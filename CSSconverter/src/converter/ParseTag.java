package converter;

import java.io.*;
import java.util.ArrayList;

public class ParseTag {
    ArrayList<Tag> tags = new ArrayList<Tag>();
    BufferedReader reader;
    FileWriter writer;
    boolean body_yet = false;


    public void parseHTML(File input) throws IOException {
        reader = new BufferedReader(new FileReader(input));
        String line;

        while((line = reader.readLine()) != null) {
            while(!(line.equals("<body>")) && body_yet == false)
            {
                line = reader.readLine();
                body_yet = true;
            }
            if (line.length() >0 && line.charAt(0) == '<') {
                int i;
                for (i = 0; i < line.length(); i++) {
                    if (line.charAt(i) == ' ')
                        break;
                }
                tags.add(0, new Tag(line.substring(1, i)));
                tags.get(0).addCSS(line.substring(i));
            }
        }
        reader.close();
        writer = new FileWriter(new File("CSS.txt"),true);
        for(int i =0; i<tags.size(); i++)
        {
            //System.out.println(tags.get(i).toString());
            writer.write(tags.get(i).toString());
        }
    }
    public static void main(String args[]) throws IOException
    {
       File a = new File("/Users/joshuakrinsky/IntelliJ-WorkSpace/CSSconverter/src/converter/Test.txt");
       ParseTag tester = new ParseTag();
       tester.parseHTML(a);
    }
}
