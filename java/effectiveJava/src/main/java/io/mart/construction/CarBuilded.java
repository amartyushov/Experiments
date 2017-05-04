package io.mart.construction;

public class CarBuilded {

    private Integer spedLimit;
    private String brand;
    private Integer year;

    public CarBuilded(Builder builder) {
        spedLimit = builder.spedLimit;
        brand = builder.brand;
        year = builder.year;
    }

    public static class Builder {

        private Integer spedLimit = 0;
        private String brand;
        private Integer year = 0;

        public Builder(String brand) {
            this.brand = brand;
        }

        public Builder setSpedLimit(Integer spedLimit) {
            this.spedLimit = spedLimit;
            return this;
        }

        public Builder setYear(Integer year) {
            this.year = year;
            return this;
        }

        // finally builder build wrapping object
        public CarBuilded build() {
            return new CarBuilded(this);
        }
    }
}
