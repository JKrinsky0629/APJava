package Address;

import java.util.ArrayList;

public class PersonalInfo  implements Comparable<PersonalInfo> {
	private String first_name;
	private String last_name;
	private Address address;
	
	ArrayList<String> phone_numbers;
	ArrayList<String> email_address;
	ArrayList<String> website;
	private char gender;
	private int salary;
	private String pet_type;
	private int numb_child;
	
	public PersonalInfo(String namef, String nameL, String strName, String town, String county, String state,
			String zip_code,String phone, String phone2, String email, String web)
	{//constructor using for persons info
		first_name = namef;
		last_name = nameL;
		address = new Address(strName,town,county,state,zip_code); //creats new address
		phone_numbers = new ArrayList<String>(); //creates new array list
		email_address = new ArrayList<String>();
		website = new ArrayList<String>();
		phone_numbers.add(phone); //adds phone
		phone_numbers.add(phone2); //adds second phone number
		email_address.add(email);
		website.add(web); //adds website
	}
	public void setGender(char a) //sets it equals to input
	{
		gender = a;
	}
	public void setSalary(int a)
	{
		salary = a;
	}
	public char getGender() //returns the info
	{
		return gender;
	}
	public int getSalary()
	{
		return salary;
	}
	public Address getAddress()
	{
		return address;
	}
	public void setPet(String a)
	{
		pet_type = a;
	}
	public String getPet()
	{
		return pet_type;
	}
	public void setchild(int a)
	{
		numb_child = a;
	}
	public int getChild()
	{
		return numb_child;
	}
	public String toString()
	{
		return "\n\nName: "+first_name+" "+last_name+"\nPhone numbers: "+phone_numbers+"\ne-mail: "+email_address
				+"\nwebsite: "+website+"\naddress: \n"+address+"gender: "+gender+"\nsalary: "+salary+"\nPet: "+pet_type
				+"\nnumber of children: "+numb_child;
	}
	public int compareTo(PersonalInfo T)
	{
		if(last_name.compareTo(T.last_name) == 0)
		{
			return first_name.compareTo(T.first_name);
		}
		return last_name.compareTo(T.last_name);

	}
	
}
