package com.example.rgrinterface;

import java.util.Random;


public interface IArray {

    default int[] initArrayRandom(int size,int origin,int bound) throws Exception {
        if(size < 0){
            throw new Exception("Размер массива указан неверно");
        } else {
            int[] arr = new int[size];
            Random rnd = new Random();
            for (int i = 0; i < arr.length; i++) {
                arr[i] = rnd.nextInt(origin, bound+1);
            }
            return arr;
        }
    }

}
