/*
CSV convert
 FileWriter fwobj = new FileWriter(Filename);

       fwobj.write("Data,Subject,Duration.Description\n");
*/

import java.util.*;
import java.time.LocalDate;
import java.io.*;

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
class program852
{
    public static void main(String[] args)throws Exception
    {
       LocalDate lobj = LocalDate.now();

       StudyLog s1 = new StudyLog(lobj, "C programming", 4.5, "Revision of pointers");
       StudyLog s2 = new StudyLog(lobj, "C++ programming", 4.5, "Revision of pointers");
       StudyLog s3 = new StudyLog(lobj, "JAVA programming", 4.5, "Revision of pointers");
       StudyLog s4 = new StudyLog(lobj, "PYTHON programming", 4.5, "Revision of pointers");

       ArrayList <StudyLog>Database = new ArrayList<StudyLog>();

       Database.add(s1);
       Database.add(s2);
       Database.add(s3);
       Database.add(s4);

       for (StudyLog s : Database)
       {
            System.out.println(s);
       }

       String Filename = "MarvellousStudyLog.csv";

       FileWriter fwobj = new FileWriter(Filename);

       fwobj.write("Data,Subject,Duration.Description\n");

       for (StudyLog s : Database)
       {
            fwobj.write(s.getDate()+","+
                        s.getSubject()+","+
                        s.getDuration()+","+
                        s.getDescription()+"\n");
       }

       fwobj.close();
       Database.clear();
       Database = null;

       System.gc();
    }
    
}
