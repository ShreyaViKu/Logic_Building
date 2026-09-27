/*
duplicate transaction identifier
using hashset with 2 hashset
*/

import java.util.*;

class program958
{
    public static void main(String[] A)
    {
        String transactions[] = {"TX101","TX102","TX103","TX101","TX104","TX102"};

        HashSet<String> unique = new HashSet<>();
        HashSet<String> duplicate = new HashSet<>();

        for(String str : transactions)
        {
            if(!unique.add(str))
            {
                duplicate.add(str);
            }
        }

        System.out.println("Unique : "+unique);

        System.out.println("Duplicate : "+duplicate);
    }
    
}
