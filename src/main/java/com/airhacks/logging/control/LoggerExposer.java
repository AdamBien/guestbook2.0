
package com.airhacks.logging.control;

import java.util.logging.Logger;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

/**
 *
 * @author airhacks.com
 */
public class LoggerExposer {
    @Produces
    public GLogger expose(InjectionPoint ip) {
        Class<?> clazz = ip.getMember().getDeclaringClass();
        return Logger.getLogger(clazz.getName())::info;
    }
}
