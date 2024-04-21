import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("Введите данные в формате: Фамилия Имя Отчество дата_рождения номер_телефона пол");
            String input = scanner.nextLine();
            if(input.equals("q"))
                break;
            String[] data = input.split(" ");

            if (data.length != 6) {
                System.out.println("Вы ввели меньше или больше данных, чем требуется.");
                return;
            }

            String surname = data[0];
            String name = data[1];
            String patronymic = data[2];
            String birthDate = data[3];
            String phoneNumber = data[4];
            String gender = data[5];

            try {
                validateData(surname, name, patronymic, birthDate, phoneNumber, gender);
                writeToFile(surname, name, patronymic, birthDate, phoneNumber, gender);
            } catch (IncorrectDataFormatException e) {
                System.out.println(e.getMessage());
            } catch (IOException e) {
                System.out.println("Произошла ошибка при записи в файл.");
                e.printStackTrace();
            }
        }
    }

    private static void validateData(String surname, String name, String patronymic, String birthDate, String phoneNumber, String gender) throws IncorrectDataFormatException {
        if (!surname.matches("[a-zA-Zа-яА-Я]+"))
            throw new IncorrectDataFormatException("Неверный формат фамилии.");

        if (!name.matches("[a-zA-Zа-яА-Я]+"))
            throw new IncorrectDataFormatException("Неверный формат имени.");

        if (!patronymic.matches("[a-zA-Zа-яА-Я]+"))
            throw new IncorrectDataFormatException("Неверный формат отчества.");

        if (!birthDate.matches("\\d{2}.\\d{2}.\\d{4}"))
            throw new IncorrectDataFormatException("Неверный формат даты рождения.");

        if (!phoneNumber.matches("\\d+"))
            throw new IncorrectDataFormatException("Неверный формат номера телефона.");

        if (!(gender.equals("f") || gender.equals("m")))
            throw new IncorrectDataFormatException("Неверный формат пола.");
    }

    private static void writeToFile(String surname, String name, String patronymic, String birthDate, String phoneNumber, String gender) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(surname + ".txt", true))) {
            writer.write(surname + " " + name + " " + patronymic + " " + birthDate + " " + phoneNumber + " " + gender);
            writer.newLine();
            System.out.println("Данные успешно добавлены в файл.");
        }
    }
}
