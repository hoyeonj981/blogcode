package me.hoyeon.crawler;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CrawlerTest {

    @Test
    void 크롤러는_주어진_URL에서_상품별_가격을_추출한다() {
    }

    @Test
    void 크롤러는_주어진_URL이_유효하지_검증한다() {
    }

    @Test
    void name() {
        var crawler = new EmartPriceCrawler(Constants.EMART_URL.url());
        crawler.crawl();
    }
}