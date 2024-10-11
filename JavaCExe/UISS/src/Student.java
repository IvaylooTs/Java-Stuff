import java.util.ArrayList;
import java.util.List;

public class Student extends User{
    List<Grade> gradesOfStudent= new ArrayList<>();
    public getUserType getUserType(){
        return getUserType.STUDENT;
    }

}
