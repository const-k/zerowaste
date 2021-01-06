package com.zerowaste.service.posts;

import com.zerowaste.domain.posts.Posts;
import com.zerowaste.domain.posts.PostsRepository;
import com.zerowaste.web.dto.PostsResponseDto;
import com.zerowaste.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + id));
        
        return new PostsResponseDto(entity);
    }
}
