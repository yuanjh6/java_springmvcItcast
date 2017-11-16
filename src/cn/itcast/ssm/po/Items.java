package cn.itcast.ssm.po;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import cn.itcast.ssm.validator.ValidatorGroup1;
import cn.itcast.ssm.validator.ValidatorGroup2;

public class Items {
    private Integer id;
    //商品名称长度必须大于1小于30，message属性就是错误消息
    @Size(min=1,max=30,message="{items.name.length}", groups={ValidatorGroup1.class,ValidatorGroup2.class})
    private String name;
    //价格必须输入
    @NotNull(message="{items.price.notnull}" , groups={ValidatorGroup2.class})
    private Float price;

    private String pic;

    private Date createtime;

    private String detail;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }
}