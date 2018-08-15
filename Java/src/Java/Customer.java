package Java;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Customer implements Comparable<Customer> {
    private String first_name;
    private String last_name;
    private String address;
    private int totalAmtSpent;
    private ArrayList<String> items;
    private int customerId;
    private static int customers = 0;

    public Customer(String f, String l, String a, int t)
    {
        first_name = f;
        last_name = l;
        address = a;
        totalAmtSpent = t;
        customerId = customers++;
    }
    public boolean equals(Object a)
    {
        if(((Customer)a).last_name.equals(last_name) && ((Customer)a).customerId == customerId)
            return true;
        else
            return false;
    }
    public Customer Copy()
    {
        Customer a = new Customer(first_name,last_name,address,totalAmtSpent);
        return a;
    }
    public void setID()
    {
        customerId--;
    }
    public String toString()
    {
        return "Name: "+first_name+" "+last_name+"\naddress: "+address+"\ncost: "+totalAmtSpent+"\nID: "+customerId+"\n\n";
    }
    public int compareTo(Customer t)
    {
        int name_val;
        if(t.last_name.compareTo(last_name) != 0)
        {
           name_val = last_name.compareTo(t.last_name);
           return name_val;
        }
        else
        {
           int id_val = customerId - t.customerId;
           return id_val;
        }
    }
    public static void sort(Customer arr [])
    {
        int n = arr.length-1;
        while(n>1)
        {
            int max_pos=0;
            for(int k=0; k<arr.length; k++)
            {
                if(arr[k].compareTo(arr[max_pos]) > 0)
                {
                    max_pos = k;
                }
            }
            Customer temp = arr[max_pos];
            arr[max_pos] = arr[n];
            arr[n] = temp;
            n--;
        }
    }
    public static void main (String args[])
    {
        Customer one = new Customer("Casey","Whoseit","16 wallaby Lane",600);
        Customer two = new Customer("Nick","Whoseit","16 wallaby Lane",600);
        Customer three = new Customer("Greg","Smith","16 wallaby Lane",600);
        Customer four = new Customer("Michael","Zyberg","16 wallaby Lane",600);
        Customer [] a = {four,one,three,two};

        sort(a);
        for(int i=0; i<a.length; i++)
            System.out.println(a[i]);
    }
}
