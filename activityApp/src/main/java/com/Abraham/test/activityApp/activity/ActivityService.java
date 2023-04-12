package com.Abraham.test.activityApp.activity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class ActivityService {
	
	private static List<Activity> todos = new ArrayList<>();
	
	private static int todosCount = 0;
	
	public List<Activity> findByUsername(String username){
		Predicate<? super Activity> predicate =
				todo -> todo.getUsername().equalsIgnoreCase(username);
		return todos.stream().filter(predicate).toList();
	}
	
	public void addTodo(String username, String description, LocalDate targetDate, boolean done) {
		Activity todo = new Activity(++todosCount,username,description,targetDate,done);
		todos.add(todo);
	}
	
	public void deleteById(int id) {
		Predicate<? super Activity> predicate = todo -> todo.getId() == id;
		todos.removeIf(predicate);
	}

	public Activity findById(int id) {
		Predicate<? super Activity> predicate = todo -> todo.getId() == id;
		Activity todo = todos.stream().filter(predicate).findFirst().get();
		return todo;
	}

	public void updateTodo(@Valid Activity todo) {
		deleteById(todo.getId());
		todos.add(todo);
	}
}