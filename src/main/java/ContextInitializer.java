import pba.cxn.dbReader.DbConnector;

class ContextInitializer {
    private static boolean initialized;

    public static void initialize() {
        if (initialized)
            return;
        initialized = true;
        try {
            DbConnector.initialize(
                    "jdbc:postgresql://localhost:5432/postgres",
                    "postgres",
                    "test123",
                    DbConnector.INTERFACE.PostgreSQL
            );

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
