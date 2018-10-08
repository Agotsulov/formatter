package it.sevenbits.format.formatter;

import it.sevenbits.format.handlers.*;
import it.sevenbits.format.streams.InStream;
import it.sevenbits.format.streams.OutStream;

import java.io.IOException;
import java.util.ArrayList;

public class Format {

    public static boolean indent = false;
    public static boolean isNewLine = true;
    public static int indentLevel = 0;

    public static String indentString;

    public static int pastHandlers;

    public static ArrayList<Handler> handlers = new ArrayList<Handler>();

    public static void format(InStream inStream, OutStream outStream,FormatSettings formatSettings) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        indentString = formatSettings.getIndentString();
        char currentSymbol;
        handlers = formatSettings.getHandlersList();
        while (true) {
            pastHandlers = 0;
            currentSymbol = inStream.readSymbol();
            if (inStream.isEnd()) break;
            if (indent){
                for (int j = 0; j < indentLevel; j++) {
                    outStream.writeString(indentString);
                }
            }
            for (Handler handler : handlers) {
                if (handler.canDo(currentSymbol)) {
                    handler.action(outStream);
                    break;
                }
                pastHandlers++;
            }
            if (pastHandlers ==  handlers.size()){
                outStream.writeSymbol(currentSymbol);
                indent = false;
                isNewLine = false;
            }
        }
    }
}
