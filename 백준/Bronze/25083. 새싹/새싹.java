import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        bw.append(
            "         ,r'\"7\n"
            + "r`-_   ,'  ,/\n"
            + " \\. \". L_r'\n"
            + "   `~\\/\n"
            + "      |\n"
            + "      |");
        
        bw.close();
    }
}