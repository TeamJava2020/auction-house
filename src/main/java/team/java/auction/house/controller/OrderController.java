package team.java.auction.house.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(path = "/orders")
public class OrderController {


    @PostMapping("/add-order")
    public Object addOrder() {
        return null;
    }

    @GetMapping("/get-all-orders")
    public List getAllOrders(){
        return Collections.singletonList("orders");
    }





}
