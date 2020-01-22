package org.yunzhong.account.accounting.api;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "AcctBasicRequestBody", description = "AcctBasicRequestBody")
public class AcctBasicRequestBody {

    @ApiModelProperty(value = "accountBookId", example = "01")
    private String accountBookId;
}
