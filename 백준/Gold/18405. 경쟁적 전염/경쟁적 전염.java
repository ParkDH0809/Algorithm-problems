import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Queue<Virus> queue = new ArrayDeque<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				int current = Integer.parseInt(st.nextToken());
				
				if(current == 0) {
					continue;
				}
				
				queue.add(new Virus(r, c, current));
			}
		}
		
		
		st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken())-1;
		int c = Integer.parseInt(st.nextToken())-1;
		
		PriorityQueue<Virus> pq = new PriorityQueue<>();
		while(!queue.isEmpty()) {
			Virus virus = queue.poll();
			virus.setDistance(r, c);
			pq.add(virus);
		}
		
		Virus virus = pq.poll();
		if(virus.distance <= t) {
			System.out.println(virus.value);
		} else {
			System.out.println(0);
		}
	}
}


class Virus implements Comparable<Virus> {
	
	int r;
	int c;
	int value;
	int distance;
	
	public Virus(int r, int c, int value) {
		this.r = r;
		this.c = c;
		this.value = value;
	}
	
	void setDistance(int r, int c) {
		distance = Math.abs(r - this.r) + Math.abs(c - this.c);
	}
	
	@Override
	public int compareTo(Virus o) {
		if(distance != o.distance) {
			return distance - o.distance;
		}
		return value - o.value;
	}
}