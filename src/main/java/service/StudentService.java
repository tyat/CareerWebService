package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Service;
import pojo.CmStudent;
import pojo.EmpStu;
import pojo.UnempStu;

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
            return true;/*已就业返回true*/
        }else {
            return false;/*未就业返回false*/
        }
    }

    /*已就业学生信息*/
    public EmpStu listEmpStudent(int sid){
        String hql = "select new EmpStu (cs.sid,cs.sno,cs.sname,cs.ssex,cs.sbirth,cs.spro,cs.sgrade,cs.class,cs.sphone,cs.semail,cs.scode,cs.smark,cs.sassess,cs.sstate,cs.sdetail,cj.jname,ce.etime,ce.esalary,ce.ewq,ce.eleave,ce.ereason) " +
                "from CmStudent cs inner join CmJob cj inner join CmEmp ce where cs.sid = ?";
        List<EmpStu> stu = (List<EmpStu>)hibernateTemplate.find(hql,sid);
        if (!stu.isEmpty()){
            return stu.get(0);
        }
        return null;
    }

    /*未就业学生信息*/
    public UnempStu listUnempStudent(int sid){
        String hql = "select new UnempStu (cs.sid,cs.sno,cs.sname,cs.ssex,cs.sbirth,cs.spro,cs.sgrade,cs.class,cs.sphone,cs.semail,cs.scode,cs.smark,cs.sassess,cs.sstate,cs.sdetail,cj.jname,ue.esalary,ue.uetime,ue.ueschool,ue.uemajor,ue.uesuccess) " +
                "from CmStudent cs inner join CmJob cj inner join CmUnemp ue where cs.sid = ?";
        List<UnempStu> stu = (List<UnempStu>)hibernateTemplate.find(hql,sid);
        if (!stu.isEmpty()){
            return stu.get(0);
        }
        return null;
    }

    /*查询必修学分*/
    public int queryBxxx(int sid) {
        String hsql = "select sum(g.gxf) " +
                "from CmGrade g " +
                "where g.cmStudentBySid.sid = ? " +
                "and g.glx = 0 " +
                "and ((g.gfslx = 1 and (g.gcj in ('及格','中','良','优') or g.gbkcj in ('及格','中','良','优'))) or (g.gfslx = 2 and (CONVERT(g.gcj , SIGNED) >= 60 or CONVERT(g.gbkcj , SIGNED) >= 60))) ";
        List<?> data = hibernateTemplate.find(hsql, sid);
        return Integer.parseInt(data.get(0).toString());
    }

    /*查询选修学分*/
    public int queryXxxx(int sid){
        String hsql = "select sum(g.gxf) " +
                "from CmGrade g " +
                "where g.cmStudentBySid.sid = ? " +
                "and g.glx in (1,2) " +
                "and ((g.gfslx = 1 and (g.gcj in ('及格','中','良','优') or g.gbkcj in ('及格','中','良','优'))) or (g.gfslx = 2 and (CONVERT(g.gcj , SIGNED) >= 60 or CONVERT(g.gbkcj , SIGNED) >= 60))) " ;
        List<?> data = hibernateTemplate.find(hsql,sid);
        return Integer.parseInt(data.get(0).toString());
    }

    /*查询科目总数,0总科目1清考科目2中兴科目3中兴清考科目*/
    public int queryZkms(int sid,int type){
        String hsql = "select count(*) from CmGrade g where g.cmStudentBySid.sid = ?";
        if(type==1){
            hsql = hsql + " and (g.gfslx = 1 and g.gcj = '不及格' and g.gbkcj = '不及格') or (g.gfslx = 2 and CONVERT(g.gcj , SIGNED) < 60 and CONVERT(g.gbkcj , SIGNED) < 60)";
        }else if(type==2){
            hsql = hsql + " and g.gkcm in ('Java语言基础','Java在移动通信中应用','网页设计','网页设计课程设计','数据库应用技术','JSP应用技术与AJAX','JSP应用技术与AJAX课程设计','SSH应用技术','SSH应用技术课程设计','IPhone/android嵌入式移动开发技术基础','IPhone/android嵌入式移动开发技术','软件测试技术与工具','IT项目管理','IT项目管理课程设计','Web前端技术','IT文档规范与编写','IPhone开发入门','CMMI标准工作流程','JAVA EE商用项目实践','项目开发模型','企业职业素养训练')";
        }else if(type==3){
            hsql = hsql + "and g.gkcm in ('Java语言基础','Java在移动通信中应用','网页设计','网页设计课程设计','数据库应用技术','JSP应用技术与AJAX','JSP应用技术与AJAX课程设计','SSH应用技术','SSH应用技术课程设计','IPhone/android嵌入式移动开发技术基础','IPhone/android嵌入式移动开发技术','软件测试技术与工具','IT项目管理','IT项目管理课程设计','Web前端技术','IT文档规范与编写','IPhone开发入门','CMMI标准工作流程','JAVA EE商用项目实践','项目开发模型','企业职业素养训练') and (g.gfslx = 1 and g.gcj = '不及格' and g.gbkcj = '不及格') or (g.gfslx = 2 and CONVERT(g.gcj , SIGNED) < 60 and CONVERT(g.gbkcj , SIGNED) < 60)";
        }
        List<?> data = hibernateTemplate.find(hsql,sid);
        return Integer.parseInt(data.get(0).toString());
    }
}
