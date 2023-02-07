package lk.ijse.spring.repo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.jupiter.api.Assertions.*;


@WebAppConfiguration//creat the testing context
@ContextConfiguration // add configuration for that context
@ExtendWith(SpringExtension.class) // integrate junit with Spring
class CustomerRepoTest {

    @Test
    void findByName() {

    }
}