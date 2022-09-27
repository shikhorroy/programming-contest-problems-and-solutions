package main.java.chapter01.timus;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Roy
 */
public class Timus1001ReverseRoot {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        ReverseRoot solver = new ReverseRoot();
        solver.solve(1, in, out);
        out.close();
    }

    static class ReverseRoot {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            //~~️Keep the Dreams Alive in Your Heart ❤️~~//
            List<Long> list = new ArrayList<>();
            while (true) {
                try {
                    list.add(in.readLong());
                } catch (InputMismatchException ignored) {
                    for (int i = list.size() - 1; i >= 0; --i) {
                        out.printLine(Math.sqrt(list.get(i)));
                    }
                    return;
                }
            }
        }
    }

    static class InputReader {
        private int curChar;
        private int numChars;
        private InputReader.SpaceCharFilter filter;
        private final InputStream stream;
        private final byte[] buf = new byte[1024];

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        private long readWholeNumber(int c) {
            long res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res;
        }

        public int read() {
            if (numChars == -1) {
                throw new InputMismatchException();
            }
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);

                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buf[curChar++];
        }

        public long readLong() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = readWholeNumber(c);
            return res * sgn;
        }

        public boolean isSpaceChar(int c) {
            if (filter != null) {
                return filter.isSpaceChar(c);
            }
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public interface SpaceCharFilter {
            boolean isSpaceChar(int ch);

        }

    }

    static class OutputWriter {
        private final PrintWriter writer;

        public OutputWriter(OutputStream outputStream) {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }

        public OutputWriter(Writer writer) {
            this.writer = new PrintWriter(writer);
        }

        public void print(Object... objects) {
            for (int i = 0; i < objects.length; i++) {
                if (i != 0) {
                    writer.print(' ');
                }
                writer.print(objects[i]);
            }
        }

        public void printLine(Object... objects) {
            this.print(objects);
            writer.println();
        }

        public void close() {
            writer.flush();
            writer.close();
        }

    }
}
