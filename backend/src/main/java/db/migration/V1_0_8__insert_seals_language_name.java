package db.migration;

import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;

import java.io.InputStreamReader;
import java.sql.PreparedStatement;

public class V1_0_8__insert_seals_language_name extends BaseJavaMigration {
    @Override
    public void migrate(Context context) throws Exception {
        try (CSVReader csvReader = new CSVReaderBuilder(new InputStreamReader(
                getClass().getResourceAsStream("/db/data/seals_language_name.csv")))
                .withCSVParser(new CSVParserBuilder().withSeparator(';').build())
                .build()) {
            String[] line;
            PreparedStatement statement = context.getConnection()
                    .prepareStatement("INSERT INTO seals_language_name (id, name, fk_seal_id, fk_supported_language_id) VALUES (?, ?, ?, ?)");
            while ((line = csvReader.readNext()) != null) {
                if (line[0].equals("id")) continue; // Skip header
                statement.setInt(1, Integer.parseInt(line[0]));
                statement.setString(2, line[1]);
                statement.setInt(3, Integer.parseInt(line[2]));
                statement.setInt(4, Integer.parseInt(line[3]));
                statement.execute();
            }
        }
    }
}
