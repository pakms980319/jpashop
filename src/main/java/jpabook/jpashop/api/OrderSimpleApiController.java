package jpabook.jpashop.api;

import jpabook.jpashop.domain.Order;
import jpabook.jpashop.repository.OrderSearch;
import jpabook.jpashop.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * XToOne 관계는 Lazy 로 설정되어 있음
 * Order
 * Order -> Member (ManyToOne)
 * Order -> Delivery (OneToOne)
 */
@RestController
@RequiredArgsConstructor
public class OrderSimpleApiController {

    private final OrderService orderService;

    @GetMapping("/api/v1/simple-orders")
    public List<Order> ordersV1() {
        List<Order> all = orderService.findOrders(new OrderSearch());

        // Lazy 프록시 강제 초기화
        for (Order order : all) {
            order.getMember().getName();
            order.getDelivery().getAddress();
            order.getOrderItems().size();
        }

        return all;
    }
}
