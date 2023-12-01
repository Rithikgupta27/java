package utils;

import java.time.LocalDate;
import java.util.Map;

import customException.TaskManagerExceptions;
import taskManager.TaskManager;
import taskManager.TaskStatus;

public class TaskManagerValidationRule {
	
public static TaskStatus parseAndValidateStatus(String status) {
	return TaskStatus.valueOf(status.toUpperCase());
}

public static LocalDate parseDate(String date) {
	LocalDate temp = LocalDate.parse(date);
	return temp;
}
public static int validateId(int id,Map<Integer,TaskManager> task) throws TaskManagerExceptions{
	TaskManager temp=task.get(id);
	if(temp==null) {
		throw new TaskManagerExceptions("Invalid id Enter");
	}
	return id;
}

public static TaskManager validateAllInput(String taskName, String description, String taskDate, String status, boolean active) {
	LocalDate dt=parseDate(taskDate);
	TaskStatus tStatus=parseAndValidateStatus(status);
	return new TaskManager(taskName, description, dt, tStatus, active=true);
}


}
