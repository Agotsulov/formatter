import java.io.IOException;

/**
 * Created by byzilio on 08.07.14.
 */
public interface OutStream {
    void writeSymbol(char symbol) throws IOException;
    void writeString(String string) throws IOException;
    void close() throws IOException;
    String getString();
}
