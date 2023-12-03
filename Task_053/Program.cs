using System;

namespace ConsoleApp1
{
    class Program
    {
        static void Main(string[] args)
        {
            int rows = ReadInt("Введите количество строк в матрице: ");
            int cols = ReadInt("Введите количество столбцов в матрице: ");

            if (rows == cols) // если пользовательно вредный
                cols += 1;

            int[,] matrix = GenerateMatrix(rows, cols, 1, 10);

            PrintMatrix(matrix);

            int indexRow = FindRow(matrix);
            int[] masRow = new int[matrix.GetLength(1)];
            for(int i = 0; i < matrix.GetLength(1); i++)
            {
                masRow[i] = matrix[indexRow, i];
            }


            System.Console.WriteLine();
            for (int i = 0; i < matrix.GetLength(1); i++)
            {
                System.Console.Write(masRow[i] + "\t");
            }

        }
        static int ReadInt(string text)
        {
            System.Console.Write(text);
            return Convert.ToInt32(Console.ReadLine());
        }

        static int[,] GenerateMatrix(int row, int col, int leftRange, int rightRange)
        {
            int[,] tempMatrix = new int[row, col];
            Random rand = new Random();

            for (int i = 0; i < tempMatrix.GetLength(0); i++)
            {
                for (int j = 0; j < tempMatrix.GetLength(1); j++)
                {
                    tempMatrix[i, j] = rand.Next(leftRange, rightRange + 1);
                }
            }

            return tempMatrix;
        }

        static void PrintMatrix(int[,] matrixForPrint)
        {
            for (int i = 0; i < matrixForPrint.GetLength(0); i++)
            {
                for (int j = 0; j < matrixForPrint.GetLength(1); j++)
                {
                    System.Console.Write(matrixForPrint[i, j] + "\t");
                }
                System.Console.WriteLine();
            }
        }
        static int FindRow(int[,] matrix)
        {
            int maxSum = int.MinValue, indexMaxRow = 0;
            for (int i = 0; i < matrix.GetLength(0); i++)
            {
                int sum = 0;
                for (int j = 0; j < matrix.GetLength(1); j++)
                {
                    sum += matrix[i, j];
                }

                if (sum > maxSum)
                {
                    maxSum = sum;
                    indexMaxRow = i;
                }
            }
            return indexMaxRow;
        }
    }
}

