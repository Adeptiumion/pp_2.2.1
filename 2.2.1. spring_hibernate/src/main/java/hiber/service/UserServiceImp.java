package hiber.service;

import hiber.dao.UserDao;
import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;


@Transactional(readOnly = true)
@Service
public class UserServiceImp implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImp(UserDao userDao){
        this.userDao = userDao;
    }

    @Transactional
    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    public User takeBasedOnTheCar(int series, String model) {

        return userDao.takeBasedOnTheCar(series, model);
    }


    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }


}
