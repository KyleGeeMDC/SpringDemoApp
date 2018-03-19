package resultApp;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ResultTest{
    
    @Autowired
    Result testResult;
    
    @Test
    public void createCourse() throws Exception {
        Result testResult = new Result( null, null);

        Long check = (long) 12;
        
        testResult.setId((long) 12);
        testResult.setResult("true");

        assertEquals(testResult.getId(), check);
        assertEquals(testResult.getResult(), "true");

    }

    @Test
    public void toStringTest() throws Exception {
        Result testResult = new Result((long) 13 , "true");

        assert(testResult.toString().equals("{result=true}"));
    }
}