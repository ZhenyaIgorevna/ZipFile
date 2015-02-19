package by.bsu.util;

import by.bsu.entities.ProjectNode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Yauheniya_Neliub on 2/12/2015.
 */
public class DepthTreeIterator implements Iterator<ProjectNode> {
    private LinkedList<ProjectNode> list;

    public DepthTreeIterator(HashMap<String, ProjectNode> tree, String identifier){
        list = new LinkedList<>();

        if (tree.containsKey(identifier)) {
            this.buildList(tree, identifier);
        }

    }

    private void buildList(HashMap<String, ProjectNode> tree, String identifier) {
        list.add(tree.get(identifier));
        List<ProjectNode> children =  tree.get(identifier).getChildren();
        for (ProjectNode child : children) {
            // Recursive call
            this.buildList(tree, child.getFilename());
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
