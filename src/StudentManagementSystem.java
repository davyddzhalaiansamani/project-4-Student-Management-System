import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class StudentManagementSystem {
    private List <Student> students; 
    private HashMap <Department, ArrayList<Student>> categorization; 

    public StudentManagementSystem (){
        students = new ArrayList<>();
        categorization = new HashMap<>(); 
    }

    public void addStudent (Student student) {
        students.add(student); 
        for(Department department : student.getDepartment()) {
            if(!categorization.containsKey(department))categorization.put(department, new ArrayList<Student>()); 
            categorization.get(department).add(student); 
        }
    }

    public void removeStudent (String studentid) {
        students.removeIf(student -> student.getStudentID().equals(studentid)); 
        for (Department department : categorization.keySet()){
            categorization.get(department).removeIf(student -> student.getStudentID().equals(studentid));
        }
    }

    public void updateStudent (String studentid, String newname, Department newdepartment, double newgpa) {
        for (Student student : students) {
            if (student.getStudentID().equals(studentid)){
                student.setName(newname);
                student.addDepartment(newdepartment);
                student.addGPA(newdepartment, newgpa);
                if (!categorization.containsKey(newdepartment))categorization.put(newdepartment, new ArrayList<Student>()); 
                categorization.get(newdepartment).add(student); 
                //student.setDepartment(newdepartment);
                //student.setGPA(newgpa);
                return ; 
            }
        }
        System.out.println ("Student not found"); 
        return; 
    }

    public void searchByID (String studentid) {
        for(Student student : students) {
            if (student.getStudentID().equals(studentid)){
                System.out.println (student.toString()); 
                return ; 
            }
        }
        System.out.println ("Student not found"); 
        return; 
    }

    public void searchByDepartment (Department department, String studentid) {
        if (categorization.containsKey(department)){
            for(Student student : students) {
                if (student.getStudentID().equals(studentid)){
                    System.out.println (student.toString()); 
                }
            }
        }
        else System.out.println ("Department not found"); 
        return; 
    }

    public void sortWithinDepartment (Department department) {
        if (categorization.containsKey(department)){
            //categorization.get(department).sort(Comparator.comparingDouble(Student::getGPA(department)).reversed());
            categorization.get(department).sort((s1, s2) -> 
                Double.compare(s2.getGPA(department), s1.getGPA(department))
            );
        }
        else System.out.println ("Department not found"); 
        return; 
    }

    public void showTopStudentInDepartment (Department department) {
        if (categorization.containsKey(department)){
        sortWithinDepartment(department);
        categorization.get(department).get(0).toString();         
        }
    }

    public void sort (String criteria) {
        
        if(criteria.equals("Name")) {
            students.sort(Comparator.comparing(Student::getName));
        } else if(criteria.equals("Department")) {
            //((Object) categorization).sort();
        } else if(criteria.equals("GPA")) {
            //students.sort(Comparator.comparingDouble(Student::getGPA).reversed());
        } else if(criteria.equals("StudentID")) {
            students.sort(Comparator.comparing(Student::getStudentID)); 
        } else {
            System.out.println ("Invalid criteria"); 
        }
    }
}
