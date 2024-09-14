package com.dnd5eapi_integration.property;

import lombok.Getter;
//import lombok.Value;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
public class ApplicationProperties {
    @Value("${data.services.dnd5eApiUrl}")
    private String Dnd5eApiUrl;

}
