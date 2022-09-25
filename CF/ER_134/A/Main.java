import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int tests = Integer.parseInt(input[0]);
        for (int tc = 0; tc < tests; tc++) {
            String s = br.readLine() + br.readLine();
            HashSet<Character> map = new HashSet<>();
            for( int i = 0; i < s.length(); i++){
                map.add(s.charAt(i));
            }
            switch (map.size()) {
                case 1:
                System.out.println(0);
                    break;
                case 2:
                System.out.println(1);
                    break;
                case 3:
                System.out.println(2);
                    break;
                case 4:
                System.out.println(3);
                    break;
                default:
                    break;
            }

        }
    }
}
