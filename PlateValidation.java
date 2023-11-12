import java.util.Scanner;

/**
 * As2 Q3
 */
public class PlateValidation{
    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        String input = kb.nextLine().toUpperCase();
        boolean validStandard = true, validCustom = true;
        if (input.length() <= 7){
            // check if standard
            validStandard = validateRegular(input);
            if (validStandard){
                // print message that it is valid regular
                System.out.println("Valid regular Saskatchewan license plate number");
            } else {
                // if invalid regular
                validCustom = validateCustom(input);
                // check if personalized
                if (validCustom) System.out.println("Valid personalized Saskatchewan license plate number");
                else System.out.println("Invalid Saskatchewan license plate number");
            }
        } else System.out.println("Invalid Saskatchewan license plate number");
    }

    /** Validates regular Sask license plate numbers format 999AAA and 999 AAA **/
    public static boolean validateRegular(String input){
        boolean valid = true;
        // if has 7 characters and a space in the middle, remove the 
        // middle space
        if (input.length() == 7 && input.charAt(3) == ' ')
            input = input.substring(0, 3) + input.substring(4);
            System.out.println(input);
        // check for 999AAA format
        if (input.length() == 6){
            for (int i=0; i<3; i++)
                if (!Character.isDigit(input.charAt(i))) 
                    valid = false;
            for (int i=3; i<6; i++)
                if (!Character.isLetter(input.charAt(i))) 
                    valid = false;
        } else valid = false;
        return valid;
    }

    /** Validates custom Sask license plate numbers: max 7 characters; letters, digits, hyphen and
       space allowed, cannot be all numeric**/
    public static boolean validateCustom(String input){
        boolean valid = true; int numDigits = 0;
        if (input.length() <= 7 && !validateRegular(input)){
            for (int i=0; i<input.length(); i++){
                char c = input.charAt(i);
                // check if valid character
                if (!Character.isLetter(c) &&  !Character.isDigit(c) && c !='-' && c != ' ')
                    valid = false;
                // counter incrementing when a digit is encountered
                if (Character.isDigit(c)) numDigits++;
            } 
        } else valid = false;
        // check if all digits
        if (numDigits == input.length()) valid = false;
        return valid;
    }
}
