/*
Display log function
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

    public void InsertLog()
    {
        Scanner sobj = new Scanner(System.in);

        System.out.println("--------------------------------------------------------");
        System.out.println("------------Enter the details of your study ------------");
        System.out.println("--------------------------------------------------------");

        LocalDate lobj = LocalDate.now();

        System.out.println("We are entering date as : "+lobj);

        System.out.println("Enter the Name of Subject like C/CPP/JAVA : ");
        String sub = sobj.nextLine();

        System.out.println("Enter the time period of your study : ");
        double dur = sobj.nextDouble();

        //ISSUE RESOLVED
        sobj.nextLine();

        System.out.println("Please provide the description of your study : ");
        String desc = sobj.nextLine();

        StudyLog studyobj = new StudyLog(lobj, sub, dur, desc);

        Database.add(studyobj);

        System.out.println("Study log gets inserted successfully");
        System.out.println("--------------------------------------------------------");

    }

    public void DisplayLog()
    {
        System.out.println("--------------------------------------------------------");

        if(Database.isEmpty())
        {
            System.out.println("Nothing to display - DataBase is empty");
            System.out.println("--------------------------------------------------------");
            
            return;
        }

        System.out.println("----------Log report of Marvellous Study Tracker--------");
        System.out.println("--------------------------------------------------------");

        for (StudyLog s : Database)
        {
            System.out.println(s);  
        }

        System.out.println("--------------------------------------------------------");

    }

    public void ExportToCSV()
    {}

    public void SummaryByDate()
    {}

    public void SummaryBySubject()
    {}
}

class program860
{
    public static void main(String[] args)
    {
        int iChoice = 0;

        Scanner sobj = new Scanner(System.in);
        StudyTracker stobj = new StudyTracker();

        System.out.println("--------------------------------------------------------");
        System.out.println("------------Welcome to Marvellous StudyTracker----------");
        System.out.println("--------------------------------------------------------");

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

            switch(iChoice)
            {
                // Insert new log
                case 1 :
                    stobj.InsertLog();
                    break;

                // View all study logs
                case 2 :
                    stobj.DisplayLog();
                    break;
                
                // Export to CSV
                case 3 :
                    stobj.ExportToCSV();
                    break;

                // Summery by date
                case 4 :
                    stobj.SummaryByDate();
                    break;

                // Summary by subject
                case 5 :
                    stobj.SummaryBySubject();
                    break;

                // Terminate the project
                case 6 :
                    break;

                default:
                    System.out.println("Please enter valid option");
                    break;

            }

        }while(iChoice !=6);

        System.out.println("--------------------------------------------------------");
        System.out.println("-------------Thank you for using StudyTracker-----------");
        System.out.println("--------------------------------------------------------");

    }// end of main
    
}// end of class
