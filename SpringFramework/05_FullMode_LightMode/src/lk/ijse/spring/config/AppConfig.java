package lk.ijse.spring.config;

import lk.ijse.spring.pojo.PojoThree;
import lk.ijse.spring.pojo.PojoTwo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "lk.ijse.spring")
public class AppConfig {


    //Full Mode
    //In Full Mode it Satisfied Inter-bean Dependencies
//    @Bean
//    public PojoTwo pojoTwo(){
//        //inter-bean dependencies invocation
//        PojoThree pojoThree1 = pojoThree();//fully satisfied object
//        PojoThree pojoThree2 = pojoThree();//fully satisfied object
//        System.out.println(pojoThree1); //same link
//        System.out.println(pojoThree2);//same link
//        return new PojoTwo();
//    }
//
//    @Bean
//    public PojoThree pojoThree(){
//        return new PojoThree();
//    }
}
