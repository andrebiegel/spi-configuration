package de.abiegel.configuration.api;

/**
 * SPI for  Module Configuration
 * @author usiabiegel
 *
 */
public interface ModuleConfiguration {
	static final String KEY_NOT_FOUND = "key not found";
	/**
	 * provides a value for a specified key
	 * @param key , configuration key
	 * @return configured value if is existent
	 */
	String get( String key);
	
	void init();
}
