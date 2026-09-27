/*
 bRet = unique.add(str);

            if(bRet == false)
            {
                duplicate.add(str);
            }
*/

import java.util.*;

class program962
{
    public static void main(String[] A)
    {
        boolean bRet = false;

        String transactions[] = {"TX101","TX102","TX103","TX101","TX104","TX102","TX101"};

        HashSet<String> unique = new HashSet<>();
        HashSet<String> duplicate = new HashSet<>();

        for(String str : transactions)
        {
            bRet = unique.add(str);

            if(bRet == false)
            {
                duplicate.add(str);
            }
        }

        System.out.println("Duplicate transactions : ");

        for(String str : duplicate)
        {
            System.out.println(str);
        }
    }
    
}
