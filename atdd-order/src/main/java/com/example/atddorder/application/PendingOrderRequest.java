package com.example.atddorder.application;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PendingOrderRequest {

    private long productId;
    private int quantity;

    private PendingOrderRequest(long productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public static PendingOrderRequest of(long productId, int quantity) {
        return new PendingOrderRequest(productId, quantity);
    }
}
