package Address;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Collections;

public class AddressReaderV1
{
    public static void main(String[] args) throws IOException
    {
        Scanner keyboard = new Scanner(System.in);
        String fileName;

        // Open input file:

        if (args.length > 0)
            fileName = args[0];
        else
        {
            System.out.print("\nEnter input file name: ");
            fileName = keyboard.nextLine().trim();
        }

        BufferedReader inputFile =
                new BufferedReader(new FileReader("/Users/joshuakrinsky/Downloads/"+fileName), 1024);



        PersonalDatabase database = new PersonalDatabase();

        String line="";
        String input="";
        int lineNum = 0;

        while ((line = inputFile.readLine()) != null)
        {
            input+=line;

            String[] s = line.split("\",");
            for(int i=0; i<s.length; i++)
                s[i] = s[i].replaceAll("\"","");

            String[] phone_email = s[7].split(",");

            PersonalInfo info = new PersonalInfo(s[0], s[1], s[3], s[4], s[5], s[6], phone_email[0], phone_email[1], s[8], s[9], s[10]);

            if(!database.contains(info))
                database.add(info);
            

        }

        inputFile.close();

        System.out.println("Done loading addresses " + database.size() + " entries");

        //randomly sets gender, pet, salary and number of children
        for(int i=0; i<database.size(); i++)
        {
            int gender = (int)(Math.random() * 3);

            if(gender == 0)
                database.get(i).setGender('M');
            else if(gender == 1)
                database.get(i).setGender('F');
            else
                database.get(i).setGender('N');

            int salary = (int) (Math.random() * 300000);
            salary += 20000;
            database.get(i).setSalary(salary);
            
            int pet = (int)(Math.random() * 3);

            if(gender == 0)
                database.get(i).setPet("Dog");
            else if(gender == 1)
                database.get(i).setPet("Cat");
            else
                database.get(i).setPet("Goat");
            
            int numb_children = (int)(Math.random() * 6);
            database.get(i).setchild(numb_children);
            
        }

        while(true)
        {
        		//user prompt for filters
            System.out.println("Search Database:");
            System.out.println("1. Find People from State");
            System.out.println("2. Search by gender");
            System.out.println("3. Search by salary");
            System.out.println("4. Search by pet type");
            System.out.println("5. search by number of children");
            System.out.println("6. sort by name");
            System.out.println("7. sort by number of children");
            System.out.println("8. sort by salary");
            System.out.println("9. sort by gender");
            System.out.println("10. Quit");

            int choice = keyboard.nextInt();
            keyboard.nextLine();

            switch(choice)
            {

                case 1:
                    System.out.println("Which state");
                    String state = keyboard.nextLine();
                    System.out.println(database.findPeopleFromState(state));
                    break;

                case 2:
                    System.out.println("Which gender M/F/N");
                    String answer = keyboard.next();
                    char gender = answer.charAt(0);
                    System.out.println(database.findByGender(gender));
                    break;

                case 3:
                    System.out.println("What is the minimum salary (Max 320,000)");
                    int salary = keyboard.nextInt();
                    System.out.println(database.findBySalary(salary));
                    break;
                case 4:
                    System.out.println("What is the minimum salary (Dog, Cat, Goat)");
                    String pet = keyboard.nextLine();
                    System.out.println(database.findByPet(pet));
                    break;
                case 5:
                    System.out.println("What is the minimum number of children");
                    int numbchild = keyboard.nextInt();
                    System.out.println(database.findByNumbChild(numbchild));
                    break;
                
                case 6:
                    System.out.println("Sorting by Name");
                    Collections.sort(database);
                    System.out.println(database);
                    break;

                case 7:
                    System.out.println("Sorting by number of children");
                    Collections.sort(database,new Comparatorer(1));
                    System.out.println(database);
                    break;

                case 8:
                    System.out.println("Sorting by salary");
                    Collections.sort(database,new Comparatorer(2));
                    System.out.println(database);
                    break;

                case 9:
                    System.out.println("Sorting by Gender");
                    Collections.sort(database,new Comparatorer(5));
                    System.out.println(database);
                    break;

                case 10:
                		return;

            }
        }
    }
}