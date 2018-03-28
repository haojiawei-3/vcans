package com.vcans.Protocol;

/**
 * Created by vcans-1 on 2017-12-14.
 */
/**
 * 标准协议
 * @author vcans
 *
 */
public final class YPStandardProtocol
{
    //==VCANS模板采集器标准版==开始==
    //VCANS模板采集器标准版==样品字段信息        151
    public static final String m_vfxVAGSTD_YangPinZiDuanXinXi1                =       "VSTD_YPZDXXXXXX";      //C     []
    public static final String m_vfxVAGSTD_YangPinZiDuanXinXiRe0              =       "VSTD_YPZDXXXRE0";      //S     成功    [字段1Caption,字段2Caption,字段3Caption,...字段30Caption]       //注意:最多30个字段,字段1必须为条形码 ,字段2必须为价格,字段3必须为货号,字段3字段4字段5为展会询样提示内容
    public static final String m_vfxVAGSTD_YangPinZiDuanXinXiRe1              =       "VSTD_YPZDXXXRE1";      //S     失败    [失败信息]

    //VCANS模板采集器标准版==样品查询       152
    public static final String m_vfxVAGSTD_YangPinChaXun1                     =       "VSTD_YPCXXXXXXX";      //C     [条形码]
    public static final String m_vfxVAGSTD_YangPinChaXun4                     =       "VSTD_YPCXXXXXX4";      //C     [条形码]
    public static final String m_vfxVAGSTD_YangPinChaXunRe0                   =       "VSTD_YPCXXXXRE0";      //S     成功    [条型码,字段2值,字段3值,...字段30值]                            //注意:最多30个字段,字段1必须为条形码  ,字段2必须为价格,字段3必须为货号,字段3字段4字段5为展会询样提示内容
    public static final String m_vfxVAGSTD_YangPinChaXunRe1                   =       "VSTD_YPCXXXXRE1";      //S     失败    [失败信息]
    public static final String m_vfxVAGSTD_YangPinChaXunRe6                   =       "VSTD_YPCXXXXRE6";      //C     图片命令[条型码,字段2值,字段3值,...字段30值]

    //VCANS模板采集器标准版==样品下载数量      80
    public static final String m_vfxVAGSTD_YangPinXiaZaiShuLiang1             =       "VSTD_YPXZSLXXXX";      //C     []
    public static final String m_vfxVAGSTD_YangPinXiaZaiShuLiangRe0           =       "VSTD_YPXZSLRE0X";      //S     成功        [数量]
    public static final String m_vfxVAGSTD_YangPinXiaZaiShuLiangRe1           =       "VSTD_YPXZSLRE1X";      //S     失败        [失败信息]

    //VCANS模板采集器标准版==样品下载       81
    public static final String m_vfxVAGSTD_YangPinXiaZai1                     =       "VSTD_YPXZXX1XXX";      //C     []
    public static final String m_vfxVAGSTD_YangPinXiaZai2                     =       "VSTD_YPXZXX2XXX";      //C     []
    public static final String m_vfxVAGSTD_YangPinXiaZaiRe0                   =       "VSTD_YPXZXXRE0X";      //S     成功        下载记录格式[条型码,字段2值,字段3值,...字段30值]            //注意:最多30个字段,字段1必须为条形码 ,字段2必须为价格,字段3字段4字段5为展会询样提示内容
    public static final String m_vfxVAGSTD_YangPinXiaZaiRe1                   =       "VSTD_YPXZXXRE1X";      //S     失败        [失败信息]
    public static final String m_vfxVAGSTD_YangPinXiaZaiRe2                   =       "VSTD_YPXZXXRE2X";      //S     成功        下载记录格式[条型码,字段2值,字段3值,...字段30值]            //注意:最多30个字段,字段1必须为条形码

