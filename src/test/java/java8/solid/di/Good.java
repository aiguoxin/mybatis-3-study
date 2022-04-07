package java8.solid.di;

/**
 * 2022/4/6 下午4:52
 * aiguoxin 
 * 说明:
 */
public class Good {
    private IHttpClient httpClient;

    public Good(IHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public String getWeather(){
        return this.httpClient.get();
    }
}

interface IHttpClient {
    String get();
}

class DefaultHttpClient implements IHttpClient {

    @Override
    public String get() {
        return "";
    }
}
