package org.example;

public class HW_1 {
    public int[] subArrays(int[] a, int[] b){
        // Введите свое решение ниже
        if(a == null || b == null || a.length != b.length){
            return new int[1]; // нулевой массив длины 1 будет означать различие в длине массивов
        }
        else{
            int[] c = new int[a.length];
            for(int i = 0; i < a.length; i++){
                c[i] = a[i] / b[i];
            }
            return c;
        }
    }
}
