import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String input = br.readLine();
        int answer = 0;
        boolean flag = false;
        char first = input.charAt(0);
        for(int i = 0; i < input.length(); i++) {
            if(!flag && first != input.charAt(i)) {
                answer++;
                flag = true;
            }

            if(flag && first == input.charAt(i)) {
                flag = false;
            }
        }

        System.out.println(answer);
    }
} 