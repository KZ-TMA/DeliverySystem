package com.kztma.delivering.pojo;

/**
 * Created by cccc on 11/18/2017.
 */
public enum RoleType {

    ADMIN("ADMIN"),
    CONTROLLER("CONTROLLER"),
    DELIVERYMAN("DELIVERYMAN"),
    DISPATCHER("DISPATCHER"),
    OPERATOR("OPERATOR"),
    USER("USER");

    private final String value;

    RoleType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static RoleType fromValue(String v) {
        for (RoleType roleType : RoleType.values()) {
            if (roleType.value.equals(v)) {
                return roleType;
            }
        }
        throw new IllegalArgumentException(v);
    }
}
