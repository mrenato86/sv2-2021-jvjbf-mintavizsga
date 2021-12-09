package owlcounter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class OwlCounter {

    private List<String> dataLines;

    public void readFromFile(Path path) {
        try {
            dataLines = Files.readAllLines(path);
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file.", ioe);
        }
    }

    public int getNumberOfOwls(String county) {
        if (county == null || dataLines == null) {
            throw new IllegalArgumentException("Cannot search in wrong datasource or input!");
        }
        for (String line : dataLines) {
            String[] parts = line.split("=");
            if (parts[0].equalsIgnoreCase(county)) {
                return Integer.parseInt(parts[1]);
            }
        }
        throw new IllegalArgumentException("No such county in Hungary!");
    }

    public int getNumberOfAllOwls() {
        if (dataLines == null) {
            throw new IllegalArgumentException("Cannot search in wrong datasource!");
        }
        int numberOfAllOwls = 0;
        for (String line : dataLines) {
            String[] parts = line.split("=");
            numberOfAllOwls += Integer.parseInt(parts[1]);
        }
        return numberOfAllOwls;
    }
}
