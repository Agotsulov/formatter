import org.junit.*;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * Created by byzilio on 10.07.14.
 */
public class FormatTest {

    @Test
    public void emptyStringTest() throws IOException {
        InStream sr = new StringInStream("");
        OutStream sw = new StringOutStream();

        Format.format(sr, sw);

        assertEquals("", sw.getString());
    }
}
