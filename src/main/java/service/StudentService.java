package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Service;
import pojo.CmStudent;
import pojo.EmpStu;
import pojo.UnempStu;
import tools.Tools;

import java.text.ParseException;
import java.util.List;

/**
 * Created by TianYu on 2016/10/27.
 */
@Service("studentService")
public class StudentService {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    /*添加学生*/
    public boolean addUser(CmStudent stu){
        hibernateTemplate.save(stu);
        return true;
    }

    /*按姓名查询学生*/
    public List<CmStudent> findStuByName(String sname){
        String hsql = "from CmStudent u where u.sname like ?";
        List<CmStudent> data = (List<CmStudent>)hibernateTemplate.find(hsql,"%"+sname+"%");
        if(!data.isEmpty()){
            return data;
        }
        return null;
    }

    /*按年级查询学生*/
    public List<CmStudent> findStuByGrade(int grade){
        String hql = "from CmStudent u where u.sgrade = ?";
        List<CmStudent> data = (List<CmStudent>)hibernateTemplate.find(hql,grade);
        if(!data.isEmpty()){
            return data;
        }
        return null;
    }

    /*按id查询学生*/
    public CmStudent findStuById(int id){
        String hql = "from CmStudent stu where stu.sid = ?";
        List<CmStudent> stu = (List<CmStudent>)hibernateTemplate.find(hql,id);
        if(!stu.isEmpty()){
            return stu.get(0);
        }
        return null;
    }

    /*查询学生就业状态*/
    public boolean findStuState(int sid){
        List<CmStudent> stu = (List<CmStudent>)hibernateTemplate.find("from CmStudent s where s.sstate=2 and id=?",sid);
        if (!stu.isEmpty()){
            System.out.println("该学生"+sid+"--已就业--");
            return true;/*已就业返回true*/
        }else {
            System.out.println("该学生"+sid+"--未就业--");
            return false;/*未就业返回false*/
        }
    }

    /*已就业学生信息*/
    public List<EmpStu> listEmpStudent(int sid){
        String hql = "select new pojo.EmpStu(cs.sid, cs.sno, cs.sname, cs.ssex, cs.sbirth, cs.spro, cs.sgrade, cs.sclass, cs.sphone, cs.semail, cs.scode, cs.smark, cs.sassess, cs.sstate, cs.sdetail, cc.cname, cj.jname, ce.etime, ce.esalary, ce.ewq, ce.eleave, ce.ereason) " +
                "from pojo.CmStudent cs inner join cs.cmEmpsBySid ce inner join ce.cmJobByJid cj inner join cj.cmRecruitsByJid cr inner join cr.cmCompanyByCid cc where cs.sid = ?";
        List<EmpStu> stu = (List<EmpStu>)hibernateTemplate.find(hql,sid);
        if (!stu.isEmpty()){
            return stu;
        }
        return null;
    }

    /*未就业学生信息*/
    public List<UnempStu> listUnempStudent(int sid){
        String hql = "select new pojo.UnempStu(cs.sid, cs.sno, cs.sname,cs.ssex, cs.sbirth, cs.spro, cs.sgrade, cs.sclass, cs.sphone, cs.semail, cs.scode, cs.smark, cs.sassess, cs.sstate,cs.sdetail, cj.jname, ue.uesalary, ue.uetime, ue.ueschool, ue.uemajor, ue.uesuccess) " +
                "from CmStudent cs inner join cs.cmUnempsBySid ue inner join ue.cmJobByJid cj where cs.sid = ?";
        List<UnempStu> stu = (List<UnempStu>)hibernateTemplate.find(hql,sid);
        if (!stu.isEmpty()){
            return stu;
        }
        return null;
    }

    /*查询必修学分*/
    public Integer queryBxxx(int sid) {
        String hsql = "select sum(g.gxf) " +
                "from CmGrade g " +
                "where g.cmStudentBySid.sid = ? " +
                "and g.glx = 0 " +
                "and ((g.gfslx = 1 and (g.gcj in ('及格','中','良','优') or g.gbkcj in ('及格','中','良','优'))) or (g.gfslx = 2 and (CONVERT(g.gcj , SIGNED) >= 60 or CONVERT(g.gbkcj , SIGNED) >= 60))) ";
        List<?> data = hibernateTemplate.find(hsql, sid);
        if(!data.isEmpty()) {
            System.out.println("必修学分："+data.get(0)+"----------------------");
            return new Integer(String.valueOf(data.get(0)));
        }
        return 0;
    }

    /*查询选修学分*/
    public Integer queryXxxx(int sid){
        String hsql = "select sum(g.gxf) " +
                "from CmGrade g " +
                "where g.cmStudentBySid.sid = ? " +
                "and g.glx in (1,2) " +
                "and ((g.gfslx = 1 and (g.gcj in ('及格','中','良','优') or g.gbkcj in ('及格','中','良','优'))) or (g.gfslx = 2 and (CONVERT(g.gcj , SIGNED) >= 60 or CONVERT(g.gbkcj , SIGNED) >= 60))) " ;
        List<Long> data = (List<Long>)hibernateTemplate.find(hsql,sid);
        if(!data.isEmpty()) {
            System.out.println("选修学分："+data.get(0)+"----------------------");
            return new Integer(String.valueOf(data.get(0)));
        }
        return 0;
    }

    /*查询科目总数,0总科目1清考科目2中兴科目3中兴清考科目*/
    public Integer queryZkms(int sid,int type){
        String hsql = "select count(*) from CmGrade g where g.cmStudentBySid.sid = ?";
        if(type==1){
            hsql = hsql + " and (g.gfslx = 1 and g.gcj = '不及格' and g.gbkcj = '不及格') or (g.gfslx = 2 and CONVERT(g.gcj , SIGNED) < 60 and CONVERT(g.gbkcj , SIGNED) < 60)";
        }else if(type==2){
            hsql = hsql + " and g.gkcm in ('Java语言基础','Java在移动通信中应用','网页设计','网页设计课程设计','数据库应用技术','JSP应用技术与AJAX','JSP应用技术与AJAX课程设计','SSH应用技术','SSH应用技术课程设计','IPhone/android嵌入式移动开发技术基础','IPhone/android嵌入式移动开发技术','软件测试技术与工具','IT项目管理','IT项目管理课程设计','Web前端技术','IT文档规范与编写','IPhone开发入门','CMMI标准工作流程','JAVA EE商用项目实践','项目开发模型','企业职业素养训练')";
        }else if(type==3){
            hsql = hsql + "and g.gkcm in ('Java语言基础','Java在移动通信中应用','网页设计','网页设计课程设计','数据库应用技术','JSP应用技术与AJAX','JSP应用技术与AJAX课程设计','SSH应用技术','SSH应用技术课程设计','IPhone/android嵌入式移动开发技术基础','IPhone/android嵌入式移动开发技术','软件测试技术与工具','IT项目管理','IT项目管理课程设计','Web前端技术','IT文档规范与编写','IPhone开发入门','CMMI标准工作流程','JAVA EE商用项目实践','项目开发模型','企业职业素养训练') and (g.gfslx = 1 and g.gcj = '不及格' and g.gbkcj = '不及格') or (g.gfslx = 2 and CONVERT(g.gcj , SIGNED) < 60 and CONVERT(g.gbkcj , SIGNED) < 60)";
        }
        List<Long> data = (List<Long>) hibernateTemplate.find(hsql,sid);
        if(!data.isEmpty()) {
            System.out.println("查询总科目："+data.get(0)+"----------------------");
            return new Integer(String.valueOf(data.get(0)));
        }
        return 0;
    }
}
