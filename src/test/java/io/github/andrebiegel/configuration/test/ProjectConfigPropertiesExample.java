package io.github.andrebiegel.configuration.test;

import io.github.andrebiegel.configuration.ModuleConfiguration;
import io.github.andrebiegel.configuration.PropertiesConfiguration;

public class ProjectConfigPropertiesExample extends PropertiesConfiguration implements ModuleConfiguration {

	public ProjectConfigPropertiesExample() {
		super(ProjectConfigPropertiesExample.class.getClassLoader().getResourceAsStream("test.properties"));
	}

}