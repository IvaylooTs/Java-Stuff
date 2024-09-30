import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class Server {
    private final String FILE = "test.txt";
    private ServerSocket server;
    Object lock;
    public Server(){
        lock = new Object();
    }

    public void start(int port){
        try {
            server = new ServerSocket(port);
            while(true) {
                Socket socket = server.accept();
                Thread t1 = new Thread(() -> {
                    try (Scanner sc = new Scanner(socket.getInputStream()); PrintStream out = new PrintStream(socket.getOutputStream())) {
                        userMenu(sc, out);


                    } catch (IOException e) {
                        e.getStackTrace();
                    }
                });
                t1.start();
            }
            } catch(IOException e){
            e.getStackTrace();
        }

    }

    private void writeToFile(List<Regex> regexList) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE, true))) {
            synchronized (lock) {
                for (Regex regex : regexList) {
                    writer.write("ID: " + regex.getId() + "\n");
                    writer.write("Pattern: " + regex.getPattern() + "\n");
                    writer.write("Description: " + regex.getDescription() + "\n");
                    writer.write("Rating: " + regex.getRating() + "\n\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<Regex> readFromFile() {
        List<Regex> regexList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE))) {
            synchronized (lock) {
                String line;
                while ((line = reader.readLine()) != null) {
                    // Прочитане на информацията за всяка регулярна проверка от файла
                    int id = Integer.parseInt(line.substring(4));
                    String pattern = reader.readLine().substring(9);
                    String description = reader.readLine().substring(13);
                    int rating = Integer.parseInt(reader.readLine().substring(8));

                    if (!containsPattern(regexList, pattern)) {
                        Regex regex = new Regex(pattern, description);
                        regex.setId(id);
                        regex.setRating(rating);
                        regexList.add(regex);
                    }

                    reader.readLine();
                }
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        return regexList;
    }

    private boolean containsPattern(List<Regex> regexList, String pattern) {
        for (Regex regex : regexList) {
            if (regex.getPattern().equals(pattern)) {
                return true;
            }
        }
        return false;
    }

    private void userMenu(Scanner sc, PrintStream out){
        out.println("Chose an option: CREATE NEW | LOAD");
        String option = sc.nextLine().toUpperCase();
        switch(option){
            case ("CREATE NEW"):
                createNew(sc, out);
                break;
            case ("LOAD"):
                load(sc, out);
                break;
            default:
                out.println("Invalid option");
        }
    }
    private void load(Scanner sc, PrintStream out){
        out.println("You chose to load a regex.");
        out.println("Enter key word:");
        List<Regex> list = readFromFile();
        List<Regex> matchingList = new ArrayList<>();
        String keyword = sc.nextLine();
        for (Regex regex : list){
            if (regex.getDescription().toLowerCase().contains(keyword.toLowerCase())) {
                matchingList.add(regex);
            }
        }
        matchingList.sort((regex1, regex2) -> Integer.compare(regex2.getRating(), regex1.getRating()));

        Regex neededRegex = null;
        while(neededRegex==null) {
            out.println("Chose a regex by it's ID");
            int idOf = sc.nextInt();
            for (Regex regex : matchingList) {
                if (idOf == regex.getId()) {
                    neededRegex = regex;
                } else {
                    out.println("Regex not found by id");
                }
            }
        }
        out.println("Do you want to change rating of the regex? +|-|NO");
        String answear = sc.nextLine();
        switch(answear){
            case "+":
                for(Regex regex : list){
                    if(neededRegex.getId() == regex.getId()){
                        regex.setRating(regex.getRating()+1);;
                    }
                }
        }
        writeToFile(list);

    }
    private void createNew(Scanner sc, PrintStream out) {
        out.println("Type Pattern");
        String pattern = sc.nextLine();
        out.println("Type Description");
        String desc = sc.nextLine();
        Regex newRegex= new Regex(pattern, desc);
        String[] strings = new String[3];
        for(int i=0 ; i<3; i++){
            out.println("Enter string.");
            strings[i] = sc.nextLine();
        }
        RegexTester.test(newRegex, strings);
        out.println("Do you want to add regex in file: ");
        List<Regex> list = readFromFile();
        list.add(newRegex);
        writeToFile(list);

    }
}


