package com.adjecti.liferay.workarea.hierarchy.util;

import com.adjecti.liferay.workarea.hierarchy.modelview.Node;
import com.adjecti.mdm.liferay.model.WorkArea;
import com.adjecti.mdm.liferay.service.WorkAreaLocalServiceUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.spi.LocaleServiceProvider;

public class WorkAreaTreeNodes {
	public List<Node> getNodes() {
		List<Node> nodeList = new ArrayList<Node>();
		List<WorkArea> parentWorkAreas = WorkAreaLocalServiceUtil.getWorkAreasByParentId(0);
		List<Node> parentNodes = convertWorkAreaToNode(parentWorkAreas);
		for (Node parentNode : parentNodes) {
			if (parentNode.getHasChild()) {
				List<Node> childNodes = getChildNodes(parentNode.getId());
				parentNode.setChildren(childNodes);
			}
			nodeList.add(parentNode);
		}
		return nodeList;

	}

	public List<Node> getChildNodes(long parentId) {
		List<Node> childNodes = new ArrayList<Node>();
		List<WorkArea> childWorkAreas = WorkAreaLocalServiceUtil.getWorkAreasByParentId(parentId);
		List<Node> nodes = convertWorkAreaToNode(childWorkAreas);
		for (Node childNode : nodes) {
			if (childNode.getHasChild()) {
				childNode.setChildren(getChildNodes(childNode.getId()));
			}
			childNodes.add(childNode);
		}

		return childNodes;

	}

	public List<Node> convertWorkAreaToNode(List<WorkArea> workAreaList) {
		List<Node> nodes = new ArrayList<Node>();
		for (WorkArea workArea : workAreaList) {
			Node node = new Node();
			node.setId(workArea.getWorkAreaId());
			node.setLabel(workArea.getName());
			node.setParentId(workArea.getParentWorkAreaId());
			//node.setHasChild(WorkAreaLocalServiceUtil.);
			nodes.add(node);
		}
		return nodes;
	}
}
