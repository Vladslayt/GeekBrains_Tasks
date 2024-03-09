import java.util.*;

public class Main {
    private final Map<String, Set<String>> phoneBook;

    public Main() {
        phoneBook = new HashMap<>();
    }

    public void addEntry(String name, String phoneNumber) {
        if (!phoneBook.containsKey(name)) {
            phoneBook.put(name, new HashSet<>());
        }
        phoneBook.get(name).add(phoneNumber);
    }

    public void printSortedByPhoneCount() {
        List<Map.Entry<String, Set<String>>> entries = new ArrayList<>(phoneBook.entrySet());
        entries.sort((entry1, entry2) -> entry2.getValue().size() - entry1.getValue().size());

        for (Map.Entry<String, Set<String>> entry : entries) {
            System.out.println(entry.getKey() + ": " + entry.getValue().size() + " phone numbers");
            for (String phoneNumber : entry.getValue()) {
                System.out.println("- " + phoneNumber);
            }
        }
    }

    public static void main(String[] args) {
        Main phoneBook = new Main();
        phoneBook.addEntry("Владислав", "1234567890");
        phoneBook.addEntry("Дмитрий", "2345678901");
        phoneBook.addEntry("Алена", "3456789012");
        phoneBook.addEntry("Максим", "4567890123");
        phoneBook.addEntry("Алексей", "5678901234");
        phoneBook.addEntry("Максим", "6789012345");
        phoneBook.printSortedByPhoneCount();
    }
}