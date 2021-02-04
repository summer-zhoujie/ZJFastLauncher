package com.zj.fastlauncher.db.entities;

import android.text.TextUtils;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

import java.util.Objects;

/**
 * 表: 记录捕获到的可进行跳转的界面信息
 */
@Entity
public class ActCanJump {
    @Id(autoincrement = true)
    public Long id;

    /**
     * 界面全路径
     */
    private String act;

    /**
     * 跳过控件数组, ',' 号隔开的一个String
     */
    private String jumpIds;

    @Generated(hash = 1786795113)
    public ActCanJump(Long id, String act, String jumpIds) {
        this.id = id;
        this.act = act;
        this.jumpIds = jumpIds;
    }

    @Generated(hash = 1855282583)
    public ActCanJump() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAct() {
        return this.act;
    }

    public void setAct(String act) {
        this.act = act;
    }

    public String getJumpIds() {
        return this.jumpIds;
    }

    public void setJumpIds(String jumpIds) {
        this.jumpIds = jumpIds;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ActCanJump)) {
            return false;
        }

        return TextUtils.equals(act, ((ActCanJump) o).act);
    }

    @Override
    public String toString() {
        return "ActCanJump{" +
                "id=" + id +
                ", act='" + act + '\'' +
                ", jumpIds='" + jumpIds + '\'' +
                '}';
    }
}
