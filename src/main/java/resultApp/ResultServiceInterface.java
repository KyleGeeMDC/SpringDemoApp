package resultApp;

import java.util.Optional;

public interface ResultServiceInterface{

    //final ResultRepository resultRepository;

    void addResult(Result result);

    Optional<Result> getResultById(Long id);
    
}