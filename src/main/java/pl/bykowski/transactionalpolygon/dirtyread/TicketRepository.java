package pl.bykowski.transactionalpolygon.dirtyread;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("TicketRepositoryTicketServiceDirtyRead")
public interface TicketRepository extends JpaRepository<Ticket,Long> {

}
