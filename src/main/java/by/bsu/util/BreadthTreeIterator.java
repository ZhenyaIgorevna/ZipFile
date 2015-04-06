package by.bsu.util;

import by.bsu.entities.project.ProjectNode;

import java.util.*;

/**
 * Created by Yauheniya_Neliub on 2/12/2015.
 */
public class BreadthTreeIterator implements Iterator<ProjectNode> {
    private static final int ROOT = 0;

    private LinkedList<ProjectNode> list;
    private HashMap<Integer, ArrayList<String>> levels;

    public BreadthTreeIterator(HashMap<String, ProjectNode> tree, String identifier) {
        list = new LinkedList<ProjectNode>();
        levels = new HashMap<Integer, ArrayList<String>>();

        if (tree.containsKey(identifier)) {
            this.buildList(tree, identifier, ROOT);

            for (Map.Entry<Integer, ArrayList<String>> entry : levels.entrySet()) {
                for (String child : entry.getValue()) {
                    list.add(tree.get(child));
                }
            }
        }
    }

    private void buildList(HashMap<String, ProjectNode> tree, String identifier, int level) {
        if (level == ROOT) {
            list.add(tree.get(identifier));
        }

        List<ProjectNode> children = tree.get(identifier).getChildren();

        if (!levels.containsKey(level)) {
            levels.put(level, new ArrayList<String>());
        }
        for (ProjectNode child : children) {
            levels.get(level).add(child.getFilename());

            // Recursive call
            this.buildList(tree, child.getFilename(), level + 1);
        }
    }

    @Override
    public boolean hasNext() {
        return !list.isEmpty();
    }

    @Override
    public ProjectNode next() {
        return list.poll();
    }
}
