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
package java8.solid.di;

/**
 * 2022/4/6 下午4:48
 * aiguoxin 
 * 说明:
 */
public class Bad {
    private HttpClient httpClient;

    public Bad(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public String getWeather(){
        return this.httpClient.get();
    }
}

class HttpClient {
    public String get(){
        //
        return "";
    }
}


