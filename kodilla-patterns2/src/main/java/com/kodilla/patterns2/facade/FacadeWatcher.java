package com.kodilla.patterns2.facade;

import com.kodilla.patterns2.facade.api.OrderDto;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class FacadeWatcher {
    private static final Logger LOGGER = LoggerFactory.getLogger(FacadeWatcher.class);
    private OrderDto orderDto;

    /*    @Before("execution(* com.kodilla.patterns2.facade.api.OrderFasade.processOrder(..))" +
        "&& args(OrderDto order, Long userId")*/
    @Before("execution(* com.kodilla.patterns2.facade.api.OrderFacade.processOrder(..))")
//    public void logEvent(OrderDto order, Long userId) {
    public void logEvent() {
        LOGGER.info("Logging the event (caused by aspect)");
    }
}
