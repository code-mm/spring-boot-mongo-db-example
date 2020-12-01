package com.ms.service.mongodb.dao;

import com.ms.service.mongodb.entity.OrderEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderDao {


    void svae(OrderEntity entity);

    void remove(OrderEntity entity);

    void update(OrderEntity entity);

    OrderEntity findOrderEntityById(Long id);

   List<OrderEntity> findAll();

}
