import java.util.HashMap;
import java.util.List;

public class Student {
    private String Name;
    private String StudentID;
    //private String Department;   
    private List<Department>departments; 
    //private double GPA;
    private HashMap<Department, Double>GPA; 

    public Student (String name, String StudentID, List<Department>departs, HashMap<Department, Double>GPA) {
        this.setName(name);
        this.setStudentID(StudentID);
        this.setDepartment(departs); 
        this.setGPA(GPA); 
    }
    
    public void setName (String name) {
        this.Name = name; 
    }
    public String getName () {
        return this.Name; 
    }
    public void setStudentID(String studentid) {
        this.StudentID = studentid; 
    }
    public String getStudentID() {
        return this.StudentID; 
    }
    public void setDepartment (List<Department>departs) {
        this.departments = departs; 
    }
    public List<Department> getDepartment () {
        return this.departments; 
    }
    public void addDepartment(Department department) {
        this.departments.add (department); 
        this.GPA.put(department, (double) -1); 
    }
    public void setGPA(HashMap<Department, Double>gpa) {
        this.GPA = gpa; 
    }
    public void addGPA(Department department, double gpa){
        if (!GPA.containsKey(department))this.addDepartment(department); 
        GPA.put(department, gpa); 
    }
    public HashMap<Department, Double> getGPA() {
        return this.GPA; 
    }
    public double getGPA(Department department) {
        return this.GPA.get(department); 
    }
    @Override
    public String toString () {
        return "Student {Name :"+ this.getName() + ",StudentID :" + this.getStudentID() + ",Department :" + this.getDepartment() + ",GPA :" + this.getGPA() +"}";  
    }
}
