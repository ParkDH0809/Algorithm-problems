import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		PriorityQueue<Request> pq = new PriorityQueue<>();
		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			pq.add(new Request(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		int[] values = new int[10001];
		while(!pq.isEmpty()) {
			Request current = pq.poll();
			
			for(int i = current.d; i > 0; i--) {
				if(values[i] == 0) {
					values[i] = current.p;
					break;
				}
			}
		}
		
		System.out.println(getAnswer(values));
	}
	
	static int getAnswer(int[] values) {
		int answer = 0;
		for(int i = 1; i < values.length; i++) {
			answer += values[i];
		}
		return answer;
	}

}

class Request implements Comparable<Request> {
	
	int p;
	int d;
	
	public Request(int p, int d) {
		this.p = p;
		this.d = d;
	}
	
	@Override
	public int compareTo(Request o) {
		if(p != o.p) {
			return o.p - p;
		}
		return o.d - d;
	}
}