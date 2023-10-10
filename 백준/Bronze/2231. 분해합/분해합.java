import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int inputNum = Integer.parseInt(br.readLine());
        boolean check = false;
        
        for(int i = 0; i < inputNum; i++) {
            if(isCorrect(i, inputNum)) {
                System.out.println(i);
                check = true;
                break;
            }
        }
        
        if(!check) {
            System.out.println(0);
        }
    }
        
    public static boolean isCorrect(int i, int inputNum) {
        String s = String.valueOf(i);
        int result = 0;
        
        for(char c : s.toCharArray()) {
            result += c - '0';
        }
        
        if(result + i == inputNum) {
            return true;
        }
        
        return false;
    }
}