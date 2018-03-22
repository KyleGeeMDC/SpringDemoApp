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

//import javax.ws.rs.DefaultValue;
//import javax.ws.rs.QueryParam;

@RestController
public class ResultController {


    @Autowired
    public ResultService resultService = new ResultService();

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
    
    //private static final Logger log = LoggerFactory.getLogger(Application.class);

    private String resultString;

    
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

    @RequestMapping("/result")
    public void getResult(RestTemplate restTemplate) throws Exception {
        //log.info("Now retrieving result...");
        logger.info("Now retrieving result...");
		Result result = restTemplate.getForObject( //full -> "https://rl003vo1kj.execute-api.us-east-1.amazonaws.com/devo?magenicKey=larryl&input=%26asdfasdfsa=fraggelrock%2limit=10%26offset=20%26sort=date_asc
				"https://rl003vo1kj.execute-api.us-east-1.amazonaws.com/devo?magenicKey=larryl", Result.class);
        resultString = result.toString();
        //log.info(resultString);
        logger.info(resultString);
		resultService.addResult(result);
    }
    
    @RequestMapping(method=RequestMethod.POST, value = "/params")
    public void getResultParams(RestTemplate restTemplate,
                                //@QueryParam("magenicKey") @DefaultValue("larryl") String magenicKey,
                                //@QueryParam(value = "asdfasdfsa") @DefaultValue("") String asdfasdfsa,
                                //@QueryParam("limit") @DefaultValue("") String limit,
                                //@QueryParam("offset") @DefaultValue("") String offset,
                                //@QueryParam("sort") @DefaultValue("") String sort

                                @RequestParam(value="magenicKey", required=false, defaultValue="larryl") String magenicKey,
                                @RequestParam(value="asdfasdfsa", required=false, defaultValue="") String asdfasdfsa,
                                @RequestParam(value="limit", required=false, defaultValue="") String limit,
                                @RequestParam(value="offset", required=false, defaultValue="") String offset,
                                @RequestParam(value="sort", required=false, defaultValue="") String sort
                                ) throws Exception {

        // log.info("Now retrieving result from query...");
        // log.info("MagenicKey: " + magenicKey);
        // log.info("asdfasdfsa: " + asdfasdfsa);
        // log.info("limit: " + limit);
        // log.info("offsest: " + offset);
        // log.info("sort: " + sort);
        
        logger.info("Now retrieving result from query...");
        logger.info("MagenicKey: " + magenicKey);
        logger.info("asdfasdfsa: " + asdfasdfsa);
        logger.info("limit: " + limit);
        logger.info("offsest: " + offset);
        logger.info("sort: " + sort);

        String resultPath = "https://rl003vo1kj.execute-api.us-east-1.amazonaws.com/devo?magenicKey=" + magenicKey + "&input=%26" + asdfasdfsa + "=fraggelrock%252limit=" + limit + "%26offset=" + offset + "%26sort=" + sort + "%20";

		Result result = restTemplate.getForObject(resultPath, Result.class);
        resultString = result.toString();
        //log.info();
        logger.info(resultString);
		resultService.addResult(result);
    }

    /*
    @RequestMapping("/get")
    public void getResult(RestTemplate restTemplate) throws Exception {
        log.info("Now retrieving result...");
		Result result = restTemplate.getForObject( //full -> "https://rl003vo1kj.execute-api.us-east-1.amazonaws.com/devo?magenicKey=larryl&input=%26asdfasdfsa=fraggelrock%2limit=10%26offset=20%26sort=date_asc
				"https://rl003vo1kj.execute-api.us-east-1.amazonaws.com/devo?magenicKey=larryl", Result.class);
        resultString = result.toString();
        log.info(resultString);
		resultService.addResult(result);

    */
}

