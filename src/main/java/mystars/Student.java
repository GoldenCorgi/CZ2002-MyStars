package mystars;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

// in the main function, create another student class for the peer, to swap index for peer

// check if current index is not equal to newCourseIndex
// check if peerStudID and peerPassword is valid
// put oldCourseIndex to temp int, add newCourseIndex to studCourses
// put temp int to peerStudCourses


public class Student implements Serializable {
    private static final long serialVersionUID = 42L;

    private String matricNo, studentName, studentEmail, studentGender, studentNationality;
    private int numberOfCoursesRegistered, MaxAcademicUnit = 21;
    private HashMap<String, String> studentCourses = new HashMap<>();

    public Student(String matricNo, String studentName, String studentEmail, String studentGender, String studentNationality) {
        this.studentName = studentName;
        this.matricNo = matricNo;
        this.studentEmail = studentEmail;
        this.studentGender = studentGender;
        this.studentNationality = studentNationality;

    }

    public String getStudentName() {
        return this.studentName;
    }

    public String getMatricNo() {
        return this.matricNo;
    }

    public String getStudentEmail() {
        return this.studentEmail;
    }

    public String getStudentGender() {
        return this.studentGender;
    }

    public String getStudentNationality() {
        return this.studentNationality;
    }

    public boolean hasCourse(String courseCode) {
        return (this.studentCourses.containsKey(courseCode));
    }

    public void addCourse(String courseCode, String courseIndex) {
        this.studentCourses.put(courseCode, courseIndex);
    }

    public void dropCourse(String courseCode) {
        this.studentCourses.remove(courseCode);
    }

    public HashMap<String, String> getCourse() {
        return this.studentCourses;
    }

    public void printCourse() {
        // https://stackoverflow.com/questions/1066589/iterate-through-a-hashmap
        for (Map.Entry<String, String> entry : this.studentCourses.entrySet()) {
            String CourseCode = entry.getKey();
            String CourseIndex = entry.getValue();
            System.out.println(" CourseCode: " + CourseCode + "// Course Index: " + CourseIndex);
        }
    }


    public boolean checkTimingClash(String courseCode1, String courseCode2, String courseIndex1, String courseIndex2) {
        return true;
    }

