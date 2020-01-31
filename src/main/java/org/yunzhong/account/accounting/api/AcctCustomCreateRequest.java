package org.yunzhong.account.accounting.api;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@ApiModel(value = "AcctCustomCreateRequest", description = "AcctCustomCreateRequest")
public class AcctCustomCreateRequest extends AcctBasicRequestBody{

	@ApiModelProperty(value = "accountBookId", example = "01")
    private String accountBookId;
	
	@ApiModelProperty(value = "acctType", example = "01")
	private String acctType;
}
