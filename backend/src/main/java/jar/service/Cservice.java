package jar.service;

import java.util.*;
import org.springframework.stereotype.Service;

import jar.model.Student;
import jar.repo.StudentRepo;

@Service
public class Cservice {

    StudentRepo db;

    Cservice(StudentRepo db) {
        this.db = db;
    }

    public Map<Object, Object> cs(Student student) {

        Map<Object, Object> res = new HashMap<>();

        Student savedStudent = db.save(student);

        res.put("msg", "Student Created Successfully");
        res.put("status", 201);
        res.put("student", savedStudent);

        return res;
    }
}