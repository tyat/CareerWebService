package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.orm.hibernate4.HibernateTemplate;
import pojo.CmCompany;
import pojo.Company;
import java.util.List;

/**
 * Created by TianYu on 2016/10/27.
 */
@Service("companyService")
public class CompanyService {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    /*根据id查询企业*/
    public Company findByCid(int cid){
        String  hsql="select new pojo.Company(c.cid,c.cname,a.aprovince,a.acity,c.chr,c.cphone,c.cemail,c.cinfo,c.cmark,c.caddress,c.ctime) " +
                "from pojo.CmCompany c inner join c.cmAreaByAid a where c.cid=?";
        List<Company> cmCompanies =(List<Company>) hibernateTemplate.find(hsql,cid);
        return cmCompanies.get(0);
    }

    /*根据企业名模糊查询*/
    public List<CmCompany> findByName(String cname){
        String hql="from CmCompany c where c.cname like ?";
        List<CmCompany> cmCompanies = (List<CmCompany>) hibernateTemplate.find(hql,"%"+cname+"%");
        return cmCompanies;
    }

    /*根据企业联系人模糊查询*/
    public List<CmCompany> findByHR(String chr){
        String hql="from CmCompany c where c.chr like ?";
        List<CmCompany> cmCompanies = (List<CmCompany>) hibernateTemplate.find(hql,"%"+chr+"%");
        return cmCompanies;
    }


}
