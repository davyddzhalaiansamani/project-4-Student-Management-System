public class Department {
    private String name; 
    public Department (String name) {
        this.setName(name); 
    }
    public void setName(String name) {
        this.name = name; 
    }
    public String getName () {
        return this.name; 
    }
    @Override
    public String toString() {
        return this.getName(); 
    }
}
