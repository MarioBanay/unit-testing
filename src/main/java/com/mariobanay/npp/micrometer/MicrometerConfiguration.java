package com.mariobanay.npp.micrometer;

import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.micrometer.core.instrument.MeterRegistry;

@Configuration
public class MicrometerConfiguration {
	
	@SuppressWarnings("rawtypes")
	@Bean
	MeterRegistryCustomizer meterRegistryCustomizer(MeterRegistry meterRegistry) {
		return meterRegistry1 -> {
			meterRegistry.config()
			.commonTags("application", "micrometer");
		};
	}
}
