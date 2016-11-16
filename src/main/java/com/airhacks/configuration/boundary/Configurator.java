
package com.airhacks.configuration.boundary;

import com.airhacks.configuration.control.ConfigurationSource;
import com.airhacks.logging.control.GLogger;
import java.util.Optional;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Inject;

/**
 *
 * @author airhacks.com
 */
public class Configurator {

    @Inject
    ConfigurationSource source;

    @Inject
    GLogger LOG;

    @Produces
    public String expose(InjectionPoint ip) {
        LOG.log("Using: " + source.getClass().getName());
        String name = ip.getMember().getName();
        DefaultValue defaultConfig = ip.getAnnotated().getAnnotation(DefaultValue.class);
        Optional<String> optionalDefault = Optional.
                ofNullable(defaultConfig).
                map(a -> a.value());
        ConfigurationKey configurationKey = ip.getAnnotated().getAnnotation(ConfigurationKey.class);
        Optional<String> optionalKey = Optional.
                ofNullable(configurationKey).
                map(c -> c.value());
        return this.source.get(optionalKey.orElse(name), optionalDefault.orElse("-not-set-"));
    }
}
