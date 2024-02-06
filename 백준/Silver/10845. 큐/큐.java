import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		Queue queue = new Queue();
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			switch(st.nextToken()) {
			case "push": 
				queue.enque(Integer.parseInt(st.nextToken()));
				break;
				
			case "pop":
				sb.append(queue.deque() + "\n");
				break;
				
			case "front":
				sb.append(queue.getFirst() + "\n");
				break;
				
			case "back":
				sb.append(queue.getLast() + "\n");
				break;
				
			case "empty":
				if(queue.isEmpty()) {
					sb.append("1\n");
				} else {
					sb.append("0\n");
				}
				break;
				
			case "size":
				sb.append(queue.size() + "\n");
				break;
			}
		}
		System.out.println(sb);
	}
	
}


class Node {
	
	Node beforeNode;
	Node afterNode;
	int value;
	
	Node(int value) {
		this.value = value;
		this.beforeNode = null;
		this.afterNode = null;
	}
}


class Queue {
	
	private Node firstNode;
	private Node lastNode;
	private int size;
	
	public Queue() {
		firstNode = null;
		lastNode = null;
		size = 0;
	}
	
	
	public boolean isEmpty() {
		return size == 0 ? true : false;
	}
	
	
	public int size() {
		return size;
	}
	
	
	public int getFirst() {
		if(isEmpty()) {
			return -1;
		}
		return firstNode.value;
	}
	

	public int getLast() {
		if(isEmpty()) {
			return -1;
		}
		
		return lastNode.value;
	}
	
	
	public void enque(int input) {
		if(isEmpty()) {
			firstNode = lastNode = new Node(input);
			size++;
			return;
		}
		
		lastNode.afterNode = new Node(input);
		lastNode.afterNode.beforeNode = lastNode;
		lastNode = lastNode.afterNode;
		size++;
	}
	
	
	public int deque() {
		if(isEmpty()) {
			return -1;
		}
		
		Node tmp = firstNode;
		if(size == 1) {
			firstNode = lastNode = null;
		} else {
			firstNode.afterNode.beforeNode = null;
			firstNode = firstNode.afterNode;
			tmp.afterNode = null;
		}
		size--;
		return tmp.value;
	}
	
}