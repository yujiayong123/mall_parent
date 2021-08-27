package com.mszlu.shop.buyer.service.goods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class GoodsSearchService {

    private static final String HOT_WORDS_REDIS_KEY = "goods_hot_words";

    @Autowired
    private StringRedisTemplate redisTemplate;

    public List<String> getHotWords(Integer start, Integer end) {
        start = (start-1)*end;
        end = start+end;
        Set<ZSetOperations.TypedTuple<String>> typedTuples = redisTemplate.opsForZSet().reverseRangeByScoreWithScores(HOT_WORDS_REDIS_KEY, start, end);
        List<String> hotWords = new ArrayList<>();
        if (typedTuples == null) {
            return hotWords;
        }
        for (ZSetOperations.TypedTuple<String> typedTuple : typedTuples) {
            hotWords.add(typedTuple.getValue());
        }
        return hotWords;
    }
}
