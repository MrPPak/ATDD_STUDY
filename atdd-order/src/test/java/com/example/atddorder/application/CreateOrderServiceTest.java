package com.example.atddorder.application;

import com.example.atddorder.domain.PendingOrder;
import com.example.atddorder.infra.PendingOrderRepositoryMemoryImpl;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CreateOrderServiceTest {

    private CreateOrderService createOrderService = new CreateOrderServiceImpl(new PendingOrderRepositoryMemoryImpl());

    @Test
    public void createPendingOrder() throws Exception {

        // given
        Long productId = 1L;
        int quantity = 2;
        PendingOrderRequest request = PendingOrderRequest.of(productId, quantity);

        // when
        PendingOrder pendingOrder = createOrderService.createPendingOrder(request);

        // then
        assertThat(pendingOrder.getId()).isPositive();
    }

}
