
package com.airhacks.configuration.control;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Stereotype;

/**
 *
 * @author airhacks.com
 */
@Stereotype
@Alternative
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Docker {
}
