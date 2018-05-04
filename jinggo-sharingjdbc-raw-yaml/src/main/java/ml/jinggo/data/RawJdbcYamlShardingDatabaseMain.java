package ml.jinggo.data;

import io.shardingjdbc.core.api.MasterSlaveDataSourceFactory;
import io.shardingjdbc.core.api.ShardingDataSourceFactory;
import ml.jinggo.data.repository.RawJdbcYamlRepository;

import javax.sql.DataSource;
import java.io.File;

/**
 * @author wangyj
 * @description
 * @create 2018-05-04 16:30
 **/
public class RawJdbcYamlShardingDatabaseMain {

    // CHECKSTYLE:OFF
    public static void main(final String[] args) throws Exception {
        // CHECKSTYLE:ON
        DataSource dataSource = ShardingDataSourceFactory.createDataSource(new File(
                RawJdbcYamlShardingDatabaseMain.class.getResource("/META-INF/yamlShardingDatabase.yaml").getFile()));
        new RawJdbcYamlRepository(dataSource).demo();
    }
}
