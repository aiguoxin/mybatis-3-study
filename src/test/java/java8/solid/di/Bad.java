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


