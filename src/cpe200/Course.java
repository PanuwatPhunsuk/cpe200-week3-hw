package cpe200;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Course {

    public Course() {
        this("","","",30);
    }

    public Course(String n, String cid) {
        this.course_name = !n.equalsIgnoreCase("")?n:"TBA";
        this.course_id =isValidCourse_id(cid)?cid:"000000";
        this.lecturer = "TBA";
        this.max_students = 30;
        this.no_students = 0;
    }

    public Course(String n, String cid, String l) {
        this.course_name = !n.equalsIgnoreCase("")?n:"TBA";
        this.course_id =isValidCourse_id(cid)?cid:"000000";
        this.lecturer=!l.equalsIgnoreCase("")?l:"TBA";
        this.max_students = 30;
        this.no_students =0;
    }

    public Course(String n, String cid, String l, int max) {
        this.course_name = !n.equalsIgnoreCase("")?n:"TBA";
        this.course_id =isValidCourse_id(cid)?cid:"000000";
        this.lecturer=!l.equalsIgnoreCase("")?l:"TBA";
        this.max_students =(max>9)?max:30;
        this.no_students =0;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = !course_name.equalsIgnoreCase("")?course_name:this.course_name;
    }

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = isValidCourse_id(course_id)?course_id:this.course_id;
    }

    // implement the other get and set methods here
    public String getLecturer() {

        return lecturer;
    }

    public void setLecturer(String lecturer) {
        this.lecturer =!lecturer.equalsIgnoreCase("")?lecturer:this.lecturer;
    }

    public int getMax_students() {

        return max_students;
    }

    public void setMax_students(int max_students) {
        if(max_students<10)
        {
            max_students = this.max_students;

        }else{
            this.max_students = max_students;
        }
    }

    public int getNo_students() {

        return no_students;
    }

    public void setNo_students(int no_students) {
        if(no_students>this.max_students||no_students<0)
        {
            no_students =this.no_students;
        }else{
            this.no_students = no_students;
        }
    }

    @Override
    public String toString() {
        String n;
        if (this.no_students==1){
            n = "ONE student, [maximum: "+this.max_students +"]";
        }else if(this.no_students==0){
            n="NO student, [maximum: "+this.max_students +"]";
        }else{
            n = this.no_students+" students, [maximum: "+this.max_students +"]";
        }
        String o = this.course_name + " ("
                + this.course_id + "), Teacher: "
                + this.lecturer + ", has "
                + n;

        // implement the rest here

        return o;
    }

    private boolean isValidCourse_id(String id) {
        Pattern p = Pattern.compile(idREGEX);
        Matcher m = p.matcher(id);

        if(m.matches()==false){
            return  false;
        }

        return true;
    }

    // Regular expression for the Student ID pattern
    private static final String idREGEX = "\\d{6}";

    // all private attributes
    private String course_name;
    private String course_id;
    private String lecturer;
    private int max_students;
    private int no_students;
}
