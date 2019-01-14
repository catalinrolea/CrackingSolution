package string.arraylist;

import org.junit.Test;

public class RotateMatrix {

    static void rotate(int[][] matrix) {
        //arr.length != arr[0].length -> if matrix contain one element
        if (matrix.length == 0 || matrix.length != matrix[0].length)
            return;
        int n = matrix.length;
        for (int i=0; i<n/2; i++) {
          int first = i;
          int last = n-1-i;
          for (int j = first; j < last; j++)    {
              int offset = j-first;
              int top = matrix[first][j];
              //left -> top
              matrix[first][j] = matrix[last-offset][first];
              //bottom -> left
              matrix[last-offset][first] = matrix[last][last-offset];
              //right -> bottom
              matrix[last][last - offset] = matrix[j][last];
              //top -> right
              matrix[j][last] = top;
          }
        }
        for (int i=0; i<matrix.length; i++)    {
            for (int j=0; j<matrix.length; j++)    {
                    System.out.print(matrix[i][j] + " ");
            }
              System.out.println();
        }
    }

    @Test
    public void rotateMatrix()  {
        System.out.println("*** Rotate matrix ***");
        int[][]arr = new int[3][3];
        arr[0][0] = 1;
        arr[0][1] = 2;
        arr[0][2] = 3;
        arr[1][0] = 4;
        arr[1][1] = 5;
        arr[1][2] = 6;
        arr[2][0] = 7;
        arr[2][1] = 8;
        arr[2][2] = 9;

        rotate(arr);

    }
}
