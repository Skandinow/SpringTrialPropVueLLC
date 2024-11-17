package com.example.springtrial.controller;

import com.example.springtrial.model.Product;
import com.example.springtrial.model.Status;
import com.example.springtrial.service.FulfillmentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Fulfillment")
@RequiredArgsConstructor
@RestController
@RequestMapping("/fulfillment")
public class FulfillmentController {
    final FulfillmentService fulfillmentService;

    @GetMapping("/filter/status")
    public List<Product> filterByStatus(@RequestParam Status status) {
        return fulfillmentService.filterByStatus(status);
    }

    @GetMapping("all/sellable")
    public List<Product> getAllSellable() {
        return fulfillmentService.getAllSellable();
    }

    @GetMapping("sum")
    public Integer getSumValByFulfillmentCenter(@RequestParam("fulfillment_center") String fulfillmentCenter) {
        return fulfillmentService.getSumValByFulfillmentCenter(fulfillmentCenter);
    }
}
