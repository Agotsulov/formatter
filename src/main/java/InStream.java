import java.io.IOException;

/**
 * Created by byzilio on 08.07.14.
 */
public interface InStream {
    char readSymbol() throws IOException;
    boolean isEnd();
}
