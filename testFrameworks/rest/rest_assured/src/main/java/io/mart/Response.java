package io.mart;

import java.util.List;

/**
 * @author Aleksandr Martiushov
 */
public class Response {

    Integer id;
    String name;
    Double price;
    List<String> tags;
    Dimensions dimensions;
    WarehouseLocation warehouseLocation;


    public Response(Integer id, String name, Double price, List<String> tags) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.tags = tags;
    }

    public Response(Integer id, String name, Double price, List<String> tags, Dimensions dimensions, WarehouseLocation warehouseLocation) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.tags = tags;
        this.dimensions = dimensions;
        this.warehouseLocation = warehouseLocation;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public List<String> getTags() {
        return tags;
    }

    public Dimensions getDimensions() {
        return dimensions;
    }

    public WarehouseLocation getWarehouseLocation() {
        return warehouseLocation;
    }
}
