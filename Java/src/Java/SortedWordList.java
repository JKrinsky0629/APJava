package Java;

import java.util.ArrayList;

public class SortedWordList extends ArrayList<String> {
    public SortedWordList()
    {
        super();
    }
    public SortedWordList(int i)
    {
        super(i);
    }
    public boolean contains(Object T)
    {
        int left = 0;
        int right = size();
        while(left <= right)
        {
            int middle = ((left + right)/2);
            System.out.println(left+" "+right+" "+middle);
            if(((String)T).equalsIgnoreCase(get(middle))) //if finds middle
                return true;

            else if(((String)T).compareTo(get(middle)) < 0)
            {
                left = middle + 1;
            }
            else if(((String)T).compareTo(get(middle)) > 0)
            {
                right = middle - 1;
            }
        }
        return false;
    }
    public int indexOf(Object T)
    {
        int left =0;
        int right = size();
        while(left <= right)
        {
            int middle = (left + right)/2; //averages left and right
            if(((String)T).equalsIgnoreCase(get(middle)))
                return middle;

            else if(((String)T).compareTo(get(middle)) < 0)
            {
                left = middle + 1;
            }
            else if(((String)T).compareTo(get(middle)) > 0)
            {
                right = middle - 1;
            }
        }
        return -1;
    }
    public String set(int i, String w)
    {
        if( (i==0 ||(w.compareTo(get(i-1)) > 0)) && (i+1 == size() || (w.compareTo(get(i+1)) < 0)))
        {
            return super.set(i,w); //run arraylist set
        }
        else
            throw new IllegalArgumentException("word= "+w +" I= "+i);
    }
    public void add(int i, String w)
    {
        if((i == 0 || (w.compareTo(get(i-1)) > 0)) && (i== size() ||(w.compareTo(get(i)) < 0)))
        {
            super.add(i,w);
        }
        else
            throw new IllegalArgumentException("word= "+w +"I= "+i); //throws illegal exception
    }
    public boolean add(String w) {
        int left = 0;
        int right = size();
        if(size() < 1)
        {
            super.add(w); //runs arraylist add
            return true;
        }
        while (left <= right) {
            int middle = (left + right) / 2;
            if (middle != size() && w.equalsIgnoreCase(get(middle))) {
                return false;
            }
            if((middle == 0 ||(w.compareTo(get(middle-1)) > 0)) && (middle == size() || w.compareTo(get(middle)) < 0))//if fits inbetween the two points
            {
                super.add(middle,w);
                return true;
            }
            else if (w.compareTo(get(middle)) > 0)
                left = middle + 1;

            else if (w.compareTo(get(middle)) < 0)
                right = middle - 1;
        }
        return false;
    }
}