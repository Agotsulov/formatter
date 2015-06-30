package it.sevenbits.format.handlers;

import it.sevenbits.format.formatter.Format2;
import it.sevenbits.format.handlers.Handler;
import it.sevenbits.format.streams.OutStream;

import java.io.IOException;

/**
 * Created by byzilio on 30.06.15.
 */
public class SemicolonHandler implements Handler {
    public boolean canDo(char symbol) {
        if (symbol == ';') return true;
        return false;
    }

    public void action(OutStream outStream) throws IOException {
        outStream.writeSymbol(';');
        System.out.println("SC");
        outStream.writeSymbol('\n');
        Format2.indent = true;
        Format2.isNewLine = true;

    }
}
