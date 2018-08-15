package survey;

import java.util.ArrayList;


public class JavaClass extends ArrayList<JavaStudent>{
	public JavaClass()
	{
		super();
	}
	public ArrayList<String> getFavoriteMovies(){
		ArrayList<String> retVal = new ArrayList<String>();
		for(int i=0; i<size(); i++){
			ArrayList<String> movies = get(i).getMovies();
			for(String m: movies)
			{
				if(retVal.size() == 0)
				{
					retVal.add(m);
				}

					if(!(retVal.get(i).equalsIgnoreCase(m)))
					{
						retVal.add(m);
					}
			}
		}
		return retVal;
	}

	public String findTheFavoriteMovie(){
		ArrayList<String> all_movies = new ArrayList<String>();
		for(int i=0; i<size(); i++){
			ArrayList<String> movies = get(i).getMovies();
			all_movies.addAll(movies);
		}
		int[] parallel = new int[all_movies.size()];
		for(int i= 0; i<all_movies.size(); i++)
		{
			int cnt = 0;
			for(int j= 0; j<all_movies.size(); j++)
			{
				if(all_movies.get(i).equals(all_movies.get(j)))
				{
					cnt++;
					parallel[i] = cnt;
				}
			}
		}
		int highest = 0;
		int highest_index=0;
		for(int i=0; i<all_movies.size(); i++)
		{
			System.out.println("Movie: "+all_movies.get(i)+"\nVotes: "+ parallel[i]);
			if(parallel[i] > highest)
			{
				highest = parallel[i];
				highest_index = i;
			}
		}
		return all_movies.get(highest_index);
	}
	void removeDuplicateStudents()
	{
		for(int i=0; i<size(); i++)
		{
			String email = get(i).getEmail();
			for(int j=0; j<size(); j++)
			{
				if(email.equals(get(j).getEmail()) && i!=j)
				{
					remove(j);
					j--;
				}
			}
		}
	}
	public int findAverageAge()
	{
		int sum =0;
		for(int i=0; i<size(); i++)
		{
			sum+= get(i).getAge();
			System.out.println(get(i).getAge()+"\n");
		}
		sum/=size();
		return sum;
	}
}


