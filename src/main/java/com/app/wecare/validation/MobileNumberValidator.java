package com.app.wecare.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MobileNumberValidator implements ConstraintValidator<MobileNumberConstraint, Long> {


    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        int digitsCount = (int)Math.floor(Math.log10(value) + 1);
        long firstDigit = (Long)( value / (int) (Math.pow(10, digitsCount -1)));
        return (firstDigit == 6 || firstDigit ==7 || firstDigit == 8 || firstDigit == 9) &&
                (digitsCount == 10);
    }
}
