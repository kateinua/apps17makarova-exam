package ua.edu.ucu.smartarr;

import java.util.ArrayList;
import java.util.Arrays;

// Remove duplicates from SmartArray. Use method equals() to compare objects
public class DistinctDecorator extends SmartArrayDecorator {

    Object[] array;

    public DistinctDecorator(SmartArray smartArray) {
        super(smartArray);
    }

    @Override
    public Object[] toArray() {
        array = super.toArray();
        ArrayList newArray = new ArrayList();
        newArray.addAll(Arrays.asList(array));
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (i != j) {
                    if (array[i].equals(array[j])) {
                        newArray.remove(array[i]);
                    }
                }
            }
        } return newArray.toArray();
    }

    @Override
    public String operationDescription() {
        return "Distinct Array";
    }

    @Override
    public int size() {
        return array.length;
    }
}
