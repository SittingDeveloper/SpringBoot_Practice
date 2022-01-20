package com.study.springboot;

import com.study.springboot.dao.ISimpleBbsDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class MyController {

    @Autowired
    ISimpleBbsDao dao;

    @RequestMapping("/")
    public String root() throws Exception {
        // MyBatis : SimpleBBS
        return "redirect:list";
    }

    @RequestMapping("/list")
    public String userlistPage(Model model) {
        model.addAttribute("list", dao.listDao());

        int nTotalCount = dao.articleCount();
        System.out.println("Count : " + nTotalCount);

        return "list";
    }

    /*
    @RequestMapping("/view")
    public String view(HttpServletRequest request, Model model) {
        String sId = request.getParameter("id");
        model.addAttribute("dto", dao.viewDao(sId));
        return "view";
    }
     */


    @RequestMapping("/view")
    public String view(@Param ("IID") @RequestParam("id") String id, Model model) {
        model.addAttribute("dto", dao.viewDao(id));
        return "view";
    }

    @RequestMapping("/writeForm")
    public String writeForm() {
        return "writeForm";
    }

    @RequestMapping("/write")
    public String write(HttpServletRequest request, Model model) {

        String sName = request.getParameter("writer");
        String sTitle = request.getParameter("title");
        String sContent = request.getParameter("content");

        Map<String, String> map = new HashMap<String, String>();

        map.put("item1", sName);
        map.put("item2", sTitle);
        map.put("item3", sContent);

        int nResult = dao.writeDao(map);
        System.out.println("Write : " + nResult); // insert 성공하면 1, 실패하면 0 Return

        return "redirect:list";
    }

    @RequestMapping("/delete")
    public String delete(HttpServletRequest request, Model model) {

        String sId = request.getParameter("id");
        int nResult = dao.deleteDao(sId);
        System.out.println("Delete : " + nResult);

        // dao.deleteDao(request.getParameter("id"));
        return "redirect:list";
    }
}