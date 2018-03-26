package resultApp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.InjectionPoint;

import javax.servlet.http.HttpServletRequest;
//import javax.ws.rs.container.ContainerRequestContext;
//import javax.ws.rs.core.MultivaluedMap;
//import javax.ws.rs.core.UriInfo;
//import javax.ws.rs.core.Context;
//import javax.ws.rs.core.MultivaluedMap;
//import javax.ws.rs.core.UriInfo;

@RestController
public class ResultController {

/*
    @Context
    public UriInfo ui(){
    };
*/
    @Autowired
    private final ResultService resultService = new ResultService();
    private final RestTemplate restTemplate = new RestTemplate();
    
    @Bean
    Logger logger(InjectionPoint injectionPoint){
        return LoggerFactory.getLogger(injectionPoint.getMethodParameter().getContainingClass());
    }

    private Logger logger;

    @Autowired
    public void setLogger(Logger logger) {
        this.logger = logger;
    }

	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

    @RequestMapping(method=RequestMethod.GET, value = "/params")
    public void getResultParams(//@Context UriInfo ui,
                                HttpServletRequest request
                                ) throws Exception {
                                    
        String queryParams = request.getQueryString();

        //MultivaluedMap<String, String> queryParams = ui.getQueryParameters();
        //MultivaluedMap<String, String> pathParams = ui.getPathParameters();

        logger.info(request.getRequestURL().toString()); 
        logger.info("Retrieving result fromget ResultParams with query: " + queryParams);

        String resultPath = "https://rl003vo1kj.execute-api.us-east-1.amazonaws.com/devo?" + queryParams ;

        logger.info("full path: " + resultPath);           

		Result result = restTemplate.getForObject(resultPath, Result.class);

        logger.info("result: " + result.toString());
        
        resultService.addResult(result);
    }
}

