import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MailValidator {

    private Pattern pattern;

    private Matcher matcher;

    private static final String EMAIL_PATTERN =

 "^[A-Za-z0-9]+(\\.[A-Za-z0-9]*)@+[A-Za-z0-9]+(\\.[A-Za-z]{2,})$";
    public void EmailValidator() {

        pattern = Pattern.compile(EMAIL_PATTERN);

    }

    public boolean validateMail(final String checkedMail) {

        matcher = pattern.matcher(checkedMail);

        return matcher.matches();

    }

}