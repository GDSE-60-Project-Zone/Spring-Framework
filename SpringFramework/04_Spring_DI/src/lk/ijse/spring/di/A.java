package lk.ijse.spring.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class A {
    @Autowired
    SuperB superB;

    public A(){
        System.out.println("A:instantiated");
    }

    public void test(){
        superB.methodUseByA();
    }
}
