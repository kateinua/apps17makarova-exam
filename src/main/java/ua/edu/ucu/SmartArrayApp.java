package ua.edu.ucu;

import java.util.Arrays;
import ua.edu.ucu.functions.MyComparator;
import ua.edu.ucu.functions.MyFunction;
import ua.edu.ucu.functions.MyPredicate;
import ua.edu.ucu.smartarr.*;

public class SmartArrayApp {

    public static Integer[]
            filterPositiveIntegersSortAndMultiplyBy2(Integer[] integers) {
                
        MyPredicate pr = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                return ((Integer) t) > 0;
            }
        };

        MyComparator cmp = new MyComparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((Integer) o1) - ((Integer) o2);
            }
        };

        MyFunction func = new MyFunction() {
            @Override
            public Object apply(Object t) {
                return 2 * ((Integer) t);
            }
        };

        // Input: [-1, 2, 0, 1, -5, 3]
        SmartArray sa = new BaseArray(integers);

        sa = new FilterDecorator(sa, pr); // Result: [2, 1, 3];
        sa = new SortDecorator(sa, cmp); // Result: [1, 2, 3]
        sa = new MapDecorator(sa, func); // Result: [2, 4, 6]

        // Alternative
//        sa = new MapDecorator(
//                    new SortDecorator(
//                        new FilterDecorator(sa, pr),
//                    cmp),
//                func);
        Object[] result = sa.toArray();
        return Arrays.copyOf(result, result.length, Integer[].class);
    }

    public static String[]
            findDistinctStudentNamesFrom2ndYearWithGPAgt4AndOrderedBySurname(Student[] students) {
        SmartArray smartStudents = new BaseArray(students);

        MyComparator myComparator = new MyComparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Student student1 = (Student) o1;
                Student student2 = (Student) o2;
                return student1.getSurname().compareTo((student2.getSurname()));
            }
        };

        MyPredicate myPredicate = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                Student student = (Student) t;
                return (student.getGPA() >= 4 && student.getYear() == 2);
            }
        };

        smartStudents = new DistinctDecorator(new SortDecorator(new FilterDecorator(smartStudents, myPredicate), myComparator));
        Object[] result = smartStudents.toArray();

        String[] strings = new String[result.length];
        for(int i = 0; i < strings.length; i++) {
            strings[i] = ((Student) result[i]).getSurname() + " " + ((Student) result[i]).getName();
        }
        String[] res = new String[result.length-1];
        for (int i = 0; i < res.length; i++) {
            res[i] = strings[i];
        }

        return res;
    }
}
