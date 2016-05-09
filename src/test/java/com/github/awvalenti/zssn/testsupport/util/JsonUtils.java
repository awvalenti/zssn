package com.github.awvalenti.zssn.testsupport.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonValue;

public class JsonUtils {

	public static JsonValue readAsJsonValue(String filename) {
		InputStream stream = JsonUtils.class
				.getResourceAsStream("/com/github/awvalenti/zssn/resource/" + filename);

		if (stream == null) throw new RuntimeException("Resource '" + filename + "' not found");

		try (InputStreamReader reader = new InputStreamReader(stream, Charset.forName("US-ASCII"))) {
			return Json.parse(reader);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static String readAsString(String filename) {
		return readAsJsonValue(filename).toString();
	}

	public static JsonValue parse(String string) {
		return Json.parse(string);
	}

}
