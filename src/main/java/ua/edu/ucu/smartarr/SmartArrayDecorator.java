package ua.edu.ucu.smartarr;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;

abstract class SmartArrayDecorator extends BaseArray {

    protected SmartArray smartArray;

    public SmartArrayDecorator(SmartArray smartArray) {
        super(smartArray);
        this.smartArray = smartArray;
    }
}
