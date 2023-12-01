package taskManager;

import java.time.LocalDate;

public class TaskManager implements Comparable<TaskManager>{
private static int taskId=0;
private String taskName;
private String description;
private LocalDate taskDate;
private TaskStatus status;
private boolean active;
public TaskManager(String taskName, String description, LocalDate taskDate, TaskStatus status, boolean active) {
	this.taskName = taskName;
	this.description = description;
	this.taskDate = taskDate;
	this.status = status;
	this.active = active;
	++taskId;
}

@Override
public String toString() {
	return "TaskManager [taskName=" + taskName + ", description=" + description + ", taskDate=" + taskDate + ", status="
			+ status + ", active=" + active + "]";
}

public static int getTaskId() {
	return taskId;
}

public String getTaskName() {
	return taskName;
}

public String getDescription() {
	return description;
}

public LocalDate getTaskDate() {
	return taskDate;
}

public TaskStatus getStatus() {
	return status;
}

public boolean isActive() {
	return active;
}

public void setActive(boolean active) {
	this.active = active;
}

public void setStatus(TaskStatus status) {
	this.status = status;
}

@Override
public int compareTo(TaskManager lDate) {
	
	this.taskDate=taskDate;
	
	return taskDate.compareTo(lDate.getTaskDate());
}


}
