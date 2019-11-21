package cn.wolfcode.springboot.ssm.web.controller;

import cn.wolfcode.springboot.ssm.domain.Employee;
import cn.wolfcode.springboot.ssm.query.EmpQueryObject;
import cn.wolfcode.springboot.ssm.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/emp")
public class EmployeeController {
	@Autowired
	private IEmployeeService service;
	
	@RequestMapping("/list")
	public String list(@ModelAttribute("qo") EmpQueryObject qo , Model model) {
	    //int i = 1/0;
		model.addAttribute("result", service.allList(qo));
		return "list";
	}
	
	@RequestMapping("/remove")
	public String remove(Employee emp) {
		service.remove(emp.getId());
		return "redirect:/emp/list";
	}
	
	@RequestMapping("/input")
	public String input(Employee emp,Model model) {
		if (emp.getId() != null) {
			model.addAttribute("emp", service.get(emp.getId()));
		}
		return "input";
	}
	@RequestMapping("/save")
	public String save(Employee emp) {
		service.save(emp);
		return "redirect:/emp/list";
	}
}
