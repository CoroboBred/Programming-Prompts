import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int tests = Integer.parseInt(input[0]);
        for (int tc = 0; tc < tests; tc++) {
            input = br.readLine().split(" ");
            long hc = Long.parseLong(input[0]);
            long dc = Long.parseLong(input[1]);
            input = br.readLine().split(" ");
            long hm = Long.parseLong(input[0]);
            long dm = Long.parseLong(input[1]);
            input = br.readLine().split(" ");
            long k = Long.parseLong(input[0]);
            long w = Long.parseLong(input[1]);
            long a = Long.parseLong(input[2]);

            boolean found = false;
            for (int i = 0; i <= k; i++) {
                long hc2 = hc + (a * i);
                long dc2 = dc + (w * (k - i));

                long tk = hm / dc2;
                if (hm % dc2 != 0)
                    tk++;
                long td = hc2 / dm;
                if (hc2 % dm != 0)
                    td++;

                if (tk <= td) {
                    found = true;
                    break;
                }
            }
            System.out.println(found ? "YES" : "NO");
        }
    }
}

/**
 * ceil is considered
 * hm/dc= tc, turns to kill
 * hc/dm = tm , turns to get killed
 * 
 * Yes if hm/dc > hc/dm, you win if you kill before killed
 */