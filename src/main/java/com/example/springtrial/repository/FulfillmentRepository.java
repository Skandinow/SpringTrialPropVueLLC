package com.example.springtrial.repository;

import com.example.springtrial.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FulfillmentRepository extends CrudRepository<Product, Integer> {
    @Query(value = """
            select * from products p where status=:status
           """, nativeQuery = true)
    List<Product> findProductByStatus(String status);

    @Query(value = """
        select * from products p where status='SELLABLE'
        """, nativeQuery = true)
    List<Product> getAllSellable();

    @Query(value = """
    select sum(value * quantity)  from products p
                      where fulfillment_center=:fulfillmentCenter
    """, nativeQuery = true)
    Integer getSumValByFulfillmentCenter(String fulfillmentCenter);
}
