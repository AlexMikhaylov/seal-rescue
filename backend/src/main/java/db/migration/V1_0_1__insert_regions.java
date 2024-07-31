package db.migration;

import com.opencsv.CSVReader;
import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;

import java.io.InputStreamReader;
import java.sql.PreparedStatement;

public class V1_0_1__insert_regions extends BaseJavaMigration {
    @Override
    public void migrate(Context context) throws Exception {
        try (CSVReader csvReader = new CSVReader(new InputStreamReader(
                getClass().getResourceAsStream("/db/data/regions.csv")))) {
            String[] line;
            PreparedStatement statement = context.getConnection()
                    .prepareStatement("INSERT INTO regions (region_id, region_name) VALUES (?, ?)");
            while ((line = csvReader.readNext()) != null) {
                if (line[0].equals("region_id")) continue; // Skip header
                statement.setInt(1, Integer.parseInt(line[0]));
                statement.setString(2, line[1]);
                statement.execute();
            }
        }
    }
}