    //VCANS模板采集器标准版==展会询样客户条码
    public static final String m_vfxVAGSTD_ZhanHuXunYangKeHuTiaoMa1           =       "VSTD_ZHXYKHTXXX";      //C     [客户条码]
    public static final String m_vfxVAGSTD_ZhanHuXunYangKeHuTiaoMaRe0         =       "VSTD_ZHXYKHTRE0";      //S     成功    []
    public static final String m_vfxVAGSTD_ZhanHuXunYangKeHuTiaoMaRe1         =       "VSTD_ZHXYKHTRE1";      //S     失败    [失败信息]

    //VCANS模板采集器标准版==展会询样客户简称   468
    public static final String m_vfxVAGSTD_ZhanHuXunYangKeHuJianCheng1        =       "VSTD_ZHXYKHJXXX";      //C     [客户简称,客户条码]
    public static final String m_vfxVAGSTD_ZhanHuXunYangKeHuJianChengRe0      =       "VSTD_ZHXYKHJRE0";      //S     成功    []
    public static final String m_vfxVAGSTD_ZhanHuXunYangKeHuJianChengRe1      =       "VSTD_ZHXYKHJRE1";      //S     失败    [失败信息]

    //VCANS模板采集器标准版==展会询样样品条码
    public static final String m_vfxVAGSTD_ZhanHuXunYangYangPinTiaoMa1        =       "VSTD_ZHXYYPTXXX";      //C     [样品条码,客户简称]
    public static final String m_vfxVAGSTD_ZhanHuXunYangYangPinTiaoMaRe0      =       "VSTD_ZHXYYPTRE0";      //S     成功    [价格,提示内容]
    public static final String m_vfxVAGSTD_ZhanHuXunYangYangPinTiaoMaRe1      =       "VSTD_ZHXYYPTRE1";      //S     失败    [失败信息]

    //VCANS模板采集器标准版==展会询样表上传
    public static final String m_vfxVAGSTD_ZhanHuXunYangBiao0                 =       "VSTD_ZHXYB0XXXX";      //C     开始命令
    public static final String m_vfxVAGSTD_ZhanHuXunYangBiao1                 =       "VSTD_ZHXYB1XXXX";      //C     上传记录格式[采集器记录ID,客户条码,样品条码,报价,数量,客户简称]
    public static final String m_vfxVAGSTD_ZhanHuXunYangBiao2                 =       "VSTD_ZHXYB2XXXX";      //C     上传记录格式[采集器记录ID,客户条码,样品条码,报价,数量,客户简称]
    public static final String m_vfxVAGSTD_ZhanHuXunYangBiao3                 =       "VSTD_ZHXYB3XXXX";      //C     请求错误信息继续
    public static final String m_vfxVAGSTD_ZhanHuXunYangBiaoRe0               =       "VSTD_ZHXYBRE0XX";      //S     成功
    public static final String m_vfxVAGSTD_ZhanHuXunYangBiaoRe1               =       "VSTD_ZHXYBRE1XX";      //S     失败
    public static final String m_vfxVAGSTD_ZhanHuXunYangBiaoRe3               =       "VSTD_ZHXYBRE3XX";      //S     错误信息 + 错误记录格式[采集器记录ID]
    public static final String m_vfxVAGSTD_ZhanHuXunYangBiaoRe5               =       "VSTD_ZHXYBRE5XX";      //S     错误记录格式[采集器记录ID]

    //==样品==样品图片-表上传
    public static final String m_vfxVAG43VcanYangpinImage0                    =      "V43VCANSYPIXXX0";     //C     开始命令
    public static final String m_vfxVAG43VcanYangpinImage1                    =      "V43VCANSYPIXXX1";     //C     上传记录格式[客户条码,客户简称,条形码,图片(1-N)]
    public static final String m_vfxVAG43VcanYangpinImage2                    =      "V43VCANSYPIXXX2";     //C     上传记录格式[客户条码,客户简称,条形码,图片(1-N)]
    public static final String m_vfxVAG43VcanYangpinImage3                    =      "V43VCANSYPIXXX3";     //C     请求错误信息继续
    public static final String m_vfxVAG43VcanYangpinImageRe0                  =      "V43VCANSYPIXRE0";     //S     成功
    public static final String m_vfxVAG43VcanYangpinImageRe1                  =      "V43VCANSYPIXRE1";     //S     失败
    public static final String m_vfxVAG43VcanYangpinImageRe3                  =      "V43VCANSYPIXRE3";     //S     错误信息 + 错误记录格式[客户条码]
    public static final String m_vfxVAG43VcanYangpinImageRe5                  =      "V43VCANSYPIXRE5";     //S     错误记录格式[客户条码]

