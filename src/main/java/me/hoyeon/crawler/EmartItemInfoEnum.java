package me.hoyeon.crawler;

public enum EmartItemInfoEnum {

    ITEM_NAME("상품 이름"),
    ITEM_BRAND("상품 브랜드"),
    ITME_PRICE("상품 가격"),
    ITEM_UNIT_PRICE("상품 단위 가격"),
    ITEM_REVIEW_COUNT("상품 평점"),
    ITEM_LINK("상품 경로"),
    ;

    private final String info;

    EmartItemInfoEnum(final String info) {
        this.info = info;
    }
}
