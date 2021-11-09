/*
Ziad Zaki
IDE 3
Coding Club Members
 */

import java.util.Scanner;

class NamesAndNumber {

    // function to check if number is correct
    static boolean checkNumber(String number) {
        return number.matches("[0-9]+");
    }

    // function to find a name in the names array
    static int findName(String names[], String name, int count){
        for (int i = 0; i < count; i++) {
            if(names[i].equals(name))
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        // Create a scanner object
        Scanner sc = new Scanner(System.in);

        // prompting the user to enter the number of records
        System.out.print("Enter number of records: ");
        int n = sc.nextInt();

        // consume the newline from the input stream
        sc.nextLine();

        // create arrays of n names and numbers
        String[] names = new String[n];
        String[] numbers = new String[n];

        // variable count will increase as more numbers are entered
        int count = 0;

        for (int i = 0; i < n; i++) {
            // prompt the user to enter a member's name
            System.out.print("\nEnter a member's name: ");
            names[i] = sc.nextLine();

            // check if user typed DONE
            if(names[i].equals("DONE")){
                // then user does not want to enter anymore records
                break;
            }
            else{
                // increment the count
                count = count + 1;
            }

            // prompt the user to enter a member's number
            System.out.println("\nMember's name: " + names[i]);
            System.out.print("Enter " + names[i] + "'s phone number: ");
            numbers[i] = sc.nextLine();

            // call checkNumber function to check if number is valid
            boolean valid = checkNumber(numbers[i]);

            while (valid == false) {
                System.out.println("Please enter a valid 10 digit number!");
                System.out.print("Enter " + names[i] + "'s phone number: ");
                numbers[i] = sc.nextLine();

                // call checkNumber() again
                valid = checkNumber(numbers[i]);
            }
        }

        // now print all the names and numbers
        System.out.println("\nPrinting all member's name and numbers:");
        for (int i = 0; i < count; i++) {
            System.out.println("\nMember name: "+ names[i]);
            System.out.println("Member number: "+ numbers[i]);
        }

        while(true){
            // prompt the user for a members name
            System.out.print("\nEnter a member's name to find their number(q to quit): ");
            String searchName = sc.nextLine();

            // check if searchName is equal to quit
            if(searchName.equals("q"))
                break;

            // call findName() function
            int index = findName(names, searchName, count);

            if(index != -1){
                // format the number
                String num = "("+numbers[index].substring(0, 3)+") "+numbers[index].substring(3, 6)+"-"+numbers[index].substring(6, 10);

                System.out.println("\n"+searchName+"'s phone number is " + num);
            }
            else{
                System.out.println("\n--THE NAME IS NOT IN THE LIST!--\n");
            }
        }

        // close the scanner object
        sc.close();
    }

}
