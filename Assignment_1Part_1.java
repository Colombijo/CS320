import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Assignment_1Part_1 {
    public static void main(String[] args) throws IOException {
        File f = new File("A.java");
        Scanner scan = new Scanner(f);
        String inputLine = "";
        String text = "";
        while (scan.hasNextLine()) {
            inputLine = scan.nextLine();
            text += inputLine + "\n";
        }

        // Pattern pattern = Pattern.compile("[\\s\\S]*?=\\s(.*);");
        Pattern pattern = Pattern.compile("//w+\\s//w+\\s(.*)\\s=");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println("Value: " + matcher.group(1));
        }


    }
}
