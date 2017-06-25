package com.itheima.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itheima.crm.dao.BaseDictDao;
import com.itheima.crm.pojo.BaseDict;
@Service
public class BaseDictServiceImple implements BaseDictService{

	@Autowired
	private BaseDictDao baseDictDao;
	
	public List<BaseDict> queryBaseDictByDictTypeCode(String typeCode) {
		// TODO Auto-generated method stub
		
		return baseDictDao.queryBaseDictByDictTypeCode(typeCode);
	}

}
