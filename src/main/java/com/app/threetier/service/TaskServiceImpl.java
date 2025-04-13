package com.app.threetier.service;

import com.app.threetier.domain.ProductVO;
import com.app.threetier.mapper.TaskMapper;
import com.app.threetier.repository.TaskDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskDAO taskDAO;

    @Override
    public void addProduct(ProductVO productVO) {
        taskDAO.insert(productVO);
    }

    @Override
    public List<ProductVO> findAllProduct() {
        return taskDAO.findAll();
    }
}
