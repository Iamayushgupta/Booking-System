package ayush.springframework.spring5webapp.repositories;

import ayush.springframework.spring5webapp.model.Event;
import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository<Event, Long> {
}
