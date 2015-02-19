package by.bsu.entities;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yauheniya_Neliub on 2/9/2015.
 */
public class ProjectNode{

    //Папка или файл. Сделать наверно enum
    private String entitiesName;
    //имя файла или имя папки
    private String filename;

    private List<ProjectNode> children;

    //tRy add parent
    protected ProjectNode parent;

    public ProjectNode() {
    }

    public ProjectNode(String filename,String entitiesName){
        this.entitiesName = entitiesName;
        this.filename = filename;
        children = new ArrayList<>();
    }

    public ProjectNode(String filename,String entitiesName, ProjectNode parent) {
        this.entitiesName = entitiesName;
        this.filename = filename;
        children = new ArrayList<>();
        this.parent = parent;
    }

    public ProjectNode getParent() {
        return parent;
    }

    public void setParent(ProjectNode parent) {
        this.parent = parent;
    }

    public String getEntitiesName() {
        return entitiesName;
    }

    public void setEntitiesName(String entitiesName) {
        this.entitiesName = entitiesName;
    }

    public List<ProjectNode> getChildren() {
        return children;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public void setChildren(List<ProjectNode> children) {
        this.children = children;
    }

    public void addChild(ProjectNode child){
        children.add(child);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ProjectNode{");
        sb.append("entitiesName='").append(entitiesName).append('\'');
        sb.append(", filename='").append(filename).append('\'');
        sb.append(", children=").append(children);
        sb.append('}').append("\n");
        return sb.toString();
    }
}
