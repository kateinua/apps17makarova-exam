package ua.edu.ucu.smartarr;

import java.util.ArrayList;
import java.util.Arrays;

// Base array for decorators
public class BaseArray implements SmartArray {
    protected Object[] baseArray;

    /*public BaseArray() {
        array = new Object[100];
    }*/

    public BaseArray(Object[] baseArray) {
        this.baseArray = baseArray;
    }

    @Override
    public Object[] toArray() {
        return baseArray;
    }

    @Override
    public String operationDescription() {
        return "Base Array";
    }

    @Override
    public int size() {
        return baseArray.length;
    }
}
