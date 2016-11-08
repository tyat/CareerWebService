package pojo;

import java.util.Date;

/**
 * Created by TianYu on 2016/11/1.
 */
public class StuGrade {
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
    private Integer bxxx;/*必修学分*/
    private Integer xxxx;/*选修学分*/
    private Integer zkmu;/*总科目数*/
    private Integer zxkm;/*中兴科目数*/
    private Integer qxkm;/*清考科目数*/
    private Integer zxqk;/*中兴清考科目数*/

    public StuGrade() {
    }

    public StuGrade(Integer sid, String sno, String sname, Boolean ssex, Date sbirth, String spro, Integer sgrade, Integer sclass, String sphone, String semail, String scode, Integer smark, String sassess, Integer sstate, String sdetail, Integer bxxx, Integer xxxx, Integer zkmu, Integer zxkm, Integer qxkm, Integer zxqk) {
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
        this.bxxx = bxxx;
        this.xxxx = xxxx;
        this.zkmu = zkmu;
        this.zxkm = zxkm;
        this.qxkm = qxkm;
        this.zxqk = zxqk;
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

    public Integer getBxxx() {
        return bxxx;
    }

    public void setBxxx(Integer bxxx) {
        this.bxxx = bxxx;
    }

    public Integer getXxxx() {
        return xxxx;
    }

    public void setXxxx(Integer xxxx) {
        this.xxxx = xxxx;
    }

    public Integer getZkmu() {
        return zkmu;
    }

    public void setZkmu(Integer zkmu) {
        this.zkmu = zkmu;
    }

    public Integer getZxkm() {
        return zxkm;
    }

    public void setZxkm(Integer zxkm) {
        this.zxkm = zxkm;
    }

    public Integer getQxkm() {
        return qxkm;
    }

    public void setQxkm(Integer qxkm) {
        this.qxkm = qxkm;
    }

    public Integer getZxqk() {
        return zxqk;
    }

    public void setZxqk(Integer zxqk) {
        this.zxqk = zxqk;
    }
}
