package db.migration;

import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;

import java.io.InputStreamReader;
import java.sql.PreparedStatement;

public class V1_0_4__insert_external_media_links extends BaseJavaMigration {
    @Override
    public void migrate(Context context) throws Exception {
        try (CSVReader csvReader = new CSVReaderBuilder(new InputStreamReader(
                getClass().getResourceAsStream("/db/data/external_media_links.csv")))
                .withCSVParser(new CSVParserBuilder().withSeparator(';').build())
                .build()) {
            String[] line;
            PreparedStatement statement = context.getConnection()
                    .prepareStatement("INSERT INTO external_media_links (id, link, media_links_type, fk_station_id) VALUES (?, ?, ?, ?)");
            while ((line = csvReader.readNext()) != null) {
                if (line[0].equals("id")) continue; // Skip header
                statement.setInt(1, Integer.parseInt(line[0]));
                statement.setString(2, line[1]);
                statement.setString(3, line[2]);
                statement.setInt(4, Integer.parseInt(line[3]));
                statement.execute();
            }
        }
    }
}
