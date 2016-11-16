
package com.airhacks.configuration.control;

/**
 *
 * @author airhacks.com
 */
@FunctionalInterface
public interface ConfigurationSource {

    String get(String key, String defaultValue);
}
