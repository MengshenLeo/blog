package fun.mengshenleo.blog.pojo;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author mengshen
 * @date 2022/7/23 18:24
 */
@Component
@ConfigurationProperties(prefix = "person-info")
public class PersonInfo {

    /**
     * 年龄
     */
    private int age;

    /**
     * 名字
     */
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
