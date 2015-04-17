package check;


import java.time.LocalDate;
import java.text.DateFormat;
import java.time.format.DateTimeFormatter;
import  java.util.concurrent.TimeUnit;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jenniferschofield
 */
// Check Class: Check the book if it is avilable
public class Check {
    int cardholder; // Who has the book right now
    int bookid; // Book ID
    LocalDate duedate; // Due date of checked out book
    
    // Constructor
    public Check(int cardholder, int bookid,int days, LocalDate duedate) {
        this.cardholder = cardholder;
        this.bookid = bookid;
        this.duedate = duedate.plusDays(days);
    }
    // Get info from data base
    public Check (String s){
        String [] ch= s.split(",=");
        cardholder =Integer.parseInt(ch[1]);
        bookid = Integer.parseInt(ch[2]);
        duedate= LocalDate.of(Integer.parseInt(ch[3]),Integer.parseInt(ch[4]),Integer.parseInt(ch[5]));
        
    }

    @Override
    public String toString() {
        return "C" + ",=" + cardholder + ",=" + bookid + 
                ",=" + duedate.getYear()+",="+duedate.getMonth()+",=" +duedate.getDayOfMonth();
    }
    // Check the book if it is check out
    public boolean ischeckedout(int item){
        return item==bookid;
    }
    // Get patron's info
    public int getpatroncard (){
        return cardholder;
    }
    // Check if the patron is in our data base
    public boolean ispatron(int c){
        return c==cardholder;
    }
    // Get book ID
    public int getbookid (){
        return bookid;
    }
    // Check duedate if it is over
       public boolean overdue(LocalDate now){
        return now.isAfter(duedate);
        
    }
    
}
