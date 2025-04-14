package com.app.threetier.mapper;

import com.app.threetier.domain.ProductVO;
import com.app.threetier.service.TaskService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
public class TaskMapperTest {
    @Autowired
    private TaskService taskService;

    @Test
    public void selectAllTest() {
        List<ProductVO> products = taskService.findAllProduct();
        products.stream().map(ProductVO::toString).forEach(log::info);
    }
}
