package it.sevenbits.format.handlers;

import it.sevenbits.format.formatter.Format;
import it.sevenbits.format.streams.OutStream;

import java.io.IOException;

public abstract class IndentHandler implements Handler {

    @Override
    public boolean canDo(char symbol) {
        return false;
    }

    @Override
    public void action(OutStream outStream) throws IOException {
        if (Format.indent){
            for (int j = 0; j < Format.indentLevel; j++) {
                outStream.writeString(Format.indentString);
            }
        }
    }
}
