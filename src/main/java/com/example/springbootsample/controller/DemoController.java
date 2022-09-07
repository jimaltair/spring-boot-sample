package com.example.springbootsample.controller;

import com.example.springbootsample.models.Greeting;
import com.example.springbootsample.models.MyComplexType;
import com.example.springbootsample.models.UserProfile;
import com.example.springbootsample.models.Versions;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api("demo")
@RestController
@RequestMapping(value = "/demo", produces = {Versions.V1_0_JSON, Versions.V1_0_XML})
public class DemoController {

    @RequestMapping(value = "/get_some_resource", method = RequestMethod.GET)
    @ApiResponses(value = {@ApiResponse(code = 422, message = "Have some problems")})
    @ApiOperation("Get some resource")
    public MyComplexType getSomeResource(@ApiParam("Токен")
                                         @RequestHeader(value="Auth-Token", required = false)
                                         String authToken,

                                         @ApiParam("Identificator of authorized user")
                                         @RequestHeader(value = "Profile-Id", required = false)
                                         Long userPid,

                                         @ApiParam("Identificator of student")
                                         @RequestParam(value = "student_id")
                                         Long studentPid,

                                         @ApiParam("Profile of user")
                                         @RequestHeader(value = "Profile", required = false)
                                         UserProfile user,

                                         @ApiParam("Array of group ids")
                                         @RequestParam(value = "groups", required = false)
                                         String groups
    ) {
        return new MyComplexType(authToken, userPid, studentPid, user, groups);
    }

    @RequestMapping(value = "/say_hello", method = RequestMethod.GET)
    @ApiOperation("Say hello")
    public Greeting sayHello(@RequestParam final String name) {
        return new Greeting("Hello " + name + "!");
    }
}
