package com.mszlu.shop.buyer.controller.goods;

import com.mszlu.shop.buyer.service.goods.GoodsSearchService;
import com.mszlu.shop.common.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "买家端,商品接口")
@RestController
@RequestMapping("/goods")
public class GoodsBuyerController {

    @Autowired
    private GoodsSearchService goodsSearchService;

    @ApiOperation(value = "获取搜索热词")
    @GetMapping("/hot-words")
    public Result<List<String>> getGoodsHotWords(Integer start, Integer end) {
        List<String> hotWords = goodsSearchService.getHotWords(start, end);
        return Result.success(hotWords);
    }

}