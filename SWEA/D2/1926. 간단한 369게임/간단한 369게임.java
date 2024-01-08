import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= N; i++) {
            String current = i + "";
            
            if(current.contains("3") || current.contains("6") || current.contains("9")) {
                for(char c : current.toCharArray()) {
                    if(c == '3' || c == '6' || c == '9') {
                        sb.append("-");
                    }
                }
                sb.append(" ");
            } else {
            	sb.append(current + " ");
            }
        }
            
        System.out.println(sb);
	}
}