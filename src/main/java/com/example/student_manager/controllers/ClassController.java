package com.example.student_manager.controllers;

import com.example.student_manager.exceptions.EmptyException;
import com.example.student_manager.exceptions.NotFoundException;
import com.example.student_manager.models.dto.ClassDTO;
import com.example.student_manager.models.in.ClassIn;
import com.example.student_manager.services.business.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/classes")
public class ClassController {

    @Autowired
    private ClassService service;
    private Object ClassEntityValidator;

//    @InitBinder
//    public void myInitBinder(WebDataBinder dataBinder) {
//        Object target = dataBinder.getTarget();
//
//        if (target.getClass() == ClassEntity.class) {
//            dataBinder.setValidator((Validator) ClassEntityValidator);
//        }
//    }
    @GetMapping
    public ResponseEntity<List<ClassDTO>> read() {
        return ResponseEntity.ok(service.read());
    }

    @PostMapping
    public ResponseEntity<ClassDTO> create(@RequestBody ClassIn classIn) throws EmptyException {
        return ResponseEntity.ok(service.create(classIn));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") int id) throws NotFoundException {
        return ResponseEntity.ok(service.delete(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClassDTO> edit(@RequestBody ClassIn classIn, @PathVariable("id") int id) throws NotFoundException {
        return ResponseEntity.ok(service.edit(classIn, id));
    }
}
