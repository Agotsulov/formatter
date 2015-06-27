package it.sevenbits.format.tests;

import it.sevenbits.format.formatter.Format;
import it.sevenbits.format.formatter.FormatSettings;
import it.sevenbits.format.streams.InStream;
import it.sevenbits.format.streams.OutStream;
import it.sevenbits.format.streams.string.StringInStream;
import it.sevenbits.format.streams.string.StringOutStream;
import org.junit.*;

import java.io.IOException;

import static org.junit.Assert.assertEquals;


public class FormatTest {

    @Test
    public void emptyStringTest() throws IOException {
        InStream sr = new StringInStream("");
        OutStream sw = new StringOutStream();
        FormatSettings formatSettings = new FormatSettings();

        Format.format(sr, sw ,formatSettings);

        assertEquals("", sw.getString());
    }

    @Test
    public void testNextString() throws IOException {
        InStream sr = new StringInStream("asd;");
        OutStream sw = new StringOutStream();
        FormatSettings formatSettings = new FormatSettings();

        Format.format(sr, sw, formatSettings);

        assertEquals("asd;\n", sw.getString());
    }

    @Test
    public void testIndent() throws IOException {
        InStream sr = new StringInStream("{asd; }");
        OutStream sw = new StringOutStream();

        FormatSettings formatSettings = new FormatSettings();

        Format.format(sr, sw, formatSettings);

        assertEquals("{\n    asd;\n}\n", sw.getString());
    }



    @Test
    public void testIndentLevel() throws IOException {
        InStream sr = new StringInStream("{{asd; }}");
        OutStream sw = new StringOutStream();

        FormatSettings formatSettings = new FormatSettings();

        Format.format(sr, sw, formatSettings);

        assertEquals("{\n    {\n        asd;\n    }\n\n}\n", sw.getString());
    }



    @Test
    public void testExtraLines() throws IOException {
        InStream sr = new StringInStream("a\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "b\n" +
                "\n" +
                "\n" +
                "\n" +
                "s");
        OutStream sw = new StringOutStream();

        FormatSettings formatSettings = new FormatSettings();

        Format.format(sr, sw, formatSettings);

        assertEquals("abs", sw.getString());
    }


    @Test
    public void testExtraSpaces() throws IOException {
        InStream sr = new StringInStream("    df;");
        OutStream sw = new StringOutStream();

        FormatSettings formatSettings = new FormatSettings();

        Format.format(sr, sw, formatSettings);

        assertEquals("df;\n", sw.getString());
    }
}
