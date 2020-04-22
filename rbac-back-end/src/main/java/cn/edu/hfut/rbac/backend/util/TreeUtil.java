package cn.edu.hfut.rbac.backend.util;

import cn.edu.hfut.rbac.backend.util.bean.TreeNode;
import cn.edu.hfut.rbac.backend.util.bean.Treeable;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xuewenG
 * @date 2019/8/22 17:26
 */
public class TreeUtil {

    /**
     * @author xuewenG
     * @date 2019/8/22 17:26
     * 将列表 originList 中的元素转换成树节点，List中的元素必须实现 Treeable 接口
     */
    public static List<TreeNode> toTreeNodeList(List<? extends Treeable> originList) {
        List<TreeNode> nodeList = new ArrayList<>();
        if (originList == null) {
            return nodeList;
        }
        originList.forEach(item -> {
            TreeNode treeNode = new TreeNode();
            String nodeId = item.getNodeId();
            String parentId = item.getParentNodeId();
            treeNode.setNodeId(nodeId);
            treeNode.setParentId(parentId);
            treeNode.setNodeData(item);
            nodeList.add(treeNode);
        });
        return nodeList;
    }

    /**
     * @author xuewenG
     * @date 2019/8/22 18:07
     * 将 nodeList 中的节点构造成以一棵树
     */
    public static TreeNode buildTree(List<TreeNode> nodeList) {
        TreeNode root = new TreeNode();
        root.setNodeId(TreeNode.ROOT_NODE_ID);
        root.setParentId(TreeNode.ROOT_NODE_ID);
        root.setNodeData(null);
        if (nodeList == null) {
            return root;
        }
        nodeList.forEach(node -> {
            String parentId = node.getParentId();
            if (parentId == null || parentId.equals(TreeNode.ROOT_NODE_ID)) {
                root.getChildren().add(node);
                return;
            }
            for (TreeNode current : nodeList) {
                String currentId = current.getNodeId();
                if (currentId != null && currentId.equals(parentId)) {
                    current.getChildren().add(node);
                    return;
                }
            }
        });
        return root;
    }
}
