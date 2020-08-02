/**
 * @author Avanesh Sharma
 *
 */
package com.library.demo.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PageValidator implements ConstraintValidator<ValidatePages, Integer> {

	@Override
	public boolean isValid(Integer pages, ConstraintValidatorContext context) {
		return pages < 1000;
	}

}
