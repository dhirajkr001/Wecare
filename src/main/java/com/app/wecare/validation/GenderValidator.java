package com.app.wecare.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class GenderValidator implements ConstraintValidator<GenderConstraint, String> {
    private static final String MALE = "male";
    private static final String FEMALE = "female";

    @Override
    public void initialize(GenderConstraint constraintAnnotation) {

    }
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return (MALE.equals(value) || FEMALE.equals(value));
    }
}
