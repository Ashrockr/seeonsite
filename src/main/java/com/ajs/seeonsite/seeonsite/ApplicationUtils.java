package com.ajs.seeonsite.seeonsite;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Value;

public class ApplicationUtils {

	@Value("${app.url}")
	public static String APP_URL = "http://localhost:8080";

	public static List<String> EXCLUDED_URL_PATTERN = Arrays.asList("/",
			"/register", "/contact", "/favicon.ico", "/login");

	private static final String IMAGE_PATTERN = "([^\\s]+(\\.(?i)(jpg|png|gif|bmp))$)";

	private static Pattern pattern = Pattern.compile(IMAGE_PATTERN);

	private static Matcher matcher;

	/**
	 * Validate image with regular expression
	 * 
	 * @param image
	 *            image for validation
	 * @return true valid image, false invalid image
	 */
	public static boolean isValidImage(final String image) {

		matcher = pattern.matcher(image);
		return matcher.matches();

	}

}
