package pl.bykowski.transactionalpolygon.nonrepetableread;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component("RunMeNonRepeatableRead")
public class RunMe {

    private final TicketService ticketService;

    public RunMe(TicketService ticketService) {
        this.ticketService = ticketService;
    }

   @EventListener(ApplicationReadyEvent.class)
    public void get() throws InterruptedException {
        ticketService.update();
        ticketService.show();
    }
}
