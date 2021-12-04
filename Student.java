import java.util.Vector;

public class Student extends Person{
    private String id;
    private String name;
    private Vector<Course> courses = new Vector<Course>(); // contains all courses the student is registered in


    public Student(String stdId, String stdName) {
        this.name = stdName;
        this.id = stdId;
    }


    public String getName()
    {
        return name;
    }

    public String getId()
    {
        return id;
    }

    public void registerFor(Course course)
    {
        courses.add(course);

    }

    public String toString()
    {
        // return a string representation of a student using the following format:
        // 100234546 John McDonald
        // Registered courses: ELEE 2110, ELEE 2790, SOFE 2710, SOFE 2800, SOFE 2850
        System.out.println(this.id + "    ,    "  + this.name);
        System.out.println("Registered courses: ");
        for(int b = 0;b<courses.size();b++)
        {
            System.out.print(courses.get(b).getCode() + " " + courses.get(b).getNumber() + " ");
        }

        return " ";
    }

    public boolean equals(Student student)
    {
        if(this.id == student.getId())
        {
            if (name.equals(student.getName()))
            {
                return false;
            }
            return true;
        }
        return false;
    }

    public boolean isRegisteredInCourse(Course cour)
    {
        int s = 0;
        while(s<courses.size())
        {
            if(cour.getCode().equals(courses.get(s).getCode()))
            {
                if(cour.getNumber() == courses.get(s).getNumber())
                {
                    return true;
                }
            }
            s++;
        }
        return false;
    }

    public boolean isRegisteredInCourse(int number){
        int l = 0;
        int temp;
        while(l<courses.size())
        {
            if(courses.get(l).getNumber() == number)
            {
                return true;
            }
            l++;
        }
        return false;
    }
}
