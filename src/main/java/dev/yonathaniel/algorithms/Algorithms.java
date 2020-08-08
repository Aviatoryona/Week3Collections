package dev.yonathaniel.algorithms;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Algorithms {


    public static void main(String[] args) {
//        Algorithms algorithms = new Algorithms();
//        algorithms.toRecursion(5);
//        System.out.println(algorithms.sum);
//        doFindSum();
//        doAlg2(32);
        doChange(1790);
    }


    // TODO: 7/23/2020
    private int sum = 0;

    private void toRecursion(int n) {
        if (n > 0) {
            sum += n;
        } else {
            return;
        }
        n--;
        toRecursion(n);
    }

    static void doFindSum() {
        int[] vals = {8, 7, 2, 5, 3, 1};
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < vals.length; i++) {
            for (int j = i + 1; j < vals.length; j++) {
                int sum = vals[i] + vals[j];
                map.put(i + "-" + j, sum);
            }
        }

        for (String s :
                map.keySet()) {

        }
    }

    static void doAlg2(int n) {
        char[] s = String.valueOf(n).toCharArray();
        int sum = 0;
        for (int i = 0; i < s.length; i++) {
            sum += Math.pow((Integer.parseInt(String.valueOf(s[i]))), 2);
        }

        System.out.println(sum);
        if (sum == 1) {
            return;
        }
        doAlg2(sum);
    }

    void p2() {

    }

    static double[] demons = {
            1000,
            500, 200, 100, 50, 40, 20, 10, 5, 1, 0.1, 0.5
    };

    static void doChange(double amount) {
        double swap = amount;
        for (int i = 0; i < demons.length; i++) {
            double mod = swap % demons[i];
            double tm=swap/demons[i];
            double times=Math.floor(tm);//Math.round(tm);
            if (mod == 0){
                System.out.println(demons[i] + "-" +times);
                break;
            }else{
                System.out.println(demons[i] + "-" +times);
            }
            swap=mod;
//            System.out.println(swap);
        }
    }


}
