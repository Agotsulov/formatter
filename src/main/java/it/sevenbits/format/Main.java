package it.sevenbits.format;

import it.sevenbits.format.formatter.Format;
import it.sevenbits.format.formatter.Format2;
import it.sevenbits.format.formatter.FormatSettings;
import it.sevenbits.format.streams.InStream;
import it.sevenbits.format.streams.OutStream;
import it.sevenbits.format.streams.file.FileInStream;
import it.sevenbits.format.streams.file.FileOutStream;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        String nameFileIn = args[0];
        String nameFileOut = args[1];
        InStream fr = new FileInStream(nameFileIn);
        OutStream fw = new FileOutStream(nameFileOut);
        FormatSettings formatSettings = new FormatSettings("formatter.properties");


        //Format.format(fr, fw, formatSettings);
        Format2.format(fr ,fw, formatSettings);
        //FormatTestConsole.allTests();

        fw.close();
    }
}
