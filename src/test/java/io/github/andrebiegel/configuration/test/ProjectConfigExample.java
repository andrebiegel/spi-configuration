package io.github.andrebiegel.configuration.test;

import io.github.andrebiegel.configuration.JsonPConfiguration;
import io.github.andrebiegel.configuration.ModuleConfiguration;

public class ProjectConfigExample extends JsonPConfiguration implements ModuleConfiguration {

	public ProjectConfigExample() {
		super(ProjectConfigExample.class.getClassLoader().getResourceAsStream("test.json"));
	}

}