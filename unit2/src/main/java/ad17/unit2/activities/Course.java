package ad17.unit2.activities;

import java.util.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Course {
  
  @XmlElement
    private List<Student> students;
    private int nrStudents; //Number of students in the course
    private int maxStudents;

  public Course() {
  }

 
    public Course(int size){
        students=new ArrayList<Student>();
        maxStudents = size;
        nrStudents=0;
        
    }
    /**
     * Checks if the course has no students
     * @return true if empty
     */
    public boolean emptyCourse(){
        return students.isEmpty();
    }

    /**
     * Checks if the course is full
     * @return true if full
     */
    public boolean fullCourse(){
        return nrStudents==maxStudents;
    }
    /**
     * Adds a new student to the course (if not full)
     */
    public void add(Student student){
        if (!this.fullCourse()){
            students.add(student);
            nrStudents++;
        }
    }
    /**
     * Deletes a student from the course
     * @return true if student deleted, false if not
     */

    public boolean delete(Student student){
    	return students.remove(student);
        
    }
   
    public List<Student> getStudents(){
        return students;
         }
   
    /**
     * Prints all the students registered in the course
     */
    public void infoStudents(){
        System.out.println("The course has the following students:");
        for (int j=0;j<students.size();j++){
             System.out.println(students.get(j).toString()+" ");
         }
    }
}
