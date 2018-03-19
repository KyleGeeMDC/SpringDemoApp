package resultApp;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultRepository extends CrudRepository<Result, String>{

	//void save(Boolean result);

	//void save(String result);

}