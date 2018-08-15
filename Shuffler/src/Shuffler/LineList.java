package Shuffler;

import java.util.ArrayList;

public class LineList extends ArrayList<String> {	
	public LineList()
	{
		super();
	}
	/*public int size()
	{
		return line.size();
	}
	public String get(int i)
	{
		return line.get(i);
	}
	public void add(String a)
	{
		line.add(a);
	}
	public String remove(int k)
	{
		return line.remove(k);
	}*/
	public void move(int i, int j)
	{
		String temp = get(i);
		set(i,get(j));
		set(j, temp);
	}
	public void shuffle()
	{
		for(int i=0; i<size(); i++)
		{
			int j = (int) (Math.random()*(size()));
			int k = (int) (Math.random()*(size()));
			move(j,k);
		}
	}

}
