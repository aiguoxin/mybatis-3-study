/**
 *    Copyright 2009-2022 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
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
