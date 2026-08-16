/*
object hash address of object
ArrayList can hold object of user defined class as StudyLog
*/

import java.util.*;

class StudyLog
{
    public String Subject;
    public Double Duration;

    public StudyLog(String a, double d)
    {
        this.Subject = a;
        this.Duration = d;
    }

}
class program838
{
    public static void main(String[] args)
    {
        StudyLog sobj1 = new StudyLog("C",2.5);
        StudyLog sobj2 = new StudyLog("JAVA",4.5);

        System.out.println(sobj1);
        System.out.println(sobj2);

    }
    
}
