package com.services.interfaces;

import java.util.List;

import com.entities.ExpComment;

public interface IExpCommentService {
	public ExpComment saveExpComment(ExpComment expComment);

	public List<ExpComment> findAll();

	public ExpComment findOne(Long id);

	public void deleteExpComment(Long id);
	
	public List<ExpComment> findByExperience(Long id);

}
