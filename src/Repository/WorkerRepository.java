/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

import DataAccess.WorkerDao;
import java.util.Hashtable;
import java.util.List;
import Model.SalaryHistory;
import Model.Worker;

/**
 *
 * @author hieu
 */
public class WorkerRepository implements IWorkerRepository {

    @Override
    public void addWorker(Hashtable<String, Worker> workers) {
        WorkerDao.Instance().addWorker(workers);
    }

    @Override
    public void changeSalary(Hashtable<String, Worker> workers, List<SalaryHistory> salaryHistorys, String status) {
        WorkerDao.Instance().changeSalary(workers, salaryHistorys, status);
    }

    @Override
    public void displaySalary(List<SalaryHistory> salaryHistorys) {
        WorkerDao.Instance().displayInfomationSalary(salaryHistorys);
    } 
}
