import java.io.IOException;

public class FormatTest {
    public static boolean test(String falseString, String trueString) throws IOException{
        InStream sr = new StringInStream(falseString);
        OutStream sw = new StringOutStream();

        Format.format(sr,sw);

        if(trueString.equals(sw.getString()) ){
            return true;
        }else{
            return false;
        }
    }

    public static boolean testEmptyString() throws IOException {
        return test("", "");
    }


    public static boolean testRightBraces() throws IOException {
        return test("{abs}", "{\n    abs\n}\n");
    }
}