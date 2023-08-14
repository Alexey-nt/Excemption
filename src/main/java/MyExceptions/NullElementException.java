package MyExceptions;

public class NullElementException extends NullPointerException{
    public NullElementException(int index){
        super("Обращение к null по индексу "+index);
    }
}
