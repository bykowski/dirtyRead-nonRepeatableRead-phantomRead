package pl.bykowski.transactionalpolygon.nonrepetableread;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service("TicketServiceNonRepeatableRead")
@Transactional(isolation = Isolation.DEFAULT) // Isolation.REPEATABLE_READ == Isolation.DEFAULT
public class TicketService {

    private final TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
        save();
    }

    public void save() {
        Ticket ticketToNorway = new Ticket();
        ticketToNorway.setTicketName("to Norway");
        ticketRepository.save(ticketToNorway);

        Ticket ticketToFrance = new Ticket();
        ticketToFrance.setTicketName("to Canada");
        ticketRepository.save(ticketToFrance);
    }

    @Async
    public void update() throws InterruptedException {
        Ticket ticketById = ticketRepository.findById(1L).get();
        ticketById.setTicketName("to USA");
        Thread.sleep(2000);
        ticketRepository.save(ticketById);
        // checking
        Ticket newTicketValue = ticketRepository.findById(1L).get();
        System.out.println("AFTER UPDATE T2: " + newTicketValue);
    }

    @Async
    public void show() throws InterruptedException {
        Ticket ticketById = ticketRepository.findById(1L).get();
        System.out.println("AFTER READING T1:" + ticketById);
        Thread.sleep(5000);
        Ticket ticketById2 = ticketRepository.findById(1L).get();;
        System.out.println("AFTER UPDATE T1:" + ticketById2);
    }
}
