package com.itheima.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itheima.common.utils.Page;
import com.itheima.crm.pojo.BaseDict;
import com.itheima.crm.pojo.Customer;
import com.itheima.crm.pojo.QueryVo;
import com.itheima.crm.service.BaseDictService;
import com.itheima.crm.service.CustomerService;
/**
 * 客户管理
 * @author 张俊恺
 *
 */
@Controller
public class CustomerController {

	@Autowired
	private BaseDictService baseDictService;
	@Autowired
	private CustomerService customerService;
	
	@Value(value="${b.fromType}")
	private String ft;
	@Value(value="${b.industryType}")
	private String it;
	@Value(value="${b.levelType}")
	private String lt;
	
	
	@RequestMapping(value="/customer/list.action")
	public String list(QueryVo vo,Model model){
		
		//客户来源 
		List<BaseDict> fromType = baseDictService.queryBaseDictByDictTypeCode(ft);
		model.addAttribute("fromType", fromType);
//				所属行业
		List<BaseDict> industryType = baseDictService.queryBaseDictByDictTypeCode(it);
		model.addAttribute("industryType", industryType);
//				客户级别
		List<BaseDict> levelType = baseDictService.queryBaseDictByDictTypeCode(lt);
		model.addAttribute("levelType", levelType);
		
		/*
		 * private String custName;
	private String custSource;
	private String custIndustry;
	private String custLevel;
		 */
		
		//通过页面传递的参数 查询 分页 对象
		Page<Customer> page = customerService.selectPageByQueryVo(vo);
		model.addAttribute("page", page);
		model.addAttribute("custName", vo.getCustName());
		model.addAttribute("custSource", vo.getCustSource());
		model.addAttribute("custIndustry", vo.getCustIndustry()); 
		model.addAttribute("custLevel", vo.getCustLevel());
		
		
		
		return "customer";
				
	}
	//点击修改按钮   弹出层
	@RequestMapping(value="customer/edit.action")
	public @ResponseBody Customer edit(Integer id){
		return customerService.selectCustomerQueryVo(id);
	}
	//提交修改
	@RequestMapping(value="customer/update.action")
	public @ResponseBody
	String update(Customer customer){
		
		customerService.uodateCustomerQueryVo(customer);
		return "ok";
	}
	@RequestMapping(value="customer/delete.action")
	public @ResponseBody
	String delete(Integer id){
		customerService.deleteCustomerQueryVo(id);
		return "ok";
	}
	
}
