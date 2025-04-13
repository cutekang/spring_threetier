package com.app.threetier.repository;

import com.app.threetier.domain.ProductVO;
import com.app.threetier.mapper.TaskMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class TaskDAO {
    private final TaskMapper taskMapper;

    public void insert(ProductVO productVO) {
        taskMapper.insert(productVO);
    }

    public List<ProductVO> findAll() {
        return taskMapper.selectAll();
    }
}
