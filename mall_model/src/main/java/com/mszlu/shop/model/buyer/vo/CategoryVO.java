package com.mszlu.shop.model.buyer.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryVO implements Serializable {

    @ApiModelProperty(value = "父节点名称")
    private String parentTitle;

    @ApiModelProperty("子分类列表")
    private List<CategoryVO> children;

    private Long id;

    private String name;

    private Long parentId;

    private Integer level;

    private Integer sortOrder;

    private Double commissionRate;

    private String image;

    private Boolean supportChannel;

//
//    @ApiModelProperty("分类关联的品牌列表")
//    private List<Brand> brandList;
//
//    public List<CategoryVO> getChildren() {
//
//        if (children != null) {
//            children.sort(new Comparator<CategoryVO>() {
//                @Override
//                public int compare(CategoryVO o1, CategoryVO o2) {
//                    return o1.getSortOrder().compareTo(o2.getSortOrder());
//                }
//            });
//            return children;
//        }
//        return null;
//    }
}