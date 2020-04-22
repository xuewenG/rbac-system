package cn.edu.hfut.rbac.backend.util.bean;

/**
 * @author xuewenG
 * @date 2019/8/22 23:00
 */
public interface Treeable {
    /**
     * 获取该节点的 ID
     *
     * @return 该节点的 ID
     * @author xuewenG
     * @date 2019/8/22 23:00
     */
    String getNodeId();

    /**
     * 获取该节点的父节点的 ID
     *
     * @return 该节点的父节点的 ID
     * @author xuewenG
     * @date 2019/8/22 23:00
     */
    String getParentNodeId();
}
