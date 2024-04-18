package com.cwr.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties("key-generate")
public class KeyGenerationServiceProperties {
    private String algorithm;
    private Integer keySize;
}
