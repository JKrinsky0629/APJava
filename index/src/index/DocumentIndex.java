package index;

import java.util.ArrayList;

public class DocumentIndex extends ArrayList<IndexEntry>{
	public DocumentIndex()
	{
		super();
	}
	public DocumentIndex(int i)
	{
		super(i);
	}
	public void addWord(String word, int num)
	{
		//word = word.toUpperCase();
		IndexEntry e = new IndexEntry(word);
		for(int i=0; i<size(); i++)
		{
			if(size() ==0)
				add(e);
			if(get(i).getWord().equalsIgnoreCase(word))
			{
				get(i).add(num);
				return;
			}	
		}
		for(int i=0; i<size(); i++)
		{
			if(word.compareToIgnoreCase(get(i).getWord()) > 0)
			{	
			}
			else
			{
				add(i,e);
				get(i).add(num);
				return;
			}	
		}
		add(e);
		get(indexOf(e)).add(num);
	}
	public void addAllWords(String str, int num)
	{	
		String[] split = str.split("\\W+");
		for(int i=0; i<split.length; i++)
		{
			if(split[i].equals(""))
			{
				
			}
			else
			{
				addWord(split[i], num);
			}
		}
		
	}

}
