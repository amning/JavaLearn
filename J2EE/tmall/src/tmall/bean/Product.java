
package tmall.bean;

import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Created by 王宁 on 2017/5/12.
 * 产品
 */
@Repository
public class Product {
    private String name;//产品名称
    private String subTitle;//产品标题
    private float originalPrice;//原价
    private float promotePrice;//折后价格
    private int stock;//库存
    private Date creatDate;//上架日期
    private Category category;//产品分类
    private  int id;//产品id
    private ProductImage firstProductImages;//产品主图
    private List<ProductImage> productImages;//产品大图
    private List<ProductImage> productSingleImages;//产品单个图片
    private List<ProductImage> productDetailImages;//产品详情图

    public int getReviewCount() {
        return reviewCount;
    }

    public void setReviewCount(int reviewCount) {
        this.reviewCount = reviewCount;
    }

    public int getSaleCount() {
        return saleCount;
    }

    public void setSaleCount(int saleCount) {
        this.saleCount = saleCount;
    }

    private int reviewCount;//产品评价数
    private int saleCount;//产品销量数；


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public float getOrignalPrice() {
        return originalPrice;
    }

    public void setOrignalPrice(float originalPrice) {
        this.originalPrice = originalPrice;
    }

    public float getPromotePrice() {
        return promotePrice;
    }

    public void setPromotePrice(float promotePrice) {
        this.promotePrice = promotePrice;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Date getCreatDate() {
        return creatDate;
    }

    public void setCreatDate(Date creatDate) {
        this.creatDate = creatDate;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ProductImage getFirstProductImages() {
        return firstProductImages;
    }

    public void setFirstProductImages(ProductImage firstProductImages) {
        this.firstProductImages = firstProductImages;
    }

    public List<ProductImage> getProductImages() {
        return productImages;
    }

    public void setProductImages(List<ProductImage> productImages) {
        this.productImages = productImages;
    }

    public List<ProductImage> getProductSingleImages() {
        return productSingleImages;
    }

    public void setProductSingleImages(List<ProductImage> productSingleImages) {
        this.productSingleImages = productSingleImages;
    }

    public List<ProductImage> getProductDetailImages() {
        return productDetailImages;
    }

    public void setProductDetailImages(List<ProductImage> productDetailImages) {
        this.productDetailImages = productDetailImages;
    }


}
