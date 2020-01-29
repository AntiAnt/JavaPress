import java.util.Scanner;

public class DiceRoller {
    /*
    dice roller using user input to 
    detrmine the side of the die they wish to
    roll.
     */
    int sides;

    public DiceRoller(int sides){ // constructor setting value for sides of die
        this.sides = sides;
    }
    public int roll() { // rolling random numbers and returning them as an int
        double random = Math.random();
        double randomSides = random * this.sides;
        int dieCast = (int) randomSides;
        return dieCast + 1;
    }
    public static void main(String[] args){
        //boolean loop = true;
        while (true){
            Scanner choice = new Scanner(System.in); // user input initialization
            System.out.println("Enter number of sides on die (0 to exit dice roller)");
            int input = Integer.parseInt(choice.nextLine()); // user input parsed from String to int
            if (input <= 0) { // option to quit out of loop
                System.out.println("Quitting");
                break;
            }else{
                DiceRoller die = new DiceRoller(input);
                System.out.println(die.roll());
            }
        }
    }
}