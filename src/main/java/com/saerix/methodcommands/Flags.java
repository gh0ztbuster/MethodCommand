package com.saerix.methodcommands;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Flags {
	String[] description() default {};
	/**
	 * @return
	 */
	String[] identifier();
}
