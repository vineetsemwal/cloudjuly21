package corejava.collectiondemo;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class ConvertToArray {


    public Integer[] convert(Collection<Integer>collection){
       Integer array[] =collection.toArray(new Integer[0]);
       return array;
    }

}
