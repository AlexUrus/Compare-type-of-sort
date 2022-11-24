package com.example.rgrinterface;

import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.text.DecimalFormat;
import java.util.Map;

public class Controller implements IArray {
    private int sizeOfArray = 30000;
    @FXML
    private Button but_charts;
    @FXML
    private LineChart<Number,Number> lineChart;
    @FXML
    private NumberAxis axisOfNumber;
    @FXML
    private NumberAxis axisOfTime;
    @FXML
    private Label bubble;
    @FXML private Label comb;
    @FXML private Label cocktail;
    @FXML private Label selection;
    @FXML private Label shell;
    @FXML
    private Button but_start;
    @FXML
    protected void but_start_action() throws Exception {
        DecimalFormat df = new DecimalFormat("#,###,###");
        Map<String,String> compMap = CompassionSort.compassionSort(initArrayRandom(sizeOfArray,1,1000));
        bubble.setText(compMap.get("bubble")+ " millis kolvo oper " + df.format(CompassionSort.getKolvoOper().get("bubble")).replace(","," " ));
        comb.setText(compMap.get("comb")+ " millis kolvo oper "+ df.format(CompassionSort.getKolvoOper().get("comb")).replace(","," "));
        cocktail.setText(compMap.get("cocktail")+ " millis kolvo oper " + df.format(CompassionSort.getKolvoOper().get("cocktail")).replace(","," "));
        selection.setText(compMap.get("selection")+ " millis kolvo oper "+ df.format(CompassionSort.getKolvoOper().get("selection")).replace(","," "));
        shell.setText(compMap.get("shell")+ " millis kolvo oper "+ df.format(CompassionSort.getKolvoOper().get("shell")).replace(","," "));
    }
    @FXML
    protected void but_charts_action() throws Exception {

        lineChart.getXAxis().setAutoRanging(true);
        lineChart.getYAxis().setAutoRanging(true);

        enum KolvoEl{
            ONE(1000),TWO(2500),THREE(5000),FOUR(10000),FIVE(30000);
            private int value;
            KolvoEl(int i) {
                value = i;
            }
        }
        Map<String,String> compMap = CompassionSort.compassionSort(initArrayRandom(KolvoEl.ONE.value,1,1000));

        XYChart.Series<Number,Number> bubble = new XYChart.Series<>();
        XYChart.Series<Number,Number> comb = new XYChart.Series<>();
        XYChart.Series<Number,Number> cocktail = new XYChart.Series<>();
        XYChart.Series<Number,Number> selection = new XYChart.Series<>();
        XYChart.Series<Number,Number> shell = new XYChart.Series<>();

        bubble.setName("Bubble Sort");
        comb.setName("Comb Sort");
        cocktail.setName("Cocktail Sort");
        selection.setName("Selection Sort");
        shell.setName("Shell Sort");

        bubble.getData().add(new XYChart.Data(KolvoEl.ONE.value,Integer.parseInt(compMap.get("bubble"))));
        comb.getData().add(new XYChart.Data(KolvoEl.ONE.value,Integer.parseInt(compMap.get("comb"))));
        cocktail.getData().add(new XYChart.Data(KolvoEl.ONE.value,Integer.parseInt(compMap.get("cocktail"))));
        selection.getData().add(new XYChart.Data(KolvoEl.ONE.value,Integer.parseInt(compMap.get("selection"))));
        shell.getData().add(new XYChart.Data(KolvoEl.ONE.value,Integer.parseInt(compMap.get("shell"))));

        Map<String,String> compMap2 = CompassionSort.compassionSort(initArrayRandom(KolvoEl.TWO.value,1,1000));

        bubble.getData().add(new XYChart.Data(KolvoEl.TWO.value,Integer.parseInt(compMap2.get("bubble"))));
        comb.getData().add(new XYChart.Data(KolvoEl.TWO.value,Integer.parseInt(compMap2.get("comb"))));
        cocktail.getData().add(new XYChart.Data(KolvoEl.TWO.value,Integer.parseInt(compMap2.get("cocktail"))));
        selection.getData().add(new XYChart.Data(KolvoEl.TWO.value,Integer.parseInt(compMap2.get("selection"))));
        shell.getData().add(new XYChart.Data(KolvoEl.TWO.value,Integer.parseInt(compMap2.get("shell"))));

        Map<String,String> compMap3 = CompassionSort.compassionSort(initArrayRandom(KolvoEl.THREE.value,1,1000));

        bubble.getData().add(new XYChart.Data(KolvoEl.THREE.value,Integer.parseInt(compMap3.get("bubble"))));
        comb.getData().add(new XYChart.Data(KolvoEl.THREE.value,Integer.parseInt(compMap3.get("comb"))));
        cocktail.getData().add(new XYChart.Data(KolvoEl.THREE.value,Integer.parseInt(compMap3.get("cocktail"))));
        selection.getData().add(new XYChart.Data(KolvoEl.THREE.value,Integer.parseInt(compMap3.get("selection"))));
        shell.getData().add(new XYChart.Data(KolvoEl.THREE.value,Integer.parseInt(compMap3.get("shell"))));

        Map<String,String> compMap4 = CompassionSort.compassionSort(initArrayRandom(KolvoEl.FOUR.value,1,1000));

        bubble.getData().add(new XYChart.Data(KolvoEl.FOUR.value,Integer.parseInt(compMap4.get("bubble"))));
        comb.getData().add(new XYChart.Data(KolvoEl.FOUR.value,Integer.parseInt(compMap4.get("comb"))));
        cocktail.getData().add(new XYChart.Data(KolvoEl.FOUR.value,Integer.parseInt(compMap4.get("cocktail"))));
        selection.getData().add(new XYChart.Data(KolvoEl.FOUR.value,Integer.parseInt(compMap4.get("selection"))));
        shell.getData().add(new XYChart.Data(KolvoEl.FOUR.value,Integer.parseInt(compMap4.get("shell"))));

        Map<String,String> compMap5 = CompassionSort.compassionSort(initArrayRandom(KolvoEl.FIVE.value,1,1000));

        bubble.getData().add(new XYChart.Data(KolvoEl.FIVE.value,Integer.parseInt(compMap5.get("bubble"))));
        comb.getData().add(new XYChart.Data(KolvoEl.FIVE.value,Integer.parseInt(compMap5.get("comb"))));
        cocktail.getData().add(new XYChart.Data(KolvoEl.FIVE.value,Integer.parseInt(compMap5.get("cocktail"))));
        selection.getData().add(new XYChart.Data(KolvoEl.FIVE.value,Integer.parseInt(compMap5.get("selection"))));
        shell.getData().add(new XYChart.Data(KolvoEl.FIVE.value,Integer.parseInt(compMap5.get("shell"))));

        lineChart.getData().addAll(bubble,comb,cocktail,selection,shell);


    }
}
