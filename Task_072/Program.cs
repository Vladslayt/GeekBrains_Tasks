internal class Program
{
    private static void Main(string[] args)
    {
        int m = 3, n = 2;
        Console.WriteLine(FuncAkkerman(m, n));

        static int FuncAkkerman(int m, int n){
            if(m == 0)
                return n + 1;
            if(m > 0 && n == 0)
                return FuncAkkerman(m - 1, 1);
            if(m > 0 && n > 0)
                return FuncAkkerman(m - 1, FuncAkkerman(m, n - 1));
            return 0;
        }
    }
}