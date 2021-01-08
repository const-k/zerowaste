package com.zerowaste.service.posts;

import com.zerowaste.domain.posts.Posts;
import com.zerowaste.domain.posts.PostsRepository;
import com.zerowaste.web.dto.PostsListReponseDto;
import com.zerowaste.web.dto.PostsResponseDto;
import com.zerowaste.web.dto.PostsSaveRequestDto;
import com.zerowaste.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Transactional
@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + id));
        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    @Transactional(readOnly = true)
    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + id));

        return new PostsResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<PostsListReponseDto> findAllDesc() {
        return postsRepository.findAllDesc().stream()
                .map(PostsListReponseDto::new)
                .collect(Collectors.toList());
    }

    public void delete(Long id) {
        Posts post = postsRepository.findById(id).orElseThrow(() -> new IllegalStateException("해당 게시글이 없습니다. id = " + id));
        postsRepository.delete(post);
    }
}
