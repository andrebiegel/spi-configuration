package de.abiegel.configuration.api.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import de.abiegel.configuration.api.ApplicationConfiguration;

public class ApplicationConfigurationTest {

	@Test
	public void test() {
		ApplicationConfiguration config  =  new ApplicationConfiguration();
		config.init();
		Assertions.assertEquals("New York Bulls", config.get("/quiz/sport/q1/options/0"));
	}

}
