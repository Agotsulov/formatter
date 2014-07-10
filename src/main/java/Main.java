import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
        String nameFileIn = args[0];
        String nameFileOut = args[1];

        InStream fr = new FileInStream(nameFileIn);
        OutStream fw = new FileOutStream(nameFileOut);

        Format.format(fr, fw);
        FormatTestConsole.allTests();

        fw.close();
 	}
}
