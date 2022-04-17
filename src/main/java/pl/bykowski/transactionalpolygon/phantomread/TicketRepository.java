package pl.bykowski.transactionalpolygon.phantomread;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("TicketRepositoryPhantomRead")
public interface TicketRepository extends JpaRepository<Ticket,Long> {
}
