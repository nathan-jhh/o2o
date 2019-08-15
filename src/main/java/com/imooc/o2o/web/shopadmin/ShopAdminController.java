package com.imooc.o2o.web.shopadmin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "shopadmin", method = RequestMethod.GET)
/**
 * 解析路由并转发到相应的html中
 * @author jhhma
 *
 */
public class ShopAdminController {
	@RequestMapping(value = "/shopoperation")
	 public String shopOperation() {
		 return "shop/shopoperation";
	 }
	@RequestMapping(value = "/shoplist")
	 public String shopList() {
		 return "shop/shoplist";
	 }
	@RequestMapping(value = "/shopmanagement")
	 public String shopManagement() {
		 return "shop/shopmanagement";
	 }
	@RequestMapping(value = "/productcategorymanagement")
	 public String productCategoryCanagement() {
		 return "shop/productcategorymanagement";
	 }
	@RequestMapping(value = "/productoperation")
	 public String productOperation() {
		 return "shop/productoperation";
	 }
	@RequestMapping(value = "/productmanagement")
	 public String productManagement() {
		 return "shop/productmanagement";
	 }
}
