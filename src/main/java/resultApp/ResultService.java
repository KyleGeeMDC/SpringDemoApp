package resultApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResultService {
    
    @Autowired
    private ResultRepository resultRepository;

    public void addResult(Result result){
        resultRepository.save(result);
    }
    

}