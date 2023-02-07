package lk.ijse.spring.service.impl;

import lk.ijse.spring.config.WebRootConfig;
import lk.ijse.spring.service.ItemService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@WebAppConfiguration//creat the testing context
@ContextConfiguration(classes = {WebRootConfig.class}) // add configuration for that context
@ExtendWith(SpringExtension.class) // integrate junit with Spring
@Transactional
class ItemServiceImplTest {

    @Autowired
    ItemService service;

    @Test
    void saveItem() {

    }
}