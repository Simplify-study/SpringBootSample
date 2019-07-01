package com.simplify.sample.property;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySources({
	@PropertySource( value = "file:c:/dev/config.properties", ignoreResourceNotFound = true ),
	@PropertySource( value = "file:${user.home}/env/config.properties", ignoreResourceNotFound = true)
})
public class GlobalPropertySource {

	@Value("${spring.datasource.driverClassName}")
	private String driverClassName;
	
	@Value("${spring.datasource.url}")
	private String url;
	
	@Value("${spring.datasource.username}")
	private String username;
	
	@Value("${spring.datasource.password}")
	private String password;

	private Logger LOGGER = LoggerFactory.getLogger(GlobalPropertySource.class);
	
	@PostConstruct
	public void postGlobalPropertySource() {
		LOGGER.debug("spring.datasource.driverClassName=" + driverClassName);
		LOGGER.debug("spring.datasource.url=" + url);
		LOGGER.debug("spring.datasource.username=" + username);
		LOGGER.debug("spring.datasource.password=**********");
	}
	
	public String getDriverClassName() {
		return driverClassName;
	}

	public String getUrl() {
		return url;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

}
