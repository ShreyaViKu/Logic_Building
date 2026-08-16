/*
 // Override
    public String toString()
    {
        return Date+" | "+Subject+" | "+Duration+" | "+Description;
    } 
*/

import java.util.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

class StudyLog
{
    public LocalDate Date;
    public String Subject;
    public Double Duration;
    public String Description;

    public StudyLog( LocalDate a,String b, double c, String d)
    {
        this.Date = a;
        this.Subject = b;
        this.Duration = c;
        this.Description = d;
    }

    // Override
    public String toString()
    {
        return Date+" | "+Subject+" | "+Duration+" | "+Description;
    }

}
class program843
{
    public static void main(String[] args)
    {
        LocalDate lobj = LocalDate.now();

        StudyLog sobj1 = new StudyLog(lobj, "C Programming", 3.5, "Pointers in C");

        StudyLog sobj2 = new StudyLog(lobj, "JAVA Programming", 5.5, "Inheritance in JAVA");

        System.out.println(sobj1);  // sobj.toSting()
        System.out.println(sobj2);

    }
    
}
