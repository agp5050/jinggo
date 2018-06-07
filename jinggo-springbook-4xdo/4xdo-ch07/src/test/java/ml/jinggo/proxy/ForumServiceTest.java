package ml.jinggo.proxy;

/**
 * @author wangyj
 * @description
 * @create 2018-06-06 17:57
 **/
public class ForumServiceTest {

    public static void main(String[] args) {
        ForumService forumService = new ForumServiceImpl();
        forumService.removeForum(10);
        forumService.removeTopic(1012);
    }
}
