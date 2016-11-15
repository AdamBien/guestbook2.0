
package com.airhacks.logging.boundary;

import com.airhacks.logging.control.GLogger;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

/**
 *
 * @author airhacks.com
 */
@Loggable
@Interceptor
public class LoggingInterceptor {

    @Inject
    private GLogger LOG;

    @AroundInvoke
    public Object log(InvocationContext ic) throws Exception {
        LOG.log("Method invoked: " + ic.getMethod());
        return ic.proceed();
    }
}
