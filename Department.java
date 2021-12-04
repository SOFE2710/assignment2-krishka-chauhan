import java.util.Vector;

public class Department {
    private String name; // the name of school Dept of Computing and Info Science
    private String id; // short name for courses SOFE, ELEE, STAT, etc
    private Vector<Course> courseList; // all courses offered by the department
    private Vector<Student> registerList; // all students taking courses in the department.


    public Department(String name, String id) {
        this.name = name;
        this.id  = id;
        courseList = new Vector<Course>();// also initialize the vectors
        registerList = new Vector<Student>();
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public void registerStudentCourseInDepartment(Student name, Course course){
        boolean condition1 = true;
        for(int b = 0;b<registerList.size();b++){
            if(registerList.get(b).getId()  == name.getId()){
                if(registerList.get(b).getName().equals(name.getName())) {
                    condition1 = false;
                }
            }
        }
        if(condition1){
            registerList.add(name);
        }
        boolean condition  = true;
        for(int i = 0;i<courseList.size();i++){
            if(course.equals(courseList.get(i))){
                condition = false;
            }
        }
        if(condition) {
            courseList.add(course);
        }
    }

    public String toString() {
        String ref = id;// returns a string representation of department name, number
        ref += ": " + courseList.size() + " courses, " + registerList.size() + " students\n";// of courses offered and number of students registered in the

        return ref;
    }
    public void offerCourse(Course course){
        if(!courseList.contains(course)){
            courseList.add(course);
        }
    }
    public boolean isStudentRegistered(Student stud){
        int i = 0;
        while(i<registerList.size()){
            if(stud.getId() == registerList.get(i).getId()){
                if(stud.getName().equals(registerList.get(i).getId())) {
                    return true;
                }
            }
            i++;
        }
        return false;
    }

    public void printStudentsRegisteredInCourse(int number){
        int i  = 0;
        while(i<registerList.size()){
            if(registerList.get(i).isRegisteredInCourse(number)){
                registerList.get(i).toString();
            }
            i++;
        }
    }

    public String largestCourse(){
        int i = 0, j = 0;
        int[] c = new int[courseList.size()];
        String[] temp  = new String[courseList.size()];
        while(i<courseList.size()){
            c[i] = courseList.get(i).getClassSize();
            temp[i] = courseList.get(i).getTitle();
            i++;
        }
        int maximum = c[0];
        String max = temp[0];// start with the first value
        for (j = 0; j<c.length; j++) {
            if (c[j] > maximum) {
                maximum = c[j];
                max = temp[j];
            }
        }
        return max;
    }

    public void printCoursesOffered(){
        for (Course course : courseList) {
            System.out.println(course.toString());
        }
    }

    public void printStudentsByName(){
        for (Student student : registerList) {

            student.toString();
        }
    }
}

