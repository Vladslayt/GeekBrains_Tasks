using System;

namespace ConsoleApp1
{
    class Program
    {
        static void Main(string[] args)
        {
            int rows = ReadInt("Введите количество строк в матрице: ");
            int cols = ReadInt("Введите количество столбцов в матрице: ");

            int[,] matrix = GenerateMatrix(rows, cols, 1, 10);

            PrintMatrix(matrix);
            if(rows > 1)
                ChangeMatrix(matrix);

            System.Console.WriteLine();
            PrintMatrix(matrix);

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
        static void ChangeMatrix(int[,] newMatrix)
        {
            int temp;
            int lastRow = newMatrix.GetLength(0) - 1;
            for (int i = 0; i < newMatrix.GetLength(1); i++)
            {
                temp = newMatrix[0, i];
                newMatrix[0, i] = newMatrix[lastRow, i];
                newMatrix[lastRow, i] = temp;
            }
        }
    }
}

