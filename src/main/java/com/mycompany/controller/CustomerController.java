/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import com.lowagie.text.DocumentException;
import com.mycompany.dao.AddressDao;
import com.mycompany.dao.CartDao;
import com.mycompany.dao.CartItemDao;
import com.mycompany.dao.CategoryDao;
import com.mycompany.dao.OrderItemDao;
import com.mycompany.dao.OrdersDao;
import com.mycompany.dao.ProductDao;
import com.mycompany.dao.UserDao;
import com.mycompany.exceptionHandling.AdException;
import com.mycompany.pojo.Address;
import com.mycompany.pojo.Cart;
import com.mycompany.pojo.CartItem;
import com.mycompany.pojo.Category;
import com.mycompany.pojo.OrderItem;
import com.mycompany.pojo.Orders;
import com.mycompany.pojo.Product;
import com.mycompany.pojo.User;
import com.mycompany.view.PdfView;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Anjali
 */
@Controller
@RequestMapping("/Customer")
public class CustomerController {

    private List<Category> departmentList;
    private List<Product> productList;
    private CategoryDao departmentDao;
    private ProductDao productDao;
    private UserDao userDao;
    private AddressDao addressDao;
    private CartDao cartdao;
    private CartItemDao cartItemDao;
    private OrdersDao orderdao;
    private OrderItemDao orderItemDao;
    private PdfView pdfview;

    @Autowired
    CustomerController(CategoryDao departmentDao, ProductDao productDao, UserDao userDao, AddressDao addressDao, CartDao cartdao, CartItemDao cartItemDao, OrdersDao orderdao, OrderItemDao orderItemDao, PdfView pdfview) {
        this.departmentDao = departmentDao;
        this.productDao = productDao;
        this.userDao = userDao;
        this.addressDao = addressDao;
        this.cartdao = cartdao;
        this.cartItemDao = cartItemDao;
        this.orderdao = orderdao;
        this.orderItemDao = orderItemDao;
        this.pdfview = pdfview;

    }

    @RequestMapping(value = "/homepage")
    public ModelAndView home(HttpSession session) throws AdException {
        ModelAndView mv;
        String email = (String) session.getAttribute("email");
        String role = (String) session.getAttribute("role");
        if (role.equals("customer")) {
            User user = userDao.checkEmail(email);
            List<Product> productList = productDao.getProductList();
            mv = new ModelAndView("mainpage");
            mv.addObject("title", "Home");
            mv.addObject("products", productList);
            mv.addObject("user", user.getFirstName());
            mv.addObject("clickHome", true);

        } else {
            mv = new ModelAndView("noaccess");
            mv.addObject("Seller", true);
        }
        return mv;
    }

    @RequestMapping(value = "/account", method = RequestMethod.GET)
    public ModelAndView account(HttpSession session) throws AdException {
        ModelAndView mv;
        String email = (String) session.getAttribute("email");
        String role = (String) session.getAttribute("role");
        if (role.equals("customer")) {
            User user = userDao.checkEmail(email);
            mv = new ModelAndView("mainpage");
            mv.addObject("user", user);
            mv.addObject("username", user.getFirstName());
            mv.addObject("title", "Account");
            mv.addObject("clickAccount", true);
        } else {
            mv = new ModelAndView("noaccess");
            mv.addObject("Seller", true);
        }
        return mv;
    }

    @RequestMapping(value = "/userDetails", method = RequestMethod.GET)
    public ModelAndView userView(@ModelAttribute("user") User user, HttpSession session) throws AdException {
        ModelAndView mv;
        String email = (String) session.getAttribute("email");
        String role = (String) session.getAttribute("role");
        if (role.equals("customer")) {
            user = userDao.checkEmail(email);
            mv = new ModelAndView("mainpage");
            mv.addObject("username", user.getFirstName());
            mv.addObject("user", user);
            mv.addObject("title", "Account");
            mv.addObject("account", true);

        } else {
            mv = new ModelAndView("noaccess");
            mv.addObject("Seller", true);
        }
        return mv;
    }

