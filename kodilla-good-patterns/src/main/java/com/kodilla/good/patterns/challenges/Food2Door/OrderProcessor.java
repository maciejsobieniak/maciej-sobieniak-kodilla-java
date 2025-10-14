package com.kodilla.good.patterns.challenges.Food2Door;

public class OrderProcessor {
    private InformationService informationService;
    private OrderService orderService;
    private OrderRepository orderRepository;

    public OrderProcessor(InformationService informationService, OrderService orderService, OrderRepository orderRepository) {
        this.informationService = informationService;
        this.orderService = orderService;
        this.orderRepository = orderRepository;
    }

    public OrderDto process(OrderRequest orderRequest) {
        ProcessResult result = orderService.order(orderRequest.getUser(), orderRequest.getProducer(), orderRequest.getProduct(), orderRequest.getQuantity());
        if (result.isSuccess()) {
            informationService.inform(orderRequest.getUser(), result.getMessage());
            orderRepository.createOrder(orderRequest.getUser(), orderRequest.getProducer(), orderRequest.getProduct(), orderRequest.getQuantity());
            return new OrderDto(orderRequest.getUser(), true);
        } else {
            informationService.inform(orderRequest.getUser(), result.getMessage());
            return new OrderDto(orderRequest.getUser(), false);
        }
    }

}
