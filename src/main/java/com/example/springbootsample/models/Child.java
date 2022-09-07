package com.example.springbootsample.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Child {
    @JsonProperty("profile_id")
    private Long profileId;
    @JsonProperty("school_id")
    private Integer schoolId;
    @JsonProperty("user_id")
    private Integer userId;
    @JsonProperty("class_unit_id")
    private Integer classUnitId;
}
