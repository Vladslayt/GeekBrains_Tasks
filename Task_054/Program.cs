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

            matrix = ChangeMatrix(matrix);

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
        static int[,] ChangeMatrix(int[,] matrix)
        {
            int minValue = int.MaxValue;
            int indexRow = 0, indexCol = 0;
            for (int i = 0; i < matrix.GetLength(0); i++)
            {
                for (int j = 0; j < matrix.GetLength(1); j++)
                {
                    if(matrix[i, j] < minValue)
                    {
                        minValue = matrix[i, j];
                        indexRow = i;
                        indexCol = j;
                    }
                }
            }

            int[,] tempMatrix = new int[matrix.GetLength(0) - 1, matrix.GetLength(1) - 1];
            int indexNewRow = 0, indexNewCol = 0;
            for (int i = 0; i < matrix.GetLength(0); i++)
            {
                for (int j = 0; j < matrix.GetLength(1); j++)
                {
                    if (i != indexRow && j != indexCol)
                    {
                        tempMatrix[indexNewRow, indexNewCol] = matrix[i, j];
                        indexNewCol++;
                        if (indexNewCol == tempMatrix.GetLength(1))
                        {
                            indexNewRow++;
                            indexNewCol = 0;
                        }
                    }
                    
                }
            }
            return tempMatrix;
        }
    }
}
