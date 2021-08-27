package com.mszlu.shop.buyer.controller.pages;

import com.mszlu.shop.buyer.service.PageService;
import com.mszlu.shop.buyer.service.goods.pages.PagesService;
import com.mszlu.shop.common.vo.Result;
import com.mszlu.shop.model.buyer.enums.PageType;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pages")
public class PagesController {

    @Autowired
    private PagesService pagesService;

    @GetMapping("index")
    public Result index(Integer clientType){

        return pagesService.getPageIndexData(clientType, PageType.INDEX.getCode());
    }
}