    @RequestMapping(value = "/userDetails", method = RequestMethod.POST)
    public ModelAndView userUpdate(@ModelAttribute("user") User user, HttpSession session) throws AdException {
        ModelAndView mv;
        String role = (String) session.getAttribute("role");
        if (role.equals("customer")) {
            mv = new ModelAndView("mainpage");
            userDao.updateUser(user);
            userDao.close();
            mv.addObject("username", user.getFirstName());
            mv.addObject("user", user);
            mv.addObject("title", "Account");
            mv.addObject("account", true);

        } else {
            mv = new ModelAndView("noaccess");
            mv.addObject("Seller", true);
        }
        return mv;
    }

    @RequestMapping(value = "/updateShippingAddress", method = RequestMethod.GET)
    public ModelAndView viewShipping(@ModelAttribute("addresss") Address addresss, Address address, HttpSession session) throws AdException {
        ModelAndView mv;
        String email = (String) session.getAttribute("email");
        String role = (String) session.getAttribute("role");
        if (role.equals("customer")) {
            User user = userDao.checkEmail(email);
            mv = new ModelAndView("mainpage");
            if (addresss == null) {
                ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("../applicationContext.xml");
                addresss = (Address) context.getBean("address");
            } else {
                addresss = addressDao.getShippingAddress(user);
            }
            mv.addObject("username", user.getFirstName());
            mv.addObject("user", user);
            mv.addObject("address", addresss);
            mv.addObject("title", "Account");
            mv.addObject("shipping", true);

        } else {
            mv = new ModelAndView("noaccess");
            mv.addObject("Seller", true);
        }
        return mv;
    }

    @RequestMapping(value = "/updateShippingAddress", method = RequestMethod.POST)
    public String updateShipping(@Valid @ModelAttribute("addresss") Address addresss,BindingResult result,Model model, HttpSession session) throws AdException {
        ModelAndView mv;
        String email = (String) session.getAttribute("email");
        String role = (String) session.getAttribute("role");
        if (role.equals("customer")) {
            mv = new ModelAndView("mainpage");
            User user = userDao.checkEmail(email);
            
             if(result.hasErrors()){
            model.addAttribute("username", user.getFirstName());
            model.addAttribute("user", user);
            model.addAttribute("address", addresss);
            model.addAttribute("title", "Account");
            model.addAttribute("shipping", true);
            return "mainpage";
            }
            
            addresss.setBilling(false);
            addresss.setShipping(true);
            addresss.setUser(user);
            if (addresss.getAddressid() == 0) {
                addressDao.addShippingAddress(addresss);
            } else {
                addressDao.updateShippingAddress(user);
                addressDao.close();
            }
           }
        return "redirect:/Customer/updateShippingAddress";
    
    }

    @RequestMapping(value = "/updateBillingAddress", method = RequestMethod.GET)
    public ModelAndView viewBilling(@ModelAttribute("addressbill") Address addressbill, HttpSession session) throws AdException {
        ModelAndView mv;
        String email = (String) session.getAttribute("email");
        String role = (String) session.getAttribute("role");
        if (role.equals("customer")) {
            User user = userDao.checkEmail(email);
            mv = new ModelAndView("mainpage");
            addressbill = addressDao.getBillingAddress(user);
            mv.addObject("username", user.getFirstName());
            mv.addObject("user", user);
            mv.addObject("address", addressbill);
            mv.addObject("title", "Account");
            mv.addObject("billing", true);

        } else {
            mv = new ModelAndView("noaccess");
            mv.addObject("Seller", true);
        }
        return mv;
    }

    @RequestMapping(value = "/updateBillingAddress", method = RequestMethod.POST)
    public String updateBilling(@Valid @ModelAttribute("addressbill") Address addressbill,BindingResult result,Model model, HttpSession session) throws AdException {
        ModelAndView mv;
        String email = (String) session.getAttribute("email");
        String role = (String) session.getAttribute("role");
        if (role.equals("customer")) {
             mv = new ModelAndView("mainpage");
            User user = userDao.checkEmail(email);
            if(result.hasErrors()){
           model.addAttribute("username", user.getFirstName());
            model.addAttribute("user", user);
            model.addAttribute("address", addressbill);
           model.addAttribute("title", "Account");
            model.addAttribute("billing", true);
            return "mainpage";
            }
            addressbill.setBilling(true);
            addressbill.setShipping(false);
            addressbill.setUser(user);
            if (addressbill.getAddressid() == 0) {
                addressDao.addBillingAddress(addressbill);
            } else {
                addressDao.updateBillingAddress(user);
                addressDao.close();
            }

            mv.addObject("username", user.getFirstName());
            mv.addObject("user", user);
            mv.addObject("address", addressbill);
            mv.addObject("title", "Account");
            mv.addObject("billing", true);

        } else {
            mv = new ModelAndView("noaccess");
            mv.addObject("Seller", true);
        }
        return "redirect:/Customer/updateBillingAddress";
    }

