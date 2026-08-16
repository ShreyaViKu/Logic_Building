/*
@Override
    public String toString()
    Dcorator
*/

import java.util.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

class StudyLog
{
    private LocalDate Date;
    private String Subject;
    private Double Duration;
    private String Description;

    public StudyLog( LocalDate a,String b, double c, String d)
    {
        this.Date = a;
        this.Subject = b;
        this.Duration = c;
        this.Description = d;
    }

    @Override
    public String toString()
    {
        return Date+" | "+Subject+" | "+Duration+" | "+Description;
    }

    // Getter methods 

    public LocalDate getDate()
    {
        return this.Date;
    }

    public String getSubject()
    {
        return this.Subject;
    }

    public Double getDuration()
    {
        return this.Duration;
    }

    public String getDescription()
    {
        return this.Description;
    }

}
class program846
{
    public static void main(String[] args)
    {
        LocalDate lobj = LocalDate.now();

        StudyLog sobj1 = new StudyLog(lobj, "C Programming", 3.5, "Pointers in C");

        System.out.println(sobj1);

        System.out.println(sobj1.getDate());

        System.out.println(sobj1.getSubject());

        System.out.println(sobj1.getDuration());

        System.out.println(sobj1.getDescription());

    }
    
}
