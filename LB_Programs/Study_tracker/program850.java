/*
for(StudyLog sobj : DataBase)
        {
            System.out.println(sobj);
        }

*/

import java.util.*;
import java.time.LocalDate;

class StudyLog
{
    private LocalDate Date;
    private String Subject;
    private Double Duration;
    private String Description;

    /*
    INSERT INTO StudyLog
    (Date, Subject, Duration, Description)
    VALUES (?, ?, ?, ?);
    */
    public StudyLog( LocalDate a,String b, double c, String d)
    {
        this.Date = a;
        this.Subject = b;
        this.Duration = c;
        this.Description = d;
    }
    /*
    SELECT Date, Subject, Duration, Description
    FROM StudyLog;
    */
    @Override
    public String toString()
    {
        return Date+" | "+Subject+" | "+Duration+" | "+Description;
    }

    // Getter methods 

    //SELECT Date from StudyLog;
    public LocalDate getDate()
    {
        return this.Date;
    }

    //SELECT Subject from StudyLog;
    public String getSubject()
    {
        return this.Subject;
    }

    //SELECT Duration from StudyLog;
    public Double getDuration()
    {
        return this.Duration;
    }

    //Select Description from StudyLog;
    public String getDescription()
    {
        return this.Description;
    }

    //DELETE 

}
class program850
{
    public static void main(String[] args)
    {
        LocalDate lobj = LocalDate.now();

        ArrayList <StudyLog>DataBase = new ArrayList<StudyLog>();

         /*
        INSERT INTO StudyLog
        VALUES (CURRENT_DATE, 'C Programming',3.5, 'Pointers in C');
        */
        StudyLog sobj1 = new StudyLog(lobj, "C Programming", 3.5, "Pointers in C");
        StudyLog sobj2 = new StudyLog(lobj, "Java Programming", 3.5, "Pointers in C");
        StudyLog sobj3 = new StudyLog(lobj, "C++ Programming", 3.5, "Pointers in C");

        DataBase.add(sobj1);
        DataBase.add(sobj2);
        DataBase.add(sobj3);

        /*
        SELECT * FROM StudyLog;
        */
        for(StudyLog sobj : DataBase)
        {
            System.out.println(sobj);
        }

         /*
        DELETE FROM StudyLog WHERE index = 1;
        */
        DataBase.remove(1);

        System.out.println("After removal : ");
        for(StudyLog sobj : DataBase)
        {
            System.out.println(sobj);
        }

    }
    
}
