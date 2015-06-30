package it.sevenbits.format.formatter;

import java.io.*;
import java.util.Properties;

public class FormatSettings {
    private static final char INDENT_CHAR_DEFAULT = ' ';
    private static final int INDENT_LENGHT_DEFAULT = 4;
    private char indentChar;
    private String indentString = "";
    private int indentLenght;
    private boolean extraBraces;
    private Properties properties;
    public FormatSettings(){
        setDefaultSettings();
    }
    public FormatSettings(final String fileName) throws IOException {
        Reader fileReader;
        fileReader = new FileReader(new File(fileName));
        properties = new Properties();
        properties.load(fileReader);
        indentLenght = Integer.parseInt(properties.getProperty("indentLenght"));
        indentChar = properties.getProperty("indentChar").charAt(1);
        extraBraces = Boolean.parseBoolean(properties.getProperty("extraBraces"));

        setSetting();
    }

    private void  setDefaultSettings() {
        for (int i = 0;i < INDENT_LENGHT_DEFAULT;i++) {
            indentString = indentString + INDENT_CHAR_DEFAULT;
        }
        extraBraces = false;
    }
    private void setSetting(){
        for (int i = 0;i < indentLenght;i++) {
            indentString = indentString + indentChar;
        }
    }
    public String getIndentString (){
        return indentString;
    }
    public boolean getExtraBraces () { return extraBraces; }
}
