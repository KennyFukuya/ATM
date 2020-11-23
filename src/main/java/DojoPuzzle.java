import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.*;

public class DojoPuzzle {
    public static void main(String[] args) {
        if (args.length < 1) {
            throw new IllegalArgumentException("Filename parameter is required!");
        }

        Reader reader;
        CSVReader csvReader;
        List<String[]> csvContent;
        ArrayList<Integer> availableBills = new ArrayList<>();
        ATM atm;
        Integer requestedValue;

        try {
            reader = Files.newBufferedReader(Paths.get(args[0]));
            csvReader = new CSVReaderBuilder(reader).build();
            csvContent = csvReader.readAll();

            if (csvContent.get(0).length != 4) {
                throw new IllegalArgumentException("Headers must have the amount of bills available for each type!");
            }

            for (String header: csvContent.get(0)) {
                availableBills.add(Integer.parseInt(header));
            }

            atm = new ATM(availableBills);

            System.out.println("Welcome to the ATM!");

            for (int i = 1; i < csvContent.size(); i++) {
                for (String value: csvContent.get(i)) {
                    requestedValue = Integer.parseInt(value);

                    System.out.println("Trying to withdraw $" + requestedValue + "...");

                    System.out.println(atm.withdrawBills(requestedValue));
                }
            }
        } catch (NoSuchFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
