package org.example;

import java.util.Scanner;

/*
Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float),
и возвращает введенное значение.
Ввод текста вместо числа не должно приводить к падению приложения,
вместо этого, необходимо повторно запросить у пользователя ввод данных.
 */
public class HW_2 {
    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);
        System.out.println("Введите дробное число: ");
        int num = iScanner.nextInt();
    }

    public static boolean inputFloat(){
        try {
            String st = new String(String.valueOf(inputFloat()));
        } catch (Exception e) {
            System.out.println("Введены некорректные данные");
        }
        return false;
    }
}

