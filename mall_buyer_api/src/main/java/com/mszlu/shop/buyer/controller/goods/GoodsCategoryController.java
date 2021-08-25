package com.mszlu.shop.buyer.controller.goods;

import com.mszlu.shop.buyer.service.goods.GoodsCategoryService;
import com.mszlu.shop.common.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("category")
@Api(tags = "买家端-商品分类")
public class GoodsCategoryController {

    @Autowired
    private GoodsCategoryService goodsCategoryService;

    @ApiOperation(value = "获取商品分类列表")
    @ApiImplicitParam(name = "parentId",required = true,dataType = "Long",value = "上级分类ID，全部分类为：0",paramType = "list")
    @GetMapping("/get/{parentId}")
    public Result list(@PathVariable Long parentId) {
        return goodsCategoryService.listAllChildren(parentId);
    }
}
