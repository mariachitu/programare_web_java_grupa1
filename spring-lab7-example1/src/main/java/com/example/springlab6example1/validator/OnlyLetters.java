package com.example.springlab6example1.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = OnlyLettersValidator.class)
@Documented
public @interface OnlyLetters {

    String message() default "Only letters required";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
