package myssm.controller;

import myssm.domain.Account;
import myssm.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @RequestMapping("/save")
    public String save(Account account){
        accountService.save(account);
        return "redirect:/account/all";
    }

    @RequestMapping("/all")
    public ModelAndView findAll(){
        ModelAndView modelAndView=new ModelAndView();
        List<Account> accountList = accountService.findAll();
        modelAndView.addObject("accountList",accountList);
        modelAndView.setViewName("accountList");
        return modelAndView;
    }
}
