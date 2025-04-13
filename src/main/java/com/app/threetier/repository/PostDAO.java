package com.app.threetier.repository;

import com.app.threetier.domain.PostVO;
import com.app.threetier.mapper.PostMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.crypto.spec.PSource;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class PostDAO {

    private final PostMapper postMapper;

//    게시글 전체조회
    public List<PostVO> findAll() {
        return postMapper.selectAll();
    }

//    게시글 단일 조회
    public Optional<PostVO> findById(Long id) {
        return postMapper.selectById(id);
    }

//    게시글 작성
    public void save(PostVO postVO) {
        postMapper.insert(postVO);
    }

    public void editById(PostVO postVO) {
        postMapper.update(postVO);
    }

    public void deleteById(Long id) { postMapper.delete(id); }

//    해당 유저의 게시글 전체 삭제
    public void deleteAllByMemberId(Long memberId) {
        postMapper.deleteAll(memberId);
    }
}
