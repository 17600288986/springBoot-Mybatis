package com.forezp.web;

import com.forezp.entity.Account;
import com.forezp.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by fangzhipeng on 2017/4/20.
 */
@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountService accountService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Account> getAccoulistnts() {
        return accountService.findAccountList();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Account getAccountById(@PathVariable("id") int id) {
        return accountService.findAccount(id);
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public String updateAccount(@PathVariable("id") int id, @RequestParam(value = "name", required = false) String name,
                                @RequestParam(value = "money", required = false) BigDecimal money) {
        int t = accountService.update(name, money, id);
        if (t == 1) {
            return "success";
        } else {
            return "fail";
        }

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable(value = "id") Integer id) {
        int t = accountService.delete(id);
        if (t == 1) {
            return "success";
        } else {
            return "fail";
        }

    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String postAccount(@RequestParam(value = "name") String name,
                              @RequestParam(value = "money") double money) {

        int t = accountService.add(name, money);
        if (t == 1) {
            return "success";
        } else {
            return "fail";
        }

    }


}