
package com.airhacks.logging.control;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

/**
 *
 * @author airhacks.com
 */
public class LoggingInterceptor {

    private static final Logger LOG = Logger.getLogger(LoggingInterceptor.class.getName());

    @AroundInvoke
    public Object log(InvocationContext ic) throws Exception {
        LOG.log(Level.INFO, "Method invoked: {0}", ic.getMethod());
        return ic.proceed();
    }


}
