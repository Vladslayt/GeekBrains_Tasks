internal class Program
{
    private static void Main(string[] args)
    {
        string str = "Что не делается всё к лучшему";
        string[] splitStr = str.Split(" ");
        string resultStr = "";
        resultStr += splitStr.Last();
        for(int i = splitStr.Length - 2; i >= 0; i--){
            resultStr += " " + splitStr[i];
        }
        Console.WriteLine(resultStr);
    }
}