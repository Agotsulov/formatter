import java.io.IOException;
import java.lang.String;

/**
 * Created by byzilio on 09.07.14.
 */
public class StringOutStream implements OutStream{
    private String outString;
    private boolean firstWrite = false;

    public void writeSymbol(char symbol) throws IOException{
        if(firstWrite == false){
            outString = "" + symbol;
            firstWrite = true;
        }else {
            outString = outString + symbol;
        }
    }
    public void writeString(String string) throws IOException{
        outString = outString + string;
    }
    public void close() throws IOException{
    }

    public String getString(){
        return outString;
    }
}
