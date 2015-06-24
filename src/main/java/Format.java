import java.io.*;

public class Format {

    public static final String INDENT_STRING = "    ";

    public static void format(InStream inStream, OutStream outStream) throws IOException {

        char currentSymbol;
        char lastSymbol = ' ';
        boolean indent = true;
        int indentLevel = 0;

        while (true) {
            currentSymbol = inStream.readSymbol();
            if (inStream.isEnd()) break;
            if (currentSymbol == '{') {
                for (int j = 0; j < indentLevel; j++) {
                    outStream.writeString(INDENT_STRING);
                }
                outStream.writeSymbol('{');
                outStream.writeSymbol('\n');
                indent = true;
                indentLevel = indentLevel + 1;
            } else if (currentSymbol == '}') {
                for (int j = 0; j < indentLevel - 1; j++) {
                    outStream.writeString(INDENT_STRING);
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
                    outStream.writeSymbol(' ');
                    outStream.writeSymbol(currentSymbol);
                    outStream.writeSymbol(' ');
                } else if (currentSymbol != '\n') {
                    if ((currentSymbol == ' ') && (indent == true)) {
                        continue;
                    }
                    if ((currentSymbol != ' ') ||((currentSymbol == ' ') && (indent == false) )) {
                        if (indent == true){
                            for (int j = 0; j < indentLevel; j++) {
                                outStream.writeString(INDENT_STRING);
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
    }
}
