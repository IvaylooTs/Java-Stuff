package zadachi;
import java.time.LocalDate;

public class Age {
    public static int recalculateAge(LocalDate input){
        LocalDate currentDate = LocalDate.now();
        int age = currentDate.getYear() - input.getYear();

        if (currentDate.getDayOfYear() < input.getDayOfYear()) {
            age--;
        }

        return age;
    }
}