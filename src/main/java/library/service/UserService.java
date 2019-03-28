package library.service;

import library.dao.RoleDAO;
import library.dao.UserDao;
import library.dto.UserDTO;
import library.entity.Role;
import library.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

@Service("service")
@Transactional
public class UserService {
    @Autowired
    UserDao userDao;
    @Autowired
    RoleDAO roleDAO;



    public void save(UserEntity user) {
        Set<Role> roles = new HashSet<>();
        roles.add(roleDAO.getOne(1L));
        user.setRoles(roles);
        userDao.create(user);

        //TODO
    }

    public void createUser(UserDTO userEntity) {
        userDao.create(userEntity);
    }
    public void updateUser(UserEntity user) {
        userDao.updateUser(user);
    }
    public void deleteUser(UserEntity userEntity) {
        userDao.deleteUser(userEntity);
    }
    public boolean isLoginExists(String login) {
        return userDao.isLoginExists(login);
    }
    public boolean isEmailExists(String email) {
        return userDao.isEmailExists(email);
    }
    public UserEntity getUserByLogin(String login) {
        return userDao.getUserByNickName(login);
    }
    public String getUserNicknameByEmail(String email){
       return userDao.getUserNicknameByEmail(email);
    }
    public boolean isPasswordExist(UserDTO user) {
        return userDao.isPasswpodExist(user);
    }

}
