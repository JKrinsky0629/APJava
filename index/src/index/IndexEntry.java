package index;

import java.util.ArrayList;

public class IndexEntry {
	private String word;
	private ArrayList<Integer> numsList; //represents
	
	public IndexEntry(String s)
	{
		word = s.toUpperCase();
		numsList = new ArrayList<Integer>();
	}
	public void add(int n)
	{
		for(int i=0; i<numsList.size(); i++)
		{
			if(numsList.get(i) == n)
				return;
		}
		numsList.add(n);
	}
	public String getWord()
	{
		return word;
	}
	public String toString()
	{
		String placement = "";
		for(int i=0; i<numsList.size(); i++)
			placement += numsList.get(i)+", ";
		
		return word+" "+placement;
	}

}
