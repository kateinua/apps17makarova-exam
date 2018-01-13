package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyPredicate;

import java.util.ArrayList;
import java.util.Arrays;

// Tests every element and removes it if it doesn't satisfy MyPredicate
public class FilterDecorator extends SmartArrayDecorator {
    //Object[] array;
    MyPredicate myPredicate;

    public FilterDecorator(SmartArray smartArray, MyPredicate myPredicate) {
        super(smartArray);
        this.myPredicate = myPredicate;
    }

    @Override
    public Object[] toArray() {
        Object[] array = smartArray.toArray();
        ArrayList newArray = new ArrayList();
        newArray.addAll(Arrays.asList(array));
        for (int i = 0; i < array.length; i++) {
            if(!myPredicate.test(array[i])) newArray.remove(array[i]);
        } return newArray.toArray();
    }

    @Override
    public String operationDescription() {
        return "Filter Array";
    }
    @Override
    public int size() {
        return toArray().length;
    }
}
