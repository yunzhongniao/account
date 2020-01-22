package org.yunzhong.account.datasource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = { "org.yunzhong.account.accounting.dao" })
public class AccountDatasourceConfig {

}
