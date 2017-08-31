package ru.neustupov.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import ru.neustupov.model.User;
import ru.neustupov.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    private static int id = 0;

    @Autowired
    private UserService userService;

    /**
     * Создание нового пользователя.
     * <p>
     * Если пользователя нет (id == 0), создаём нового. Если есть, обновляем того, что есть.
     *
     * @param user
     * @return редирект в root
     */
    @RequestMapping(value = "users/add", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("user") User user) {
        if (user.getId() == 0) userService.add(user);
        else userService.edit(user);
        return "redirect:/";
    }

    /**
     * Удаление пользователя по ID.
     *
     * @param id
     * @return редирект в root
     */
    @RequestMapping("/remove/{id}")
    public String removeUser(@PathVariable("id") int id) {
        this.userService.delete(id);
        return "redirect:/";
    }

    /**
     * Изменение данных пользователя.
     * <p>
     * Метод получает id и экземпляр модели.
     *
     * @param id
     * @param model
     * @return редирект в root
     */
    @RequestMapping("/edit/{id}")
    public String editUser(@PathVariable("id") int id, Model model) {
        UserController.id = id;
        model.addAttribute("listUsers", userService.getAllUsers());
        return "redirect:/";
    }

    @RequestMapping("userdata{id}")
    public String userData(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "redirect:/";
    }

    /**
     * Метод пейджинга.
     * <p>
     * Он срабатывает при запросе "/". Далее происходит следующее:
     * В метод передаётся номер страницы и поисковый запрос в String, если он есть.
     * Далее — если запрос есть — список наполняется только объектами User, имена которых содержат строку запроса.
     * Если его нет — копируется основной список.
     * <p>
     * Список отправляется в модель, которую и возвращает метод.
     *
     * @param page     — номер страницы.
     * @param userName — поисковый запрос.
     * @return модель, аттрибуты которой участвуют при наполнении списка.
     */
    @RequestMapping(value = "/")
    public ModelAndView listOfUsers(@RequestParam(required = false) Integer page,
                                    @RequestParam(required = false) String userName) {
        ModelAndView modelAndView = new ModelAndView("index");
        if (id != 0) {
            modelAndView.addObject("user", userService.getUser(id));
            id = 0;
        } else {
            modelAndView.addObject("user", new User());
        }

        List<User> users = null;
        if (userName == null || userName.length() < 3) {
            users = userService.getAllUsers();
        } else {
            List<User> tempUsers = userService.getAllUsers();
            users = new ArrayList<User>();
            for (User tempUser : tempUsers) {
                if (tempUser.getName().toLowerCase().contains(userName.toLowerCase())) {
                    System.out.println("filter: " + tempUser);
                    users.add(tempUser);
                }
            }
        }
        PagedListHolder<User> pagedListHolder = new PagedListHolder<User>(users);
        pagedListHolder.setPageSize(7);
        modelAndView.addObject("maxPages", pagedListHolder.getPageCount());

        if (page == null || page < 1 || page > pagedListHolder.getPageCount()) {
            page = 1;
        }

        modelAndView.addObject("page", page);
        if (page == null || page < 1 || page > pagedListHolder.getPageCount()) {
            pagedListHolder.setPage(0);
            modelAndView.addObject("listUsers", pagedListHolder.getPageList());
        } else if (page <= pagedListHolder.getPageCount()) {
            pagedListHolder.setPage(page - 1);
            modelAndView.addObject("listUsers", pagedListHolder.getPageList());
        }
        return modelAndView;
    }
}
