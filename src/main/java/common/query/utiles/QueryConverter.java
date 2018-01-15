package common.query.utiles;

import org.apache.commons.io.FileUtils;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.SAXException;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class QueryConverter {

    private static String table_name = "dict";

    private static List<String> queries = new ArrayList<>();
    private static List<String> rows;

    /**
     * Replace idsForChange with newId and removes idsForChange from database.
     *
     * @param newId
     * @param idsToChange
     */
    public static void replacementQuerry(int newId, int[] idsToChange) {
        queries.add(String.format("update struct_cv_education set faculty_dict_id = " + newId + " " +
                "where faculty_dict_id in (" + Arrays.toString(idsToChange) + ");\n"));
        queries.add(String.format("update dict set local = 0 where id = " + newId + "\n"));
        queries.add(String.format("delete from " + table_name + " where id in " +
                "(" + Arrays.toString(idsToChange) + ");\n\n"));
    }

    public static void removalQuery(int[] idsToRemove) {
        queries.add(String.format("delete from " + table_name + " where id in " +
                "(" + Arrays.toString(idsToRemove) + ");\n"));
    }

    public static void renameDescription(String newDescription, int id) {
        queries.add(String.format("update " + table_name + " set description = '" + newDescription + "'" + " where id = " + id + "\n"));
    }

    public static List FileToStringArray(String pathToFile) {
        rows = new ArrayList<>();
        try (Stream<String> stream = Files.lines(Paths.get(pathToFile), StandardCharsets.UTF_8)) {
            stream.forEach(s -> rows.add(s));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return rows;
    }

    public static String parseToPlainText(String out) throws IOException, SAXException, TikaException {
        BodyContentHandler handler = new BodyContentHandler();
        AutoDetectParser parser = new AutoDetectParser();
        Metadata metadata = new Metadata();

        StringBuilder sb = new StringBuilder();
        for (String s : queries) {
            sb.append(s.replaceAll("\\[", "").replaceAll("]", ""));

        }
        try (InputStream stream = new ByteArrayInputStream(sb.toString().getBytes())) {
            parser.parse(stream, handler, metadata);
            FileUtils.writeStringToFile(new File(out), handler.toString(), "UTF-8");
            return handler.toString();
        }
    }

}
