package com.mszlu.shop.buyer.service.goods.pages;

import com.mszlu.shop.buyer.service.PageService;
import com.mszlu.shop.common.vo.Result;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;

@Service
public class PagesService {

    @DubboReference(version = "1.0.0")
    private PageService pageService;

    public Result getPageIndexData(Integer clientType, int pageType) {
        return pageService.findPageTemplate(clientType,pageType);
    }
}
