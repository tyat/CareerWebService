package control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.CmCompany;
import pojo.Company;
import service.CompanyService;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by TianYu on 2016/10/27.
 */
@Controller
@RequestMapping("/company")
public class CompanyCtrl {
    @Autowired
    private CompanyService companyService;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String index(){
        return "index";
    }

     /*根据id查询*/
    @RequestMapping(value = "/findById")
    @ResponseBody
    public Company findById(int cid){
        return companyService.findByCid(cid);
    }

    /*根据公司名模糊查询*/
    @RequestMapping(value = "/findByName")
    @ResponseBody
    public List<CmCompany> findByName(String cname) throws UnsupportedEncodingException {
        String tn = new String(cname.getBytes("iso-8859-1"),"utf-8");
        return companyService.findByName(tn);
    }

    /*根据HR姓名模糊查询*/
    @RequestMapping(value = "/findByHR")
    @ResponseBody
    public List<CmCompany> findByHR(String chr) throws UnsupportedEncodingException {
        String tn = new String(chr.getBytes("iso-8859-1"),"utf-8");
        return companyService.findByHR(tn);
    }

}
