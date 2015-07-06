package it.sevenbits.format.formatter;

import it.sevenbits.format.handlers.*;
import it.sevenbits.format.streams.InStream;
import it.sevenbits.format.streams.OutStream;

import java.io.IOException;
import java.util.ArrayList;

public class Format2 {
    public static boolean indent = false;
    public static boolean isNewLine = true;
    public static int indentLevel = 0;
    public static String indentString;
    public static int pastHandlers;
    public static ArrayList<Handler> handlers = new ArrayList<Handler>();
    public static void format(InStream inStream, OutStream outStream,FormatSettings formatSettings) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        indentString = formatSettings.getIndentString();
        char currentSymbol;
        Class c = Class.forName("it.sevenbits.format.handlers.SemicolonHandler");
        Object o =  c.newInstance();
        handlers.add((Handler) o);
        //handlers.add(new SemicolonHandler());
        handlers.add(new OpenBraceHandler());
        handlers.add(new CloseBraceHandler());
        handlers.add(new ExtraSpacesHandler());

        while (true) {
            pastHandlers = 0;
            currentSymbol = inStream.readSymbol();
            if (inStream.isEnd()) break;
            System.out.println("Read:"+currentSymbol);
            if (indent == true){
                System.out.println("new line");
                for (int j = 0; j < indentLevel; j++) {
                    outStream.writeString(indentString);
                }
            }
            for (int i = 0; i < handlers.size(); i++) {
                if (handlers.get(i).canDo(currentSymbol)){
                    handlers.get(i).action(outStream);
                    break;
                }
                pastHandlers++;
            }
            System.out.println("past:"+pastHandlers);
            if (pastHandlers ==  handlers.size()){
                System.out.println("Write:"+currentSymbol);
                outStream.writeSymbol(currentSymbol);
                indent = false;
                isNewLine = false;
            }
        }
    }
}
