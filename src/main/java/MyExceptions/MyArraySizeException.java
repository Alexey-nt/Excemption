package MyExceptions;

public class MyArraySizeException extends RuntimeException{
    public MyArraySizeException(int m, int n){
        super(String.format("Размер массива %d на %d не корректный", m, n));
    }
}
