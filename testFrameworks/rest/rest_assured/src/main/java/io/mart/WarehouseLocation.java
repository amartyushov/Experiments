package io.mart;

/**
 * @author Aleksandr Martiushov
 */
public class WarehouseLocation {

    Double longitude;
    Double latitude;

    public WarehouseLocation(Double longitude, Double latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public Double getLatitude() {
        return latitude;
    }
}
