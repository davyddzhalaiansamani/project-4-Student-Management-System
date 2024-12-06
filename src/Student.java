public class Student {
    private String Name;
    private String StudentID;
    private String Department;   
    private double GPA;

    public Student (String name, String StudentID, String Department, double GPA) {
        this.setName(name);
        this.setStudentID(StudentID);
        this.setDepartment(Department);
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
    public void setDepartment (String department) {
        this.Department = department; 
    }
    public String getDepartment () {
        return this.Department; 
    }
    public void setGPA(double gpa) {
        this.GPA = gpa; 
    }
    public double getGPA () {
        return this.GPA; 
    }
    @Override
    public String toString () {
        return "Student {Name :"+ this.getName() + ",StudentID :" + this.getStudentID() + ",Department :" + this.getDepartment() + ",GPA :" + this.getGPA() +"}";  
    }
}
