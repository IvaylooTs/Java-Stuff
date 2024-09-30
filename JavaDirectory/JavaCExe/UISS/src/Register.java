import java.util.regex.Pattern;

public class Register {
    private static final Pattern FN = Pattern.compile("[0-9]{9}");
    private static final Pattern EGN = Pattern.compile("[0-9]{10}");
    private static final Pattern EMAIL = Pattern.compile("[a-z]+@tu-sofia.bg");


    public static User createUser(String name, String password, User.getUserType userType) {
        switch(userType){
            case "ADMIN":
                return new Admin(name, password);
            case "TEACHER":
                if(!EMAIL.matcher(name).matches() || password.length()<5) {
                    return null;
                }
                return new Teacher(name, password);
            case "STUDENT":
                if(!FN.matcher(name).matches() || !EGN.matcher(password).matches()){
                    return null;
                }
                return new Student(name, password);
            default:
                System.err.println("Unknown User type");
                return null;
        }
    }
}
