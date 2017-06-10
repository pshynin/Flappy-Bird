package master;

import org.junit.Test;

import java.util.Scanner;

/**
 * Created by pshynin on 6/9/17.
 */
public class FirstTest {
    /**
     * main
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Loop, asking for a new URL to be entered.
        do {
            System.out.println();
            System.out.println("Enter URL site (or 'exit')...");
            String baseUrl = sc.nextLine();
            if (baseUrl.equalsIgnoreCase("exit"))
                break;

            // Create a new MyUrl object and call its constructor
            MyUrl u = new MyUrl(baseUrl);
            System.out.println("Url value read was: " + baseUrl);

//      // Loop, asking for argument/value input
//      do {
//        System.out.println("Enter URL argument name (or 'done')...");
//        String argName = sc.nextLine();
//        if (argName.equalsIgnoreCase("done"))
//          break;
//        System.out.println("Enter type of argument value (string, integer, double)...");
//        String argType = sc.nextLine();
//
//        if (argType.startsWith("s")) {
//          System.out.println("Enter a string value");
//          String s = sc.nextLine();
//          u.addArgument(argName, s);
//        } else if (argType.startsWith("i")) {
//          System.out.println("Enter an integer value");
//          int i = sc.nextInt();
//          sc.nextLine();
//          u.addArgument(argName, i);
//        } else if (argType.startsWith("d")) {
//          System.out.println("Enter a double value");
//          double d = sc.nextDouble();
//          sc.nextLine();
//          u.addArgument(argName, d);
//        } else {
//          System.out.println("Unrecognized value type - must be (s)tring, (i)nteger, or (d)ouble");
//          continue;
//        }
//      }while (true);
//
//      // Display the final url
//      System.out.println("URL with appended arguments is:");
//      System.out.println("  " + u.toString());
//
        } while (true);

        // Keep console window alive until 'enter' pressed (if needed).
        System.out.println();
        System.out.println("Done - press enter key to end program");
        String junk = sc.nextLine();
    }

    public static class MyUrl {
        private static String baseUrl;

        public MyUrl(String url) {
            urlEncode(url);
        }

        public static String urlEncode(String text) {
            if (!text.startsWith("http://")) {
                return baseUrl = "http:// " + text;
            } else {
                return baseUrl = text;
            }
        }
    }
}
//Description
//
//In this assignment, you'll write a Java class that has an instance variable that is a String reference,
// a constructor method, a set of overloaded methods, and a class static method.
//
// Write a Java class called MyUrl that represents a URL (Uniform Resource Locator)
// with optional URL encoded parameters attached. It should have a private String instance variable representing the URL,
// and have the following public methods:
//
//public MyUrl(String url) - this constructor initializes the base URL to the url parameter value.
// It adds the protocol prefix http:// on the front if not present in the url parameter..
// For example, if the parameter is www.amazon.com, it sets the mUrl instance variable to http://www.amazon.com
// Note that a constructor has no return type, not even 'void'.
//
//public void addArgument(String name, String value) - this overloaded method adds a string argument to the URL
// of the form name=value.  It URL encodes both the name and value parameters by calling the urlEncode() method on each.
//
//public void addArgument(String name, int ivalue) - this overloaded method adds an int argument to the URL
// of the form name=value. It URL encodes the name parameter by calling urlEncode()..
// The value is the string representation of the ivalue parameter. Use Integer.toString(ivalue)
// to convert the integer to a string representation.
//
//public void addArgument(String name, double dvalue) - this overloaded method adds a double argument to the URL
// of the form name=value. It URL encodes the name parameter by calling urlEncode()..
// The value is the string representation of the dvalue parameter.
// Use Double.toString(dvalue) to convert the double to a string representation.
//
//public String toString() - this method returns the object's URL value (the base URL plus all arguments).
//
//public static String urlEncode(String text) - this static method URL encodes its parameter 
// String and returns the URL encoded value as the result.
// It is called by the addArgument methods to encode their name and value parameters
// before appending them to the object's URL. Use your earlier project code to implement
// this method - instead of reading a line of text, the parameter string contains the text to be URL encoded,
// and instead of printing the encoded string, it is returned as the method result.
//
//        ya zastryala v samom nachale na constructor method...
