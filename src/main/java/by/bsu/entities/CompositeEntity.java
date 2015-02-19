package by.bsu.entities;

import java.util.List;

/**
 * Created by Yauheniya_Neliub on 2/9/2015.
 */
public class CompositeEntity extends ProjectPart{
    private String name;
    private List<ProjectPart> children;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setChildren(List<ProjectPart> children) {
        this.children = children;
    }

    @Override
    public List<ProjectPart> getChildren() {
        return children;
    }

    public void addChildren(ProjectPart child){
        children.add(child);
    }

    public void removeChildren(ProjectPart child){
        children.remove(child);
    }
}
