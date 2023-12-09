internal class Program
{
    private static void Main(string[] args)
    {
        string str = "шалаш";
        str = str.ToLower();
        bool flag = true;
        for(int i = 0; i < str.Length; i++){
            if(str[i] != str[str.Length - 1 - i]){
                flag = false;
                break;
            }
        }
        if(flag)
            Console.WriteLine("Строка является палиндромом");
        else
            Console.WriteLine("Строка не является палиндромом");
    }
}