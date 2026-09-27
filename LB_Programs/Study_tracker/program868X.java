/*
load csv to DataBase
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
    {
        Scanner sobj = new Scanner(System.in);

        System.out.println("Enter Name that you want to create for CSV file : ");
        String Filename = sobj.nextLine();

        System.out.println("--------------------------------------------------------");

        if(Database.isEmpty())
        {
            System.out.println("Nothing to export - DataBase is empty");
            System.out.println("--------------------------------------------------------");
            
            return;
        }

        try(FileWriter fwobj = new FileWriter(Filename))
        {
            fwobj.write("Date,Subject,Duration of study,Description of study\n");

            for (StudyLog s : Database)
            {
                fwobj.write(s.getDate()+","+
                            s.getSubject()+","+
                            s.getDuration()+","+
                            s.getDescription()+"\n");
                
            }
            System.out.println("Data gets exported to CSV successfully");
            System.out.println("--------------------------------------------------------");
        }
        catch(IOException iobj)
        {
            System.out.println(iobj);
        }
        catch(Exception eobj)
        {
            System.out.println(eobj);
        }

    }

    public void SummaryByDate()
    {
        System.out.println("--------------------------------------------------------");
        System.out.println("-----------Summary by Date from Study Tracker-----------");
        System.out.println("--------------------------------------------------------");

        TreeMap <LocalDate, Double> tobj = new TreeMap<LocalDate,Double>();

        LocalDate lobj = null;
        Double d = 0.0;
        Double old = 0.0;

        for (StudyLog s : Database)
        {
            lobj = s.getDate();
            d = s.getDuration();

            if(tobj.containsKey(lobj))
            {
                old = tobj.get(lobj);

                tobj.put(lobj, old+d);       // duration gets updated and adds it to old
            }
            else
            {
                tobj.put(lobj, d);
            } 
        }

        //Display the details as per date 
        for (LocalDate l : tobj.keySet())
        {
            System.out.println("Date : "+l+" Total study duration : "+tobj.get(l));
            
        }
        System.out.println("--------------------------------------------------------");
    }

    public void SummaryBySubject()
    {
        System.out.println("--------------------------------------------------------");
        System.out.println("----------Summary by Subject from Study Tracker---------");
        System.out.println("--------------------------------------------------------");

        TreeMap <String, Double> tobj = new TreeMap<String,Double>();

        String sobj = null;
        Double d = 0.0;
        Double old = 0.0;

        for (StudyLog s : Database)
        {
            sobj = s.getSubject();
            d = s.getDuration();

            if(tobj.containsKey(sobj))
            {
                old = tobj.get(sobj);

                tobj.put(sobj, old+d);       
            }
            else
            {
                tobj.put(sobj, d);
            } 
        }

        //Display the details as per date 
        for (String str : tobj.keySet())
        {
            System.out.println("Subject : "+str+" Total study duration : "+tobj.get(str));
            
        }
        System.out.println("--------------------------------------------------------");
    }

    public void LoadCSV()
    {
        Scanner sobj = new Scanner(System.in);
        String line = null;
        String Buffer[] = null;

        System.out.println("Enter CSV Filename to load : ");
        String Filename = sobj.nextLine();

        try(FileReader fobj = new FileReader(Filename))
        {
            BufferedReader bobj = new BufferedReader(fobj);

            bobj.readLine();

            while((line = bobj.readLine()) != null)
            {
                Buffer = line.split(",");

                LocalDate date = LocalDate.parse(Buffer[0]);
                String subject = Buffer[1];
                Double duration = Double.parseDouble(Buffer[2]);
                String description = Buffer[3];

                StudyLog studyobj = new StudyLog(date,subject,duration,description);

                Database.add(studyobj);

            }
            System.out.println("CSV data loaded successfully");
        }
        catch(Exception eobj)
        {
            System.out.println(eobj);
        }
    }

    public void DeleteLog()
    {
        Scanner sobj = new Scanner(System.in);

        int i = 1;

        for (StudyLog s : Database) {

            System.out.println(i+" : "+s);
            i++;
        }

        System.out.println("Enter Number of log which you want to delete : ");
        int index = sobj.nextInt();

        Database.remove(index-1);

        System.out.println("Log deleted Successfully from Dataset");
    }

    public void SearchBySubject()
    {
        Scanner sobj = new Scanner(System.in);

        System.out.println("Enter valid Subject name to search in log : ");
        String sname = sobj.nextLine();

        for (StudyLog s : Database)
        {
            if(sname.equals(s.getSubject()))
            {
                System.out.println(s);
            }
            
        }
    }

    public void SortByDuration()
    {
        Database.sort((s1, s2) ->
        Double.compare(s1.getDuration(), s2.getDuration()));

        System.out.println("Study logs sorted by duration");
    }
}

class program868X
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
            System.out.println("6 : Load CSV file");
            System.out.println("7 : Delete log from Database");
            System.out.println("8 : Search by Subject in log databse");
            System.out.println("9 : Sort the logs by Duration studied");
            System.out.println("10: Exit the Appliction");

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

                // Load CSV file
                case 6 :
                    stobj.LoadCSV();
                    break;

                // Delete the log
                case 7 :
                    stobj.DeleteLog();
                    break;

                // Search by Subject
                case 8 :
                    stobj.SearchBySubject();
                    break;

                // Sort the log by Duration
                case 9 :
                    break;

                // Terminate the project
                case 10 :
                    break;

                default:
                    System.out.println("Please enter valid option");
                    break;

            }

        }while(iChoice !=9);

        System.out.println("--------------------------------------------------------");
        System.out.println("-------------Thank you for using StudyTracker-----------");
        System.out.println("--------------------------------------------------------");

    }// end of main
    
}// end of class
