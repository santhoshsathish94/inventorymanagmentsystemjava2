package CTRL;

import BLL.Users;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class UsersCTRL {
    
    protected EntityManager em;
    
    public UsersCTRL(EntityManager em) 
    {
       this.em = em;
    }
    
    public Users createUser(String username, String passwordHash, String type, String fName, String lName)
    {
    Users user = new Users();
    user.setFName(fName);
    user.setLName(lName);
    user.setPasswordHash(passwordHash);
    user.setType(type);
    user.setUsername(username);
    em.persist(user);
    return user;
    }
    
    public Users findUser(int user_id) 
    {
        return em.find(Users.class, user_id);
    }
    
    public Users removeUser(int user_id) 
    {
     Users user = findUser(user_id);
        if (user != null) 
        {
          em.remove(user);
        }
        return null;
    }
    
    public Users updateUserType(int user_id,String type) 
    {
    Users user = em.find(Users.class, user_id);
    if (user != null) 
    {
         user.setType(type);
    }
        return user;
    }
    
}
