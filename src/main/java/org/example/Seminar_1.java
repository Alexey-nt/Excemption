package org.example;

public class Seminar_1 {
    public static void main(String[] args) {
// Здача 1
//        int[] testArray = {5, 5, 3, 6, 1, 7};
//        printMessage(task1(testArray, 6, 3)); // Индекс элемента: 2
//        printMessage(task1(testArray, 7, 3)); // Длина массива меньше заданного
//        printMessage(task1(testArray, 4, 8)); // Элемент не найден
//        printMessage(task1(null, 4, 3)); // Вместо масива прищел null

// Задача 2
//        int[][] m = {{0,1,0},{1,1}};
//        System.out.println("Сумма элементов равна: "+sumOfElements(m));

//        int[][] m = {{0,2},{1,1}};
//        System.out.println("Сумма элементов равна: "+sumOfElements(m));

// Задача 3
//        Integer[] array = {1,2,null,3,null};
//        checkArray(array);

//        Integer[] array = {1,3,2,5,4,9};
//        checkArray(array);

// Задача 4
//        int[][] m = {{1,2},{1,2}};
//        System.out.println(task4(m));
    }
/*
Задача 1
Реализуйте метод, принимающий в качестве аргумента целочисленный массив и некоторое значение.
Метод ищет в массиве заданное значение и возвращает его индекс. При этом, например:
если длина массива меньше некоторого заданного минимума, метод возвращает -1, в качестве кода ошибки.
если искомый элемент не найден, метод вернет -2 в качестве кода ошибки.
если вместо массива пришел null, метод вернет -3
придумайте свои варианты исключительных ситуаций и верните соответствующие коды ошибок.
Напишите метод, в котором реализуйте взаимодействие с пользователем.
То есть, этот метод запросит искомое число у пользователя, вызовет первый, обработает возвращенное значение и покажет
читаемый результат пользователю. Например, если вернулся -2, пользователю выведется сообщение: “Искомый элемент не найден
 */
    public static int task1(int[] array, int num, int value) {
        if (array == null)
            return -3;
        if (array.length < num)
            return -1;
        int result = -2;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                result = i;
                break;
            }
        }
        return result;
    }


    public static void printMessage(int errorCode){
        switch (errorCode){
            case -3:
                System.out.println("Вместо масива прищел null");
                break;
            case -1:
                System.out.println("Длина массива меньше заданного");
                break;
            case  -2:
                System.out.println("Элемент не найден");
                break;
            default:
                System.out.println("Индекс элемента: " + errorCode);
        }
    }

/*
Задача 2
Реализуйте метод, принимающий в качестве аргумента целочисленный двумерный массив.
Необходимо посчитать и вернуть сумму элементов этого массива.
При этом накладываем на метод 2 ограничения:
  - метод может работать только с квадратными массивами (кол-во строк = кол-ву столбцов),
  - в каждой ячейке может лежать только значение 0 или 1.
Если нарушается одно из условий, метод должен бросить RuntimeException с сообщением об ошибке.
 */

    public static int sumOfElements(int[][] matrix) {
        int height = matrix.length;
        int sum = 0;
        for (int[] row: matrix) {
            if (row.length != height){
                throw new RuntimeException(String.format("Матрица не квадратная, есть строка длины %d, " + "всего строк %d", row.length, height));
            }
            for (int num: row) {
                if (num != 0 && num != 1){
                    throw new RuntimeException(String.format("В матрице есть число %d, отличное от 0 и 1", num));
                }
                sum += num;
            }
        }
        return sum;
    }

/*
Задача 3
Реализуйте метод checkArray(Integer[] arr), принимающий в качестве аргумента целочисленный одномерный массив.
Метод должен пройтись по каждому элементу и проверить что он не равен null.
А теперь реализуйте следующую логику:
Если в какой-то ячейке встретился null, то необходимо “оповестить” об этом пользователя
Если null’ы встретились в нескольких ячейках, то идеально было бы все их “подсветить”
 */

    public static void checkArray(Integer[] array){
        StringBuilder nullIndexes = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null){
                nullIndexes.append(i).append(" ");
            }
        }
        if (nullIndexes.length() != 0){
            throw new RuntimeException("Индексы null-ов: "+nullIndexes);
        }
        System.out.println("null-ов нет");
    }

/*
Задача 4
Реализуйте метод, принимающий в качестве аргументов двумерный массив.
Метод должен проверить что длина строк и столбцов с одинаковым индексом одинакова,
детализировать какие строки со столбцами не требуется.
Как бы вы реализовали подобный метод.
 */

    public static boolean task4(int[][] matrix){
        int height = matrix.length;
        int[] num = getCountColumn(matrix);
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i].length != num[i])
                return false;
            }
        return true;
        }

    public static int[] getCountColumn(int[][] array){
        StringBuilder string1 = new StringBuilder();
        int max = 0;
        for (int[] row: array) {
            if (row.length > max){
                max = row.length;
            }
        }
        int[] maxElements = new int[max];
        for (int[] row: array) {
            for (int i = 0; i < row.length; i++) {
                maxElements[i] += 1;
            }
        }
        return maxElements;
    }
}