import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int tests = Integer.parseInt(input[0]);
        for (int tc = 0; tc < tests; tc++) {
            char[] s = br.readLine().toCharArray();
            int l = 0;
            int r = 0;
            int q = 0;
            for (int i = 0; i < s.length; i++) {
                switch (s[i]) {
                    case '(':
                        l++;
                        break;
                    case ')':
                        r++;
                        break;
                    case '?':
                        q++;
                }
            }

            int fl = 0;
            int fr = 0;
            if (l - r > 0) {
                fr += l - r;
                q -= (l - r);
            } else {
                fl += r - l;
                q -= (r - l);
            }
            q /= 2;
            fl += q;
            fr += q;

            int b = 0;
            boolean start = false;
            boolean found = false;
            for (int i = 0; i < s.length; i++) {
                if (s[i] == '?') {
                    if (fl > 1) {
                        fl--;
                        b++;
                    } else if (fl == 1) {
                        fl--;
                        b++;
                        if (b < 2)
                            break;
                        start = true;

                    } else {
                        if (start)
                            found = true;
                        break;
                    }
                } else if (s[i] == '(') {
                    b++;
                } else {
                    b--;
                    if (start && b < 2)
                        break;
                }
            }
            System.out.println(found ? "NO" : "YES");
        }
    }
}
