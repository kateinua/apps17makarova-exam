package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyComparator;

import java.util.Arrays;

// Sorts elements using MyComparator to compare them
public class SortDecorator extends SmartArrayDecorator {

    MyComparator myComparator;

    public SortDecorator(SmartArray smartArray, MyComparator myComparator) {
        super(smartArray);
        this.myComparator = myComparator;
    }
    @Override
    public Object[] toArray() {
        Object[] array = smartArray.toArray();
        Arrays.sort(array, myComparator);
        return array;
    }

    @Override
    public String operationDescription() {
        return "Sort Decorator Array";
    }
    @Override
    public int size() {
        return toArray().length;
    }
}
