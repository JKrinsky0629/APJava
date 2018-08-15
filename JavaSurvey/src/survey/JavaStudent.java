package survey;

import java.util.ArrayList;

public class JavaStudent {
	private String name;
	private int age;
	private ArrayList<String> favoriteMovies;
	private String email;
	public JavaStudent(String n, int a, String m1, String m2, String m3,String e)
	{
		name = n;
		age = a;
		favoriteMovies = new ArrayList<String>();
		favoriteMovies.add(m1);
		favoriteMovies.add(m2);
		favoriteMovies.add(m3);
		email =e;
	}
	public int getAge()
	{
		return age;
	}
	public String getName()
	{
		return name;
	}
	public void addMovies(String m)
	{
		favoriteMovies.add(m);
	}
	public ArrayList<String> getMovies()
	{
		return favoriteMovies;
	}
	public String getMovie(int i)
	{
		return favoriteMovies.get(i);
	}
	public void RemoveLongNames()
	{
		for(int i=0; i<favoriteMovies.size(); i++)
		{
			if(favoriteMovies.get(i).length() > 6)
			{
				favoriteMovies.remove(i);
				i--;
			}
		}
	}
	public String getEmail()
	{
		return email;
	}
	public String toString()
	{
		return "Name: "+name+"\nmovies: "+favoriteMovies;
	}
}
