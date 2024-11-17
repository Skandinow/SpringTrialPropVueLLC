package com.example.springtrial.service;

import com.example.springtrial.model.Product;
import com.example.springtrial.model.Status;
import com.example.springtrial.repository.FulfillmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FulfillmentService {
    final FulfillmentRepository fulfillmentRepository;

    public List<Product> filterByStatus(Status status) {
        return fulfillmentRepository.findProductByStatus(status.toString());
    }

    public List<Product> getAllSellable() {
        return fulfillmentRepository.getAllSellable();
    }

    public Integer getSumValByFulfillmentCenter(String fulfillmentCenter) {
        return fulfillmentRepository.getSumValByFulfillmentCenter(fulfillmentCenter);
    }
}
