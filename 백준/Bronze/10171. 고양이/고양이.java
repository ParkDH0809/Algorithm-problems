import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        bw.append(
            "\\    /\\\n"
            + " )  ( ')\n"
            + "(  /  )\n"
            + " \\(__)|");
        
        bw.close();
    }
}


