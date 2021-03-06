
/**
 * Write a description of class ModuleMark here.
 *
 * @author Muhammad Shakeel
 * @version 1.0
 */
public class ModuleMark
{
    private int mark;
    private Module module;

    /**
     * Constructor for objects of class ModuleMark
     */
    public ModuleMark(Module module)
    {
        mark = 0;
        this.module = module;
    }

    /**
     * Return the mark of this student.
     */
    public int getValue()
    {
        return mark;
    }

    /**
     * If the mark is 40% or more then the 
     * student is awarded the module's credit.
     */
    public int getCredit()
    {
        if(mark <= Grades.F.getValue())
        {
            return 0;
        }
        else
        {
            return Module.CREDIT;
        }
    }

    /**
     * Set the marks of student.
     */
    public void setMark(int mark)
    {
        this.mark = mark;
        if(mark<40)
        {
            System.out.println("You fail in this module ");
        }
    }

    /**
     * Return the module of this student.
     */
    public Module getModule()
    {
        return module;
    }

    /**
     * Print the module details and any credit
     * that has been awarded.
     */
    public void print()
    {
        module.print();
        System.out.print("\t  " + getCredit() + "\t" + mark);
    }
}
