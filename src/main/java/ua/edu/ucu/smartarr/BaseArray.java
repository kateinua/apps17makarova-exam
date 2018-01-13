package ua.edu.ucu.smartarr;

import java.util.ArrayList;
import java.util.Arrays;

// Base array for decorators
public class BaseArray implements SmartArray {
    protected Object[] array;
    SmartArray smartArray;

    /*public BaseArray() {
        array = new Object[100];
    }*/

    BaseArray(SmartArray smartArray) {
        this.smartArray = smartArray;
    }

    @Override
    public Object[] toArray() {
        ArrayList arr = new ArrayList();
        arr.addAll(Arrays.asList(smartArray));
        return arr.toArray();
    }

    @Override
    public String operationDescription() {
        return "Base Array";
    }

    @Override
    public int size() {
        return array.length;
    }
}
