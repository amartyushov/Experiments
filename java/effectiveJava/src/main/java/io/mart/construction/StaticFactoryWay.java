package io.mart.construction;

import java.util.ArrayList;
import java.util.List;

public class StaticFactoryWay {

    private String val1;
    private String val2;
    private String val3;
    private static final List<Integer> objCache = new ArrayList<Integer>();

    public void setVal1(String val1) {
        this.val1 = val1;
    }

    public void setVal2(String val2) {
        this.val2 = val2;
    }

    public void setVal3(String val3) {
        this.val3 = val3;
    }

    private StaticFactoryWay(){
        populateObjectCache();
    }

    // ugly but obvious demonstration that object have not to be constructed in factory method
    // it may be returned from cache
    private void populateObjectCache(){
        objCache.add(10);
    }

    private static final StaticFactoryWay instance = new StaticFactoryWay();

    // Pros: method may have any name
    public static StaticFactoryWay createObj(){
        return instance;
    }

    // Pros: methods may have same number and sequence of params
    public static StaticFactoryWay createObj_withParams(String va1, String va2, String va3){
        StaticFactoryWay inst = new StaticFactoryWay();
        inst.setVal1(va1);
        inst.setVal2(va2);
        inst.setVal3(va3);
        return inst;
    }

    // Pros: methods may have same number and sequence of params
    // Cons: name of method does not say what is going inside
    public static StaticFactoryWay createObj_withSameParams(String va1, String va2, String va3){
        StaticFactoryWay inst = new StaticFactoryWay();
        inst.setVal1(va1);
        inst.setVal2(va2.substring(1));
        inst.setVal3(va3.substring(1));
        return inst;
    }

    // factory returns cached object
    public static Integer createObj_fromCache(){
        return objCache.get(0);
    }

}
