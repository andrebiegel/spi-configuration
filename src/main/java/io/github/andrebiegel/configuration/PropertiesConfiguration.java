package io.github.andrebiegel.configuration;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesConfiguration implements ModuleConfiguration {

	private InputStream inputStream;
	private Properties configurations = new Properties();

	public PropertiesConfiguration(InputStream inStream) {
		super();
		this.inputStream = inStream;
	}

	@Override
	public String get(String key) {
		return configurations.getProperty(key, KEY_NOT_FOUND);
	}

	/**
	 * Initialized the properties
	 * @throws IllegalStateException , if inner {@link IOException} occurs 
	 */
	@Override
	public void init() {
		try {
			configurations.load(inputStream);
		} catch (IOException ioe) {
			throw new IllegalStateException(ioe);
		}
	}

}
