package com.example.springbootsample.service;

import com.example.springbootsample.models.UserProfile;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.io.IOException;
import java.util.TimeZone;

@Service
public class StringToUserConverter implements Converter<String, UserProfile> {

    private ObjectMapper mapper = new ObjectMapper();

    public StringToUserConverter() {
        mapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
        mapper.setTimeZone(TimeZone.getDefault());
        mapper.configure(MapperFeature.DEFAULT_VIEW_INCLUSION, false);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    @Override
    public UserProfile convert(String source) {
        try {
            UserProfile userProfile = mapper.readValue(source, UserProfile.class);
            setProfileIdIfEmpty(userProfile);
            return userProfile;
        } catch (IOException ex) {
            throw new RestClientException("Unable to convert user. Reason: " + ex.getMessage(), ex);
        }
    }

    private void setProfileIdIfEmpty(UserProfile userProfile) {
        if (userProfile.getUserProfileId() == null) {
            RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
            if (requestAttributes instanceof ServletRequestAttributes) {
                String profileId = ((ServletRequestAttributes) requestAttributes).getRequest().getHeader("Profile-Id");
                userProfile.setUserProfileId(Integer.parseInt(profileId));
            }
        }
    }
}
