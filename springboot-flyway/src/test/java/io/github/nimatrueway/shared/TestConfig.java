package io.github.nimatrueway.shared;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@TestPropertySource({"classpath:application.properties", "classpath:application-test.properties"})
@SpringBootTest()
public class TestConfig {

}