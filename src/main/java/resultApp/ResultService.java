package resultApp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResultService implements ResultServiceInterface{
    
    @Autowired
    private ResultRepository resultRepository;

    public void addResult(Result result){
        resultRepository.save(result);
    }

    public Optional<Result> getResultById(Long id){
        return resultRepository.findById(id);
    }
}