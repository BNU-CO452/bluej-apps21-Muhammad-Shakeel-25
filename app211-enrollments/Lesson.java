
/**
 *  Each module has at least one lesson
 *  scheduled in a room with a tutor on
 *  a particular day and time
 *
 * @author (Muhammad Shakeel)
 * @version (a version number or a date)
 */
public class Lesson
{
    private String day;
    private String startTime;
    private String roomNumber;
    private String tutor;

    /**
     * Constructor for objects of module Lesson
     */
    public Lesson(String day,String startTime,String roomNumber,String tutor)
    {
		this.day=day;
		this.startTime=startTime;
		this.roomNumber=roomNumber;
		this.tutor=tutor;
    }
	
	
	
	public void print()
	{
		System.out.println("Day "+day);
		System.out.println("Start Time "+startTime);
		System.out.println("Room Number "+roomNumber);
		System.out.println("Tutor "+tutor);
	}
	
	

}
