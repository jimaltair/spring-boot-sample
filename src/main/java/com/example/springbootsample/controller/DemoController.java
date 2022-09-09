package com.example.springbootsample.controller;

import com.example.springbootsample.models.Greeting;
import com.example.springbootsample.models.MyComplexType;
import com.example.springbootsample.models.UserProfile;
import com.example.springbootsample.models.Versions;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/demo", produces = {Versions.V1_0_JSON, Versions.V1_0_XML})
public class DemoController {

    @RequestMapping(value = "/get_some_resource", method = RequestMethod.GET)
    @ApiResponses(value = {@ApiResponse(responseCode = "422", description = "Have some problems")})
    @Operation(summary = "Get some resource")
    public MyComplexType getSomeResource(@Parameter(name = "Token")
                                         @RequestHeader(value="Auth-Token", required = false)
                                         String authToken,

                                         @Parameter(name = "Identificator of authorized user")
                                         @RequestHeader(value = "Profile-Id", required = false)
                                         Long userPid,

                                         @Parameter(name = "Identificator of student")
                                         @RequestParam(value = "student_id")
                                         Long studentPid,

                                         @Parameter(name = "Profile of user")
                                         @RequestHeader(value = "Profile")
                                         UserProfile user,

                                         @Parameter(name = "Array of group ids")
                                         @RequestParam(value = "groups", required = false)
                                         String groups
    ) {
        return new MyComplexType(authToken, userPid, studentPid, user, groups);
    }

    @RequestMapping(value = "/say_hello", method = RequestMethod.GET)
    @Operation(summary = "Say hello")
    public Greeting sayHello(@Parameter(name = "User name") @RequestParam final String name) {
        return new Greeting("Hello " + name + "!");
    }
}
