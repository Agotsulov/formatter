package it.sevenbits.format.streams;

import java.io.IOException;


public interface OutStream {
    void writeSymbol(char symbol) throws IOException;
    void writeString(String string) throws IOException;
    void close() throws IOException;
    String getString();
}
