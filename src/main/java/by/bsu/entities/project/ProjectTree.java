package by.bsu.entities.project;

import by.bsu.util.BreadthTreeIterator;
import by.bsu.util.DepthTreeIterator;
import by.bsu.util.TraversalStrategy;

import java.util.*;

/**
 * Created by Yauheniya_Neliub on 2/11/2015.
 */
public class ProjectTree {
    private HashMap<String, ProjectNode> nodes;
    private TraversalStrategy strategy;

    private final static int ROOT = 0;

    public ProjectTree() {
        nodes = new LinkedHashMap<>();
        strategy = TraversalStrategy.BREADTH_FIRST;
    }

    public HashMap<String, ProjectNode> getNodes() {
        return nodes;
    }

    public void setNodes(HashMap<String, ProjectNode> nodes) {
        this.nodes = nodes;
    }

    public ProjectNode addNode(String identifier, String nodeType) {
        ProjectNode node = new ProjectNode(identifier, nodeType);
        nodes.put(identifier, node);
        return node;
    }

    public ProjectNode addNode(String identifier, String nodeType, String parentName) {
        ProjectNode node = new ProjectNode(identifier, nodeType);
        nodes.put(identifier, node);

        if (parentName != null && !parentName.equals("root")) {
            ProjectNode parent = nodes.get(parentName);
            if (parent == null) {//Если нет родителя,  значит папка первого уровня в архиве и родитель ее сам архив
                System.out.println("Parent null with name "+parentName);
                System.out.println("Node: "+node);
            }
            node.setParent(parent);
            parent.addChild(node);
        }
        return node;
    }

    public Iterator<ProjectNode> iterator(String identifier, TraversalStrategy traversalStrategy) {
        return traversalStrategy == TraversalStrategy.BREADTH_FIRST ?
                new BreadthTreeIterator(nodes, identifier) :
                new DepthTreeIterator(nodes, identifier);
    }

    public Iterator<ProjectNode> iterator(String identifier) {
        return this.iterator(identifier, strategy);
    }

    public void display(String identifier) {
        this.display(identifier, ROOT);
    }

    public void display(String identifier, int depth) {
        List<ProjectNode> children = nodes.get(identifier).getChildren();

        if (depth == ROOT) {
            System.out.println(nodes.get(identifier).getFilename());
        } else {
            String tabs = String.format("%0" + depth + "d", 0).replace("0", "    "); // 4 spaces
            System.out.println(tabs + nodes.get(identifier).getFilename());
        }
        depth++;
        for (ProjectNode child : children) {

            // Recursive call
            this.display(child.getFilename(), depth);
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ProjectTree{");
        sb.append("nodes=[");
        for (String key : nodes.keySet()) {
            sb.append(" Node name: ").append(key);
            sb.append(" Node value: ").append(nodes.get(key));
            sb.append("\n\n");
        }
        sb.append("]}");
        return sb.toString();
    }
}
