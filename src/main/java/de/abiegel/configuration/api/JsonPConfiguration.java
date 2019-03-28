/**
 * 
 */
package de.abiegel.configuration.api;

import java.io.InputStream;

import javax.json.Json;
import javax.json.JsonNumber;
import javax.json.JsonObject;
import javax.json.JsonPointer;
import javax.json.JsonString;
import javax.json.JsonValue;

/**
 * JSON Configuration with RFC 6901 Syntax
 * @author usiabiegel
 *
 */
public abstract class JsonPConfiguration implements ModuleConfiguration {
	
	private InputStream inputStream;
	private JsonObject configurations;

	/**
	 * @param inputStream, stream of the Json File
	 */
	public JsonPConfiguration(InputStream inputStream) {
		super();
		this.inputStream = inputStream;
	}

	public void init() {
		this.configurations = Json.createReader(inputStream).readObject();
	}

	@Override
	public String get(String key) {
		JsonPointer pointer = Json.createPointer(key);
		
		if (pointer.containsValue(configurations)) {
			return convert(pointer.getValue(configurations));
		}
		return KEY_NOT_FOUND;
	}

	private String convert(JsonValue value) {
		switch (value.getValueType()) {
		case STRING:
			return ((JsonString)value).getString();
		case NUMBER:
			return ((JsonNumber)value).numberValue().toString();
		case FALSE:
			return Boolean.FALSE.toString();
		case TRUE:
			return Boolean.TRUE.toString();
		default:
			throw new UnsupportedOperationException();
		}
		
	}	
}
