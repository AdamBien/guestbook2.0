
package com.airhacks.configuration.control;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.inject.Qualifier;

/**
 *
 * @author airhacks.com
 */
@Qualifier
@Target({ElementType.FIELD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface DeploymentTarget {

    Environment value();

    enum Environment {
        DOCKER, HOST;
    }
}
