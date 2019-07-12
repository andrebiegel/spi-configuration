# Java Configuration through SPI

Providing Configuration is a common task. It is mostly tackled by functionality the environment already provides. But sometimes a custom solution has to be found. The repository contians a solution, which is based upon SPI. The library supports two types of configuration provider
  * JsonPConfiguration (JSON Files with JsonPointer Access)
  * PropertiesConfiguration (normal property files
  
## Usage
The test demonstrates how to use it ...

1. Write Config File 
2. Implement the Configuration type you need
```java
public class ProjectConfigPropertiesExample extends PropertiesConfiguration implements ModuleConfiguration {
	public ProjectConfigPropertiesExample() {
		super(ProjectConfigPropertiesExample.class.getClassLoader().getResourceAsStream("test.properties"));
	}
}
```
3. Provide a SPI descriptor in META-INF/services/io.github.andrebiegel.configuration.ModuleConfiguration of your module
```
io.github.andrebiegel.configuration.test.ProjectConfigPropertiesExample
```

 
