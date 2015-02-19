package by.bsu.file;

import by.bsu.exception.FileException;

import java.io.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

/**
 * Created by Yauheniya_Neliub on 1/23/2015.
 */
public class ReadZipFile {
    private static final String DEFAULT_ENCODING = "UTF-8";

    /**
     * Read zip file and return list with name of entities in this archive(folder and file. folder name end with /)
     *
     * @param filename of reading archive
     * @return list with name of entities
     * @throws FileException if there is not such archive or it can't be read
     */
    public List<String> readArchiveOther(String filename) throws FileException {
        List<String> listName = new ArrayList<String>();
        try (ZipFile zipFile = new ZipFile(filename)) {
            Enumeration<? extends ZipEntry> entries = zipFile.entries();
            while (entries.hasMoreElements()) {
                ZipEntry entry = entries.nextElement();
                listName.add(entry.getName());
            }
        } catch (IOException e) {
            throw new FileException(e.getMessage(), e);
        }
        return listName;
    }

    /**
     * Делает то же самое что и прошлый методЮ, но с помощью другого класса.
     */
    public LinkedList<String> readArchive(String filename) throws FileException {
        LinkedList<String> listName = new LinkedList<>();
        try (ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(filename))) {
            ZipEntry entry;
            while ((entry = zipInputStream.getNextEntry()) != null) {
                listName.add(entry.getName());
            }
            listName.addFirst(filename.substring(0, filename.lastIndexOf('.')));
            return listName;
        } catch (IOException e) {
            throw new FileException(e.getMessage(), e);
        }
    }

    //Read file and return text from it.
    public List<String> readFileList(String archivename, String filename) throws FileException {
        List<String> listString = new ArrayList<>();
        try (ZipFile zipFile = new ZipFile(archivename)) {
            Enumeration<? extends ZipEntry> entries = zipFile.entries();
            while (entries.hasMoreElements()) {
                ZipEntry entry = entries.nextElement();
                String entryName = entry.getName();
                if (entryName.equals(filename)) {
                    try (InputStream stream = zipFile.getInputStream(entry)) {
                        BufferedReader br = new BufferedReader(new InputStreamReader(stream, DEFAULT_ENCODING));
                        String line;
                        while ((line = br.readLine()) != null) {
                            listString.add(line+"\n");
                        }
                        return listString;
                    }
                }
            }
            return listString;
        } catch (IOException e) {
            throw new FileException(e.getMessage(), e);
        }
    }

    //Read file and return text from it.
    public String readFile(String archivename, String filename) throws FileException {
        StringBuilder builder = new StringBuilder();
        try (ZipFile zipFile = new ZipFile(archivename)) {
            Enumeration<? extends ZipEntry> entries = zipFile.entries();
            while (entries.hasMoreElements()) {
                ZipEntry entry = entries.nextElement();
                String entryName = entry.getName();
                if (entryName.equals(filename)) {
                    try (InputStream stream = zipFile.getInputStream(entry)) {
                        BufferedReader br = new BufferedReader(new InputStreamReader(stream, DEFAULT_ENCODING));
                        String line;
                        while ((line = br.readLine()) != null) {
                            builder.append(line+"\n");
                        }
                    }
                }
            }
            return builder.toString();
        } catch (IOException e) {
            throw new FileException(e.getMessage(), e);
        }
    }

}
