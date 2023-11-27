package com.adjecti.liferay.workarea.hierarchy.modelview;

import java.util.List;

public class Node {
	private Long id;
	private String label;
	private Long parentId;
	private Boolean hasChild;
	private List<Node> children;
	public Node() {}
	public Node(Long id, String label, Long parentId, Boolean hasChild, List<Node> children) {
		super();
		this.id = id;
		this.label = label;
		this.parentId = parentId;
		this.hasChild = hasChild;
		this.children = children;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public Boolean getHasChild() {
		return hasChild;
	}

	public void setHasChild(Boolean hasChild) {
		this.hasChild = hasChild;
	}

	public List<Node> getChildren() {
		return children;
	}

	public void setChildren(List<Node> children) {
		this.children = children;
	}

}
