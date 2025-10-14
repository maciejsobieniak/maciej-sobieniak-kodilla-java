package com.kodilla.good.patterns.challenges.Food2Door;

import com.kodilla.good.patterns.challenges.Food2Door.ProducerStore.*;

public class AppRun {

    public static void main(String[] args) {

        OrderRequestRetriever orderRequestRetriever = new OrderRequestRetriever();
        OrderRequest orderRequest = orderRequestRetriever.retrieve();

        //orderRequest.getProducer().process(orderRequest.getProduct(), orderRequest.getQuantity());

        OrderProcessor orderProcessor = new OrderProcessor(new ConsoleOutput(), new ProducerOrderService(), new ProducerOrderRepository());
        orderProcessor.process(orderRequest);

    }
}
