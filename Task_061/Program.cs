internal class Program
{
    private static void Main(string[] args)
    {
        char[,] mas = new char[10, 10];
        Random rnd = new Random();
        for (int i = 0; i < mas.GetLength(0); i++)
        {
            for(int j = 0; j < mas.GetLength(1); j++){
                mas[i, j] = Convert.ToChar(rnd.Next('a', 'a' + 27));
                Console.Write("{0}", mas[i, j]);
            }
        }
        Console.WriteLine();
        string str = "";
        for(int i = 0; i < mas.GetLength(0); i++){
            for(int j = 0; j < mas.GetLength(1); j++){
                 str += mas[i, j];       
            }
        }
        Console.WriteLine(str);

    }
}