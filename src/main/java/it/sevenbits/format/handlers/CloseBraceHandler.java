package it.sevenbits.format.handlers;

import it.sevenbits.format.formatter.Format;
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

        for (int j = 0; j < Format.indentLevel - 1; j++) {
            outStream.writeString(Format.indentString);
        }
        outStream.writeSymbol('}');
        outStream.writeSymbol('\n');
        Format.indent = true;
        Format.isNewLine = true;

        Format.indentLevel = Format.indentLevel - 1;
    }
}
