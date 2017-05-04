package io.mart.construction;

public class TelescopingConstructor {

    private String val1;
    private String val2;
    private String val3;

    public TelescopingConstructor(String val1, String val2, String val3) {
        this.val1 = val1;
        this.val2 = val2;
        this.val3 = val3;
    }

    public TelescopingConstructor(String val1, String val2){
        this(val1, val2, null);
    }

    public TelescopingConstructor(String val1){
        this(val1, null, null);
    }
}
