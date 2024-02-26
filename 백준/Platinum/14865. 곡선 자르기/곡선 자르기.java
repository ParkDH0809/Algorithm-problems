import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		
		boolean flag = false;
		int minX = Integer.MAX_VALUE;
		int maxX = Integer.MIN_VALUE;
		int maxY = Integer.MIN_VALUE;
		
		Queue<int[]> queue = new ArrayDeque<>();
		int moreN = 0;
		boolean first = true;
		for(int i = 0; i < N + moreN; i++) {
			int x;
			int y;
			if(i < N) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
			} else {
				int[] tmp = queue.poll();
				x = tmp[0];
				y = tmp[1];
			}
			
			if(first) {
				moreN++;
				if(y > 0) {
					queue.add(new int[] {x, y});
					continue;
				}
				
				if(y < 0) {
					queue.add(new int[] {x, y});
					first = false;
					continue;
				}
			}
			
			if(y < 0 && !flag) {
				continue;
			}
			
			if(x < minX) {
				minX = x;
			}
			
			if(x > maxX) {
				maxX = x;
			}
			
			if(y > maxY) {
				maxY = y;
				flag = true;
			}
			
			if(y < 0) {
				pq.add(new int[] {minX, maxY});
				pq.add(new int[] {maxX, maxY});
				flag = false;
				minX = Integer.MAX_VALUE;
				maxX = Integer.MIN_VALUE;
				maxY = Integer.MIN_VALUE;
			}
		}
		
		
		
		if(pq.isEmpty()) {
			System.out.println("0 0");
			return;
		}
		
		int large = 0;
		int small = 0;
		int beforeNumber = 0;
		Stack<Integer> stack = new Stack<>();
		while(!pq.isEmpty()) {
			int[] firstPoint = pq.poll();
			boolean isAlone = true;
			
			stack.add(firstPoint[1]);
			beforeNumber = stack.peek();
			while(true) {
				int[] point = pq.poll();
				
				//한 봉우리가 끝난 경우
				if(stack.peek() == point[1]) {
					stack.pop();
					if(stack.size() == 0) {
						large++;
						if(isAlone) {
							small++;
						}
						break;
					}
					
					if(beforeNumber == point[1]) {
						small++;
					}
					
					continue;
				}
				
				isAlone = false;
				stack.add(point[1]);
				beforeNumber = point[1];
			}
			
		}
		
		sb.append(large).append(" ").append(small);
		System.out.println(sb);
	}
	
}
