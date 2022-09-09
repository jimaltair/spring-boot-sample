package com.example.springbootsample.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserProfile implements Serializable {

    private static final long serialVersionUID = 6804950387640328211L;

    @Schema(description = "ID")
    private Integer id;
    @Schema(description = "Original user ID")
    private Integer originalUserId;
    @Schema(description = "User profile ID")
    private Integer userProfileId;
    @Schema(description = "School ID")
    private Integer schoolId;
    @Schema(description = "User profile type")
    private UserProfileType type;
    @Schema(description = "List of roles")
    private List<UserProfileRoleType> roles = new ArrayList<>();
    @Schema(description = "List of children")
    private List<Child> children = new ArrayList<>();
}

