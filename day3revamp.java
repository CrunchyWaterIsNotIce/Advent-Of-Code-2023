import java.util.*;
import java.util.regex.*;
import java.io.*;

public class day3revamp {
    private static ArrayList<String> linesList = new ArrayList<String>();
    public static void main(String[] args)throws IOException{
        Scanner in = new Scanner(new File("day3.dat"));
        datToList(in);
        System.out.println(part1(in));
    }

    public static void datToList(Scanner in){
        while(in.hasNextLine()){
            linesList.add(in.nextLine());
        }
    }

    public static int part1(Scanner in){
        int sum = 0;
        // Pattern pat = Pattern.compile("[\\*\\$\\/@=%#&+]"); // find 
        // (?<=[\\*\\$\\/@=%#&+])\d+|\d+(?=[\\*\\$\\/@=%#&+]) finds numbers left or right of symbol
        // 
        for(int i = 1; i < linesList.size() - 1; i++){
            String line = linesList.get(i);
            Matcher matSymbol = Pattern.compile("[\\*\\$\\/@=%#&+]").matcher(line);
            while(matSymbol.find()){
                
                int sumAroundSymbol = 0;
                int indexOfSymbol = matSymbol.start();
                
                
                // left
                if(Character.isDigit(line.charAt(indexOfSymbol - 1))){
                    int leftNum = Integer.parseInt( line.substring(indexOfSymbol - 3, indexOfSymbol).replace(".", "") );
                    sumAroundSymbol += leftNum;
                }
                // right
                if(Character.isDigit(line.charAt(indexOfSymbol + 1))){
                    int rightNum = Integer.parseInt( line.substring(indexOfSymbol + 1, indexOfSymbol + 4).replace(".", "") );
                    sumAroundSymbol += rightNum;
                }


                //--------------------------------------------
                String topPortion = linesList.get(i - 1).substring(indexOfSymbol - 1, indexOfSymbol + 2);
                if( !topPortion.equals("...")){
                    if(topPortion.matches("\\d+")){
                        sumAroundSymbol += Integer.parseInt(topPortion);
                    } else {
                        String middleLeft = linesList.get(i - 1).substring(indexOfSymbol - 3, indexOfSymbol + 1);
                        if(middleLeft.matches("^\\d{3}|(?<=.)\\d{2,3}|(?<=.{2})\\d")){
                            System.out.println(middleLeft);
                        }
                    }
               
                sum += sumAroundSymbol;
                // System.out.println(sumAroundSymbol);
                //---------
                }

            }
        }
        return sum;
    }

    // public static _ part2(Scanner in){
        
    // }
}
