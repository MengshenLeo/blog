package fun.mengshenleo.blog;

import com.alibaba.excel.EasyExcel;
import fun.mengshenleo.blog.listener.ExcelListener;
import fun.mengshenleo.blog.mapper.UserMapper;
import fun.mengshenleo.blog.pojo.ApiLog;
import fun.mengshenleo.blog.pojo.PersonInfo;
import fun.mengshenleo.blog.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

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

    @Test
    void testExcelRead(){

        ExcelListener excelListener = new ExcelListener();

        String file = "C:\\Users\\29458\\Desktop\\apiLog.xlsx";
        EasyExcel
                .read(file, ApiLog.class,excelListener)
                .sheet("表1")
                .doRead();
        List<ApiLog> data = excelListener.getData();
        for (ApiLog datum : data) {
            System.out.println(datum);
        }

    }

}
