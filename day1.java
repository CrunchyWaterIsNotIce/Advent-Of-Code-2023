import java.util.*;
// import java.util.regex.*;
import java.io.*;

public class day1{
    public static void main(String[] args)throws IOException{
        Scanner in = new Scanner(new File("day1.dat"));

        // PART 1
        // int sum = 0;
        // while(in.hasNextLine()){
        //     Pattern num = Pattern.compile("\\d+");
        //     Matcher match = num.matcher(in.nextLine());
        //     String temp = "";
        //     while(match.find()){
        //         temp += "" + match.group();
        //     }
        //     if(temp.length() == 1){
        //         temp += temp;
        //     }
        //     sum += Integer.parseInt(temp.substring(0,1) + temp.substring(temp.length() - 1, temp.length()));
        // }
        // System.out.println(sum);

        // PART 2
        int sum = 0;
        String[] wordArr = new String[] {"one","two","three","four","five","six","seven","eight","nine"};
        String[] numArr = new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
        while(in.hasNextLine()){
            String line = in.nextLine();
            int indexNumAtLine = Integer.MAX_VALUE;
            int tempIndexAtArr = -1;
    
            String calib = "";
            for(int i = 0; i < 9; i++){
                if(line.indexOf(wordArr[i]) != -1){
                    if(line.indexOf(wordArr[i]) < indexNumAtLine){
                        indexNumAtLine = line.indexOf(wordArr[i]);
                        tempIndexAtArr = i;

                    }
                }
                if(line.indexOf(numArr[i]) != -1){
                    if(line.indexOf(numArr[i]) < indexNumAtLine){
                        indexNumAtLine = line.indexOf(numArr[i]);
                        tempIndexAtArr = i;
   
                    } 
                }
            }
            calib += numArr[tempIndexAtArr];

            line = new StringBuilder(line).reverse().toString();
            indexNumAtLine = Integer.MAX_VALUE;
            for(int i = 0; i < 9; i++){
                String reverseWord = new StringBuilder(wordArr[i]).reverse().toString();
                if(line.indexOf(reverseWord) != -1){
                    if(line.indexOf(reverseWord) < indexNumAtLine){
                        indexNumAtLine = line.indexOf(reverseWord);
                        tempIndexAtArr = i;
                    }
                }
                if(line.indexOf(numArr[i]) != -1){
                    if(line.indexOf(numArr[i]) < indexNumAtLine){
                        indexNumAtLine = line.indexOf(numArr[i]);
                        tempIndexAtArr = i;
   
                    } 
                }
            }
            calib += numArr[tempIndexAtArr];

            sum += Integer.parseInt(calib);
        }
        System.out.println(sum);
    }
}