    //==VCANS==是否为加密数据通知
    public static final String m_vcansHandshakeNotifyIsEncrypto               =      "HANDSHAKE_ENCRY";      //C     [字符(1或0),设备ID]
    public static final String m_vcansHandshakeNotifyIsEncryptoRe0            =      "HANDSHAKE_ENCR0";      //S     成功
    public static final String m_vcansHandshakeNotifyIsEncryptoRe1            =      "HANDSHAKE_ENCR1";      //S     失败        [失败信息]

    //==VCANS==发送结束命令
    public static final String m_vfxVcans_SendEndNotify1          			  =      "VCANS_SEND_ENDX";      //C     []
    public static final String m_vfxVcans_SendEndNotifyRe0         		   	  =      "VCANS_SENDENDE0";      //S     成功    []
    public static final String m_vfxVcans_SendEndNotifyRe1        			  =      "VCANS_SENDENDE1";      //S     失败    [失败信息]

    //==样品==搜索==
    public static final String m_vfxVAGSTD_YangPinSearch1                     =      "VSTD_YPSEARCHXX";      //C     [搜索录入值,用户名]
    public static final String m_vfxVAGSTD_YangPinSearch2                     =      "VSTD_YPSEARCH2X";      //C     []
    public static final String m_vfxVAGSTD_YangPinSearchRe0                   =      "VSTD_YPSEARRE0X";      //S     成功        下载记录格式[条型码,品号,描述,图片(1-N)] //注意:字段1必须为条形码  图片置最后
    public static final String m_vfxVAGSTD_YangPinSearchRe1                   =      "VSTD_YPSEARRE1X";      //S     失败        [失败信息]
    public static final String m_vfxVAGSTD_YangPinSearchRe2                   =      "VSTD_YPSEARRE2X";      //S     成功        下载记录格式[条型码,品号,描述,图片(1-N)] //注意:字段1必须为条形码  图片置最后

    //==VCANS==标题下载==
    public static final String m_vfxVAGSTD_UIItemTitle1                   	  =      "V53VSPZXXXZXXX1";      //C     []
    public static final String m_vfxVAGSTD_UIItemTitle2                       =      "V53VSPZXXXZXXX2";      //C     []
    public static final String m_vfxVAGSTD_UIItemTitleRe0                  	  =      "V53VSPZXXXZXRE0";      //S     成功        下载记录格式[配置项(固定值),配置值] (配置项(固定值):  跟单_坯布进仓_模块标题)
    public static final String m_vfxVAGSTD_UIItemTitleRe1                     =      "V53VSPZXXXZXRE1";      //S     失败        [失败信息]
    public static final String m_vfxVAGSTD_UIItemTitleRe2                  	  =      "V53VSPZXXXZXRE2";      //S     成功        下载记录格式[配置项(固定值),配置值]  (配置项(固定值):  跟单_坯布进仓_模块标题)

    //==VCANS_成品_坯布_标准==配置信息版本_登录信息是否_查询
    public static final String m_vfxVAG53VCANSBiaoZhun_PeiZhiXinXiBanBen      =       "V71VSPZDLYNXXXX";      //C     [配置信息版本(初始为-1),设备ID(PC测试包为"PC"),设备描述]
    public static final String m_vfxVAG53VCANSBiaoZhun_PeiZhiXinXiBanBenRe0   =       "V71VSPZDLYNXRE0";      //S     成功    [配置信息版本,登陆信息是否(Y/N)]
    public static final String m_vfxVAG53VCANSBiaoZhun_PeiZhiXinXiBanBenRe1   =       "V71VSPZDLYNXRE1";      //S     失败    [失败信息]

    //==VCANS模板采集器标准版==结束==
}

