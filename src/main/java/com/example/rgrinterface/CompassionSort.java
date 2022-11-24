package com.example.rgrinterface;

import javafx.scene.control.skin.TableHeaderRow;

import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

public class CompassionSort {

    private static Map<String,String> compassionMap = new HashMap<>();

    public static Map<String, Integer> getKolvoOper() {
        return kolvoOper;
    }

    private static Map<String,Integer> kolvoOper = new HashMap<>();

    public static Map<String,String> compassionSort(int[] arrForCompassion) {
        class BubbleThread extends Thread {
            @Override
            public void run(){
                try {
                    Sort bubble = new Sort();
                    compassionMap.put("bubble",bubble.bubbleSorter(arrForCompassion.clone()));
                    kolvoOper.put("bubble",bubble.getKolvoOper());
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
        class CocktailThread extends Thread{
            @Override
            public void run(){
                Sort cocktail = new Sort();
                compassionMap.put("cocktail",cocktail.cocktailSorter(arrForCompassion.clone()));
                kolvoOper.put("cocktail",cocktail.getKolvoOper());
            }
        }
        class SelectionThread extends Thread{
            @Override
            public void run(){
                Sort selection = new Sort();
                compassionMap.put("selection",selection.selectionSorter(arrForCompassion.clone()));
                kolvoOper.put("selection",selection.getKolvoOper());
            }
        }
        class CombShellThread extends Thread{
            @Override
            public void run(){
                Sort comb = new Sort();
                Sort shell = new Sort();
                compassionMap.put("comb",comb.combSorter(arrForCompassion.clone()));
                compassionMap.put("shell",shell.shellSorter(arrForCompassion.clone()));
                kolvoOper.put("comb",comb.getKolvoOper());
                kolvoOper.put("shell",shell.getKolvoOper());
            }
        }

        CocktailThread cocktailThread = new CocktailThread();
        BubbleThread bubbleThread = new BubbleThread();
        SelectionThread selectionThread = new SelectionThread();
        CombShellThread combShellThread = new CombShellThread();

        cocktailThread.run();
        bubbleThread.run();
        selectionThread.run();
        combShellThread.run();

        return compassionMap;
    }

}