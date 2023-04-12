package com.Abraham.test.activityApp.activity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository<Activity, Integer>{
	public List<Activity> findByUsername(String username);
}
