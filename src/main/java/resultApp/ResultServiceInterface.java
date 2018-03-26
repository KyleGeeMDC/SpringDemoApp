package resultApp;

import java.util.Optional;

public interface ResultServiceInterface{
    
    void addResult(Result result);

    Optional<Result> getResultById(Long id);
    
}