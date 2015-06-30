package it.sevenbits.format.handlers;

import it.sevenbits.format.formatter.Format2;
import it.sevenbits.format.streams.OutStream;

import java.io.IOException;

/**
 * Created by byzilio on 30.06.15.
 */
public interface Handler {
    public boolean canDo(char symbol);
    public void action(OutStream outStream) throws IOException;
}
