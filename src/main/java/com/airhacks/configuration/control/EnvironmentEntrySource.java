
package com.airhacks.configuration.control;

/**
 *
 * @author airhacks.com
 */
public class EnvironmentEntrySource implements ConfigurationSource {

    @Override
    public String get(String key, String defaultValue) {
        return System.getenv().getOrDefault(key, defaultValue);
    }

}
