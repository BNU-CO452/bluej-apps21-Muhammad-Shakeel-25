import java.util.*;
/**
 * The Student class represents a student in a student administration system.
 * It holds the student details relevant in our context.
 * 
 * @author Muhammad Shakeel
 * Modified by Muhammad Shakeel
 * @version 1.0
 */
public class Student
{
    // the student ID
    private int id;
    // the student's full name
    private String name;
    // The course the student is enrolled on
    private Course course;
    // The marks awarded for the modules on the course
    private ArrayList<ModuleMark> marks;

    /**
     * This constructor creates a new student with a
     * fixed name and id. 
     */
    public Student()
    {
        this("Muhammad Shakeel", 21924162);
    }

    /**
     * Create a new student with a given name and ID number.
     */
    public Student(String name, int id)
    {
        this.name = name;
        this.id = id;

        marks = new ArrayList<ModuleMark>();
    }

    public void addMark(ModuleMark mark)
    {
        marks.add(mark);
    }

    /**
     * Find the module by the moduleCode and
     * set its mark to the value
     */
    public void awardMark(String moduleCode, int value)
    {
        for(Module module : course.modules)
        {
            if(module.getCode() == moduleCode)
            {
                //ModuleMark mark = new ModuleMark(module ,value);
            }
        }

    }

    /**
     * Set the student's course
     */
    public void enrol(Course course)
    {
        this.course = course;
        awardTestMarks();
    }

    /**
     * Award a different pass mark for each of the
     * modules on the enrolled course
     */
    public void awardTestMarks()
    {
        int randValue = 80;
        for(Module module : course.modules)
        {
            ModuleMark mark = new ModuleMark(module);

            mark.setMark(randValue);
            marks.add(mark);
            randValue = randValue - 10;
        }

    }

    /**
     * Return the full name of this student.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Return the student ID of this student.
     */
    public int getID()
    {
        return id;
    }

    /**
     * Print the student's name and ID number to the 
     * output terminal.
     */
    public void print()
    {
        System.out.println(" Student ID: " + id + ", " + name);
    }

    public void printCourse()
    {
        this.print();
        course.print();
    }

    private void printModules()
    {
        for(ModuleMark moduleMark: marks)
        {
            moduleMark.print();
            System.out.println("\t" + course.convertToGrade(moduleMark.getValue()));
        }
    }

    public void printTranscript()
    {
        System.out.println(" ------------------------------------");
        System.out.println(" App21-02: Exam Board Transcript 2021");
        System.out.println("        by Muhammad Shakeel");
        System.out.println(" ------------------------------------");

        printCourse();

        System.out.println();
        System.out.println();
        System.out.println(" ---- \t -------------------- \t ------\t ---- \t -----");
        System.out.println(" Code \t Module \t\tCredit\t Mark \t Grade");
        System.out.println(" ---- \t -------------------- \t ------\t ---- \t -----");

        printModules();

        Grades finalGrade = course.calculateGrade(marks);

        System.out.println();
        System.out.println();

        if(finalGrade == Grades.NS)
        {
            System.out.println(" No Final Course Grade Yet!");
        }
        else
        {
            System.out.println(" Final Course Grade = " + finalGrade);
        }
    }
}