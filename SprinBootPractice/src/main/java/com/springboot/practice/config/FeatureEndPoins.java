package com.springboot.practice.config;

import java.awt.Taskbar.Feature;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Endpoint(id = "features")
public class FeatureEndPoins {
	
	private final Map<String, Feature> featureMap = new ConcurrentHashMap<>();
	
	public FeatureEndPoins() {
		featureMap.put("Department", new Feature(true));
		featureMap.put("User", new Feature(true));
		featureMap.put("Authentication", new Feature(true));
	}
	
	@ReadOperation
	public Map<String,Feature> features() {
		return featureMap;
	}
	
	@ReadOperation
	public Feature feature(@Selector String featureName) {
		return featureMap.get(featureName);
	}
	
	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	private static class Feature {
		private boolean isEnables;
	}

}