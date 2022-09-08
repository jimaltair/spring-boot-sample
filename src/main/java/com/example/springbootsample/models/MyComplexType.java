package com.example.springbootsample.models;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class MyComplexType {

    @ApiModelProperty(value = "JWT Token")
    private String authToken;
    @ApiModelProperty(value = "User profile ID")
    private Long userPid;
    @ApiModelProperty(value = "Student profile ID")
    private Long studentPid;
    @ApiModelProperty(value = "Authenticated user profile")
    private UserProfile user;
    @ApiModelProperty(value = "Array of groups ids")
    private String groups;
}

