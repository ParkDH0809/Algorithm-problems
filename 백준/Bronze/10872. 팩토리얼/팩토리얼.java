import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        switch(br.readLine()) {
            case "0": case "1":
                System.out.print("1");
                break;
            case "2":
                System.out.print("2");
                break;
            case "3":
                System.out.print("6");
                break;
            case "4":
                System.out.print("24");
                break;
            case "5":
                System.out.print("120");
                break;
            case "6":
                System.out.print("720");
                break;
            case "7":
                System.out.print("5040");
                break;
            case "8":
                System.out.print("40320");
                break;
            case "9":
                System.out.print("362880");
                break;
            case "10":
                System.out.print("3628800");
                break;
            case "11":
                System.out.print("39916800");
                break;
            case "12":
                System.out.print("479001600");
                break;
        }
    }
}