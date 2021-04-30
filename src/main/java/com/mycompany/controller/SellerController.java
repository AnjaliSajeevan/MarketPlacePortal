/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import com.mycompany.dao.CategoryDao;
import com.mycompany.dao.OrderItemDao;
import com.mycompany.dao.OrdersDao;
import com.mycompany.dao.ProductDao;
import com.mycompany.dao.UserDao;
import com.mycompany.exceptionHandling.AdException;
import com.mycompany.pojo.Category;
import com.mycompany.pojo.OrderItem;
import com.mycompany.pojo.Orders;
import com.mycompany.pojo.Product;
import com.mycompany.pojo.User;
import com.mycompany.utility.UploadFile;
import com.mycompany.validator.ProductValidator;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Anjali
 */
@Controller
@RequestMapping("/Seller")
public class SellerController {

    Product product;
    CategoryDao categorydao;
    Category department;
    ProductDao productdao;
    UserDao userdao;
    CategoryDao departmentDao;
    OrdersDao orderdao;
    private List<Product> productList;
    OrderItem orderitem;
    OrderItemDao orderitemdao;
    ProductValidator productValidator;
    
    @Autowired
    SellerController(ProductDao productdao, CategoryDao categorydao,UserDao userdao,CategoryDao departmentDao,OrdersDao orderdao,OrderItemDao orderitemdao,ProductValidator productValidator) {
        this.categorydao = categorydao;
        this.departmentDao = departmentDao;
        this.userdao=userdao;
        this.productdao = productdao;
        this.orderdao=orderdao;
        this.orderitem=orderitem;
        this.orderitemdao=orderitemdao;
        this.productValidator=productValidator;
    }

    @RequestMapping(value = "/sellerHomePage", method = RequestMethod.GET)
    public ModelAndView sellerHomePage(HttpSession session) throws AdException {
        ModelAndView mv;
        String role = (String) session.getAttribute("role");
        if (role.equals("seller")) {
            List<Product> productList = productdao.getProductList();
            mv = new ModelAndView("sellermainPage");
            mv.addObject("products", productList);
            mv.addObject("clickHome", true);
            mv.addObject("title", "Home Page");
        } else {
            mv = new ModelAndView("noaccess");
            mv.addObject("Customer", true);
        }
        return mv;
    }

    @RequestMapping(value = "/department", method = RequestMethod.GET)
    public ModelAndView formDepartment(@ModelAttribute("department") Category department, SessionStatus status, HttpSession session) throws AdException {
        ModelAndView mv;
        List<Category> categorylist = null;
        String role = (String) session.getAttribute("role");
        if (role.equals("seller")) {
            categorylist = categorydao.getDepartmentList();
            categorydao.close();
            status.setComplete();
            mv = new ModelAndView("sellermainPage");
            mv.addObject("addDepartment", true);
            mv.addObject("title", "Add Department");
            mv.addObject("departmentlist",  categorylist);
        } else {
            mv = new ModelAndView("noaccess");
            mv.addObject("Customer", true);
        }
        return mv;
    }
    
    @RequestMapping(value = "/department", method = {RequestMethod.POST}, params = "save")
    public String addDepartment(@Valid @ModelAttribute("department") Category department,BindingResult result,Model model, HttpSession session, SessionStatus status) throws AdException {
        ModelAndView mv;

        String role = (String) session.getAttribute("role");
        if (role.equals("seller")) {
              if(result.hasErrors()){
            List<Category>categories = categorydao.getDepartmentList();
            categorydao.close();
             mv = new ModelAndView("sellermainPage");
            mv.addObject("addDepartment", true);
            mv.addObject("title", "Add Department");
            mv.addObject("departmentlist",  categories);
            return "sellermainPage";
            }

            boolean output = categorydao.addDepartment(department);
            categorydao.close();
            status.setComplete();

        }

        return "redirect:/Seller/department";
    }

    @RequestMapping(value = "/department", method = {RequestMethod.POST}, params = "update")
    public String updateDepartment(@Valid @ModelAttribute("department") Category department,BindingResult result,Model model, HttpSession session, SessionStatus status) throws AdException {
        List<Category> categorylist = null;
         ModelAndView mv;
        String role = (String) session.getAttribute("role");
        if (role.equals("seller")) {
            int id=department.getCategoryid();
            if (result.hasErrors()) {
                List<Category> categories = categorydao.getDepartmentList();
                categorydao.close();
                model.addAttribute("addDepartment", true);
                model.addAttribute("title", "Add Department");
                model.addAttribute("departmentlist", categories);
                return "sellermainPage";
            }
            categorydao.updateDepartment(department);
            categorylist = categorydao.getDepartmentList();
            categorydao.close();
            status.setComplete();
       

        } 

        return "redirect:/Seller/department";
    }

