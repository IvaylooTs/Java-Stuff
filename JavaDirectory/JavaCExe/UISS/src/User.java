public abstract class User {
    public String username;
    public String password;
    public enum getUserType {
        ADMIN,
        STUDENT,
        TEACHER
    }
}
