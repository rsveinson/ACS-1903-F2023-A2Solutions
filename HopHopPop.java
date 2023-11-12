import java.util.Scanner;
import java.util.Random;
/** 
 * ACS-1903 Assignment X Question Y
 * @author 
*/

public class HopHopPop{
    public static void main(String[] args) {
        // vairables constants and objects
        Scanner scanner = new Scanner(System.in);
        Random rnd = new Random();
        
        String playAgain;
        
        // dice
        int quaffel = 0;
        int snitch = 0;
        
        // position
        int aPosition = 0;
        int bPosition = 20;
        
        // rock paper scissors
        // int playerAShoot = 0;
        // int plaeryBShoot = 0;
        
        // distances to goal
        int p1DistanceToGoal = 20;
        int p2DistanceToGoal = 20;
        
        int margin = 0;     // margin of victory
        
        // round
        int rounds = 0;
        
        
        // print the banner
        printBanner();
        
        // game loop
        
        System.out.println("Do you want to play HopHopPop? (y/n)");
        playAgain = scanner.next().toUpperCase();
        
        while(playAgain.equals("Y")){
            // set up the column headings for the round by round summary
            System.out.print("Player 1: \t Position \t  Distance \t");
            System.out.println("Player 2: \t  Position \t  Distance");
            
            // set up counters
            rounds = 0;
            aPosition = 1;
            bPosition = 20;
            p1DistanceToGoal = 20;
            p2DistanceToGoal = 20;
            
            do{ // there will be at least one round in every game so a do while loop works
            rounds++;
            // player one
            quaffel = rnd.nextInt(3) + 1;
            snitch = rnd.nextInt(5) + 1;
            //System.out.println("p1 " + quaffel + " " + snitch);
            
            //move
            if(quaffel % 2 == 1){
                aPosition += snitch;
            }// end move forward
            else{
                aPosition -= snitch;
                aPosition = Math.max(1, aPosition);
            }// end move backward
            
            // see if they've reached the end
            if(aPosition > 20){
                aPosition = 20 - (aPosition - 20);
            }//end overshoot
            //System.out.println("player 1 position " + aPosition);
            
            // player two
            quaffel = rnd.nextInt(3) + 1;
            snitch = rnd.nextInt(5) + 1;
            //System.out.println("p2 " + quaffel + " " + snitch);
            
            //move
            if(quaffel % 2 == 1){
                bPosition -= snitch;
            }// end move forward
            else{
                bPosition += snitch;
                bPosition = Math.min(20, bPosition);
            }// end move backward
            
            // see if they've reached the end
            if(bPosition < 1){
                bPosition = 1 - bPosition;
            }//end overshoot
            //System.out.println("player 2 position " + bPosition);
            
            // print round by round status
            p1DistanceToGoal = 20 - aPosition;
            p2DistanceToGoal = bPosition - 1;
            
            
            //System.out.print("Player 1: \t Position \t Distance \t");
            //System.out.println("Player 2: \t Position \t Distance");
            System.out.print("Round: " + rounds + "\t\t" + aPosition + "\t\t" + p1DistanceToGoal + "\t");
            System.out.println("Round: " + rounds + "\t\t" + bPosition + "\t\t" + p2DistanceToGoal + "\t");
            
            
        }// end do
        while(aPosition != 20 && bPosition != 1 && rounds < 20);
        
        // game summary
        System.out.println();
        System.out.println("-------------- Summary -------------");
        System.out.println();
        if(20 - aPosition == bPosition){
            System.out.println("It's a tie");
        }// it's a tie
        else{
            if(20 - aPosition > bPosition){
                System.out.println("Player 2 wins!");
            }// p2 20
            else{
                System.out.println("Player 1 wins!");
            }
        }// not a tie
        
        margin = Math.max(p1DistanceToGoal, p2DistanceToGoal) - Math.min(p1DistanceToGoal, p2DistanceToGoal);
        
        System.out.println("In " + rounds + " rounds.");
        System.out.println("By a margin of: " + margin + " squares.");
        
            
            // update the game loop
            System.out.println();
            System.out.println("------------------------------------------------");
            System.out.println("Do you want to play HopHopPop again? (y/n)");
            playAgain = scanner.next().toUpperCase();
        }
        
        System.out.println("end of program");
    }// end main
    public static void printBanner(){
        System.out.println("*********************************");
        System.out.println("Welcome to Hop Hop Pop");
        System.out.println("The two player palyground game");
        System.out.println("gone virtual.");
        System.out.println("*********************************");
    }//end print banner
}// end main
