package util;

import exception.LoadFileException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public final class FileUtil {
    public static List<String> readFile(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            return br.lines().skip(1).collect(Collectors.toList());
        } catch (IOException e) {
            throw new LoadFileException();
        }
    }
}
