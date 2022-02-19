/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payroll;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author udube
 */
@RestController
public class EmployeeController {
    
    private final EmployeeRepository repo;
    private final EmployeeModelAssembler assembler;
    /**
     *
     * @param repo
     */
    public EmployeeController(EmployeeRepository repo,
            EmployeeModelAssembler assembler) {
        this.repo = repo;
        this.assembler = assembler;
    }
    
    @GetMapping("/employees")
    CollectionModel<EntityModel<Employee>> all(){
        
        List<EntityModel<Employee>> employees = repo.findAll().stream()
                .map(assembler::toModel).collect(Collectors.toList());
        
        return CollectionModel.of(employees, linkTo(methodOn(EmployeeController.class).all()).withSelfRel());
   } 
    
    @PostMapping("/employees")
    ResponseEntity<?> newEmployee(@RequestBody Employee newEmployee){
        
        EntityModel<Employee> entityModel = 
                assembler.toModel(repo.save(newEmployee));
        return ResponseEntity.created(entityModel.
                getRequiredLink(IanaLinkRelations.SELF)
        .toUri()).body(entityModel);
    }
    
    @GetMapping("/employees/{id}")
    EntityModel<Employee> findEmployeeById(@PathVariable Long id){
        
        Employee employee = repo.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));
        return assembler.toModel(employee);
    }
    
    @PutMapping("/employees/{id}")
    ResponseEntity<?> replaceEmployee(@RequestBody Employee newEmployee,
            @PathVariable Long id){
        
        Employee updateEmployee = repo.findById(id).map(emp ->{
                emp.setName(newEmployee.getName());
                emp.setRole(newEmployee.getRole());
                return repo.save(emp);
                }).
                orElseGet(() -> {
                    newEmployee.setId(id);
                    return repo.save(newEmployee);
                });
        EntityModel<Employee> entityModel =
                assembler.toModel(updateEmployee);
        
        return ResponseEntity.created(entityModel
        .getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(entityModel);
    }
    
    @DeleteMapping("/employees/{id}")
    ResponseEntity<?> deleteEmployee(@PathVariable Long id){
        repo.deleteById(id);
        
        return ResponseEntity.noContent().build();
    }
}
