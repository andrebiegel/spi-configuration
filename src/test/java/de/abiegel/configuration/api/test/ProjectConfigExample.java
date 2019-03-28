package de.abiegel.configuration.api.test;

import de.abiegel.configuration.api.JsonPConfiguration;
import de.abiegel.configuration.api.ModuleConfiguration;

public class ProjectConfigExample extends JsonPConfiguration implements ModuleConfiguration {

	public ProjectConfigExample() {
		super(ProjectConfigExample.class.getClassLoader().getResourceAsStream("test.json"));
	}

}