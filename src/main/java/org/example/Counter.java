package org.example;

import java.io.IOException;

public class Counter implements AutoCloseable{
    int i;
    public Counter(){
        this.i = 0;
    }

    public void add() throws IOException {
        if (isClosed()) throw new IOException("Счетчик закрыт");
        i++;
    }
    @Override
    public void close(){
        this.i = -1;
        System.out.println("Закрытие счетчика");
    }

    public boolean isClosed(){
        return (i == -1);
    }
}
