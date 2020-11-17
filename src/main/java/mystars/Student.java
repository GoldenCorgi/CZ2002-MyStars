package mystars;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;
import java.util.Iterator;
import java.util.Map;

public class Student {
    private String matricNo;
    private String studName;
    private String studServerName;
    private int numberOfCoursesRegistered;
    private HashMap<String, String> studCourses= new HashMap<>();
    // private HashMap<String, Object> studCourses= new HashMap<>(); use Course as object?
    private final int MAXCOURSES=6;

    public Student() {}

    //public String getStudName(studServerName) {return studName;}
    //public String getMatricNo(studServerName) { return matricNo;}

    public boolean hasCourse(String courseCode) {
        if (studCourses.containsKey(courseCode)){
            return true;
        }
        else { return false;}
    }
    public void addCourse(String courseIndex, String confirmInput) {
        //if (courseIndex) in txt file (ie. valid)
        // extract courseCode from the .txt file using courseIndex as key
        // getCourseCode using courseIndex from Courses class?
        // hasVacancies check using Courses class?
        //hasVacancy = courseList.hasVacancies(courseIndex)
        boolean hasVacancy = true;
        //courseCode = courseList.getCourseCode(courseIndex);
        String courseCode = "CZ2002";
        if(!hasCourse(courseCode)) {
            if (hasVacancy) {
                if (numberOfCoursesRegistered <= MAXCOURSES) {
                    //display the index info
                    System.out.println("Enter 'OK' to confirm add course");
                    boolean confirmation = Confirmation(confirmInput);
                    if(confirmation) {
                        System.out.println("This index has now been added to your courses!");
                        studCourses.put(courseCode, courseIndex);
                        // reduce vacancy of this index
                    }
                    else{
                        System.out.println("This index is not added.");
                    }
                }
            }
        }
        //} // do i need to input an else failed statement?
    }

    public boolean Confirmation(String confirm) {
        if(confirm.toUpperCase() == "OK") { return true; }
        else { return false;}
    }

    public void dropCourse(String courseIndex, String confirmInput) {
        System.out.println("These are the courses that you have registered:");
        //Display the course index, course code, and status of the course
        System.out.println("Enter what Course Index you want to drop: ");
        //Scanner sc = new Scanner(System.in);
        //courseIndex = sc.nextInt();
        //if (courseIndex) in list of studCourses
        // extract courseCode from the .txt file using courseIndex as key

        //courseCode = courseList.getCourseCode(courseIndex);
        String courseCode = "CZ2002";
        if(hasCourse(courseCode)) {
            //display the index info (course index, course code, course type, course status)
            boolean confirmation = Confirmation(confirmInput);
            if(confirmation) {
                System.out.println("This index has now been dropped!");
                studCourses.remove(courseCode, courseIndex);
                // reduce vacancy of this index
            }
            else{
                System.out.println("This index is not added.");
            }
        }
        //}
    }

    public HashMap getCourses() {
        // using hashmap (Qingyi)
        /* Display content using Iterator*/
        Set set = studCourses.entrySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()) {
            Map.Entry mapEntry = (Map.Entry)iterator.next();
            System.out.print("Course code is: "+ mapEntry.getKey() + " & Course index is: ");
            System.out.println(mapEntry.getValue());
        }

        return studCourses;

    }

    // hasVacancies can be found using Courses class?
    //public boolean hasVacancies(courseIndex){
    //    if (checkVacancies > 0){return true;}
    //    else{return false;}
    //}

    public void displayVacancies(String courseIndex){
        // use get methods from Courses class to get course index info?
        // display the course index info
        // display places available and length of waitlist, vacancies
    }

    //public boolean checkTimingClash(int courseIndex, studCourses) {}

    public int getNumberOfCoursesRegistered(HashMap studCourses){
        this.numberOfCoursesRegistered = studCourses.size();
        return  numberOfCoursesRegistered;
    }


//    public void checkVacancies(int courseIndex){
//        //justina
//        System.out.println("The number of vacancies for the course index %d is %d",
//                courseIndex, getNumCourseIndexAvail);
//    }

    public void changeIndex(String oldIndex, String newIndex, String confirmInput){
        // from Courses class, getCourseCode of newIndex
        String courseCodeNew="CZ2002";
        //courseCodeNew = courseList.getCourseCode(oldIndex);
        // compare if they are from the same course
        // from Courses class, check for vacancy of newIndex

        if (!studCourses.containsValue(newIndex)){
            // display course info of old index
            // display course info of new index
            boolean confirmation = Confirmation(confirmInput);
            if(confirmation) {
                System.out.println("Index Number" + oldIndex+ " changed to "+ newIndex);
                studCourses.values().remove(oldIndex);
                studCourses.put(courseCodeNew, newIndex);
            }
            else{
                System.out.println("This index is not changed.");
            }
            // increase vacancy of oldIndex using Courses class
            // decrease vacancy of newIndex using Courses class
        }

    }

    public void swapIndex(String oldCourseIndex, String newCourseIndex, String confirmInput){
        // from Courses class, getCourseCode of newIndex
        String courseCode="CZ2002";
        //courseCode = courseList.getCourseCode(oldIndex);
        if (!oldCourseIndex.equals(newCourseIndex)){
            boolean confirmation = Confirmation(confirmInput);
            if(confirmation) {
                // increase vacancy of oldIndex using Courses class
                // decrease vacancy of newIndex using Courses class
                studCourses.values().remove(oldCourseIndex);
                studCourses.put(courseCode,newCourseIndex);
                System.out.println("Index Number" + oldCourseIndex+ " changed to "+ newCourseIndex);
            }
            else{
                System.out.println("This index is not changed.");
            }
            // increase vacancy of oldIndex using Courses class
            // decrease vacancy of newIndex using Courses class
            studCourses.values().remove(oldCourseIndex);
            studCourses.put(courseCode,newCourseIndex);

        }
        // in the main function, create another student class for the peer, to swap index for peer

        // check if current index is not equal to newCourseIndex
        // check if peerStudID and peerPassword is valid
        // put oldCourseIndex to temp int, add newCourseIndex to studCourses
        // put temp int to peerStudCourses
    }
}

