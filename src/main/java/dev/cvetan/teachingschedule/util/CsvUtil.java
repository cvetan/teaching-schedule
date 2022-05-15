package dev.cvetan.teachingschedule.util;

import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import dev.cvetan.teachingschedule.exception.TSRuntimeException;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

@Component
public class CsvUtil {

    public List<String[]> readCsvFile(String path) {
        try (var reader = new CSVReaderBuilder(
                new FileReader(path))
                .withSkipLines(1)
                .build()
        ) {
            return reader.readAll();
        } catch (FileNotFoundException e) {
            throw new TSRuntimeException(String.format(
                    "File not found on path %s",
                    path
            ));
        } catch (IOException e) {
            throw new TSRuntimeException(String.format(
                    "There was error while loading CSV file on path %s (%s)",
                    path,
                    e.getMessage()
            ));
        } catch (CsvException e) {
            throw new TSRuntimeException(String.format(
                    "There was error while reading CSV file on path %s (%s)",
                    path,
                    e.getMessage()
            ));
        }
    }
}
