package ui.map;

import core.map.tiles.AbstractMapTile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapLoader {

    public List<List<AbstractMapTile>> getMapTiles(String file) {

        List<String> mapStrings = extractMapString(file);


        List<List<String>> tilesString = extractTileString(mapStrings);

        return constructTilesFromString(tilesString);

    }

    private List<String> extractMapString(String file) {
        InputStream inputStream = ClassLoader.getSystemClassLoader()
                .getResourceAsStream(file);
        List<String> mapStrings;

        try {
            mapStrings = readFromInputStream(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return mapStrings;
    }

    private List<List<String>> extractTileString(List<String> mapStrings) {
        return mapStrings.stream()
                .map(line -> Arrays.asList(line.split("")))
                .collect(Collectors.toList());
    }

    private List<List<AbstractMapTile>> constructTilesFromString(
            List<List<String>> tilesString
    ) {
        List<List<AbstractMapTile>> mapTiles = new ArrayList<>();

        tilesString.forEach(line -> {
            List<AbstractMapTile> tempTiles = new ArrayList<>();
            line.forEach(element -> tempTiles.add(
                    MapAdapter.toMapTile(element)
            ));
            mapTiles.add(tempTiles);
        });

        return mapTiles;
    }

    private List<String> readFromInputStream(InputStream inputStream)
            throws IOException {

        List<String> responseLines = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(inputStream)
        )) {
            String line;
            while ((line = br.readLine()) != null) {
                responseLines.add(line);
            }
        }
        return responseLines;
    }

}
