package resultApp;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultRepository extends CrudRepository<Result, String>{

	Optional<Result> findById(String string);

	//void save(Boolean result);

	//void save(String result);

}