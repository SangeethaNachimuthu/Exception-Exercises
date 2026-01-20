package lexicon;

import javax.naming.NameNotFoundException;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class ListOperations {

    public void findNameInList(String findName) throws IOException, NameNotFoundException, DuplicateNameException {

        List<String> names = readNames();
        for (String s : names) {
            if (s.equalsIgnoreCase(findName)) {
                System.out.println("The name was found");
                return;
            }
        }
        addNameInList(findName);
        throw new NameNotFoundException("Name not found. It has been added to the list.");
    }

    public void addNameInList(String addName) throws IOException, DuplicateNameException {

        List<String> names = readNames();
        for (String s : names) {
            if (s.equalsIgnoreCase(addName)) {
                throw new DuplicateNameException("Duplicate Name: " + addName);
            }
        }

        BufferedWriter writer = null;
        try {
            writer = Files.newBufferedWriter(
                    Path.of("dir/names.txt"),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND);

            writer.append(addName);
            writer.append(",");
            System.out.println("Name added: " + addName);

            writer.flush();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> readNames() throws IOException {

        List<String> lines = Files.readAllLines(Path.of("dir/names.txt"));
        List<String> names = new ArrayList<>();

        boolean found = false;

        for (String line : lines) {
            for (String s : line.split(",")) {
                if (!s.trim().isEmpty()) {
                    names.add(s.trim());
                }
            }
        }
        return  names;
    }
}
