
package com.airhacks.configuration.control;

/**
 *
 * @author airhacks.com
 */
@DeploymentTarget(DeploymentTarget.Environment.DOCKER)
public class EnvironmentEntrySource implements ConfigurationSource {
    @Override
    public String get(String key, String defaultValue) {
        return System.getenv().getOrDefault(key, defaultValue);
    }
}
