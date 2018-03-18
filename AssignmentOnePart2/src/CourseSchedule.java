import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CourseSchedule {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in); // To get input from the user
        System.out.print("Enter quarter: ");
        String quarter = scan.next(); // Quarter selected by user is stored in quarter variable
        System.out.print("Enter year: ");
        String year = scan.next(); // Year selected by user is stored in year variable
        System.out.print("Enter initial for the program: ");
        String initial = scan.next(); // Program initial selected by user is stored in inital variable
        System.out.println();
        System.out.println("Programs:");
        String extension = "https://www.bellevuecollege.edu/classes/" + quarter + year;

        URL second = new URL(extension); // To read the URL entered
        BufferedReader in = new BufferedReader(new InputStreamReader(second.openStream()));
        String inputLine = "";
        String text = "";
        while ((inputLine = in.readLine()) != null) {
            text += inputLine + "\n"; // Stores input from URL into text string
        }
        in.close();

        Pattern pattern = Pattern.compile("<a\\shref=\"\\Sclasses\\S" + quarter + year + ".*\">" + initial + "(.*)</a>\\s*(.*)\\s");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) { // If text matches pattern entered
            System.out.print(initial + matcher.group(1));
            System.out.println(" " + matcher.group(2)); // Prints out programs starting with that initial
        }

        System.out.println();
        System.out.print("Enter the program's name: ");
        scan.nextLine();
        String program = scan.nextLine(); // Stores program selected as program variable
        System.out.println();
        System.out.print("Enter the course ID: ");
        String courseABV = scan.next();
        String courseNumber = scan.next();
        String courseId = courseABV + " " + courseNumber;
        System.out.println();
        System.out.println(program + " courses in " + quarter + " " + year);
        System.out.println("==================================");
        String programSite = extension + "/" + courseABV;

        URL courseSite = new URL(programSite); // To read the URL entered
        BufferedReader inTwo = new BufferedReader(new InputStreamReader(courseSite.openStream()));
        String courseInput = "";
        String courseText = "";
        while ((courseInput = inTwo.readLine()) != null) {
            courseText += courseInput + "\n";
        }
        inTwo.close();

        Pattern patternTwo = Pattern.compile("<a\\shref=\"/classes/All/" + courseABV + "/" + courseNumber + "\">[\\s\\S]*?courseTitle\">(.*)</span>[\\s\\S]*?<th\\srowspan=\"2\"\\sscope=\"rowgroup\"\\sclass=\"nowrap\">(.*)</th>[\\s\\S]*?SearchString(.*)\">(.*)</a>");
        matcher = patternTwo.matcher(courseText);
        while (matcher.find()) {
            System.out.println("Code: " + courseId);
            System.out.println("Item#: " + matcher.group(2));
            System.out.println("Title: " + matcher.group(1));
            System.out.println("Instructor: " + matcher.group(4));
            System.out.println();
        }
    }
}




