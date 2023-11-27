package com.adjecti.mdm.liferay.dto;

public class PostDTO {
	private long postId;
	private String code;
	private String name_En;
	private String name_Hi;
	private long designationId;
	private boolean postBox;
	private String description;
	private long[] organizationIds;
	
	
	public long getPostId() {
		return postId;
	}
	public void setPostId(long postId) {
		this.postId = postId;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName_En() {
		return name_En;
	}
	public void setName_En(String name_En) {
		this.name_En = name_En;
	}
	public String getName_Hi() {
		return name_Hi;
	}
	public void setName_Hi(String name_Hi) {
		this.name_Hi = name_Hi;
	}
	public long getDesignationId() {
		return designationId;
	}
	public void setDesignationId(long designationId) {
		this.designationId = designationId;
	}
	public boolean isPostBox() {
		return postBox;
	}
	public void setPostBox(boolean postBox) {
		this.postBox = postBox;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public long[] getOrganizationIds() {
		return organizationIds;
	}
	public void setOrganizationIds(long[] organizationIds) {
		this.organizationIds = organizationIds;
	}
 	
}
