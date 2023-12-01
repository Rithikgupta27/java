package Tester;

import static utils.TaskManagerValidationRule.parseAndValidateStatus;
import static utils.TaskManagerValidationRule.validateAllInput;
import static utils.TaskManagerValidationRule.validateId;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import taskManager.TaskManager;
import taskManager.TaskStatus;

public class Main {
	@SuppressWarnings("unlikely-arg-type")
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {

			Map<Integer, TaskManager> tasks = new HashMap<>();
			boolean exit = false;
			while (!exit) {
				try {
					System.out.println("\r\n" + "1. Add New Task\r\n" + "2. Delete a task                         \r\n"
							+ "3. Update task status               \r\n" + "4. Display all pending tasks     \r\n"
							+ "5. Display all pending tasks for today           \r\n"
							+ "6.  Display all tasks sorted by taskDate \r\n" + "7. Display by taskId \r\n"
							+ "0. exit");
					switch (sc.nextInt()) {
					case (1):
						String status = "PENDING";
						System.out.println("Enter String taskName, String description, String taskDate, String status");
						TaskManager ts = validateAllInput(sc.next(), sc.next(), sc.next(), status, true);
						tasks.put(ts.getTaskId(), ts);
						break;
					case (2):
						System.out.println("Enter task Id");
						int tempId = validateId(sc.nextInt(), tasks);
						TaskManager tempActive = tasks.get(tempId);
						tempActive.setActive(false);
						System.out.println("task deleted");
						break;
					case (3):
						System.out.println("Enter task Id");
						tempId = validateId(sc.nextInt(), tasks);
						TaskManager temp = tasks.get(tempId);
						System.out.println("enter new status pending,in_progress,completed");
						TaskStatus tempStatus =parseAndValidateStatus(sc.next());
						temp.setStatus(tempStatus);
						System.out.println("status updated succesfully");
						break;
					case (4):						
						for(TaskManager id:tasks.values()) {
							TaskManager temp1=tasks.get(id);							
							if(temp1.getStatus().equals("PENDING"))
							System.out.println(temp1.getStatus());
						}
						break;
					case (5):
						LocalDate today=LocalDate.now();
					    for(TaskManager id:tasks.values()) {
					    	TaskManager temp1=tasks.get(id);
					    	if(temp1.getTaskDate().equals(today)) {
					    		if(temp1.getStatus().equals("PENDING")) {
									System.out.println(temp1.getStatus());
									}
					    	}
					    }
						break;
					case (6):
						List<TaskManager> tml =new ArrayList<>();
						for(TaskManager value:tasks.values()) {
							tml.add(value);
						}
						Collections.sort(tml);
						for(TaskManager tsk:tml)
						System.out.println(tsk);
						
						break;
					case (7):
						System.out.println("Enter id");
//					    TaskManager tempKey=tasks.get(sc.nextInt());
//					    if(tempKey==null) {
//					    	throw new TaskManagerExceptions("no such task is present");
//					    }
						tempId = validateId(sc.nextInt(), tasks);
						System.out.println(tasks.get(tempId));

						break;
					case (0):
						exit = true;
						break;

					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

	}
}
