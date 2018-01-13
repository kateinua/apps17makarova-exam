package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyFunction;

// Map every element to another object using MyFunction
public class MapDecorator extends SmartArrayDecorator implements MyFunction{

    public MapDecorator(SmartArray smartArray) {
        super(smartArray);
    }

    @Override
    public Object apply(Object t) {
        return t;
    }

    @Override
    public Object[] toArray() {
        array = super.toArray();
        for (int i = 0; i < array.length; i++) {
            array[i] = apply(array[i]);
        } return array;
    }

    @Override
    public String operationDescription() {
        return "Map Decorator Array";
    }
}
