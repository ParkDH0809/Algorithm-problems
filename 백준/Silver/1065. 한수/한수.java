import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        for(int i = 1; i <= N; i++) {
            if(isPossible(i)) {
                answer++;
            }
        }
        System.out.println(answer);
    }

    static boolean isPossible(int n) {
        if(n < 10) {
            return true;
        }

        String s = String.valueOf(n);
        int gap = s.charAt(1) - s.charAt(0);
        for(int i = 1; i < s.length() - 1; i++) {
            if(s.charAt(i+1) - s.charAt(i) != gap) {
                return false;
            }
        }

        return true;
    }
} 