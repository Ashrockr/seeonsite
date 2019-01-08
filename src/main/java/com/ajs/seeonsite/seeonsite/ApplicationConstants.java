package com.ajs.seeonsite.seeonsite;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;

public interface ApplicationConstants {

	@Value("${app.url}")
	public static String APP_URL = "http://localhost:8080";

	public static List<String> EXCLUDED_URL_PATTERN = Arrays.asList("/",
			"/register", "/contact", "/favicon.ico");

}
