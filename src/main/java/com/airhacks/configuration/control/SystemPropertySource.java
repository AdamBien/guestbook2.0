
package com.airhacks.configuration.control;

/**
 *
 * @author airhacks.com
 */
@DeploymentTarget(DeploymentTarget.Environment.HOST)
public class SystemPropertySource implements ConfigurationSource {
    @Override
    public String get(String key, String defaultValue) {
        return System.getProperty(key, defaultValue);
    }
}
