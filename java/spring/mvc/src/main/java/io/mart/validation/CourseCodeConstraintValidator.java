package io.mart.validation;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by Aleksandr Martiushov.
 */
public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

    private String[] courseCodePrefix;

    @Override
    public void initialize(CourseCode constraintAnnotation) {
        courseCodePrefix = constraintAnnotation.values();
    }

    @Override
    public boolean isValid(String theCode, ConstraintValidatorContext context) {

        boolean result = false;

        if (theCode !=null) {
            for (String prefix : courseCodePrefix) {
                result = theCode.startsWith(prefix);
                if (result) break;
            }
        } else {
            result = true;
        }
        return result;
    }
}
