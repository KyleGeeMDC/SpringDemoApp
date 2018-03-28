package resultApp;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.Mockito.*;
import java.util.Optional;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import static org.mockito.Mockito.when;
import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
//@WebMvcTest(value = ResultController.class, secure = false)
@SpringBootTest
public class ResultControllerTest{
    
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ResultService resultService;

    Result mockResult = new Result((long) 22, "true");
    
    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void addResultTest() {
        ResultService resultService = mock(ResultService.class);

        doNothing().when(resultService).addResult(mockResult);
        resultService.addResult(mockResult);
        
        verify(resultService).addResult(any(Result.class));
        verify(resultService, times(1)).addResult(mockResult);
    
    }

    @Test
    public void getResultRestTest() throws Exception{
        ResultService resultService = mock(ResultService.class);
        //Result result = new Result((long) 52, "true");

        when(resultService.getResultById((long) 22)).thenReturn(Optional.of(mockResult));

        this.mockMvc.perform(get("/params/{id}", 22)).andExpect(status().isOk()).andExpect(jsonPath("$id", is(22)));
    }
}