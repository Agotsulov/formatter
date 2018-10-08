package it.sevenbits.format.streams.string;

import it.sevenbits.format.streams.OutStream;

import java.io.IOException;
import java.lang.String;


public class StringOutStream implements OutStream {
    private String outString;

    private boolean firstWrite = false;

    public void writeSymbol(char symbol) {
        if(!firstWrite){
            outString = "" + symbol;
            firstWrite = true;
        }else {
            outString = outString + symbol;
        }
    }
    public void writeString(String string) {
        outString = outString + string;
    }

    public void close() {}

    public String getString(){
        if (outString == null) return "";
        else return outString;
    }
}
