import java.io.*;

public class Main {

    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();

        String input = br.readLine();
        int[] arr = new int[26];
        for(char c : input.toCharArray()) 
            arr[c - 'A']++;
        

        if(canMakeAnswer(arr)) {
            answer.append(makeFront(arr));
            answer.append(getMidCharacter(arr));
            answer.append(makeBack(arr));
        } else {
            answer.append("I'm Sorry Hansoo");
        }

        System.out.println(answer);
    }

    static boolean canMakeAnswer(int[] arr) {
        int count = 0;
        for(int i = 0; i < 26; i++)
            if(arr[i] % 2 == 1)
                count++;
            
        if(count > 1)
            return false;
        return true;
    }

    static StringBuilder makeFront(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 26; i++) {
            if(arr[i] == 0)
                continue;

            for(int j = 0; j < arr[i]/2; j++) {
                sb.append((char)('A' + i));
            }
        }
        return sb;
    }

    static String getMidCharacter(int[] arr) {
        for(int i = 0; i < 26; i++) 
            if(arr[i] % 2 == 1)
                return (char)('A' + i) + "";
        
        return "";
    }

    static StringBuilder makeBack(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for(int i = 25; i >= 0; i--) {
            if(arr[i] == 0)
                continue;

            for(int j = 0; j < arr[i]/2; j++) {
                sb.append((char)('A' + i));
            }
        }
        return sb;
    }
}