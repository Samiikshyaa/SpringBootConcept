package com.example.employeespring.controller;

import com.example.employeespring.service.DepartmentService;
import com.example.employeespring.view.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DepartmentController {
    @Autowired
    private DepartmentService ds;

    @GetMapping("/department/add")
    public String getAdd(){
        return "DepartmentAdd";
    }

    @PostMapping("/department/add")
    public String postadd(@ModelAttribute Department dept){
        ds.add(dept);
        return "DepartmentAdd";
    }

    @GetMapping("/department/show")
    public String showdep(Model model){
        model.addAttribute("dlist",ds.show());
        return "DepartmentList";
    }

    @GetMapping("/department/delete")
    public String deleteDepartment(@RequestParam int id){
        ds.deletedep(id);
        return "redirect:/department/show";
    }

    @GetMapping("/department/edit")
    public String editdep(@RequestParam int id, Model model){
        model.addAttribute("dmodel",ds.getById(id));
        return "DepartmentEdit";
    }

    @PostMapping("/department/update")
    public String update(@ModelAttribute Department department){
        ds.update(department);
        return "redirect:/department/show";
    }

}
