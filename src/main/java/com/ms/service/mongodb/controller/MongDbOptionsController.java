package com.ms.service.mongodb.controller;

import com.ms.service.mongodb.dao.OrderDao;
import com.ms.service.mongodb.entity.OrderEntity;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class MongDbOptionsController {

    @Resource
    OrderDao orderDao;

    @GetMapping("/save")
    public boolean save(@Param("id") Long id) {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setId(id);
        orderEntity.setTitle("title : " + id);
        orderEntity.setTimestamp(System.currentTimeMillis());
        orderDao.svae(orderEntity);
        return true;
    }

    @GetMapping("/findAll")
    public List<OrderEntity> findAll() {
        return orderDao.findAll();
    }

    @GetMapping("/find")
    public OrderEntity getOrderEntityById(@Param("id") Long id) {
        return orderDao.findOrderEntityById(id);
    }

    @GetMapping("/remove")
    public boolean remove(@Param("id") Long id) {
        orderDao.remove(orderDao.findOrderEntityById(id));
        return true;
    }
}
