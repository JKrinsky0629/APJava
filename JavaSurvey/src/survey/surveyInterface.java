package survey;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Collections;

public class surveyInterface
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



        JavaClass database = new JavaClass();

        String line="";
        String input="";

        inputFile.readLine();
        while ((line = inputFile.readLine()) != null)
        {
            input+=line;

            String[] s = line.split(",");
            for(int i=0; i<s.length; i++)
             s[i] = s[i].replaceAll("\"","");
            if(s[3].contains(" ") || s[3].equals("Gonna") || s[3].contains("."))
            		s[3] = "17";
            int age = Integer.parseInt(s[3]);

            JavaStudent info = new JavaStudent(s[2], age, s[4], s[5], s[6], s[1]);
            database.add(info);
            

        }

        inputFile.close();
        database.removeDuplicateStudents();
        System.out.println("Fav Movie: "+database.findTheFavoriteMovie());
        System.out.println("Avg age: "+database.findAverageAge());
        System.out.println(database.getFavoriteMovies());
}
    
}
