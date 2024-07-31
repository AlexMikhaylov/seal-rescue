package db.migration;

import com.opencsv.CSVReader;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReaderBuilder;
import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;

import java.io.InputStreamReader;
import java.sql.PreparedStatement;

public class V1_0_2__insert_countries extends BaseJavaMigration {
    @Override
    public void migrate(Context context) throws Exception {
        try (CSVReader csvReader = new CSVReaderBuilder(new InputStreamReader(
                getClass().getResourceAsStream("/db/data/countries.csv")))
                .withCSVParser(new CSVParserBuilder().withSeparator(';').build())
                .build()) {
            String[] line;
            PreparedStatement statement = context.getConnection()
                    .prepareStatement("INSERT INTO countries (country_id, country_name, country_code, fk_region_id) VALUES (?, ?, ?, ?)");
            while ((line = csvReader.readNext()) != null) {
                if (line[0].equals("country_id")) continue; // Skip header
                statement.setInt(1, Integer.parseInt(line[0]));
                statement.setString(2, line[1]);
                statement.setString(3, line[2]);
                statement.setInt(4, Integer.parseInt(line[3]));
                statement.execute();
            }
        }
    }
}
