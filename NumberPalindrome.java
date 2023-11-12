public class NumberPalindrome{
    public static void main(String[] args){
        int count, max = 0;         // tracks the max number of iterations
        String maxNumber = "0";     // tracks the number with most iterations
        String number, reverse;     // String representations
        
        /* we can use magic numbers here i.e. 10 and 89 because
         * we are interested specifically in that range
         * of values
         */
        for (int i=10; i<89; i++){
            count = 0; // reset count
            number = Integer.toString(i);
            reverse = getReverseString(i);      
            
            /* use this print for testing and de-bugging
             * but it should be removed or at leaste commented
             * out for the final run
             */
            //System.out.print(number + ": ");                    // not required
            
            // iterate as long as not palindrome result
            while(!number.equals(reverse)){
                // convert to int to calculate the next iteration value
                int num1 = Integer.parseInt(number);
                int num2 = Integer.parseInt(reverse);
                
                /* more testing output
                 * should be removed or commented for
                 * the final run 
                 */
                //System.out.print(num1 + " + " + num2);          // not required
                // add the 2 numbers
                int sum = num1 + num2;
                
                /* more testing output
                 * should be removed or commented for
                 * the final run 
                 */
                //System.out.print(" = " + sum);                  // not required
                
               // convert sum to String to check for palindrome
                number = Integer.toString(sum);
                
                // reverse for palindrome check
                reverse = getReverseString(sum);
                
                /* more testing output
                 * should be removed or commented for
                 * the final run 
                 */
                //if (!number.equals(reverse)) System.out.print(", ");    // not required
                count++;
            }
            if (count > max){
                max = count;
                maxNumber = Integer.toString(i);
            }
            //System.out.println(" ("+count+")");           
        }
        System.out.println("\n\nThe number " + maxNumber + " reaches a palindromic number after " + max + " iterations"); 
    }

    /** takes int and returns reversed string **/
    public static String getReverseString(int num){
        String number = Integer.toString(num);
        String reverse = "";
        for (int j=number.length()-1; j>=0; j--){
            reverse += number.charAt(j);
        }
        return reverse;
    }
}
