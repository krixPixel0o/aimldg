package jar.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import jar.model.Student;
import jar.repo.StudentRepo;

@Service
public class Rservice {

    StudentRepo db;

    Rservice(StudentRepo db) {
        this.db = db;
    }

    public Map<Object, Object> rs(Integer id) {

        Map<Object, Object> res = new HashMap<>();

        if (db.existsById(id)) {

            Student student = db.findById(id).get();

            res.put("msg", "Student Found");
            res.put("status", 200);
            res.put("student", student);

        } else {

            res.put("msg", "Student Not Found");
            res.put("status", 404);
        }

        return res;
    }
}