package me.hoyeon.crawler;

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    private String element = "장바구니 담기 {\"advertBidId\":\"\",\"displayPrc\":\"980\",\"giftBtnShowType\":\"\",\"giftBtnActType\":\"Y\",\"itemChrctDivCd\":\"10\",\"giftBtnMsg\":\"\",\"itemNm\":\"도톰한 물티슈 100매\",\"shppTypeCd\":\"10\",\"shppTypeDtlCd\":\"11\",\"goItemDetailYn\":\"N\",\"dealItemYn\":\"N\",\"itemRegDivCd\":\"20\",\"advertExtensTeryDivCd\":\"\",\"siteNo\":\"6001\",\"brandNm\":\"노브랜드\",\"useForcedSsg\":\"N\",\"cartPsblType\":\"\",\"msgItemDetail\":\"\",\"bsplItemDivCd\":null,\"itemLnkd\":\"https://emart.ssg.com/item/itemView.ssg?itemId=1000051612209&siteNo=6001&salestrNo=2037&tlidSrchWd=노브랜드&srchPgNo=1\",\"bothSsgMorningShppYn\":\"N\",\"drctPurchYn\":\"N\",\"gourmetYn\":\"\",\"itemId\":\"1000051612209\",\"cleaningLabYn\":\"N\",\"uitemId\":\"00000\",\"infloSiteNo\":\"7018\",\"salestrNo\":\"2037\"} 쓱배송 새벽배송 가능 노브랜드 도톰한 물티슈 100매 판매가격 980원 10매 당 98원 상품평점 5점 만점에 4.8 상품평 개수 (185,071) #도톰한물티슈 #가성비\n";

    @Test
    void printName() {
        System.out.println(element);
    }

    @Test
    void parseItemName() {
        var itemNameStart = "\"itemNm\":\"";
        var itemNameEnd = "\"";

        var subString = extract(element, itemNameStart, itemNameEnd);

        System.out.println(subString);
    }

    @Test
    void parseItemLink() {
        var itemLinkStart = "\"itemLnkd\":\"";
        var itemLinkEnd = "\"";

        var subString = extract(element, itemLinkStart, itemLinkEnd);

        System.out.println(subString);
    }

    @Test
    void parseItemPrice() {
        var priceStart = "\"displayPrc\":\"";
        var priceEnd = "\"";

        var extract = extract(element, priceStart, priceEnd);

        System.out.println(extract);
    }

    @Test
    void parseItemUnitPrice() {
        String patternString = "\\d+(매|g|ml) 당 \\d+원";
        Pattern pattern = Pattern.compile(patternString);

        Matcher matcher = pattern.matcher(element);
        while (matcher.find()) {
            String pricePerUnit = matcher.group();
            System.out.println("Price Per Unit: " + pricePerUnit);
        }
    }

    @Test
    void parseItemReview() {
        var reviewStart = element.indexOf("상품평점");
        var review = element.substring(reviewStart+12, reviewStart+15);

        System.out.println(review);
    }

    @Test
    void parseBrandName() {
        var brandNameStart = "\"brandNm\":\"";
        var brandNameEnd = "\"";

        var extract = extract(element, brandNameStart, brandNameEnd);

        System.out.println(extract);
    }

    private String extract(String data, String startKey, String delimiter) {
        int start = data.indexOf(startKey) + startKey.length();
        int end = data.indexOf(delimiter, start);
        return data.substring(start, end);
    }
}