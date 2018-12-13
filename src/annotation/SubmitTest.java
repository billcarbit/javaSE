package annotation;

public class SubmitTest {

    public static void main(String[] args) throws IllegalAccessException {
        LoginReq loginReq = new LoginReq();
        loginReq.setUsername("1234");
        //loginReq.setUsername("13207111657");
        new RequestParamValidator(loginReq);


    }
}
