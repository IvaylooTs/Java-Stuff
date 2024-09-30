import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Интерфейс за валидация
interface Validater {
    void checking() throws InvalidUserException;
}

// Изключение за невалиден потребител
class InvalidUserException extends Exception {
    public InvalidUserException(String message) {
        super(message);
    }
}

// Клас User, който имплементира интерфейса Validater
class User implements Validater {
    private String nickName;
    private String password;

    public User(String nickName, String password) {
        this.nickName = nickName;
        this.password = password;
    }

    // Метод за валидация
    @Override
    public void checking() throws InvalidUserException {
        // Проверка дали nickName е валиден email
        if (!isValidEmail(nickName)) {
            throw new InvalidUserException("Invalid email address");
        }

        // Създаване на обект и запис във файл
        // (тук можете да добавите логиката за запис във файл)

        System.out.println("User object created and saved to file");
    }

    // Помощен метод за проверка на валиден email
    private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    // Статичен метод за проверка на потребител във файл
    public static boolean checkUserFromFile(File file, String nickName, String password) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Разделяме реда на части, като предполагаме, че е във формат "nickName password"
                String[] parts = line.split("\\s+");
                if (parts.length == 2 && parts[0].equals(nickName) && parts[1].equals(password)) {
                    return true; // Намерен потребител във файл
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false; // Потребител не е намерен във файл
    }
}

public class Main {
    public static void main(String[] args) {
        try {
            // Пример за използване на класа User и валидация
            User user1 = new User("user@example.com", "password123");
            user1.checking();

            // Пример за използване на статичния метод за проверка във файл
            File userFile = new File("users.txt");
            boolean userExists = User.checkUserFromFile(userFile, "user@example.com", "password123");

            if (userExists) {
                System.out.println("User exists in the file.");
            } else {
                System.out.println("User does not exist in the file.");
            }
        } catch (InvalidUserException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}