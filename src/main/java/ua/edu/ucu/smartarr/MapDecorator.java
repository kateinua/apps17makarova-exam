package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyFunction;
import ua.edu.ucu.functions.MyPredicate;

// Map every element to another object using MyFunction
public class MapDecorator extends SmartArrayDecorator{

    Object[] array;
    MyFunction myFunction;

    public MapDecorator(SmartArray smartArray, MyFunction myFunction) {
        super(smartArray);
        this.myFunction = myFunction;
    }


    @Override
    public Object[] toArray() {
        array = smartArray.toArray();
        for (int i = 0; i < array.length; i++) {
            array[i] = myFunction.apply(array[i]);
        } return array;
    }

    @Override
    public String operationDescription() {
        return "Map Decorator Array";
    }
    @Override
    public int size() {
        return toArray().length;
    }
}
