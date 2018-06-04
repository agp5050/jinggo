package ml.jinggo.dynamic;

import ml.jinggo.conf.UserDao;

public class UserService {
  private UserDao userDao;


    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
