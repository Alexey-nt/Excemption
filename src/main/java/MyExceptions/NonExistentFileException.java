package MyExceptions;

import java.io.FileNotFoundException;

public class NonExistentFileException extends FileNotFoundException {
    public NonExistentFileException(String path){
        super("Несуществующий файл по пути: "+path);
    }
}
