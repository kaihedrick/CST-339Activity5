package com.gcu.business;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gcu.model.OrdersList;
import com.gcu.model.OrderModel;


@RestController
@RequestMapping("/service")
public class OrdersRestService {
    private final OrdersBusinessServiceInterface orders;
    public OrdersRestService(OrdersBusinessServiceInterface orders) {
        this.orders = orders;
    }
    
    @GetMapping(path="/getjson", produces={MediaType.APPLICATION_JSON_VALUE})
    public List<OrderModel> getOrdersAsJson()
    {
        return orders.getOrders();
    }
    @GetMapping(path="/getxml", produces={MediaType.APPLICATION_XML_VALUE})
    public OrdersList getOrdersAsXml()
    {
        OrdersList list = new OrdersList();
        list.setOrders(orders.getOrders());
        return list;
    }
    @GetMapping(path="/getorder/{id}")
    public ResponseEntity<?> getOrder(@PathVariable("id") String id) {
        try{
            OrderModel order = orders.getOrderById(id);
            if(order==null)
            {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            else{
                return new ResponseEntity<>(order, HttpStatus.OK);
            }
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
