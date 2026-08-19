package jar.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import jar.model.Student;
import jar.repo.StudentRepo;

@Service
public class Uservice {

    StudentRepo db;

    Uservice(StudentRepo db) {
        this.db = db;
    }

    public Map<Object, Object> us(Integer id, Student student) {

        Map<Object, Object> res = new HashMap<>();

        if (db.existsById(id)) {

            Student oldStudent = db.findById(id).get();

            oldStudent.setName(student.getName());
            oldStudent.setEmail(student.getEmail());
            oldStudent.setIp(student.getIp());

            Student updatedStudent = db.save(oldStudent);

            res.put("msg", "Student Updated Successfully");
            res.put("status", 200);
            res.put("student", updatedStudent);

        } else {

            res.put("msg", "Student Not Found");
            res.put("status", 404);
        }

        return res;
    }
}