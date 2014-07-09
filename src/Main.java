import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
        String nameFileIn = args[0];
        String nameFileOut = args[1];

        InStream fr = new FileInStream(nameFileIn);
        OutStream fw = new FileOutStream(nameFileOut);

        Format.format(fr, fw);
        if(FormatTest.test("123;()","123;\n (  ) ") == false){
            System.out.print("False");
        }else{
            System.out.print("True");
        }
        fw.close();
 	}
}
