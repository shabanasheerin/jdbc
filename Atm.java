import java.sql.*;
import java.util.Scanner;

public class Atm {
    public static void main (String[] args) throws Exception {
        
    

        
            String url="jdbc:mysql://localhost:3306/Atm";
            String user="root";
            String password="successgrowth";
            
            Connection con =DriverManager.getConnection(url,user,password);
            Statement s=con.createStatement();
            Scanner sc= new Scanner(System.in);
            System.out.println("Hey Welcome to all in One Atm");
            System.out.println("Enter Your Pin Number");
            int pin =sc.nextInt();
            String name="null";
           int count=0;
            int balance=0;
            
            ResultSet r= s.executeQuery("select * from list where ac_no="+pin);
            while(r.next()){
                name=r.getString(3);
                balance=r.getInt(4);
               count++;
            }
           
            
            int choice=0;
            int amount=0;
            int take_amount=0;
            
           if(count>0){
            
                
    
        
            
                System.out.println("Hello"+name);
                while(true){
                    System.out.println("Press 1 to check balance");
                    System.out.println("Press 2 to Add Amount");
                    System.out.println("Press 3 to Take Amount");
                    System.out.println("Press 4 to print the Recipt");
                    System.out.println("Press 5 to Exit");
                    
                    
                    System.out.println("Enter Your Choice");
                    choice=sc.nextInt();
                
                    switch(choice){
                        
                        case 1:
                        System.out.println("Your balance is:"+balance);
                        
                        break;
                        case 2:
                        System.out.println("How much amount did you want to add");
                        amount=sc.nextInt();
                        balance=balance+amount;
                        int bal=s.executeUpdate("UPDATE list SET balance ="+balance+" WHERE ac_no="+pin);
                        System.out.println("successfully added now your current balance:"+balance);
                        break;
                        case 3:
                        System.out.println("How much amount did you want to take");
                        take_amount=sc.nextInt();
                        balance=balance-take_amount;
                        int sub=s.executeUpdate("UPDATE list SET balance ="+balance+" WHERE ac_no="+pin);
                        System.out.println("successfully added now your current balance:"+balance);
                        break;
                        case 4:{
                            System.out.println("Thanks for coming");
                            System.out.println("your current balance is:"+balance);
                            break;
                            
                        }
                    }
                        if(choice==5){
                            break;
                        }
                        
                    
                    
                    }
                }
            

else{
    System.out.println("Wrong pin number");
}
    }
}



        
                        
                        
                             
                    
                    
                
            
            
          
    
                         
                            
                         
                        
        

                
            
            
            
        
        
       




