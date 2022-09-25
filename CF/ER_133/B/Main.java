import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int cases = Integer.parseInt(input[0]);
        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < cases; tc++) {
            int n = Integer.parseInt(br.readLine());
            sb.append("" + n + "\n");
            int[] p = new int[n];
            for (int i = 0; i < n; i++)
                p[i] = i + 1;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    sb.append("" + p[j] + " ");
                }
                sb.append("\n");
                if (i == n - 1)
                    break;

                int t = p[i];
                p[i] = p[i + 1];
                p[i + 1] = t;
            }
        }
        System.out.println(sb.toString());
    }
}