package kr.hoseo.kobis.example;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestDemoApplicationTests {

	@Test
	public void contextLoads() throws Exception {
		RestTemplate restTemplate = new RestTemplate();
		
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString("http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json")
				.queryParam("key", "430156241533f1d058c603178cc3ca0e")
				.queryParam("targetDt", "20180608")
				.queryParam("itemPerPage", "20");
		
		ResponseEntity<String> response = restTemplate.getForEntity(builder.build().toUri(), String.class);
		
		ObjectMapper mapper = new ObjectMapper();
		JsonNode root = mapper.readTree(response.getBody());
		root.path("boxOfficeResult").path("dailyBoxOfficeList").elements().forEachRemaining(item -> {
			BoxOfficeMovie bom = mapper.convertValue(item, BoxOfficeMovie.class);
			System.out.println(bom);
		});
		
		//assertThat(name.asText(), notNullValue());
		
	}

}
