package by.bsu.parser;

import by.bsu.entities.EntityName;
import by.bsu.entities.ProjectTree;
import by.bsu.exception.CreateException;

import java.util.LinkedList;

/**
 * Created by Yauheniya_Neliub on 2/9/2015.
 */
public class ProjectParser {

    public ProjectTree parse(LinkedList<String> listName) throws CreateException {
        ProjectTree tree = new ProjectTree();
        //Add root
        String projectName = listName.getFirst();
        tree.addNode(projectName, EntityName.PROJECT.getValue());
        for (int i = 1; i < listName.size(); i++) {
            String name = listName.get(i);
            EntityName entityName;
            if (name.endsWith("/")) {
                entityName = EntityName.FOLDER;
            } else {
                if (name.endsWith(".java")) {
                    entityName = EntityName.JAVA_FILE;
                } else if (name.endsWith(".xml")) {
                    entityName = EntityName.XML_FILE;
                } else if (name.endsWith(".js")) {
                    entityName = EntityName.JS_FILE;
                } else if (name.endsWith(".jpg")) {
                    entityName = EntityName.IMAGE;
                } else if (name.endsWith(".jsp")) {
                    entityName = EntityName.JSP_FILE;
                } else if (name.endsWith(".css")) {
                    entityName = EntityName.CSS_FILE;
                } else if (name.endsWith(".properties")) {
                    entityName = EntityName.PROPERTIES_FILE;
                } else {
                    entityName = EntityName.PROJECT;
                }
            }
            String parent = getParent(name, entityName);
            if(!listName.contains(parent)){
                parent = listName.getFirst();
            }
            tree.addNode(name, entityName.getValue(), parent);
        }
        return tree;
    }

    public String getParent(String object, EntityName entityName) {
        if (entityName == EntityName.FOLDER) {
            object = object.substring(0, object.length() - 1);
        }
        if(object.contains("/")) {
            StringBuilder parent = new StringBuilder(object.substring(0, object.lastIndexOf('/') + 1));
            return parent.toString();
        }else{
            return object;
        }
    }
}
