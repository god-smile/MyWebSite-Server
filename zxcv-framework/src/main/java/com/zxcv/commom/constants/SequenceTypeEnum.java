package com.zxcv.commom.constants;

/**
 * 订单生成前三位规则枚举类.<br/>
 * 规则 key总共三位数
 * 第一位：1 订单、2订单流水、3 支付单、4 支付流水  5 个人客户(用户)
 * 第二三位：从01开始 ，例如：101-停车订单 、102-预定停车订单...
 */
public enum SequenceTypeEnum {

    /**************************共享车位编码****************************/

    /**
     * 停车订单
     */
    ORDER_PARK("101", "停车订单"),

    /**
     * 停车预订单
     */
    ORDER_PARK_PRE("102", "停车预订单"),

    /**
     * 年卡/月卡购买订单.
     */
    ORDER_CARD_BUY("103", "年卡/月卡购买订单"),

    /**
     * 账户充值订单，appended by hxz, 08 17 2017
     */
    ORDER_ACC_RECHARGE("104", "充值订单"),

    /**
     * 补缴订单
     */
    ORDER_BACK("105", "补缴订单"),

    /**
     * 补缴订单明细
     */
    ORDER_BACK_DETAIL("107", "补缴订单明细"),

    /**
     * 停车订单流水
     */
    ORDER_PARK_FLOW("201", "停车订单流水"),

    /**
     * 年卡/月卡购买流水订单.
     */
    ORDER_CARD_BUY_FLOW("202", "年卡/月卡购买流水订单"),

    /**
     * 提现订单.
     */
    ORDER_TRANSFER("203", "提现订单"),

    /************************支付单******************************/
    /**
     * 未知支付方式的支付单：300
     */
    ORDER_PAY_UNKNOWN("300", "未知支付方式的支付单"),
    /**
     * 支付宝支付订单:301:支付宝支付订单.
     */
    ORDER_PAY_ZFB("301", "支付宝支付订单"),

    /**
     * 微信支付订单：302:微信支付订单.
     */
    ORDER_PAY_WX("302", "微信支付订单"),

    /**
     * 银联支付订单：303:银联支付订单.
     */
    ORDER_PAY_YL("303", "银联支付订单"),

    /**
     * 微信公众号支付订单：304:银联支付订单.
     */
    ORDER_PAY_WXGZH("304", "微信公众号支付订单"),

    /**
     * 账户支付订单：304:账户支付订单.
     */
    ORDER_PAY_ZH("305", "账户支付订单"),

    /**
     * 现金支付订单：306:现金支付订单.
     */
    ORDER_PAY_XIANJIN("306", "现金支付订单"),

    /**
     * 微信公众号支付订单：307:IC卡支付.
     */
    ORDER_PAY_ICCARD("307", "IC卡支付"),

    /**
     * 共享车位收益账户
     */
    ORDER_PAY_SHARE_ZH("308", "共享车位收益账户"),

    /**
     * 账户充值赠送账户余额
     */
    ORDER_PAY_SEND_ZH("309", "账户充值赠送账户余额"),

    /**
     * 扫码支付：310:扫码支付.
     */
    ORDER_PAY_SM("310", "扫码支付"),

    /**
     * 充值卡：311:充值卡.
     */
    ORDER_PAY_CZK("311", "充值卡"),

    /***********************支付流水*******************************/
    /**
     * 支付宝支付流水订单:401:支付宝支付流水订单.
     */
    ORDER_PAY_FLOW_ZFB("401", "支付宝支付流水订单"),

    /**
     * 微信支付流水订单：402:微信支付流水订单.
     */
    ORDER_PAY_FLOW_WX("402", "微信支付流水订单"),

    /**
     * 银联支付流水订单：403:银联支付流水订单.
     */
    ORDER_PAY_FLOW_YL("403", "银联支付订流水单"),

    /**
     * 微信公众号流水支付订单：404:银联支付订单.
     */
    ORDER_PAY_FLOW_WXGZH("404", "微信公众号流水支付订单"),

    /**
     * 账户流水支付订单：405:账户支付订单.
     */
    ORDER_PAY_FLOW_ZH("405", "账户流水支付订单"),
    /**
     * 现金流水支付订单：406:现金支付订单.
     */
    ORDER_PAY_FLOW_XIANJIN("406", "现金流水支付订单"),

    /**
     * 扫码流水订单：407:扫码流水订单.
     */
    ORDER_PAY_FLOW_SM("407", "扫码流水订单"),

    /**
     * 个人客户cust_id
     */
    CUST_PERSION_SQE("501", "个人客户cust_id"),

    /**
     * 个人客户cust_id
     */
    CUST_COMPANY_SQE("601", "企业客户cust_id"),

    /**
     * 个人会员卡编码.
     */
    PERSON_CUST_CARD_NO_SQE("701", "个人会员卡编码序列"),


    /**
     * 801 退款单.
     */
    ORDER_REFUND("801", "退款单"),

    /**************************账户****************************/
    ACCOUNT_ID_P_SQE("ACCP", "个人账户ID"),

    ACCOUNT_ID_C_SQE("ACCC", "企业账户ID"),

    /**
     * 赠送规则编码
     */
    PRESENT_RULE_NO("PR", "赠送规则编码"),
    /**************************诱导屏编码****************************/

    GUIDE_NO_SQE("G", "诱导屏编码"),
    /**************************巡查异常信息编码****************************/

    INSPECT_RECORD_NO("INSPECT", "巡查异常信息编码"),

    /**************************泊位区间编码****************************/

    PARK_AREA_CODE("PAC", "泊位区间编码"),

    /**************************虚拟的物联网卡编码****************************/

    VIRTUAL_CARD_NO("VCN", "虚拟的物联网卡编码"),


    /***********************区块编码*****************************/
    AREA_BLOCK_CODE("1", "区域服务点编码"),

    /***********************会员卡*******************************/
    VIP_ID_SQE("V", "会员卡"),

    /**
     * 白名单.
     */
    WHITE_LIST("W", "白名单"),

    /**
     * 折扣.
     */
    DISCOUNT_RULE("DR", "折扣"),

    /**
     * 活动activity.
     */
    ACTIVITY_RULE("ACT", "折扣"),

    /**
     * 优惠券.
     */
    CARD_RULE("CR", "折扣"),

    /**
     * 停车券生成批次号.
     */
    CARD_RULE_PCH("CRPCH", "卡券批次号"),

    /**
     * 规则编码.
     */
    BILL_RULE_NO("BRN", "规则编码"),
    /**
     * 规则配置编码.
     */
    BILL_RULE_CONFIG_NO("BRCFN", "规则配置编码"),
    /**
     * 规则集合编码.
     */
    BILL_RULE_COLLECT_NO("BRCN", "规则集合编码"),
    DISCOUNT("D", "折扣"),

    /***********************结算单*******************************/
    SETTLEMENT_NO("SN", "结算单号"),
    SETTLEMENT_SERIAL_NO("SSN", "结算流水单号"),
    SETTLEMENT_SHARE_RECORD_NO("SR", "共享结算记录单号"),
    /**
     * 发票id
     */
    INVOICE_ID("911", "发票id"),

    /**
     * 对zt_order_n 库，暂无法通过车牌获取到custId，暂时生成临时custId
     */
    SYNCDATA_TEMP("TempCustId", "对于道闸同步上传数据生成临时custId");
    private String value;
    private String desc;

    SequenceTypeEnum(String value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public String value() {
        return this.value;
    }

    public String desc() {
        return this.desc;
    }
}
