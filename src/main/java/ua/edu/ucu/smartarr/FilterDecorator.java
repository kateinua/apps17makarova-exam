package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyPredicate;

// Tests every element and removes it if it doesn't satisfy MyPredicate
public class FilterDecorator extends SmartArrayDecorator implements MyPredicate {

    public FilterDecorator(SmartArray smartArray) {
        super(smartArray);
    }

    @Override
    public boolean test(Object t) {
        return true;
    }

    @Override
    public Object[] toArray() {
        array = super.toArray();
        for (int i = 0; i < array.length; i++) {
            if(!test(array[i])) array.remove(array[i]);
        } return array;
    }

    @Override
    public String operationDescription() {
        return "Filter Array";
    }
}
