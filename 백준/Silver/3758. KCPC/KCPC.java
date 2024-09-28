import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 팀 개수
            int k = Integer.parseInt(st.nextToken()); // 문제 개수
            int t = Integer.parseInt(st.nextToken()); // 내 팀
            int m = Integer.parseInt(st.nextToken()); // 로그 개수

            Team[] teams = new Team[n + 1];
            for (int i = 1; i <= n; i++) {
                teams[i] = new Team(i);
            }

            for (int submission = 0; submission < m; submission++) {
                st = new StringTokenizer(br.readLine());
                int i = Integer.parseInt(st.nextToken()); // 팀 ID
                int j = Integer.parseInt(st.nextToken()); // 문제 번호
                int s = Integer.parseInt(st.nextToken()); // 점수
                teams[i].solve(j, s, submission);
            }

            int rank = 1;
            int myScore = teams[t].getTotalScore();
            int myTotalSubmission = teams[t].totalSubmission;
            int myLastSubmission = teams[t].lastSubmission;
            for (int i = 1; i <= n; i++) {
                if (i == t) {
                    continue;
                }

                if (myScore != teams[i].getTotalScore()) {
                    if (myScore < teams[i].getTotalScore()) {
                        rank++;
                    }
                    continue;
                }

                if (myTotalSubmission != teams[i].totalSubmission) {
                    if (myTotalSubmission > teams[i].totalSubmission) {
                        rank++;
                    }
                    continue;
                }

                if (myLastSubmission > teams[i].lastSubmission) {
                    rank++;
                }
            }

            sb.append(rank).append("\n");
        }

        System.out.print(sb);
    }

}

class Team {

    int id;
    int totalSubmission;
    int lastSubmission;
    Map<Integer, Integer> solved;

    Team(int id) {
        this.lastSubmission = 99999;
        this.id = id;
        solved = new HashMap<>();
    }

    void solve(int qNumber, int score, int lastSubmission) {
        this.lastSubmission = lastSubmission;
        totalSubmission++;
        if (solved.containsKey(qNumber)) {
            solved.put(qNumber, Math.max(solved.get(qNumber), score));
        } else {
            solved.put(qNumber, score);
        }
    }

    int getTotalScore() {
        int total = 0;
        for (int key : solved.keySet()) {
            total += solved.get(key);
        }
        return total;
    }

}