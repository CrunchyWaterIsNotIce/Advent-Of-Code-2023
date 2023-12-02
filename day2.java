import java.util.*;
import java.util.regex.*;
import java.io.*;
// https://www.freeformatter.com/java-regex-tester.html#before-output

public class day2 {
    private static int RC = 12;
    private static int GC = 13;
    private static int BC = 14;
    public static void main(String[] args)throws IOException{
        Scanner in = new Scanner(new File("day2.dat"));
        System.out.println(part2(in));
    }

    public static int part1(Scanner in){
        int sum = 0;
        /** Lookahead that a white space is before a [0-9] digit including the next charactier if it is the same type,
         *  then a space, then including a set of characters with a lookahead seeking if there is a new word and including
         *  the length of atleast 3 to at most 5.
         *  */
        Pattern pat = Pattern.compile("(?<=\\s)\\d+ [(?=\\w)]{3,5}");

        while(in.hasNextLine()){
            String line = in.nextLine();

            int id = Integer.parseInt(line.substring(line.indexOf(" ") + 1, line.indexOf(":")));

            boolean pass = true;
            Matcher mat = pat.matcher(line);
            while(mat.find()){
                String temp = mat.group();
                int numCubes = Integer.parseInt(temp.substring(0, temp.indexOf(" ")));
                String color = temp.substring(temp.indexOf(" ") + 1);
                
                if(color.equals("red")){
                    if (numCubes > RC) pass = false;
                } else if(color.equals("green")){
                    if (numCubes > GC) pass = false;
                } else if(color.equals("blue")){
                    if (numCubes > BC) pass = false;
                }
            }
            if(pass){
                sum += id;
            }
        }
        return sum;
    }

    public static int part2(Scanner in){
        int sum = 0;
        Pattern pat = Pattern.compile("(?<=\\s)\\d+ [(?=\\w)]{3,5}");

        while(in.hasNextLine()){
            String line = in.nextLine();

            // int id = Integer.parseInt(line.substring(line.indexOf(" ") + 1, line.indexOf(":")));

            Matcher mat = pat.matcher(line);
            int reds = Integer.MIN_VALUE;
            int greens = Integer.MIN_VALUE;
            int blues = Integer.MIN_VALUE;
            while(mat.find()){
                String temp = mat.group();
                int numCubes = Integer.parseInt(temp.substring(0, temp.indexOf(" ")));
                String color = temp.substring(temp.indexOf(" ") + 1);
                
                if(color.equals("red")){
                    if (numCubes > reds) reds = numCubes;
                } else if(color.equals("green")){
                    if (numCubes > greens) greens = numCubes; 
                } else if(color.equals("blue")){
                    if (numCubes > blues) blues = numCubes;
                }
            }
            sum += reds * greens * blues;
        }
        return sum;
    }
}
