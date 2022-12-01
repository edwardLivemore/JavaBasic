package com.example.java_basic.Others;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public class TreeTest {
    // Map(K: 节点id, V: 子节点名称集合)
    Map<String, Set<TreeNode>> map = new HashMap<>();

    private void tree() {
        // 构建数据
        List<String> data = new ArrayList<>();
        data.add("1.1");
        data.add("2.2");
        data.add("1");
        data.add("2");

        // 构建树
        buildTree(data);

        // 输出树
        output(null);
    }

    private void output(String pid) {
        Set<TreeNode> children = map.get(pid);
        if (children != null) {
            for (TreeNode node : children) {
                if (node != null) {
                    log.info("node: {}", node);
                    output(node.getId());
                }
            }
        }
    }

    private void buildTree(List<String> data) {
        // 创建根节点
        TreeNode root = new TreeNode(UUID.randomUUID().toString().replaceAll("-", ""), null, null, 0);
        addNode(root);

        // 遍历数据
        for (String d : data) {
            // 解析数据
            String[] nodes = d.split("\\.");
            // 从子往父遍历
            generateNode(nodes, nodes.length, root);
        }
    }

    private TreeNode generateNode(String[] nodes, int level, TreeNode root) {
        if (level == 0) {
            // 返回根节点
            return root;
        }
        TreeNode pNode = generateNode(nodes, level - 1, root);

        String name = nodes[level - 1];
        Set<TreeNode> childrenSet = map.getOrDefault(pNode.getId(), new HashSet<>());
        for (TreeNode node : childrenSet) {
            if (node.getName().equals(name)) {
                return node;
            }
        }

        // 生成节点
        TreeNode node = new TreeNode(UUID.randomUUID().toString().replaceAll("-", ""), pNode.getId(), name, level);
        // 添加节点
        addNode(node);
        return node;
    }

    /*
     * 添加树节点
     * */
    private void addNode(TreeNode node) {
        Set<TreeNode> childrenSet = map.getOrDefault(node.getPid(), new HashSet<>());
        childrenSet.add(node);
        map.put(node.getPid(), childrenSet);
    }

    public static void main(String[] args) {
        TreeTest test = new TreeTest();
        test.tree();
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    private static class TreeNode {
        // id
        private String id;
        // 父id
        private String pid;
        // 名称
        private String name;
        // 层级
        private Integer level;
    }
}
