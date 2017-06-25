package com.itheima.crm.dao;

import java.util.List;

import com.itheima.crm.pojo.BaseDict;

public interface BaseDictDao {
	
	public List<BaseDict> queryBaseDictByDictTypeCode(String typeCode);
}
