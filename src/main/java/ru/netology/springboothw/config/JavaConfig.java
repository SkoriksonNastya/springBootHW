package ru.netology.springboothw.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import ru.netology.springboothw.profiles.DevProfile;
import ru.netology.springboothw.profiles.ProductionProfile;
import ru.netology.springboothw.profiles.SystemProfile;

@Configuration
public class JavaConfig {
    @Bean
    @Primary
    @ConditionalOnProperty(prefix = "netology", name = "profile.dev", havingValue = "true")
    public SystemProfile devProfile() {
        return new DevProfile();
    }

    @Bean
    @ConditionalOnProperty(prefix = "netology", name = "profile.dev", havingValue = "false")
    public SystemProfile prodProfile() {
        return new ProductionProfile();
    }
}
