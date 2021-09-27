import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

/**
 * Problem solution template.
 */
public final class Part1Task5 {
    private Part1Task5() {
        // Should not be instantiated
    }


    private static void solve(final FastScanner in, final PrintWriter out) {

        Deque<Integer> partsOfExample = new LinkedList<>();

        while (in.hasNext()) {
            String part = in.next();
            switch (part) {
                case "+":
                    partsOfExample.push(partsOfExample.pop() + partsOfExample.pop());
                    break;
                case "-":
                    partsOfExample.push((partsOfExample.pop() - partsOfExample.pop()) * (-1));
                    break;
                case "*":
                    partsOfExample.push(partsOfExample.pop() * partsOfExample.pop());
                    break;
                default:
                    partsOfExample.push(Integer.parseInt(part));
            }
        }
        out.println(partsOfExample.pop());
    }

    private static class FastScanner {
        private final BufferedReader reader;
        private StringTokenizer tokenizer;

        FastScanner(final InputStream in) {
            reader = new BufferedReader(new InputStreamReader(in));
        }

        String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return tokenizer.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        boolean hasNext() {
            if (tokenizer != null) {
                return tokenizer.hasMoreTokens();
            }
            return true;
        }
    }

    public static PrintWriter createPrintWriterForLocalTests() {
        return new PrintWriter(System.out, true);
    }


    public static void main(final String[] arg) {
        final FastScanner in = new FastScanner(System.in);
        try (PrintWriter out = new PrintWriter(System.out)) {
            solve(in, out);
        }
    }
}