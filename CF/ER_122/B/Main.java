import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int tests = Integer.parseInt(input[0]);
        for (int tc = 0; tc < tests; tc++) {
            String line = br.readLine();
            int a = 0;
            int b = 0;
            for (int i = 0; i < line.length(); i++) {
                if (line.charAt(i) == '0')
                    a++;
                else
                    b++;
            }

            if (a != b) {
                System.out.println(Math.min(a, b));
            }else{
                System.out.println(a-1);
            }
        }
    }
}