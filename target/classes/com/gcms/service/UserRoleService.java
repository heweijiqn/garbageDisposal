package com.gcms.service;

import com.gcms.model.ResultMap;
import com.gcms.pojo.UserRole;

import java.util.List;

public interface UserRoleService {
	List<UserRole> getRoleByUserId(String userId);

	boolean delUserRoleByRoleId(int id);

	ResultMap delUserRoleByUserIdAndRoleId(String userId, Integer roleId);

	String addUserRole(Integer roleId, String[] userIds);

	UserRole getUserRole(String userId);
}
