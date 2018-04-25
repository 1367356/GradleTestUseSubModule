package chapter20.class02;

/**
 * 一个bean，使用了上面的注解
 */
@DBTable(name = "MEMBER")  //该注解将Member解析为数据库表。可以指定表名。
public class Member {
    @SQLString(30)  //该域定义sqlString类型,
    String firstName;
    @SQLString(50)  //值
    String lastName;
    @SQLInteger  //SQL整数类型,
    Integer age;

    @SQLString(value = 30,contraint = @Contraints(primaryKey = true))
    String handle;

    static int memberCount;
    public String getHandle(){
        return handle;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getAge() {
        return age;
    }

    public String toString() {
        return handle;
    }
}
