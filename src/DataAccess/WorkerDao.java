/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import Common.Library;
import Common.Validation;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;
import Model.SalaryHistory;
import Model.Worker;

/**
 *
 * @author hieu
 */
public class WorkerDao {
    private static WorkerDao instance = null;
    Library l = new Library();
    Validation val = new Validation();
    public static WorkerDao Instance() {
        if (instance == null)
            synchronized (WorkerDao.class) {
                if (instance == null)
                    instance = new WorkerDao();
            }
        return instance;        
    }
    public void addWorker(Hashtable<String, Worker> workers) {
        String id = l.getString("Enter code: ");
        while (val.checkCodeExist(workers, id) != null) {
            id = l.getString("Enter code: ");
        } 
        String name = l.getString("Enter name: ");
        int age = l.getInt("Enter age: ");
        while (!val.checkInputIntLimit(age, 18, 50)) {
            age = l.getInt("Enter age: ");
        }
        double salary = l.getInt("Enter salary: ");
        while (!val.checkInputPositiveNumber(salary)) {
            salary = l.getInt("Enter salary: ");
        }
        String workLocation = l.getString("Enter work location: ");
        Worker worker = new Worker(id, name, age, salary, workLocation);
        workers.put(worker.getId(), worker);
    }
    public void changeSalary(Hashtable<String, Worker> workers, List<SalaryHistory> salaryHistorys, String status) {
        String id = l.getString("Enter code: ");
        double amount = l.getInt("Enter amount: ");
        while (!val.checkInputPositiveNumber(amount)) {
            amount = l.getInt("Enter amount: ");
        }
        changeSalary(workers, salaryHistorys, status, id, amount);
    }

    private void changeSalary(Hashtable<String, Worker> workers, List<SalaryHistory> salaryHistorys, String status, String id, double amount) {
        Worker worker = val.checkCodeExist(workers, id);
        if (worker != null) {
            double newSalary = 0;
            if (status.equalsIgnoreCase("UP"))
                newSalary = worker.getSalary() + amount;
            else {
                while(!val.checkInputPositiveNumber(worker.getSalary() - amount)) {
                    amount = l.getInt("Enter amount: ");
                }
                newSalary = worker.getSalary() - amount;   
            }
            worker.setSalary(newSalary);
            salaryHistorys.add(new SalaryHistory(worker.getId(), worker.getName(), worker.getAge(), newSalary,
                    worker.getWorkLocation(), status, l.getCurrentDate()));
        }
        else
            System.out.println("Not found any worker.");
        
    }

    public void displayInfomationSalary(List<SalaryHistory> salaryHistorys) {
        salaryHistorys = getInfomationSalary(salaryHistorys);
        salaryHistorys.forEach(s -> System.out.println(s));
    }
    public List<SalaryHistory> getInfomationSalary(List<SalaryHistory> salaryHistorys) {
        Collections.sort(salaryHistorys);
        return salaryHistorys;
    }
}

