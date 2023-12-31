import java.util.*;
import java.util.regex.*;
import java.io.*;

public class day3 {
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
                        // checks from indexOfSymbol to 2 spaces to the right -> 3 length
                        String slyRight = linesList.get(i - 1).substring(indexOfSymbol, indexOfSymbol + 3);
                        if( slyRight.matches(".?\\d{2,3}.?") ){
                            // System.out.println(slyRight);
                            if( slyRight.charAt(0) == '.' ){
                                if( linesList.get(i - 1).substring(indexOfSymbol + 1, indexOfSymbol + 4).charAt(2) == '.' ){
                                    sumAroundSymbol += Integer.parseInt(
                                    linesList.get(i - 1).substring(indexOfSymbol + 1, indexOfSymbol + 3)
                                    );
                                } else {
                                    sumAroundSymbol += Integer.parseInt(
                                    linesList.get(i - 1).substring(indexOfSymbol + 1, indexOfSymbol + 4)
                                    );
                                }
                            } else if( slyRight.charAt(2) == '.' ){
                                sumAroundSymbol += Integer.parseInt(
                                    linesList.get(i - 1).substring(indexOfSymbol, indexOfSymbol + 2)
                                );
                            } else {
                                sumAroundSymbol += Integer.parseInt(slyRight);
                            }
                        }
                        
                        String slyLeft = linesList.get(i - 1).substring(indexOfSymbol - 2, indexOfSymbol + 1);
                        if( slyLeft.matches(".?\\d{1,3}.?$")){

                           if( slyLeft.charAt(2) == '.' ){
                                if( linesList.get(i - 1).substring(indexOfSymbol - 3, indexOfSymbol).charAt(0) == '.' ){
                                    sumAroundSymbol += Integer.parseInt(
                                    linesList.get(i - 1).substring(indexOfSymbol - 2, indexOfSymbol)
                                    );
                                } else {
                                    sumAroundSymbol += Integer.parseInt(
                                    linesList.get(i - 1).substring(indexOfSymbol - 3, indexOfSymbol)
                                    );
                                }
                                System.out.println(slyLeft);
                            } else if( slyLeft.charAt(0) == '.' ){
                                    sumAroundSymbol += Integer.parseInt(
                                    linesList.get(i - 1).substring(indexOfSymbol - 1, indexOfSymbol + 1)
                                    );
                            } else {
                                sumAroundSymbol += Integer.parseInt(slyLeft);
                            }
                        }
                
                    }
                }
                //--------------------------------------------
                // bottom
                // String bottomPortion = linesList.get(i + 1).substring(indexOfSymbol - 1, indexOfSymbol + 2);
                // if( !bottomPortion.equals("...")){
                //     if(bottomPortion.matches("\\d+")){
                //         sumAroundSymbol += Integer.parseInt(bottomPortion);
                //     } else {
                //         // checks from indexOfSymbol to 2 spaces to the right -> 3 length
                //         String slyRight = linesList.get(i + 1).substring(indexOfSymbol, indexOfSymbol + 3);
                //         if( slyRight.matches(".?\\d{1,3}.?") ){
                //             // System.out.println(slyRight);
                //             if( slyRight.charAt(0) == '.' ){
                //                 if( linesList.get(i + 1).substring(indexOfSymbol + 1, indexOfSymbol + 4).charAt(2) == '.' ){
                //                     sumAroundSymbol += Integer.parseInt(
                //                     linesList.get(i + 1).substring(indexOfSymbol + 1, indexOfSymbol + 3)
                //                     );
                //                 } else {
                //                     sumAroundSymbol += Integer.parseInt(
                //                     linesList.get(i + 1).substring(indexOfSymbol + 1, indexOfSymbol + 4)
                //                     );
                //                 }
                //             // } else if( slyRight.charAt(1) == '.' ){
                //             //     // sumAroundSymbol += Integer.parseInt(
                //             //     //     linesList.get(i + 1).substring(indexOfSymbol, indexOfSymbol + 2)
                //             //     // );
                //             //     System.out.println(slyRight);
                //             } else if( slyRight.charAt(2) == '.' ){
                //                 sumAroundSymbol += Integer.parseInt(
                //                     linesList.get(i + 1).substring(indexOfSymbol, indexOfSymbol + 2)
                //                 );
                //             } else {
                //                 sumAroundSymbol += Integer.parseInt(slyRight);
                //             }
                //         }
                        
                //         String slyLeft = linesList.get(i + 1).substring(indexOfSymbol - 2, indexOfSymbol + 1);
                //         if( slyLeft.matches(".?\\d{2,3}.?$")){

                //            if( slyLeft.charAt(2) == '.' ){
                //                 if( linesList.get(i + 1).substring(indexOfSymbol - 3, indexOfSymbol).charAt(0) == '.' ){
                //                     sumAroundSymbol += Integer.parseInt(
                //                     linesList.get(i + 1).substring(indexOfSymbol - 2, indexOfSymbol)
                //                     );
                //                 } else {
                //                     sumAroundSymbol += Integer.parseInt(
                //                     linesList.get(i + 1).substring(indexOfSymbol - 3, indexOfSymbol)
                //                     );
                //                 }
                //             }  else if( slyLeft.charAt(0) == '.' ){
                //                     sumAroundSymbol += Integer.parseInt(
                //                     linesList.get(i + 1).substring(indexOfSymbol - 1, indexOfSymbol + 1)
                //                     );
                //             } else {
                //                 sumAroundSymbol += Integer.parseInt(slyLeft);
                //             }
                //         }
                //     }
                // }

                sum += sumAroundSymbol;
                // System.out.println(sumAroundSymbol);
                //---------
            }

        }

        return sum;
    }

    // public static _ part2(Scanner in){
        
    // }
}
