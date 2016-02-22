package com.team2.store.enums;

/**
 * Created by Isaiev on 22.02.2016.
 */
public enum RoleEnum {
    ADMIN(1), SELLER(2);

    private final int value;

    private RoleEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static RoleEnum getByValue(int value){
        for(RoleEnum e:values()){
            if(e.getValue()==value)
                return e;
        }
        return null;
    }
}
