package com.ms.service.mongodb.dao.impl;

import com.ms.service.mongodb.dao.OrderDao;
import com.ms.service.mongodb.entity.OrderEntity;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class OrderDaoImpl implements OrderDao {
    @Resource
    private MongoTemplate mongoTemplate;

    @Override
    public void svae(OrderEntity entity) {
        mongoTemplate.save(entity);
    }

    @Override
    public void remove(OrderEntity entity) {
        mongoTemplate.remove(entity);
    }

    @Override
    public void update(OrderEntity entity) {
        Query query = new Query(Criteria.where("id").is(entity.getId()));
        Update update = new Update();
        update.set("title", entity.getTitle());
        update.set("timestamp", entity.getTimestamp());
        mongoTemplate.updateFirst(query, update, OrderEntity.class);
    }

    @Override
    public OrderEntity findOrderEntityById(Long id) {
        Query query = new Query(Criteria.where("id").is(id));
        OrderEntity demoEntity = mongoTemplate.findOne(query, OrderEntity.class);
        return demoEntity;
    }

    @Override
    public List<OrderEntity> findAll() {
        return mongoTemplate.findAll(OrderEntity.class);
    }
}
