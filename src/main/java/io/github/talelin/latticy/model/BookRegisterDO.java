package io.github.talelin.latticy.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.Date;

@TableName("bookregister")
@Data
public class BookRegisterDO {
    //书ID
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    //书名
    private String bookName;
    //书编号
    private String bookNo;
    //借阅状态
    private String state;
    //借书人
    private String borrowerName;
    //借阅人电话
    private String borrowerIphone;
    //开始借阅时间
    private String startTime;
    //结束借阅时间
    private String endTime;
    //续借次数
    private String renew;
    //书本详细描述
    private String describle;
    //封面url

    private String bookImagesUrl;

    @JsonIgnore
    private Date createTime;

    @JsonIgnore
    private Date updateTime;

    @JsonIgnore
    @TableLogic
    private Date deleteTime;
}
