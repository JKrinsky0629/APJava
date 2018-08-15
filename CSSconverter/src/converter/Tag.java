package converter;

public class Tag {
    private String details;
    private String tag;
    public Tag(String t)
    {
        tag = t;
    }
    public void addCSS(String s)
    {
        int start = 0;
        int end = 0 ;
        for(int i = 0; i<s.length(); i++)
        {
            if(s.charAt(i) == '"')
            {
                start = i+1;
                System.out.println(s.charAt(i)+" "+i);
            }
            else if(s.charAt(i) == '"' && i != start)
            {
                end = i;
                System.out.println(s.charAt(i)+" "+i);
            }

        }
        if(start >= end)
            return;
        String full_tag = s.substring(start+1,end);
        String corrected_tag = full_tag.replace(";", ";\n");
        details = corrected_tag;
    }
    /*public String getTag()
    {
        return tag;
    }
    public String getCSS()
    {
        return details;
    }*/
    public String toString()
    {
        return "Tag: "+tag+"{\n"+details+"\n}";
    }
}
