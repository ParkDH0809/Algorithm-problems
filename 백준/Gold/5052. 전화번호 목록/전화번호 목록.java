import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            sb.append(isConsistent(br, Integer.parseInt(br.readLine())) ? "YES\n" : "NO\n");
        }
        System.out.print(sb);
    }

    private static boolean isConsistent(BufferedReader br, int n) throws IOException {
        Node root = new Node();
        boolean isYes = true;
        while(n-- > 0) {
            Node node = root;
            boolean isContains = true;
            String s = br.readLine();
            if (!isYes) {
               continue;
            }

            for (int i = 0; i < s.length(); i++) {
                int current = s.charAt(i) - '0';
                if(node.childs[current] == null) {
                    node.childs[current] = new Node();
                    isContains = false;
                }

                if(node.isEnd) {
                    isYes = false;
                    break;
                }

                node = node.childs[current];
            }
            
            node.isEnd = true;
            if(isContains) {
                isYes = false;
            }
        }
        return isYes;
    }

}

class Node {

    Node[] childs;
    boolean isEnd;

    Node() {
        childs = new Node[10];
        isEnd = false;
    }

}