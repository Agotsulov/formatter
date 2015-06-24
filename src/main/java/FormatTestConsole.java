import java.io.IOException;

public class FormatTestConsole {
    public static boolean test(String falseString, String trueString) throws IOException{
        InStream sr = new StringInStream(falseString);
        OutStream sw = new StringOutStream();

        Format.format(sr,sw);

        if(trueString.equals(sw.getString())){
            return true;
        }else{
            System.out.print("Error: " + "Invalid string:" + falseString + " Correct string:"+trueString+"\n");
            System.out.print("Error: " + "Getting string:" + sw.getString() + "\n");
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

    public static boolean test2() throws IOException {
        return test("{abs;}", "{\n    abs;\n}\n");
    }

    public static boolean testPlus() throws IOException {
        return test("a+s", "a + s");
    }

    public static boolean testMinus() throws IOException {
        return test("a-s", "a - s");
    }

    public static boolean testBrackets() throws IOException {
        return test("abs()", "abs (  ) ");
    }

    public static boolean testIs() throws IOException {
        return test("a=b", "a = b");
    }

    public static boolean testExtraSpaces() throws IOException {
        return test("                  abs", "abs");
    }

    public static boolean testExtraLines() throws IOException{
        return test("a\n\n\n\n\nb\n\n\n\ns","abs");
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
        if(test2() == false){
            error += 1;
        }
        if(testPlus() == false){
            error += 1;
        }
        if(testMinus() == false){
            error += 1;
        }
        if(testBrackets() == false){
            error += 1;
        }
        if(testIs() == false){
            error += 1;
        }
        if(testExtraLines() == false){
            error += 1;
        }
        if(testExtraSpaces() == false){
            error += 1;
        }
        System.out.print("Error: "+error+"\n");
    }
}