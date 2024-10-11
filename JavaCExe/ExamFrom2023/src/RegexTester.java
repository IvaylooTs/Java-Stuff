import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTester {
    public static List<Boolean> test(Regex regex, String[] strings){
        List<Boolean> returnList = new ArrayList<>();
        Pattern pattern = Pattern.compile(regex.getPattern());
        for (String string : strings) {
            Matcher matcher = pattern.matcher(string);

            returnList.add(matcher.matches());
        }
        return returnList;
    }
}
