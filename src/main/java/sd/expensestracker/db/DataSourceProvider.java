package sd.expensestracker.db;

import org.postgresql.ds.PGSimpleDataSource;

public class DataSourceProvider {

    private static PGSimpleDataSource dataSource = null;
    public static final String USER = "postgres";
    public static final String PASS = "secret";

    public static PGSimpleDataSource getDataSource() {
        if (dataSource == null) {
            dataSource = new PGSimpleDataSource();
            dataSource.setServerNames(new String[] {"localhost"});
            dataSource.setPortNumbers(new int[] {5432});
            dataSource.setDatabaseName("expenses_tracker_postgres_db");
            dataSource.setUser(USER);
            dataSource.setPassword(PASS);
        }
        return dataSource;
    }
}
