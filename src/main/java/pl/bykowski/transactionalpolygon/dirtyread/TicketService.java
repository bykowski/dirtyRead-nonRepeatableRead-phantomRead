package pl.bykowski.transactionalpolygon.dirtyread;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

@Service("TicketServiceDirtyRead")
public class TicketService {

    private final TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @Async
    public void update() throws InterruptedException, SQLException {
        Ticket ticketToNorway = new Ticket();
        ticketToNorway.setTicketName("to Norway");
        ticketRepository.save(ticketToNorway);
        Thread.sleep(3000);
        throw new RuntimeException("hehe");
    }

    @Async
    public void show() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println(ticketRepository.findAll());
    }
}
