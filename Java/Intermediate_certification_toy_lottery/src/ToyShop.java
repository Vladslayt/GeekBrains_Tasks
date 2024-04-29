import java.util.*;
import java.io.*;

public class ToyShop {
    private final List<Toy> toys;
    private final List<Toy> prizeQueue;
    private final Random random;

    public ToyShop() {
        toys = new ArrayList<>();
        prizeQueue = new ArrayList<>();
        random = new Random();
    }

    /**
     * Выбирает призовую игрушку и добавляет ее в список призовых игрушек.
     */
    public void choosePrizeToy() {
        double totalWeight = toys.stream().mapToDouble(Toy::getWeight).sum();
        double randomNumber = random.nextDouble() * totalWeight;
        double sum = 0;
        Toy selectedToy = null;
        for (Toy toy : toys) {
            sum += toy.getWeight();
            if (randomNumber <= sum) {
                selectedToy = toy;
                break;
            }
        }
        if (selectedToy != null) {
            prizeQueue.add(selectedToy);
            System.out.println("Выбрана игрушка " + selectedToy.getName());
        }
    }

    /**
     * Получает призовую игрушку из списка призовых игрушек, удаляет ее из списка,
     * записывает в файл и уменьшает количество доступных игрушек.
     */
    public void getPrizeToy() {
        if (!prizeQueue.isEmpty()) {
            Toy prizeToy = prizeQueue.remove(0);
            decreaseQuantity(prizeToy.getId());
            writeToFile(prizeToy.getName());
            System.out.println("Вы получили призовую игрушку: " + prizeToy.getName());
        } else {
            System.out.println("Нет призовых игрушек для выдачи.");
        }
    }

    /**
     * Добавляет новую игрушку в магазин.
     *
     * @param id       уникальный идентификатор игрушки
     * @param name     название игрушки
     * @param quantity количество доступных игрушек
     * @param weight   вес игрушки в процентах от 100
     */
    public void addNewToy(int id, String name, int quantity, double weight) {
        toys.add(new Toy(id, name, quantity, weight));
    }

    /**
     * Изменяет вес (частоту выпадения) игрушки по ее id.
     *
     * @param toyId     id игрушки, чей вес нужно изменить
     * @param newWeight новый вес игрушки
     */
    public void adjustWeight(int toyId, double newWeight) {
        for (Toy toy : toys) {
            if (toy.getId() == toyId) {
                toy.setWeight(newWeight);
                return;
            }
        }
        System.out.println("Игрушка с id " + toyId + " не найдена.");
    }

    /**
     * Уменьшает количество доступных игрушек по их id.
     *
     * @param toyId id игрушки, количество которой нужно уменьшить
     */
    private void decreaseQuantity(int toyId) {
        for (Toy toy : toys) {
            if (toy.getId() == toyId) {
                toy.setQuantity(toy.getQuantity() - 1);
                if (toy.getQuantity() == 0) {
                    toys.remove(toy);
                }
                return;
            }
        }
    }

    /**
     * Записывает название игрушки в текстовый файл.
     *
     * @param toyName название игрушки
     */
    private void writeToFile(String toyName) {
        try (FileWriter writer = new FileWriter("prize_winners.txt", true)) {
            writer.write(toyName + "\n");
        } catch (IOException e) {
            System.out.println("Ошибка записи в файл.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ToyShop toyShop = new ToyShop();
        toyShop.addNewToy(1, "Кукла", 1, 30);
        toyShop.addNewToy(2, "Машинка", 2, 50);
        toyShop.addNewToy(3, "Мяч", 3, 20);

        try (Scanner scanner = new Scanner(System.in)) {
            int choice;
            do {
                System.out.println("Выберите действие:");
                System.out.println("1. Выбрать призовую игрушку");
                System.out.println("2. Получить призовую игрушку");
                System.out.println("3. Добавить новую игрушку");
                System.out.println("4. Изменить вес игрушки");
                System.out.println("5. Выход");
                choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        toyShop.choosePrizeToy();
                        break;
                    case 2:
                        toyShop.getPrizeToy();
                        break;
                    case 3:
                        toyShop.addNewToyFromInput(scanner);
                        break;
                    case 4:
                        toyShop.adjustWeightFromInput(scanner);
                        break;
                    case 5:
                        System.out.println("Программа завершена.");
                        break;
                    default:
                        System.out.println("Неверный выбор.");
                }
            } while (choice != 5);
        } catch (Exception e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }

    /**
     * Добавляет новую игрушку на основе ввода с клавиатуры.
     *
     * @param scanner объект Scanner для считывания ввода с клавиатуры
     */
    private void addNewToyFromInput(Scanner scanner) {
        System.out.println("Введите id: ");
        int id = scanner.nextInt();

        System.out.println("Введите название: ");
        String name = scanner.next();

        System.out.println("Введите количество: ");
        int quantity = scanner.nextInt();

        System.out.println("Введите вес (в % от 100): ");
        double weight = scanner.nextDouble();

        addNewToy(id, name, quantity, weight);
    }

    /**
     * Изменяет вес игрушки на основе ввода с клавиатуры.
     *
     * @param scanner объект Scanner для считывания ввода с клавиатуры
     */
    private void adjustWeightFromInput(Scanner scanner) {
        System.out.println("Введите id игрушки, вес которой нужно изменить: ");
        int id = scanner.nextInt();

        System.out.println("Введите новый вес (в % от 100): ");
        double weight = scanner.nextDouble();

        adjustWeight(id, weight);
    }
}
