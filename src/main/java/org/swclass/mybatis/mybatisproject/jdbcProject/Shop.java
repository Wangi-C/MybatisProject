package org.swclass.mybatis.mybatisproject.jdbcProject;

public class Shop {
    private int shopNo;
    private String shopName;
    private String shopLoc;
    private String shopStatus;

    public Shop() {
    }

    public int getShopNo() {
        return shopNo;
    }

    public void setShopNo(int shopNo) {
        this.shopNo = shopNo;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopLoc() {
        return shopLoc;
    }

    public void setShopLoc(String shopLoc) {
        this.shopLoc = shopLoc;
    }

    public String getShopStatus() {
        return shopStatus;
    }

    public void setShopStatus(String shopStatus) {
        this.shopStatus = shopStatus;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "shopNo=" + shopNo +
                ", shopName='" + shopName + '\'' +
                ", shopLoc='" + shopLoc + '\'' +
                ", shopStatus='" + shopStatus + '\'' +
                '}';
    }
}
