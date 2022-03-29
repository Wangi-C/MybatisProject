package org.swclass.mybatis.mybatisproject.step1;

public class Shop {
    private int shopNo;
    private String shopName;
    private String shopLoc;
    private String shopStatus;

    public Shop() {
    }

    public Shop(int shopNo, String shopName, String shopLoc, String shopStatus) {
        this.shopNo = shopNo;
        this.shopName = shopName;
        this.shopLoc = shopLoc;
        this.shopStatus = shopStatus;
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
