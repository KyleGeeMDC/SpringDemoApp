package resultApp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.InjectionPoint;

import java.util.List;
import java.util.Map;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.PathSegment;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

@RestController
public class ResultController {


    @Autowired
    public ResultService resultService = new ResultService();

    @Context
    public UriInfo ui;

    @Bean
    @Scope("prototype")
    Logger logger(InjectionPoint injectionPoint){
        return LoggerFactory.getLogger(injectionPoint.getMethodParameter().getContainingClass());
    }

    private Logger logger;

    @Autowired
    public void setLogger(Logger logger) {
        this.logger = logger;
    }

    private String resultString;

    
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

    /*
    @RequestMapping("/result")
    public void getResult(RestTemplate restTemplate) throws Exception {
        logger.info("Now retrieving result...");
		Result result = restTemplate.getForObject( //full -> "https://rl003vo1kj.execute-api.us-east-1.amazonaws.com/devo?magenicKey=larryl&input=%26asdfasdfsa=fraggelrock%2limit=10%26offset=20%26sort=date_asc
				"https://rl003vo1kj.execute-api.us-east-1.amazonaws.com/devo?magenicKey=larryl", Result.class);
        resultString = result.toString();
        logger.info(resultString);
		resultService.addResult(result);
    }
    */

    @RequestMapping(method=RequestMethod.POST, value = "/params")
    public void getResultParams(RestTemplate restTemplate,
                                //@QueryParam("magenicKey") @DefaultValue("larryl") String magenicKey,
                                //@QueryParam(value = "asdfasdfsa") @DefaultValue("") String asdfasdfsa,
                                //@QueryParam("limit") @DefaultValue("") String limit,
                                //@QueryParam("offset") @DefaultValue("") String offset,
                                //@QueryParam("sort") @DefaultValue("") String sort,

                                @RequestParam(value="magenicKey", required=false, defaultValue="") String magenicKey,
                                @RequestParam(value="input", required=false, defaultValue="") String input,
                                @RequestParam(value="asdfasdfsa", required=false, defaultValue="") String asdfasdfsa,
                                @RequestParam(value="limit", required=false, defaultValue="") String limit,
                                @RequestParam(value="offset", required=false, defaultValue="") String offset,
                                @RequestParam(value="sort", required=false, defaultValue="") String sort
                                ) throws Exception {
        
        logger.info("Now retrieving result from query...");
        logger.info("MagenicKey: " + magenicKey);
        logger.info("Input: " + input);
        logger.info("asdfasdfsa: " + asdfasdfsa);
        logger.info("limit: " + limit);
        logger.info("offsest: " + offset);
        logger.info("sort: " + sort);

        String resultPath = "https://rl003vo1kj.execute-api.us-east-1.amazonaws.com/devo?magenicKey=" + magenicKey + "&input="+ input + "%26asdfasdfsa=" + asdfasdfsa + "%25limit=" + limit + "%26offset=" + offset + "%26sort=" + sort;


        logger.info("path: " + resultPath);

		Result result = restTemplate.getForObject(resultPath, Result.class);
        resultString = result.toString();
        logger.info(resultString);
		resultService.addResult(result);
    }

    @RequestMapping(method=RequestMethod.GET, value = "/params2")
    public void getResultParams(@Context UriInfo ui,
                                RestTemplate restTemplate
                                ) throws Exception {
          
        //ui = new uriInfo();                              
        MultivaluedMap<String, String> queryParams = ui.getQueryParameters();
        MultivaluedMap<String, String> pathParams = ui.getPathParameters();
        
        logger.info("Now retrieving result from query...");
        logger.info("MagenicKey: " + queryParams);
        logger.info("Input: " + pathParams);

        String resultPath = "https://rl003vo1kj.execute-api.us-east-1.amazonaws.com/devo?magenicKey=" + queryParams + "&input="+ pathParams ;


        logger.info("path: " + resultPath);

		Result result = restTemplate.getForObject(resultPath, Result.class);
        resultString = result.toString();
        logger.info(resultString);
		//resultService.addResult(result);
    }
}

