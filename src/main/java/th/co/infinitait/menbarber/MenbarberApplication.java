package th.co.infinitait.menbarber;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

@SpringBootApplication
public class MenbarberApplication {

	public static void main(String[] args) {
		SpringApplication.run(MenbarberApplication.class, args);
	}

//	@Bean
//	public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
//		ObjectMapper mapper = new ObjectMapper();
//		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
//		return new MappingJackson2HttpMessageConverter(mapper);
//	}
}
