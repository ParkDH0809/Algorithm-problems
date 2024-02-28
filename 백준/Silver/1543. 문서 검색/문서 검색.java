import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        char[] document = br.readLine().toCharArray();
        char[] search = br.readLine().toCharArray();
        
        int answer = 0;
        
        for(int i = 0; i < document.length; i++) {
            boolean isAnswer = true;
            if(document[i] == search[0] && i + search.length <= document.length) {
                for(int j = 0; j < search.length; j++) {
                    if(document[i+j] != search[j]) {
                        isAnswer = false;
                        break;
                    }
                }

                if(isAnswer) {
                    answer++;
                    i += search.length-1;
                }
            }
        }
        System.out.println(answer);
    }
} 