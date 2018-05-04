package ml.jinggo.data.util;

import org.apache.commons.dbcp.BasicDataSource;

import javax.sql.DataSource;

/**
 * @author wangyj
 * @description
 * @create 2018-05-04 14:11
 **/
public class DataSourceUtil {

    private static final String URL_PREFIX1 = "jdbc:mysql://192.168.5.111:3306/";
    private static final String URL_PREFIX2 = "jdbc:mysql://192.168.5.77:3306/";

    private static final String USER_NAME = "root";

    private static final String PASSWORD = "soonfor123456!";

    public static DataSource createDataSource(final String dataSourceName) {
        BasicDataSource result = new BasicDataSource();
        result.setDriverClassName(com.mysql.jdbc.Driver.class.getName());
        result.setUrl(URL_PREFIX1 + dataSourceName);
        result.setUsername(USER_NAME);
        result.setPassword(PASSWORD);
        return result;
    }

    public static DataSource createDataSource2(final String dataSourceName) {
        BasicDataSource result = new BasicDataSource();
        result.setDriverClassName(com.mysql.jdbc.Driver.class.getName());
        result.setUrl(URL_PREFIX2 + dataSourceName);
        result.setUsername(USER_NAME);
        result.setPassword(PASSWORD);
        return result;
    }
}
