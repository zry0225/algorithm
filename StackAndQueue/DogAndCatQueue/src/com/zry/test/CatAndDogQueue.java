package com.zry.test;

import com.zry.model.Cat;
import com.zry.model.Dog;
import com.zry.model.Pet;
import com.zry.model.PetEntry;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author zry
 * @Date 2021/12/8
 * @ApiNote
 *
 * 实现一种狗猫队列的结构, 要求如下:
 * 用户可以调用 add方法将 cat类或 dog 类的实例放入队列中;
 * 用戶可以调用pollAll 方法,将队列中所有的实例按照进队列的先后顺序依次弹出;
 * 用户可以调用pollDog方法,将队列中 dog 类的实例按照进队列的先后顺序依次
 * 弹出;
 * 用户可以调用pollCat方法,将队列中 cat 类的实例按照进队列的先后顺序依次弹出;
 * 用戶可以调用isEmpty方法,检查队列中是否还有 dog或 cat 的实例;
 * 用戶可以调用 isDogEmpty 方法,检查队列中是否有 dog 类的实例;
 * 用戶可以调用 isCatEmpty方法,检查队列中是否有 cat 类的实例。
 */
public class CatAndDogQueue {
    /**
     * 狗狗队列
     */
    private Queue<PetEntry> dogQ;
    /**
     * 猫猫队列
     */
    private Queue<PetEntry> catQ;

    /**
     * 标识，随时间累加
     */
    private long cont;

    /**
     * 用戶可以调用isEmpty方法,检查队列中是否还有 dog或 cat 的实例;
     * @return 是否有实例
     */
    public boolean isEmpty(){
        return isDogEmpty() && isCatEmpty();
    }

    /**
     * 用戶可以调用 isDogEmpty 方法,检查队列中是否有 dog 类的实例;
     * @return 是否有狗狗实例
     */
    public boolean isDogEmpty(){
        return dogQ.isEmpty();
    }

    /**
     * 用戶可以调用 isCatEmpty 方法,检查队列中是否有 cat 类的实例;
     * @return 是否有猫猫实例
     */
    public boolean isCatEmpty(){
        return catQ.isEmpty();
    }

    public CatAndDogQueue() {
        this.dogQ = new LinkedList<PetEntry>();
        this.catQ = new LinkedList<PetEntry>();
        this.cont = 0;
    }

    /**
     * 用户可以调用 add方法将 cat类或 dog 类的实例放入队列中;
     * @param pet 宠物
     */
    public void add(Pet pet){
        String dog = "dog";
        String cat = "cat";

        if (dog.equals(pet.getType())){
            dogQ.add(new PetEntry(pet,this.cont++));
        }else if (cat.equals(pet.getType())){
            catQ.add(new PetEntry(pet,this.cont++));
        }else {
            throw new RuntimeException("宠物类型错误");
        }
    }

    /**
     * 用戶可以调用pollAll 方法,将队列中所有的实例按照进队列的先后顺序依次弹出;
     * @return
     */
    public Pet pollAll(){
        if (!this.dogQ.isEmpty() && !this.catQ.isEmpty()){
            if (this.dogQ.peek().getCont()>this.catQ.peek().getCont()){
                return this.catQ.poll().getPet();
            }else {
                return this.dogQ.poll().getPet();
            }
        }else if (dogQ.isEmpty()){
            return this.catQ.poll().getPet();
        }else if(catQ.isEmpty()){
            return this.dogQ.poll().getPet();
        }else {
            throw new RuntimeException("猫狗队列都是空");
        }
    }

    /**
     * 用户可以调用pollDog方法,将队列中 dog 类的实例按照进队列的先后顺序依次
     * @return 狗狗
     */
    public Dog pollDog(){
        if (!this.isDogEmpty()){
            return (Dog) this.dogQ.poll().getPet();
        }else {
            throw new RuntimeException("狗狗队列为空");
        }
    }

    /**
     * 用户可以调用pollCat方法,将队列中 cat 类的实例按照进队列的先后顺序依次弹出;
     * @return 猫猫
     */
    public Cat pollCat(){
        if (!this.isCatEmpty()){
            return (Cat) this.catQ.poll().getPet();
        }else {
            throw new RuntimeException("猫猫队列为空");
        }
    }






}
