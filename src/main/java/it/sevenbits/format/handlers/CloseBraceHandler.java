package it.sevenbits.format.handlers;

import it.sevenbits.format.formatter.Format2;
import it.sevenbits.format.handlers.Handler;
import it.sevenbits.format.streams.OutStream;

import java.io.IOException;

/**
 * Created by byzilio on 30.06.15.
 */
public class CloseBraceHandler implements Handler {
    public boolean canDo(char symbol) {
        if (symbol == '}') return true;
        return false;
    }

    public void action(OutStream outStream) throws IOException {
        outStream.writeSymbol('\n');

        for (int j = 0; j < Format2.indentLevel - 1; j++) {
            outStream.writeString(Format2.indentString);
        }
        System.out.println("CB");
        outStream.writeSymbol('}');
        outStream.writeSymbol('\n');
        Format2.indent = true;
        Format2.isNewLine = true;

        Format2.indentLevel = Format2.indentLevel - 1;
    }
}
