package com.delonborges.dslearn.components;

import com.delonborges.dslearn.entities.User;
import com.delonborges.dslearn.repositories.UserRepository;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class JwtTokenEnhancer implements TokenEnhancer {

    private final UserRepository userRepository;

    public JwtTokenEnhancer(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken oAuth2AccessToken, OAuth2Authentication oAuth2Authentication) {
        User user = userRepository.findByEmail(oAuth2Authentication.getName());

        Map<String, Object> map = new HashMap<>();
        map.put("userId", user.getId());

        DefaultOAuth2AccessToken defaultOAuth2AccessToken = (DefaultOAuth2AccessToken) oAuth2AccessToken;
        defaultOAuth2AccessToken.setAdditionalInformation(map);

        return oAuth2AccessToken;
    }
}
