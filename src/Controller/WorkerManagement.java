/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import Model.SalaryHistory;
import Model.Worker;
import Repository.IWorkerRepository;
import Repository.WorkerRepository;
import View.Menu;

/**
 *
 * @author hieu
 */
public class WorkerManagement extends Menu<String> {

    private IWorkerRepository workerRepository;
    static String[] options = {"Add worker", "Up salary", "Down salary",
        "Display Information salary", "Exit"};
    Hashtable<String, Worker> workers;
    List<SalaryHistory> salaryHistorys;

    public WorkerManagement() {
        super("===== Worker Management =====", options);
        workerRepository = new WorkerRepository();
        workers = new Hashtable<>();
        salaryHistorys = new ArrayList<>();
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                workerRepository.addWorker(workers);
                break;
            case 2:
                workerRepository.changeSalary(workers, salaryHistorys, "UP");
                break;
            case 3:
                workerRepository.changeSalary(workers, salaryHistorys, "DOWN");
                break;
            case 4:
                workerRepository.displaySalary(salaryHistorys);
                break;
            case 5:
                System.exit(0);
        }
    }
}
