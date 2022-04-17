package pl.bykowski.transactionalpolygon.phantomread;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.List;

@Service("TicketServicePhantomRead")
@Transactional(isolation = Isolation.SERIALIZABLE)
public class TicketService {

    private final TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @PostConstruct
    public void save() {
        Ticket ticketToNorway = new Ticket();
        ticketToNorway.setTicketName("to Norway");
        Ticket ticketToCanada = new Ticket();
        ticketToCanada.setTicketName("to Canada");
        ticketRepository.save(ticketToNorway);
        ticketRepository.save(ticketToCanada);
    }

    @Async
    public void saveNewElement() throws InterruptedException {
        Ticket ticketToFrance = new Ticket();
        ticketToFrance.setTicketName("to France");
        Thread.sleep(2000);
        ticketRepository.save(ticketToFrance);
    }

    @Async
    public void show() throws InterruptedException {
        List<Ticket> all = ticketRepository.findAll();
        System.out.println("AFTER READING T2:" + all);
        Thread.sleep(4000);
        List<Ticket> all2 = ticketRepository.findAll();
        System.out.println("AFTER READING T2:" + all2);
    }
}
