package com.example.springtrial.controller;

import com.example.springtrial.model.Product;
import com.example.springtrial.model.Status;
import com.example.springtrial.service.FulfillmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@Tag(name = "Fulfillment")
@RequiredArgsConstructor
@RestController
@RequestMapping("/fulfillment")
public class FulfillmentController {
    final FulfillmentService fulfillmentService;

    @Operation(description = "Фильтрует продукты по статусу")
    @GetMapping("/filter/status")
    public List<Product> filterByStatus(@RequestParam Status status) {
        return fulfillmentService.filterByStatus(status);
    }

    @Operation(description = "Возвращает все продукты со статусом SELLABLE")
    @GetMapping("all/sellable")
    public List<Product> getAllSellable() {
        return fulfillmentService.getAllSellable();
    }

    @Operation(description = "Возвращает суммарную цену всех продуктов по fulfillment_center")
    @GetMapping("sum")
    public Integer getSumValByFulfillmentCenter(@RequestParam("fulfillment_center") String fulfillmentCenter) {
        Integer result = fulfillmentService.getSumValByFulfillmentCenter(fulfillmentCenter);
        return Objects.equals(result, null) ? 0 : result;
    }
}
