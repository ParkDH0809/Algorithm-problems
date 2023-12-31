import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
        String s = br.readLine();
        int answer = 0;
        for(char c : s.toCharArray())
            answer += c - '0';
        
        bw.append(answer + "");
        bw.flush();
	}
}