/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

import java.util.Hashtable;
import java.util.List;
import Model.SalaryHistory;
import Model.Worker;

/**
 *
 * @author hieu
 */
public interface IWorkerRepository {
    void addWorker(Hashtable<String, Worker> workers);
    void changeSalary(Hashtable<String, Worker> workers, List<SalaryHistory> salaryHistorys, String status);
    void displaySalary(List<SalaryHistory> salaryHistorys);
}

