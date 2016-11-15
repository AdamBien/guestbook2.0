
package com.airhacks.configuration.boundary;

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
        return System.getProperty(name, "-not-set-");
    }
}
