/*

package resultApp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;


import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ResultRepositoryTest {

    @Autowired
    private static ResultService resultService;

    private static Result testResult;
    

    @Test
    public void saveAndRetreiveResult() {
        testResult = new Result((long) 44, "test");
        Result foundResult;

        resultService.addResult(testResult);

        foundResult = resultService.getResultById((long) 44).get();
  
        assertNotNull(foundResult);
        assertEquals(foundResult, testResult);
    }
}


*/