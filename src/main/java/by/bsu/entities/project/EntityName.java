package by.bsu.entities.project;

/**
 * Created by Yauheniya_Neliub on 2/11/2015.
 */
public enum EntityName {
    PROJECT("project"),
    FOLDER("folder"),
    JAVA_FILE("javaFile"),
    XML_FILE("xmlFile"),
    JS_FILE("jsFile"),
    IMAGE("image"),
    JSP_FILE("jspFile"),
    CSS_FILE("cssFIle"),
    PROPERTIES_FILE("properties");

    private final String value;

    EntityName(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
