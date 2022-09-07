package com.example.springbootsample.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum UserProfileRoleType {
    URS_MANAGE_ACCESS,
    ARGUS,
    URS_SUPPORT,
    URS_AUTHOR,
    URS_INFRASTRUCTURE_ADMIN,
    URS_ADMIN,
    TEACHER,
    PRINCIPAL,
    STAFF,
    DEPUTY,
    SCHOOL_ADMIN,
    EDUCATOR,
    SCHOOL_ADMIN_READ_ONLY,
    METHODOLOGIST,
    PASSPORT_PRINTER,
    AE_EDUCATOR,
    PSYCHOLOGIST,
    JUNIOR_EDUCATOR,
    RESPONSIBLE_EXTRACURRICULAR_ACTIVITIES;

    UserProfileRoleType() {
    }

    @JsonValue
    public String getJson() {
        return this.toString().toLowerCase();
    }

    @JsonCreator
    public static UserProfileRoleType fromJson(String id) {
        return Enum.valueOf(UserProfileRoleType.class, id.toUpperCase());
    }
}
