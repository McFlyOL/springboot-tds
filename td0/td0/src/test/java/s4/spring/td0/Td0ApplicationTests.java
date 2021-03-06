package s4.spring.td0;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

@SpringBootTest
class Td0ApplicationTests {
	@Autowired
	private MockMvc mvc;

	@Test
	void contextLoads() {
	}
	
	public void loadHello() throws Exception
	{
		ResultActions resultActions=mvc.perform(get("/hello").contentType(MediaType.TEXT_PLAIN));
		resultActions.andExpect(status().isOk()).andExpect(content().string("Hello World!"));
	}

}
