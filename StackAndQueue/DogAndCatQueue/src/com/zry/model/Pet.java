package com.zry.model;

/**
 * @author zry
 * @Date 2021/12/8
 * @ApiNote 宠物类
 */
public class Pet {
    private String type;

    public Pet(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "type='" + type + '\'' +
                '}';
    }
}
