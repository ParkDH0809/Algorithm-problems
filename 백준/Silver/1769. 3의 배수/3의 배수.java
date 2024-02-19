import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String input = br.readLine();

        int count = 0;
        boolean isTrue = false;
        while(true) {
            if(input.length() <= 1) {
                isTrue = Integer.parseInt(input) % 3 == 0 ? true : false;
                break;
            }

            int sum = 0;
            for(int i = 0; i < input.length(); i++) {
                sum += input.charAt(i) - '0';
            }

            count++;
            input = String.valueOf(sum);
        }

        System.out.println(count);
        if(isTrue) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}