import java.io.IOException;

public interface InStream {
    char readSymbol() throws IOException;
    boolean isEnd();
}
