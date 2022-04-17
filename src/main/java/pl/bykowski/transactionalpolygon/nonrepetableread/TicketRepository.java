package pl.bykowski.transactionalpolygon.nonrepetableread;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("RepositoryNonRepeatableRead")
public interface TicketRepository extends JpaRepository<Ticket,Long> {
}
