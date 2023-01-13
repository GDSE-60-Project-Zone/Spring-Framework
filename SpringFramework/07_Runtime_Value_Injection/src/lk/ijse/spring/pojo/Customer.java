package lk.ijse.spring.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Customer {

//    public Customer(){
//        System.out.println("Default Constructor :Customer:Instantiated ");
//    }

//    public Customer(@Value("IJSE") String name){
//        System.out.println("Customer:Instantiated "+name);
//    }

    @Autowired(required = false)//here spring runs the greedious constructor
    public Customer(@Value("Dasun,Kasun,Amal") String names[],@Value("1") int i,@Value("2") int c){
        System.out.println("Customer:Instantiated");
        for (String name : names) {
            System.out.println(name);
        }
    }

    @Autowired(required = false)
    public Customer(@Value("Dasun") String name,@Value("10") int i){
        System.out.println("Customer:Instantiated :"+name);
    }

    //what you can assign with @Value annotation
    //Primitive Data Types
    //String data
    //Arrays



}
