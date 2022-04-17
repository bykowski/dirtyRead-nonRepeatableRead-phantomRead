package pl.bykowski.transactionalpolygon.phantomread;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component("RunPhantomRead")
public class RunMePhantom {

    private final TicketService ticketService;

    public RunMePhantom(TicketService ticketService) {
        this.ticketService = ticketService;
    }

//    @EventListener(ApplicationReadyEvent.class)
    public void get() throws InterruptedException {
        ticketService.saveNewElement();
        ticketService.show();
    }
}
