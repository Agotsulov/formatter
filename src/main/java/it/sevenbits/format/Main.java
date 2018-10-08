package it.sevenbits.format;

import it.sevenbits.format.formatter.Format;
import it.sevenbits.format.formatter.FormatSettings;
import it.sevenbits.format.streams.InStream;
import it.sevenbits.format.streams.OutStream;
import it.sevenbits.format.streams.file.FileInStream;
import it.sevenbits.format.streams.file.FileOutStream;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException, IllegalAccessException, InstantiationException, ClassNotFoundException {
        String nameFileIn = args[0];
        String nameFileOut = args[1];
        String nameFileSettings = args[2];
        String nameFileJson = args[3];

        InStream fr = new FileInStream(nameFileIn);
        OutStream fw = new FileOutStream(nameFileOut);
        FormatSettings formatSettings = new FormatSettings(nameFileSettings, nameFileJson);

        Format.format(fr, fw, formatSettings);

        fw.close();
    }
}
