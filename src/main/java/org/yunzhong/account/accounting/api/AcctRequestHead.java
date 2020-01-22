package org.yunzhong.account.accounting.api;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "AcctRequestHead", description = "AcctRequestHead")
public class AcctRequestHead {

    @ApiModelProperty(value = "账套id", example = "01")
    private String accountBookId;

    @ApiModelProperty(value = "应用id", example = "01")
    private String appId;

    @ApiModelProperty(value = "用户名", example = "01")
    private String userName;

    @ApiModelProperty(value = "密码", example = "01")
    private String password;

    @ApiModelProperty(value = "版本", example = "v1")
    private String version;

    @ApiModelProperty(value = "认证标识", example = "01")
    private String sign;
}
