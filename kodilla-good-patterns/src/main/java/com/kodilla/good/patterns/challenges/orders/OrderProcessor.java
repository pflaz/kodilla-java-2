package com.kodilla.good.patterns.challenges.orders;

public class OrderProcessor {
    private InformationService informationService;
    private OrderService orderService;
    private Repository repository;

    public OrderProcessor(final InformationService informationService,
                          final OrderService orderService,
                          final Repository Repository) {
        this.informationService = informationService;
        this.orderService = orderService;
        this.repository = Repository;
    }

    public boolean process(final OrderRequest orderRequest) {
        boolean isOrdered = orderService.order(orderRequest);
        if (isOrdered) {
            informationService.sendConfirmation(orderRequest);
            repository.add(orderRequest);
            return true;
        }
        else {
            return false;
        }
    }

    public void showRepository() {
        repository.show();
    }
}
