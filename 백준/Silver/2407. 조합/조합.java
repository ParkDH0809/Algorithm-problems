import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        BigInteger[] memoization = new BigInteger[n+1];
        memoization[0] = BigInteger.ONE;
        memoization[1] = BigInteger.ONE;
        setMemoization(memoization, n);

//        System.out.println(Arrays.toString(memoization));
        System.out.print(memoization[n].divide(memoization[n-m].multiply(memoization[m])));
    }

    private static BigInteger setMemoization(BigInteger[] memoization, int current) {
        if (memoization[current] != null) {
            return memoization[current];
        }

        return memoization[current] = setMemoization(memoization, current-1).multiply(new BigInteger(String.valueOf(current)));
    }

}