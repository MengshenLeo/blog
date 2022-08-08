package fun.mengshenleo.blog;

import fun.mengshenleo.blog.pojo.PersonInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class BlogApplicationTests {

    @Resource
    private PersonInfo personInfo;

    @Test
    void contextLoads() {
    }
    //获取配置文件中的age
    @Value("${age}")
    private int age;

    //获取配置文件中的name
    @Value("${name}")
    private String name;

    @Test
    public void TestYml(){
        System.out.println(age);
        System.out.println(name);
    }

    @Test
    public void TestPersonInfo(){
        System.out.println(personInfo.getName());
        System.out.println(personInfo.getAge());
    }

}
