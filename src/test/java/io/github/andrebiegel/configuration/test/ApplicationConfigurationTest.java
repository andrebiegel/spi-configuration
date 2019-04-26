package io.github.andrebiegel.configuration.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.github.andrebiegel.configuration.ApplicationConfiguration;

public class ApplicationConfigurationTest {

	@Test
	public void test() {
		ApplicationConfiguration config  =  new ApplicationConfiguration();
		config.init();
		Assertions.assertEquals("New York Bulls", config.get("/quiz/sport/q1/options/0"));
	}

}
