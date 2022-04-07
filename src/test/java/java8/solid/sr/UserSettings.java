package java8.solid.sr;

/**
 * 2022/4/6 下午4:01
 * aiguoxin 
 * 说明: 单一职责例子
 */
public class UserSettings {
    private User user;
    private UserAuth userAuth;
    public UserSettings(User user){
        this.user = user;
        this.userAuth = new UserAuth(user);
    }

    public void changeSettings(String settings){
        if(this.userAuth.verifyCredentials()){
            //
        }
    }
}

class UserAuth{
    private User user;
    public UserAuth(User user){
        this.user = user;
    }

    public boolean verifyCredentials(){
        //
        return true;
    }
}

class User{

}
