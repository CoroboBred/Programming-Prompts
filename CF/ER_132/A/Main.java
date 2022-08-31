import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int tests = Integer.parseInt(input[0]);
        for (int tc = 0; tc < tests; tc++) {
            int k = Integer.parseInt(br.readLine());
            int[] d = new int[3];
            input = br.readLine().split(" ");
            for (int i = 0; i < 3; i++)
                d[i] = Integer.parseInt(input[i]);

            boolean ok = true;
            for (int i = 0; i < 2; i++) {
                k = d[k - 1];
                if (k == 0) {
                    ok = false;
                    break;
                }
            }
            System.out.println(ok ? "YES" : "NO");

        }
    }
}
