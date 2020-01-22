package org.yunzhong.account.accounting.api;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "AcctRequest", description = "AcctRequest")
public class AcctRequest<T extends AcctBasicRequestBody> {

    @ApiModelProperty(value = "通用数据")
    private AcctRequestHead head;

    @ApiModelProperty(value = "具体数据")
    private T body;
}
