package Zadacha2;

public class User {
    private String email;
    public void setEmail(String email){
        this.email = email;
    }
    public String getEmail(){
        return email;
    }
    private String tels;

    private String getTels(){
        return tels;
    }
    public User(String Email, String Tels){
        this.email = Email;
        this.tels = Tels;
    }

    public User(){
    }
    public String toString() {
        return String.format("Email: %s, Tel: %s", getEmail(), getTels());
    }
}
