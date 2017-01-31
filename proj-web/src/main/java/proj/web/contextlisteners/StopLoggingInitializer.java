package proj.web.contextlisteners;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StopLoggingInitializer implements ServletContextListener {
    private static final Logger LOG = LoggerFactory.getLogger(StopLoggingInitializer.class);

    @Override
    public void contextDestroyed(final ServletContextEvent sce) {
        LOG.debug("Destroying SLF4J Logger Context. No more logs will be printed.");
        try {
            final ILoggerFactory o = LoggerFactory.getILoggerFactory();
            // use reflection so we don't have a hard dependency on the logger implementation
            final Method m = o.getClass().getMethod("stop");
            m.invoke(o);
        } catch (final RuntimeException | NoSuchMethodException | IllegalAccessException
                       | InvocationTargetException ignore) {
        }
    }

    @Override
    public void contextInitialized(final ServletContextEvent sce) {
    }

}
