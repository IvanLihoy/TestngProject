package MyCode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;




public class Validator {
    private String patterNumbers = "^(?:Numbers: )?(?:(?:[2-9][0-9]{3}|10000)(?:\\.\\d\\d)?(?:,|$))+$";
    private String patterEmails = "^(?i)(?:(?:[^@]+@gmail\\.com)(?:,|$))+$";

    public Validator() {
    }

    public boolean numbers(String input) {
        return Pattern.matches(this.patterNumbers, input);
    }
    public boolean emails(String input)
    {
        return Pattern.matches(this.patterEmails, input);
    }
//    public boolean replaceM(String input){
//        Pattern p = Pattern.compile(REGEX);
//        Matcher m = p.matcher(input);
//        input = m.replaceAll(REPLACE);
//        System.out.println(input);
//        return m.matches();
//    }
    public boolean testReplace(String input) {
         return Pattern.matches(this.patterEmails, input.replaceAll("[0-9]", ""));
   }

   }