    @RequestMapping(value = "/{id}/deleteDepartment", method = RequestMethod.GET)
    public String deleteDepartment(@PathVariable int id,SessionStatus status, HttpSession session) throws AdException {
        ModelAndView mv;
        
        String role = (String) session.getAttribute("role");
        if (role.equals("seller")) {
         Category category = categorydao.getEachDepartment(id);
            categorydao.delete(category);
            categorydao.close();
            status.setComplete();
            
            
        } 
        return "redirect:/Seller/department";
    }

    
     @RequestMapping(value = "/{id}/updateDepartment", method = RequestMethod.GET)
    public ModelAndView updateDepartment(@ModelAttribute("department") Category department,@PathVariable int id,SessionStatus status, HttpSession session) throws AdException {
        ModelAndView mv;
        List<Category> categorylist = null;
        String role = (String) session.getAttribute("role");
        if (role.equals("seller")) {
            Category category = categorydao.getEachDepartment(id);
            categorylist = categorydao.getDepartmentList();
            categorydao.close();
            status.setComplete();
            mv = new ModelAndView("sellermainPage");
            mv.addObject("addDepartment", true);
            mv.addObject("category", category);
            mv.addObject("title", "Add Department");
            mv.addObject("departmentlist",  categorylist);
        }else {
            mv = new ModelAndView("noaccess");
            mv.addObject("Customer", true);
        
        }
        return mv;
    }
    

        
     @RequestMapping(value = "/manageProducts", method = RequestMethod.GET)
    public ModelAndView formProducts(HttpSession session) throws AdException {
        ModelAndView mv;
           String role = (String) session.getAttribute("role");
             String email = (String) session.getAttribute("email");
        if (role.equals("seller")) {
            mv = new ModelAndView("sellermainPage");
            User user=userdao.checkEmail(email);
            userdao.close();
            productList = productdao.getUserProductList(user);
            productdao.close();
            mv.addObject("manageProduct", true);
            mv.addObject("products", productList);
            mv.addObject("title", "Manage Product");
        } else {
            mv = new ModelAndView("noaccess");
            mv.addObject("Customer", true);
        }
        return mv;
    }
    
 
        @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public ModelAndView dashBoard(HttpSession session) throws AdException {
        ModelAndView mv;
        
        List<OrderItem> orderItemsSeller=new ArrayList<OrderItem>();
       
        String email = (String) session.getAttribute("email");
        String role = (String) session.getAttribute("role");
        if (role.equals("seller")) {
            User user=userdao.checkEmail(email);
            List<Orders> orderList =orderdao.getOrdersList();
            for(Orders order:orderList){
            List<OrderItem> orderItems = orderitemdao.getOrderItemList(order);
            for(OrderItem orderitem:orderItems){
                if(orderitem.getProduct().getUser().getUserid()==user.getUserid()){
                    orderItemsSeller.add(orderitem);
                    
            }
            }
            }
            orderdao.close();
            mv = new ModelAndView("sellermainPage");
            mv.addObject("dashboard", true);
            mv.addObject("title", "Dashboard");
            mv.addObject("orders",orderItemsSeller);
        } else {
            mv = new ModelAndView("noaccess");
            mv.addObject("Customer", true);
        }
        return mv;
    }
    
    
    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public ModelAndView formProducts(@ModelAttribute("product") Product product, HttpSession session) throws AdException {
        ModelAndView mv;
           String role = (String) session.getAttribute("role");
        if (role.equals("seller")) {
            List<Category>categories = categorydao.getDepartmentList();
            categorydao.close();
            mv = new ModelAndView("sellermainPage");
            mv.addObject("addProduct", true);
            mv.addObject("title", "Add Product");
            mv.addObject("categories",categories);
        } else {
            mv = new ModelAndView("noaccess");
            mv.addObject("Customer", true);
        }
        return mv;
    }
    
   

    @RequestMapping(value = "/productsadded", method = RequestMethod.POST)
    public String manageProducts(@Valid @ModelAttribute("product") Product product,BindingResult result,Model model, HttpServletRequest request, HttpSession session, SessionStatus status) throws IOException, AdException {
       
        String email = (String) session.getAttribute("email");
        String role = (String) session.getAttribute("role");
        User user = userdao.getUser(email);
        userdao.close();
       
            productValidator.validate(product, result);
            if(result.hasErrors()){
            List<Category>categories = categorydao.getDepartmentList();
            categorydao.close();
            model.addAttribute("addProduct", true);
            model.addAttribute("title", "Add Product");
            model.addAttribute("categories",categories);
            return "sellermainPage";
            }
            product.setImageURL(product.getFile().getOriginalFilename());
            product.setUser(user);
            product.setViews(0);
            product.setPurchases(0);
            productdao.addProduct(product);
            productdao.close();
                if (!product.getImageURL().equals("")) {
                    UploadFile.addFile(request, product.getFile(), product.getImageURL());
                }

            status.setComplete();
          
       
        return "redirect:/Seller/products";
    }

        
    
