/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payroll;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.stereotype.Component;

/**
 *
 * @author udube
 */
@Component
class OrderModelAssembler implements RepresentationModelAssembler<Order, EntityModel<Order>>{

    @Override
    public EntityModel<Order> toModel(Order order) {
     
        EntityModel<Order> orderModel = 
                EntityModel.of(order,
                        linkTo(methodOn(OrderController.class).
                                one(order.getId())).withSelfRel(),
                        linkTo(methodOn(OrderController.class).
                        all()).withRel("orders"));
        
        if(order.getStatus() == Status.IN_PROGRESS){
          orderModel.add(linkTo(methodOn(OrderController.class)
          .cancel(order.getId())).withRel("cancel"));
          orderModel.add(linkTo(methodOn(OrderController.class)
          .complete(order.getId())).withRel("complete"));
        }
        return orderModel;
    }
    
}
