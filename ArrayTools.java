/**
Student Name: Kunwar Vats
Student Number: A00251176
Program Description: A small command line application (ArrayTools.java) that provides useful tools to developers:
encrypt Create a Caesar cipher method that accepts a String (the String to encrypt), a shift value, and returns the new String.
arrayAvg Write a method that accepts an array and produces the average of all values (array should be numeric type)
arrayContains Write a method that accepts an array and a search value, and determines if the array contains the value (true/false) (can use any data type you want)
reverse Write a method that reverses an array (gives a new array) (can use any data type you want)
 */

import java.util.Scanner;

class ArrayTools {

    static int[] intArray = new int[]{ 12, 42, 3, 55, 11, 26, 81, 2 };

    //This is the main method
    public static void main(String[] args) {

      getUserInput();
    }

    //This method prompts user to select a command
    static void getUserInput()
    {
        System.out.println("Enter index of the following commands to run them");
        System.out.println("1. Caesar cipher");
        System.out.println("2. Average of array");
        System.out.println("3. Array contains value or not");
        System.out.println("4. Reverse array");
        System.out.println("\nOr type q to exit.\n");

        Scanner sc = new Scanner(System.in);

        if (sc.hasNextInt()) {
            int strInput = sc.nextInt();
            selectCommand(strInput);
        }
        else if (sc.hasNext("q"))
        {
            System.exit(0);
        }
        else {
            System.out.println("Invalid user input.");
            getUserInput();
        }
    }

    //This method decides which command to perform
    //Parameters: strInput
    static void selectCommand(int strInput)
    {
        if (strInput == 1)
        {
            getInputToEncrypt();
            getUserInput();
        }
        else if (strInput == 2)
        {
            System.out.println("The given array is: ");
            printArray(intArray);
            arrayAvg(intArray);
            getUserInput();
        }
        else if (strInput == 3)
        {
            System.out.println("The given array is: ");
            printArray(intArray);
            arrayContains(intArray);
            getUserInput();
        }
        else if (strInput == 4)
        {
            System.out.println("The given array is: ");
            printArray(intArray);
            reverse(intArray);
            getUserInput();
        }
        else
        {
            System.out.println("Invalid user input.");
            getUserInput();
        }
    }

    //This method gets user inputs for Caesar cypher and calls the encrypt method
    static void getInputToEncrypt()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter string to encrypt. ");

        String strValue = sc.nextLine();
        System.out.println("Enter a value to encrypt with. ");

        if (sc.hasNextInt())
        {
            int intValue = sc.nextInt();
            encrypt(strValue, intValue);
        }
        else {
            System.out.println("Invalid user input. Please try again.\n");
            getInputToEncrypt();
        }
    }

    //This method encrypts the given string with the offset by Caesar cypher
    //Parameters: message, offset
    static void encrypt(String message, int offset)
    {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < message.length(); i++)
        {
            char character = message.charAt(i);
            if (character != ' ') {
                int originalAlphabetPosition = character - 'a';
                int newAlphabetPosition = (originalAlphabetPosition + offset) % 26;
                char newCharacter = (char) ('a' + newAlphabetPosition);
                result.append(newCharacter);
            } else {
                result.append(character);
            }
        }

        System.out.println("\nEncrypted string is " + result);
        System.out.println("Decrypting " + result + " with -" + String.valueOf(offset) + "....\n" + message + "\n\n");
   }

    //This method prints all the elements of array
    // Parameters: Array of integers
    static void printArray(int[] arrInt)
    {
      String strArr = "";

      for (int i = 0; i < arrInt.length; i++)
      {
          strArr += String.valueOf(arrInt[i]);
          if (i != arrInt.length - 1)
          {
              strArr += ", ";
          }
      }

      System.out.println(strArr);
    }

    //This method calculates average of the array
    // Parameters: Array of integers
    static void arrayAvg(int[] arrInt)
    {
        double avg = 0.0;

        for (int i = 0; i < arrInt.length; i++)
        {
            avg += arrInt[i];
        }

        avg = avg / arrInt.length;

        System.out.println("Average of the given array is: " + String.valueOf(avg) + "\n\n");
    }

    //This method checks if array contains integer
    //Parameters: Array of integer and integer value
    //Returns: true/false
    static void arrayContains(int[] arrInt)
    {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt())
        {
            int value = sc.nextInt();

            for (int i = 0; i < arrInt.length; i++)
            {
                if (arrInt[i] == value)
                {
                    System.out.println("\nGiven array contains " + String.valueOf(value) + "\n\n");
                }
            }

            System.out.println("\nGiven array does not contains " + String.valueOf(value) + "\n\n");
        }
        else
        {
            String value = sc.nextLine();
            System.out.println("\nGiven array does not contains " + String.valueOf(value) + "\n\n");
        }
    }

    //This method reverses the array
    // Parameters: Array of integers
    //Returns: Array of integers
    static void reverse(int[] arrInt)
    {
        int[] reverseArr = new int[arrInt.length];
        for (int i = arrInt.length - 1; i >= 0; i--)
        {
            reverseArr[arrInt.length - i - 1] = arrInt[i];
        }

        System.out.println("The reversed array is: ");
        printArray(reverseArr);
        System.out.println("\n");
    }
}
