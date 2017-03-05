package io.github.nimatrueway;

import io.github.nimatrueway.shared.H2ServerBuilder;
import io.github.nimatrueway.shared.TestConfig;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class MainSpec extends TestConfig {

  private MockMvc mockMvc;

  @Autowired
  private WebApplicationContext context;

  @Before
  public void setup() {
    mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
  }

  @Test
  public void nimaLoginCountTest() throws Exception {
    H2ServerBuilder.start();
    mockMvc
      .perform(get("/nimaLoginCount"))
      .andExpect(status().isOk())
      .andExpect(content().string("5"));
  }


}
