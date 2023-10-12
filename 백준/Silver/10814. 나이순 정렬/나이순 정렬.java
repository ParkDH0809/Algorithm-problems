import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        Member[] arr = new Member[N];
        
        StringTokenizer st;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            arr[i] = new Member(Integer.parseInt(st.nextToken()), st.nextToken());
        }
        
        Arrays.sort(arr, new Comparator<Member>() {
            @Override
            public int compare(Member m1, Member m2) {
                return m1.age - m2.age;
            }
        });
        
        for(int i = 0; i < N; i++) {
            bw.append(arr[i].toString() + "\n");
        }
        bw.close();
    }
}

class Member {
    int age;
    String name;
    
    Member(int age, String name) {
        this.age = age;
        this.name = name;
    }
    
    public String toString() {
        return age + " " + name;
    }
}