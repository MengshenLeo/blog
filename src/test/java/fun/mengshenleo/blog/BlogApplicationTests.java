package fun.mengshenleo.blog;

import fun.mengshenleo.blog.mapper.UserMapper;
import fun.mengshenleo.blog.pojo.PersonInfo;
import fun.mengshenleo.blog.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.Date;

@SpringBootTest
class BlogApplicationTests {

    @Resource
    private PersonInfo personInfo;

    @Test
    void contextLoads() {
        System.out.println("hello");
    }
    //获取配置文件中的age
//    @Value("${age}")
//    private int age;
//
//    //获取配置文件中的name
//    @Value("${name}")
//    private String name;
//
//    @Test
//    public void TestYml(){
//        System.out.println(age);
//        System.out.println(name);
//    }
//
//    @Test
//    public void TestPersonInfo(){
//        System.out.println(personInfo.getName());
//        System.out.println(personInfo.getAge());
//    }

    @Resource
    UserMapper userMapper;

    @Test
    void testInsert() {
        User sample = new User();

        sample.setUsername("rzl123");
        sample.setPassword("123456");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        sample.setCreateTime(timestamp);
        userMapper.insert(sample);
    }

}
