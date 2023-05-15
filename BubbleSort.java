// Importing
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
* The program uses bubble sort.
*
* @author  Adrijan Vranjkovic
* @version 1.0
* @since   2023-05-15
*/

public final class BubbleSort {
    /**
    * For style checker.
    *
    * @exception IllegalStateException Utility class.
    * @see IllegalStateException
    */
    private BubbleSort() {
        throw new IllegalStateException("Utility class");
    }

    /**
    * This is the main method.
    *
    * @param args Unused
    */
    public static void main(String[] args) {

        // Create a list to hold the input arrays
        final ArrayList<int[]> inputList = new ArrayList<>();

        try {
            // Create input/output file and scanner
            final File input = new File("input.txt");
            final Scanner scanInput = new Scanner(input);
            final FileWriter output = new FileWriter("output.txt");

            while (scanInput.hasNextLine()) {
                // cut off any trailing white spaces
                final String line = scanInput.nextLine().trim();

                // Skip any blank lines/
                if (!line.isEmpty()) {
                    // Parse the input line and store the resulting array
                    final int[] arrOfInt = parseInputLine(line);

                    if (arrOfInt != null) {
                        inputList.add(arrOfInt);
                    } else {
                        output.write("Invalid input\n");
                    }
                }
            }

            // Call bubble sort to sort each array
            for (int[] arrOfInt : inputList) {
                bubbleSort(arrOfInt);
                output.write(Arrays.toString(arrOfInt) + "\n");
            }

            // Close output
            output.close();

        } catch (IOException err) {
            // Display error
            System.err.println("Error: " + err.getMessage());
        }
    }

    /**
    * This function uses bubble sort.
    *
    * @param line *
    * @return arrOfInt
    */
    private static int[] parseInputLine(String line) {

        final String[] numStrings = line.split(" ");
        final int[] arrOfInt = new int[numStrings.length];
        for (int i = 0; i < numStrings.length; i++) {
            try {
                arrOfInt[i] = Integer.parseInt(numStrings[i]);
            } catch (NumberFormatException fnfex) {
                // Return null if it's not an integer.
                return null;
            }
        }
        return arrOfInt;
    }

    /**
    * This function uses bubble sort.
    *
    * @param arrayNum *
    */
    public static void bubbleSort(int[] arrayNum) {
        for (int i = 0; i < arrayNum.length - 1; i++) {
            for (int j = 0; j < arrayNum.length - i - 1; j++) {
                if (arrayNum[j] > arrayNum[j + 1]) {
                    // Swap elements if they are in the wrong order
                    final int temp = arrayNum[j + 1];
                    arrayNum[j + 1] = arrayNum[j];
                    arrayNum[j] = temp;
                }
            }
        }
    }
}
