import java.util.*;
import java.util.regex.*;
import java.io.*;

public class day3revamp {
    private static ArrayList<String> linesList = new ArrayList<String>();
    public static void main(String[] args)throws IOException{
        Scanner in = new Scanner(new File("day3.dat"));
        datToList(in);
        System.out.println(part2(in));
    }

    public static void datToList(Scanner in){
        while(in.hasNextLine()){
            linesList.add(in.nextLine());
        }
    }

    public static int part1(Scanner in){
        int sum = 0;

        for(int i = 1; i < linesList.size() - 1; i++){
            String line = linesList.get(i);
            Matcher matSymbol = Pattern.compile("[@#$%&*+=+\\-\\/]").matcher(line);
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


                // top
                String topPortion = linesList.get(i - 1).substring(indexOfSymbol - 1, indexOfSymbol + 2);
                if( !topPortion.equals("...")){
                    if(topPortion.matches("^\\d{3}")){
                        sumAroundSymbol += Integer.parseInt(topPortion);
                    } else {
                        String middleLeft = linesList.get(i - 1).substring(indexOfSymbol - 3, indexOfSymbol + 1);
                        Matcher matLeft = Pattern.compile("^\\d{3}|(?<=.)\\d{2,3}|(?<=..)\\d").matcher(middleLeft);
                        if(matLeft.find() && topPortion.matches("^(\\d{1}|[.]{1}[^..])\\d?([.]{1,2}[\\d]?)$") ){ // INCLUDES CASE .3.
                            sumAroundSymbol += Integer.parseInt(matLeft.group());
                        }
                        
                        String middleRight = linesList.get(i - 1).substring(indexOfSymbol, indexOfSymbol + 4);
                        Matcher matRight = Pattern.compile("^\\d{2,3}|(?<=^.)\\d{2,3}|(?<=^.?)\\d").matcher(middleRight);
                        if(matRight.find() && topPortion.matches("^(\\d{1}|[.]{1,2})[.]?\\d{1,2}$") ){
                            sumAroundSymbol += Integer.parseInt(matRight.group());
                        }
                    }
                }
                // bottom
                String bottomPortion = linesList.get(i + 1).substring(indexOfSymbol - 1, indexOfSymbol + 2);
                if( !bottomPortion.equals("...")){
                    if(bottomPortion.matches("^\\d{3}")){
                        sumAroundSymbol += Integer.parseInt(bottomPortion);
                    } else {
                        String middleLeft = linesList.get(i + 1).substring(indexOfSymbol - 3, indexOfSymbol + 1);
                        Matcher matLeft = Pattern.compile("^\\d{3}|(?<=.)\\d{2,3}|(?<=..)\\d").matcher(middleLeft);
                        if(matLeft.find() && bottomPortion.matches("^(\\d{1}|[.]{1}[^..])\\d?([.]{1,2}[\\d]?)$") ){
                            sumAroundSymbol += Integer.parseInt(matLeft.group());
                        }
                        
                        String middleRight = linesList.get(i + 1).substring(indexOfSymbol, indexOfSymbol + 4);
                        Matcher matRight = Pattern.compile("^\\d{2,3}|(?<=^.)\\d{2,3}|(?<=^.?)\\d").matcher(middleRight);
                        if(matRight.find() && bottomPortion.matches("^(\\d{1}|[.]{1,2})[.]?\\d{1,2}$") ){
                            sumAroundSymbol += Integer.parseInt(matRight.group());
                        }
                    }
                }
                sum += sumAroundSymbol;
                if(sumAroundSymbol == 0){
                    System.out.println("bruh");
                }
                // System.out.println(sumAroundSymbol);
                //---------

            }
        }
        return sum;
    }

    public static int part2(Scanner in){
        int sum = 0;

        for(int i = 1; i < linesList.size() - 1; i++){
            String line = linesList.get(i);
            Matcher matSymbol = Pattern.compile("[*]").matcher(line);
            while(matSymbol.find()){
                
                int nums = 0;
                int prodAroundSymbol = 1;
                int indexOfSymbol = matSymbol.start();
                
                
                // left
                if(Character.isDigit(line.charAt(indexOfSymbol - 1))){
                    int leftNum = Integer.parseInt( line.substring(indexOfSymbol - 3, indexOfSymbol).replace(".", "") );
                    prodAroundSymbol *= leftNum;
                    nums++;
                }
                // right
                if(Character.isDigit(line.charAt(indexOfSymbol + 1))){
                    int rightNum = Integer.parseInt( line.substring(indexOfSymbol + 1, indexOfSymbol + 4).replace(".", "") );
                    prodAroundSymbol *= rightNum;
                    nums++;
                }


                // top
                String topPortion = linesList.get(i - 1).substring(indexOfSymbol - 1, indexOfSymbol + 2);
                if( !topPortion.equals("...")){
                    if(topPortion.matches("^\\d{3}")){
                        prodAroundSymbol *= Integer.parseInt(topPortion);
                        nums++;
                    } else {
                        String middleLeft = linesList.get(i - 1).substring(indexOfSymbol - 3, indexOfSymbol + 1);
                        Matcher matLeft = Pattern.compile("^\\d{3}|(?<=.)\\d{2,3}|(?<=..)\\d").matcher(middleLeft);
                        if(matLeft.find() && topPortion.matches("^(\\d{1}|[.]{1}[^..])\\d?([.]{1,2}[\\d]?)$") ){ // INCLUDES CASE .3.
                            prodAroundSymbol *= Integer.parseInt(matLeft.group());
                            nums++;
                        }
                        
                        String middleRight = linesList.get(i - 1).substring(indexOfSymbol, indexOfSymbol + 4);
                        Matcher matRight = Pattern.compile("^\\d{2,3}|(?<=^.)\\d{2,3}|(?<=^.?)\\d").matcher(middleRight);
                        if(matRight.find() && topPortion.matches("^(\\d{1}|[.]{1,2})[.]?\\d{1,2}$") ){
                            prodAroundSymbol *= Integer.parseInt(matRight.group());
                            nums++;
                        }
                    }
                }
                // bottom
                String bottomPortion = linesList.get(i + 1).substring(indexOfSymbol - 1, indexOfSymbol + 2);
                if( !bottomPortion.equals("...")){
                    if(bottomPortion.matches("^\\d{3}")){
                        prodAroundSymbol *= Integer.parseInt(bottomPortion);
                        nums++;
                    } else {
                        String middleLeft = linesList.get(i + 1).substring(indexOfSymbol - 3, indexOfSymbol + 1);
                        Matcher matLeft = Pattern.compile("^\\d{3}|(?<=.)\\d{2,3}|(?<=..)\\d").matcher(middleLeft);
                        if(matLeft.find() && bottomPortion.matches("^(\\d{1}|[.]{1}[^..])\\d?([.]{1,2}[\\d]?)$") ){
                            prodAroundSymbol *= Integer.parseInt(matLeft.group());
                            nums++;
                        }
                        
                        String middleRight = linesList.get(i + 1).substring(indexOfSymbol, indexOfSymbol + 4);
                        Matcher matRight = Pattern.compile("^\\d{2,3}|(?<=^.)\\d{2,3}|(?<=^.?)\\d").matcher(middleRight);
                        if(matRight.find() && bottomPortion.matches("^(\\d{1}|[.]{1,2})[.]?\\d{1,2}$") ){
                            prodAroundSymbol *= Integer.parseInt(matRight.group());
                            nums++;
                        }
                    }
                }
                if(nums == 2){
                    sum += prodAroundSymbol;
                }
  
                // System.out.println(sumAroundSymbol);
                //---------

            }
        }
        return sum;
    }
}