package com.adjecti.mdm.liferay.handler;

import com.adjecti.mdm.liferay.dto.PostDTO;
import com.adjecti.mdm.liferay.model.Post;
import com.liferay.portal.kernel.exception.PortalException;

public interface PostHandler {
	
	public Post addPost(PostDTO postDTO) throws PortalException;
	
	public void deletePost(long postId) throws PortalException;

	public Post updatePost(PostDTO postDTO) throws PortalException;


}
