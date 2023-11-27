package com.adjecti.mdm.liferay.handler;

import com.adjecti.mdm.liferay.dto.PostDTO;
import com.adjecti.mdm.liferay.model.Post;
import com.adjecti.mdm.liferay.service.PostLocalServiceUtil;
import com.adjecti.mdm.liferay.service.PostOrganizationLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;

import org.osgi.service.component.annotations.Component;

@Component
public class PostHandlerImpl implements PostHandler {

	
	@Override
	public Post addPost(PostDTO postDTO) throws PortalException {		
		Post post = PostLocalServiceUtil.addPost(postDTO.getCode(),postDTO.getName_En(),postDTO.getName_Hi(),postDTO.getDesignationId(),postDTO.isPostBox(),postDTO.getDescription());		
		if(postDTO.getOrganizationIds().length != 0)
		{	
			for (long organizationId : postDTO.getOrganizationIds()) {
				PostOrganizationLocalServiceUtil.addPostOrganization(post.getPostId(),organizationId,post.getPostBox());
			}
		}
		
		return post;
	}

	@Override
	public void deletePost(long postId) throws PortalException {
		PostLocalServiceUtil.deletePostById(postId);
		PostOrganizationLocalServiceUtil.deletePostOrganizationByPostId(postId); 
	}

	@Override
	public Post updatePost(PostDTO postDTO) throws PortalException {
		Post post = PostLocalServiceUtil.updatePostData(postDTO.getPostId(),postDTO.getCode(),postDTO.getName_En(),postDTO.getName_Hi(),postDTO.getDesignationId(),postDTO.isPostBox(),postDTO.getDescription());
			PostOrganizationLocalServiceUtil.updatePostOrganization(post.getPostId(),postDTO.getOrganizationIds(),post.getPostBox());
		return post;
	}

}