    @RequestMapping(value = "/viewProducts", method = RequestMethod.GET)
    public ModelAndView products(HttpSession session, SessionStatus status) throws AdException {
        ModelAndView mv;
        String role = (String) session.getAttribute("role");
        if (role.equals("customer")) {
            mv = new ModelAndView("mainpage");
            departmentList = departmentDao.getDepartmentList();
            productList = productDao.getProductList();
            productDao.close();
            status.setComplete();
            mv.addObject("title", "All products");
            mv.addObject("categories", departmentList);
            mv.addObject("products", productList);
            mv.addObject("clickProducts", true);
        } else {
            mv = new ModelAndView("noaccess");
            mv.addObject("Seller", true);
        }
        return mv;
    }

    @RequestMapping(value = "/show/category/{id}/products", method = RequestMethod.GET)
    public ModelAndView showDepartmentProducts(@PathVariable("id") int id, HttpSession session, SessionStatus status) throws AdException {
        ModelAndView mv;
        String role = (String) session.getAttribute("role");
        if (role.equals("customer")) {
            mv = new ModelAndView("mainpage");
            Category department;
            department = departmentDao.getEachDepartment(id);
            departmentList = departmentDao.getDepartmentList();
            productList = productDao.searchproduct(id);
            productDao.close();
            status.setComplete();
            String departmentName = department.getName();
            mv.addObject("title", departmentName);
            mv.addObject("products", productList);
            
            mv.addObject("category", department);
            mv.addObject("categories", departmentList);
            mv.addObject("clickDeptProducts", true);
        } else {
            mv = new ModelAndView("noaccess");
            mv.addObject("Seller", true);
        }
        return mv;
    }

    @RequestMapping(value = "/orderPlaced")
    public ModelAndView placeorders(HttpSession session, Orders orders, OrderItem orderitem) throws AdException {
        ModelAndView mv;
        String role = (String) session.getAttribute("role");
        String email = (String) session.getAttribute("email");
        if (role.equals("customer")) {
            User user = userDao.checkEmail(email);

            Cart cart = cartdao.getCart(user);

            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("../applicationContext.xml");
            orders = (Orders) context.getBean("orders");

            List<CartItem> cartitemList = cartItemDao.getCartItemList(cart);
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
            LocalDateTime now = LocalDateTime.now();
            String dateToString = dtf.format(now);
            orders.setUser(user);
            orders.setDate(dateToString);
            orders.setQuantity(cartitemList.size());
            orders.setTotal(cart.getTotal());
            
            orderdao.addOrder(orders);

            for (int i = 0; i < cartitemList.size(); i++) {
                CartItem cartitems = cartitemList.get(i);
                cartitems.setOrderid(orders.getOrderid());
                cartitems.getProduct().setQuantity(cartitems.getProduct().getQuantity() - cartitems.getQuantity());

                ClassPathXmlApplicationContext context1 = new ClassPathXmlApplicationContext("../applicationContext.xml");
                orderitem = (OrderItem) context1.getBean("orderItem");

                orderitem.setProduct(cartitems.getProduct());
                orderitem.setOrders(orders);
                orderitem.setQuantity(cartitems.getQuantity());
                orderitem.setPrice(cartitems.getTotalPrice());
                orderitem.setStatus("Order Placed");
                orderItemDao.addOrderItem(orderitem);

            }

            cartdao.close();
            cartItemDao.close();

            return new ModelAndView("redirect:/Customer/orders");
        } else {
            mv = new ModelAndView("noaccess");
            mv.addObject("Seller", true);
        }
        return mv;
    }

