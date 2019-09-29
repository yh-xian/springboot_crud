package cn.yunhe.springboot_crud.controller;

import cn.yunhe.springboot_crud.dao.DepartmentDao;
import cn.yunhe.springboot_crud.dao.EmployeeDao;
import cn.yunhe.springboot_crud.entity.Department;
import cn.yunhe.springboot_crud.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Collection;
import java.util.Optional;

@Controller
public class DemoController {

    //注入dao
    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private DepartmentDao departmentDao;

    //1.首页
    @RequestMapping({"/","/index"})
    public String index(){
        return "login"; //使用的是thymeleaf的模板引擎,在thymeleafProperties中已经定义了前缀与后缀
    }

    //2.登录
    @RequestMapping("/login")
    public String login(String username, String password, Model model, HttpSession session){

            if(username.equals("admin")&&password.equals("123")){
                //登录成功!
                //将用户的信息,保存到session
                session.setAttribute("user",username);
                return "redirect:/main";
            }else{
                model.addAttribute("msg","用户名或密码错误!");
                return "login";
            }
        }

     //3.在crud案例中,使用restful的风格 相同的访问路径,根据请求方式不同,获得的资源不同
    /**
     * 添加--POST
     * 查询--GET
     * 修改--PUT
     * 删除--DELETE
     */
    //查询所有员工 --将数据model--在页面解析
    @GetMapping("/emps")
    public String getEmps(Model model){
        //查询
        Collection<Employee> list = employeeDao.findAll();
        model.addAttribute("list",list);
        return "list";
    }
    //4.跳转到添加页面
    @GetMapping("/emp")
    public String tz_add(Model model){
        //查询部门的编号
        Collection<Department> departments = departmentDao.findAll();
        model.addAttribute("dept",departments);
        return "add";
    }

    //5.员工的添加
    @PostMapping("/emp")
    public String save(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    //6.来到修改页面
    @GetMapping("/emp/{id}")
    public String tz_update(@PathVariable Integer id,Model model){
        //1.根据id查询需要修改的员工
        Employee employee = employeeDao.findById(id).get();
        //2.
        model.addAttribute("emp",employee);

        //查询部门的编号
        Collection<Department> departments = departmentDao.findAll();
        model.addAttribute("dept",departments);
        return "add";
    }

    //7.修改
    @PutMapping("/emp")
    public String update(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }


    //8.删除
    @DeleteMapping("/emp/{id}")
    public String delete(@PathVariable Integer id){
        employeeDao.deleteById(id);
        return "redirect:/emps";
    }



































}
