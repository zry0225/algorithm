package com.zry.model;/**
 *  @author zry
 *  @Date 2021/12/8
 *  @ApiNote 宠物类变种，通过添加时间戳，可以实现猫狗队列
 */

public class PetEntry {
    /**
     * 宠物类
     */
    private Pet pet;
    /**
     * 时间戳
     */
    private long cont;

    public PetEntry(Pet pet, long cont) {
        this.pet = pet;
        this.cont = cont;
    }

    public Pet getPet() {
        return pet;
    }

    public long getCont() {
        return cont;
    }

    public String petEntryType(){
        return this.pet.getType();
    }
}
