package pojo;

import java.util.Collection;
import java.util.Date;

/**
 * Created by LENOVO on 2016/10/20.
 */
public class CmCompany {
    private Integer cid;
    private String cname;
    private String chr;
    private String cphone;
    private String cemail;
    private String cinfo;
    private String cmark;
    private String caddress;
    private Date ctime;
    private Integer cstate;
    private CmArea cmAreaByAid;
    private Collection<CmRecruit> cmRecruitsByCid;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getChr() {
        return chr;
    }

    public void setChr(String chr) {
        this.chr = chr;
    }

    public String getCphone() {
        return cphone;
    }

    public void setCphone(String cphone) {
        this.cphone = cphone;
    }

    public String getCemail() {
        return cemail;
    }

    public void setCemail(String cemail) {
        this.cemail = cemail;
    }

    public String getCinfo() {
        return cinfo;
    }

    public void setCinfo(String cinfo) {
        this.cinfo = cinfo;
    }

    public String getCmark() {
        return cmark;
    }

    public void setCmark(String cmark) {
        this.cmark = cmark;
    }

    public String getCaddress() {
        return caddress;
    }

    public void setCaddress(String caddress) {
        this.caddress = caddress;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public Integer getCstate() {
        return cstate;
    }

    public void setCstate(Integer cstate) {
        this.cstate = cstate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CmCompany cmCompany = (CmCompany) o;

        if (cid != null ? !cid.equals(cmCompany.cid) : cmCompany.cid != null) return false;
        if (cname != null ? !cname.equals(cmCompany.cname) : cmCompany.cname != null) return false;
        if (chr != null ? !chr.equals(cmCompany.chr) : cmCompany.chr != null) return false;
        if (cphone != null ? !cphone.equals(cmCompany.cphone) : cmCompany.cphone != null) return false;
        if (cemail != null ? !cemail.equals(cmCompany.cemail) : cmCompany.cemail != null) return false;
        if (cinfo != null ? !cinfo.equals(cmCompany.cinfo) : cmCompany.cinfo != null) return false;
        if (cmark != null ? !cmark.equals(cmCompany.cmark) : cmCompany.cmark != null) return false;
        if (caddress != null ? !caddress.equals(cmCompany.caddress) : cmCompany.caddress != null) return false;
        if (ctime != null ? !ctime.equals(cmCompany.ctime) : cmCompany.ctime != null) return false;
        if (cstate != null ? !cstate.equals(cmCompany.cstate) : cmCompany.cstate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cid != null ? cid.hashCode() : 0;
        result = 31 * result + (cname != null ? cname.hashCode() : 0);
        result = 31 * result + (chr != null ? chr.hashCode() : 0);
        result = 31 * result + (cphone != null ? cphone.hashCode() : 0);
        result = 31 * result + (cemail != null ? cemail.hashCode() : 0);
        result = 31 * result + (cinfo != null ? cinfo.hashCode() : 0);
        result = 31 * result + (cmark != null ? cmark.hashCode() : 0);
        result = 31 * result + (caddress != null ? caddress.hashCode() : 0);
        result = 31 * result + (ctime != null ? ctime.hashCode() : 0);
        result = 31 * result + (cstate != null ? cstate.hashCode() : 0);
        return result;
    }

    public CmArea getCmAreaByAid() {
        return cmAreaByAid;
    }

    public void setCmAreaByAid(CmArea cmAreaByAid) {
        this.cmAreaByAid = cmAreaByAid;
    }

    public Collection<CmRecruit> getCmRecruitsByCid() {
        return cmRecruitsByCid;
    }

    public void setCmRecruitsByCid(Collection<CmRecruit> cmRecruitsByCid) {
        this.cmRecruitsByCid = cmRecruitsByCid;
    }
}
