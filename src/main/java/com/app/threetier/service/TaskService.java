package com.app.threetier.service;

import com.app.threetier.domain.ProductVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TaskService {
    public void addProduct(ProductVO productVO);

    public List<ProductVO> findAllProduct();
}
