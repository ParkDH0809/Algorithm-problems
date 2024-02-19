import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        getAnswer(input);
    }

    public static void getAnswer(String input){
        int count = 0;
        while(true){
            if(input.length()==1) 
                break;

            long sum=0;
            for(int i=0;i< input.length();i++){
                sum+=input.charAt(i) - '0';
            }
            count++;
            input=String.valueOf(sum);
        }

        System.out.println(count);
        if(Long.parseLong((input))%3==0){
            System.out.println("YES");
        }else{
            System.out.print("NO");
        }
    }

}