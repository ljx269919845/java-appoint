package com.loskatt.appoint.vo;

import com.loskatt.appoint.common.BaseObject;

import io.swagger.annotations.ApiModelProperty;

public class PageSearch extends BaseObject{
    
    @ApiModelProperty(value = "页码")
    private int pageIndex = 1;

    @ApiModelProperty(value = "每页显示数量")
    private int pageSize = 20;
    
    @ApiModelProperty(hidden = true)
    private int offset;
    
    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getOffset() {
        offset = (this.pageIndex-1)*this.pageSize;
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

}

