import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int[] c = new int[m];
        input = br.readLine().split(" ");
        for (int i = 0; i < m; i++)
            c[i] = Integer.parseInt(input[i]);

        SegmentTree st = new SegmentTree(c);
        int q = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int qn = 0; qn < q; qn++) {
            input = br.readLine().split(" ");
            int xs = Integer.parseInt(input[0]) - 1;
            int ys = Integer.parseInt(input[1]) - 1;
            int xf = Integer.parseInt(input[2]) - 1;
            int yf = Integer.parseInt(input[3]) - 1;
            int k = Integer.parseInt(input[4]);
            if ((xf - xs) % k != 0 || (ys - yf) % k != 0) {
                sb.append("NO\n");
                continue;
            }

            int mod = (n - xs - 1) / k;
            int x = (k * mod) + xs;
            int rsq = ys <= yf ? st.rsq(ys, yf) : st.rsq(yf, ys);
            sb.append(rsq > x ? "NO\n" : "YES\n");
        }
        System.out.print(sb.toString());

    }
}

// Segment Tree code from CP3
// Updated by Ronald Rojas
// Usage: Find Range Sum Queries and Update ranges in Log(n) time.
class SegmentTreeMax { // the segment tree is stored like a heap array
    private int[] st, A;
    private int n;

    private int left(int p) {
        return p << 1;
    } // same as binary heap operations

    private int right(int p) {
        return (p << 1) + 1;
    }

    private void build(int p, int L, int R) {
        if (L == R) // as L == R, either one is fine
            st[p] = A[L]; // store the index
        else { // recursively compute the values
            build(left(p), L, (L + R) / 2);
            build(right(p), (L + R) / 2 + 1, R);
            int p1 = st[left(p)], p2 = st[right(p)];
            st[p] = Math.max(p1, p2);
        }
    }

    private int rsq(int p, int L, int R, int i, int j) { // O(log n)
        if (i > R || j < L)
            return -1; // current segment outside query range
        if (L >= i && R <= j)
            return st[p]; // inside query range

        // update children
        // compute the min position in the left and right part of the interval
        int p1 = rsq(left(p), L, (L + R) / 2, i, j);
        int p2 = rsq(right(p), (L + R) / 2 + 1, R, i, j);

        if (p1 == -1)
            return p2; // if we try to access segment outside query
        if (p2 == -1)
            return p1; // same as above
        return Math.max(p1, p2);
    }

    private int update(int p, int L, int R, int idx, int idz, int new_value) {
        int i = idx, j = idz;

        // if the current interval does not intersect
        // the update interval, return this st node value!
        if (i > R || j < L)
            return st[p];

        // if the current interval is included in the update range,
        // update that st[node]

        if (i == R && j == L)
            return st[p] = new_value;

        // update children

        // compute the range in the
        // left and right part of the interval
        int p1, p2;
        p1 = update(left(p), L, (L + R) / 2, idx, idz, new_value);
        p2 = update(right(p), (L + R) / 2 + 1, R, idx, idz, new_value);

        // return the sum
        return st[p] = Math.max(p1, p2);
    }

    // Update Children to correct values
    private void prop(int p, int L, int R) {
        int r = (R - L) + 1;
        int lr = (L + R) / 2; // left range
        lr -= L;
        lr++;
        int rr = R; // right range
        rr -= ((L + R) / 2 + 1);
        rr++;

        int left = left(p);
        int right = right(p);
        if (st[p] == 0) {
            st[left] = 0;
            st[right] = 0;
        } else if (st[p] == r) {
            st[left] = lr;
            st[right] = rr;

        }
    }

    public SegmentTree(int[] _A) {
        A = _A;
        n = A.length; // copy content for local usage
        st = new int[4 * n];
        for (int i = 0; i < 4 * n; i++)
            st[i] = 0; // create vector with length `len' and fill it with zeroes
        build(1, 0, n - 1); // recursive build
    }

    public int rsq(int i, int j) {
        return rsq(1, 0, n - 1, i, j);
    } // overloading

    public int update_range(int idx, int idz, int new_value) {
        return update(1, 0, n - 1, idx, idz, new_value);
    }

    public int update_point(int idx, int new_value) {
        return update(1, 0, n - 1, idx, idx, new_value);
    }

}