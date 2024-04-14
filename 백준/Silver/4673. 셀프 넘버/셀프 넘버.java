public class Main {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        
        boolean[] arr = new boolean[10001];
       
        int number = 1;
        while(number < 10000) {
            int current = number;
            int result = current;
            
            while(current != 0) {
                result += current % 10;
                current /= 10;
            }

            if(result <= 10000) {
                arr[result] = true;
            }
            
            number++;
        }

        for(int i = 1; i <= 10000; i++) {
            if(!arr[i]) {
                sb.append(i).append("\n");
            }
        }

        System.out.print(sb);
    }
}