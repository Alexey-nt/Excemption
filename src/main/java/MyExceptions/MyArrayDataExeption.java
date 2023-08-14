package MyExceptions;

public class MyArrayDataExeption extends RuntimeException{
    public MyArrayDataExeption(int i, int j, String value){
        super(String.format("Некорректный элемент %s на позиции [%d, %d]", value, i, j));
    }
}
