/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payroll;

import org.springframework.hateoas.EntityModel;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
/**
 *
 * @author udube
 */
@Component
class EmployeeModelAssembler implements RepresentationModelAssembler<Employee, EntityModel<Employee>>{

    @Override
    public EntityModel<Employee> toModel(Employee employee) {
        return EntityModel.of(employee,
                linkTo(methodOn(EmployeeController.class)
                .findEmployeeById(employee.getId())).withSelfRel(),
                linkTo(methodOn(EmployeeController.class)
                .all()).withRel("employees"));
    }
    
}
