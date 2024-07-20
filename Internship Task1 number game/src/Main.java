import java.util.Random;
import java.util.Scanner;

class Picknumber {
    int randomNumber;
    Picknumber() {
        int min = 1;
        int max = 100;
        Random ran = new Random();
        randomNumber = ran.nextInt(max - min + 1) + min;
    }
    boolean matchguess(int guess) {
        if (guess == randomNumber) {
            System.out.println("Wow,Your Guess Matches");
            return true;

        } else if (guess > randomNumber + 10 || guess < randomNumber - 10) {
            System.out.println("You are too far");
            //System.out.println("The number is" + randomNumber);
            return false;


        } else if (guess < randomNumber + 10 || guess > randomNumber - 10) {
            System.out.println("You are too close");
            //System.out.println("The number is" + randomNumber);
            return false;
        }

            return false;
        }


}
public class Main {
    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        Picknumber obj1 = new Picknumber();
        System.out.println("You have 5 chances to guess the right number between 1-100");
        for(int i=0;i<5;i++) {
            System.out.println("Enter your guess in Integers");
            int guess = obj.nextInt();

            if (obj1.matchguess(guess)==true){
                break;
            }

        }
        System.out.println("Your turn is over");
        }
    }
