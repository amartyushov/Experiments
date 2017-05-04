package io.mart.construction;

public class EvaluationClass {
    public static void main(String[] args) {

        CarBuilded car = new CarBuilded.Builder("Ferrari").build();


        CarBuilded car1 = new CarBuilded.Builder("Lada").setSpedLimit(100).build();


        CarBuilded car2 = new CarBuilded.Builder("Kia").
                setSpedLimit(200).
                setYear(1981).build();
    }
}
