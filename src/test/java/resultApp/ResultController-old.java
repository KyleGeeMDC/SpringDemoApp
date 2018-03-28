/*

package resultApp;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.containsString;


public class ResultController {
  
    private static AnnotationConfigApplicationContext context;
    private static ResultService resultService;
    private static ResultController resultController;

    @Autowired
    private MockMvc mockMvc;
 
    @BeforeClass
    public static void setUp(){
        context = new AnnotationConfigApplicationContext();
        

        context.scan("resultApp");
        context.refresh();

        resultService = (ResultService) context.getBean("resultService");
        resultController = (ResultController) context.getBean("courseController");
    }
    
    @Test
    public void saveAndGetResult() throws Exception {
        Result result = new Result((long) 22, "test");
        resultController.getResultParams();
        Optional<Result> foundResult = resultService.getResultById((long) 22);
        foundResult.get();

        assertEquals(foundResult.get().getResult(), "test");  
} 

    @Test
    public void shouldReturnDefaultMessage() throws Exception {
        this.mockMvc.perform(get("https://rl003vo1kj.execute-api.us-east-1.amazonaws.com/devo?magenicKey=larryl")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("true")));
    }

}

*/