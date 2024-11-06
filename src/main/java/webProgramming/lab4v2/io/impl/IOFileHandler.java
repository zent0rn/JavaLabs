package webProgramming.lab4v2.io.impl;

import webProgramming.lab4v2.io.IOHandler;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class IOFileHandler implements IOHandler {

    private final RandomAccessFile file;

    /**
     * Конструктор по умолчанию
     *
     * @throws FileNotFoundException если не найден файл
     */
    public IOFileHandler() throws FileNotFoundException {
        file = new RandomAccessFile(DEFAULT_FILE_PATH.toFile(), "rw");
    }

    /**
     * Конструктор с параметром - путем к файлу
     *
     * @param path путь к файлу
     * @throws FileNotFoundException если не найден файл
     */
    public IOFileHandler(Path path) throws FileNotFoundException {
        file = new RandomAccessFile(path.toFile(), "rw");
    }

    public String read() throws IOException {
        return file.readLine();
    }

    public void write(String string) throws IOException {
        file.write(string.getBytes());
    }

    public List<String> readLines() throws IOException {
        List<String> lines = new ArrayList<>();
        while (true) {
            String line = file.readLine();
            if (line == null) {
                break;
            }
            lines.add(new String(line.getBytes(StandardCharsets.UTF_8)));
        }
        return lines;
    }

    public void writeLines(List<String> lines) throws IOException {
        file.seek(0);
        for (String string : lines) {
            file.write(string.getBytes());
            file.write('\r');
            file.write('\n');
        }
    }

    private static final Path DEFAULT_FILE_PATH = Path.of(FileSystems.getDefault().getPath(".").toAbsolutePath()
            + "/src/main/resources/fileForLab4.txt");
}
