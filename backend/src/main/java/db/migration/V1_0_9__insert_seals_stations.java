package db.migration;

import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;

import java.io.InputStreamReader;
import java.sql.PreparedStatement;

public class V1_0_9__insert_seals_stations extends BaseJavaMigration {
    @Override
    public void migrate(Context context) throws Exception {
        try (CSVReader csvReader = new CSVReaderBuilder(new InputStreamReader(
                getClass().getResourceAsStream("/db/data/seals_stations.csv")))
                .withCSVParser(new CSVParserBuilder().withSeparator(',').build())
                .build()) {
            String[] line;
            PreparedStatement statement = context.getConnection()
                    .prepareStatement("INSERT INTO seals_stations (seals_stations_id, fk_seal_id, fk_station_id) VALUES (?, ?, ?)");
            while ((line = csvReader.readNext()) != null) {
                if (line[0].equals("seals_stations_id")) continue; // Skip header
                statement.setInt(1, Integer.parseInt(line[0]));
                statement.setInt(2, Integer.parseInt(line[1]));
                statement.setInt(3, Integer.parseInt(line[2]));
                statement.execute();
            }
        }
    }
}
