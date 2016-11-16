/*
 */
package com.airhacks.guestbook.entity;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author airhacks.com
 */
public class GuestEntryContentValidator implements ConstraintValidator<GuestEntryContent, GuestEntry> {

    @Override
    public void initialize(GuestEntryContent annotation) {
    }

    @Override
    public boolean isValid(GuestEntry entry, ConstraintValidatorContext context) {
        return entry.isValid();
    }
}
