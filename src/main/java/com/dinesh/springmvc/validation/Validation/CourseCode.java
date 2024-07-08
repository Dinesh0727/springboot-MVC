package com.dinesh.springmvc.validation.Validation;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RUNTIME)
public @interface CourseCode {
    public String value() default "LUV";

    public String message() default "Starts with LUV";

    public Class<?>[] groups() default {};

    public Class<? extends Payload>[] payload() default {}; 
}
