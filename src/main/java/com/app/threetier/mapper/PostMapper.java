package com.app.threetier.mapper;

import com.app.threetier.domain.PostVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface PostMapper {
    public List<PostVO> selectAll();

    public Optional<PostVO> selectById(Long id);

    public void insert(PostVO postVO);

    public void update(PostVO postVO);

    public void delete(Long id);

    public void deleteAll(Long memberId);


}
