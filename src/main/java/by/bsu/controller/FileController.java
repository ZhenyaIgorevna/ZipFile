package by.bsu.controller;

import by.bsu.entities.ProjectNode;
import by.bsu.entities.ProjectTree;
import by.bsu.exception.CreateException;
import by.bsu.exception.FileException;
import by.bsu.file.ReadZipFile;
import by.bsu.parser.ProjectParser;
import by.bsu.util.TraversalStrategy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.*;

import static by.bsu.constants.PageConstants.STRUCTURE;
import static by.bsu.controller.ControllerConstants.PROJECT_URI;

/**
 * Created by Yauheniya_Neliub on 1/28/2015.
 */
@Controller
public class FileController {

    @RequestMapping(value = PROJECT_URI)
    public String viewProject(Map<String, Object> model, HttpSession session) {
        String zipfilename = "archive.zip";
        ReadZipFile reader = new ReadZipFile();
        try {
            LinkedList<String> listName = reader.readArchive(zipfilename);
            ProjectTree tree = new ProjectParser().parse(listName);

            Iterator<ProjectNode> depthIterator = tree.iterator("archive", TraversalStrategy.DEPTH_FIRST);
            Map<String, String> nodeNames = new LinkedHashMap<>();
            ProjectTree sortTree = new ProjectTree();
            while (depthIterator.hasNext()) {
                ProjectNode node = depthIterator.next();
                sortTree.addNode(node.getFilename(), node.getEntitiesName(), node.getParent() != null ? node.getParent().getFilename() : "root");
                nodeNames.put(node.getFilename(), node.getParent() != null ? node.getParent().getFilename() : "root");
            }
            //model.put("projectTree",tree);
            //model.put("nodeNames", nodeNames);
            session.setAttribute("projectTree",tree);
            session.setAttribute("nodeNames", nodeNames);
        } catch (FileException | CreateException e) {
            e.printStackTrace();
        }
        return STRUCTURE;
    }

    @RequestMapping(value = "/file")
    public String viewFile(@RequestParam String filename, Map<String, Object> model) {
        ReadZipFile reader = new ReadZipFile();
        try {
            String fileContext = reader.readFile("archive.zip",filename);
            //List<String> fileContext = reader.readFileList("archive.zip",filename);
            System.out.println(fileContext);
            model.put("file",fileContext);
        } catch (FileException e) {
            e.printStackTrace();
        }
        return "viewFile";
    }
}
