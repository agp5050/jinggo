package ml.jinggo.service;


import ml.jinggo.dao.ForumDao;
import ml.jinggo.domain.Forum;

public class JdbcBbtForum implements BbtForum {
    private ForumDao forumDao;
    
	public void setForumDao(ForumDao forumDao) {
		this.forumDao = forumDao;
	}

	public void addForum(Forum forum) {
		forumDao.addForum(forum);
	}
}
