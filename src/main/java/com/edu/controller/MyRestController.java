package com.edu.controller;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class MyRestController {
    private static List<String> empList=new ArrayList<String>();

  //  private final MyRepo repository;

//    MyRestController(MyRepo repository) {
//        this.repository = repository;
//    }


    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/strings")
    List<String> all() {
      return empList;
    }
    // end::get-aggregate-root[]

    @PostMapping("/string")
    String newEmployee(@RequestBody String newEmployee) {
        empList.add(newEmployee);
        return newEmployee;
    }

    // Single item

//    @GetMapping("/employees/{id}")
//    Employee one(@PathVariable Long id) {
//
//        return repository.findById(id)
//                .orElseThrow(() -> new EmployeeNotFoundException(id));
//    }
//
//    @PutMapping("/employees/{id}")
//    Employee replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {
//
//        return repository.findById(id)
//                .map(employee -> {
//                    employee.setName(newEmployee.getName());
//                    employee.setRole(newEmployee.getRole());
//                    return repository.save(employee);
//                })
//                .orElseGet(() -> {
//                    newEmployee.setId(id);
//                    return repository.save(newEmployee);
//                });
//    }

    @DeleteMapping("/string/{str}")
    void deleteEmployee(@PathVariable String str) {
        empList.remove(str);
    }
}

