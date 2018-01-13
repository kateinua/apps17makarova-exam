package ua.edu.ucu.smartarr;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;

abstract class SmartArrayDecorator implements SmartArray {

    protected SmartArray smartArray;

    public SmartArrayDecorator(SmartArray smartArray) {
        this.smartArray = smartArray;
    }

    public Object[] toArray() {
        return smartArray.toArray();
    }

    public String operationDescription() {
        return smartArray.operationDescription();
    }

    public int size() {
        return smartArray.size();
    }
}
