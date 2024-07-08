package com.dinesh.springmvc.validation.calidation_demo.model;

import com.dinesh.springmvc.validation.Validation.CourseCode;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class Customer {
    private String firstName;

    @NotNull(message="is required")
    @Size(min=1, message = "is required")
    private String lastName;

    @NotNull(message="is required")
    @Min(value=0, message="must be greater than or equal to zero")
    @Max(value=10, message = "must be less than or equal to ten")
    private Integer noOfPasses;

    @Pattern(regexp="^[a-zA-Z0-9]{5}", message="should have 5 digits or characters")
    private String postalCode;

    @CourseCode
    private String courseCode;

    public Customer() {
    }

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

    public Integer getNoOfPasses() {
        return noOfPasses;
    }

    public void setNoOfPasses(Integer noOfPasses) {
        this.noOfPasses = noOfPasses;
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
