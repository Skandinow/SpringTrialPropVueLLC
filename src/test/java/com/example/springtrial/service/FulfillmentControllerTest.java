package com.example.springtrial.service;

import com.example.springtrial.model.Product;
import com.example.springtrial.model.Status;
import com.example.springtrial.repository.FulfillmentRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest()
@AutoConfigureMockMvc
public class FulfillmentControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FulfillmentRepository mockRepository;

    @Test
    public void filterByStatus() throws Exception {
        String responseJson = """
          
                  [
              {
                  "id": 1,
                  "productId": "p1",
                  "status": "SELLABLE",
                  "fulfillmentCenter": "fc5",
                  "quantity": 4,
                  "value": 400
              }
          ]
          """;

        Mockito.when(mockRepository.findProductByStatus("SELLABLE"))
                .thenReturn(List.of(new Product(1, "p1", Status.SELLABLE, "fc5", 4, 400)));

        mockMvc.perform(get("/fulfillment/filter/status?status=SELLABLE"))
                .andExpect(status().isOk())
                .andExpect(content().json(responseJson));
    }

    @Test
    public void getAllSellable() throws Exception {
        String responseJson = """
                  [
              {
                  "id": 1,
                  "productId": "p1",
                  "status": "SELLABLE",
                  "fulfillmentCenter": "fc5",
                  "quantity": 4,
                  "value": 400
              }
          ]
          """;

        Mockito.when(mockRepository.getAllSellable())
                .thenReturn(List.of(new Product(1, "p1", Status.SELLABLE, "fc5", 4, 400)));

        mockMvc.perform(get("/fulfillment/all/sellable"))
                .andExpect(status().isOk())
                .andExpect(content().json(responseJson));

    }

    @Test
    public void getSumValByFulfillmentCenter() throws Exception {
        int responseJson = 1600;

        Mockito.when(mockRepository.getSumValByFulfillmentCenter("fc5")).thenReturn(1600);

        mockMvc.perform(get("/fulfillment/sum?fulfillment_center=fc5"))
                .andExpect(status().isOk())
                .andExpect(content().json(Integer.toString(responseJson)));
    }
}
