package by.bsu.service;

import by.bsu.dao.DaoException;
import by.bsu.dao.IUserDao;
import by.bsu.entities.user.UserRole;
import by.bsu.exception.UserServiceException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Yauheniya_Neliub on 2/27/2015.
 */
public class UserService implements UserDetailsService {
    private IUserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            by.bsu.entities.user.User user = userDao.findUserByUsername(username) ;
            return new User(user.getLogin(),user.getPassword(), true, true, true, true, getAuthority(user.getRole()));
        } catch (DaoException e) {
            e.printStackTrace();
            throw new UserServiceException(e.getMessage(),e);
        }
    }

    public Collection<? extends GrantedAuthority> getAuthority(UserRole role){
        List<GrantedAuthority> authList = getGrantedAuthorities(getRoles(role));
        return authList;
    }

    public List<String> getRoles(UserRole role) {
        List<String> roles = new ArrayList<String>();
        switch (role){
            case ADMIN:
                roles.add("admin");
                break;
        }
/*
        if (role.intValue() == 1) {
            roles.add("ROLE_MODERATOR");
            roles.add("ROLE_ADMIN");
        } else if (role.intValue() == 2) {
            roles.add("ROLE_MODERATOR");
        }*/
        return roles;
    }

    public static List<GrantedAuthority> getGrantedAuthorities(List<String> roles) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        for (String role : roles) {
            authorities.add(new SimpleGrantedAuthority(role));
        }
        return authorities;
    }

    public void setUserDao(IUserDao userDao) {
        this.userDao = userDao;
    }
}
