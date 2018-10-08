package it.sevenbits.format.handlers;

import it.sevenbits.format.formatter.Format;
import it.sevenbits.format.streams.OutStream;

import java.io.IOException;

public class OpenBraceHandler extends IndentHandler {

    public boolean canDo(char symbol) {
        return symbol == '{';
    }

    public void action(OutStream outStream) throws IOException {
        super.action(outStream);

        outStream.writeSymbol('{');
        outStream.writeSymbol('\n');

        Format.indent = true;
        Format.isNewLine = true;

        Format.indentLevel = Format.indentLevel + 1;
    }
}
