/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

/**
 *
 * @author hieu
 */
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Menu<T> {

    protected String title;
    protected ArrayList<T> mChon;

    public Menu() {
    }

    public Menu(String td, String[] mc) {
        title = td;
        mChon = new ArrayList<>();
        for (String s : mc) {
            mChon.add((T) s);
        }
    }

    public void display() {
        System.out.println(title);
        System.out.println("-------------------------------------");
        for (int i = 0; i < mChon.size(); i++) {
            System.out.println((i + 1) + "." + mChon.get(i));
        }
        System.out.println("-------------------------------------");

    }

    public int getSelected() {
        display();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter selection : ");
        try {
            int selection = sc.nextInt();
            sc.nextLine(); // Đọc dòng mới sau khi đọc số nguyên
            return selection;
        } catch (Exception e) {
            sc.nextLine(); // Đọc dòng mới nếu xảy ra lỗi
            return -1; // Trả về -1 nếu nhập không hợp lệ
        }
    }

    public abstract void execute(int n);

    public void run() {
         while (true) {
            int n = getSelected();
            if (n > mChon.size()) {
                System.out.println("Invalid selection. Please enter a valid option.");
                continue; // Tiếp tục vòng lặp nếu lựa chọn không hợp lệ
            }
            if (n<1){
                System.out.println("Please Enter a number 1-5");
            }
            execute(n);
            if (n == mChon.size()) {
                break; // Thoát khỏi vòng lặp khi lựa chọn là lựa chọn cuối cùng
            }
        }

    }
}

