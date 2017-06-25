package com.itheima.crm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itheima.common.utils.Page;
import com.itheima.crm.dao.CustomerDao;
import com.itheima.crm.pojo.Customer;
import com.itheima.crm.pojo.QueryVo;
@Service
public class CustomerServiceImpl implements CustomerService{
	@Autowired
	private CustomerDao customerDao;
	
	
	//通过页面穿的参数  分页查询
	public Page<Customer> selectPageByQueryVo(QueryVo vo) {
		
		Page<Customer> page=new Page<>();
		//设置当前页
		if(null==vo.getPage()){
			vo.setPage(1);
		}
		page.setPage(vo.getPage());
		page.setSize(5);
		vo.setSize(5);
		//开始行
		vo.setStart((vo.getPage()-1)*vo.getSize());
		//总条数
		page.setTotal(customerDao.countCustomerQueryVo(vo));
		//结果集
		page.setRows(customerDao.selectCustomerListQueryVo(vo));
		return page;
	}


	//通过id查询客户页面
	public Customer selectCustomerQueryVo(Integer id) {
		
		return customerDao.selectCustomerQueryVo(id);
	}


	//修改 保存
	public void uodateCustomerQueryVo(Customer customer) {
		// TODO Auto-generated method stub
		customerDao.uodateCustomerQueryVo(customer);
	}


	//根据id删除
	public void deleteCustomerQueryVo(Integer id) {
		// TODO Auto-generated method stub
		customerDao.deleteCustomerQueryVo(id);
	}

}
