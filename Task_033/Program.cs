internal class Program
{
    private static void Main(string[] args)
    {
        Random random = new();
        int[] mas = new int[10];
        for (int i = 0; i < mas.Length; i++){
            mas[i] = random.Next(1, 999);
            Console.Write(mas[i] + " ");
        }
        ReverseMass(mas);
        Console.WriteLine();
        for (int i = 0; i < mas.Length; i++){
            Console.Write(mas[i] + " ");
        }
        
    }
    static void ReverseMass(int[] mas){
        int temp;
        for(int i = 0; i < mas.Length / 2; i++){
            temp = mas[i];
            mas[i] = mas[mas.Length - i - 1];
            mas[mas.Length - i - 1] = temp;
        }
    }
}