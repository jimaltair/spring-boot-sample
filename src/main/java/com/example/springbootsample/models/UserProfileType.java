package com.example.springbootsample.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum UserProfileType {
    URS_MANAGE_ACCESS("UrsManageAccessProfile"),
    AUTHOR("AuthorProfile"),
    ARGUS("ArgusProfile"),
    URS_ADMIN("UrsAdminProfile"),
    CURATOR("CuratorProfile"),
    PARENT("ParentProfile"),
    STUDENT("StudentProfile"),
    MATERIAL_VIEWER("MaterialViewerProfile"),
    MEDAL_COMMISSION("MedalCommissionProfile"),
    MRKO("MrkoProfile"),
    TEACHER("TeacherProfile"),
    JURY("JuryProfile"),
    PRINCIPAL("PrincipalProfile"),
    BUSINESS_ADMINISTRATOR("BusinessAdministratorProfile"),
    ADMIN("AdminProfile"),
    OBSERVER("ObserverProfile"),
    DEPUTY("DeputyProfile"),
    METHODOLOGIST("MethodologistProfile"),
    STAFF("StaffProfile"),
    SCHOOL_ADMIN("SchoolAdminProfile"),
    SCHOOL_ADMIN_READ_ONLY("SchoolAdminReadOnlyProfile"),
    PUBLISHER("PublisherProfile"),
    MATERIAL_MODERATOR("MaterialModeratorProfile"),
    NURSE("NurseProfile"),
    CONTENT_MANAGER("ContentManagerProfile"),
    ADMIN_SECURITY("AdminSecurityProfile");

    private String id;

    @JsonValue
    public String getJson() {
        return this.toString().toLowerCase();
    }

    @JsonCreator
    public static UserProfileType fromJson(String id) {
        return Enum.valueOf(UserProfileType.class, id.toUpperCase());
    }

    UserProfileType(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public static UserProfileType fromId(String id) {
        UserProfileType[] var1 = values();
        int var2 = var1.length;

        for (int var3 = 0; var3 < var2; ++var3) {
            UserProfileType type = var1[var3];
            if (type.getId().equals(id)) {
                return type;
            }
        }

        return null;
    }
}
