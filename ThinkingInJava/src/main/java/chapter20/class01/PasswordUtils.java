package chapter20.class01;

public class PasswordUtils {

//    @UseCase(id = 47, description = "passwords must contain at least one numerirc")  //在方法上使用注解，注解元素为方法名
//    public boolean validatePassword(String password) {
//        return (password.matches("\\w\\d\\w*"));
//    }
//
//    @UseCase(id = 48)
//    public String encryptPassword(String password) {
//        return new StringBuilder(password).reverse().toString();
//    }
//
//    @UseCase(id = 49, description = "New passwords can't equal previously used ones")
//    public boolean checkForpassword(List<String> prevPasswords,String password) {
//        return !prevPasswords.contains(password);
//    }




    @UseCase(id = 49, description = "New passwords can't equal previously used ones")
    public void checkForpassword() {
        System.out.println("void调用我了");
    }
}
