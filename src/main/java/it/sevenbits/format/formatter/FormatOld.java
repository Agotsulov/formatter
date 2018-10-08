package it.sevenbits.format.formatter;

import it.sevenbits.format.streams.InStream;
import it.sevenbits.format.streams.OutStream;

import java.io.*;

public class FormatOld {

    public static String indentString;

    public static void format(InStream inStream, OutStream outStream,FormatSettings formatSettings) throws IOException {
        indentString = formatSettings.getIndentString();
        char currentSymbol;
        char lastSymbol = ' ';
        boolean indent = true;
        int indentLevel = 0;

        while (true) {
            currentSymbol = inStream.readSymbol();
            if (inStream.isEnd()) break;
            if (currentSymbol == '{') {
                for (int j = 0; j < indentLevel; j++) {
                    outStream.writeString(indentString);
                }
                outStream.writeSymbol('{');
                outStream.writeSymbol('\n');
                indent = true;
                indentLevel = indentLevel + 1;
            } else if (currentSymbol == '}') {
                for (int j = 0; j < indentLevel-1; j++) {
                    outStream.writeString(indentString);
                }
                if (lastSymbol != ';') outStream.writeSymbol('\n');
                outStream.writeSymbol('}');
                outStream.writeSymbol('\n');
                indent = true;
                indentLevel = indentLevel - 1;
            } else {
                if (currentSymbol == ';') {
                    outStream.writeSymbol(';');
                    outStream.writeSymbol('\n');
                    indent = true;
                } else if ((currentSymbol == '(') || (currentSymbol == ')') || (currentSymbol == '=') || (currentSymbol == '+') || (currentSymbol == '-') || (currentSymbol == '*') || (currentSymbol == '/')) {
                    //outStream.writeSymbol(' ');
                    outStream.writeSymbol(currentSymbol);
                    //outStream.writeSymbol(' ');
                } else if ((currentSymbol != '\n') && (currentSymbol != '\r')) {
                    if ((currentSymbol == ' ') && (indent == true)) {
                        continue;
                    }
                    if ((currentSymbol != ' ') ||((currentSymbol == ' ') && (indent == false) )) {
                        if (indent == true){
                            for (int j = 0; j < indentLevel; j++) {
                                outStream.writeString(indentString);
                            }
                            indent = false;
                        }
                        outStream.writeSymbol(currentSymbol);
                        //indent = true;
                    }
                }
            }

            lastSymbol = currentSymbol;
        } //while(true)

        if((indentLevel > 0) && (formatSettings.getExtraBraces()==true)) {
            outStream.writeString("\n"+"//Error:More brace on "+indentLevel);
        }

        if((indentLevel < 0) && (formatSettings.getExtraBraces()==true)) {
            outStream.writeString("\n"+"//Error:Less brace on "+indentLevel*-1);
        }

    }
}
