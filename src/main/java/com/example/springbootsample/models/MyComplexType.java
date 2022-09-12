package com.example.springbootsample.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Schema(name = "Answer from demo-controller") // replacing for @ApiModel
public class MyComplexType {

    @Schema(description = "JWT Token")
    @JsonProperty("some_other_naming")
    private String authToken;
    @Schema(description = "User profile ID")
    private Long userPid;
    @Schema(description = "Student profile ID")
    private Long studentPid;
    @Schema(description = "Authenticated user profile")
    private UserProfile user;
    @Schema(description = "Array of groups ids")
    private String groups;
}

