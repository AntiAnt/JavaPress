package com.company;
import java.util.*;// for ArrayList and Collections classes
class RollDice {
    int sum = 0;

    public int roll(int numDice, int sides, boolean ability) {
        ArrayList<Integer> rolls = new ArrayList<Integer>();
        for ( int i = numDice; i > 0; i--) {
            double random = Math.random() * sides;
            int die = (int) random;
            rolls.add(die + 1);
        }

        if (ability) {
            Collections.sort(rolls);
            rolls.remove(0);
            for (int i: rolls) {
                sum += i;
            }
            return sum;
        }else {
            int sum = 0;
            for (int i: rolls) {
                sum += i;
            }
            return sum;
        }
    }
}
class Character {
    int maxHp;
    int currentHp;
    int initiative;
    String charName;
    //String charClass;
    boolean hasMove;
    boolean hasAction;
    int str;
    int dex;
    int con;
    int coordinateX;
    int coordinateY;
    boolean isAlive;

    RollDice roller = new RollDice();

    public Character(String setName) {

        charName = setName;
        str = roller.roll(4,6,true);
        dex = roller.roll(4,6,true);
        con = roller.roll(4,6,true);
        maxHp = roller.roll(1,12,false) + (con - 10)/2;
        currentHp = this.maxHp;
        initiative = (dex - 10)/2;
        hasAction = true;
        hasMove = true;
        isAlive = true;

    }
    public int getCurrentHpHp(){
        return this.currentHp;
    }
    public int rollInitiative() {
        return roller.roll(1, 20, false) + initiative;
    }
}

class GameStart {
    boolean combat = false;
    boolean isAlive = true;

    public GameStart(String name){
        Character player = new Character(name);
        Character enemy = new Character("Enemy");
        player.coordinateX = 0;
        player.coordinateY = 0;
        enemy.coordinateX = 2;
        enemy.coordinateY = 2;

        Scanner input = new Scanner(System.in);

        while(isAlive) {
            if (!isAlive){
                System.out.println("Game Over");
                break;
            }else {
                System.out.println(player.charName);
                System.out.println(player.getCurrentHpHp());
                System.out.println("What would you like to do?: ");
                String choice = input.nextLine();
                switch (choice) {
                    case "west":
                        player.coordinateX--;
                        break;
                    case "east":
                        player.coordinateX++;
                        break;
                    case "north":
                        player.coordinateY++;
                        break;
                    case "south":
                        player.coordinateY--;
                    case "quit":
                        isAlive = false;
                        break;
                    default:
                        System.out.println("invalid entry: east, west, north, south, quit");
                        break;
                }
                if (player.coordinateX == enemy.coordinateX && player.coordinateY == enemy.coordinateY) {
                    System.out.println("You see the enemy before you!");
                }
            }

        }
    }

}
public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Name: ");
        String name = input.nextLine();
	    GameStart game = new GameStart(name);

    }

}
