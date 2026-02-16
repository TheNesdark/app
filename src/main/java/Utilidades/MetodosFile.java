package Utilidades;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileAttribute;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/* JADX INFO: loaded from: GenomaP.jar:Utilidades/MetodosFile.class */
public class MetodosFile {
    public static int countPDFFilesInFolder(Path folderPath, final String extension) throws IOException {
        final AtomicInteger pdfFileCount = new AtomicInteger();
        Files.walkFileTree(folderPath, new SimpleFileVisitor<Path>() { // from class: Utilidades.MetodosFile.1
            @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                if (Files.isRegularFile(file, new LinkOption[0]) && file.toString().toLowerCase().endsWith(extension)) {
                    pdfFileCount.incrementAndGet();
                }
                return FileVisitResult.CONTINUE;
            }
        });
        return pdfFileCount.get();
    }

    public static List<Path> searchFilesContainingString(Path folderPath, final String searchString) throws IOException {
        final List<Path> result = new ArrayList<>();
        System.out.println("buscar " + folderPath);
        Files.walkFileTree(folderPath, new SimpleFileVisitor<Path>() { // from class: Utilidades.MetodosFile.2
            @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (Files.isRegularFile(file, new LinkOption[0]) && MetodosFile.containsString(file, searchString)) {
                    result.add(file);
                }
                return FileVisitResult.CONTINUE;
            }
        });
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean containsString(Path path, String searchString) throws IOException {
        Charset charset = StandardCharsets.UTF_8;
        Stream<String> lines = Files.lines(path, charset);
        Throwable th = null;
        try {
            try {
                boolean zAnyMatch = lines.anyMatch(line -> {
                    return line.contains(searchString);
                });
                if (lines != null) {
                    if (0 != 0) {
                        try {
                            lines.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    } else {
                        lines.close();
                    }
                }
                return zAnyMatch;
            } finally {
            }
        } catch (Throwable th3) {
            if (lines != null) {
                if (th != null) {
                    try {
                        lines.close();
                    } catch (Throwable th4) {
                        th.addSuppressed(th4);
                    }
                } else {
                    lines.close();
                }
            }
            throw th3;
        }
    }

    public static List<Path> findPDFFilesInFolder(Path folderPath) throws IOException {
        final List<Path> pdfFiles = new ArrayList<>();
        Files.walkFileTree(folderPath, new SimpleFileVisitor<Path>() { // from class: Utilidades.MetodosFile.3
            @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                if (Files.isRegularFile(file, new LinkOption[0]) && file.toString().toLowerCase().endsWith(".pdf")) {
                    pdfFiles.add(file);
                }
                return FileVisitResult.CONTINUE;
            }
        });
        return pdfFiles;
    }

    public static void copyFilesToDestination(List<Path> files, Path destinationPath) throws IOException {
        for (Path file : files) {
            Path destinationFile = destinationPath.resolve(file.getFileName());
            Files.copy(file, destinationFile, StandardCopyOption.REPLACE_EXISTING);
        }
    }

    public static AtomicBoolean searchAndCopyFile(final Path sourceDir, final String searchString, final Path targetDir) throws IOException {
        final AtomicBoolean estado = new AtomicBoolean(false);
        Files.walkFileTree(sourceDir, new SimpleFileVisitor<Path>() { // from class: Utilidades.MetodosFile.4
            @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (file.getFileName().toString().contains(searchString)) {
                    Path targetFile = targetDir.resolve(sourceDir.relativize(file));
                    Files.createDirectories(targetFile.getParent(), new FileAttribute[0]);
                    Files.copy(file, targetFile, StandardCopyOption.REPLACE_EXISTING);
                    estado.set(true);
                }
                return FileVisitResult.CONTINUE;
            }
        });
        return estado;
    }

    public static void modifyExcelCell(String excelFilePath, int sheetIndex, int rowIndex, int cellIndex, String newValue) throws IOException {
        FileInputStream inputStream = new FileInputStream(excelFilePath);
        XSSFWorkbook xSSFWorkbook = new XSSFWorkbook(inputStream);
        Sheet sheet = xSSFWorkbook.getSheetAt(sheetIndex);
        Row row = sheet.getRow(rowIndex);
        if (row == null) {
            row = sheet.createRow(rowIndex);
        }
        Cell cell = row.getCell(cellIndex);
        if (cell == null) {
            cell = row.createCell(cellIndex);
        }
        cell.setCellValue(newValue);
        inputStream.close();
        FileOutputStream outputStream = new FileOutputStream(excelFilePath);
        xSSFWorkbook.write(outputStream);
        xSSFWorkbook.close();
        outputStream.close();
    }
}
