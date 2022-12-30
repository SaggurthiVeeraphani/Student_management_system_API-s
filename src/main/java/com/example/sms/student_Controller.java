package com.example.sms;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController//Telling the java class that this class will contain API endpoints
public class student_Controller {
    //database
    HashMap<Integer,Student> studentDB = new HashMap<>();

    //add user
    @PostMapping("/add_student")
    public String addStudent(@RequestBody()Student student){
        int key = student.getId();

        //add it to the student database
        studentDB.put(key,student);
     return "student has been created";
    }


    //get user
    @GetMapping("get_student_by_id")
    public Student getStudentById(@RequestParam("id")Integer id){
        return studentDB.get(id);
    }

    //writing get student function with path variable
    @GetMapping("get_by_path_variable/{id}")
    public Student getbypathvariable(@PathVariable("id")Integer id){
        return studentDB.get(id);
    }



    //get student by name
    @GetMapping("get_student_by_name")
    public Student getstudentbyName(@RequestParam("name")String nam){
        for(Student s : studentDB.values()){
            if(s.getName().equals(nam)){
                return s;
            }
        }
        //if it is not found
        return null;
    }

    //update the data
    @PutMapping("/update_student")
    public Student update_student(@RequestBody()Student student){
        int key = student.getId();
        studentDB.put(key,student);
        return student;
    }


    //delete the student

    @DeleteMapping("/delete_student")
    public String delete_student(@RequestParam("id")Integer id){
        studentDB.remove(id);
        return "Student has been removed successfully";
    }
}
