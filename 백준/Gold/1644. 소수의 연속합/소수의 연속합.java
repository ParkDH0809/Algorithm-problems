import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.print(getAnswer(getPrime(N), N));
    }

    static ArrayList<Integer> getPrime(int N) {
        boolean[] visited = new boolean[N+1];
        int sqrt = (int) Math.sqrt(N);
        for (int i = 2; i <= sqrt; i++) {
            int current = i + i;
            while (current <= N) {
                visited[current] = true;
                current += i;
            }
        }

        ArrayList<Integer> primes = new ArrayList<>();
        for (int i = 2; i < visited.length; i++) {
            if (!visited[i]) primes.add(i);
        }

        return primes;
    }

    static int getAnswer(ArrayList<Integer> primes, int N) {
        int answer = 0;
        for (int i = primes.size() - 1; i >= 0; i--) {
            int sum = 0;
            for (int j = i; j >= 0; j--) {
                sum += primes.get(j);
                if(sum == N) {
                    answer++;
                    break;
                }

                if(sum > N) break;
            }
        }

        return answer;
    }

}