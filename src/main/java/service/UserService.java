package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Service;
import pojo.CmUser;

import java.util.List;

/**
 * Created by TianYu on 2016/10/26.
 */
@Service("userService")
public class UserService {
    @Autowired
    private HibernateTemplate hibernateTemplate;
    /*添加用户*/
    public boolean addUser(CmUser myUser){
        System.out.println("==UserName:"+myUser.getUrname()+"==");
        hibernateTemplate.save(myUser);
        return true;
    }
    /*按用户名查询用户*/
    public CmUser findByUserName(String userName){
        String hsql = "from CmUser u where u.uname = ?";
        List<CmUser> data = (List<CmUser>)hibernateTemplate.find(hsql,userName);
        if(!data.isEmpty()){
            return (CmUser) data.get(0);
        }
        return null;
    }
    /*用户登陆*/
    public CmUser login (String uname,String pwd){
        String hql = "from CmUser u where u.uname = ? and upwd = ?";
        CmUser u = (CmUser)hibernateTemplate.find(hql,uname,pwd);
        if (u!=null){
            return u;
        }
        return null;
    }
    /*模糊查询用户*/
    public List<CmUser> searchUserName(String userName){
        String hsql = "from CmUser u where u.uname like ?";
        List<CmUser> data = (List<CmUser>)hibernateTemplate.find(hsql,"%"+userName+"%");
        if(!data.isEmpty()){
            return data;
        }
        return null;
    }
}
