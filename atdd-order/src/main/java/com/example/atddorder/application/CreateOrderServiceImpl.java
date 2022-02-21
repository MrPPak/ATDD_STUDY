package com.example.atddorder.application;

import com.example.atddorder.domain.PendingOrder;
import com.example.atddorder.domain.PendingOrderRepository;
import com.example.atddorder.infra.PendingOrderRepositoryMemoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
class CreateOrderServiceImpl implements CreateOrderService {

    private final PendingOrderRepository pendingOrderRepository;

    @Override
    public PendingOrder createPendingOrder(PendingOrderRequest request) {
        PendingOrder pendingOrder = new PendingOrder(request.getProductId(), request.getQuantity());
        return pendingOrderRepository.save(pendingOrder);
    }
}