    @RequestMapping(value = "/orders")
    public ModelAndView orders(HttpSession session) throws AdException {
        ModelAndView mv;
        String role = (String) session.getAttribute("role");
        String email = (String) session.getAttribute("email");
        if (role.equals("customer")) {
            User user = userDao.checkEmail(email);
            mv = new ModelAndView("mainpage");

            List<Orders> orderlist = orderdao.getOrdersListUser(user);

            mv = new ModelAndView("mainpage");
            mv.addObject("title", "Orders");
            mv.addObject("username", user.getFirstName());
            mv.addObject("orders", orderlist);
            mv.addObject("clickOrders", true);
        } else {
            mv = new ModelAndView("noaccess");
            mv.addObject("Seller", true);
        }
        return mv;
    }

    @RequestMapping(value = "/{id}/orderpdf")
    public ModelAndView ordersPdf(@PathVariable("id") int id, HttpSession session) throws AdException {
        ModelAndView mv;
        String role = (String) session.getAttribute("role");
        String email = (String) session.getAttribute("email");
        if (role.equals("customer")) {
            Orders order = orderdao.getEachOrder(id);
            List<OrderItem> orderItemList = orderItemDao.getOrderItemList(order);
            mv = new ModelAndView("mainpage");
            mv.addObject("title", "Orders");
            mv.addObject("orderid", order.getOrderid());
            
            mv.addObject("orderdate", order.getDate());
            mv.addObject("orders", orderItemList);
            mv.addObject("orderItemList", true);
        } else {
            mv = new ModelAndView("noaccess");
            mv.addObject("Seller", true);
        }
        return mv;
    }

    @RequestMapping(value = "/{id}/orderItems.pdf")
    public void generatePdf(@PathVariable("id") int id, HttpSession session, HttpServletRequest request, HttpServletResponse response) throws AdException, DocumentException, IOException {
        ModelAndView mv;
        OutputStream os = null;

            final ServletContext servletContext = request.getSession().getServletContext();
            final File tempDirectory = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
            final String temperotyFilePath = tempDirectory.getAbsolutePath();

            Orders order = orderdao.getEachOrder(id);
            List<OrderItem> orderItemList = orderItemDao.getOrderItemList(order);
            String fileName = "OrderDetails.pdf";
            response.setContentType("application/pdf");
            response.setHeader("Content-disposition", "attachment; filename=" + fileName);

            try {
                pdfview.createpdf(temperotyFilePath + "\\" + fileName, orderItemList);
                ByteArrayOutputStream baos = pdfview.convertPDFToByteArrayOutputStream(temperotyFilePath + "\\" + fileName);
                os = response.getOutputStream();
                baos.writeTo(os);

                os.flush();
                os.close();
            } catch (Exception e1) {
                e1.printStackTrace();
            }      

    }

    

    @RequestMapping(value = "/cart")
    public ModelAndView cart(HttpSession session) throws AdException {
        ModelAndView mv;
        double total = 0;
        int size = 0;
        String email = (String) session.getAttribute("email");
        String role = (String) session.getAttribute("role");
        if (role.equals("customer")) {
            mv = new ModelAndView("mainpage");
            User user = userDao.checkEmail(email);
            Cart carts = cartdao.getCart(user);
            
           List<CartItem> cartitemList = cartItemDao.getCartItemList(carts);

            if (carts == null || cartitemList.size() == 0) {
                size = 0;
                total = 0;

            } else {
                size = cartitemList.size();
                total = carts.getTotal();
            }
            if(carts!=null){
            if(cartitemList.size()<1){
                carts.setTotal(0);
            }
            }
            mv.addObject("title", "All products");
            mv.addObject("size", size);
            mv.addObject("total", total);
            mv.addObject("items", cartitemList);
            mv.addObject("clickCart", true);
        } else {
            mv = new ModelAndView("noaccess");
            mv.addObject("Seller", true);
        }
        return mv;

    }

    @RequestMapping(value = "/show/{id}/product", method = RequestMethod.GET)
    public ModelAndView showEachProduct(@PathVariable("id") int id, HttpSession session, SessionStatus status) throws AdException {
        ModelAndView mv = null;
        String role = (String) session.getAttribute("role");
        if (role.equals("customer")) {
            mv = new ModelAndView("mainpage");
            Product product = productDao.getEachProduct(id);
            productDao.close();
            status.setComplete();
            product.setViews(product.getViews() + 1);
            String productName = product.getName();
            mv.addObject("title", productName);
            mv.addObject("product", product);
            mv.addObject("clickEachProducts", true);
        } else if(role.equals("seller")||role == null || role.isEmpty()){
            mv = new ModelAndView("noaccess");
            mv.addObject("Seller", true);
        }
        return mv;
    }

