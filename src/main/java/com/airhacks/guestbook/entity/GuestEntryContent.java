/*
 */
package com.airhacks.guestbook.entity;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

/**
 *
 * @author airhacks.com
 */
@Documented
@Constraint(validatedBy = GuestEntryContentValidator.class)
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface GuestEntryContent {

    String message() default "{com.airhacks.guestbook.entity.GuestEntryContent}";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
