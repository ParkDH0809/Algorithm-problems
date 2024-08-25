import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Integer> trees = new HashMap<>();
        int number = 0;
        String tree = "";
        while ((tree = br.readLine()) != null && !tree.isEmpty()) {
            trees.put(tree, trees.getOrDefault(tree, 0) + 1);
            number++;
        }

        Queue<Tree> pq = new PriorityQueue<>(new Comparator<Tree>() {
            @Override
            public int compare(Tree o1, Tree o2) {
                return o1.name.compareTo(o2.name);
            }
        });

        for (String treeName : trees.keySet()) {
            pq.add(new Tree(treeName, getRate(number, trees.get(treeName))));
        }

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Tree current = pq.poll();
            sb.append(current.name).append(" ").append(current.rate).append("\n");
        }

        System.out.print(sb);

    }

    static String getRate(int number, int count) {
        return String.format("%.4f", (((count * 100) / (number * 1.0)) * 10000) / 10000.0);
        // return Math.round(((count * 100) / (number * 1.0)) * 10000) / 10000.0;
    }

}

class Tree {

    String name;
    String rate;

    Tree(String name, String rate) {
        this.name = name;
        this.rate = rate;
    }

}