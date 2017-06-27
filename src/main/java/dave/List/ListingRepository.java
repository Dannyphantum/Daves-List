package dave.List;

import org.springframework.data.repository.CrudRepository;

import dave.List.StudentListings;

public interface ListingRepository extends CrudRepository<StudentListings, Long> {

}
