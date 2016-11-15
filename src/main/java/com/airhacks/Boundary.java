
package com.airhacks;

import com.airhacks.logging.boundary.Loggable;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Stereotype;
import javax.transaction.Transactional;

/**
 *
 * @author airhacks.com
 */
@Loggable
@RequestScoped
@Transactional
@Stereotype
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Boundary {
}
