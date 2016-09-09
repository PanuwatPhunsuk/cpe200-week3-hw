package cpe200;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student {

    public Student() {
        this("","",1990,false);
    }
    public  Student(String name,String id,int YearofBirth,boolean status){
        this.Student_name =!name.equalsIgnoreCase("")?name:"John Doe";
        this.Student_id =isValidStudent_id(id)?id:"560610000";
        this.YoB =isValidYOB(YearofBirth)?YearofBirth:1990;
        this.status = status;
    }


    // implement all missing constructors here

    // implement all get and set methods here

    @Override
    public String toString() {
        String n;
        if(isActive() ==false)
        {
            n =" is an INACTIVE student.";
        }else
        {
            n =" is an ACTIVE student.";
        }
        String o = this.Student_name+" ("+this.Student_id+")"+" was born in "+this.YoB+n;

        return o;
    }

    private boolean isValidStudent_id(String id) {
        Pattern p =Pattern.compile(X);
        Matcher m =p.matcher(id);
        return m.matches();
    }

    private boolean isValidYOB(int yob) {
        if(yob<1989){
            return false;
        }
        return true;
    }
    private String Student_name;
    private String Student_id;
    private int YoB;
    private boolean status;
    private static final String X= "5+[6-9]+[061]+[0-2]+\\d{3}";

    // declare your attributes here

    public String getName() {
        return Student_name;
    }

    public void setName(String student_name) {
        this.Student_name =!student_name.equalsIgnoreCase("")?student_name:this.Student_name;
    }
    public  String getStudent_id(){
        return  Student_id;
    }
    public void setStudent_id(String student_id) {
        this.Student_id =isValidStudent_id(student_id)?student_id:this.Student_id;
    }

    public int getYearOfBirth() {
        return YoB;
    }

    public void setYearOfBirth(int yoB) {
        if(yoB<1989){
            yoB = this.YoB;
        }else{
            this.YoB = yoB;
        }
    }
    public boolean isActive(){
        return status;
    }


}
