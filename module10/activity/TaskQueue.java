package sef.module10.activity;

import java.util.ArrayList;
import java.util.List;

/*
* Очередь, в которую будем добавлять задания
* */
public class TaskQueue {
	
	private List<String> taskList;
	
	public TaskQueue(){
		taskList = new ArrayList<String>();	
	}

	public synchronized void addTask(String task){

		taskList.add(task);
		
	}
	
	public  synchronized String getNextTask(){
		if(taskList.isEmpty()){
			return null;
		}else{
			return taskList.remove(0);
		}
	}
	
	public boolean isEmpty(){
		if(taskList.size() == 0){
			return true;
		}else{
			return false;
		}
	}
}
