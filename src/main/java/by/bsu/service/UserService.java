package by.bsu.service;

import by.bsu.dao.DaoException;
import by.bsu.dao.IUserDao;
import by.bsu.entities.user.UserRole;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Yauheniya_Neliub on 2/24/2015.
 */
public class UserService implements UserDetailsService {
    private IUserDao userDao;

    @Override
    public UserDetails loadUserByUsername(final String login)
            throws UsernameNotFoundException {

        by.bsu.entities.user.User user = null;
        try {
            user = userDao.findUserByLogin(login);
        } catch (DaoException e) {
            e.printStackTrace();//сгенерить ошибку сервиса!!!
        }
        List<GrantedAuthority> authorities = buildUserAuthority(user.getRole());
        return buildUserForAuthentication(user, authorities);


    }

    // Converts com.mkyong.users.model.User user to
    // org.springframework.security.core.userdetails.User
    private User buildUserForAuthentication(by.bsu.entities.user.User user,
                                            List<GrantedAuthority> authorities) {
        return new User(user.getLogin(),
                user.getPassword(), true,// вместо этого true возможно надо user.isEnabled(), но тогда надо менять таблицу!!!
                true, true, true, authorities);
    }

    private List<GrantedAuthority> buildUserAuthority(UserRole userRole) {
        Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
        // Build user's authorities
        setAuths.add(new SimpleGrantedAuthority(userRole.getValue()));
        List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);
        return Result;
    }

    public IUserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(IUserDao userDao) {
        this.userDao = userDao;
    }
}
