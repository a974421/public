package com.itheima.crm.dao;

import java.util.List;

import com.itheima.crm.pojo.Customer;
import com.itheima.crm.pojo.QueryVo;

public interface CustomerDao {
	
	//总条数
	public Integer countCustomerQueryVo(QueryVo vo);
	//结果集
	public List<Customer> selectCustomerListQueryVo(QueryVo vo);
	
	//通过id查询客户对象
	public Customer selectCustomerQueryVo(Integer id);
	
	//修改  保存
	public void uodateCustomerQueryVo(Customer customer);
	//根据id删除
	public void deleteCustomerQueryVo(Integer id);
	
}
