package com.tenco.blog.repository.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.tenco.blog.repository.model.Post;

@Mapper
public interface PostRepository {

	public int insert(Post post);

	public int updateById(Post post);

	public int deleteById(Integer id);

	List<Post> readAllPosts(@Param("limit") int limit, @Param("offset") int offset);

	public int countAll();

}
