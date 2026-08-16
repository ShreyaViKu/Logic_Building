/*
object hash address of object
ArrayList can hold object of user defined class as StudyLog
 ArrayList <StudyLog>DataBase = new ArrayList<StudyLog>();

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
class program847
{
    public static void main(String[] args)
    {
        LocalDate lobj = LocalDate.now();

        ArrayList <StudyLog>DataBase = new ArrayList<StudyLog>();

        StudyLog sobj1 = new StudyLog(lobj, "C Programming", 3.5, "Pointers in C");
        StudyLog sobj2 = new StudyLog(lobj, "Java Programming", 3.5, "Pointers in C");
        StudyLog sobj3 = new StudyLog(lobj, "C++ Programming", 3.5, "Pointers in C");

        DataBase.add(sobj1);
        DataBase.add(sobj2);
        DataBase.add(sobj3);

        System.out.println(DataBase.size());

    }
    
}
