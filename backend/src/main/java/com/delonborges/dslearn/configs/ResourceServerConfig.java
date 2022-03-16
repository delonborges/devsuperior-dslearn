package com.delonborges.dslearn.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import java.util.Arrays;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    private static final String[] PUBLIC = {"/oauth/token", "/h2-console/**"};

    private final Environment environment;
    private final JwtTokenStore tokenStore;

    public ResourceServerConfig(Environment environment, JwtTokenStore tokenStore) {
        this.environment = environment;
        this.tokenStore = tokenStore;
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.tokenStore(tokenStore);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        if (Arrays.asList(environment.getActiveProfiles())
                  .contains("test")) {
            http.headers()
                .frameOptions()
                .disable();
        }

        http.authorizeRequests()
            .antMatchers(PUBLIC)
            .permitAll()
            .anyRequest()
            .authenticated();
    }
}
