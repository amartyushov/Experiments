package io.mart;

/**
 * @author Aleksandr Martiushov
 */
public class Dimensions {

    Double height;
    Double length;
    Double width;

    public Dimensions(Double height, Double length, Double width) {
        this.height = height;
        this.length = length;
        this.width = width;
    }

    public Double getHeight() {
        return height;
    }

    public Double getLength() {
        return length;
    }

    public Double getWidth() {
        return width;
    }
}
