
package com.airhacks.configuration.boundary;

import java.util.Optional;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

/**
 *
 * @author airhacks.com
 */
public class Configurator {

    @Produces
    public String expose(InjectionPoint ip) {
        String name = ip.getMember().getName();
        DefaultValue defaultConfig = ip.getAnnotated().getAnnotation(DefaultValue.class);
        Optional<String> optionalDefault = Optional.
                ofNullable(defaultConfig).
                map(a -> a.value());
        return System.getProperty(name, optionalDefault.orElse("-not-set-"));
    }
}
