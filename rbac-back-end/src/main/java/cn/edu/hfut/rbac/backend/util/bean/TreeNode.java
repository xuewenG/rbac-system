package cn.edu.hfut.rbac.backend.util.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xuewenG
 * @date 2019/8/22 16:22
 */
public class TreeNode {
    public static final String ROOT_NODE_ID = "0";
    private String nodeId;
    private String parentId;
    private List<TreeNode> children;
    private Treeable nodeData;

    public TreeNode() {
        this.children = new ArrayList<>();
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<TreeNode> children) {
        this.children = children;
    }

    public Treeable getNodeData() {
        return nodeData;
    }

    public void setNodeData(Treeable nodeData) {
        this.nodeData = nodeData;
    }
}
