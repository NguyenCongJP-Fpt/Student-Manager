package com.studentmanager.studentmanager.controller;

import com.studentmanager.studentmanager.entity.Student;
import com.studentmanager.studentmanager.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping(value = "/students")
public class StudentController {

    @Autowired
    StudentService studentService;

    // trang chủ phía user.
    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {
        List<Student> students = studentService.students();
        model.addAttribute("Students", students);
        return "student/index";
    }

    //xem chi tiết sinh vien.
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public String detail(@PathVariable int id, Model model) {
        Student student = studentService.getById(id);
        if (student == null) {
            return "error/404";
        }
        model.addAttribute("student", student);
        return "student/detail";
    }

    //tạo mới sinh vien.
    @RequestMapping(method = RequestMethod.GET, value = "/create")
    public String create(Model model) {
        model.addAttribute("student", new Student());
        return "student/form";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/login")
    public String login(Model model) {
        model.addAttribute("student", new Student());
        return "user/login";
    }

    //save sinh vienk m,
    @RequestMapping(method = RequestMethod.POST, value = "/create")
    public String store(Model model, Student student) {
        studentService.create(student);
        return "redirect:/students";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        Student student = studentService.getById(id);
        if (student == null) {
            return "error/404";
        }
        model.addAttribute("student", student);
        return "student/edit";
    }

    public String update(@PathVariable int id, Model model, Student updateStudent) {
        Student student = studentService.getById(id);
        if (student == null) {
            return "error/404";
        }
        student.setName(updateStudent.getName());
        student.setEmail(updateStudent.getEmail());
        studentService.update(student);
        return "redirect:/students";
    }

    //đoạn này yêu cầu viết ajax gửi lên, nhưng chưa biết viết...huhu
    // ham delete sing vien
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    @ResponseBody
    public ResponseEntity<Object> update(@PathVariable int id) {
        HashMap<String, Object> mapResponse = new HashMap<>();
        Student student = studentService.getById(id);
        if (student == null) {
            mapResponse.put("status", HttpStatus.NOT_FOUND.value());
            mapResponse.put("message", "Student is not found.");
            return new ResponseEntity<>(mapResponse, HttpStatus.NOT_FOUND);
        }
        studentService.delete(student);
        mapResponse.put("status", HttpStatus.OK.value());
        mapResponse.put("message", "Delete success");
        return new ResponseEntity<>(mapResponse, HttpStatus.OK);
    }

}
