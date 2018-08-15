package TypingGame;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Problems extends ArrayList<String>{
	private ArrayList<String> problems;
	public Problems ()
	{
		problems = new ArrayList<String>();
	}
	public void place() throws IOException
	{
		BufferedReader inputFile =
                new BufferedReader(new FileReader("/Users/joshuakrinsky/Downloads/large.txt"), 1024);
		String word;
		while((word = inputFile.readLine()) != null) //reads each line as a file
		{
			problems.add(word); //puts each line into an arraylist
		}
		Collections.sort(problems); //sorts all words
	}
	public String return_word_random() //returns a random word within the arraylist 
	{
		int rand = (int)(Math.random()* problems.size());
		return problems.get(rand);
	}
	
	/*public static void main(String args[])
	{
		//tested to see if place works and if return word random works
		Problems a = new Problems();
		try {
			a.place();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(a);
		String random = a.return_word_random();
		System.out.println(random);
	}*/
}
