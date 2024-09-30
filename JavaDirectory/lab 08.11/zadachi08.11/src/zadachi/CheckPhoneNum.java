package zadachi;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
public class CheckPhoneNum {

        public static void main(String[] args) {
            String[] phoneNumbers = {
                    "0898123456",
                    "+359878765432",
                    "0771234567",
                    "+443591234567",
                    "1234567890",
                    "+359885261009"
            };

            for (String phoneNumber : phoneNumbers) {
                if (isValidPhoneNumber(phoneNumber)) {
                    System.out.println(phoneNumber + " - валиден");
                } else {
                    System.out.println(phoneNumber + " - невалиден");
                }
            }
        }

        public static boolean isValidPhoneNumber(String phoneNum) {
            String regex = "^(0|\\+359)\\d{9}$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(phoneNum);
            return matcher.matches();
        }

}
