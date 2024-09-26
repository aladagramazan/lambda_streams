package com.rem.streams_lambda.dataType;

import java.util.Arrays;

public class ReferenceType {

    public static void main(String[] args) {
        int [] arr = new int[]{1,2,3};  // new reference in memory // abc123
        System.out.println("before change : " + Arrays.toString(arr));
        predict(arr);
        totalSale(arr);
        System.out.println("after change : " + Arrays.toString(arr));
    }

    private static void predict(int[] arr) {  // same reference in memory // abc123
        // changed reference in memory // abc456
        arr = Arrays.copyOf(arr, arr.length); // solved the problem
        arr[0]++;
        arr[1]++;
        arr[2]++;
        System.out.println("after predict : " + (arr[0] + arr[1] + arr[2]));
    }

    private static void totalSale(int[] arr) {
        int total = 0;
        for (int i = 0; i < arr.length; i++) {
            total += arr[i];
        }
        System.out.println("Total sale : " + total);
    }

    private static void change(int[] arr) {
        arr = new int[]{4,5,6};  // new reference in memory // abc456
        System.out.println(arr);
        arr[0]++;
        arr[1]++;
        arr[2]++;
    }

    /*
    Java'da tüm primitive typelar (int, float, boolean, vb.) "pass by value" ile geçirilir.
    Bu, değişkenin bir kopyasının metota geçirildiği anlamına gelir.
    Metot içinde yapılan değişiklikler orijinal değişkeni etkilemez.
     */

    /*
    Java'da tüm nesne referansları "pass by value" ile geçirilir,
    ancak bu referanslar nesnenin kendisini işaret eder.
    Bu nedenle, metot içinde referansın işaret ettiği nesne üzerinde yapılan değişiklikler orijinal nesneyi etkiler.
    Ancak, referansın kendisi değiştirildiğinde orijinal referans etkilenmez.
     */
}

