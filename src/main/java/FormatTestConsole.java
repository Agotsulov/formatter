import java.io.IOException;

public class FormatTestConsole {
    public static boolean test(String falseString, String trueString) throws IOException{
        InStream sr = new StringInStream(falseString);
        OutStream sw = new StringOutStream();

        Format.format(sr,sw);

        if(trueString.equals(sw.getString()) ){
            return true;
        }else{
            System.out.print("Error: " + "Invalid string:"+falseString + " Correct string:"+trueString+"\n");
            return false;
        }
    }

    public static boolean testEmptyString() throws IOException {
        return test("", "");
    }

    public static boolean testRightBraces() throws IOException {
        return test("{abs}", "{\n    abs\n}\n");
    }

    public static boolean test1() throws IOException {
        return test("abs;", "abs;\n");
    }



    public static void allTests() throws IOException{
        int error = 0;
        if(testEmptyString() == false){
            error += 1;
        }

        if(testRightBraces() == false){
            error += 1;
        }

        if(test1() == false){
            error += 1;
        }

        System.out.print("Error: "+error+"\n");
    }
}