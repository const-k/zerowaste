package com.zerowaste.domain.posts;

import org.aspectj.lang.annotation.After;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PostLoad;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class PostsRepositoryTest {
    @Autowired
    PostsRepository postsRepository;

    @Test
    public void 게시글저장_불러오기() {
        //given
        String title = "테스트 게시글";
        String content = "테스트 본문";
        String author = "sskim";
        postsRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build());
        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts post = postsList.get(0);
        assertEquals(post.getTitle(), title);
        assertEquals(post.getContent(), content);
        assertEquals(post.getAuthor(), author);
    }
}