package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyComparator;

// Sorts elements using MyComparator to compare them
public class SortDecorator extends SmartArrayDecorator implements MyComparator {

    public SortDecorator(SmartArray smartArray) {
        super(smartArray);
    }

    @Override
    public int compare(Object o1, Object o2) {
        return 0;
    }
}
