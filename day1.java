import java.util.*;
import java.util.regex.*;
import java.io.*;

public class day1{
    public static void main(String[] args)throws IOException{
        Scanner in = new Scanner(new File("day1.dat"));

        // PART 1
        // ------
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
        // -----

        // PART 2
        int sum = 0;
        while(in.hasNextLine()){
            Pattern num = Pattern.compile("^\\btwo\\b");
            Matcher match = num.matcher(in.nextLine());
            String temp = "";
            while(match.find()){
                temp += "" + match.group(2);
            }
            // if(temp.length() == 1){
            //     temp += temp;
            // }
            // sum += Integer.parseInt(temp.substring(0,1) + temp.substring(temp.length() - 1, temp.length()));
            System.out.println(temp);
        }
        // System.out.println(sum);
    }
}