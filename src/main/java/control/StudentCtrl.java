package control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.CmStudent;
import pojo.EmpStu;
import pojo.StuGrade;
import pojo.UnempStu;
import service.StudentService;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.List;

/**
 * Created by TianYu on 2016/10/27.
 */
@Controller
@RequestMapping("/student")
public class StudentCtrl {
    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String index(){
        return "index";
    }

    /*根据姓名查询学生*/
    @RequestMapping(value = "/findByName")
    @ResponseBody
    public List<CmStudent> findByStuName(String sname) throws UnsupportedEncodingException {
        String tn = new String(sname.getBytes("iso-8859-1"),"utf-8");
        List<CmStudent> data = (List<CmStudent>)studentService.findStuByName(tn);
        return data;
    }

    /*根据年级查询学生*/
    @RequestMapping(value = "/findByGrade")
    @ResponseBody
    public List<CmStudent> findByStuGrade(int grade){
        List<CmStudent> data = (List<CmStudent>)studentService.findStuByGrade(grade);
        return data;
    }

    /*查询已就业、未就业学生信息*/
    @RequestMapping(value = "/findById")
    @ResponseBody
    public List<?> findStu(int sid){
        if(studentService.findStuState(sid)){
            return (List<EmpStu>)studentService.listEmpStudent(sid);
        }else if(!studentService.findStuState(sid)){
            return (List<UnempStu>)studentService.listUnempStudent(sid);
        }
        return null;
    }

    /*查询学生成绩*/
    @RequestMapping(value = "/findGrade")
    @ResponseBody
    public StuGrade findGrade(int sid) throws ParseException {
        StuGrade sg = new StuGrade();
        CmStudent cs = studentService.findStuById(sid);
        sg.setSno(cs.getSno());
        sg.setSname(cs.getSname());
        sg.setSsex(cs.getSsex());
        sg.setSbirth(cs.getSbirth());
        sg.setSpro(cs.getSpro());
        sg.setSgrade(cs.getSgrade());
        sg.setSclass(cs.getSclass());
        sg.setSphone(cs.getSphone());
        sg.setSemail(cs.getSemail());
        sg.setScode(cs.getScode());
        sg.setSmark(cs.getSmark());
        sg.setSassess(cs.getSassess());
        sg.setSstate(cs.getSstate());
        sg.setSdetail(cs.getSdetail());
        sg.setBxxx(studentService.queryBxxx(sid));
        sg.setXxxx(studentService.queryXxxx(sid));
        sg.setZkmu(studentService.queryZkms(sid,0));
        sg.setQxkm(studentService.queryZkms(sid,1));
        sg.setZxkm(studentService.queryZkms(sid,2));
        sg.setZxqk(studentService.queryZkms(sid,3));
        return sg;
    }
}
