package owlcounter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OwlCounterMap {

    private final Map<String, Integer> dataMap = new HashMap<>();

    private void mapData(List<String> lines) {
        for (String line : lines) {
            String[] parts = line.split("=");
            dataMap.put(parts[0], Integer.parseInt(parts[1]));
        }
    }

    public void readFromFile(Path path) {
        List<String> dataSource;
        try {
            dataSource = Files.readAllLines(path);
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file.", ioe);
        }
        mapData(dataSource);
    }

    public int getNumberOfOwls(String county) {
        Integer numberOfOwls = dataMap.get(county);
        if (numberOfOwls == null) {
            throw new IllegalArgumentException("No such county in Hungary!");
        }
        return numberOfOwls;
    }

    public int getNumberOfAllOwls() {
        int numberOfAllOwls = 0;
        for (int value : dataMap.values()) {
            numberOfAllOwls += value;
        }
        return numberOfAllOwls;
    }
}
