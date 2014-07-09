import java.io.*;

/**
 * Created by byzilio on 08.07.14.
 */
public class FileInStream implements InStream {
    private Reader fileReader;
    private boolean end = false;
    public FileInStream(final String fileName) throws FileNotFoundException {
        this.fileReader = new FileReader(new File(fileName));
    }

    @Override
    public char readSymbol() throws IOException {
        int i = this.fileReader.read();
        if (i == -1) {
            end = true;
        }
        return (char) i;
    }

    public boolean isEnd() {
        return end;
    }
}
