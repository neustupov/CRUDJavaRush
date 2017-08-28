package ru.neustupov.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import ru.neustupov.model.User;
import ru.neustupov.service.UserService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    private int recordsPerPage = 3;
    private int numberOfPages, allDataSize, page;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    @RequestMapping("/")
    public String someAction(@ModelAttribute User model, Map<String, Object> map) {
        page = 1;
        allDataSize = userService.getAllUserNumber();
        numberOfPages = allDataSize % recordsPerPage == 0 ? allDataSize / recordsPerPage :
                allDataSize / recordsPerPage + 1;
        User user = new User();
        map.put("user", user);
        map.put("usersList", userService.showOnePage(page, recordsPerPage));
        map.put("currentPage", getPage());
        map.put("noOfPages", numberOfPages);
        return "user";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:MM:SS");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @RequestMapping(value="/user.do", method=RequestMethod.GET)
    public String doActions2(
            @ModelAttribute User user,
            Map<String, Object> map,
            @RequestParam("page") String inputPage
    ){

        try {
            if (inputPage.length()==0 || inputPage==null)setPage(1);
            else{
                setPage(Integer.parseInt(inputPage));
                if (getPage()<=0)setPage(1);
            }

        } catch (Exception e) {
            System.out.println("PAGE not corrected value");
            // TODO: handle exception
        }


        allDataSize=userService.getAllUserNumber();

        numberOfPages=allDataSize%recordsPerPage==0?allDataSize/recordsPerPage:allDataSize/recordsPerPage+1;

        map.put("currentPage", getPage());
        map.put("noOfPages", numberOfPages);
        map.put("user", user);
        map.put("usersList", userService.showOnePage(page, recordsPerPage));

        return "user";

    }

    @RequestMapping(value = "/user.do", method = RequestMethod.POST)
    public String doActions(@ModelAttribute User user, BindingResult result, @RequestParam String action,
                            Map<String, Object> map) {
        User userResult = new User();
        switch (action.toLowerCase()) {
            case "add":
                userService.add(user);
                userResult = user;
                break;

            case "edit":
                userService.edit(user);
                userResult = user;
                break;

            case "delete":
                userService.delete(user.getId());
                userResult = user;
                break;

            case "search":
                User searchedUser = userService.getUser(user.getId());
                userResult = searchedUser != null ? searchedUser : new User();
                break;
        }
        map.put("user", userResult);
        map.put("usersList", userService.getAllUsers());
        return "user";

    }
}
