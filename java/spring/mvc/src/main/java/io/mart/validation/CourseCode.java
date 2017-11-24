package io.mart.validation;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Aleksandr Martiushov.
 */
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
public @interface CourseCode {

    public String[] values() default {"LUV"};
    public String message() default "must start with LUV";

    public Class<?>[] groups() default {};
    public Class<? extends Payload>[] payload() default {};

}
