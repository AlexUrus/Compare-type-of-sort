package com.example.rgrinterface;

import java.time.Duration;
import java.time.Instant;

public class Sort implements IArray {
    public int getKolvoOper() {
        return kolvoOper;
    }
    private int kolvoOper = 0;
    private void toSwap(int indexFirst, int indexSecond, int[] array) {
        int swapElement = array[indexFirst]; kolvoOper++;
        array[indexFirst] = array[indexSecond];kolvoOper++;
        array[indexSecond] = swapElement;kolvoOper++;
    }
    private void hSort(int[] array, int h) {
        int length = array.length;kolvoOper++;
        for (int i = h; i < length; i++) {
            for (int j = i; j >= h; j = j - h) {
                kolvoOper++;
                if (array[j] < array[j - h]) {
                    kolvoOper++;
                    toSwap(j, j - h, array);
                }
                else
                    break;
            }
        }
    }
    private int min(int[] array, int begin, int end) {
        int minVal = array[begin]; kolvoOper++;
        int minIndex = begin; kolvoOper++;
        for (int i = begin + 1; i <= end; i++) {
            kolvoOper++;
            if (array[i] < minVal) {
                minVal = array[i];kolvoOper++;
                minIndex = i;kolvoOper++;
            }
        }
        return minIndex;
    }
    public String selectionSorter(int[] array) {
        Instant instantStart = Instant.now();
        int n = array.length; kolvoOper++;
        for (int i = 0; i < n; i ++) {
            int minIndex = min(array, i, n - 1);kolvoOper++;
            toSwap( i, minIndex,array);kolvoOper++;
        }
        Instant instantStop = Instant.now();
        Duration durationBetween = Duration.between(instantStart, instantStop);
        return String.valueOf(durationBetween.toMillis());
    }
    public String shellSorter(int[] array) {
        Instant instantStart = Instant.now();
        int h = 1;kolvoOper++;
        while (h*3 < array.length) {
            h = h * 3 + 1;kolvoOper++;
        }
        while(h >= 1) {
            hSort(array, h);kolvoOper++;
            h = h/3;kolvoOper++;
        }
        Instant instantStop = Instant.now();
        Duration durationBetween = Duration.between(instantStart, instantStop);
        return String.valueOf(durationBetween.toMillis());
    }
    public String bubbleSorter(int[] array) throws Exception {
        Instant instantStart = Instant.now();
        if (array.length > 1) { kolvoOper++;
            for (int out = array.length - 1; out >= 1; out--) {
                kolvoOper++;
                for (int in = 0; in < out; in++) {
                    kolvoOper++;
                    if (array[in] > array[in + 1]) {
                        toSwap(in, in + 1,array);kolvoOper++;
                    }
                }
            }
        } else if (array.length < 0) throw new Exception("Размер массива равен нулю");
        Instant instantStop = Instant.now();
        Duration durationBetween = Duration.between(instantStart, instantStop);
        return String.valueOf(durationBetween.toMillis());
    }
    public String combSorter(int[] array) {
        Instant instantStart = Instant.now();
        final double constStep = 1.24733095;kolvoOper++;
        int step = array.length;kolvoOper++;
        while (step > 1) { kolvoOper++;
            step = (int) (step / constStep);
            for (int i = 0; step + i < array.length; i++) {
                kolvoOper++;
                if (array[i] > array[i + step]) {
                    kolvoOper++;
                    toSwap(i, i + step, array);
                }
            }
        }
        Instant instantStop = Instant.now();
        Duration durationBetween = Duration.between(instantStart, instantStop);
        return String.valueOf(durationBetween.toMillis());
    }
    public String cocktailSorter(int[] array) {
        Instant instantStart = Instant.now();
        int start = 0;kolvoOper++;
        int end = array.length - 1;kolvoOper++;
        while (start <= end) {kolvoOper++;
            boolean swapped = false;
            for (int j = start; j < end; j++) {kolvoOper++;
                if (array[j] > array[j + 1]) {
                    int temp = array[j];kolvoOper++;
                    array[j] = array[j + 1];kolvoOper++;
                    array[j + 1] = temp;kolvoOper++;
                    swapped = true;
                }
            }
            end--;kolvoOper++;
            for (int k = end; k > start; k--) {kolvoOper++;
                if (array[k] < array[k - 1]) {
                    int temp = array[k - 1];kolvoOper++;
                    array[k - 1] = array[k];kolvoOper++;
                    array[k] = temp;kolvoOper++;
                    swapped = true;
                }
            }
            start++;kolvoOper++;
            if (!swapped) {
                break;
            }
        }
        Instant instantStop = Instant.now();
        Duration durationBetween = Duration.between(instantStart, instantStop);
        return String.valueOf(durationBetween.toMillis());
    }
}