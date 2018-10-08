package it.sevenbits.format.handlers;

import it.sevenbits.format.formatter.Format;
import it.sevenbits.format.streams.OutStream;

import java.io.IOException;

/**
 * Created by byzilio on 30.06.15.
 */
public class ExtraSpacesHandler extends IndentHandler {

    public boolean canDo(char symbol) {
        return symbol == ' ';
    }

    public void action(OutStream outStream) throws IOException {
        super.action(outStream);
        if (!Format.isNewLine) outStream.writeSymbol(' ');
        Format.indent = false;
    }
}
