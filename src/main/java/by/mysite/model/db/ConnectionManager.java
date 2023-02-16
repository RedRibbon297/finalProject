package by.mysite.model.db;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import static by.mysite.constants.DbConstant.DB_FILE_PROPS;

public class ConnectionManager {
    private static final String DRIVER = "driver";
    private static final String URL = "url";
    private static Connection cn;
    private static Properties props;

    public static void init(){
        loadProps();
        loadDriver();
    }

    private static void loadProps() {
        InputStream is = Thread.currentThread()
                .getContextClassLoader()
                .getResourceAsStream(DB_FILE_PROPS);
        props = PropertiesManager.getProperties(is);
    }

    private static void loadDriver() {
        try {
            Class.forName(props.getProperty(DRIVER));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() throws SQLException {
        if (cn == null || cn.isClosed()) {
            cn = DriverManager.getConnection(props.getProperty(URL), props);
        }
        return cn;
    }
}
