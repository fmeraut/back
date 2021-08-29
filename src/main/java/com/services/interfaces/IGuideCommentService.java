package com.services.interfaces;

import java.util.List;


import com.entities.GuideComment;

public interface IGuideCommentService {
	public GuideComment saveGuideComment(GuideComment guideComment);

	public List<GuideComment> findAll();

	public GuideComment findOne(Long id);

	public void deleteGuideComment(Long id);
	
	public List<GuideComment> findByGuideBis(Long id);

}
