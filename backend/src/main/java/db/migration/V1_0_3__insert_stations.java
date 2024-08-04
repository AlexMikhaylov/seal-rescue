package db.migration;

import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;

import java.io.InputStreamReader;
import java.sql.PreparedStatement;

public class V1_0_3__insert_stations extends BaseJavaMigration {
    @Override
    public void migrate(Context context) throws Exception {
        try (CSVReader csvReader = new CSVReaderBuilder(new InputStreamReader(
                getClass().getResourceAsStream("/db/data/stations.csv")))
                .withCSVParser(new CSVParserBuilder().withSeparator(';').build())
                .build()) {
            String[] line;
            PreparedStatement statement = context.getConnection()
                    .prepareStatement("INSERT INTO stations (station_id, station_original_name, station_longitude, station_latitude, station_address, fk_country_id, station_status) VALUES (?, ?, ?, ?, ?, ?, ?::station_status_enum)");
            while ((line = csvReader.readNext()) != null) {
                if (line[0].equals("station_id")) continue; // Skip header
                statement.setInt(1, Integer.parseInt(line[0]));
                statement.setString(2, line[1]);
                statement.setFloat(3, Float.parseFloat(line[2]));
                statement.setFloat(4, Float.parseFloat(line[3]));
                statement.setString(5, line[4]);
                statement.setInt(6, Integer.parseInt(line[5]));
                statement.setString(7, line[6]);
                statement.execute();
            }
        }
    }
}
