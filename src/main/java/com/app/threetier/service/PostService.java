package com.app.threetier.service;

import com.app.threetier.domain.PostVO;

import java.util.List;
import java.util.Optional;

public interface PostService {
//    게시글 전체조회
    public List<PostVO> getList();

//    게시글 단일 조회
    public Optional<PostVO> getPostById(Long id);

//    게시글 작성
    public void write(PostVO postVO);

    public void edit(PostVO postVO);

    public void delete(Long id);

//    게시글 전체 삭제
    public void deleteAll(Long memberId);
}