  @RequestMapping(value = "/{id}/updateproduct", method = RequestMethod.GET)
    public ModelAndView editProducts(@PathVariable int id, HttpSession session,SessionStatus status) throws IOException, AdException {
    ModelAndView mv = null;
        String role = (String) session.getAttribute("role");
        if (role.equals("seller")) {
            mv = new ModelAndView("sellermainPage");
            Product product = productdao.getEachProduct(id);
            productdao.close();
            status.setComplete();
            int categoryid = product.getCategoryid();
            department = departmentDao.getEachDepartment(categoryid);
            departmentDao.close();
            String productName = product.getName();
            mv.addObject("title", productName);
            mv.addObject("product", product);
            mv.addObject("category", department);
            mv.addObject("updateProducts", true);
            } 
          
        else {
            mv = new ModelAndView("noaccess");
            mv.addObject("Customer", true);
        }
        return mv;
    }

    @RequestMapping(value = "/updateProductResult", method = RequestMethod.POST)
    public ModelAndView updateProducts(@ModelAttribute("product") Product product, HttpSession session, SessionStatus status) throws IOException, AdException {
        ModelAndView mv = null;
        String email = (String) session.getAttribute("email");
        String role = (String) session.getAttribute("role");
        if (role.equals("seller")) {
            mv = new ModelAndView("sellermainPage");
            User user=userdao.checkEmail(email);
            product.setUser(user);
            productdao.updateproduct(product);
            productdao.close();
            int categoryid = product.getCategoryid();
            department = departmentDao.getEachDepartment(categoryid);
            departmentDao.close();
              
            List<Product> productLists;
            productLists = productdao.getUserProductList(user);
            productdao.close();
            mv.addObject("manageProduct", true);
            mv.addObject("products", productLists);
            mv.addObject("title", "Manage Product");
            
            status.setComplete();
          
        } else {
            mv = new ModelAndView("noaccess");
            mv.addObject("Customer", true);
        }
        return mv;
    }
    
    
    @RequestMapping(value = "/{id}/deleteproduct", method = RequestMethod.GET)
    public ModelAndView deleteProducts(@PathVariable int id, HttpSession session, SessionStatus status) throws IOException, AdException {
        ModelAndView mv = null;
         String email = (String) session.getAttribute("email");
        String role = (String) session.getAttribute("role");
        if (role.equals("seller")) {
            mv = new ModelAndView("sellermainPage");
            Product product = productdao.getEachProduct(id);
            productdao.delete(product);
            status.setComplete();
            List<Product> productLists;
            User user=userdao.checkEmail(email);
            productLists = productdao.getUserProductList(user);
            productdao.close();
            mv.addObject("manageProduct", true);
            mv.addObject("products", productLists);
            mv.addObject("title", "Manage Product");
        } else {
            mv = new ModelAndView("noaccess");
            mv.addObject("Customer", true);
        }
        return mv;
    }
    
    
    @RequestMapping(value = "/{id}/processOrder", method = RequestMethod.GET)
    public String processOrder(@PathVariable int id, HttpSession session, SessionStatus status) throws IOException, AdException {
          String role = (String) session.getAttribute("role");
        if (role.equals("seller")) {
           
            OrderItem orderitem = orderitemdao.getEachOrderItem(id);
            orderitem.setStatus("OrderItem Processed");
            orderitemdao.updateOrderItem(orderitem);

    }
 return "redirect:/Seller/dashboard";
}
    
       @RequestMapping(value = "/{id}/delievered", method = RequestMethod.GET)
    public String OrderDelivered(@PathVariable int id, HttpSession session, SessionStatus status) throws IOException, AdException {
       
        String role = (String) session.getAttribute("role");
        if (role.equals("seller")) {
           
            OrderItem orderitem = orderitemdao.getEachOrderItem(id);
            orderitem.setStatus("OrderItem Delivered");
            orderitemdao.updateOrderItem(orderitem);

    }
        return "redirect:/Seller/dashboard";
    }
    
         @RequestMapping(value = "/{id}/cancelOrder", method = RequestMethod.GET)
    public String OrderCancelled(@PathVariable int id, HttpSession session, SessionStatus status) throws IOException, AdException {
          String role = (String) session.getAttribute("role");
        if (role.equals("seller")) {
           
            OrderItem orderitem = orderitemdao.getEachOrderItem(id);
            orderitem.setStatus("OrderItem Cancelled");
            orderitemdao.updateOrderItem(orderitem);

    }
 return "redirect:/Seller/dashboard";
}
    
    
    @RequestMapping(value = "/signout", method = RequestMethod.GET)
    public ModelAndView showEachProduct(HttpSession session) {
        ModelAndView mv = new ModelAndView("usermainPage");
        mv.addObject("title", "Home");
        mv.addObject("clickHome", true);
        session.invalidate();
        return mv;
    }
}
