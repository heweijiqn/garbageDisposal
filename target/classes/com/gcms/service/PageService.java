package com.gcms.service;


import com.gcms.model.ResultMap;
import com.gcms.pojo.Page;

import java.util.List;

public interface PageService {
	public List<Page> getAllPageByRoleId(Integer roleId);

	public List<Page> getAllPage();

	public ResultMap updatePageById(Page page);

	public Page addPage(Page page);

	public ResultMap delPageById(Integer id);

	public List<Page> getAllRolePageByUserId(String userId);
}
