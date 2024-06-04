package com.demo.travelcardsystem;

import com.demo.travelcardsystem.config.TravelCardSystemApplication;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {TravelCardSystemApplication.class})
@AutoConfigureMockMvc
public abstract class IntegrationTest {
}
