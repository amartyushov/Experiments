package io.mart.validation;

import javax.validation.constraints.*;

/**
 * Created by Aleksandr Martiushov.
 */
public class Customer {

    private String firstName;

    @NotNull(message = "is required")
    @Size(min = 1, message = "min length is 1")
    private String lastName;

    @Max(value = 10, message = "must be <=10")
    @Min(value = 0, message = "must be >= 0")
    @NotNull(message = "is required")
    private Integer freePasses;

    @Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "5 digits/chars")
    private String postalCode;

    @CourseCode(values = {"TOPS", "LUV"}, message = "LUV and TOPS")
    private String courseCode;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(Integer freePasses) {
        this.freePasses = freePasses;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
}
