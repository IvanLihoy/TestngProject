package MyCode;

import java.util.regex.Pattern;




public class Validator {
    private String patterNumbers = "^(?:Numbers: )?(?:(?:[2-9][0-9]{3}|10000)(?:\\.\\d\\d)?(?:,|$))+$";
    private String patterEmails = "^(?i)(?:(?:[^@]+@gmail\\.com)(?:,|$))+$";
    private String newPattern = "^(?i)(?:(?:[^@]+@yandex\\.com)(?:,|$))+$";


    public Validator() {
    }

    public boolean numbers(String input) {
        return Pattern.matches(this.patterNumbers, input);
    }
    public boolean emails(String input)
    {
        return Pattern.matches(this.patterEmails, input);
    }
    public boolean replace(String input, String replaceString){
        return Pattern.matches(this.newPattern, input.replaceAll(patterEmails, replaceString));
    }
}
