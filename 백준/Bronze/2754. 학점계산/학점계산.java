import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        switch(br.readLine()) {
            case "A+":
                bw.append("4.3");
                break;
            case "A0":
                bw.append("4.0");
                break;
            case "A-":
                bw.append("3.7");
                break;
            case "B+":
                bw.append("3.3");
                break;
            case "B0":
                bw.append("3.0");
                break;
            case "B-":
                bw.append("2.7");
                break;
            case "C+":
                bw.append("2.3");
                break;
            case "C0":
                bw.append("2.0");
                break;
            case "C-":
                bw.append("1.7");
                break;
            case "D+":
                bw.append("1.3");
                break;
            case "D0":
                bw.append("1.0");
                break;
            case "D-":
                bw.append("0.7");
                break;
            case "F":
                bw.append("0.0");
                break;
        }
        bw.flush();
    }
}