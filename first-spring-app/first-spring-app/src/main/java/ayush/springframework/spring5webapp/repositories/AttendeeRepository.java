package ayush.springframework.spring5webapp.repositories;

import ayush.springframework.spring5webapp.model.Attendee;
import org.springframework.data.repository.CrudRepository;

public interface AttendeeRepository extends CrudRepository<Attendee,Long> {

}
