import org.junit.*;

import java.io.IOException;

import static org.junit.Assert.assertEquals;


public class FormatTest {

    @Test
    public void emptyStringTest() throws IOException {
        InStream sr = new StringInStream("");
        OutStream sw = new StringOutStream();

        Format.format(sr, sw);

        assertEquals("", sw.getString());
    }
}
