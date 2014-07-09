import java.io.*;

public class FileOutStream implements OutStream {
    private Writer fileWriter;

    public FileOutStream(final String fileName) throws IOException {
        this.fileWriter = new FileWriter(new File(fileName));
    }

    public void writeSymbol(char symbol) throws IOException{
        fileWriter.write(symbol);
    }

    public void writeString(String string) throws IOException{
        fileWriter.write(string);
    }

    public void close() throws IOException{
        this.fileWriter.close();
    }
    public String getString(){
        return "null";
    }
}
