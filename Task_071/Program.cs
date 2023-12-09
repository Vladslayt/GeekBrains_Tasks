internal class Program
{
    private static void Main(string[] args)
    {
        Random random = new Random();
        int m = random.Next(10), n = random.Next(10, 30);
        AllNumbersInInterval(m, n);

        static void AllNumbersInInterval(int m, int n){
            if(m > n)
                return;
            Console.Write(m + " ");
            m++;
            AllNumbersInInterval(m, n);
        }
    }
}