import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static int size;
	static String s1;
	static String s2;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		size = Integer.parseInt(br.readLine());
		s1 = br.readLine();
		s2 = br.readLine();

		if (first() && second() && third()) {
			System.out.print("YES");
		} else {
			System.out.print("NO");
		}
	}

	static boolean first() {
		return (s1.charAt(0) == s2.charAt(0)) && (s1.charAt(size - 1) == s2.charAt(size - 1));
	}

	static boolean second() {
		int[] arr = new int[26];
		for (int i = 0; i < size; i++) {
			arr[s1.charAt(i) - 'a']++;
			arr[s2.charAt(i) - 'a']--;
		}

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) {
				return false;
			}
		}
		return true;
	}

	static boolean third() {
		char[] s1Arr = new char[size];
		char[] s2Arr = new char[size];
		int s1Count = 0;
		int s2Count = 0;

		for (int i = 0; i < size; i++) {
			if (isConsonant(s1.charAt(i))) {
				s1Arr[s1Count++] = s1.charAt(i);
			}

			if (isConsonant(s2.charAt(i))) {
				s2Arr[s2Count++] = s2.charAt(i);
			}
		}

		if (s1Count != s2Count) {
			return false;
		}

		for (int i = 0; i < s1Count; i++) {
			if (s1Arr[i] != s2Arr[i]) {
				return false;
			}
		}

		return true;
	}

	static boolean isConsonant(char c) {
		return c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u';
	}

}