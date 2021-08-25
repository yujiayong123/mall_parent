package com.mszlu.shop.buyer.service;

import com.mszlu.shop.model.buyer.vo.CategoryVO;

import java.util.List;

public interface CategoryService {
    /**
     * 根据父id获取对应商品分类列表
     * @param parentId
     * @return
     */
    List<CategoryVO> findCategoryTree(Long parentId);
}
