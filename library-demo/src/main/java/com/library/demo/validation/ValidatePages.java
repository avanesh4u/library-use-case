/**
 * @author Avanesh Sharma
 *
 */
package com.library.demo.validation;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;;

@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PageValidator.class)
public @interface ValidatePages {

	//String message() default "{com.dolszewski.blog.UniqueLogin.message}";
	String message() default "Pages cannot be greater than 1000 ";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
