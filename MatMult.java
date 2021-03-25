
// Matrix Multiplication Code By SP19-BCS-138

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;


class MatrixThread implements Runnable{

    int id;
    int rows;
    int columns;
    int [][] matrix;
    int [][] resultantMatrix;

    public MatrixThread( int id) {
        this.id = id;
    }

    public MatrixThread(int id, int rows, int columns, int[][] matrix, int[][] resultantMatrix) {
        this.id = id;
        this.rows = rows;
        this.columns = columns;
        this.matrix = matrix;
        this.resultantMatrix = resultantMatrix;
    }

    public void run(){
        for(int i=0; i<rows; i++){

            for(int j=0; j<columns; j++){

                resultantMatrix[id][i] += matrix[id][j] * matrix[j][i];

            }

        }
    }


}



public class MatMult {
            public static void main(String[] args) throws FileNotFoundException {


                FileReader fileReader = new FileReader(args[0]);

                Scanner input = new Scanner(fileReader);
                MatrixThread [] threads;

                int m = 0;
                int n = 0;

                m = input.nextInt();
                n = m;

                System.out.println("This is a " + m +" x " + n + " matrix.\n");

                int[][] matrix1 = new int [m][n];
                int[][] resultantMatrix = new int [m][n];
                for(int i = 0; i < m; ++i)
                {
                    for(int j = 0; j < n; ++j)
                    {
                        if(input.hasNextInt())
                        {
                            matrix1[i][j] = input.nextInt();
                        }
                    }
                }



                // Displaying The Input Matrix

                for (int i = 0; i < n; i++){

                    for (int j = 0; j < m; j++)

                        System.out.print(matrix1[i][j]+"\t");

                    System.out.println();

                }

                // Performing the multiplication....!


                threads = new MatrixThread[m];

                for (int i = 0; i < m; i++) {
                    threads[i] = new MatrixThread(i, m,n, matrix1,resultantMatrix);
                    threads[i].run();



                }
                
                
                // Printing the resultant matrix....

                System.out.println("\nThe Resultant Matrix Is: ");

                System.out.println("");

                for (int i = 0; i < n; i++){

                    for (int j = 0; j < m; j++)

                        System.out.print(resultantMatrix[i][j]+"\t");

                    System.out.println();

                }




            }



}


