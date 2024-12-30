package com.mimipizza.state;

import com.mimipizza.model.Order;

public interface OrderState {
    void processOrder(Order order);
}
