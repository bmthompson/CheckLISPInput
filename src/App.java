import java.util.Scanner;

public class App {
    
    private static boolean checkInputString(String inputString) {
        String openP = "(";
        String closeP = ")";

        int nestCnt = 0;

        for (int i=0; i<inputString.length(); i++) {
            if (inputString.startsWith(openP, i)) {
                nestCnt++;
                //System.out.println("Found ( at location=" + i + "  ---> nextCnt=" + nestCnt);
            }

            if (inputString.startsWith(closeP, i)) {
                // Verify that there is already an accompaning open parentheses
                if (nestCnt <= 0) {
                    //System.out.println("ERROR:   Found ) at location=" + i + " with no open par yet");
                    nestCnt--;
                    break;
                }

                nestCnt--;
                //System.out.println("Found ) at location=" + i + "  ---> nextCnt=" + nestCnt);
            }
        }

        if (nestCnt != 0) {
            //System.out.println("ERROR:   Mismatched Parentheses   ---  nestCnt=" + nestCnt);
            return false;
        }

        //System.out.println("Parentheses matched!!!");
        return true;
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        boolean contLoop = true;
        while (contLoop) {
            System.out.println("Input test string:");
            String testString = scanner.nextLine();
            if (testString.length() <= 0) break;

            //System.out.println(("test string=" + testString));
            if (checkInputString( testString )) {
                System.out.println("Parentheses matched!!!");
            } else {
                System.out.println("ERROR:   Mismatched Parentheses!!!");
            }
        }

        scanner.close();
        //System.out.println("Finished, LISP Checker!");
    }
}
