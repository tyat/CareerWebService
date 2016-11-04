package control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.CmUser;
import service.UserService;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by TianYu on 2016/10/26.
 */
@Controller
@RequestMapping("/user")
public class UserCtrl {
    @Autowired
    private UserService usersService;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String index(){
        return "index";
    }

    /*注册用户*/
    @RequestMapping(value = "/register")
    @ResponseBody
    public Map<String,String> register(String uname, String urname, String upwd, String uemail, String uphone, int urank,int ustate) throws UnsupportedEncodingException {
        String tn = new String(urname.getBytes("iso-8859-1"),"utf-8");
        CmUser myUsers = new CmUser(uname,tn,upwd,uemail,uphone,urank,ustate);
        usersService.addUser(myUsers);
        Map<String,String> data = new HashMap<String,String>();
        data.put("state","0");
        return data;
    }

    /*查找用户*/
    @RequestMapping(value = "/find")
    @ResponseBody
    public CmUser findByUserName(String uname){
        CmUser data = (CmUser)usersService.findByUserName(uname);
        return data;
    }

    /*用户登录*/
    @RequestMapping(value = "/login")
    @ResponseBody
    public CmUser login(String uname,String pwd) {
        CmUser u = usersService.login(uname,pwd);
        return u;
    }

    @RequestMapping(value = "/search")
    @ResponseBody
    public List<CmUser> searchUser(String uname){
        List<CmUser> data = (List<CmUser>)usersService.searchUserName(uname);
        return data;
    }

}
