package db.migration;

import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;

import java.io.InputStreamReader;
import java.sql.PreparedStatement;

public class V1_1_1__insert_station_news extends BaseJavaMigration {
    @Override
    public void migrate(Context context) throws Exception {
        try (CSVReader csvReader = new CSVReaderBuilder(new InputStreamReader(
                getClass().getResourceAsStream("/db/data/station_news.csv")))
                .withCSVParser(new CSVParserBuilder().withSeparator(';').build())
                .build()) {
            String[] line;
            PreparedStatement statement = context.getConnection()
                    .prepareStatement("INSERT INTO station_news (id, news_external_link, news_summary, updated_at, created_at, fk_station_id) VALUES (?, ?, ?, ?, ?, ?)");
            while ((line = csvReader.readNext()) != null) {
                if (line[0].equals("id")) continue; // Skip header
                statement.setInt(1, Integer.parseInt(line[0]));
                statement.setString(2, (line[1]));
                statement.setString(3, (line[2]));
                statement.setString(4, (line[3]));
                statement.setString(5, (line[4]));
                statement.setInt(6, Integer.parseInt(line[5]));
                statement.execute();
            }
        }
    }
}
