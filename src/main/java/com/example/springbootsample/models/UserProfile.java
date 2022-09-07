package com.example.springbootsample.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserProfile implements Serializable {
    private static final long serialVersionUID = 6804950387640328211L;

    @ApiModelProperty(value = "ID")
    private Integer id;
    @ApiModelProperty(value = "Original user ID")
    private Integer originalUserId;
    @ApiModelProperty(value = "User profile id")
    private Integer userProfileId;
    @ApiModelProperty(value = "School id")
    private Integer schoolId;
    @ApiModelProperty(value = "User profile type")
    private UserProfileType type;
    @ApiModelProperty(value = "List of roles")
    private List<UserProfileRoleType> roles = new ArrayList<>();
    @ApiModelProperty(value = "List of childs")
    private List<Child> children = new ArrayList<>();
}