    @RequestMapping(value = "/signout", method = RequestMethod.GET)
    public ModelAndView showEachProduct(HttpSession session) {
        ModelAndView mv = new ModelAndView("usermainPage");
        mv.addObject("title", "Home");
        mv.addObject("clickHome", true);
        session.invalidate();
        return mv;
    }

    @RequestMapping(value = "/addtocart/{id}/product")
    public ModelAndView showCart(@PathVariable("id") int id, HttpSession session, Cart cart, CartItem cartitem, Orders orders) throws AdException {
        double total = 0;
        ModelAndView mv = null;
        String email = (String) session.getAttribute("email");
        String role = (String) session.getAttribute("role");
        if (role.equals("customer")) {
            User user = userDao.checkEmail(email);
            if (role.equals("customer")) {
                mv = new ModelAndView("mainpage");

                Cart cartExisting = cartdao.getCart(user);
                if (cartExisting == null) {
                    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("../applicationContext.xml");
                    cart = (Cart) context.getBean("cart");
                    cart.setUser(user);
                    cart.setTotal(0);
                    cartdao.addCart(cart);
                } else {
                    cart = cartExisting;
                }

                Product product = productDao.getEachProduct(id);
                CartItem cartitemExisting = cartItemDao.getCartItem(product, cart);
                if (cartitemExisting == null) {
                    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("../applicationContext.xml");
                    cartitem = (CartItem) context.getBean("cartItem");
                    cartitem.setProduct(product);
                    cartitem.setCart(cart);

                    cartitem.setOrderid(0);
                    cartitem.setQuantity(1);
                    cartitem.setTotalPrice(product.getPrice() * cartitem.getQuantity());
                    cartItemDao.addCartItem(cartitem);
                    cartItemDao.close();
                } else {

                    cartitemExisting.setQuantity(cartitemExisting.getQuantity() + 1);
                    cartitemExisting.setTotalPrice(product.getPrice() * cartitemExisting.getQuantity());
                    cartItemDao.updateCartItem(cartitemExisting);

                }

                List<CartItem> cartitemList;
                cartitemList = cartItemDao.getCartItemList(cart);

                if (cartitemList.size() >= 1) {
                    for (int i = 0; i < cartitemList.size(); i++) {
                        total += cartitemList.get(i).getTotalPrice();
                    }
                } else if (cartitemList.size() < 1) {
                    total = 0;
                }

                cart.setTotal(total);
                cartdao.updateCart(cart);

                mv = new ModelAndView("mainpage");
                mv.addObject("title", "Cart");
                mv.addObject("product", product);
                mv.addObject("clickEachProducts", true);
            } else {
                mv = new ModelAndView("noaccess");
                mv.addObject("Seller", true);
            }

        }
        return mv;
    }
    
       @RequestMapping(value ="/looseSearch")
    public @ResponseBody List<String> performLooseSearch(@RequestParam("name")String name, HttpSession session) throws AdException {
        List<Product>productLists = new ArrayList<Product>();
        List<String>categorylist = new ArrayList<>();
        String role = (String) session.getAttribute("role");
        if (role.equals("customer")) {
            int j =Integer.parseInt(name);
            productLists = productDao.autoSearch(j);
            System.out.println("After search :"+productLists.size());
           for(int i=0;i<productLists.size();i++){
               categorylist.add(productLists.get(i).getName());
               System.out.println("product"+productLists.get(i).getName());
           }
            productDao.close();
    }   
        return categorylist;
    }
    
     @RequestMapping(value ="/looseSearchPage")
    public ModelAndView looseSearchPage(HttpSession session) throws AdException {
        ModelAndView mv;
        String email = (String) session.getAttribute("email");
        String role = (String) session.getAttribute("role");
        if (role.equals("customer")) {
            
            mv = new ModelAndView("mainpage");
            mv.addObject("LooseSearch", true);
            mv.addObject("title", "looseSearch");

        } else {
            mv = new ModelAndView("noaccess");
            mv.addObject("Seller", true);
        }
        return mv;
    }
}
