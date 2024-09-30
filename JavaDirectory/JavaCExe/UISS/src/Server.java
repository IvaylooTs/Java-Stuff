import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Server {

    public Server() {
        firstStart();

    }

    private Object lock;
    private final String FILE_NAME = "users.bin";
    ServerSocket server = null;


    public void firstStart() {
        if (new File(FILE_NAME).exists())
            return;
        List<User> users = new ArrayList<>();
        users.add(new Admin("admin", "12345"));
        writeToFile(users);
    }

    public void start(int port) {
        try {
            server = new ServerSocket(port);
            while (true) {
                Socket socket = server.accept();
                Thread t1 = new Thread(() -> {
                    Scanner sc = null;
                    PrintStream out = null;
                    try {
                        sc = new Scanner(socket.getInputStream());
                        out = new PrintStream((socket.getOutputStream()));
                        userMenu(sc, out);

                    } catch (IOException e) {
                        if (sc != null) {
                            sc.close();
                        }
                        if (out != null) {
                            out.close();
                        }
                    }
                });
                t1.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<User> readFromFile() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            synchronized (lock) {
                return (List<User>) in.readObject();
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void writeToFile(List<User> list) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            synchronized (lock) {
                out.writeObject(list);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public User login(String password, String username) {
        synchronized (lock) {
            for (User user : readFromFile()) {
                if (user.getPassword().equals(password) && user.getUsername().equals(username)) {
                    return user;
                }
            }
            return null;
        }
    }

    private void userMenu(Scanner sc, PrintStream out) {
        while (true) {
            out.println("Login? Y/N");
            String login = sc.nextLine();

            if (!login.equalsIgnoreCase("Y")) {
                out.println("Goodbye.");
                return;
            }

            out.println("Enter username:");
            String userName = sc.nextLine();

            out.println("Enter password:");
            String password = sc.nextLine();

            User user = login(userName, password);

            if (user == null) {
                out.println("Error: Invalid login.");
                continue;
            }
            switch (user.getUserType())
            {
                case ADMIN:
                {
                    adminMenu(sc, out, (Admin) user);
                    break;
                }
                case STUDENT:
                {
                    studentMenu(sc, out, (Student) user);
                    break;
                }
                case TEACHER:
                {
                    teacherMenu(sc, out, (Teacher) user);
                    break;
                }
            }

        }
    }

    private void adminMenu(Scanner sc, PrintStream out, Admin admin){
        System.out.println("Logged in as Admin.");
        System.out.println("Enter type of account: ADMIN, TEACHER, STUDENT");
        try
        {
            User.getUserType userType = User.getUserType.valueOf(sc.nextLine().toUpperCase());

            out.println("Enter username:");
            String userName = sc.nextLine();

            out.println("Enter password:");
            String password = sc.nextLine();

            Register.createUser(userName, password, userType);

            out.println("Success.");
        }
        catch (IllegalArgumentException e)
        {
            out.println("Error: Invalid user type.");
        }

    }

    private void studentMenu(Scanner sc, PrintStream out, Student student) {
        List<Grade> sortedGrades = student.getGrades()
                .stream()
                .sorted(Comparator.comparingInt(Grade::getSemester).thenComparing(Grade::getSubject))
                .collect(Collectors.toList());
        out.println(sortedGrades);
    }
    private void teacherMenu(Scanner sc, PrintStream out, Teacher teacher)
    {
        out.println("Logged in as teacher.");

        out.println("Enter student faculty number:");
        String facultyNumber = sc.nextLine();

        out.println("Enter subject:");
        String subject = sc.nextLine();

        out.println("Enter semester:");
        int semester = Integer.parseInt(sc.nextLine());

        out.println("Enter grade:");
        int gradeValue = Integer.parseInt(sc.nextLine());

        Grade grade = new Grade(subject, semester, gradeValue);

        synchronized (lock)
        {
            List<User> users = readFromFile();
            for (User user : users)
            {
                if (user.getUserName().equals(facultyNumber) && user instanceof Student)
                {
                    Student student = (Student) user;

                    student.getGrades().add(grade);

                    writeToFile(users);

                    out.println("Success.");
                    return;
                }
            }

            out.println("No such student.");
        }
    }
}

