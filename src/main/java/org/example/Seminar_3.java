package org.example;

import MyExceptions.*;

import java.io.File;
import java.io.IOException;

public class Seminar_3 {

    public static void main(String[] args) {
        task1();
        task2();
        task3();
        task4();
    }

    /*
    task1
    Создайте метод doSomething(), который может быть источником одного из типов
    checked exceptions (тело самого метода прописывать не обязательно).
    Вызовите этот метод из main и обработайте в нем исключение, которое вызвал метод doSomething().
     */

    public static void task1(){
        try {
            doSomething();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /*
    task2
    Создайте класс Счетчик, у которого есть метод add(), увеличивающий значение внутренней int переменной на 1.
    Сделайте так, чтобы с объектом такого типа можно было работать в блоке try-with-resources.
    Подумайте, что должно происходить при закрытии этого ресурса? Напишите метод для проверки, закрыт ли ресурс.
    При попытке вызвать add() у закрытого ресурса, должен выброситься IOException+
     */

    public static void task2(){
        try(Counter counter = new Counter()) {
            counter.add();
            counter.close();
            counter.add();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void doSomething() throws IOException{
        File file = new File("path");
    }

/*
task3
Создайте класс исключения, который будет выбрасываться при делении на 0.
Исключение должно отображать понятное для пользователя сообщение об ошибке.
Создайте класс исключений, которое будет возникать при обращении к пустому элементу в массиве ссылочного типа.
Исключение должно отображать понятное для пользователя сообщение об ошибке
Создайте класс исключения, которое будет возникать при попытке открыть несуществующий файл.
Исключение должно отображать понятное для пользователя сообщение об ошибке.
 */

    public static void task3(){
        try {
            int a = 5/0;
        } catch (ArithmeticException ae) {
            try {
                throw new DivisionByZeroException();
            }
            catch (DivisionByZeroException e){
                System.out.println(e.getMessage());
            }

        }

        try {
            throw new NullElementException(3);
        }catch (NullElementException e){
            System.out.println(e.getMessage());
        }

        try {
            throw new NonExistentFileException("path");
        }catch (NonExistentFileException e){
            System.out.println(e.getMessage());
        }
    }

    /*
    task4
    Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4.
    При подаче массива другого размера необходимо бросить исключение MyArraySizeException.
Далее метод должен пройтись по всем элементам массива, преобразовать в int и просуммировать.
Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа),
должно быть брошено исключение MyArrayDataException с детализацией, в какой именно ячейке лежат неверные данные.
В методе main() вызвать полученный метод, обработать возможные исключения MyArraySizeException и MyArrayDataException и
вывести результат расчета (сумму элементов, при условии что подали на вход корректный массив).
     */

    public static void task4(){
        String[][] array = {{"1","2","3","4"},{"1","2","3","4"},{"1","2","3","4"},{"1","2","3","4"}};
//        String[][] array = {{"1","2","3","4"},{"1","2","3","4","5"},{"1","2","3","4"},{"1","2","3","4"}};
//        String[][] array = {{"1","2","3","4"},{"1","2","3","gyg"},{"1","2","3","4"},{"1","2","3","4"}};
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i].length != array.length) throw new MyArraySizeException(array.length, array[i].length);
            for (int j = 0; j < array[i].length; j++){
                if (!isInt(array[i][j])) throw new MyArrayDataExeption(i, j, array[i][j]);
                sum += Integer.parseInt(array[i][j]);
            }
        }
        System.out.println("Сумма элементов массива: "+sum);
    }

    public static boolean isInt(String number){
        try {
            Integer.parseInt(number);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }

}
