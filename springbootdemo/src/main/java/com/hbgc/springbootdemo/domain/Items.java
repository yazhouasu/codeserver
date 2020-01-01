package com.hbgc.springbootdemo.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="ITEMS")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer"})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Items extends BaseEntity implements Serializable,Cloneable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; //商品编号
    private String name; //商品名称
    private int price; //价格
    private String pic; //商品图片
    private boolean isFreePost; //是否免邮费；
    private int buyCount; //购买数量
    private int shopId; //商品编号
    private String shopName; //店铺名称
    private int number; //库存数量
    private String property; //面料，材质
    private String province; //产地省份
    private String city; //产地城市
    private int status; //是否下架
    private double discount; //折扣

}
