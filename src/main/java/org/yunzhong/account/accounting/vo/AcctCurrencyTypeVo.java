package org.yunzhong.account.accounting.vo;

import org.yunzhong.account.accounting.api.AcctBasicRequestBody;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@ApiModel(value = "AcctCurrencyTypeVo", description = "AcctCurrencyTypeVo")
public class AcctCurrencyTypeVo extends AcctBasicRequestBody {

    @ApiModelProperty(value = "币种编码", example = "01")
    private String currtype;

    @ApiModelProperty(value = "币种名称", example = "01")
    private String currname;

    @ApiModelProperty(value = "本币标识", example = "01")
    private Byte currlocal;

}