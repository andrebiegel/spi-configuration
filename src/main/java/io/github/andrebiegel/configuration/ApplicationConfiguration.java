package io.github.andrebiegel.configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

import javax.annotation.PostConstruct;

public class ApplicationConfiguration implements ModuleConfiguration {

	private List<ModuleConfiguration> moduleConfigurations = new ArrayList<>();

	/**
	 * Reading SPI instances
	 */
	@PostConstruct
	public void init() {
		ServiceLoader.load(ModuleConfiguration.class).forEach(this::storeConfiguration);
	}

	public void storeConfiguration(ModuleConfiguration provider) {
		provider.init();
		this.moduleConfigurations.add(provider);
	}

	@Override
	public String get(String key) {

		return System.getenv().getOrDefault(key, System.getProperty(key, appConfigfor(key)));

	}

	public String appConfigfor(String key) {
		return moduleConfigurations.stream().map(provider -> provider.get(key))
				.filter(it -> !ModuleConfiguration.KEY_NOT_FOUND.equals(it)).findFirst()
				.orElse(ModuleConfiguration.KEY_NOT_FOUND);
	}
}
