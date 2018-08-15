package Address;

import java.util.Comparator;

public class Comparatorer implements Comparator<PersonalInfo> {

    private int chose;
    public Comparatorer(int i)
    {
        chose = i;
    }
    public int compare(PersonalInfo t, PersonalInfo g)
    {
        if(chose==1)
            return t.getChild()-g.getChild();

        else if(chose ==2)
            return t.getSalary()-g.getSalary();
        else
            return t.getGender() - (g.getGender());
    }
}
