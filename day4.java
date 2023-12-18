import java.util.*;
import java.io.*;


public class day4 {
    public static void main(String[] args)throws IOException{
        Scanner in = new Scanner(new File("day4.dat"));
        System.out.println(part1(in));
    }

    public static int part1(Scanner in){
        int sum = 0;

        while(in.hasNextLine()){
            String line = in.nextLine();
            
            int points = 0;
            String[] winningNumbers;
            String[] cardNumbers;

            if(line.substring(10, line.indexOf("|")).charAt(0) == ' '){ //makes array when first number is one digit
                winningNumbers = line.substring(11, line.indexOf("|")).split(" +");
            } else {
                winningNumbers = line.substring(10, line.indexOf("|")).split(" +");
            }

            if(line.substring(line.indexOf("|") + 2, line.length()).charAt(0) == ' '){ //makes array when first number is one digit
                cardNumbers = line.substring(line.indexOf("|") + 3, line.length()).split(" +");
            } else {
                cardNumbers = line.substring(line.indexOf("|") + 2, line.length()).split(" +");
            }
            
            for(int c = 0; c < cardNumbers.length; c++){
                for(int w = 0; w < winningNumbers.length; w++){
                    if(cardNumbers[c].equals(winningNumbers[w])){
                        if(points == 0){
                            points++;
                        } else {
                            points *= 2;
                        }
                    }
                }
            }
            sum += points;
        }

        return sum;
    }

    public static int part2(Scanner in){
        int sum = 0;

        while(in.hasNextLine()){
            String line = in.nextLine();
            
            int points = 0;
            String[] winningNumbers;
            String[] cardNumbers;

            if(line.substring(10, line.indexOf("|")).charAt(0) == ' '){ //makes array when first number is one digit
                winningNumbers = line.substring(11, line.indexOf("|")).split(" +");
            } else {
                winningNumbers = line.substring(10, line.indexOf("|")).split(" +");
            }

            if(line.substring(line.indexOf("|") + 2, line.length()).charAt(0) == ' '){ //makes array when first number is one digit
                cardNumbers = line.substring(line.indexOf("|") + 3, line.length()).split(" +");
            } else {
                cardNumbers = line.substring(line.indexOf("|") + 2, line.length()).split(" +");
            }
            
            for(int c = 0; c < cardNumbers.length; c++){
                for(int w = 0; w < winningNumbers.length; w++){
                    if(cardNumbers[c].equals(winningNumbers[w])){
                        if(points == 0){
                            points++;
                        } else {
                            points *= 2;
                        }
                    }
                }
            }
            sum += points;
        }

        return sum;
    }


}
