package th.co.infinitait.menbarber.controllers;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import th.co.infinitait.menbarber.model.CloudinaryRequest;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IndexControllerTest {

    @Autowired
    private IndexController indexController;

    @Test
    public void testIndex() {
//        assertEquals("SUCCESS", indexController.uploadDocs(CloudinaryRequest.builder().build()));
    }

}
