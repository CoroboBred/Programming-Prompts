import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int tc = Integer.parseInt(input[0]);
        for (int tests = 0; tests < tc; tests++) {
            int n = Integer.parseInt(br.readLine());
            while (n % 7 != 0) {
                n++;
                if (n % 10 == 0) {
                    n -= 10;
                }
            }
            System.out.println(n);
        }

    }
}