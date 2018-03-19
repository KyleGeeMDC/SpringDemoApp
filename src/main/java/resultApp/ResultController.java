package resultApp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ResultController {
    
    private static final Logger log = LoggerFactory.getLogger(Application.class);

    private String resultString;

    @Autowired
    public ResultService resultService = new ResultService();
    
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

    @RequestMapping("/get")
    public void getResult(RestTemplate restTemplate) throws Exception {
        log.info("Now retrieving result...");
		Result result = restTemplate.getForObject( //full -> "https://rl003vo1kj.execute-api.us-east-1.amazonaws.com/devo?magenicKey=larryl&input=%26asdfasdfsa=fraggelrock%2limit=10%26offset=20%26sort=date_asc
				"https://rl003vo1kj.execute-api.us-east-1.amazonaws.com/devo?magenicKey=larryl", Result.class);
        resultString = result.toString();
        log.info(resultString);
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

