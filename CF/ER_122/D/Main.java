import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int tests = Integer.parseInt(input[0]);
        int[] a = new int[1001];
        for (int i = 0; i < a.length; i++)
            a[i] = Integer.MAX_VALUE;
        a[1] = 0;
        for (int i = 1; i < a.length; i++) {
            for (int j = 1; j <= i; j++) {
                int div = i / j;
                if (div + i < a.length)
                    a[div + i] = Math.min(a[i] + 1, a[div + i]);
            }
        }
        for (int tc = 0; tc < tests; tc++) {
            input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int k = Integer.parseInt(input[1]);

            int[] b = new int[n];
            int[] c = new int[n];
            input = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                b[i] = Integer.parseInt(input[i]);
            }

            input = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                c[i] = Integer.parseInt(input[i]);
            }

            int[][] dp = new int[2][k + 1];
            int sum = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j <= k && j <= sum; j++) {
                    if (j + a[b[i]] <= k)
                        dp[1][j + a[b[i]]] = Math.max(dp[0][j] + c[i], dp[1][j + a[b[i]]]);
                    dp[1][j] = Math.max(dp[0][j], dp[1][j]);
                }
                sum += a[b[i]];
                int[] tmp = dp[0];
                dp[0] = dp[1];
                dp[1] = tmp;
            }

            int max = 0;
            for (int i = 0; i <= k; i++) {
                // System.out.println(dp[n][i]);
                max = Math.max(max, dp[0][i]);
            }

            System.out.println(max);

        }
    }
}