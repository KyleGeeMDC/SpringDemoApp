/*
package resultApp;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.doNothing;

public class ResultServiceTest{

    @Autowired
	private MockMvc mockMvc;

	@MockBean
	private ResultService resultService;

	Result mockResult = new Result((long) 44, "true");

	String exampleResultJson = "{\"result\":\"true\"}";


	@Test
	public void createStudentCourse() throws Exception {
		Result mockResult = new Result((long) 50, "true");

		// studentService.addCourse to respond back with mockCourse
		Mockito.when(
            resultService.addResult(Mockito.anyString(),
						Mockito.any(Course.class))).thenReturn(mockCourse);

		// Send course as body to /students/Student1/courses
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/params/")
				.accept(MediaType.APPLICATION_JSON).content(exampleCourseJson)
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();
        
        verify(resultService, times(1)).exists(anyString());

	}

*/
}