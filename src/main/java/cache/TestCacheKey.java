package cache;

import lombok.Getter;

public enum TestCacheKey {
    OLD_TIME_OF_EVENT_BEGINNING("oldTimeOfEventBeginning"),
    NEW_TIME_ZONE("newTimwZone"),
    ZERO_TIME_OF_EVENT_BEGINNING("zeroTimeOfEventBeginning"),
    TIME_ZONE_TEXT("timeZoneText");

    @Getter
    private final String key;

    TestCacheKey(String key) {
        this.key = key;
    }
}

