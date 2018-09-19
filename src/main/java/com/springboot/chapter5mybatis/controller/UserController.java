package com.springboot.chapter5mybatis.controller;

import com.springboot.chapter5mybatis.pojo.User;
import com.springboot.chapter5mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService = null;

    /**
     * 第九章
     */
    //   http://localhost:8080/user/details?id=2
    //展示用户详情
    @RequestMapping("details")
    public ModelAndView details(Long id){
        //访问模型得到数据
        User user = userService.getUser(id);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("user/details");
        mv.addObject("user",user);
        return mv;
    }

    //  http://localhost:8080/user/table
    @RequestMapping("/table")
    public ModelAndView table(){
        System.out.println("table...........");
        //访问模型层得到数据
        List<User> userList = userService.findUsers(null,null);
        //模型和视图
        ModelAndView mv = new ModelAndView();
        //定义模型视图
        mv.setViewName("user/table");
        //加入模型数据
        mv.addObject("userList",userList);
        //返回模型和视图
        return mv;
    }

    //   http://localhost:8080/user/list    查询表所有
    //  http://localhost:8080/user/list?userName=张三&note=爱面子    条件查询
    @RequestMapping("/list")
    @ResponseBody
    public List<User> list(
            @RequestParam(value = "userName",required = false) String userName,
            @RequestParam(value = "note",required = false) String note){
        //访问模型层得到数据
        List<User> userList = userService.findUsers(userName,note);
        System.out.println("list.............");
        System.out.println(userList);
        return userList;
    }

    /**
     * 第十章
     */
    /**
     * 打开请求页面
     * @return字符串，指向页面
     */
    @GetMapping("/add")
    public String add(){
        return "/user/add";
    }

    /**
     * 新增用户
     * @param user 通过@RequestBody 注解得到JSON数据
     * @return 回填 id 后的用户信息
     */
    @PostMapping("/insert")
    @ResponseBody
    public User insert(@RequestBody User user){
        userService.insertUser(user);
        return user;
    }
    /**
     * 通过 URL 传递参数
     *   http://localhost:8080/user/2
     */
    //{...}代表占位符，还可以配置参数名称
    @GetMapping("/{id}")
    @ResponseBody
    //@PathVariable 通过名称获取参数
    public User get(@PathVariable("id") Long id){
        return userService.getUser(id);
    }

    /**    http://localhost:8080/user/converter?user=1-user_name_1-note_1
     * 调用自定义的 字符串转换器
     * @param user
     * @return
     */
    @GetMapping("/converter")
    @ResponseBody
    public User getUserByConverter(User user){
        return user;
    }

    /**
<<<<<<< HEAD
     *  http://localhost:8080/user/listConverter?userList=1-user_name_1-note_1,2-user_name_2-note_2,3-user_name_3-note_3
=======
	 * http://localhost:8080/user/listConverter?userList=1-user_name_1-note_1,2-user_name_2-note_2,3-user_name_3-note_3
>>>>>>> 87ce9353ef42b8a385345238dfc72b8c5682b278
     * 调用自定义的 字符串转换器
     * @param userList
     * @return
     */
    @GetMapping("/listConverter")
    @ResponseBody
    public List<User> listConverter(List<User> userList){
        return userList;
    }




}
