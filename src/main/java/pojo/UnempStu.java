package pojo;

import java.sql.Date;

/**
 * Created by TianYu on 2016/10/28.
 */
public class UnempStu {
    private Integer sid;
    private String sno;
    private String sname;
    private Boolean ssex;
    private Date sbirth;
    private String spro;
    private Integer sgrade;
    private Integer sclass;
    private String sphone;
    private String semail;
    private String scode;
    private Integer smark;
    private String sassess;
    private Integer sstate;
    private String sdetail;
    private String jname;
    private Integer uesalary;
    private Date uetime;
    private String ueschool;
    private String uemajor;
    private Integer uesuccess;

    public UnempStu() {
    }

    public UnempStu(Integer sid, String sno, String sname, Boolean ssex, Date sbirth, String spro, Integer sgrade, Integer sclass, String sphone, String semail, String scode, Integer smark, String sassess, Integer sstate, String sdetail, String jname, Integer uesalary, Date uetime, String ueschool, String uemajor, Integer uesuccess) {
        this.sid = sid;
        this.sno = sno;
        this.sname = sname;
        this.ssex = ssex;
        this.sbirth = sbirth;
        this.spro = spro;
        this.sgrade = sgrade;
        this.sclass = sclass;
        this.sphone = sphone;
        this.semail = semail;
        this.scode = scode;
        this.smark = smark;
        this.sassess = sassess;
        this.sstate = sstate;
        this.sdetail = sdetail;
        this.jname = jname;
        this.uesalary = uesalary;
        this.uetime = uetime;
        this.ueschool = ueschool;
        this.uemajor = uemajor;
        this.uesuccess = uesuccess;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Boolean getSsex() {
        return ssex;
    }

    public void setSsex(Boolean ssex) {
        this.ssex = ssex;
    }

    public Date getSbirth() {
        return sbirth;
    }

    public void setSbirth(Date sbirth) {
        this.sbirth = sbirth;
    }

    public String getSpro() {
        return spro;
    }

    public void setSpro(String spro) {
        this.spro = spro;
    }

    public Integer getSgrade() {
        return sgrade;
    }

    public void setSgrade(Integer sgrade) {
        this.sgrade = sgrade;
    }

    public Integer getSclass() {
        return sclass;
    }

    public void setSclass(Integer sclass) {
        this.sclass = sclass;
    }

    public String getSphone() {
        return sphone;
    }

    public void setSphone(String sphone) {
        this.sphone = sphone;
    }

    public String getSemail() {
        return semail;
    }

    public void setSemail(String semail) {
        this.semail = semail;
    }

    public String getScode() {
        return scode;
    }

    public void setScode(String scode) {
        this.scode = scode;
    }

    public Integer getSmark() {
        return smark;
    }

    public void setSmark(Integer smark) {
        this.smark = smark;
    }

    public String getSassess() {
        return sassess;
    }

    public void setSassess(String sassess) {
        this.sassess = sassess;
    }

    public Integer getSstate() {
        return sstate;
    }

    public void setSstate(Integer sstate) {
        this.sstate = sstate;
    }

    public String getSdetail() {
        return sdetail;
    }

    public void setSdetail(String sdetail) {
        this.sdetail = sdetail;
    }

    public String getJname() {
        return jname;
    }

    public void setJname(String jname) {
        this.jname = jname;
    }

    public Integer getUesalary() {
        return uesalary;
    }

    public void setUesalary(Integer uesalary) {
        this.uesalary = uesalary;
    }

    public Date getUetime() {
        return uetime;
    }

    public void setUetime(Date uetime) {
        this.uetime = uetime;
    }

    public String getUeschool() {
        return ueschool;
    }

    public void setUeschool(String ueschool) {
        this.ueschool = ueschool;
    }

    public String getUemajor() {
        return uemajor;
    }

    public void setUemajor(String uemajor) {
        this.uemajor = uemajor;
    }

    public Integer getUesuccess() {
        return uesuccess;
    }

    public void setUesuccess(Integer uesuccess) {
        this.uesuccess = uesuccess;
    }
}
