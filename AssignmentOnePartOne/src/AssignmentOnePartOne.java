import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AssignmentOnePartOne {
    public static void main(String[] args) throws IOException {
        File f = new File("A.java");
        Scanner scan = new Scanner(f);
        String inputLine = "";
        String text = "";
        while (scan.hasNextLine()) {
            inputLine = scan.nextLine();
            text += inputLine + "\n";
        }

        Pattern pattern = Pattern.compile("(\\w*)\\s+(\\w*)\\s=\\s([^';]*)'*;|(\\w*)\\s+(\\w*)(\\w*);|(\\w*)\\s+(\\w*)\\s=\\s'*([^';]*)'*;");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) { // while matcher finds a match for one of the pattern scenarios
            if (matcher.group(1) == null && matcher.group(7) == null) { // if it matches with second scenario
                System.out.println("Type: " + matcher.group(4));
                System.out.println("Variable name: " + matcher.group(5));
                if (matcher.group(6).isEmpty()) { // Meaning the variable is not initialized to any value
                    System.out.println("Value: null");
                } else {
                    System.out.println("Value: " + matcher.group(6));
                }
            } else if (matcher.group(4) == null && matcher.group(7) == null) { // If pattern matches with first condition
                System.out.println("Type: " + matcher.group(1));
                System.out.println("Variable name: " + matcher.group(2));
                if (matcher.group(3).isEmpty()) { // Meaning the variable is not initialized to any value
                    System.out.println("Value: null");
                } else {
                    System.out.println("Value: " + matcher.group(3));
                }
            } else { // if matcher matches with pattern's third condition
                System.out.println("Type: " + matcher.group(7));
                System.out.println("Variable name: " + matcher.group(8));
                if (matcher.group(9).isEmpty()) { // Meaning the variable is not initialiized to any value
                    System.out.println("Value: null");
                } else {
                    System.out.println("Value: " + matcher.group(9));
                }
            }
            for (int i = 0; i < 31; i++) {
                    System.out.print("^"); // Prints out separator for each variable
            }
            System.out.println();
        }
        scan.close();
    }
}
