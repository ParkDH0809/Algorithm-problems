import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        
        char[] input = br.readLine().toCharArray();
        int answer = -1;
        boolean isEnd = false;
        while(!isEnd) {
            isEnd = true;
            boolean[] number = new boolean[10];
            for(int i = 0; i < input.length; i++) {
                if(input[i] == 'e') {
                    continue;
                }

                isEnd = false;
                if(input[i] == '6' || input[i] == '9') {
                    if(!number[6]) {
                        number[6] = true;
                        input[i] = 'e';
                    } else if(!number[9]) {
                        number[9] = true;
                        input[i] = 'e';
                    }
                } else {
                    if(number[input[i] - '0']) {
                        continue;
                    } else {
                        number[input[i] - '0'] = true;
                        input[i] = 'e';
                    }
                }
            }
            answer++;
        }

        System.out.println(answer);
    }
}