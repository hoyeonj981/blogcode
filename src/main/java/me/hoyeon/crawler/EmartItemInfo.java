package me.hoyeon.crawler;

import java.util.EnumMap;

public class EmartItemInfo {

    private final EnumMap<EmartItemInfoEnum, String> itemInfo;

    public EmartItemInfo(final EnumMap<EmartItemInfoEnum, String> itemInfo) {
        this.itemInfo = itemInfo;
    }

    public EmartItemInfo() {
        this(new EnumMap<>(EmartItemInfoEnum.class));
    }


}
