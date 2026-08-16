/*
import java.time.LocalDate;
import java.time.LocalDateTime;
*/

import java.util.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

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
class program839
{
    public static void main(String[] args)
    {
        StudyLog sobj1 = new StudyLog("C",2.5);
        StudyLog sobj2 = new StudyLog("JAVA",4.5);

        System.out.println(sobj1);
        System.out.println(sobj2);

        LocalDateTime lobj = LocalDateTime.now();

        System.out.println(lobj);

    }
    
}
