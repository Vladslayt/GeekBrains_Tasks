using System.Security.Cryptography.X509Certificates;

internal class Program
{
    private static void Main(string[] args)
    {
        while (true)
        {
            string? str = Console.ReadLine();
            if (str == "q")
                break;

            if (!IsNumber(str))
                continue;

            if (IsEven(Convert.ToInt32(str)))
                break;

        }
    }
    
    static bool IsEven(int number)
    {
        int sum = 0;
        while (number != 0)
        {
            sum += number % 10;
            number /= 10;
        }
        if (sum % 2 == 0)
            return true;
        return false;
    }

    static bool IsNumber(string? str)
    {
        if(int.TryParse(str, out int number))
            return true;
        
        else
            return false;
    }
}