import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StudentManagementSystem {
    //store in arrayList, methods for veowing and sorting by gpa, name, or department
    private List <Student> students; 

    public StudentManagementSystem (){
        students = new ArrayList<>();
    }

    public void addStudent (Student student) {
        students.add(student); 
    }

    public void removeStudent (String studentid) {
        students.removeIf(student -> student.getStudentID().equals(studentid)); 
    }

    public void updateStudent (String studentid, String newname, String newdepartment, double newgpa) {
        for (Student student : students) {
            if (student.getStudentID().equals(studentid)){
                student.setName(newname);
                student.setDepartment(newdepartment);
                student.setGPA(newgpa);
                return ; 
            }
        }
        System.out.println ("Student not found"); 
        return; 
    }

    public void sort (String criteria) {
        
        if(criteria.equals("Name")) {
            students.sort(Comparator.comparing(Student::getName));
        } else if(criteria.equals("Department")) {
            students.sort(Comparator.comparing(Student::getDepartment));
        } else if(criteria.equals("GPA")) {
            students.sort(Comparator.comparingDouble(Student::getGPA).reversed());
        } else if(criteria.equals("StudentID")) {
            students.sort(Comparator.comparing(Student::getStudentID)); 
        } else {
            System.out.println ("Invalid criteria"); 
        }
    }
}
