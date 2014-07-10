import java.io.IOException;
import java.lang.String;

/**
 * Created by byzilio on 09.07.14.
 */
public class StringInStream implements InStream {
    private String currentString;
    private char currentSymbol;
    private int numberSymbol = 0;
    private boolean end = false;

    public StringInStream(String s){
        this.currentString = s;
    }

    public char readSymbol() throws IOException{
        if(numberSymbol == currentString.length() ){
            end = true;
        }
        if(end == false){
            currentSymbol = currentString.charAt(numberSymbol);
            numberSymbol += 1;
        }
        return currentSymbol;
    }
    public boolean isEnd(){
        return end;
    }
}
