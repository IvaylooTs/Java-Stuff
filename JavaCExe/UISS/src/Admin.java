public class Admin extends User{
    public Admin(String username, String password) {
    }
    public getUserType getUserType(){
        return getUserType.ADMIN;
    }
}
