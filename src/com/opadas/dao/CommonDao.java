package com.opadas.dao;

import java.util.List;

import com.opadas.model.Admin;

public interface CommonDao<T> {
	public boolean insert(T user);
	public List<T> retriveUsers();
	public boolean update(T user);
	public boolean delete();
}
