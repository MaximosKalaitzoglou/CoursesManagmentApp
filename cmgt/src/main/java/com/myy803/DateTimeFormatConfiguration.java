package com.myy803;

import java.text.DateFormat;
import java.time.format.DateTimeFormatter;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.format.datetime.DateFormatterRegistrar;
import org.springframework.format.datetime.standard.DateTimeFormatterRegistrar;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class DateTimeFormatConfiguration implements WebMvcConfigurer {

	@Override
	public void addFormatters(FormatterRegistry registry) {
		DateTimeFormatterRegistrar dtRegistrar = new DateTimeFormatterRegistrar();
		DateTimeFormatter dtFormatter = DateTimeFormatter.ISO_DATE;

		dtRegistrar.setDateTimeFormatter(dtFormatter);
		dtRegistrar.registerFormatters(registry);

		DateFormatterRegistrar dRegistrar = new DateFormatterRegistrar();
		DateFormatter dFormatter = new DateFormatter("yyyy");
		dRegistrar.setFormatter(dFormatter);
		dRegistrar.registerFormatters(registry);
	}
}
