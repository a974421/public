package com.itheima.crm.service;

import com.itheima.common.utils.Page;
import com.itheima.crm.pojo.Customer;
import com.itheima.crm.pojo.QueryVo;

public interface CustomerService {
	/*
	 * 客户管理
	 * 列表查询
	 * 修改
	 * 删除
	 */
	//通过页面传递过来的参数  查询分页对象
	public Page<Customer> selectPageByQueryVo(QueryVo vo);
	//通过id查询客户对象
	public Customer selectCustomerQueryVo(Integer id);
	//修改 保存
	public void uodateCustomerQueryVo(Customer customer);
	//根据id删除
	public void deleteCustomerQueryVo(Integer id);
}
