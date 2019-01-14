package string.arraylist;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ZeroMatrix {

    static void transformRowsIn0(int line, int[][]matrix) {
        for (int i=0; i<matrix.length; i++) {
            matrix[line][i]=0;
        }
    }
    static void transformColumnsIn0(int col, int[][]matrix) {
        for (int j=0; j<matrix.length; j++) {
            matrix[j][col] = 0;
        }
    }
    static int[][] transformZeroMatrix(int[][] matrix) {
        int n = matrix.length;
        boolean[] row = new boolean[matrix.length];
        boolean[] column = new boolean[matrix.length];

        for (int i=0; i< matrix.length; i++)    {
            for (int j=0; j<matrix.length; j++) {
                if (matrix[i][j] == 0)  {
                    row[i] = true;
                    column[j] = true;
                }
            }
        }

        for (int line=0; line<row.length; line++)  {
            if (row[line])  {
                transformRowsIn0(line,matrix);
            }
        }
        for (int col=0; col<column.length; col++)   {
            if (column[col])    {
                transformColumnsIn0(col,matrix);
            }
        }


        return matrix;
    }

    @Test
    public void testZeroMatrix()    {
        int[][]arr = new int[3][3];
        arr[0][0] = 1;
        arr[0][1] = 1;
        arr[0][2] = 1;
        arr[1][0] = 1;
        arr[1][1] = 0;
        arr[1][2] = 1;
        arr[2][0] = 1;
        arr[2][1] = 1;
        arr[2][2] = 1;

        transformZeroMatrix(arr);
        for (int i=0; i< arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }
}