    public int getNumberOfCoursesRegistered() {
        return this.studentCourses.size();
    }


// + hasVacancies(courseIndex): boolean
// + checkVacancies(courseIndex): int
// + checkVerification(): boolean
// + updateCourseData(checkVerification): void

//    public int getChoice(Scanner sc) {
//        System.out.println("Enter the number of your choice: ");
//        int choice = sc.nextInt();
//        return choice;
//    }
//
//    public boolean hasCourse(String courseCode) {
//        if (studCourses.containsKey(courseCode)) {
//            return true;
//        } else {
//            return false;
//        }
//    }
//
//    public void addCourse() {
//        //if (courseIndex) in txt file (ie. valid)
//        // extract courseCode from the .txt file using courseIndex as key
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Please enter index number: ");
//        int index = sc.nextInt();
//        String courseIndex = String.valueOf(index);
//        // getCourseCode using courseIndex from Courses class?
////        // hasVacancies check using Courses class?
////        //hasVacancy = courseList.hasVacancies(courseIndex)
//        boolean hasVacancy = true;
////        //courseCode = courseList.getCourseCode(courseIndex);
//        String courseCode = "CZ2002";
//        if (!hasCourse(courseCode)) {
//            if (hasVacancy) {
//                if (numberOfCoursesRegistered <= MAXCOURSES) {
//                    //display the index info
//                    System.out.println("Enter '1' to confirm add course: ");
//                    int confirm = sc.nextInt();
//                    boolean confirmed = Confirmation(confirm);
//                    if (confirmed) {
//                        System.out.println("This index has now been added to your courses!");
//                        studCourses.put(courseCode, courseIndex);
//                        // reduce vacancy of this index
//                    }
//                }
//            } else {
//                System.out.println("Course has already been added");
//            }
//        }
//    }
//
//    public boolean Confirmation(int confirm) {
//        if (confirm == 1) {
//            return true;
//        } else {
//            return false;
//        }
//    }
//
//    public void dropCourse() {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("These are the courses that you have registered:");
//        this.getCourses();
//        //Display the course index, course code, and status of the course
//        System.out.println("Enter what Course Index you want to drop: ");
//        int index = sc.nextInt();
//        String courseIndex = String.valueOf(index);
//        //if (courseIndex) in list of studCourses
//        // extract courseCode from the .txt file using courseIndex as key
//
//        //courseCode = courseList.getCourseCode(courseIndex);
//        String courseCode = "CZ2002";
//        if (hasCourse(courseCode)) {
//            //display the index info (course index, course code, course type, course status)
//            System.out.println("Enter 1 to confirm drop course");
//            int confirm = sc.nextInt();
//            boolean confirmed = Confirmation(confirm);
//            if (confirmed) {
//                System.out.println("This index has now been dropped!");
//                studCourses.remove(courseCode, courseIndex);
//                // reduce vacancy of this index
//            } else {
//                System.out.println("This index is not added.");
//            }
//        }
//        //}
//    }
//
//    public HashMap getCourses() {
//        // using hashmap (Qingyi)
//        /* Display content using Iterator*/
//        Set set = studCourses.entrySet();
//        Iterator iterator = set.iterator();
//        while (iterator.hasNext()) {
//            Map.Entry mapEntry = (Map.Entry) iterator.next();
//            System.out.print("Course code is: " + mapEntry.getKey() + " & Course index is: ");
//            System.out.println(mapEntry.getValue());
//        }
//        System.out.print("All courses registered displayed");
//        return studCourses;
//    }
//
//    // hasVacancies can be found using Courses class?
//    //public boolean hasVacancies(courseIndex){
//    //    if (checkVacancies > 0){return true;}
//    //    else{return false;}
//    //}
//
//    public void displayVacancies(String courseIndex) {
//        // use get methods from Courses class to get course index info?
//        // display the course index info
//        // display places available and length of waitlist, vacancies
//    }
//
//    //public boolean checkTimingClash(int courseIndex, studCourses) {}
//
//    public int getNumberOfCoursesRegistered(HashMap studCourses) {
//        this.numberOfCoursesRegistered = studCourses.size();
//        return numberOfCoursesRegistered;
//    }
//
//
////    public void checkVacancies(int courseIndex){
////        //justina
////        System.out.println("The number of vacancies for the course index %d is %d",
////                courseIndex, getNumCourseIndexAvail);
////    }
//
//    public void changeIndex() {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter Current Index: ");
//        int indexCur = sc.nextInt();
//        String oldIndex = String.valueOf(indexCur);
//        System.out.println("Enter New Index: ");
//        int indexN = sc.nextInt();
//        String newIndex = String.valueOf(indexN);
//        // from Courses class, getCourseCode of newIndex
//        String courseCodeNew = "CZ2002";
//        //courseCodeNew = courseList.getCourseCode(oldIndex);
//        // compare if they are from the same course
//        // from Courses class, check for vacancy of newIndex
//
//        if (!studCourses.containsValue(newIndex)) {
//            // display course info of old index
//            // display course info of new index
//            System.out.println("Enter 1 to confirm change course index: ");
//            int confirm = sc.nextInt();
//            boolean confirmed = Confirmation(confirm);
//            if (confirmed) {
//                System.out.println("Index Number " + oldIndex + " changed to " + newIndex);
//                studCourses.values().remove(oldIndex);
//                studCourses.put(courseCodeNew, newIndex);
//            } else {
//                System.out.println("This index is not changed.");
//            }
//            // increase vacancy of oldIndex using Courses class
//            // decrease vacancy of newIndex using Courses class
//        }
//
//    }
//
//    public String swapIndex() {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter Your Index: ");
//        int index1 = sc.nextInt();
//        String oldCourseIndex = String.valueOf(index1);
//        System.out.println("Enter Peer's Username: ");
//        String peerUN = sc.nextLine();
//        System.out.println("Enter Peer's Password: ");
//        String peerPW = sc.nextLine();
//        System.out.println("Enter Peer's Index: ");
//        int index2 = sc.nextInt();
//        String newCourseIndex = String.valueOf(index2);
//        // from Courses class, getCourseCode of newIndex
//        String courseCode = "CZ2002";
//        //courseCode = courseList.getCourseCode(oldIndex);
//        if (!oldCourseIndex.equals(newCourseIndex)) {
//            System.out.println("Enter 1 to confirm swap course:");
//            int confirm = sc.nextInt();
//            boolean confirmed = Confirmation(confirm);
//            if (confirmed) {
//                // increase vacancy of oldIndex using Courses class
//                // decrease vacancy of newIndex using Courses class
//                studCourses.values().remove(oldCourseIndex);
//                studCourses.put(courseCode, newCourseIndex);
//                System.out.println("Index Number " + oldCourseIndex + " changed to " + newCourseIndex);
//            } else {
//                System.out.println("This index is not changed.");
//                peerUN = "No swap";
//            }
//        }
//        return peerUN;
//    }
}

// in the main function, create another student class for the peer, to swap index for peer

// check if current index is not equal to newCourseIndex
// check if peerStudID and peerPassword is valid
// put oldCourseIndex to temp int, add newCourseIndex to studCourses
// put temp int to peerStudCourses



