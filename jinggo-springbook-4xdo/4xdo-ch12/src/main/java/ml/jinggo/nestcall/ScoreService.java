package ml.jinggo.nestcall;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * @author wangyj
 * @description
 * @create 2018-07-23 10:01
 **/
@Service("scoreUserService")
public class ScoreService extends BaseService {

    private JdbcTemplate jdbcTemplate;

    public void addScore(String userName, int toAdd) {
        String sql = "UPDATE t_user u SET u.score = u.score + ? WHERE user_name =?";
        jdbcTemplate.update(sql, toAdd, userName);
    }
}
