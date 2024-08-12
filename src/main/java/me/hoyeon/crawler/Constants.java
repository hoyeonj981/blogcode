package me.hoyeon.crawler;

public enum Constants {

//    EMART_URL("https://emart.ssg.com/search.ssg?target=all&query=%EA%B0%90%EC%9E%90&shpp=ssgem"),
    EMART_URL("https://emart.ssg.com/search.ssg?target=all&query=%EB%85%B8%EB%B8%8C%EB%9E%9C%EB%93%9C&page=&shpp=ssgem"),
    ;

    private final String targetUrl;

    Constants(final String targetUrl) {
        this.targetUrl = targetUrl;
    }

    public String url() {
        return this.targetUrl;
    }
}
