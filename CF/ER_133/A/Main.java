import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int cases = Integer.parseInt(input[0]);

        for (int tc = 0; tc < cases; tc++) {
            int n = Integer.parseInt(br.readLine());
            if (n == 1) {
                System.out.println(2);
                continue;
            }
            int ans = n / 3;
            int mod = n % 3;
            if (mod == 2 || mod == 1)
                ans++;
            System.out.println(ans);
        }
    }
}