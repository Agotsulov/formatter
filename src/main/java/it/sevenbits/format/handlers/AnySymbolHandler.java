package it.sevenbits.format.handlers;

import it.sevenbits.format.formatter.Format;
import it.sevenbits.format.streams.OutStream;

import java.io.IOException;

public class AnySymbolHandler extends IndentHandler {

    private char symbol;

    @Override
    public boolean canDo(char symbol) {
        this.symbol = symbol;
        return true;
    }

    @Override
    public void action(OutStream outStream) throws IOException {
        super.action(outStream);
        outStream.writeSymbol(symbol);

        Format.indent = false;
        Format.isNewLine = false;
    }
}
