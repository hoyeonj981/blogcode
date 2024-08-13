package me.hoyeon.crawler;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;

import java.io.IOException;

public class EmartPriceCrawler {

    /*
    *  해당 URL이 유요한지 검증할 필요가 있다.
     */
    private final String targetUrl;

    public EmartPriceCrawler(final String targetUrl) {
        this.targetUrl = targetUrl;
    }

    public EmartPriceCrawler(Constants urlConstants) {
        this(urlConstants.url());
    }

    EmartItemInfo crawl() {
        var httpClient = HttpClients.createDefault();
        var httpGet = new HttpGet(targetUrl);

        var responseHandler = new ResponseHandler<String>() {
            @Override
            public String handleResponse(final HttpResponse response) throws ClientProtocolException, IOException {
                var statusCode = response.getStatusLine()
                                         .getStatusCode();
                if (statusCode >= 200 && statusCode < 300) {
                    var entity = response.getEntity();
                    return entity != null ? EntityUtils.toString(entity) : null;
                } else {
                    throw new ClientProtocolException("unexpected code : " + statusCode);
                }
            }
        };

        try {
            var responseBody = httpClient.execute(httpGet, responseHandler);
            var doc = Jsoup.parse(responseBody);

            /*
            *   여기서 추출해야할 것들
            *   1. 상품 이름 ("itemNm")
            *   2. 상품 가격
            *   3. 상품 단위 가격
            *   4. 상품 평점
            *   5. 상품 경로 ("itemLnkd")
            *   6. 브랜드 이름 ("brandNm")
            *
            *   elements를 따로따로 추출해도 평점이 없거나 단위 가격이 없는 경우도 존재함. 그냥 파싱하는 것이 가장 효율적
             */


            var itemListElements = doc.selectXpath("//li[@class=\"mnemitem_grid_item\"]");
            itemListElements.forEach(el -> {
                var text = el.text();
                System.out.println(text);
            });
            System.out.println("item list size : " + itemListElements.size());

            System.out.println();
            System.out.println("--------");
            System.out.println();

            /*
            *   pagination이 존재할 경우 추가로 요청을 보내야 한다.
            *
             */

            // pagination 정보
            var pagination = doc.select("#item_navi > div > a");
            pagination.forEach(el -> {
                System.out.println(el.text());
                var attr = el.attr("data-filter-value");
                System.out.println(attr);
            });
            System.out.println(pagination.size());

            System.out.println();
            System.out.println("------");
            System.out.println();

            // 현재 pagination position
            var currentPosition = doc.selectFirst("#item_navi > div > strong");
            System.out.println(currentPosition.text());

        } catch (ClientProtocolException e) {
            // 해당 에러는 도메인 영역, 애플리케이션 에러 등으로 처리할 필요가 있다.
            throw new RuntimeException(e);
        } catch (IOException e) {
            // 해당 에러는 도메인 영역, 애플리케이션 에러 등으로 처리할 필요가 있다.
            throw new RuntimeException(e);
        }

        return new EmartItemInfo();
    }
}
