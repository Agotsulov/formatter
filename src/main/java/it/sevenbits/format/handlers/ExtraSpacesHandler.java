package it.sevenbits.format.handlers;

import it.sevenbits.format.formatter.Format;
import it.sevenbits.format.streams.OutStream;

import java.io.IOException;

/**
 * Created by byzilio on 30.06.15.
 */
public class ExtraSpacesHandler implements Handler {
    public boolean canDo(char symbol) {
        if (symbol == ' ') return true;
        return false;
    }

    public void action(OutStream outStream) throws IOException {
        if (Format.isNewLine == false ) outStream.writeSymbol(' ');
        Format.indent = false;
    }
}
