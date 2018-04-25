package se.lantmateriet.taco.voff;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VoffApplicationTests {

    @Inject HundRepository hundRepository;

    @Test
    public void contextLoads() {
        System.out.println("hundRepository = " + hundRepository);
    }

}
