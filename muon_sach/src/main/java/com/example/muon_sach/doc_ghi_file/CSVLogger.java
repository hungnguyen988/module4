package com.example.muon_sach.doc_ghi_file;

import java.io.FileWriter;
import java.io.IOException;

public class CSVLogger {
    private static final String FILE_PATH = "E:\\codegym\\module4\\bai_tap_module_4\\muon_sach\\src\\main\\java\\com\\example\\muon_sach\\logs.csv";

    // Ghi dữ liệu vào file CSV
    public static void logToCSV(String methodName, String errorMessage, String timestamp) {
        try (FileWriter writer = new FileWriter(FILE_PATH, true)) { // true để ghi tiếp vào file
            String logEntry = methodName + "," + errorMessage + "," + timestamp + "\n";
            writer.append(logEntry);
        } catch (IOException e) {
            System.err.println("Không thể ghi log vào file: " + e.getMessage());
        }
    }
}

