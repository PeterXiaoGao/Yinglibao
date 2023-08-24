package com.bjpowernode.api.pojo;

import com.bjpowernode.api.model.User;

import java.math.BigDecimal;

/**
 * @author xiaogao
 * @version 1.0
 * @className UserAccountInfo
 * @description
 * @since 1.0
 */
public class UserAccountInfo extends User {
    private BigDecimal availableMoney;

    public BigDecimal getAvailableMoney() {
        return availableMoney;
    }

    public void setAvailableMoney(BigDecimal availableMoney) {
        this.availableMoney = availableMoney;
    }
}
