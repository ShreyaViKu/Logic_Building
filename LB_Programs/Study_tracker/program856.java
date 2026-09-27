/*
//Shell to interact with end user
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

class StudyTracker
{
    public ArrayList <StudyLog>Database;

    public StudyTracker()
    {
        Database = new ArrayList<StudyLog>();
    }
}

class program856
{
    public static void main(String[] args)
    {
        int iChoice = 0;

        Scanner sobj = new Scanner(System.in);
        StudyTracker stobj = new StudyTracker();

        System.out.println("--------------------------------------------------------");
        System.out.println("------------Welcome to Marvellous StudyTracker----------");
        System.out.println("--------------------------------------------------------");

        //Shell to interact with end user
        do
        {
            System.out.println("--------------------------------------------------------");
            System.out.println("Please select appropriate option : ");
            System.out.println("--------------------------------------------------------");

            System.out.println("1 : Insert new Study Log");
            System.out.println("2 : View all Study Log");
            System.out.println("3 : Export Study Log to CSV");
            System.out.println("4 : Summery of Study Log by Date");
            System.out.println("5 : Summery of Study Log by Subject");
            System.out.println("6 : Exit the Appliction");

            System.out.println("--------------------------------------------------------");

            iChoice = sobj.nextInt();

        }while(iChoice !=6);

        System.out.println("--------------------------------------------------------");
        System.out.println("-------------Thank you for using StudyTracker-----------");
        System.out.println("--------------------------------------------------------");

    }
    
}
