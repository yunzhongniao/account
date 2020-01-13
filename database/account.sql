/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50717
 Source Host           : localhost:3306
 Source Schema         : account

 Target Server Type    : MySQL
 Target Server Version : 50717
 File Encoding         : 65001

 Date: 13/01/2020 08:32:02
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_acct_account_book
-- ----------------------------
DROP TABLE IF EXISTS `t_acct_account_book`;
CREATE TABLE `t_acct_account_book`  (
  `account_book_id` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '帐套编号',
  `account_book_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '帐套名称',
  `state` varchar(1) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '帐套状态  0:待启用 1:正常 2:停用',
  `rootinstcd` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '对应机构编码',
  `crtime` datetime(0) NOT NULL COMMENT '创建时间',
  `cruser` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '创建者',
  `shutuptime` datetime(0) NULL DEFAULT NULL COMMENT '启用时间',
  `shutupuser` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '启用者',
  `shutdowntime` datetime(0) NULL DEFAULT NULL COMMENT '关闭时间',
  `shutdownuser` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '关闭者',
  `account_book_type` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '帐套类型',
  PRIMARY KEY (`account_book_id`) USING BTREE,
  INDEX `idx_caacctosb_typeidx`(`account_book_type`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '帐套定义表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_acct_account_book
-- ----------------------------
INSERT INTO `t_acct_account_book` VALUES ('1', '1', '1', '1', '2019-03-05 17:17:17', '1', '2019-03-05 17:17:23', '1', '2019-03-05 17:17:26', '1', '1');
INSERT INTO `t_acct_account_book` VALUES ('2', '2', '2', '2', '2019-03-06 11:10:16', '2', '2019-03-06 11:10:20', '2', '2019-03-06 11:10:23', '2', '2');
INSERT INTO `t_acct_account_book` VALUES ('3', '3', '3', '3', '2019-03-07 11:12:02', '3', '2019-03-08 11:12:25', NULL, '2019-03-07 11:12:17', '3', '3');

-- ----------------------------
-- Table structure for t_acct_account_book_type
-- ----------------------------
DROP TABLE IF EXISTS `t_acct_account_book_type`;
CREATE TABLE `t_acct_account_book_type`  (
  `account_book_type` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '帐套类型码',
  `account_book_type_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '帐套类型名称',
  PRIMARY KEY (`account_book_type`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '帐套类型表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_acct_account_type
-- ----------------------------
DROP TABLE IF EXISTS `t_acct_account_type`;
CREATE TABLE `t_acct_account_type`  (
  `account_book_type` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '帐套类型',
  `accttype` varchar(2) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '账户类型',
  `typename` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '类型名称',
  `cusentry` tinyint(1) NULL DEFAULT NULL COMMENT '是否限制必须为客户账户',
  `caentry` tinyint(1) NULL DEFAULT NULL COMMENT '是否限制必须为载体账户',
  PRIMARY KEY (`account_book_type`, `accttype`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '账户类型定义表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_acct_catype
-- ----------------------------
DROP TABLE IF EXISTS `t_acct_catype`;
CREATE TABLE `t_acct_catype`  (
  `catypeid` varchar(2) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '载体类型编号',
  `catypename` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '载体类型名称',
  `iscus` tinyint(4) NULL DEFAULT NULL COMMENT '限制载体号与客户号一致',
  `account_book_type` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '帐套类型',
  PRIMARY KEY (`catypeid`, `account_book_type`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '载体类型定义表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_acct_currency_type
-- ----------------------------
DROP TABLE IF EXISTS `t_acct_currency_type`;
CREATE TABLE `t_acct_currency_type`  (
  `currtype` char(3) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '币种代码',
  `currname` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '币种名称',
  `currlocal` tinyint(4) NULL DEFAULT NULL COMMENT '本币标识',
  PRIMARY KEY (`currtype`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '币种参数表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_acct_custom
-- ----------------------------
DROP TABLE IF EXISTS `t_acct_custom`;
CREATE TABLE `t_acct_custom`  (
  `account_book_id` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '所属帐套号',
  `acctno` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '账号',
  `currtype` varchar(3) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '币种',
  `acctname` varchar(150) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '账户名称',
  `cpflag` tinyint(4) NOT NULL COMMENT '个人单位标识,  0：个人 1：单位',
  `acctstatus` varchar(2) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '账户状态',
  `accttype` varchar(2) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '账户类型',
  `acctpwd` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '账户密码',
  `itemcode` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '科目号',
  `balby` tinyint(4) NOT NULL COMMENT '余额方向',
  `cusid` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '客户编号',
  `acctcatype` varchar(2) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '账户载体类型',
  `acctcaid` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '账户载体编号',
  `balance` decimal(20, 0) NULL DEFAULT NULL COMMENT '当前余额',
  `allowpay` tinyint(4) NULL DEFAULT NULL COMMENT '允许付款',
  `allowrecharge` tinyint(4) NULL DEFAULT NULL COMMENT '允许充值',
  `allowdeposit` tinyint(4) NULL DEFAULT NULL COMMENT '允许提现',
  `allowtfin` tinyint(4) NULL DEFAULT NULL COMMENT '允许转账转入',
  `allowtfout` tinyint(4) NULL DEFAULT NULL COMMENT '允许转账转出',
  `allowin` tinyint(4) NULL DEFAULT NULL COMMENT '允许余额增加',
  `allowout` tinyint(4) NULL DEFAULT NULL COMMENT '允许余额减少 ',
  `overdramamt` decimal(20, 0) NULL DEFAULT NULL COMMENT '透支额度',
  `drmaxamt` decimal(20, 0) NULL DEFAULT NULL COMMENT '单笔借记最大金额',
  `crmaxamt` decimal(20, 0) NULL DEFAULT NULL COMMENT '单笔贷记账最大金额',
  `drdtmaxamt` decimal(20, 0) NULL DEFAULT NULL COMMENT '日借记最大金额',
  `drdtamt` decimal(20, 0) NULL DEFAULT NULL COMMENT '当前日借记金额累计',
  `drdtmaxcnt` decimal(20, 0) NULL DEFAULT NULL COMMENT '日借记最大笔数',
  `drdtcnt` decimal(20, 0) NULL DEFAULT NULL COMMENT '当前日借记笔数累计',
  `drmtmaxamt` decimal(20, 0) NULL DEFAULT NULL COMMENT '月借记最大金额',
  `drmtamt` decimal(20, 0) NULL DEFAULT NULL COMMENT '当前月借记金额累计',
  `drmtmaxcnt` decimal(20, 0) NULL DEFAULT NULL COMMENT '月借记最大笔数 ',
  `drmtcnt` decimal(20, 0) NULL DEFAULT NULL COMMENT '当前月借记笔数累计',
  `crdtmaxamt` decimal(20, 0) NULL DEFAULT NULL COMMENT '日贷记最大金额',
  `crdtamt` decimal(20, 0) NULL DEFAULT NULL COMMENT '当前日贷记金额累计',
  `crdtmaxcnt` decimal(20, 0) NULL DEFAULT NULL COMMENT '日贷记最大笔数',
  `crdtcnt` decimal(20, 0) NULL DEFAULT NULL COMMENT '当前日贷记笔数累计 ',
  `crmtmaxamt` decimal(20, 0) NULL DEFAULT NULL COMMENT '月贷记最大金额',
  `crmtamt` decimal(20, 0) NULL DEFAULT NULL COMMENT '当期月贷记金额累计',
  `crmtmaxcnt` decimal(20, 0) NULL DEFAULT NULL COMMENT '月贷记最大笔数',
  `crmtcnt` decimal(20, 0) NULL DEFAULT NULL COMMENT '当前月贷记笔数累计',
  `lsttrxtime` datetime(0) NULL DEFAULT NULL COMMENT '最后交易时间',
  `lstcintdat` varchar(8) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '最后计息日',
  `cintcycle` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '计息周期',
  `cintratect` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '利率变动方式',
  `cintratecode` varchar(8) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '利率代码',
  `cintcn` decimal(20, 0) NULL DEFAULT NULL COMMENT '计息积数',
  `crappid` varchar(8) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '开户应用',
  `cruser` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '开户者',
  `crtime` datetime(0) NOT NULL COMMENT '开户日期',
  `dtappid` varchar(8) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '销户应用',
  `dtuser` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '销户者',
  `dttime` datetime(0) NULL DEFAULT NULL COMMENT '销户日期',
  `acctreserved` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '备注',
  `mainacct` tinyint(4) NULL DEFAULT NULL COMMENT '是否为主账户',
  `reglimitcusswitch` tinyint(4) NULL DEFAULT NULL COMMENT '此账户是否关联客户额度变更',
  `cqacct` tinyint(4) NULL DEFAULT NULL COMMENT '是否为客户可查询账户',
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '唯一标识',
  PRIMARY KEY (`acctno`, `account_book_id`) USING BTREE,
  UNIQUE INDEX `cusacctcaidx`(`acctcaid`, `acctcatype`, `itemcode`, `account_book_id`) USING BTREE,
  UNIQUE INDEX `cusacctididx`(`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '客户账户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_acct_custom_limit
-- ----------------------------
DROP TABLE IF EXISTS `t_acct_custom_limit`;
CREATE TABLE `t_acct_custom_limit`  (
  `osbid` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '帐套编号',
  `cusid` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '客户号',
  `drmaxamt` decimal(20, 0) NULL DEFAULT NULL COMMENT '单笔借记最大金额',
  `crmaxamt` decimal(20, 0) NULL DEFAULT NULL COMMENT '单笔贷记账最大金额',
  `drdtmaxamt` decimal(20, 0) NULL DEFAULT NULL COMMENT '日借记最大金额',
  `drdtamt` decimal(20, 0) NULL DEFAULT NULL COMMENT '当前日借记金额累计',
  `drdtmaxcnt` decimal(20, 0) NULL DEFAULT NULL COMMENT '日借记最大笔数',
  `drdtcnt` decimal(20, 0) NULL DEFAULT NULL COMMENT '当前日借记笔数累计',
  `drmtmaxamt` decimal(20, 0) NULL DEFAULT NULL COMMENT '月借记最大金额',
  `drmtamt` decimal(20, 0) NULL DEFAULT NULL COMMENT '当前月借记金额累计',
  `drmtmaxcnt` decimal(20, 0) NULL DEFAULT NULL COMMENT '月借记最大笔数',
  `drmtcnt` decimal(20, 0) NULL DEFAULT NULL COMMENT '当前月借记笔数累计',
  `crdtmaxamt` decimal(20, 0) NULL DEFAULT NULL COMMENT '日贷记最大金额',
  `crdtamt` decimal(20, 0) NULL DEFAULT NULL COMMENT '当前日贷记金额累计',
  `crdtmaxcnt` decimal(20, 0) NULL DEFAULT NULL COMMENT '日贷记最大笔数',
  `crdtcnt` decimal(20, 0) NULL DEFAULT NULL COMMENT '当前日贷记笔数累计',
  `crmtmaxamt` decimal(20, 0) NULL DEFAULT NULL COMMENT '月贷记最大金额',
  `crmtamt` decimal(20, 0) NULL DEFAULT NULL COMMENT '当期月贷记金额累计',
  `crmtmaxcnt` decimal(20, 0) NULL DEFAULT NULL COMMENT '月贷记最大笔数',
  `crmtcnt` decimal(20, 0) NULL DEFAULT NULL COMMENT '当前月贷记笔数累计',
  `lsttrxtime` datetime(0) NULL DEFAULT NULL COMMENT '最后交易时间',
  `state` char(1) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '状态',
  `deltime` datetime(0) NULL DEFAULT NULL COMMENT '删除时间',
  `limitid` bigint(20) NOT NULL COMMENT '自增序号',
  PRIMARY KEY (`limitid`) USING BTREE,
  INDEX `idx_cphcuslimit`(`osbid`, `state`, `cusid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '客户额度表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_acct_diary
-- ----------------------------
DROP TABLE IF EXISTS `t_acct_diary`;
CREATE TABLE `t_acct_diary`  (
  `account_book_id` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '所属帐套',
  `acctno` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '账户',
  `periodday` varchar(8) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '日期',
  `currtype` char(3) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '币种',
  `openbal` decimal(20, 0) NULL DEFAULT 0 COMMENT '昨日余额',
  `opendrbal` decimal(20, 0) NULL DEFAULT 0 COMMENT '昨日借方余额',
  `closedramt` decimal(20, 0) NULL DEFAULT 0 COMMENT '本日借方发生额',
  `closedrcnt` decimal(20, 0) NULL DEFAULT 0 COMMENT '本日借方累计笔数',
  `closedrbal` decimal(20, 0) NULL DEFAULT 0 COMMENT '本日借方余额',
  `opencrbal` decimal(20, 0) NULL DEFAULT 0 COMMENT '昨日贷方余额',
  `closecramt` decimal(20, 0) NULL DEFAULT 0 COMMENT '本日贷方发生额',
  `closecrcnt` decimal(20, 0) NULL DEFAULT 0 COMMENT '本日贷方累计笔数',
  `closecrbal` decimal(20, 0) NULL DEFAULT 0 COMMENT '本日贷方余额',
  `closebal` decimal(20, 0) NULL DEFAULT 0 COMMENT '本日余额',
  `iscus` tinyint(3) UNSIGNED ZEROFILL NOT NULL COMMENT '是否为客户账户',
  `acctname` varchar(150) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '账户名称',
  `itemcode` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '账户所属科目号',
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '唯一流水号',
  PRIMARY KEY (`account_book_id`, `acctno`, `periodday`) USING BTREE,
  UNIQUE INDEX `idx_caacctdiary`(`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '账户历史余额(日记表)' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_acct_entry_detail
-- ----------------------------
DROP TABLE IF EXISTS `t_acct_entry_detail`;
CREATE TABLE `t_acct_entry_detail`  (
  `account_book_id` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '帐套编号',
  `vouchertype` varchar(2) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '凭证类型',
  `voucherno` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '凭证号',
  `iscusacct` tinyint(4) NOT NULL COMMENT '账户是否为客户账户',
  `acctno` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '账号',
  `currtype` char(3) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '币种',
  `entryno` bigint(20) NOT NULL COMMENT '分录批次号 ',
  `entrypty` bigint(20) NOT NULL COMMENT '分录组内优先级',
  `pid` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '产品类型码',
  `trxcode` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '交易类型码',
  `trxid` varchar(200) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '交易流水号',
  `refvoucherno` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '关联凭证号',
  `parenttrxid` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '父交易流水号',
  `childtrxid` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '子交易流水号',
  `entrydate` varchar(8) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '入账日期',
  `entrytime` datetime(0) NULL DEFAULT NULL COMMENT '入账时间',
  `crdr` tinyint(4) NOT NULL COMMENT '借贷方向',
  `amount` decimal(20, 0) NOT NULL COMMENT '入账金额',
  `curbal` decimal(20, 0) NOT NULL COMMENT '当前余额',
  `reciporgtype` varchar(2) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '对方机构类型',
  `reciporgcode` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '对方机构编号',
  `recipacctno` varchar(40) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '对方账号',
  `postflag` tinyint(4) NOT NULL COMMENT '过账标志',
  `postdate` varchar(8) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '过账日期',
  `posttime` datetime(0) NULL DEFAULT NULL COMMENT '过账时间',
  `postbatch` varchar(15) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '过账批次',
  `genledflag` tinyint(4) NOT NULL COMMENT '是否更新总账标志',
  `genleddate` varchar(8) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '更新总账日期',
  `genledtime` datetime(0) NULL DEFAULT NULL COMMENT '更新总账时间',
  `genledbatch` varchar(15) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '更新总账批次',
  `memo` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '交易摘要',
  `isrevd` tinyint(4) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '是否已冲账',
  `entrytype` tinyint(4) NULL DEFAULT NULL COMMENT '分录类型 1：正常分录 9：冲账分录',
  `revtime` datetime(0) NULL DEFAULT NULL COMMENT '冲账时间',
  `revtype` tinyint(4) NULL DEFAULT NULL COMMENT '冲账方式 0：红字冲账法 1：借贷冲账法',
  `entrybatch` bigint(20) NOT NULL COMMENT '分录批次',
  `acctname` varchar(150) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '账户名称',
  `reglimitcus` decimal(20, 0) NULL DEFAULT NULL COMMENT '此分录涉及客户额度值',
  `reglimitca` decimal(20, 0) NULL DEFAULT NULL COMMENT '此分录涉及载体额度值',
  `reglimitacct` tinyint(1) NULL DEFAULT NULL COMMENT '此分录是否涉及账户额度',
  `accttype` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '账户类型',
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '唯一标识',
  PRIMARY KEY (`voucherno`, `entryno`, `account_book_id`, `entrypty`) USING BTREE,
  UNIQUE INDEX `acctenyididx`(`id`) USING BTREE,
  INDEX `acctenyacctnoidx`(`acctno`) USING BTREE,
  INDEX `acctenybatchidx`(`entrybatch`) USING BTREE,
  INDEX `acctenyentrydateidx`(`entrytime`, `entrydate`) USING BTREE,
  INDEX `acctenygenledflagidx`(`genledflag`) USING BTREE,
  INDEX `acctenypididx`(`pid`) USING BTREE,
  INDEX `acctenysetbookidx`(`account_book_id`) USING BTREE,
  INDEX `acctenytrxcodeidx`(`trxcode`) USING BTREE,
  INDEX `acctenytrxididx`(`trxid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '分录明细表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_acct_entry_rule
-- ----------------------------
DROP TABLE IF EXISTS `t_acct_entry_rule`;
CREATE TABLE `t_acct_entry_rule`  (
  `efid` bigint(20) NOT NULL COMMENT '规则编号',
  `efname` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '规则名称',
  `account_book_type` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '帐套类型',
  `trxdir` varchar(6) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '交易方向',
  `pid` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '产品号',
  `trxcode` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '交易类型码',
  `actionx` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '动作类型',
  `entrygrp` tinyint(4) NOT NULL DEFAULT 1 COMMENT '规则分组标识',
  `entrysubgrp` tinyint(4) NOT NULL DEFAULT 1 COMMENT '规则子分组标识',
  `entrypty` tinyint(4) NOT NULL COMMENT '子组内处理优先级',
  `orgtype` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '机构类型取值   0:内部 1: 银行 2:渠道 机构类型',
  `orgcode` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '机构编号取值',
  `acctnature` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '账户性质取值',
  `acctcatype` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '账户载体取值',
  `accttype` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '账户类型取值',
  `acctno` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '账户取值',
  `itemcode` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '科目号',
  `fwsfather` tinyint(4) NULL DEFAULT NULL COMMENT '是否查询同父亲下的账户',
  `crdr` tinyint(4) NOT NULL COMMENT '借贷方向',
  `amount` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '金额公式',
  `reciporgtype` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '对方机构类型',
  `reciporgcode` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '对方机构号',
  `recipacctno` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '对方账户号',
  `postatonce` tinyint(4) NULL DEFAULT 1 COMMENT '是否实时过账，统一设为1',
  `genledatonce` tinyint(4) NULL DEFAULT 1 COMMENT '是否实时更新总账，暂时先设为1',
  PRIMARY KEY (`efid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '分录规则表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_acct_genled
-- ----------------------------
DROP TABLE IF EXISTS `t_acct_genled`;
CREATE TABLE `t_acct_genled`  (
  `account_book_id` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '所属帐套',
  `itemcode` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '科目号',
  `itembalby` tinyint(4) NOT NULL COMMENT '科目余额方向 1:  借方反映余额 2:  贷方反映余额 3:  双方反映余额 4:  轧差反映余额',
  `itemclass` tinyint(4) NOT NULL COMMENT '科目类别 1:  资产类 2:  负债类 3: 资产负债共同类  4:  所有者权益类 5:成本类 6:  损益类\n',
  `currtype` char(3) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '币种',
  `lydrbal` decimal(20, 0) NULL DEFAULT 0 COMMENT '上年末借方余额',
  `lycrbal` decimal(20, 0) NULL DEFAULT 0 COMMENT '上年末贷方余额',
  `tydramt` decimal(20, 0) NULL DEFAULT 0 COMMENT '本年累计借方发生额',
  `tycramt` decimal(20, 0) NULL DEFAULT 0 COMMENT '本年累计贷方发生额',
  `tydrcnt` decimal(20, 0) NULL DEFAULT 0 COMMENT '本年累计借方笔数',
  `tycrcnt` decimal(20, 0) NULL DEFAULT 0 COMMENT '本年累计贷方笔数',
  `lmdrbal` decimal(20, 0) NULL DEFAULT 0 COMMENT '上月末借方余额',
  `lmcrbal` decimal(20, 0) NULL DEFAULT 0 COMMENT '上月末贷方余额',
  `tmdramt` decimal(20, 0) NULL DEFAULT 0 COMMENT '本月累计借方发生额',
  `tmcramt` decimal(20, 0) NULL DEFAULT 0 COMMENT '本月累计贷方发生额',
  `tmdrcnt` decimal(20, 0) NULL DEFAULT 0 COMMENT '本月累计借方笔数',
  `tmcrcnt` decimal(20, 0) NULL DEFAULT 0 COMMENT '本月累计贷方笔数',
  `lddrbal` decimal(20, 0) NULL DEFAULT 0 COMMENT '昨日借方余额',
  `ldcrbal` decimal(20, 0) NULL DEFAULT 0 COMMENT '昨日贷方余额',
  `tddramt` decimal(20, 0) NULL DEFAULT 0 COMMENT '本日累计借方发生额',
  `tdcramt` decimal(20, 0) NULL DEFAULT 0 COMMENT '本日累计贷方发生额',
  `tddrcnt` decimal(20, 0) NULL DEFAULT 0 COMMENT '本日累计借方笔数',
  `tdcrcnt` decimal(20, 0) NULL DEFAULT 0 COMMENT '本日累计贷方笔数',
  `tddrbal` decimal(20, 0) NULL DEFAULT 0 COMMENT '本日借方余额',
  `tdcrbal` decimal(20, 0) NULL DEFAULT 0 COMMENT '本日贷方余额',
  PRIMARY KEY (`account_book_id`, `itemcode`) USING BTREE,
  INDEX `genleditemclassidx`(`itemclass`) USING BTREE,
  INDEX `genleditemcodeidx`(`itemcode`) USING BTREE,
  INDEX `genleditemnatueidx`(`itembalby`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '总分类账表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_acct_genled_detail
-- ----------------------------
DROP TABLE IF EXISTS `t_acct_genled_detail`;
CREATE TABLE `t_acct_genled_detail`  (
  `account_book_id` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '所属帐套',
  `itemcode` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '科目号',
  `itembalby` tinyint(4) NOT NULL COMMENT '科目余额方向',
  `itemclass` tinyint(4) NOT NULL COMMENT '科目类别',
  `currtype` char(3) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '币种',
  `periodday` varchar(8) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '日期',
  `lddrbal` decimal(20, 0) NULL DEFAULT 0 COMMENT '昨日借方余额',
  `ldcrbal` decimal(20, 0) NULL DEFAULT 0 COMMENT '昨日贷方余额',
  `tddramt` decimal(20, 0) NULL DEFAULT 0 COMMENT '本日累计借方发生额',
  `tdcramt` decimal(20, 0) NULL DEFAULT 0 COMMENT '本日累计贷方发生额',
  `tddrcnt` decimal(20, 0) NULL DEFAULT 0 COMMENT '本日累计借方笔数',
  `tdcrcnt` decimal(20, 0) NULL DEFAULT 0 COMMENT '本日累计贷方笔数',
  `tddrbal` decimal(20, 0) NULL DEFAULT 0 COMMENT '本日借方余额',
  `tdcrbal` decimal(20, 0) NULL DEFAULT 0 COMMENT '本日贷方余额',
  PRIMARY KEY (`account_book_id`, `itemcode`, `periodday`) USING BTREE,
  INDEX `genleddetailitemclassidx`(`itemclass`) USING BTREE,
  INDEX `genleddetailitemcodeidx`(`itemcode`) USING BTREE,
  INDEX `genleddetailitemnatueidx`(`itembalby`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '总分类账历史明细' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_acct_item
-- ----------------------------
DROP TABLE IF EXISTS `t_acct_item`;
CREATE TABLE `t_acct_item`  (
  `account_book_type` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '帐套类型',
  `itemcode` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '科目号',
  `itemname` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '科目名称',
  `itembalby` tinyint(4) NOT NULL COMMENT '1:  借方反映余额 2:  贷方反映余额 3:  双方反映余额 4:  轧差反映余额',
  `itemclass` tinyint(4) NOT NULL COMMENT '1:  资产类 2:  负债类 3: 资产负债共同类  4:  所有者权益类 5:成本类 6:  损益类\n',
  `itemnotes` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '变更科目号',
  `itemlevel` tinyint(4) NOT NULL COMMENT '科目级别',
  `itemfather` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '上级科目号',
  `currtype` char(3) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '币种',
  `mainacct` tinyint(4) NULL DEFAULT NULL COMMENT '是否为客户类主账户',
  `cqacct` tinyint(4) NULL DEFAULT NULL COMMENT '是否客户可查询',
  PRIMARY KEY (`account_book_type`, `itemcode`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '会计科目表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_acct_template
-- ----------------------------
DROP TABLE IF EXISTS `t_acct_template`;
CREATE TABLE `t_acct_template`  (
  `tplid` bigint(20) NOT NULL COMMENT '模板编号',
  `tplname` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '模板名称',
  `account_book_type` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '所属帐套',
  `accttype` varchar(2) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '账户类型',
  `acctnamepfx` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '账户名称前缀',
  `acctnameafx` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '账户名称后缀',
  `acctnameformula` varchar(200) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '账户名称公式',
  `forcefx` tinyint(4) NULL DEFAULT NULL COMMENT '强制使用账户前后缀',
  `acctstatus` varchar(2) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '账户初始状态',
  `itemcode` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '所属科目',
  `allowpay` tinyint(4) NULL DEFAULT NULL COMMENT '允许付款',
  `allowrecharge` tinyint(4) NULL DEFAULT NULL COMMENT '允许充值',
  `allowdeposit` tinyint(4) NULL DEFAULT NULL COMMENT '允许提现',
  `allowtfin` tinyint(4) NULL DEFAULT NULL COMMENT '允许转账转入',
  `allowtfout` tinyint(4) NULL DEFAULT NULL COMMENT '允许转账转出',
  `allowin` tinyint(4) NULL DEFAULT NULL COMMENT '允许余额增加',
  `allowout` tinyint(4) NULL DEFAULT NULL COMMENT '允许余额较少',
  `overdramamt` decimal(20, 0) NULL DEFAULT NULL COMMENT '透支额度',
  `drmaxamt` decimal(20, 0) NULL DEFAULT NULL COMMENT '借记单笔金额限制',
  `crmaxamt` decimal(20, 0) NULL DEFAULT NULL COMMENT '贷记单笔金额限制',
  `drdtmaxamt` decimal(20, 0) NULL DEFAULT NULL COMMENT '日借记累计金额限制',
  `drdtmaxcnt` decimal(20, 0) NULL DEFAULT NULL COMMENT '日借记累计笔数限制',
  `drmtmaxamt` decimal(20, 0) NULL DEFAULT NULL COMMENT '月借记累计金额限制',
  `drmtmaxcnt` decimal(20, 0) NULL DEFAULT NULL COMMENT '月借记累计笔数限制',
  `crdtmaxamt` decimal(20, 0) NULL DEFAULT NULL COMMENT '日贷记累计金额限制',
  `crdtmaxcnt` decimal(20, 0) NULL DEFAULT NULL COMMENT '日贷记累计笔数限制',
  `crmtmaxamt` decimal(20, 0) NULL DEFAULT NULL COMMENT '月贷记累计金额限制',
  `crmtmaxcnt` decimal(20, 0) NULL DEFAULT NULL COMMENT '月贷记累计笔数限制',
  `reglimitcusswitch` tinyint(1) NULL DEFAULT NULL COMMENT '是否登记客户额度',
  `reglimitcaswitch` tinyint(1) NULL DEFAULT NULL COMMENT '是否登记载体额度',
  `octype` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '关联机构类型',
  PRIMARY KEY (`tplid`) USING BTREE,
  INDEX `idx_caaccttpl_osbtype`(`account_book_type`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '账户创建模板表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_acct_transaction_cat
-- ----------------------------
DROP TABLE IF EXISTS `t_acct_transaction_cat`;
CREATE TABLE `t_acct_transaction_cat`  (
  `trxcode` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '交易类型码',
  `trxcat` tinyint(4) NULL DEFAULT NULL COMMENT '类别，-1未定义 9：网银入账类型',
  `trxname` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '交易类型名称',
  `showinpage` char(1) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '显示在运营界面',
  `showinmer` char(1) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '显示在客户服务界面',
  `trxdir` varchar(6) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '交易方向',
  `priority` char(1) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '交易最大优先级',
  `nameforacct` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '账务查询显示的名称',
  `merentry` char(1) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '是否客户主动发起',
  `iscalucost` tinyint(4) NULL DEFAULT NULL COMMENT '是否计算成本',
  `isreal` char(1) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '是否为实时交易',
  `issett` char(1) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '是否需要结算',
  `resend` char(1) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '是否可重发',
  `issyscmn` char(1) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '是否为系统补帐类交易',
  `isrev` tinyint(4) NULL DEFAULT NULL COMMENT '是否为冲正类交易',
  PRIMARY KEY (`trxcode`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '交易类型定义表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Function structure for caaccttplSeqFunc
-- ----------------------------
DROP FUNCTION IF EXISTS `caaccttplSeqFunc`;
delimiter ;;
CREATE DEFINER=`root`@`%` FUNCTION `caaccttplSeqFunc`() RETURNS bigint(20)
    DETERMINISTIC
BEGIN
	DECLARE local_id BIGINT(20);
	
	SELECT server_id INTO local_id FROM server_id;
	INSERT INTO caaccttpl_seq VALUES();
	DELETE FROM caaccttpl_seq;

	RETURN (LAST_INSERT_ID() * 100) + local_id;
END
;;
delimiter ;

-- ----------------------------
-- Function structure for caacctvoucherseq_func
-- ----------------------------
DROP FUNCTION IF EXISTS `caacctvoucherseq_func`;
delimiter ;;
CREATE DEFINER=`root`@`%` FUNCTION `caacctvoucherseq_func`() RETURNS bigint(20)
    DETERMINISTIC
BEGIN
	INSERT INTO caacctvoucherseq_t VALUES();
	DELETE FROM caacctvoucherseq_t;
	
	RETURN LAST_INSERT_ID();
END
;;
delimiter ;

-- ----------------------------
-- Function structure for cacuslimitSeqFunc
-- ----------------------------
DROP FUNCTION IF EXISTS `cacuslimitSeqFunc`;
delimiter ;;
CREATE DEFINER=`root`@`%` FUNCTION `cacuslimitSeqFunc`() RETURNS bigint(20)
    DETERMINISTIC
BEGIN
	DECLARE local_id BIGINT(20);
	
	SELECT server_id INTO local_id FROM server_id;
	INSERT INTO cacuslimit_seq VALUES();
	DELETE FROM cacuslimit_seq;

	RETURN (LAST_INSERT_ID() * 100) + local_id;
END
;;
delimiter ;

-- ----------------------------
-- Function structure for caefSeqFunc
-- ----------------------------
DROP FUNCTION IF EXISTS `caefSeqFunc`;
delimiter ;;
CREATE DEFINER=`root`@`%` FUNCTION `caefSeqFunc`() RETURNS bigint(20)
    DETERMINISTIC
BEGIN
	DECLARE local_id BIGINT(20);
	
	SELECT server_id INTO local_id FROM server_id;
	INSERT INTO caacctef_seq VALUES();
	DELETE FROM caacctef_seq;

	RETURN (LAST_INSERT_ID() * 100)+local_id;
END
;;
delimiter ;

-- ----------------------------
-- Function structure for caentrygenledbatchseq_func
-- ----------------------------
DROP FUNCTION IF EXISTS `caentrygenledbatchseq_func`;
delimiter ;;
CREATE DEFINER=`root`@`%` FUNCTION `caentrygenledbatchseq_func`() RETURNS bigint(20)
    DETERMINISTIC
BEGIN
	INSERT INTO caentrygenledbatchseq_t VALUES();
	DELETE FROM caentrygenledbatchseq_t;
	
	RETURN LAST_INSERT_ID();
END
;;
delimiter ;

-- ----------------------------
-- Function structure for caentrynoseq_func
-- ----------------------------
DROP FUNCTION IF EXISTS `caentrynoseq_func`;
delimiter ;;
CREATE DEFINER=`root`@`%` FUNCTION `caentrynoseq_func`() RETURNS bigint(20)
    DETERMINISTIC
BEGIN
	INSERT INTO caentrynoseq_t VALUES();
	DELETE FROM caentrynoseq_t;
	
	RETURN LAST_INSERT_ID();
END
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
