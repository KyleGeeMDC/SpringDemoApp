package resultApp;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.containsString;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
//@WebMvcTest(ResultController.class)
public class ResultTest{
    
    //private static AnnotationConfigApplicationContext context;

    
    //Result testResult;
    
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ResultService service;

    //ResultController resultController = new ResultController();
 
    @BeforeClass
    public static void setUp(){
        //context = new AnnotationConfigApplicationContext();
        

        //context.scan("resultApp");
        //context.refresh();
    }

    @Test
    public void createResult() throws Exception {
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

   /* 
    @Test
    public void getResultFromService() throws Exception {
        Result temp = new Result((long) 2, "hi");
        RestTemplate temp = new RestTemplate();

        when(service.addResult()).thenReturn();
        this.mockMvc.perform(resultController.getResultParams(temp, "kyleg", "testing", "5", "4", "asc"));

        this.mockMvc.perform(resultController.getResultParams(temp, "kyleg" , "test", "5", "10", "asc")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello Mock")));
    }
*/
    //@Test
    public void shouldReturnDefaultMessage() throws Exception {
        
        this.mockMvc.perform(get("/result"))
                //.andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("true")));
    }






}