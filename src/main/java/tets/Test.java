package tets;

/**
 * Created by Yauheniya_Neliub on 2/12/2015.
 */
public class Test {
    public static void main(String[] args) {
        String parent = new String("src/");
        String children =  new String("src/main/");
        String chile = children.replace(parent, "");
        System.out.println("Children: "+children);
        System.out.println("Parent: "+parent);
        System.out.println("Child: "+chile);
    }
}
