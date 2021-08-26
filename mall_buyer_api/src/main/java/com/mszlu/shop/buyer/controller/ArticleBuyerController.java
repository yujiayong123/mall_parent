package com.mszlu.shop.buyer.controller;

import com.mszlu.shop.buyer.service.ArticleService;
import com.mszlu.shop.common.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "买家端,文章接口")
@RequestMapping("/article")
public class ArticleBuyerController {

    //1. 问nacos 是否有此服务，nacos回复有 返回调用链接
    //2. 进行rpc调用
    //3. 传参以及解析返回的参数（序列化与反序列化的过程）
    @DubboReference(version = "1.0.0")
    private ArticleService articleService;

    @ApiOperation(value = "分页获取")
    @GetMapping
    public Result getByPage() {
//        int i = 10/0;
        return Result.success(articleService.findArticle());
    }
}