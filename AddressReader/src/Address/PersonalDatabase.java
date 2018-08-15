package Address;

import java.util.ArrayList;

public class PersonalDatabase extends ArrayList<PersonalInfo>
{
	public PersonalDatabase()
	{
		super();
	}
	public ArrayList<PersonalInfo> findPeopleFromState(String state) //search for people from same state
	{
		ArrayList<PersonalInfo> ret_info = new ArrayList<PersonalInfo>();
		for(PersonalInfo info: this) //for loop to go through entire array list
		{
			if(info.getAddress().getState().equalsIgnoreCase(state)) //compares info's state to state given
			{
				ret_info.add(info); //adds this to an array list
			}
		}
		return ret_info;
	}
	public ArrayList<PersonalInfo> findBySalary(int salary) 
	{
		ArrayList<PersonalInfo> ret_info = new ArrayList<PersonalInfo>();
		for(PersonalInfo info: this)
		{
			if(info.getSalary() >= salary) //if their salary is more than or equals to the inputed
			{
				ret_info.add(info);
			}
		}
		return ret_info;
	}
	public ArrayList<PersonalInfo> findByGender(char gender)
	{
		ArrayList<PersonalInfo> ret_info = new ArrayList<PersonalInfo>();
		for(PersonalInfo info: this)
		{
			if(info.getGender() == gender) //if they have the same gender as inputed
			{
				ret_info.add(info);
			}
		}
		return ret_info;
	}
	public ArrayList<PersonalInfo> findByPet(String pet)
	{
		ArrayList<PersonalInfo> ret_info = new ArrayList<PersonalInfo>();
		for(PersonalInfo info: this)
		{
			if(info.getPet().equalsIgnoreCase(pet)) //if info's pet is the same as asked for
			{
				ret_info.add(info);
			}
		}
		return ret_info;
	}
	public ArrayList<PersonalInfo> findByNumbChild(int numbChild)
	{
		ArrayList<PersonalInfo> ret_info = new ArrayList<PersonalInfo>();
		for(PersonalInfo info: this)
		{
			if(info.getChild() >= numbChild) //if they have more or equal to the inputed number of children
			{
				ret_info.add(info);
			}
		}
		return ret_info;
	}
	
}
