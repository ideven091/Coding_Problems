package com.cleo.revision.dataStructures;
import java.io.*;
import java.util.*;

public class MagicSquare {

    // Complete the formingMagicSquare function below.

    /**
     *
     * @param s a misformed matrix of integers
     * @return the minimum sum of converting the matrix to magic square for any given input of matrices
     * where the
     */
    static int formingMagicSquare(int[][] s) {

        return 0;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] s = new int[3][3];

        for (int i = 0; i < 3; i++) {
            String[] sRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int sItem = Integer.parseInt(sRowItems[j]);
                s[i][j] = sItem;
            }
        }

        int result = formingMagicSquare(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
