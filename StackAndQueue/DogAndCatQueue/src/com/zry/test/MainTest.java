package com.zry.test;

import com.zry.model.Pet;

/**
 * @author zry
 * @Date 2021/12/8
 * @ApiNote
 */
public class MainTest {
    public static void main(String[] args) {
        CatAndDogQueue catAndDogQueue = new CatAndDogQueue();

        catAndDogQueue.add(new Pet("cat"));
        catAndDogQueue.add(new Pet("dog"));
        System.out.println("catAndDogQueue.isCatEmpty() = " + catAndDogQueue.isCatEmpty());
        System.out.println("catAndDogQueue.isDogEmpty() = " + catAndDogQueue.isDogEmpty());
        System.out.println("catAndDogQueue.isEmpty() = " + catAndDogQueue.isEmpty());
        //System.out.println("catAndDogQueue.pollAll() = " + catAndDogQueue.pollAll());
        System.out.println("catAndDogQueue.pollCat() = " + catAndDogQueue.pollCat());
        System.out.println("catAndDogQueue.pollDog() = " + catAndDogQueue.pollDog());
    }
}
