package by.bsu;

import by.bsu.entities.project.ProjectNode;
import by.bsu.entities.project.ProjectTree;
import by.bsu.exception.CreateException;
import by.bsu.exception.FileException;
import by.bsu.file.ReadZipFile;
import by.bsu.parser.ProjectParser;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by Yauheniya_Neliub on 1/23/2015.
 */
public class Main {
    public static void main(String[] args) {
        String zipfilename = "src.zip";
        String filename = "srcmain/java/by/nelyub/dao/CompaniesDao.java";
        try {
            ReadZipFile reader = new ReadZipFile();
            LinkedList<String> listName = reader.readArchive(zipfilename);
            //listName.addFirst(zipfilename.substring(0, zipfilename.lastIndexOf('.')));
            try {
                ProjectTree tree = new ProjectParser().parse(listName);
                System.out.println("++++++++++++++++++++++++++++++++++++++++");
                Iterator<ProjectNode> depthIterator = tree.iterator("src");

                while (depthIterator.hasNext()) {
                    ProjectNode node = depthIterator.next();
                    String parent = node.getParent() != null ? node.getParent().getFilename() : "root";
                    System.out.println("Node: " + node.getFilename() + ", parent: "+parent);
                }
            } catch (CreateException e) {
                e.printStackTrace();
            }
            /*for (int i = 0; i < listName.size(); i++) {
                System.out.println(i + ": " + listName.get(i));

            }*/

            String obj = listName.get(5);
            String otherObg = obj.substring(0, obj.length() - 1);
            System.out.println("Obj: " + obj + ", other: " + otherObg);
            String parent = otherObg.substring(0, otherObg.lastIndexOf('/'));

            System.out.println("Obj: " + obj + ", parent: " + parent);
            /*String fileText = reader.readFile(zipfilename, listName.get(50));
            System.out.println("+++++++++++++++++++++++++++++++++++");
            System.out.println(fileText);*/


            ProjectTree tree = new ProjectTree();
            tree.addNode("src", "folder");
            tree.addNode("src/folder", "folder", "src");
            // System.out.println(tree);
        } catch (FileException e) {
            e.printStackTrace();
        }
    }
}
