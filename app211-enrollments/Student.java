/**
 * The Student class contains essential information that identifies 
 * a student at BNU.  The class also contains information 
 * concerning the course the student is currently enrolled on
 * 
 * @author Michael Kölling and David Barnes
 * @modified by Muhammad Shakeel
 * @version 2021:08:15
 */
public class Student
{
    // A unique 8 digit BNU identifier
    private int id;
    // the student's full name
    private String name;
    // the student's full father name
    private String father_name;
    // the student's Date of birth
    private int date_of_birth;
    // The course the student is enrolled on
    private Course course;
    
    /**
     * Create a new student with a given name and ID number.
     */
    public Student(String name, int id,String father_name,int date_of_birth)
    {
        this.name = name;
        this.id = id;
        this.father_name = father_name;
        this.date_of_birth = date_of_birth;
    }

    /**
     * Return the full name of this student.
     */
    public String getName()
    {
        return name;
    }

    
     /**
     * Return the full father name of this student.
     */
    public String getFatherName()
    {
        return father_name;
    }
    
     /**
     * Return the full father name of this student.
     */
    public String getDateOfBirth()
    {
        return ""+date_of_birth;
    }
    
     /**
     * Return the student ID of this student.
     */
    public int getID()
    {
        return id;
    }

    public void enrol(Course course)
    {
        this.course = course;
    }
    
    /**
     * Print the student's name and ID number to the output terminal.
     */
    public void print()
    {
        System.out.println(" Student ID: " + id + " Name: " + name);
        System.out.println(" Student Father Name: " + father_name + " Date of birth: " + date_of_birth);
    }
    
    public void printCourse()
    {
        course.print();
    }
}
