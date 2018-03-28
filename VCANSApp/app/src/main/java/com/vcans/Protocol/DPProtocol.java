package com.vcans.Protocol;

/**
 * Created by vcans-1 on 2017-12-14.
 */
public final class DPProtocol {
    //==VCANS通用==用户信息下载
    public static final String m_vfxVAG_DengLuXinXiXiaZai1 = "V48V_DLXXXZXXX1";      //C     []
    public static final String m_vfxVAG_DengLuXinXiXiaZai2 = "V48V_DLXXXZXXX2";      //C     []
    public static final String m_vfxVAG_DengLuXinXiXiaZaiRe0 = "V48V_DLXXXZXRE0";      //S     成功    下载记录格式[用户名]
    public static final String m_vfxVAG_DengLuXinXiXiaZaiRe1 = "V48V_DLXXXZXRE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG_DengLuXinXiXiaZaiRe2 = "V48V_DLXXXZXRE2";      //S     成功    下载记录格式[用户名]

    //==VCANS通用==登录信息==
    public static final String m_vfxVAG_DengLuXinXi1 = "V48V_DLXXXXXXX1";      //C     [用户,密码,设备ID,设备描述,菜单1,菜单2,菜单3,...,菜单n]
    public static final String m_vfxVAG_DengLuXinXiRe0 = "V48V_DLXXXXXRE0";      //S     成功    [菜单1是否有权限("Y"/"N"),菜单2是否有权限("Y"/"N"),菜单3是否有权限("Y"/"N"),...菜单n是否有权限("Y"/"N")]
    public static final String m_vfxVAG_DengLuXinXiRe1 = "V48V_DLXXXXXRE1";      //S     失败    [失败信息]

    /***==跟单==生产投坯=任务简报=染整费用=直接出货=备用模块=辅助资料下载 ************************************************/

    public static final String m_vfxVAG4BDePei_FuZhuZiLiaoXiaZai1 = "V4BDPFZZLXZXXX1";      //C     []
    public static final String m_vfxVAG4BDePei_FuZhuZiLiaoXiaZai2 = "V4BDPFZZLXZXXX2";      //C     []
    public static final String m_vfxVAG4BDePei_FuZhuZiLiaoXiaZaiRe0 = "V4BDPFZZLXZXRE0";      //S     成功    下载记录格式[类别{工序|品检状态|工艺|工厂|工艺二|染整费用选择|生产类型|直接出货辅助四|直接出货辅助五|备用一/二/三/四辅助资料8|备用一/二/三/四辅助资料9},编号n,名称n]或者[类别{花型颜色},花型n,颜色n]
    public static final String m_vfxVAG4BDePei_FuZhuZiLiaoXiaZaiRe1 = "V4BDPFZZLXZXRE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG4BDePei_FuZhuZiLiaoXiaZaiRe2 = "V4BDPFZZLXZXRE2";      //S     成功    下载记录格式[类别{工序|品检状态|工艺|工厂|工艺二|染整费用选择|生产类型|直接出货辅助四|直接出货辅助五},编号n,名称n]或者[类别{花型颜色},花型n,颜色n]

    /********************************************************生产投坯*****************************************************/
    //==跟单==生产投坯-公司订单号查询
    public static final String m_vfxVAG4BDePei_ShengChanHuiBaoTouLiao_RanZhengJiHuaHao = "V4BDPHBTLRZHXXX";      //C     [染整计划号,是否复合布(Y/N)]
    public static final String m_vfxVAG4BDePei_ShengChanHuiBaoTouLiao_RanZhengJiHuaHaoRe0 = "V4BDPHBTLRZHRE0";      //S     成功    [公司订单号]
    public static final String m_vfxVAG4BDePei_ShengChanHuiBaoTouLiao_RanZhengJiHuaHaoRe1 = "V4BDPHBTLRZHRE1";      //S     失败    [失败信息]

    //==跟单==生产投 称查询
    public static final String m_vfxVAG4BDePei_ShengChanHuiBaoTouLiao_RanZhengChangBianMa = "V4BDPHBTLRZCXXX";     //C     [染整厂编码][染整计划号,是否复合布(Y/N)]
    public static final String m_vfxVAG4BDePei_ShengChanHuiBaoTouLiao_RanZhengChangBianMa0 = "V4BDPHBTLRZCRE0";     //S     成功    [染整厂名称]
    public static final String m_vfxVAG4BDePei_ShengChanHuiBaoTouLiao_RanZhengChangBianMa1 = "V4BDPHBTLRZCRE1";     //S     失败    [失败信息]

    //==跟单==生产投坯-物料信息下载
    public static final String m_vfxVAG4BDePei_ShengChanHuiBaoTouLiao_GongXuXuanZe1 = "V4BDPHBTLGXXXX1";      //C     [染整计划号,染整厂编码,工序编号,工序名称,是否复合布(Y/N)]
    public static final String m_vfxVAG4BDePei_ShengChanHuiBaoTouLiao_GongXuXuanZe2 = "V4BDPHBTLGXXXX2";      //C     [染整计划号,染整厂编码,工序编号,工序名称],是否复合布(Y/N)
    public static final String m_vfxVAG4BDePei_ShengChanHuiBaoTouLiao_GongXuXuanZeRe0 = "V4BDPHBTLGXXRE0";      //S     成功    下载记录格式[公司订单号,采购合同号,物料编号,物料描述,存货描述,存货标志,匹数,数量]
    public static final String m_vfxVAG4BDePei_ShengChanHuiBaoTouLiao_GongXuXuanZeRe1 = "V4BDPHBTLGXXRE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG4BDePei_ShengChanHuiBaoTouLiao_GongXuXuanZeRe2 = "V4BDPHBTLGXXRE2";      //S     成功    下载记录格式[公司订单号,采购合同号,物料编号,物料描述,存货描述,存货标志,匹数,数量]

    //==跟单==生产投坯-表上传
    public static final String m_vfxVAG4BDePei_ShengChanHuiBaoTouLiaoBiao0 = "V4BDPHBTLBXXXX0";      //C     开始命令
    public static final String m_vfxVAG4BDePei_ShengChanHuiBaoTouLiaoBiao1 = "V4BDPHBTLBXXXX1";      //C     上传记录格式[采集器内部内部ID,染整计划号,染整厂编码,工序编号,工序名称,公司订单号,采购合同号,物料编号,物料描述,存货描述,存货标志,原库存匹数,原库存数量,回修,初始坯布投入,匹数,数量,用户名,是否复合布(Y/N,投入颜色,生产类型,生产类型编号,批次]
    public static final String m_vfxVAG4BDePei_ShengChanHuiBaoTouLiaoBiao2 = "V4BDPHBTLBXXXX2";      //C     上传记录格式[采集器内部内部ID,染整计划号,染整厂编码,工序编号,工序名称,公司订单号,采购合同号,物料编号,物料描述,存货描述,存货标志,原库存匹数,原库存数量,回修,初始坯布投入,匹数,数量,用户名,是否复合布(Y/N,投入颜色,生产类型,生产类型编号,批次]
    public static final String m_vfxVAG4BDePei_ShengChanHuiBaoTouLiaoBiao3 = "V4BDPHBTLBXXXX3";      //C     请求错误信息继续
    public static final String m_vfxVAG4BDePei_ShengChanHuiBaoTouLiaoBiaoRe0 = "V4BDPHBTLBXXRE0";      //S     成功
    public static final String m_vfxVAG4BDePei_ShengChanHuiBaoTouLiaoBiaoRe1 = "V4BDPHBTLBXXRE1";      //S     失败
    public static final String m_vfxVAG4BDePei_ShengChanHuiBaoTouLiaoBiaoRe3 = "V4BDPHBTLBXXRE3";      //S     错误信息 + 错误记录格式[采集器内部ID]
    public static final String m_vfxVAG4BDePei_ShengChanHuiBaoTouLiaoBiaoRe5 = "V4BDPHBTLBXXRE5";      //S     错误记录格式[采集器内部ID]

    //==跟单==生产投坯-花型颜色下载==成品进仓-工厂/公司订单号/花型颜色下载
    public static final String m_vfxVAG4BDePei_ShengChanHuiBaoChanChu_RanZhengJiHuaHaoX1 = "V4BDPHBCCRZXXX1";      //C     [染整计划号,投料或产出]
    public static final String m_vfxVAG4BDePei_ShengChanHuiBaoChanChu_RanZhengJiHuaHaoX2 = "V4BDPHBCCRZXXX2";      //C     [染整计划号]
    public static final String m_vfxVAG4BDePei_ShengChanHuiBaoChanChu_RanZhengJiHuaHaoXRe0 = "V4BDPHBCCRZXRE0";      //S     成功    下载记录格式["公司订单号",公司订单号] + ["工厂",工厂编码,工厂名称] + ["花型颜色",花型,颜色]
    public static final String m_vfxVAG4BDePei_ShengChanHuiBaoChanChu_RanZhengJiHuaHaoXRe1 = "V4BDPHBCCRZXRE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG4BDePei_ShengChanHuiBaoChanChu_RanZhengJiHuaHaoXRe2 = "V4BDPHBCCRZXRE2";      //S     成功    下载记录格式["工厂",工厂编码,工厂名称] + ["花型颜色",花型,颜色]

    /********************************************************成品进仓*****************************************************/
    //==跟单==成品进仓-工序/生产类型2下载
    public static final String m_vfxVAG4BDePei_ShengChanHuiBaoChanChu_RanZhengChangBianMaX1 = "V4BDPHBCCGCXXX1";      //C     [染整厂编码][染整计划号]
    public static final String m_vfxVAG4BDePei_ShengChanHuiBaoChanChu_RanZhengChangBianMaX2 = "V4BDPHBCCGCXXX2";      //C     [染整厂编码][染整计划号]
    public static final String m_vfxVAG4BDePei_ShengChanHuiBaoChanChu_RanZhengChangBianMaXRe0 = "V4BDPHBCCGCXRE0";      //S     成功    下载记录格式["工厂",工厂编码,工厂名称] + ["工序",工序编码,工序名称]+ ["生产类型2",编码,名称]
    public static final String m_vfxVAG4BDePei_ShengChanHuiBaoChanChu_RanZhengChangBianMaXRe1 = "V4BDPHBCCGCXRE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG4BDePei_ShengChanHuiBaoChanChu_RanZhengChangBianMaXRe2 = "V4BDPHBCCGCXRE2";      //S     成功    下载记录格式["工厂",工厂编码,工厂名称] + ["工序",工序编码,工序名称]+ ["生产类型2",编码,名称]

    //==跟单==成品进仓-物料信息下载
    public static final String m_vfxVAG4BDePei_ShengChanHuiBaoChanChu_GongXuXuanZe1 = "V4BDPHBCCGXXXX1";      //C     [染整计划号,染整厂编码,工序编号,工序名称]
    public static final String m_vfxVAG4BDePei_ShengChanHuiBaoChanChu_GongXuXuanZe2 = "V4BDPHBCCGXXXX2";      //C     [染整计划号,染整厂编码,工序编号,工序名称]
    public static final String m_vfxVAG4BDePei_ShengChanHuiBaoChanChu_GongXuXuanZeRe0 = "V4BDPHBCCGXXRE0";      //S     成功    下载记录格式[公司订单号,计划单号,物料编号,物料描述,存货描述,存货标志,在制匹数,在制数量]
    public static final String m_vfxVAG4BDePei_ShengChanHuiBaoChanChu_GongXuXuanZeRe1 = "V4BDPHBCCGXXRE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG4BDePei_ShengChanHuiBaoChanChu_GongXuXuanZeRe2 = "V4BDPHBCCGXXRE2";      //S     成功    下载记录格式[公司订单号,计划单号,物料编号,物料描述,存货描述,存货标志,在制匹数,在制数量]        //==德沛==生产汇报-产出==表上传   304

    //==跟单==成品进仓-表上传
    public static final String m_vfxVAG4BDePei_ShengChanHuiBaoChanChuBiao0 = "V4BDPHBCCBXXXX0";      //C     开始命令
    public static final String m_vfxVAG4BDePei_ShengChanHuiBaoChanChuBiao1 = "V4BDPHBCCBXXXX1";      //C     上传记录格式[采集器内部ID,染整计划号,染整厂编码,工序编码,工序名称,公司订单号,采购合同号,物料编号,物料描述,存货描述,存货标志,在制匹数,在制数量,花型,颜色,品检状态编码,品检状态名称,面料性质,KG转M系数,单价,单位,匹数,数量,用户名,生产类型,生产类型编号,批次]
    public static final String m_vfxVAG4BDePei_ShengChanHuiBaoChanChuBiao2 = "V4BDPHBCCBXXXX2";      //C     上传记录格式[采集器内部ID,染整计划号,染整厂编码,工序编码,工序名称,公司订单号,采购合同号,物料编号,物料描述,存货描述,存货标志,在制匹数,在制数量,花型,颜色,品检状态编码,品检状态名称,面料性质,KG转M系数,单价,单位,匹数,数量,用户名,生产类型,生产类型编号,批次]
    public static final String m_vfxVAG4BDePei_ShengChanHuiBaoChanChuBiao3 = "V4BDPHBCCBXXXX3";      //C     请求错误信息继续
    public static final String m_vfxVAG4BDePei_ShengChanHuiBaoChanChuBiaoRe0 = "V4BDPHBCCBXXRE0";      //S     成功
    public static final String m_vfxVAG4BDePei_ShengChanHuiBaoChanChuBiaoRe1 = "V4BDPHBCCBXXRE1";      //S     失败
    public static final String m_vfxVAG4BDePei_ShengChanHuiBaoChanChuBiaoRe3 = "V4BDPHBCCBXXRE3";      //S     错误信息 + 错误记录格式[采集器内部ID]
    public static final String m_vfxVAG4BDePei_ShengChanHuiBaoChanChuBiaoRe5 = "V4BDPHBCCBXXRE5";      //S     错误记录格式[采集器内部ID]

    /********************************************************加工送仓库*****************************************************/

    //==跟单==加工送仓库-工厂下载
    public static final String m_vfxVAG4BDePei_ShengChanDiaoBo_RanZhengJiHuaHaoX1 = "V4BDPSCDBRZXXX1";      //C     [染整计划号,单据类型]
    public static final String m_vfxVAG4BDePei_ShengChanDiaoBo_RanZhengJiHuaHaoX2 = "V4BDPSCDBRZXXX2";      //C     [染整计划号,单据类型]
    public static final String m_vfxVAG4BDePei_ShengChanDiaoBo_RanZhengJiHuaHaoXRe0 = "V4BDPSCDBRZXRE0";      //S     成功    下载记录格式["工厂",工厂编码,工厂名称]
    public static final String m_vfxVAG4BDePei_ShengChanDiaoBo_RanZhengJiHuaHaoXRe1 = "V4BDPSCDBRZXRE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG4BDePei_ShengChanDiaoBo_RanZhengJiHuaHaoXRe2 = "V4BDPSCDBRZXRE2";      //S     成功    下载记录格式["工厂",工厂编码,工厂名称]

    //==跟单==加工送仓库-工序/生产类型3下载
    public static final String m_vfxVAG4BDePei_ShengChanDiaoBo_JiaGongChangBianMaX1 = "V4BDPSCDBGCXXX1";      //C     [加工厂编码,单据类型,染整计划号]
    public static final String m_vfxVAG4BDePei_ShengChanDiaoBo_JiaGongChangBianMaX2 = "V4BDPSCDBGCXXX2";      //C     [加工厂编码,单据类型,染整计划号]
    public static final String m_vfxVAG4BDePei_ShengChanDiaoBo_JiaGongChangBianMaXRe0 = "V4BDPSCDBGCXRE0";      //S     成功    下载记录格式["工厂",工厂编码,工厂名称] + ["工序",工序编码,工序名称]+ ["生产类型3",编码,名称]
    public static final String m_vfxVAG4BDePei_ShengChanDiaoBo_JiaGongChangBianMaXRe1 = "V4BDPSCDBGCXRE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG4BDePei_ShengChanDiaoBo_JiaGongChangBianMaXRe2 = "V4BDPSCDBGCXRE2";      //S     成功    下载记录格式["工厂",工厂编码,工厂名称] + ["工序",工序编码,工序名称]

    //==跟单==加工送仓库-目的工厂查询
    public static final String m_vfxVAG4BDePei_ShengChanDiaoBo_MuDiGongChangBianMa = "V4BDPSCDBMDCXXX";     //C     [目的工厂编码,单据类型,染整计划号,加工厂编码]
    public static final String m_vfxVAG4BDePei_ShengChanDiaoBo_MuDiGongChangBianMa0 = "V4BDPSCDBMDCRE0";     //S     成功    [目的工厂名称]
    public static final String m_vfxVAG4BDePei_ShengChanDiaoBo_MuDiGongChangBianMa1 = "V4BDPSCDBMDCRE1";     //S     失败    [失败信息]

    //==跟单==加工送仓库-物料信息下载
    public static final String m_vfxVAG4BDePei_ShengChanDiaoBo_GongXuXuanZe1 = "V4BDPSCDBGXXXX1";      //C     [单据类型,染整计划号,加工厂编码,目的工厂编码,工序编号,工序名称]
    public static final String m_vfxVAG4BDePei_ShengChanDiaoBo_GongXuXuanZe2 = "V4BDPSCDBGXXXX2";      //C     [单据类型,染整计划号,加工厂编码,目的工厂编码,工序编号,工序名称]
    public static final String m_vfxVAG4BDePei_ShengChanDiaoBo_GongXuXuanZeRe0 = "V4BDPSCDBGXXRE0";      //S     成功    下载记录格式[公司订单号,采购合同号,物料编号,物料描述,存货描述,存货标志,匹数,数量]
    public static final String m_vfxVAG4BDePei_ShengChanDiaoBo_GongXuXuanZeRe1 = "V4BDPSCDBGXXRE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG4BDePei_ShengChanDiaoBo_GongXuXuanZeRe2 = "V4BDPSCDBGXXRE2";      //S     成功    下载记录格式[公司订单号,采购合同号,物料编号,物料描述,存货描述,存货标志,匹数,数量]

    //==跟单==加工送仓库-表上传
    public static final String m_vfxVAG4BDePei_ShengChanDiaoBoBiao0 = "V4BDPSCDBBXXXX0";      //C     开始命令
    public static final String m_vfxVAG4BDePei_ShengChanDiaoBoBiao1 = "V4BDPSCDBBXXXX1";      //C     上传记录格式[采集器内部内部ID,单据类型,染整计划号,加工厂编码,目的工厂编码,工序编号,工序名称,公司订单号,采购合同号,物料编号,物料描述,存货描述,存货标志,原库存匹数,原库存数量,匹数,数量,用户名,生产类型,生产类型编号]
    public static final String m_vfxVAG4BDePei_ShengChanDiaoBoBiao2 = "V4BDPSCDBBXXXX2";      //C     上传记录格式[采集器内部内部ID,单据类型,染整计划号,加工厂编码,目的工厂编码,工序编号,工序名称,公司订单号,采购合同号,物料编号,物料描述,存货描述,存货标志,原库存匹数,原库存数量,匹数,数量,用户名,生产类型,生产类型编号]
    public static final String m_vfxVAG4BDePei_ShengChanDiaoBoBiao3 = "V4BDPSCDBBXXXX3";      //C     请求错误信息继续
    public static final String m_vfxVAG4BDePei_ShengChanDiaoBoBiaoRe0 = "V4BDPSCDBBXXRE0";      //S     成功
    public static final String m_vfxVAG4BDePei_ShengChanDiaoBoBiaoRe1 = "V4BDPSCDBBXXRE1";      //S     失败
    public static final String m_vfxVAG4BDePei_ShengChanDiaoBoBiaoRe3 = "V4BDPSCDBBXXRE3";      //S     错误信息 + 错误记录格式[采集器内部ID]
    public static final String m_vfxVAG4BDePei_ShengChanDiaoBoBiaoRe5 = "V4BDPSCDBBXXRE5";      //S     错误记录格式[采集器内部ID]

    //==德沛==未检品出仓==染整计划号==辅助资料==下载    324
    public static final String m_vfxVAG4BDePei_WeiJianPinChuCang_RanZhengJiHuaHaoX1 = "V4BDPWJCCRZXXX1";      //C     [染整计划号]
    public static final String m_vfxVAG4BDePei_WeiJianPinChuCang_RanZhengJiHuaHaoX2 = "V4BDPWJCCRZXXX2";      //C     [染整计划号]
    public static final String m_vfxVAG4BDePei_WeiJianPinChuCang_RanZhengJiHuaHaoXRe0 = "V4BDPWJCCRZXRE0";      //S     成功    下载记录格式["工厂",工厂编码,工厂名称]
    public static final String m_vfxVAG4BDePei_WeiJianPinChuCang_RanZhengJiHuaHaoXRe1 = "V4BDPWJCCRZXRE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG4BDePei_WeiJianPinChuCang_RanZhengJiHuaHaoXRe2 = "V4BDPWJCCRZXRE2";      //S     成功    下载记录格式["工厂",工厂编码,工厂名称]

    //==德沛==未检品出仓==染整厂编码==辅助资料==下载   325
    public static final String m_vfxVAG4BDePei_WeiJianPinChuCang_RanZhengChangBianMaX1 = "V4BDPWJCCGCXXX1";      //C     [染整厂编码][染整计划号]
    public static final String m_vfxVAG4BDePei_WeiJianPinChuCang_RanZhengChangBianMaX2 = "V4BDPWJCCGCXXX2";      //C     [染整厂编码][染整计划号]
    public static final String m_vfxVAG4BDePei_WeiJianPinChuCang_RanZhengChangBianMaXRe0 = "V4BDPWJCCGCXRE0";      //S     成功    下载记录格式["工厂",工厂编码,工厂名称] + ["工序",工序编码,工序名称]
    public static final String m_vfxVAG4BDePei_WeiJianPinChuCang_RanZhengChangBianMaXRe1 = "V4BDPWJCCGCXRE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG4BDePei_WeiJianPinChuCang_RanZhengChangBianMaXRe2 = "V4BDPWJCCGCXRE2";      //S     成功    下载记录格式["工厂",工厂编码,工厂名称] + ["工序",工序编码,工序名称]

    /********************************************************坯布进仓*****************************************************/
    //==跟单==坯布进仓==出库通知单号==下载       296
    public static final String m_vfxVAG4BDePei_PeiBuJinCang_ChuKuTongZhiDanHao1 = "V4BDPPBJCCCDXX1";      //C     [出库通知单号]
    public static final String m_vfxVAG4BDePei_PeiBuJinCang_ChuKuTongZhiDanHao2 = "V4BDPPBJCCCDXX2";      //C     [出库通知单号]
    public static final String m_vfxVAG4BDePei_PeiBuJinCang_ChuKuTongZhiDanHaoRe0 = "V4BDPPBJCCCDRE0";      //S     成功    下载记录格式[供应商,采购合同号,物料编号,物料描述,发货数量,订单数,公司订单号,ID]
    public static final String m_vfxVAG4BDePei_PeiBuJinCang_ChuKuTongZhiDanHaoRe1 = "V4BDPPBJCCCDRE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG4BDePei_PeiBuJinCang_ChuKuTongZhiDanHaoRe2 = "V4BDPPBJCCCDRE2";      //S     成功    下载记录格式[供应商,采购合同号,物料编号,物料描述,发货数量,订单数,公司订单号,ID]

    //==跟单==坯布进仓==表上传       297
    public static final String m_vfxVAG4BDePei_PeiBuJinCangBiao0 = "V4BDPPBJCBXXXX0";      //C     开始命令
    public static final String m_vfxVAG4BDePei_PeiBuJinCangBiao1 = "V4BDPPBJCBXXXX1";      //C     上传记录格式[采集器内部ID,出库通知单号,供应商,采购合同号,物料编号,物料描述,发货数量,订单数,公司订单号,ID,面料性质,包装方式,码口,说明,存放位置,匹数,数量,用户名,批次]
    public static final String m_vfxVAG4BDePei_PeiBuJinCangBiao2 = "V4BDPPBJCBXXXX2";      //C     上传记录格式[采集器内部ID,出库通知单号,供应商,采购合同号,物料编号,物料描述,发货数量,订单数,公司订单号,ID,面料性质,包装方式,码口,说明,存放位置,匹数,数量,用户名,批次]
    public static final String m_vfxVAG4BDePei_PeiBuJinCangBiao3 = "V4BDPPBJCBXXXX3";      //C     请求错误信息继续
    public static final String m_vfxVAG4BDePei_PeiBuJinCangBiaoRe0 = "V4BDPPBJCBXXRE0";      //S     成功
    public static final String m_vfxVAG4BDePei_PeiBuJinCangBiaoRe1 = "V4BDPPBJCBXXRE1";      //S     失败
    public static final String m_vfxVAG4BDePei_PeiBuJinCangBiaoRe3 = "V4BDPPBJCBXXRE3";      //S     错误信息 + 错误记录格式[采集器内部ID]
    public static final String m_vfxVAG4BDePei_PeiBuJinCangBiaoRe5 = "V4BDPPBJCBXXRE5";      //S     错误记录格式[采集器内部ID]

    /********************************************************染整任务简报*****************************************************/
    //==跟单==染整任务简报-染整厂名称查询      507
    public static final String m_vfxVAG4BDePei_RanZhengRenWuJianBao_RanZhengChangBianMa = "V4BDPRZJBJGCXXX";     //C     [染整厂编码][染整计划号]
    public static final String m_vfxVAG4BDePei_RanZhengRenWuJianBao_RanZhengChangBianMa0 = "V4BDPRZJBJGCRE0";     //S     成功    [染整厂名称]
    public static final String m_vfxVAG4BDePei_RanZhengRenWuJianBao_RanZhengChangBianMa1 = "V4BDPRZJBJGCRE1";     //S     失败    [失败信息]

    //==跟单==染整任务简报==表上传        314
    public static final String m_vfxVAG4BDePei_RanZhengRenWuJianBaoBiao0 = "V4BDPRZJBBXXXX0";      //C     开始命令
    public static final String m_vfxVAG4BDePei_RanZhengRenWuJianBaoBiao1 = "V4BDPRZJBBXXXX1";      //C     上传记录格式[染整计划号,染整厂编码,工序编码,工序名称,工艺编码,工艺名称,日期时间,数量,备注]
    public static final String m_vfxVAG4BDePei_RanZhengRenWuJianBaoBiao2 = "V4BDPRZJBBXXXX2";      //C     上传记录格式[此命令不应发生]
    public static final String m_vfxVAG4BDePei_RanZhengRenWuJianBaoBiao3 = "V4BDPRZJBBXXXX3";      //C     请求错误信息继续[此命令不应发生]
    public static final String m_vfxVAG4BDePei_RanZhengRenWuJianBaoBiaoRe0 = "V4BDPRZJBBXXRE0";      //S     成功
    public static final String m_vfxVAG4BDePei_RanZhengRenWuJianBaoBiaoRe1 = "V4BDPRZJBBXXRE1";      //S     失败
    public static final String m_vfxVAG4BDePei_RanZhengRenWuJianBaoBiaoRe3 = "V4BDPRZJBBXXRE3";      //S     错误信息 + 错误记录格式[此命令不应发生]
    public static final String m_vfxVAG4BDePei_RanZhengRenWuJianBaoBiaoRe5 = "V4BDPRZJBBXXRE5";      //S     错误记录格式[此命令不应发生]

    /********************************************************染整任务简报二*****************************************************/

    //==跟单==染整任务简报二-染整厂名称查询      507
    public static final String m_vfxVAG4BDePei_RanZhengRenWuJianBaoer_RanZhengChangBianMa = "V4BDPRZJBJ2CXXX";     //C     [染整厂编码][染整计划号]
    public static final String m_vfxVAG4BDePei_RanZhengRenWuJianBaoer_RanZhengChangBianMa0 = "V4BDPRZJBJ2CRE0";     //S     成功    [染整厂名称]
    public static final String m_vfxVAG4BDePei_RanZhengRenWuJianBaoer_RanZhengChangBianMa1 = "V4BDPRZJBJ2CRE1";     //S     失败    [失败信息]


    //==跟单==染整任务简报二==表上传        314
    public static final String m_vfxVAG4BDePei_RanZhengRenWuJianBaoerBiao0 = "V4BDPRZJB2XXXX0";      //C     开始命令
    public static final String m_vfxVAG4BDePei_RanZhengRenWuJianBaoerBiao1 = "V4BDPRZJB2XXXX1";      //C     上传记录格式[染整计划号,染整厂编码,工序编码,工序名称,工艺编码,工艺名称,日期时间,数量,备注]
    public static final String m_vfxVAG4BDePei_RanZhengRenWuJianBaoerBiao2 = "V4BDPRZJB2XXXX2";      //C     上传记录格式[此命令不应发生]
    public static final String m_vfxVAG4BDePei_RanZhengRenWuJianBaoerBiao3 = "V4BDPRZJB2XXXX3";      //C     请求错误信息继续[此命令不应发生]
    public static final String m_vfxVAG4BDePei_RanZhengRenWuJianBaoerBiaoRe0 = "V4BDPRZJB2XXRE0";      //S     成功
    public static final String m_vfxVAG4BDePei_RanZhengRenWuJianBaoerBiaoRe1 = "V4BDPRZJB2XXRE1";      //S     失败
    public static final String m_vfxVAG4BDePei_RanZhengRenWuJianBaoerBiaoRe3 = "V4BDPRZJB2XXRE3";      //S     错误信息 + 错误记录格式[此命令不应发生]
    public static final String m_vfxVAG4BDePei_RanZhengRenWuJianBaoerBiaoRe5 = "V4BDPRZJB2XXRE5";      //S     错误记录格式[此命令不应发生]

    /********************************************************染整费用*****************************************************/

    //==跟单==染整费用==验证染整计划号是否存在
    public static final String m_vfxVAG4BDePei_RanZhengFeiYong_RanZhengJiHuaHao = "V5BDPRZFYRZHXXX";      //C     [染整计划号]
    public static final String m_vfxVAG4BDePei_RanZhengFeiYong_RanZhengJiHuaHaoRe0 = "V5BDPRZFYRZHRE0";      //S     成功
    public static final String m_vfxVAG4BDePei_RanZhengFeiYong_RanZhengJiHuaHaoRe1 = "V5BDPRZFYRZHRE1";      //S     失败    [失败信息]

    //==跟单==染整费用-染整名称查询
    public static final String m_vfxVAG4BDePei_RanZhengFeiYong_RanZhengChangBianMa = "V5BDPRZFYJGCXXX";     //C     [染整厂编码][染整计划号]
    public static final String m_vfxVAG4BDePei_RanZhengFeiYong_RanZhengChangBianMa0 = "V5BDPRZFYJGCRE0";     //S     成功    [染整厂名称]
    public static final String m_vfxVAG4BDePei_RanZhengFeiYong_RanZhengChangBianMa1 = "V5BDPRZFYJGCRE1";     //S     失败    [失败信息]

    //==跟单==染整费用==表上传
    public static final String m_vfxVAG4BDePei_RanZhengFeiYongBiao0 = "V5BDPRZFYBXXXX0";      //C     开始命令
    public static final String m_vfxVAG4BDePei_RanZhengFeiYongBiao1 = "V5BDPRZFYBXXXX1";      //C     上传记录格式[采集器内部ID,染整计划号,染整厂编码,工序编号,工序名称,费用选择编号,费用选择名称,匹数,数量,费用金额,说明,用户名]
    public static final String m_vfxVAG4BDePei_RanZhengFeiYongBiao2 = "V5BDPRZFYBXXXX2";      //C     上传记录格式[采集器内部ID,染整计划号,染整厂编码,工序编号,工序名称,费用选择编号,费用选择名称,匹数,数量,费用金额,说明,用户名]
    public static final String m_vfxVAG4BDePei_RanZhengFeiYongBiao3 = "V5BDPRZFYBXXXX3";      //C     请求错误信息继续
    public static final String m_vfxVAG4BDePei_RanZhengFeiYongBiaoRe0 = "V5BDPRZFYBXXRE0";      //S     成功
    public static final String m_vfxVAG4BDePei_RanZhengFeiYongBiaoRe1 = "V5BDPRZFYBXXRE1";      //S     失败
    public static final String m_vfxVAG4BDePei_RanZhengFeiYongBiaoRe3 = "V5BDPRZFYBXXRE3";      //S     错误信息 + 错误记录格式[采集器内部ID]
    public static final String m_vfxVAG4BDePei_RanZhengFeiYongBiaoRe5 = "V5BDPRZFYBXXRE5";      //S     错误记录格式[采集器内部ID]

    /****************************************************直接出货***************************************************/
    //==跟单==直接出货=辅助一下载
    public static final String m_VCANSAPP_ZHIJIECHUHUO_XIAZAI_1FZ1 = "VPZJCKFZ1XZXXX1";      //C     [关联单号][数据采集项1]
    public static final String m_VCANSAPP_ZHIJIECHUHUO_XIAZAI_1FZ2 = "VPZJCKFZ1XZXXX2";      //C     [关联单号][数据采集项1]
    public static final String m_VCANSAPP_ZHIJIECHUHUO_XIAZAI_1FZRe0 = "VPZJCKFZ1XZXRE0";      //S     成功    下载记录格式["直接出货辅助一",编码,名称]
    public static final String m_VCANSAPP_ZHIJIECHUHUO_XIAZAI_1FZRe1 = "VPZJCKFZ1XZXRE1";      //S     失败    [失败信息]
    public static final String m_VCANSAPP_ZHIJIECHUHUO_XIAZAI_1FZRe2 = "VPZJCKFZ1XZXRE2";      //S     成功    下载记录格式["直接出货辅助一",编码,名称]

    //==跟单==直接出货=辅助二下载
    public static final String m_VCANSAPP_ZHIJIECHUHUO_XIAZAI_2FZ1 = "VPZJCKFZ2XZXXX1";      //C     [关联单号][数据采集项1][直接出货辅助一编号][直接出货辅助一名称]
    public static final String m_VCANSAPP_ZHIJIECHUHUO_XIAZAI_2FZ2 = "VPZJCKFZ2XZXXX2";      //C     [关联单号][数据采集项1][直接出货辅助一编号][直接出货辅助一名称]
    public static final String m_VCANSAPP_ZHIJIECHUHUO_XIAZAI_2FZRe0 = "VPZJCKFZ2XZXRE0";      //S     成功    下载记录格式["直接出货辅助二",编码,名称]
    public static final String m_VCANSAPP_ZHIJIECHUHUO_XIAZAI_2FZRe1 = "VPZJCKFZ2XZXRE1";      //S     失败    [失败信息]
    public static final String m_VCANSAPP_ZHIJIECHUHUO_XIAZAI_2FZRe2 = "VPZJCKFZ2XZXRE2";      //S     成功    下载记录格式["直接出货辅助二",编码,名称]


    //==跟单==直接出货=辅助三下载
    public static final String m_VCANSAPP_ZHIJIECHUHUO_XIAZAI_3FZ1 = "VPZJCKFZ3XZXXX1";      //C     [关联单号][数据采集项1][直接出货辅助一编号][直接出货辅助一名称][直接出货辅助二编号][直接出货辅助二名称]
    public static final String m_VCANSAPP_ZHIJIECHUHUO_XIAZAI_3FZ2 = "VPZJCKFZ3XZXXX2";      //C     [关联单号][数据采集项1]
    public static final String m_VCANSAPP_ZHIJIECHUHUO_XIAZAI_3FZRe0 = "VPZJCKFZ3XZXRE0";      //S     成功    下载记录格式["直接出货辅助三",编码,名称]
    public static final String m_VCANSAPP_ZHIJIECHUHUO_XIAZAI_3FZRe1 = "VPZJCKFZ3XZXRE1";      //S     失败    [失败信息]
    public static final String m_VCANSAPP_ZHIJIECHUHUO_XIAZAI_3FZRe2 = "VPZJCKFZ3XZXRE2";      //S     成功    下载记录格式["直接出货辅助三",编码,名称]

    //==跟单==直接出货=物料信息下载
    public static final String m_VCANSAPP_ZHIJIECHUHUO_XIAZAI_WULIAO1 = "VPZJCKWLXZXXXX1";      //C     [关联单号][数据采集项1][直接出货辅助一编号][直接出货辅助一名称][直接出货辅助二编号][直接出货辅助二名称][直接出货辅助三编号][直接出货辅助三名称]
    public static final String m_VCANSAPP_ZHIJIECHUHUO_XIAZAI_WULIAO2 = "VPZJCKWLXZXXXX2";      //C     [关联单号][数据采集项1]
    public static final String m_VCANSAPP_ZHIJIECHUHUO_XIAZAI_WULIAORe0 = "VPZJCKWLXZXXRE0";      //S     成功    下载记录格式[物料编号,物料描述 ,存货描述,存货标志,在库匹数,在库数量,备用1,备用2,备用3,备用4,备用5]
    public static final String m_VCANSAPP_ZHIJIECHUHUO_XIAZAI_WULIAORe1 = "VPZJCKWLXZXXRE1";      //S     失败    [失败信息]
    public static final String m_VCANSAPP_ZHIJIECHUHUO_XIAZAI_WULIAORe2 = "VPZJCKWLXZXXRE2";      //S     成功   下载记录格式[物料编号,物料描述 ,存货描述,存货标志,在库匹数,在库数量,备用1,备用2,备用3,备用4,备用5]

    //==跟单==直接出货==表上传
    public static final String m_VCANSAPP_ZHIJIECHUHUO_UPLOADBIAO0 = "VPZJCKUPBIAOXX0";      //C     开始命令
    public static final String m_VCANSAPP_ZHIJIECHUHUO_UPLOADBIAO1 = "VPZJCKUPBIAOXX1";      //C     上传记录格式[采集器内部ID,关联单号,数据采集项1,直接出货辅助一编号,直接出货辅助一名称,直接出货辅助二编号,直接出货辅助二名称,直接出货辅助三编号,直接出货辅助三名称,物料编号,物料描述 ,存货描述,存货标志,在库匹数,在库数量,备用1,备用2,备用3,备用4,备用5,数据采集项2,数据采集项3,直接出货辅助四编号,直接出货辅助四名称,直接出货辅助五编号,直接出货辅助五名称,匹数,数量,用户名]
    public static final String m_VCANSAPP_ZHIJIECHUHUO_UPLOADBIAO2 = "VPZJCKUPBIAOXX2";      //C     上传记录格式[采集器内部ID,关联单号,数据采集项1,直接出货辅助一编号,直接出货辅助一名称,直接出货辅助二编号,直接出货辅助二名称,直接出货辅助三编号,直接出货辅助三名称,物料编号,物料描述 ,存货描述,存货标志,在库匹数,在库数量,备用1,备用2,备用3,备用4,备用5,数据采集项2,数据采集项3,直接出货辅助四编号,直接出货辅助四名称,直接出货辅助五编号,直接出货辅助五名称,匹数,数量,用户名]
    public static final String m_VCANSAPP_ZHIJIECHUHUO_UPLOADBIAO3 = "VPZJCKUPBIAOXX3";      //C     请求错误信息继续
    public static final String m_VCANSAPP_ZHIJIECHUHUO_UPLOADBIAORe0 = "VPZJCKUPBIAORE0";      //S     成功
    public static final String m_VCANSAPP_ZHIJIECHUHUO_UPLOADBIAORe1 = "VPZJCKUPBIAORE1";      //S     失败
    public static final String m_VCANSAPP_ZHIJIECHUHUO_UPLOADBIAORe3 = "VPZJCKUPBIAORE3";      //S     错误信息 + 错误记录格式[采集器内部ID]
    public static final String m_VCANSAPP_ZHIJIECHUHUO_UPLOADBIAORe5 = "VPZJCKUPBIAORE5";      //S     错误记录格式[采集器内部ID]


    /************************清单*************************************************************************/
    //==面料清单==目录下载     1
    public static final String m_VCANSAPP_Mlqdml_XIAZAI_1FZ1 = "VPMLQD1FZ1XZXX1";      //C
    public static final String m_VCANSAPP_Mlqdml_XIAZAI_1FZ2 = "VPMLQD1FZ1XZXX2";      //C
    public static final String m_VCANSAPP_Mlqdml_XIAZAI_1FZRe0 = "VPMLQD1FZ1XZRE0";      //S
    public static final String m_VCANSAPP_Mlqdml_XIAZAI_1FZRe1 = "VPMLQD1FZ1XZRE1";      //S
    public static final String m_VCANSAPP_Mlqdml_XIAZAI_1FZRe2 = "VPMLQD1FZ1XZRE2";      //S

    //==清单一==面料信息下载    2   上传数据[层级，编号，名称，当前用户]   下载[条形码，品号,品名，描述1，2，3，过滤1，2，3，所属2级目录，所属3级目录，标准报价]
    public static final String m_VCANSAPP_Mlqdml2_XIAZAI_1FZ1 = "VPMLQD2FZ1XZXX1";      //C
    public static final String m_VCANSAPP_Mlqdml2_XIAZAI_1FZ2 = "VPMLQD2FZ1XZXX2";      //C
    public static final String m_VCANSAPP_Mlqdml2_XIAZAI_1FZRe0 = "VPMLQD2FZ1XZRE0";      //S
    public static final String m_VCANSAPP_Mlqdml2_XIAZAI_1FZRe1 = "VPMLQD2FZ1XZRE1";      //S
    public static final String m_VCANSAPP_Mlqdml2_XIAZAI_1FZRe2 = "VPMLQD2FZ1XZRE2";      //S
    //==清单一==信息纲要查询   3  上传[条形码，当前用户]    下载[条形码,纲要信息，这里带图片]
    public static final String m_VCANSAPP_Mlqdml3_XIAZAI_1FZ1 = "VPMLQD3FZ1CXXX1";      //C
    public static final String m_VCANSAPP_Mlqdml3_XIAZAI_1FZ2 = "VPMLQD3FZ1XZXX2";      //C
    public static final String m_VCANSAPP_Mlqdml3_XIAZAI_1FZRe0 = "VPMLQD3FZ1CXRE0";      //S
    public static final String m_VCANSAPP_Mlqdml3_XIAZAI_1FZRe1 = "VPMLQD3FZ1CXRE1";      //S
    public static final String m_VCANSAPP_Mlqdml3_XIAZAI_1FZRe2 = "VPMLQD3FZ1XZRE2";      //S
    //=清单一==详细信息查询  4  上传[条形码，当前用户]    下载[条形码,详细信息]
    public static final String m_VCANSAPP_Mlqdml4_XIAZAI_1FZ1 = "VPMLQD4FZ1CXXX1";      //C
    public static final String m_VCANSAPP_Mlqdml4_XIAZAI_1FZ2 = "VPMLQD4FZ1XZXX2";      //C
    public static final String m_VCANSAPP_Mlqdml4_XIAZAI_1FZRe0 = "VPMLQD4FZ1CXRE0";      //S
    public static final String m_VCANSAPP_Mlqdml4_XIAZAI_1FZRe1 = "VPMLQD4FZ1CXRE1";      //S
    public static final String m_VCANSAPP_Mlqdml4_XIAZAI_1FZRe2 = "VPMLQD4FZ1XZRE2";      //S
    //==清单一==客户信息查询   5 上传[当前用户，编号处内容]    下载[客户编号][客户名称][联系人][电话][地址]
    public static final String m_VCANSAPP_Mlqdml5_XIAZAI_1FZ1 = "VPMLQD5FZ1CXXX1";      //C
    public static final String m_VCANSAPP_Mlqdml5_XIAZAI_1FZ2 = "VPMLQD5FZ1CXXX2";      //C
    public static final String m_VCANSAPP_Mlqdml5_XIAZAI_1FZRe0 = "VPMLQD5FZ1CXRE0";      //S
    public static final String m_VCANSAPP_Mlqdml5_XIAZAI_1FZRe1 = "VPMLQD5FZ1CXRE1";      //S
    public static final String m_VCANSAPP_Mlqdml5_XIAZAI_1FZRe2 = "VPMLQD5FZ1CXRE2";      //S

    //==清单一==表上传
    public static final String m_vfxVAG43VcanYPGJMLQD0 = "VSTD_ZHXYB0XXXX";     //C   [采集器记录ID,客户条码,样品条码,报价,数量,客户简称,登陆用户名，备注信息]
    public static final String m_vfxVAG43VcanYPGJMLQD1 = "VSTD_ZHXYB1XXXX";     //C
    public static final String m_vfxVAG43VcanYPGJMLQD2 = "VSTD_ZHXYB2XXXX";     //C
    public static final String m_vfxVAG43VcanYPGJMLQD3 = "VSTD_ZHXYB3XXXX";     //C
    public static final String m_vfxVAG43VcanYPGJMLQDRe0 = "VSTD_ZHXYBRE0XX";     //S
    public static final String m_vfxVAG43VcanYPGJMLQDRe1 = "VSTD_ZHXYBRE1XX";     //S
    public static final String m_vfxVAG43VcanYPGJMLQDRe3 = "VSTD_ZHXYBRE3XX";     //S
    public static final String m_vfxVAG43VcanYPGJMLQDRe5 = "VSTD_ZHXYBRE5XX";     //S

    /************************信息中心*************************************************************************/
    //==信息中心==待我审批==审批操作信息选择下载     3
    public static final String m_VCANSAPP_XINXIZHONXIN_XIAZAI_1FZ1 = "VPXXZX1FZ1XZXX1";      //C
    public static final String m_VCANSAPP_XINXIZHONXIN_XIAZAI_1FZ2 = "VPXXZX1FZ1XZXX2";      //C
    public static final String m_VCANSAPP_XINXIZHONXIN_XIAZAI_1FZRe0 = "VPXXZX1FZ1XZRE0";      //S
    public static final String m_VCANSAPP_XINXIZHONXIN_XIAZAI_1FZRe1 = "VPXXZX1FZ1XZRE1";      //S
    public static final String m_VCANSAPP_XINXIZHONXIN_XIAZAI_1FZRe2 = "VPXXZX1FZ1XZRE2";      //S

    //==信息中心==待我审批==消息扩展消息查询     4
    public static final String m_VCANSAPP_XINXIZHONXIN1 = "V48V_DLXXKZXXX1";      //C
    public static final String m_VCANSAPP_XINXIZHONXINRe0 = "V48V_DLXXKZXRE0";      //S
    public static final String m_VCANSAPP_XINXIZHONXINRe1 = "V48V_DLXXKZXRE1";      //S


    //==信息中心==待我审批==信息下载         2
    public static final String m_VCANSAPP_XINXIZHONXIN_XXIAZAI_1FZ1 = "VPXXXZ1FZ1XZXX1";      //C
    public static final String m_VCANSAPP_XINXIZHONXIN_XXIAZAI_1FZ2 = "VPXXXZ1FZ1XZXX2";      //C
    public static final String m_VCANSAPP_XINXIZHONXIN_XXIAZAI_1FZRe0 = "VPXXXZ1FZ1XZRE0";      //S
    public static final String m_VCANSAPP_XINXIZHONXIN_XXIAZAI_1FZRe1 = "VPXXXZ1FZ1XZRE1";      //S
    public static final String m_VCANSAPP_XINXIZHONXIN_XXIAZAI_1FZRe2 = "VPXXXZ1FZ1XZRE2";      //S

    //==信息中心==待我审批==操作信息下载      1
    public static final String m_VCANSAPP_XINXIZHONXIN_CZXIAZAI_1FZ1 = "VPXXCZ1FZ1XZXX1";      //C
    public static final String m_VCANSAPP_XINXIZHONXIN_CZXIAZAI_1FZ2 = "VPXXCZ1FZ1XZXX2";      //C
    public static final String m_VCANSAPP_XINXIZHONXIN_CZXIAZAI_1FZRe0 = "VPXXCZ1FZ1XZRE0";      //S
    public static final String m_VCANSAPP_XINXIZHONXIN_CZXIAZAI_1FZRe1 = "VPXXCZ1FZ1XZRE1";      //S
    public static final String m_VCANSAPP_XINXIZHONXIN_CZXIAZAI_1FZRe2 = "VPXXCZ1FZ1XZRE2";      //S


    //==信息中心==待我审批==信息数量红点下载
    public static final String m_VCANSAPP_XINXIZHONXIN_XXXIAZAI_1FZ1 = "VPXXSL1FZ1XZXX1";      //C
    public static final String m_VCANSAPP_XINXIZHONXIN_XXXIAZAI_1FZ2 = "VPXXSL1FZ1XZXX2";      //C
    public static final String m_VCANSAPP_XINXIZHONXIN_XXXIAZAI_1FZRe0 = "VPXXSL1FZ1XZRE0";      //S
    public static final String m_VCANSAPP_XINXIZHONXIN_XXXIAZAI_1FZRe1 = "VPXXSL1FZ1XZRE1";      //S
    public static final String m_VCANSAPP_XINXIZHONXIN_XXXIAZAI_1FZRe2 = "VPXXSL1FZ1XZRE2";      //S

    //==信息中心==待我审批-表上传
    public static final String m_vfxVAG43Vcanxinxizhonxin0 = "V43VCANXXZXXXX0";     //C
    public static final String m_vfxVAG43Vcanxinxizhonxin1 = "V43VCANXXZXXXX1";     //C
    public static final String m_vfxVAG43Vcanxinxizhonxin2 = "V43VCANXXZXXXX2";     //C
    public static final String m_vfxVAG43Vcanxinxizhonxin3 = "V43VCANXXZXXXX3";     //C
    public static final String m_vfxVAG43VcanxinxizhonxinRe0 = "V43VCANXXZXXRE0";     //S
    public static final String m_vfxVAG43VcanxinxizhonxinRe1 = "V43VCANXXZXXRE1";     //S
    public static final String m_vfxVAG43VcanxinxizhonxinRe3 = "V43VCANXXZXXRE3";     //S
    public static final String m_vfxVAG43VcanxinxizhonxinRe5 = "V43VCANXXZXXRE5";     //S

    //==信息中心==待我阅读-表上传
    public static final String m_vfxVAG43Vcanxinxizhonxindwyd0 = "V43VCANXXZXYDX0";     //C
    public static final String m_vfxVAG43Vcanxinxizhonxindwyd1 = "V43VCANXXZXYDX1";     //C
    public static final String m_vfxVAG43Vcanxinxizhonxindwyd2 = "V43VCANXXZXYDX2";     //C
    public static final String m_vfxVAG43Vcanxinxizhonxindwyd3 = "V43VCANXXZXYDX3";     //C
    public static final String m_vfxVAG43VcanxinxizhonxinRedwyd0 = "V43VCANXXZYDRE0";     //S
    public static final String m_vfxVAG43VcanxinxizhonxinRedwyd1 = "V43VCANXXZYDRE1";     //S
    public static final String m_vfxVAG43VcanxinxizhonxinRedwyd3 = "V43VCANXXZYDRE3";     //S
    public static final String m_vfxVAG43VcanxinxizhonxinRedwyd5 = "V43VCANXXZYDRE5";     //S


    /************************备用模块一*************************************************************************/
    //==跟单==备用模块一=辅助1下载
    public static final String m_VCANSAPP_BAKMODULE1_XIAZAI_1FZ1 = "VPBKMD1FZ1XZXX1";      //C     [备用类型][备用数据1][备用数据2][用户名]
    public static final String m_VCANSAPP_BAKMODULE1_XIAZAI_1FZ2 = "VPBKMD1FZ1XZXX2";      //C     [备用类型][备用数据1][备用数据2][用户名]
    public static final String m_VCANSAPP_BAKMODULE1_XIAZAI_1FZRe0 = "VPBKMD1FZ1XZRE0";      //S     成功    下载记录格式["备用一辅助资料1",编码,名称]
    public static final String m_VCANSAPP_BAKMODULE1_XIAZAI_1FZRe1 = "VPBKMD1FZ1XZRE1";      //S     失败    [失败信息]
    public static final String m_VCANSAPP_BAKMODULE1_XIAZAI_1FZRe2 = "VPBKMD1FZ1XZRE2";      //S     成功    下载记录格式["备用一辅助资料1",编码,名称]

    //==跟单==备用模块一=辅助2下载
    public static final String m_VCANSAPP_BAKMODULE1_XIAZAI_2FZ1 = "VPBKMD1FZ2XZXX1";      //C     [备用类型][备用数据1][备用数据2][备用辅助资料1编号][备用辅助资料1名称][用户名]
    public static final String m_VCANSAPP_BAKMODULE1_XIAZAI_2FZ2 = "VPBKMD1FZ2XZXX2";      //C     [备用类型][备用数据1][备用数据2][备用辅助资料1编号][备用辅助资料1名称][用户名]
    public static final String m_VCANSAPP_BAKMODULE1_XIAZAI_2FZRe0 = "VPBKMD1FZ2XZRE0";      //S     成功    下载记录格式["备用一辅助资料2",编码,名称]
    public static final String m_VCANSAPP_BAKMODULE1_XIAZAI_2FZRe1 = "VPBKMD1FZ2XZRE1";      //S     失败    [失败信息]
    public static final String m_VCANSAPP_BAKMODULE1_XIAZAI_2FZRe2 = "VPBKMD1FZ2XZRE2";      //S     成功    下载记录格式["备用一辅助资料2",编码,名称]


    //==跟单==备用模块一=辅助3下载
    public static final String m_VCANSAPP_BAKMODULE1_XIAZAI_3FZ1 = "VPBKMD1FZ3XZXX1";      //C     [备用类型][备用数据1][备用数据2][备用辅助资料1编号][备用辅助资料1名称][备用辅助资料2编号][备用辅助资料2名称][用户名]
    public static final String m_VCANSAPP_BAKMODULE1_XIAZAI_3FZ2 = "VPBKMD1FZ3XZXX2";      //C     [备用类型][备用数据1][备用数据2][备用辅助资料1编号][备用辅助资料1名称][备用辅助资料2编号][备用辅助资料2名称][用户名]
    public static final String m_VCANSAPP_BAKMODULE1_XIAZAI_3FZRe0 = "VPBKMD1FZ3XZRE0";      //S     成功    下载记录格式["备用一辅助资料3",编码,名称]
    public static final String m_VCANSAPP_BAKMODULE1_XIAZAI_3FZRe1 = "VPBKMD1FZ3XZRE1";      //S     失败    [失败信息]
    public static final String m_VCANSAPP_BAKMODULE1_XIAZAI_3FZRe2 = "VPBKMD1FZ3XZRE2";      //S     成功    下载记录格式["备用一辅助资料3",编码,名称]

    //==跟单==备用模块一=辅助4下载
    public static final String m_VCANSAPP_BAKMODULE1_XIAZAI_4FZ1 = "VPBKMD1FZ4XZXX1";      //C     [备用类型][备用数据1][备用数据2][备用辅助资料1编号][备用辅助资料1名称][备用辅助资料2编号][备用辅助资料2名称][备用辅助资料3编号][备用辅助资料3名称][用户名]
    public static final String m_VCANSAPP_BAKMODULE1_XIAZAI_4FZ2 = "VPBKMD1FZ4XZXX2";      //C     [备用类型][备用数据1][备用数据2][备用辅助资料1编号][备用辅助资料1名称][备用辅助资料2编号][备用辅助资料2名称][备用辅助资料3编号][备用辅助资料3名称][用户名]
    public static final String m_VCANSAPP_BAKMODULE1_XIAZAI_4FZRe0 = "VPBKMD1FZ4XZRE0";      //S     成功    下载记录格式["备用一辅助资料4",编码,名称]
    public static final String m_VCANSAPP_BAKMODULE1_XIAZAI_4FZRe1 = "VPBKMD1FZ4XZRE1";      //S     失败    [失败信息]
    public static final String m_VCANSAPP_BAKMODULE1_XIAZAI_4FZRe2 = "VPBKMD1FZ4XZRE2";      //S     成功    下载记录格式["备用一辅助资料4",编码,名称]

    //==跟单==备用模块一=辅助5下载
    public static final String m_VCANSAPP_BAKMODULE1_XIAZAI_5FZ1 = "VPBKMD1FZ5XZXX1";      //C     [备用类型][备用数据1][备用数据2][备用辅助资料1编号][备用辅助资料1名称][备用辅助资料2编号][备用辅助资料2名称][备用辅助资料3编号][备用辅助资料3名称][备用辅助资料4编号][备用辅助资料4名称][物料编号,物料描述,存货描述,存货标志,匹数,数量, 信息一, 信息二, 信息三, 信息四, 信息五][备用扣除数量1][备用扣除数量2][备用数据3][备用数据4][备用数据5][用户名]
    public static final String m_VCANSAPP_BAKMODULE1_XIAZAI_5FZ2 = "VPBKMD1FZ5XZXX2";      //C     [备用类型][备用数据1][备用数据2][备用辅助资料1编号][备用辅助资料1名称][备用辅助资料2编号][备用辅助资料2名称][备用辅助资料3编号][备用辅助资料3名称][备用辅助资料4编号][备用辅助资料4名称][物料编号,物料描述,存货描述,存货标志,匹数,数量, 信息一, 信息二, 信息三, 信息四, 信息五][备用扣除数量1][备用扣除数量2][备用数据3][备用数据4][备用数据5][用户名]
    public static final String m_VCANSAPP_BAKMODULE1_XIAZAI_5FZRe0 = "VPBKMD1FZ5XZRE0";      //S     成功    下载记录格式["备用一辅助资料5",编码,名称]
    public static final String m_VCANSAPP_BAKMODULE1_XIAZAI_5FZRe1 = "VPBKMD1FZ5XZRE1";      //S     失败    [失败信息]
    public static final String m_VCANSAPP_BAKMODULE1_XIAZAI_5FZRe2 = "VPBKMD1FZ5XZRE2";      //S     成功    下载记录格式["备用一辅助资料5",编码,名称]

    //==跟单==备用模块一=辅助6下载
    public static final String m_VCANSAPP_BAKMODULE1_XIAZAI_6FZ1 = "VPBKMD1FZ6XZXX1";      //C     [备用类型][备用数据1][备用数据2][备用辅助资料1编号][备用辅助资料1名称][备用辅助资料2编号][备用辅助资料2名称][备用辅助资料3编号][备用辅助资料3名称][备用辅助资料4编号][备用辅助资料4名称][物料编号,物料描述,存货描述,存货标志,匹数,数量, 信息一, 信息二, 信息三, 信息四, 信息五][备用扣除数量1][备用扣除数量2][备用数据3][备用数据4][备用数据5][备用辅助资料5编号][备用辅助资料5名称][用户名]
    public static final String m_VCANSAPP_BAKMODULE1_XIAZAI_6FZ2 = "VPBKMD1FZ6XZXX2";      //C     [备用类型][备用数据1][备用数据2][备用辅助资料1编号][备用辅助资料1名称][备用辅助资料2编号][备用辅助资料2名称][备用辅助资料3编号][备用辅助资料3名称][备用辅助资料4编号][备用辅助资料4名称][物料编号,物料描述,存货描述,存货标志,匹数,数量, 信息一, 信息二, 信息三, 信息四, 信息五][备用扣除数量1][备用扣除数量2][备用数据3][备用数据4][备用数据5][备用辅助资料5编号][备用辅助资料5名称][用户名]
    public static final String m_VCANSAPP_BAKMODULE1_XIAZAI_6FZRe0 = "VPBKMD1FZ6XZRE0";      //S     成功    下载记录格式["备用一辅助资料6",编码,名称]
    public static final String m_VCANSAPP_BAKMODULE1_XIAZAI_6FZRe1 = "VPBKMD1FZ6XZRE1";      //S     失败    [失败信息]
    public static final String m_VCANSAPP_BAKMODULE1_XIAZAI_6FZRe2 = "VPBKMD1FZ6XZRE2";      //S     成功    下载记录格式["备用一辅助资料6",编码,名称]

    //==跟单==备用模块一=辅助7下载
    public static final String m_VCANSAPP_BAKMODULE1_XIAZAI_7FZ1 = "VPBKMD1FZ7XZXX1";      //C     [备用类型][备用数据1][备用数据2][备用辅助资料1编号][备用辅助资料1名称][备用辅助资料2编号][备用辅助资料2名称][备用辅助资料3编号][备用辅助资料3名称][备用辅助资料4编号][备用辅助资料4名称][物料编号,物料描述,存货描述,存货标志,匹数,数量, 信息一, 信息二, 信息三, 信息四, 信息五][备用扣除数量1][备用扣除数量2][备用数据3][备用数据4][备用数据5][备用辅助资料5编号][备用辅助资料5名称][备用辅助资料6编号][备用辅助资料6名称][用户名]
    public static final String m_VCANSAPP_BAKMODULE1_XIAZAI_7FZ2 = "VPBKMD1FZ7XZXX2";      //C     [备用类型][备用数据1][备用数据2][备用辅助资料1编号][备用辅助资料1名称][备用辅助资料2编号][备用辅助资料2名称][备用辅助资料3编号][备用辅助资料3名称][备用辅助资料4编号][备用辅助资料4名称][物料编号,物料描述,存货描述,存货标志,匹数,数量, 信息一, 信息二, 信息三, 信息四, 信息五][备用扣除数量1][备用扣除数量2][备用数据3][备用数据4][备用数据5][备用辅助资料5编号][备用辅助资料5名称][备用辅助资料6编号][备用辅助资料6名称][用户名]
    public static final String m_VCANSAPP_BAKMODULE1_XIAZAI_7FZRe0 = "VPBKMD1FZ7XZRE0";      //S     成功    下载记录格式["备用一辅助资料6",编码,名称]
    public static final String m_VCANSAPP_BAKMODULE1_XIAZAI_7FZRe1 = "VPBKMD1FZ7XZRE1";      //S     失败    [失败信息]
    public static final String m_VCANSAPP_BAKMODULE1_XIAZAI_7FZRe2 = "VPBKMD1FZ7XZRE2";      //S     成功    下载记录格式["备用一辅助资料6",编码,名称]


    //==跟单==备用模块一=物料信息下载
    public static final String m_VCANSAPP_BAKMODULE1_XIAZAI_WULIAO1 = "VPBKMD1WLXZXXX1";      //C     [备用类型][备用数据1][备用数据2][备用辅助资料1编号][备用辅助资料1名称][备用辅助资料2编号][备用辅助资料2名称][备用辅助资料3编号][备用辅助资料3名称][备用辅助资料4编号][备用辅助资料4名称][用户名]
    public static final String m_VCANSAPP_BAKMODULE1_XIAZAI_WULIAO2 = "VPBKMD1WLXZXXX2";      //C     [备用类型][备用数据1][备用数据2][备用辅助资料1编号][备用辅助资料1名称][备用辅助资料2编号][备用辅助资料2名称][备用辅助资料3编号][备用辅助资料3名称][备用辅助资料4编号][备用辅助资料4名称][用户名]
    public static final String m_VCANSAPP_BAKMODULE1_XIAZAI_WULIAORe0 = "VPBKMD1WLXZXRE0";      //S     成功    下载记录格式[物料编号,物料描述 ,存货描述,存货标志,在库匹数,在库数量,备用1,备用2,备用3,备用4,备用5]
    public static final String m_VCANSAPP_BAKMODULE1_XIAZAI_WULIAORe1 = "VPBKMD1WLXZXRE1";      //S     失败    [失败信息]
    public static final String m_VCANSAPP_BAKMODULE1_XIAZAI_WULIAORe2 = "VPBKMD1WLXZXRE2";      //S     成功   下载记录格式[物料编号,物料描述 ,存货描述,存货标志,在库匹数,在库数量,备用1,备用2,备用3,备用4,备用5]

    //==跟单==备用模块一==表上传
    public static final String m_VCANSAPP_BAKMODULE1_UPLOADBIAO0 = "VPBKMD1UPBIAOX0";      //C     开始命令
    public static final String m_VCANSAPP_BAKMODULE1_UPLOADBIAO1 = "VPBKMD1UPBIAOX1";      //C     上传记录格式[内部ID,备用类型,备用数据1,备用数据2,备用辅助资料1编号,备用辅助资料1名称,备用辅助资料2编号,备用辅助资料2名称,备用辅助资料3编号,备用辅助资料3名称,备用辅助资料4编号,备用辅助资料4名称,[物料编号,物料描述 ,存货描述,存货标志,在库匹数,在库数量,备用1,备用2,备用3,备用4,备用5],备用扣数量1,备用扣数量2,备用数据3,备用数据4,备用数据5,备用辅助资料5编号,备用辅助资料5名称,备用辅助资料6编号,备用辅助资料6名称,备用辅助资料7编号,备用辅助资料7名称,备用数据6,备用数据7,备用辅助资料8编号,备用辅助资料8名称,备用辅助资料9编号,备用辅助资料9名称,数量1,数量2,用户名,图片]
    public static final String m_VCANSAPP_BAKMODULE1_UPLOADBIAO2 = "VPBKMD1UPBIAOX2";      //C     上传记录格式[内部ID,备用类型,备用数据1,备用数据2,备用辅助资料1编号,备用辅助资料1名称,备用辅助资料2编号,备用辅助资料2名称,备用辅助资料3编号,备用辅助资料3名称,备用辅助资料4编号,备用辅助资料4名称,[物料编号,物料描述 ,存货描述,存货标志,在库匹数,在库数量,备用1,备用2,备用3,备用4,备用5],备用扣数量1,备用扣数量2,备用数据3,备用数据4,备用数据5,备用辅助资料5编号,备用辅助资料5名称,备用辅助资料6编号,备用辅助资料6名称,备用辅助资料7编号,备用辅助资料7名称,备用数据6,备用数据7,备用辅助资料8编号,备用辅助资料8名称,备用辅助资料9编号,备用辅助资料9名称,数量1,数量2,用户名,图片]
    public static final String m_VCANSAPP_BAKMODULE1_UPLOADBIAO3 = "VPBKMD1UPBIAOX3";      //C     请求错误信息继续
    public static final String m_VCANSAPP_BAKMODULE1_UPLOADBIAORe0 = "VPBKMD1UPBIARE0";      //S     成功
    public static final String m_VCANSAPP_BAKMODULE1_UPLOADBIAORe1 = "VPBKMD1UPBIARE1";      //S     失败
    public static final String m_VCANSAPP_BAKMODULE1_UPLOADBIAORe3 = "VPBKMD1UPBIARE3";      //S     错误信息 + 错误记录格式[采集器内部ID]
    public static final String m_VCANSAPP_BAKMODULE1_UPLOADBIAORe5 = "VPBKMD1UPBIARE5";      //S     错误记录格式[采集器内部ID]

    /************************备用模块二*************************************************************************/
    //==跟单==备用模块二=辅助1下载
    public static final String m_VCANSAPP_BAKMODULE2_XIAZAI_1FZ1 = "VPBKMD2FZ1XZXX1";      //C     [备用类型][备用数据1][备用数据2][用户名]
    public static final String m_VCANSAPP_BAKMODULE2_XIAZAI_1FZ2 = "VPBKMD2FZ1XZXX2";      //C     [备用类型][备用数据1][备用数据2][用户名]
    public static final String m_VCANSAPP_BAKMODULE2_XIAZAI_1FZRe0 = "VPBKMD2FZ1XZRE0";      //S     成功    下载记录格式["备用二辅助资料1",编码,名称]
    public static final String m_VCANSAPP_BAKMODULE2_XIAZAI_1FZRe1 = "VPBKMD2FZ1XZRE1";      //S     失败    [失败信息]
    public static final String m_VCANSAPP_BAKMODULE2_XIAZAI_1FZRe2 = "VPBKMD2FZ1XZRE2";      //S     成功    下载记录格式["备用二辅助资料1",编码,名称]

    //==跟单==备用模块二=辅助2下载
    public static final String m_VCANSAPP_BAKMODULE2_XIAZAI_2FZ1 = "VPBKMD2FZ2XZXX1";      //C     [备用类型][备用数据1][备用数据2][备用辅助资料1编号][备用辅助资料1名称][用户名]
    public static final String m_VCANSAPP_BAKMODULE2_XIAZAI_2FZ2 = "VPBKMD2FZ2XZXX2";      //C     [备用类型][备用数据1][备用数据2][备用辅助资料1编号][备用辅助资料1名称][用户名]
    public static final String m_VCANSAPP_BAKMODULE2_XIAZAI_2FZRe0 = "VPBKMD2FZ2XZRE0";      //S     成功    下载记录格式["备用二辅助资料2",编码,名称]
    public static final String m_VCANSAPP_BAKMODULE2_XIAZAI_2FZRe1 = "VPBKMD2FZ2XZRE1";      //S     失败    [失败信息]
    public static final String m_VCANSAPP_BAKMODULE2_XIAZAI_2FZRe2 = "VPBKMD2FZ2XZRE2";      //S     成功    下载记录格式["备用二辅助资料2",编码,名称]


    //==跟单==备用模块二=辅助3下载
    public static final String m_VCANSAPP_BAKMODULE2_XIAZAI_3FZ1 = "VPBKMD2FZ3XZXX1";      //C     [备用类型][备用数据1][备用数据2][备用辅助资料1编号][备用辅助资料1名称][备用辅助资料2编号][备用辅助资料2名称][用户名]
    public static final String m_VCANSAPP_BAKMODULE2_XIAZAI_3FZ2 = "VPBKMD2FZ3XZXX2";      //C     [备用类型][备用数据1][备用数据2][备用辅助资料1编号][备用辅助资料1名称][备用辅助资料2编号][备用辅助资料2名称][用户名]
    public static final String m_VCANSAPP_BAKMODULE2_XIAZAI_3FZRe0 = "VPBKMD2FZ3XZRE0";      //S     成功    下载记录格式["备用二辅助资料3",编码,名称]
    public static final String m_VCANSAPP_BAKMODULE2_XIAZAI_3FZRe1 = "VPBKMD2FZ3XZRE1";      //S     失败    [失败信息]
    public static final String m_VCANSAPP_BAKMODULE2_XIAZAI_3FZRe2 = "VPBKMD2FZ3XZRE2";      //S     成功    下载记录格式["备用二辅助资料3",编码,名称]

    //==跟单==备用模块二=辅助4下载
    public static final String m_VCANSAPP_BAKMODULE2_XIAZAI_4FZ1 = "VPBKMD2FZ4XZXX1";      //C     [备用类型][备用数据1][备用数据2][备用辅助资料1编号][备用辅助资料1名称][备用辅助资料2编号][备用辅助资料2名称][备用辅助资料3编号][备用辅助资料3名称][用户名]
    public static final String m_VCANSAPP_BAKMODULE2_XIAZAI_4FZ2 = "VPBKMD2FZ4XZXX2";      //C     [备用类型][备用数据1][备用数据2][备用辅助资料1编号][备用辅助资料1名称][备用辅助资料2编号][备用辅助资料2名称][备用辅助资料3编号][备用辅助资料3名称][用户名]
    public static final String m_VCANSAPP_BAKMODULE2_XIAZAI_4FZRe0 = "VPBKMD2FZ4XZRE0";      //S     成功    下载记录格式["备用二辅助资料4",编码,名称]
    public static final String m_VCANSAPP_BAKMODULE2_XIAZAI_4FZRe1 = "VPBKMD2FZ4XZRE1";      //S     失败    [失败信息]
    public static final String m_VCANSAPP_BAKMODULE2_XIAZAI_4FZRe2 = "VPBKMD2FZ4XZRE2";      //S     成功    下载记录格式["备用二辅助资料4",编码,名称]

    //==跟单==备用模块二=辅助5下载
    public static final String m_VCANSAPP_BAKMODULE2_XIAZAI_5FZ1 = "VPBKMD2FZ5XZXX1";      //C     [备用类型][备用数据1][备用数据2][备用辅助资料1编号][备用辅助资料1名称][备用辅助资料2编号][备用辅助资料2名称][备用辅助资料3编号][备用辅助资料3名称][备用辅助资料4编号][备用辅助资料4名称][物料编号,物料描述,存货描述,存货标志,匹数,数量, 信息一, 信息二, 信息三, 信息四, 信息五][备用扣除数量1][备用扣除数量2][备用数据3][备用数据4][备用数据5][用户名]
    public static final String m_VCANSAPP_BAKMODULE2_XIAZAI_5FZ2 = "VPBKMD2FZ5XZXX2";      //C     [备用类型][备用数据1][备用数据2][备用辅助资料1编号][备用辅助资料1名称][备用辅助资料2编号][备用辅助资料2名称][备用辅助资料3编号][备用辅助资料3名称][备用辅助资料4编号][备用辅助资料4名称][物料编号,物料描述,存货描述,存货标志,匹数,数量, 信息一, 信息二, 信息三, 信息四, 信息五][备用扣除数量1][备用扣除数量2][备用数据3][备用数据4][备用数据5][用户名]
    public static final String m_VCANSAPP_BAKMODULE2_XIAZAI_5FZRe0 = "VPBKMD2FZ5XZRE0";      //S     成功    下载记录格式["备用二辅助资料5",编码,名称]
    public static final String m_VCANSAPP_BAKMODULE2_XIAZAI_5FZRe1 = "VPBKMD2FZ5XZRE1";      //S     失败    [失败信息]
    public static final String m_VCANSAPP_BAKMODULE2_XIAZAI_5FZRe2 = "VPBKMD2FZ5XZRE2";      //S     成功    下载记录格式["备用二辅助资料5",编码,名称]

    //==跟单==备用模块二=辅助6下载
    public static final String m_VCANSAPP_BAKMODULE2_XIAZAI_6FZ1 = "VPBKMD2FZ6XZXX1";      //C     [备用类型][备用数据1][备用数据2][备用辅助资料1编号][备用辅助资料1名称][备用辅助资料2编号][备用辅助资料2名称][备用辅助资料3编号][备用辅助资料3名称][备用辅助资料4编号][备用辅助资料4名称][物料编号,物料描述,存货描述,存货标志,匹数,数量, 信息一, 信息二, 信息三, 信息四, 信息五][备用扣除数量1][备用扣除数量2][备用数据3][备用数据4][备用数据5][备用辅助资料5编号][备用辅助资料5名称][用户名]
    public static final String m_VCANSAPP_BAKMODULE2_XIAZAI_6FZ2 = "VPBKMD2FZ6XZXX2";      //C     [备用类型][备用数据1][备用数据2][备用辅助资料1编号][备用辅助资料1名称][备用辅助资料2编号][备用辅助资料2名称][备用辅助资料3编号][备用辅助资料3名称][备用辅助资料4编号][备用辅助资料4名称][物料编号,物料描述,存货描述,存货标志,匹数,数量, 信息一, 信息二, 信息三, 信息四, 信息五][备用扣除数量1][备用扣除数量2][备用数据3][备用数据4][备用数据5][备用辅助资料5编号][备用辅助资料5名称][用户名]
    public static final String m_VCANSAPP_BAKMODULE2_XIAZAI_6FZRe0 = "VPBKMD2FZ6XZRE0";      //S     成功    下载记录格式["备用二辅助资料6",编码,名称]
    public static final String m_VCANSAPP_BAKMODULE2_XIAZAI_6FZRe1 = "VPBKMD2FZ6XZRE1";      //S     失败    [失败信息]
    public static final String m_VCANSAPP_BAKMODULE2_XIAZAI_6FZRe2 = "VPBKMD2FZ6XZRE2";      //S     成功    下载记录格式["备用二辅助资料6",编码,名称]

    //==跟单==备用模块二=辅助7下载
    public static final String m_VCANSAPP_BAKMODULE2_XIAZAI_7FZ1 = "VPBKMD2FZ7XZXX1";      //C     [备用类型][备用数据1][备用数据2][备用辅助资料1编号][备用辅助资料1名称][备用辅助资料2编号][备用辅助资料2名称][备用辅助资料3编号][备用辅助资料3名称][备用辅助资料4编号][备用辅助资料4名称][物料编号,物料描述,存货描述,存货标志,匹数,数量, 信息一, 信息二, 信息三, 信息四, 信息五][备用扣除数量1][备用扣除数量2][备用数据3][备用数据4][备用数据5][备用辅助资料5编号][备用辅助资料5名称][备用辅助资料6编号][备用辅助资料6名称][用户名]
    public static final String m_VCANSAPP_BAKMODULE2_XIAZAI_7FZ2 = "VPBKMD2FZ7XZXX2";      //C     [备用类型][备用数据1][备用数据2][备用辅助资料1编号][备用辅助资料1名称][备用辅助资料2编号][备用辅助资料2名称][备用辅助资料3编号][备用辅助资料3名称][备用辅助资料4编号][备用辅助资料4名称][物料编号,物料描述,存货描述,存货标志,匹数,数量, 信息一, 信息二, 信息三, 信息四, 信息五][备用扣除数量1][备用扣除数量2][备用数据3][备用数据4][备用数据5][备用辅助资料5编号][备用辅助资料5名称][备用辅助资料6编号][备用辅助资料6名称][用户名]
    public static final String m_VCANSAPP_BAKMODULE2_XIAZAI_7FZRe0 = "VPBKMD2FZ7XZRE0";      //S     成功    下载记录格式["备用二辅助资料6",编码,名称]
    public static final String m_VCANSAPP_BAKMODULE2_XIAZAI_7FZRe1 = "VPBKMD2FZ7XZRE1";      //S     失败    [失败信息]
    public static final String m_VCANSAPP_BAKMODULE2_XIAZAI_7FZRe2 = "VPBKMD2FZ7XZRE2";      //S     成功    下载记录格式["备用二辅助资料6",编码,名称]


    //==跟单==备用模块二=物料信息下载
    public static final String m_VCANSAPP_BAKMODULE2_XIAZAI_WULIAO1 = "VPBKMD2WLXZXXX1";      //C     [备用类型][备用数据1][备用数据2][备用辅助资料1编号][备用辅助资料1名称][备用辅助资料2编号][备用辅助资料2名称][备用辅助资料3编号][备用辅助资料3名称][备用辅助资料4编号][备用辅助资料4名称][用户名]
    public static final String m_VCANSAPP_BAKMODULE2_XIAZAI_WULIAO2 = "VPBKMD2WLXZXXX2";      //C     [备用类型][备用数据1][备用数据2][备用辅助资料1编号][备用辅助资料1名称][备用辅助资料2编号][备用辅助资料2名称][备用辅助资料3编号][备用辅助资料3名称][备用辅助资料4编号][备用辅助资料4名称][用户名]
    public static final String m_VCANSAPP_BAKMODULE2_XIAZAI_WULIAORe0 = "VPBKMD2WLXZXRE0";      //S     成功    下载记录格式[物料编号,物料描述 ,存货描述,存货标志,在库匹数,在库数量,备用1,备用2,备用3,备用4,备用5]
    public static final String m_VCANSAPP_BAKMODULE2_XIAZAI_WULIAORe1 = "VPBKMD2WLXZXRE1";      //S     失败    [失败信息]
    public static final String m_VCANSAPP_BAKMODULE2_XIAZAI_WULIAORe2 = "VPBKMD2WLXZXRE2";      //S     成功   下载记录格式[物料编号,物料描述 ,存货描述,存货标志,在库匹数,在库数量,备用1,备用2,备用3,备用4,备用5]

    //==跟单==备用模块二==表上传
    public static final String m_VCANSAPP_BAKMODULE2_UPLOADBIAO0 = "VPBKMD2UPBIAOX0";      //C     开始命令
    public static final String m_VCANSAPP_BAKMODULE2_UPLOADBIAO1 = "VPBKMD2UPBIAOX1";      //C     上传记录格式[内部ID,备用类型,备用数据1,备用数据2,备用辅助资料1编号,备用辅助资料1名称,备用辅助资料2编号,备用辅助资料2名称,备用辅助资料3编号,备用辅助资料3名称,备用辅助资料4编号,备用辅助资料4名称,[物料编号,物料描述 ,存货描述,存货标志,在库匹数,在库数量,备用1,备用2,备用3,备用4,备用5],备用扣数量1,备用扣数量2,备用数据3,备用数据4,备用数据5,备用辅助资料5编号,备用辅助资料5名称,备用辅助资料6编号,备用辅助资料6名称,备用辅助资料7编号,备用辅助资料7名称,备用数据6,备用数据7,备用辅助资料8编号,备用辅助资料8名称,备用辅助资料9编号,备用辅助资料9名称,数量1,数量2,用户名,图片]
    public static final String m_VCANSAPP_BAKMODULE2_UPLOADBIAO2 = "VPBKMD2UPBIAOX2";      //C     上传记录格式[内部ID,备用类型,备用数据1,备用数据2,备用辅助资料1编号,备用辅助资料1名称,备用辅助资料2编号,备用辅助资料2名称,备用辅助资料3编号,备用辅助资料3名称,备用辅助资料4编号,备用辅助资料4名称,[物料编号,物料描述 ,存货描述,存货标志,在库匹数,在库数量,备用1,备用2,备用3,备用4,备用5],备用扣数量1,备用扣数量2,备用数据3,备用数据4,备用数据5,备用辅助资料5编号,备用辅助资料5名称,备用辅助资料6编号,备用辅助资料6名称,备用辅助资料7编号,备用辅助资料7名称,备用数据6,备用数据7,备用辅助资料8编号,备用辅助资料8名称,备用辅助资料9编号,备用辅助资料9名称,数量1,数量2,用户名,图片]
    public static final String m_VCANSAPP_BAKMODULE2_UPLOADBIAO3 = "VPBKMD2UPBIAOX3";      //C     请求错误信息继续
    public static final String m_VCANSAPP_BAKMODULE2_UPLOADBIAORe0 = "VPBKMD2UPBIARE0";      //S     成功
    public static final String m_VCANSAPP_BAKMODULE2_UPLOADBIAORe1 = "VPBKMD2UPBIARE1";      //S     失败
    public static final String m_VCANSAPP_BAKMODULE2_UPLOADBIAORe3 = "VPBKMD2UPBIARE3";      //S     错误信息 + 错误记录格式[采集器内部ID]
    public static final String m_VCANSAPP_BAKMODULE2_UPLOADBIAORe5 = "VPBKMD2UPBIARE5";      //S     错误记录格式[采集器内部ID]

    /************************备用模块三*************************************************************************/
    //==跟单==备用模块三=辅助1下载
    public static final String m_VCANSAPP_BAKMODULE3_XIAZAI_1FZ1 = "VPBKMD3FZ1XZXX1";      //C     [备用类型][备用数据1][备用数据2][用户名]
    public static final String m_VCANSAPP_BAKMODULE3_XIAZAI_1FZ2 = "VPBKMD3FZ1XZXX2";      //C     [备用类型][备用数据1][备用数据2][用户名]
    public static final String m_VCANSAPP_BAKMODULE3_XIAZAI_1FZRe0 = "VPBKMD3FZ1XZRE0";      //S     成功    下载记录格式["备用三辅助资料1",编码,名称]
    public static final String m_VCANSAPP_BAKMODULE3_XIAZAI_1FZRe1 = "VPBKMD3FZ1XZRE1";      //S     失败    [失败信息]
    public static final String m_VCANSAPP_BAKMODULE3_XIAZAI_1FZRe2 = "VPBKMD3FZ1XZRE2";      //S     成功    下载记录格式["备用三辅助资料1",编码,名称]

    //==跟单==备用模块三=辅助2下载
    public static final String m_VCANSAPP_BAKMODULE3_XIAZAI_2FZ1 = "VPBKMD3FZ2XZXX1";      //C     [备用类型][备用数据1][备用数据2][备用辅助资料1编号][备用辅助资料1名称][用户名]
    public static final String m_VCANSAPP_BAKMODULE3_XIAZAI_2FZ2 = "VPBKMD3FZ2XZXX2";      //C     [备用类型][备用数据1][备用数据2][备用辅助资料1编号][备用辅助资料1名称][用户名]
    public static final String m_VCANSAPP_BAKMODULE3_XIAZAI_2FZRe0 = "VPBKMD3FZ2XZRE0";      //S     成功    下载记录格式["备用三辅助资料2",编码,名称]
    public static final String m_VCANSAPP_BAKMODULE3_XIAZAI_2FZRe1 = "VPBKMD3FZ2XZRE1";      //S     失败    [失败信息]
    public static final String m_VCANSAPP_BAKMODULE3_XIAZAI_2FZRe2 = "VPBKMD3FZ2XZRE2";      //S     成功    下载记录格式["备用三辅助资料2",编码,名称]


    //==跟单==备用模块三=辅助3下载
    public static final String m_VCANSAPP_BAKMODULE3_XIAZAI_3FZ1 = "VPBKMD3FZ3XZXX1";      //C     [备用类型][备用数据1][备用数据2][备用辅助资料1编号][备用辅助资料1名称][备用辅助资料2编号][备用辅助资料2名称][用户名]
    public static final String m_VCANSAPP_BAKMODULE3_XIAZAI_3FZ2 = "VPBKMD3FZ3XZXX2";      //C     [备用类型][备用数据1][备用数据2][备用辅助资料1编号][备用辅助资料1名称][备用辅助资料2编号][备用辅助资料2名称][用户名]
    public static final String m_VCANSAPP_BAKMODULE3_XIAZAI_3FZRe0 = "VPBKMD3FZ3XZRE0";      //S     成功    下载记录格式["备用三辅助资料3",编码,名称]
    public static final String m_VCANSAPP_BAKMODULE3_XIAZAI_3FZRe1 = "VPBKMD3FZ3XZRE1";      //S     失败    [失败信息]
    public static final String m_VCANSAPP_BAKMODULE3_XIAZAI_3FZRe2 = "VPBKMD3FZ3XZRE2";      //S     成功    下载记录格式["备用三辅助资料3",编码,名称]

    //==跟单==备用模块三=辅助4下载
    public static final String m_VCANSAPP_BAKMODULE3_XIAZAI_4FZ1 = "VPBKMD3FZ4XZXX1";      //C     [备用类型][备用数据1][备用数据2][备用辅助资料1编号][备用辅助资料1名称][备用辅助资料2编号][备用辅助资料2名称][备用辅助资料3编号][备用辅助资料3名称][用户名]
    public static final String m_VCANSAPP_BAKMODULE3_XIAZAI_4FZ2 = "VPBKMD3FZ4XZXX2";      //C     [备用类型][备用数据1][备用数据2][备用辅助资料1编号][备用辅助资料1名称][备用辅助资料2编号][备用辅助资料2名称][备用辅助资料3编号][备用辅助资料3名称][用户名]
    public static final String m_VCANSAPP_BAKMODULE3_XIAZAI_4FZRe0 = "VPBKMD3FZ4XZRE0";      //S     成功    下载记录格式["备用三辅助资料4",编码,名称]
    public static final String m_VCANSAPP_BAKMODULE3_XIAZAI_4FZRe1 = "VPBKMD3FZ4XZRE1";      //S     失败    [失败信息]
    public static final String m_VCANSAPP_BAKMODULE3_XIAZAI_4FZRe2 = "VPBKMD3FZ4XZRE2";      //S     成功    下载记录格式["备用三辅助资料4",编码,名称]

    //==跟单==备用模块三=辅助5下载
    public static final String m_VCANSAPP_BAKMODULE3_XIAZAI_5FZ1 = "VPBKMD3FZ5XZXX1";      //C     [备用类型][备用数据1][备用数据2][备用辅助资料1编号][备用辅助资料1名称][备用辅助资料2编号][备用辅助资料2名称][备用辅助资料3编号][备用辅助资料3名称][备用辅助资料4编号][备用辅助资料4名称][物料编号,物料描述,存货描述,存货标志,匹数,数量, 信息一, 信息二, 信息三, 信息四, 信息五][备用扣除数量1][备用扣除数量2][备用数据3][备用数据4][备用数据5][用户名]
    public static final String m_VCANSAPP_BAKMODULE3_XIAZAI_5FZ2 = "VPBKMD3FZ5XZXX2";      //C     [备用类型][备用数据1][备用数据2][备用辅助资料1编号][备用辅助资料1名称][备用辅助资料2编号][备用辅助资料2名称][备用辅助资料3编号][备用辅助资料3名称][备用辅助资料4编号][备用辅助资料4名称][物料编号,物料描述,存货描述,存货标志,匹数,数量, 信息一, 信息二, 信息三, 信息四, 信息五][备用扣除数量1][备用扣除数量2][备用数据3][备用数据4][备用数据5][用户名]
    public static final String m_VCANSAPP_BAKMODULE3_XIAZAI_5FZRe0 = "VPBKMD3FZ5XZRE0";      //S     成功    下载记录格式["备用三辅助资料5",编码,名称]
    public static final String m_VCANSAPP_BAKMODULE3_XIAZAI_5FZRe1 = "VPBKMD3FZ5XZRE1";      //S     失败    [失败信息]
    public static final String m_VCANSAPP_BAKMODULE3_XIAZAI_5FZRe2 = "VPBKMD3FZ5XZRE2";      //S     成功    下载记录格式["备用三辅助资料5",编码,名称]

    //==跟单==备用模块三=辅助6下载
    public static final String m_VCANSAPP_BAKMODULE3_XIAZAI_6FZ1 = "VPBKMD3FZ6XZXX1";      //C     [备用类型][备用数据1][备用数据2][备用辅助资料1编号][备用辅助资料1名称][备用辅助资料2编号][备用辅助资料2名称][备用辅助资料3编号][备用辅助资料3名称][备用辅助资料4编号][备用辅助资料4名称][物料编号,物料描述,存货描述,存货标志,匹数,数量, 信息一, 信息二, 信息三, 信息四, 信息五][备用扣除数量1][备用扣除数量2][备用数据3][备用数据4][备用数据5][备用辅助资料5编号][备用辅助资料5名称][用户名]
    public static final String m_VCANSAPP_BAKMODULE3_XIAZAI_6FZ2 = "VPBKMD3FZ6XZXX2";      //C     [备用类型][备用数据1][备用数据2][备用辅助资料1编号][备用辅助资料1名称][备用辅助资料2编号][备用辅助资料2名称][备用辅助资料3编号][备用辅助资料3名称][备用辅助资料4编号][备用辅助资料4名称][物料编号,物料描述,存货描述,存货标志,匹数,数量, 信息一, 信息二, 信息三, 信息四, 信息五][备用扣除数量1][备用扣除数量2][备用数据3][备用数据4][备用数据5][备用辅助资料5编号][备用辅助资料5名称][用户名]
    public static final String m_VCANSAPP_BAKMODULE3_XIAZAI_6FZRe0 = "VPBKMD3FZ6XZRE0";      //S     成功    下载记录格式["备用三辅助资料6",编码,名称]
    public static final String m_VCANSAPP_BAKMODULE3_XIAZAI_6FZRe1 = "VPBKMD3FZ6XZRE1";      //S     失败    [失败信息]
    public static final String m_VCANSAPP_BAKMODULE3_XIAZAI_6FZRe2 = "VPBKMD3FZ6XZRE2";      //S     成功    下载记录格式["备用三辅助资料6",编码,名称]

    //==跟单==备用模块三=辅助7下载
    public static final String m_VCANSAPP_BAKMODULE3_XIAZAI_7FZ1 = "VPBKMD3FZ7XZXX1";      //C     [备用类型][备用数据1][备用数据2][备用辅助资料1编号][备用辅助资料1名称][备用辅助资料2编号][备用辅助资料2名称][备用辅助资料3编号][备用辅助资料3名称][备用辅助资料4编号][备用辅助资料4名称][物料编号,物料描述,存货描述,存货标志,匹数,数量, 信息一, 信息二, 信息三, 信息四, 信息五][备用扣除数量1][备用扣除数量2][备用数据3][备用数据4][备用数据5][备用辅助资料5编号][备用辅助资料5名称][备用辅助资料6编号][备用辅助资料6名称][用户名]
    public static final String m_VCANSAPP_BAKMODULE3_XIAZAI_7FZ2 = "VPBKMD3FZ7XZXX2";      //C     [备用类型][备用数据1][备用数据2][备用辅助资料1编号][备用辅助资料1名称][备用辅助资料2编号][备用辅助资料2名称][备用辅助资料3编号][备用辅助资料3名称][备用辅助资料4编号][备用辅助资料4名称][物料编号,物料描述,存货描述,存货标志,匹数,数量, 信息一, 信息二, 信息三, 信息四, 信息五][备用扣除数量1][备用扣除数量2][备用数据3][备用数据4][备用数据5][备用辅助资料5编号][备用辅助资料5名称][备用辅助资料6编号][备用辅助资料6名称][用户名]
    public static final String m_VCANSAPP_BAKMODULE3_XIAZAI_7FZRe0 = "VPBKMD3FZ7XZRE0";      //S     成功    下载记录格式["备用三辅助资料6",编码,名称]
    public static final String m_VCANSAPP_BAKMODULE3_XIAZAI_7FZRe1 = "VPBKMD3FZ7XZRE1";      //S     失败    [失败信息]
    public static final String m_VCANSAPP_BAKMODULE3_XIAZAI_7FZRe2 = "VPBKMD3FZ7XZRE2";      //S     成功    下载记录格式["备用三辅助资料6",编码,名称]

    //==跟单==备用模块三=物料信息下载
    public static final String m_VCANSAPP_BAKMODULE3_XIAZAI_WULIAO1 = "VPBKMD3WLXZXXX1";      //C     [备用类型][备用数据1][备用数据2][备用辅助资料1编号][备用辅助资料1名称][备用辅助资料2编号][备用辅助资料2名称][备用辅助资料3编号][备用辅助资料3名称][备用辅助资料4编号][备用辅助资料4名称][用户名]
    public static final String m_VCANSAPP_BAKMODULE3_XIAZAI_WULIAO2 = "VPBKMD3WLXZXXX2";      //C     [备用类型][备用数据1][备用数据2][备用辅助资料1编号][备用辅助资料1名称][备用辅助资料2编号][备用辅助资料2名称][备用辅助资料3编号][备用辅助资料3名称][备用辅助资料4编号][备用辅助资料4名称][用户名]
    public static final String m_VCANSAPP_BAKMODULE3_XIAZAI_WULIAORe0 = "VPBKMD3WLXZXRE0";      //S     成功    下载记录格式[物料编号,物料描述 ,存货描述,存货标志,在库匹数,在库数量,备用1,备用2,备用3,备用4,备用5]
    public static final String m_VCANSAPP_BAKMODULE3_XIAZAI_WULIAORe1 = "VPBKMD3WLXZXRE1";      //S     失败    [失败信息]
    public static final String m_VCANSAPP_BAKMODULE3_XIAZAI_WULIAORe2 = "VPBKMD3WLXZXRE2";      //S     成功   下载记录格式[物料编号,物料描述 ,存货描述,存货标志,在库匹数,在库数量,备用1,备用2,备用3,备用4,备用5]

    //==跟单==备用模块三==表上传
    public static final String m_VCANSAPP_BAKMODULE3_UPLOADBIAO0 = "VPBKMD3UPBIAOX0";      //C     开始命令
    public static final String m_VCANSAPP_BAKMODULE3_UPLOADBIAO1 = "VPBKMD3UPBIAOX1";      //C     上传记录格式[内部ID,备用类型,备用数据1,备用数据2,备用辅助资料1编号,备用辅助资料1名称,备用辅助资料2编号,备用辅助资料2名称,备用辅助资料3编号,备用辅助资料3名称,备用辅助资料4编号,备用辅助资料4名称,[物料编号,物料描述 ,存货描述,存货标志,在库匹数,在库数量,备用1,备用2,备用3,备用4,备用5],备用扣数量1,备用扣数量2,备用数据3,备用数据4,备用数据5,备用辅助资料5编号,备用辅助资料5名称,备用辅助资料6编号,备用辅助资料6名称,备用辅助资料7编号,备用辅助资料7名称,备用数据6,备用数据7,备用辅助资料8编号,备用辅助资料8名称,备用辅助资料9编号,备用辅助资料9名称,数量1,数量2,用户名,图片]
    public static final String m_VCANSAPP_BAKMODULE3_UPLOADBIAO2 = "VPBKMD3UPBIAOX2";      //C     上传记录格式[内部ID,备用类型,备用数据1,备用数据2,备用辅助资料1编号,备用辅助资料1名称,备用辅助资料2编号,备用辅助资料2名称,备用辅助资料3编号,备用辅助资料3名称,备用辅助资料4编号,备用辅助资料4名称,[物料编号,物料描述 ,存货描述,存货标志,在库匹数,在库数量,备用1,备用2,备用3,备用4,备用5],备用扣数量1,备用扣数量2,备用数据3,备用数据4,备用数据5,备用辅助资料5编号,备用辅助资料5名称,备用辅助资料6编号,备用辅助资料6名称,备用辅助资料7编号,备用辅助资料7名称,备用数据6,备用数据7,备用辅助资料8编号,备用辅助资料8名称,备用辅助资料9编号,备用辅助资料9名称,数量1,数量2,用户名,图片]
    public static final String m_VCANSAPP_BAKMODULE3_UPLOADBIAO3 = "VPBKMD3UPBIAOX3";      //C     请求错误信息继续
    public static final String m_VCANSAPP_BAKMODULE3_UPLOADBIAORe0 = "VPBKMD3UPBIARE0";      //S     成功
    public static final String m_VCANSAPP_BAKMODULE3_UPLOADBIAORe1 = "VPBKMD3UPBIARE1";      //S     失败
    public static final String m_VCANSAPP_BAKMODULE3_UPLOADBIAORe3 = "VPBKMD3UPBIARE3";      //S     错误信息 + 错误记录格式[采集器内部ID]
    public static final String m_VCANSAPP_BAKMODULE3_UPLOADBIAORe5 = "VPBKMD3UPBIARE5";      //S     错误记录格式[采集器内部ID]

    /************************备用模块四*************************************************************************/
    //==跟单==备用模块四=辅助1下载
    public static final String m_VCANSAPP_BAKMODULE4_XIAZAI_1FZ1 = "VPBKMD4FZ1XZXX1";      //C     [备用类型][备用数据1][备用数据2][用户名]
    public static final String m_VCANSAPP_BAKMODULE4_XIAZAI_1FZ2 = "VPBKMD4FZ1XZXX2";      //C     [备用类型][备用数据1][备用数据2][用户名]
    public static final String m_VCANSAPP_BAKMODULE4_XIAZAI_1FZRe0 = "VPBKMD4FZ1XZRE0";      //S     成功    下载记录格式["备用四辅助资料1",编码,名称]
    public static final String m_VCANSAPP_BAKMODULE4_XIAZAI_1FZRe1 = "VPBKMD4FZ1XZRE1";      //S     失败    [失败信息]
    public static final String m_VCANSAPP_BAKMODULE4_XIAZAI_1FZRe2 = "VPBKMD4FZ1XZRE2";      //S     成功    下载记录格式["备用四辅助资料1",编码,名称]

    //==跟单==备用模块四=辅助2下载
    public static final String m_VCANSAPP_BAKMODULE4_XIAZAI_2FZ1 = "VPBKMD4FZ2XZXX1";      //C     [备用类型][备用数据1][备用数据2][备用辅助资料1编号][备用辅助资料1名称][用户名]
    public static final String m_VCANSAPP_BAKMODULE4_XIAZAI_2FZ2 = "VPBKMD4FZ2XZXX2";      //C     [备用类型][备用数据1][备用数据2][备用辅助资料1编号][备用辅助资料1名称][用户名]
    public static final String m_VCANSAPP_BAKMODULE4_XIAZAI_2FZRe0 = "VPBKMD4FZ2XZRE0";      //S     成功    下载记录格式["备用四辅助资料2",编码,名称]
    public static final String m_VCANSAPP_BAKMODULE4_XIAZAI_2FZRe1 = "VPBKMD4FZ2XZRE1";      //S     失败    [失败信息]
    public static final String m_VCANSAPP_BAKMODULE4_XIAZAI_2FZRe2 = "VPBKMD4FZ2XZRE2";      //S     成功    下载记录格式["备用四辅助资料2",编码,名称]


    //==跟单==备用模块四=辅助3下载
    public static final String m_VCANSAPP_BAKMODULE4_XIAZAI_3FZ1 = "VPBKMD4FZ3XZXX1";      //C     [备用类型][备用数据1][备用数据2][备用辅助资料1编号][备用辅助资料1名称][备用辅助资料2编号][备用辅助资料2名称][用户名]
    public static final String m_VCANSAPP_BAKMODULE4_XIAZAI_3FZ2 = "VPBKMD4FZ3XZXX2";      //C     [备用类型][备用数据1][备用数据2][备用辅助资料1编号][备用辅助资料1名称][备用辅助资料2编号][备用辅助资料2名称][用户名]
    public static final String m_VCANSAPP_BAKMODULE4_XIAZAI_3FZRe0 = "VPBKMD4FZ3XZRE0";      //S     成功    下载记录格式["备用四辅助资料3",编码,名称]
    public static final String m_VCANSAPP_BAKMODULE4_XIAZAI_3FZRe1 = "VPBKMD4FZ3XZRE1";      //S     失败    [失败信息]
    public static final String m_VCANSAPP_BAKMODULE4_XIAZAI_3FZRe2 = "VPBKMD4FZ3XZRE2";      //S     成功    下载记录格式["备用四辅助资料3",编码,名称]

    //==跟单==备用模块四=辅助4下载
    public static final String m_VCANSAPP_BAKMODULE4_XIAZAI_4FZ1 = "VPBKMD4FZ4XZXX1";      //C     [备用类型][备用数据1][备用数据2][备用辅助资料1编号][备用辅助资料1名称][备用辅助资料2编号][备用辅助资料2名称][备用辅助资料3编号][备用辅助资料3名称][用户名]
    public static final String m_VCANSAPP_BAKMODULE4_XIAZAI_4FZ2 = "VPBKMD4FZ4XZXX2";      //C     [备用类型][备用数据1][备用数据2][备用辅助资料1编号][备用辅助资料1名称][备用辅助资料2编号][备用辅助资料2名称][备用辅助资料3编号][备用辅助资料3名称][用户名]
    public static final String m_VCANSAPP_BAKMODULE4_XIAZAI_4FZRe0 = "VPBKMD4FZ4XZRE0";      //S     成功    下载记录格式["备用四辅助资料4",编码,名称]
    public static final String m_VCANSAPP_BAKMODULE4_XIAZAI_4FZRe1 = "VPBKMD4FZ4XZRE1";      //S     失败    [失败信息]
    public static final String m_VCANSAPP_BAKMODULE4_XIAZAI_4FZRe2 = "VPBKMD4FZ4XZRE2";      //S     成功    下载记录格式["备用四辅助资料4",编码,名称]

    //==跟单==备用模块四=辅助5下载
    public static final String m_VCANSAPP_BAKMODULE4_XIAZAI_5FZ1 = "VPBKMD4FZ5XZXX1";      //C     [备用类型][备用数据1][备用数据2][备用辅助资料1编号][备用辅助资料1名称][备用辅助资料2编号][备用辅助资料2名称][备用辅助资料3编号][备用辅助资料3名称][备用辅助资料4编号][备用辅助资料4名称][物料编号,物料描述,存货描述,存货标志,匹数,数量, 信息一, 信息二, 信息三, 信息四, 信息五][备用扣除数量1][备用扣除数量2][备用数据3][备用数据4][备用数据5][用户名]
    public static final String m_VCANSAPP_BAKMODULE4_XIAZAI_5FZ2 = "VPBKMD4FZ5XZXX2";      //C     [备用类型][备用数据1][备用数据2][备用辅助资料1编号][备用辅助资料1名称][备用辅助资料2编号][备用辅助资料2名称][备用辅助资料3编号][备用辅助资料3名称][备用辅助资料4编号][备用辅助资料4名称][物料编号,物料描述,存货描述,存货标志,匹数,数量, 信息一, 信息二, 信息三, 信息四, 信息五][备用扣除数量1][备用扣除数量2][备用数据3][备用数据4][备用数据5][用户名]
    public static final String m_VCANSAPP_BAKMODULE4_XIAZAI_5FZRe0 = "VPBKMD4FZ5XZRE0";      //S     成功    下载记录格式["备用四辅助资料5",编码,名称]
    public static final String m_VCANSAPP_BAKMODULE4_XIAZAI_5FZRe1 = "VPBKMD4FZ5XZRE1";      //S     失败    [失败信息]
    public static final String m_VCANSAPP_BAKMODULE4_XIAZAI_5FZRe2 = "VPBKMD4FZ5XZRE2";      //S     成功    下载记录格式["备用四辅助资料5",编码,名称]

    //==跟单==备用模块四=辅助6下载
    public static final String m_VCANSAPP_BAKMODULE4_XIAZAI_6FZ1 = "VPBKMD4FZ6XZXX1";      //C     [备用类型][备用数据1][备用数据2][备用辅助资料1编号][备用辅助资料1名称][备用辅助资料2编号][备用辅助资料2名称][备用辅助资料3编号][备用辅助资料3名称][备用辅助资料4编号][备用辅助资料4名称][物料编号,物料描述,存货描述,存货标志,匹数,数量, 信息一, 信息二, 信息三, 信息四, 信息五][备用扣除数量1][备用扣除数量2][备用数据3][备用数据4][备用数据5][备用辅助资料5编号][备用辅助资料5名称][用户名]
    public static final String m_VCANSAPP_BAKMODULE4_XIAZAI_6FZ2 = "VPBKMD4FZ6XZXX2";      //C     [备用类型][备用数据1][备用数据2][备用辅助资料1编号][备用辅助资料1名称][备用辅助资料2编号][备用辅助资料2名称][备用辅助资料3编号][备用辅助资料3名称][备用辅助资料4编号][备用辅助资料4名称][物料编号,物料描述,存货描述,存货标志,匹数,数量, 信息一, 信息二, 信息三, 信息四, 信息五][备用扣除数量1][备用扣除数量2][备用数据3][备用数据4][备用数据5][备用辅助资料5编号][备用辅助资料5名称][用户名]
    public static final String m_VCANSAPP_BAKMODULE4_XIAZAI_6FZRe0 = "VPBKMD4FZ6XZRE0";      //S     成功    下载记录格式["备用四辅助资料6",编码,名称]
    public static final String m_VCANSAPP_BAKMODULE4_XIAZAI_6FZRe1 = "VPBKMD4FZ6XZRE1";      //S     失败    [失败信息]
    public static final String m_VCANSAPP_BAKMODULE4_XIAZAI_6FZRe2 = "VPBKMD4FZ6XZRE2";      //S     成功    下载记录格式["备用四辅助资料6",编码,名称]

    //==跟单==备用模块四=辅助7下载
    public static final String m_VCANSAPP_BAKMODULE4_XIAZAI_7FZ1 = "VPBKMD4FZ7XZXX1";      //C     [备用类型][备用数据1][备用数据2][备用辅助资料1编号][备用辅助资料1名称][备用辅助资料2编号][备用辅助资料2名称][备用辅助资料3编号][备用辅助资料3名称][备用辅助资料4编号][备用辅助资料4名称][物料编号,物料描述,存货描述,存货标志,匹数,数量, 信息一, 信息二, 信息三, 信息四, 信息五][备用扣除数量1][备用扣除数量2][备用数据3][备用数据4][备用数据5][备用辅助资料5编号][备用辅助资料5名称][备用辅助资料6编号][备用辅助资料6名称][用户名]
    public static final String m_VCANSAPP_BAKMODULE4_XIAZAI_7FZ2 = "VPBKMD4FZ7XZXX2";      //C     [备用类型][备用数据1][备用数据2][备用辅助资料1编号][备用辅助资料1名称][备用辅助资料2编号][备用辅助资料2名称][备用辅助资料3编号][备用辅助资料3名称][备用辅助资料4编号][备用辅助资料4名称][物料编号,物料描述,存货描述,存货标志,匹数,数量, 信息一, 信息二, 信息三, 信息四, 信息五][备用扣除数量1][备用扣除数量2][备用数据3][备用数据4][备用数据5][备用辅助资料5编号][备用辅助资料5名称][备用辅助资料6编号][备用辅助资料6名称][用户名]
    public static final String m_VCANSAPP_BAKMODULE4_XIAZAI_7FZRe0 = "VPBKMD4FZ7XZRE0";      //S     成功    下载记录格式["备用四辅助资料6",编码,名称]
    public static final String m_VCANSAPP_BAKMODULE4_XIAZAI_7FZRe1 = "VPBKMD4FZ7XZRE1";      //S     失败    [失败信息]
    public static final String m_VCANSAPP_BAKMODULE4_XIAZAI_7FZRe2 = "VPBKMD4FZ7XZRE2";      //S     成功    下载记录格式["备用四辅助资料6",编码,名称]

    //==跟单==备用模块四=物料信息下载
    public static final String m_VCANSAPP_BAKMODULE4_XIAZAI_WULIAO1 = "VPBKMD4WLXZXXX1";      //C     [备用类型][备用数据1][备用数据2][备用辅助资料1编号][备用辅助资料1名称][备用辅助资料2编号][备用辅助资料2名称][备用辅助资料3编号][备用辅助资料3名称][备用辅助资料4编号][备用辅助资料4名称][用户名]
    public static final String m_VCANSAPP_BAKMODULE4_XIAZAI_WULIAO2 = "VPBKMD4WLXZXXX2";      //C     [备用类型][备用数据1][备用数据2][备用辅助资料1编号][备用辅助资料1名称][备用辅助资料2编号][备用辅助资料2名称][备用辅助资料3编号][备用辅助资料3名称][备用辅助资料4编号][备用辅助资料4名称][用户名]
    public static final String m_VCANSAPP_BAKMODULE4_XIAZAI_WULIAORe0 = "VPBKMD4WLXZXRE0";      //S     成功    下载记录格式[物料编号,物料描述 ,存货描述,存货标志,在库匹数,在库数量,备用1,备用2,备用3,备用4,备用5]
    public static final String m_VCANSAPP_BAKMODULE4_XIAZAI_WULIAORe1 = "VPBKMD4WLXZXRE1";      //S     失败    [失败信息]
    public static final String m_VCANSAPP_BAKMODULE4_XIAZAI_WULIAORe2 = "VPBKMD4WLXZXRE2";      //S     成功   下载记录格式[物料编号,物料描述 ,存货描述,存货标志,在库匹数,在库数量,备用1,备用2,备用3,备用4,备用5]

    //==跟单==备用模块四==表上传
    public static final String m_VCANSAPP_BAKMODULE4_UPLOADBIAO0 = "VPBKMD4UPBIAOX0";      //C     开始命令
    public static final String m_VCANSAPP_BAKMODULE4_UPLOADBIAO1 = "VPBKMD4UPBIAOX1";      //C     上传记录格式[内部ID,备用类型,备用数据1,备用数据2,备用辅助资料1编号,备用辅助资料1名称,备用辅助资料2编号,备用辅助资料2名称,备用辅助资料3编号,备用辅助资料3名称,备用辅助资料4编号,备用辅助资料4名称,[物料编号,物料描述 ,存货描述,存货标志,在库匹数,在库数量,备用1,备用2,备用3,备用4,备用5],备用扣数量1,备用扣数量2,备用数据3,备用数据4,备用数据5,备用辅助资料5编号,备用辅助资料5名称,备用辅助资料6编号,备用辅助资料6名称,备用辅助资料7编号,备用辅助资料7名称,备用数据6,备用数据7,备用辅助资料8编号,备用辅助资料8名称,备用辅助资料9编号,备用辅助资料9名称,数量1,数量2,用户名,图片]
    public static final String m_VCANSAPP_BAKMODULE4_UPLOADBIAO2 = "VPBKMD4UPBIAOX2";      //C     上传记录格式[内部ID,备用类型,备用数据1,备用数据2,备用辅助资料1编号,备用辅助资料1名称,备用辅助资料2编号,备用辅助资料2名称,备用辅助资料3编号,备用辅助资料3名称,备用辅助资料4编号,备用辅助资料4名称,[物料编号,物料描述 ,存货描述,存货标志,在库匹数,在库数量,备用1,备用2,备用3,备用4,备用5],备用扣数量1,备用扣数量2,备用数据3,备用数据4,备用数据5,备用辅助资料5编号,备用辅助资料5名称,备用辅助资料6编号,备用辅助资料6名称,备用辅助资料7编号,备用辅助资料7名称,备用数据6,备用数据7,备用辅助资料8编号,备用辅助资料8名称,备用辅助资料9编号,备用辅助资料9名称,数量1,数量2,用户名,图片]
    public static final String m_VCANSAPP_BAKMODULE4_UPLOADBIAO3 = "VPBKMD4UPBIAOX3";      //C     请求错误信息继续
    public static final String m_VCANSAPP_BAKMODULE4_UPLOADBIAORe0 = "VPBKMD4UPBIARE0";      //S     成功
    public static final String m_VCANSAPP_BAKMODULE4_UPLOADBIAORe1 = "VPBKMD4UPBIARE1";      //S     失败
    public static final String m_VCANSAPP_BAKMODULE4_UPLOADBIAORe3 = "VPBKMD4UPBIARE3";      //S     错误信息 + 错误记录格式[采集器内部ID]
    public static final String m_VCANSAPP_BAKMODULE4_UPLOADBIAORe5 = "VPBKMD4UPBIARE5";      //S     错误记录格式[采集器内部ID]

    /************************备用模块五*************************************************************************/
    //==跟单==备用模块五=辅助1下载
    public static final String m_VCANSAPP_BAKMODULE5_XIAZAI_1FZ1 = "VPBKMD5FZ1XZXX1";      //C     [备用类型][备用数据1][备用数据2][用户名]
    public static final String m_VCANSAPP_BAKMODULE5_XIAZAI_1FZ2 = "VPBKMD5FZ1XZXX2";      //C     [备用类型][备用数据1][备用数据2][用户名]
    public static final String m_VCANSAPP_BAKMODULE5_XIAZAI_1FZRe0 = "VPBKMD5FZ1XZRE0";      //S     成功    下载记录格式["备用四辅助资料1",编码,名称]
    public static final String m_VCANSAPP_BAKMODULE5_XIAZAI_1FZRe1 = "VPBKMD5FZ1XZRE1";      //S     失败    [失败信息]
    public static final String m_VCANSAPP_BAKMODULE5_XIAZAI_1FZRe2 = "VPBKMD5FZ1XZRE2";      //S     成功    下载记录格式["备用四辅助资料1",编码,名称]

    //==跟单==备用模块五=辅助2下载
    public static final String m_VCANSAPP_BAKMODULE5_XIAZAI_2FZ1 = "VPBKMD5FZ2XZXX1";      //C     [备用类型][备用数据1][备用数据2][备用辅助资料1编号][备用辅助资料1名称][用户名]
    public static final String m_VCANSAPP_BAKMODULE5_XIAZAI_2FZ2 = "VPBKMD5FZ2XZXX2";      //C     [备用类型][备用数据1][备用数据2][备用辅助资料1编号][备用辅助资料1名称][用户名]
    public static final String m_VCANSAPP_BAKMODULE5_XIAZAI_2FZRe0 = "VPBKMD5FZ2XZRE0";      //S     成功    下载记录格式["备用四辅助资料2",编码,名称]
    public static final String m_VCANSAPP_BAKMODULE5_XIAZAI_2FZRe1 = "VPBKMD5FZ2XZRE1";      //S     失败    [失败信息]
    public static final String m_VCANSAPP_BAKMODULE5_XIAZAI_2FZRe2 = "VPBKMD5FZ2XZRE2";      //S     成功    下载记录格式["备用四辅助资料2",编码,名称]


    //==跟单==备用模块五=辅助3下载
    public static final String m_VCANSAPP_BAKMODULE5_XIAZAI_3FZ1 = "VPBKMD5FZ3XZXX1";      //C     [备用类型][备用数据1][备用数据2][备用辅助资料1编号][备用辅助资料1名称][备用辅助资料2编号][备用辅助资料2名称][用户名]
    public static final String m_VCANSAPP_BAKMODULE5_XIAZAI_3FZ2 = "VPBKMD5FZ3XZXX2";      //C     [备用类型][备用数据1][备用数据2][备用辅助资料1编号][备用辅助资料1名称][备用辅助资料2编号][备用辅助资料2名称][用户名]
    public static final String m_VCANSAPP_BAKMODULE5_XIAZAI_3FZRe0 = "VPBKMD5FZ3XZRE0";      //S     成功    下载记录格式["备用四辅助资料3",编码,名称]
    public static final String m_VCANSAPP_BAKMODULE5_XIAZAI_3FZRe1 = "VPBKMD5FZ3XZRE1";      //S     失败    [失败信息]
    public static final String m_VCANSAPP_BAKMODULE5_XIAZAI_3FZRe2 = "VPBKMD5FZ3XZRE2";      //S     成功    下载记录格式["备用四辅助资料3",编码,名称]

    //==跟单==备用模块五=辅助4下载
    public static final String m_VCANSAPP_BAKMODULE5_XIAZAI_4FZ1 = "VPBKMD5FZ4XZXX1";      //C     [备用类型][备用数据1][备用数据2][备用辅助资料1编号][备用辅助资料1名称][备用辅助资料2编号][备用辅助资料2名称][备用辅助资料3编号][备用辅助资料3名称][用户名]
    public static final String m_VCANSAPP_BAKMODULE5_XIAZAI_4FZ2 = "VPBKMD5FZ4XZXX2";      //C     [备用类型][备用数据1][备用数据2][备用辅助资料1编号][备用辅助资料1名称][备用辅助资料2编号][备用辅助资料2名称][备用辅助资料3编号][备用辅助资料3名称][用户名]
    public static final String m_VCANSAPP_BAKMODULE5_XIAZAI_4FZRe0 = "VPBKMD5FZ4XZRE0";      //S     成功    下载记录格式["备用四辅助资料4",编码,名称]
    public static final String m_VCANSAPP_BAKMODULE5_XIAZAI_4FZRe1 = "VPBKMD5FZ4XZRE1";      //S     失败    [失败信息]
    public static final String m_VCANSAPP_BAKMODULE5_XIAZAI_4FZRe2 = "VPBKMD5FZ4XZRE2";      //S     成功    下载记录格式["备用四辅助资料4",编码,名称]

    //==跟单==备用模块五=辅助5下载
    public static final String m_VCANSAPP_BAKMODULE5_XIAZAI_5FZ1 = "VPBKMD5FZ5XZXX1";      //C     [备用类型][备用数据1][备用数据2][备用辅助资料1编号][备用辅助资料1名称][备用辅助资料2编号][备用辅助资料2名称][备用辅助资料3编号][备用辅助资料3名称][备用辅助资料4编号][备用辅助资料4名称][物料编号,物料描述,存货描述,存货标志,匹数,数量, 信息一, 信息二, 信息三, 信息四, 信息五][备用扣除数量1][备用扣除数量2][备用数据3][备用数据4][备用数据5][用户名]
    public static final String m_VCANSAPP_BAKMODULE5_XIAZAI_5FZ2 = "VPBKMD5FZ5XZXX2";      //C     [备用类型][备用数据1][备用数据2][备用辅助资料1编号][备用辅助资料1名称][备用辅助资料2编号][备用辅助资料2名称][备用辅助资料3编号][备用辅助资料3名称][备用辅助资料4编号][备用辅助资料4名称][物料编号,物料描述,存货描述,存货标志,匹数,数量, 信息一, 信息二, 信息三, 信息四, 信息五][备用扣除数量1][备用扣除数量2][备用数据3][备用数据4][备用数据5][用户名]
    public static final String m_VCANSAPP_BAKMODULE5_XIAZAI_5FZRe0 = "VPBKMD5FZ5XZRE0";      //S     成功    下载记录格式["备用四辅助资料5",编码,名称]
    public static final String m_VCANSAPP_BAKMODULE5_XIAZAI_5FZRe1 = "VPBKMD5FZ5XZRE1";      //S     失败    [失败信息]
    public static final String m_VCANSAPP_BAKMODULE5_XIAZAI_5FZRe2 = "VPBKMD5FZ5XZRE2";      //S     成功    下载记录格式["备用四辅助资料5",编码,名称]

    //==跟单==备用模块五=辅助6下载
    public static final String m_VCANSAPP_BAKMODULE5_XIAZAI_6FZ1 = "VPBKMD5FZ6XZXX1";      //C     [备用类型][备用数据1][备用数据2][备用辅助资料1编号][备用辅助资料1名称][备用辅助资料2编号][备用辅助资料2名称][备用辅助资料3编号][备用辅助资料3名称][备用辅助资料4编号][备用辅助资料4名称][物料编号,物料描述,存货描述,存货标志,匹数,数量, 信息一, 信息二, 信息三, 信息四, 信息五][备用扣除数量1][备用扣除数量2][备用数据3][备用数据4][备用数据5][备用辅助资料5编号][备用辅助资料5名称][用户名]
    public static final String m_VCANSAPP_BAKMODULE5_XIAZAI_6FZ2 = "VPBKMD5FZ6XZXX2";      //C     [备用类型][备用数据1][备用数据2][备用辅助资料1编号][备用辅助资料1名称][备用辅助资料2编号][备用辅助资料2名称][备用辅助资料3编号][备用辅助资料3名称][备用辅助资料4编号][备用辅助资料4名称][物料编号,物料描述,存货描述,存货标志,匹数,数量, 信息一, 信息二, 信息三, 信息四, 信息五][备用扣除数量1][备用扣除数量2][备用数据3][备用数据4][备用数据5][备用辅助资料5编号][备用辅助资料5名称][用户名]
    public static final String m_VCANSAPP_BAKMODULE5_XIAZAI_6FZRe0 = "VPBKMD5FZ6XZRE0";      //S     成功    下载记录格式["备用四辅助资料6",编码,名称]
    public static final String m_VCANSAPP_BAKMODULE5_XIAZAI_6FZRe1 = "VPBKMD5FZ6XZRE1";      //S     失败    [失败信息]
    public static final String m_VCANSAPP_BAKMODULE5_XIAZAI_6FZRe2 = "VPBKMD5FZ6XZRE2";      //S     成功    下载记录格式["备用四辅助资料6",编码,名称]

    //==跟单==备用模块五=辅助7下载
    public static final String m_VCANSAPP_BAKMODULE5_XIAZAI_7FZ1 = "VPBKMD5FZ7XZXX1";      //C     [备用类型][备用数据1][备用数据2][备用辅助资料1编号][备用辅助资料1名称][备用辅助资料2编号][备用辅助资料2名称][备用辅助资料3编号][备用辅助资料3名称][备用辅助资料4编号][备用辅助资料4名称][物料编号,物料描述,存货描述,存货标志,匹数,数量, 信息一, 信息二, 信息三, 信息四, 信息五][备用扣除数量1][备用扣除数量2][备用数据3][备用数据4][备用数据5][备用辅助资料5编号][备用辅助资料5名称][备用辅助资料6编号][备用辅助资料6名称][用户名]
    public static final String m_VCANSAPP_BAKMODULE5_XIAZAI_7FZ2 = "VPBKMD5FZ7XZXX2";      //C     [备用类型][备用数据1][备用数据2][备用辅助资料1编号][备用辅助资料1名称][备用辅助资料2编号][备用辅助资料2名称][备用辅助资料3编号][备用辅助资料3名称][备用辅助资料4编号][备用辅助资料4名称][物料编号,物料描述,存货描述,存货标志,匹数,数量, 信息一, 信息二, 信息三, 信息四, 信息五][备用扣除数量1][备用扣除数量2][备用数据3][备用数据4][备用数据5][备用辅助资料5编号][备用辅助资料5名称][备用辅助资料6编号][备用辅助资料6名称][用户名]
    public static final String m_VCANSAPP_BAKMODULE5_XIAZAI_7FZRe0 = "VPBKMD5FZ7XZRE0";      //S     成功    下载记录格式["备用四辅助资料6",编码,名称]
    public static final String m_VCANSAPP_BAKMODULE5_XIAZAI_7FZRe1 = "VPBKMD5FZ7XZRE1";      //S     失败    [失败信息]
    public static final String m_VCANSAPP_BAKMODULE5_XIAZAI_7FZRe2 = "VPBKMD5FZ7XZRE2";      //S     成功    下载记录格式["备用四辅助资料6",编码,名称]

    //==跟单==备用模块五=物料信息下载
    public static final String m_VCANSAPP_BAKMODULE5_XIAZAI_WULIAO1 = "VPBKMD5WLXZXXX1";      //C     [备用类型][备用数据1][备用数据2][备用辅助资料1编号][备用辅助资料1名称][备用辅助资料2编号][备用辅助资料2名称][备用辅助资料3编号][备用辅助资料3名称][备用辅助资料4编号][备用辅助资料4名称][用户名]
    public static final String m_VCANSAPP_BAKMODULE5_XIAZAI_WULIAO2 = "VPBKMD5WLXZXXX2";      //C     [备用类型][备用数据1][备用数据2][备用辅助资料1编号][备用辅助资料1名称][备用辅助资料2编号][备用辅助资料2名称][备用辅助资料3编号][备用辅助资料3名称][备用辅助资料4编号][备用辅助资料4名称][用户名]
    public static final String m_VCANSAPP_BAKMODULE5_XIAZAI_WULIAORe0 = "VPBKMD5WLXZXRE0";      //S     成功    下载记录格式[物料编号,物料描述 ,存货描述,存货标志,在库匹数,在库数量,备用1,备用2,备用3,备用4,备用5]
    public static final String m_VCANSAPP_BAKMODULE5_XIAZAI_WULIAORe1 = "VPBKMD5WLXZXRE1";      //S     失败    [失败信息]
    public static final String m_VCANSAPP_BAKMODULE5_XIAZAI_WULIAORe2 = "VPBKMD5WLXZXRE2";      //S     成功   下载记录格式[物料编号,物料描述 ,存货描述,存货标志,在库匹数,在库数量,备用1,备用2,备用3,备用4,备用5]

    //==跟单==备用模块五==表上传
    public static final String m_VCANSAPP_BAKMODULE5_UPLOADBIAO0 = "VPBKMD5UPBIAOX0";      //C     开始命令
    public static final String m_VCANSAPP_BAKMODULE5_UPLOADBIAO1 = "VPBKMD5UPBIAOX1";      //C     上传记录格式[内部ID,备用类型,备用数据1,备用数据2,备用辅助资料1编号,备用辅助资料1名称,备用辅助资料2编号,备用辅助资料2名称,备用辅助资料3编号,备用辅助资料3名称,备用辅助资料4编号,备用辅助资料4名称,[物料编号,物料描述 ,存货描述,存货标志,在库匹数,在库数量,备用1,备用2,备用3,备用4,备用5],备用扣数量1,备用扣数量2,备用数据3,备用数据4,备用数据5,备用辅助资料5编号,备用辅助资料5名称,备用辅助资料6编号,备用辅助资料6名称,备用辅助资料7编号,备用辅助资料7名称,备用数据6,备用数据7,备用辅助资料8编号,备用辅助资料8名称,备用辅助资料9编号,备用辅助资料9名称,数量1,数量2,用户名,图片]
    public static final String m_VCANSAPP_BAKMODULE5_UPLOADBIAO2 = "VPBKMD5UPBIAOX2";      //C     上传记录格式[内部ID,备用类型,备用数据1,备用数据2,备用辅助资料1编号,备用辅助资料1名称,备用辅助资料2编号,备用辅助资料2名称,备用辅助资料3编号,备用辅助资料3名称,备用辅助资料4编号,备用辅助资料4名称,[物料编号,物料描述 ,存货描述,存货标志,在库匹数,在库数量,备用1,备用2,备用3,备用4,备用5],备用扣数量1,备用扣数量2,备用数据3,备用数据4,备用数据5,备用辅助资料5编号,备用辅助资料5名称,备用辅助资料6编号,备用辅助资料6名称,备用辅助资料7编号,备用辅助资料7名称,备用数据6,备用数据7,备用辅助资料8编号,备用辅助资料8名称,备用辅助资料9编号,备用辅助资料9名称,数量1,数量2,用户名,图片]
    public static final String m_VCANSAPP_BAKMODULE5_UPLOADBIAO3 = "VPBKMD5UPBIAOX3";      //C     请求错误信息继续
    public static final String m_VCANSAPP_BAKMODULE5_UPLOADBIAORe0 = "VPBKMD5UPBIARE0";      //S     成功
    public static final String m_VCANSAPP_BAKMODULE5_UPLOADBIAORe1 = "VPBKMD5UPBIARE1";      //S     失败
    public static final String m_VCANSAPP_BAKMODULE5_UPLOADBIAORe3 = "VPBKMD5UPBIARE3";      //S     错误信息 + 错误记录格式[采集器内部ID]
    public static final String m_VCANSAPP_BAKMODULE5_UPLOADBIAORe5 = "VPBKMD5UPBIARE5";      //S     错误记录格式[采集器内部ID]

    /************************备用模块六*************************************************************************/
    //==跟单==备用模块六=辅助1下载
    public static final String m_VCANSAPP_BAKMODULE6_XIAZAI_1FZ1 = "VPBKMD6FZ1XZXX1";      //C     [备用类型][备用数据1][备用数据2][用户名]
    public static final String m_VCANSAPP_BAKMODULE6_XIAZAI_1FZ2 = "VPBKMD6FZ1XZXX2";      //C     [备用类型][备用数据1][备用数据2][用户名]
    public static final String m_VCANSAPP_BAKMODULE6_XIAZAI_1FZRe0 = "VPBKMD6FZ1XZRE0";      //S     成功    下载记录格式["备用四辅助资料1",编码,名称]
    public static final String m_VCANSAPP_BAKMODULE6_XIAZAI_1FZRe1 = "VPBKMD6FZ1XZRE1";      //S     失败    [失败信息]
    public static final String m_VCANSAPP_BAKMODULE6_XIAZAI_1FZRe2 = "VPBKMD6FZ1XZRE2";      //S     成功    下载记录格式["备用四辅助资料1",编码,名称]

    //==跟单==备用模块六=辅助2下载
    public static final String m_VCANSAPP_BAKMODULE6_XIAZAI_2FZ1 = "VPBKMD6FZ2XZXX1";      //C     [备用类型][备用数据1][备用数据2][备用辅助资料1编号][备用辅助资料1名称][用户名]
    public static final String m_VCANSAPP_BAKMODULE6_XIAZAI_2FZ2 = "VPBKMD6FZ2XZXX2";      //C     [备用类型][备用数据1][备用数据2][备用辅助资料1编号][备用辅助资料1名称][用户名]
    public static final String m_VCANSAPP_BAKMODULE6_XIAZAI_2FZRe0 = "VPBKMD6FZ2XZRE0";      //S     成功    下载记录格式["备用四辅助资料2",编码,名称]
    public static final String m_VCANSAPP_BAKMODULE6_XIAZAI_2FZRe1 = "VPBKMD6FZ2XZRE1";      //S     失败    [失败信息]
    public static final String m_VCANSAPP_BAKMODULE6_XIAZAI_2FZRe2 = "VPBKMD6FZ2XZRE2";      //S     成功    下载记录格式["备用四辅助资料2",编码,名称]


    //==跟单==备用模块六=辅助3下载
    public static final String m_VCANSAPP_BAKMODULE6_XIAZAI_3FZ1 = "VPBKMD6FZ3XZXX1";      //C     [备用类型][备用数据1][备用数据2][备用辅助资料1编号][备用辅助资料1名称][备用辅助资料2编号][备用辅助资料2名称][用户名]
    public static final String m_VCANSAPP_BAKMODULE6_XIAZAI_3FZ2 = "VPBKMD6FZ3XZXX2";      //C     [备用类型][备用数据1][备用数据2][备用辅助资料1编号][备用辅助资料1名称][备用辅助资料2编号][备用辅助资料2名称][用户名]
    public static final String m_VCANSAPP_BAKMODULE6_XIAZAI_3FZRe0 = "VPBKMD6FZ3XZRE0";      //S     成功    下载记录格式["备用四辅助资料3",编码,名称]
    public static final String m_VCANSAPP_BAKMODULE6_XIAZAI_3FZRe1 = "VPBKMD6FZ3XZRE1";      //S     失败    [失败信息]
    public static final String m_VCANSAPP_BAKMODULE6_XIAZAI_3FZRe2 = "VPBKMD6FZ3XZRE2";      //S     成功    下载记录格式["备用四辅助资料3",编码,名称]

    //==跟单==备用模块六=辅助4下载
    public static final String m_VCANSAPP_BAKMODULE6_XIAZAI_4FZ1 = "VPBKMD6FZ4XZXX1";      //C     [备用类型][备用数据1][备用数据2][备用辅助资料1编号][备用辅助资料1名称][备用辅助资料2编号][备用辅助资料2名称][备用辅助资料3编号][备用辅助资料3名称][用户名]
    public static final String m_VCANSAPP_BAKMODULE6_XIAZAI_4FZ2 = "VPBKMD6FZ4XZXX2";      //C     [备用类型][备用数据1][备用数据2][备用辅助资料1编号][备用辅助资料1名称][备用辅助资料2编号][备用辅助资料2名称][备用辅助资料3编号][备用辅助资料3名称][用户名]
    public static final String m_VCANSAPP_BAKMODULE6_XIAZAI_4FZRe0 = "VPBKMD6FZ4XZRE0";      //S     成功    下载记录格式["备用四辅助资料4",编码,名称]
    public static final String m_VCANSAPP_BAKMODULE6_XIAZAI_4FZRe1 = "VPBKMD6FZ4XZRE1";      //S     失败    [失败信息]
    public static final String m_VCANSAPP_BAKMODULE6_XIAZAI_4FZRe2 = "VPBKMD6FZ4XZRE2";      //S     成功    下载记录格式["备用四辅助资料4",编码,名称]

    //==跟单==备用模块六=辅助5下载
    public static final String m_VCANSAPP_BAKMODULE6_XIAZAI_5FZ1 = "VPBKMD6FZ5XZXX1";      //C     [备用类型][备用数据1][备用数据2][备用辅助资料1编号][备用辅助资料1名称][备用辅助资料2编号][备用辅助资料2名称][备用辅助资料3编号][备用辅助资料3名称][备用辅助资料4编号][备用辅助资料4名称][物料编号,物料描述,存货描述,存货标志,匹数,数量, 信息一, 信息二, 信息三, 信息四, 信息五][备用扣除数量1][备用扣除数量2][备用数据3][备用数据4][备用数据5][用户名]
    public static final String m_VCANSAPP_BAKMODULE6_XIAZAI_5FZ2 = "VPBKMD6FZ5XZXX2";      //C     [备用类型][备用数据1][备用数据2][备用辅助资料1编号][备用辅助资料1名称][备用辅助资料2编号][备用辅助资料2名称][备用辅助资料3编号][备用辅助资料3名称][备用辅助资料4编号][备用辅助资料4名称][物料编号,物料描述,存货描述,存货标志,匹数,数量, 信息一, 信息二, 信息三, 信息四, 信息五][备用扣除数量1][备用扣除数量2][备用数据3][备用数据4][备用数据5][用户名]
    public static final String m_VCANSAPP_BAKMODULE6_XIAZAI_5FZRe0 = "VPBKMD6FZ5XZRE0";      //S     成功    下载记录格式["备用四辅助资料5",编码,名称]
    public static final String m_VCANSAPP_BAKMODULE6_XIAZAI_5FZRe1 = "VPBKMD6FZ5XZRE1";      //S     失败    [失败信息]
    public static final String m_VCANSAPP_BAKMODULE6_XIAZAI_5FZRe2 = "VPBKMD6FZ5XZRE2";      //S     成功    下载记录格式["备用四辅助资料5",编码,名称]

    //==跟单==备用模块六=辅助6下载
    public static final String m_VCANSAPP_BAKMODULE6_XIAZAI_6FZ1 = "VPBKMD6FZ6XZXX1";      //C     [备用类型][备用数据1][备用数据2][备用辅助资料1编号][备用辅助资料1名称][备用辅助资料2编号][备用辅助资料2名称][备用辅助资料3编号][备用辅助资料3名称][备用辅助资料4编号][备用辅助资料4名称][物料编号,物料描述,存货描述,存货标志,匹数,数量, 信息一, 信息二, 信息三, 信息四, 信息五][备用扣除数量1][备用扣除数量2][备用数据3][备用数据4][备用数据5][备用辅助资料5编号][备用辅助资料5名称][用户名]
    public static final String m_VCANSAPP_BAKMODULE6_XIAZAI_6FZ2 = "VPBKMD6FZ6XZXX2";      //C     [备用类型][备用数据1][备用数据2][备用辅助资料1编号][备用辅助资料1名称][备用辅助资料2编号][备用辅助资料2名称][备用辅助资料3编号][备用辅助资料3名称][备用辅助资料4编号][备用辅助资料4名称][物料编号,物料描述,存货描述,存货标志,匹数,数量, 信息一, 信息二, 信息三, 信息四, 信息五][备用扣除数量1][备用扣除数量2][备用数据3][备用数据4][备用数据5][备用辅助资料5编号][备用辅助资料5名称][用户名]
    public static final String m_VCANSAPP_BAKMODULE6_XIAZAI_6FZRe0 = "VPBKMD6FZ6XZRE0";      //S     成功    下载记录格式["备用四辅助资料6",编码,名称]
    public static final String m_VCANSAPP_BAKMODULE6_XIAZAI_6FZRe1 = "VPBKMD6FZ6XZRE1";      //S     失败    [失败信息]
    public static final String m_VCANSAPP_BAKMODULE6_XIAZAI_6FZRe2 = "VPBKMD6FZ6XZRE2";      //S     成功    下载记录格式["备用四辅助资料6",编码,名称]

    //==跟单==备用模块六=辅助7下载
    public static final String m_VCANSAPP_BAKMODULE6_XIAZAI_7FZ1 = "VPBKMD6FZ7XZXX1";      //C     [备用类型][备用数据1][备用数据2][备用辅助资料1编号][备用辅助资料1名称][备用辅助资料2编号][备用辅助资料2名称][备用辅助资料3编号][备用辅助资料3名称][备用辅助资料4编号][备用辅助资料4名称][物料编号,物料描述,存货描述,存货标志,匹数,数量, 信息一, 信息二, 信息三, 信息四, 信息五][备用扣除数量1][备用扣除数量2][备用数据3][备用数据4][备用数据5][备用辅助资料5编号][备用辅助资料5名称][备用辅助资料6编号][备用辅助资料6名称][用户名]
    public static final String m_VCANSAPP_BAKMODULE6_XIAZAI_7FZ2 = "VPBKMD6FZ7XZXX2";      //C     [备用类型][备用数据1][备用数据2][备用辅助资料1编号][备用辅助资料1名称][备用辅助资料2编号][备用辅助资料2名称][备用辅助资料3编号][备用辅助资料3名称][备用辅助资料4编号][备用辅助资料4名称][物料编号,物料描述,存货描述,存货标志,匹数,数量, 信息一, 信息二, 信息三, 信息四, 信息五][备用扣除数量1][备用扣除数量2][备用数据3][备用数据4][备用数据5][备用辅助资料5编号][备用辅助资料5名称][备用辅助资料6编号][备用辅助资料6名称][用户名]
    public static final String m_VCANSAPP_BAKMODULE6_XIAZAI_7FZRe0 = "VPBKMD6FZ7XZRE0";      //S     成功    下载记录格式["备用四辅助资料6",编码,名称]
    public static final String m_VCANSAPP_BAKMODULE6_XIAZAI_7FZRe1 = "VPBKMD6FZ7XZRE1";      //S     失败    [失败信息]
    public static final String m_VCANSAPP_BAKMODULE6_XIAZAI_7FZRe2 = "VPBKMD6FZ7XZRE2";      //S     成功    下载记录格式["备用四辅助资料6",编码,名称]

    //==跟单==备用模块六=物料信息下载
    public static final String m_VCANSAPP_BAKMODULE6_XIAZAI_WULIAO1 = "VPBKMD6WLXZXXX1";      //C     [备用类型][备用数据1][备用数据2][备用辅助资料1编号][备用辅助资料1名称][备用辅助资料2编号][备用辅助资料2名称][备用辅助资料3编号][备用辅助资料3名称][备用辅助资料4编号][备用辅助资料4名称][用户名]
    public static final String m_VCANSAPP_BAKMODULE6_XIAZAI_WULIAO2 = "VPBKMD6WLXZXXX2";      //C     [备用类型][备用数据1][备用数据2][备用辅助资料1编号][备用辅助资料1名称][备用辅助资料2编号][备用辅助资料2名称][备用辅助资料3编号][备用辅助资料3名称][备用辅助资料4编号][备用辅助资料4名称][用户名]
    public static final String m_VCANSAPP_BAKMODULE6_XIAZAI_WULIAORe0 = "VPBKMD6WLXZXRE0";      //S     成功    下载记录格式[物料编号,物料描述 ,存货描述,存货标志,在库匹数,在库数量,备用1,备用2,备用3,备用4,备用5]
    public static final String m_VCANSAPP_BAKMODULE6_XIAZAI_WULIAORe1 = "VPBKMD6WLXZXRE1";      //S     失败    [失败信息]
    public static final String m_VCANSAPP_BAKMODULE6_XIAZAI_WULIAORe2 = "VPBKMD6WLXZXRE2";      //S     成功   下载记录格式[物料编号,物料描述 ,存货描述,存货标志,在库匹数,在库数量,备用1,备用2,备用3,备用4,备用5]

    //==跟单==备用模块六==表上传
    public static final String m_VCANSAPP_BAKMODULE6_UPLOADBIAO0 = "VPBKMD6UPBIAOX0";      //C     开始命令
    public static final String m_VCANSAPP_BAKMODULE6_UPLOADBIAO1 = "VPBKMD6UPBIAOX1";      //C     上传记录格式[内部ID,备用类型,备用数据1,备用数据2,备用辅助资料1编号,备用辅助资料1名称,备用辅助资料2编号,备用辅助资料2名称,备用辅助资料3编号,备用辅助资料3名称,备用辅助资料4编号,备用辅助资料4名称,[物料编号,物料描述 ,存货描述,存货标志,在库匹数,在库数量,备用1,备用2,备用3,备用4,备用5],备用扣数量1,备用扣数量2,备用数据3,备用数据4,备用数据5,备用辅助资料5编号,备用辅助资料5名称,备用辅助资料6编号,备用辅助资料6名称,备用辅助资料7编号,备用辅助资料7名称,备用数据6,备用数据7,备用辅助资料8编号,备用辅助资料8名称,备用辅助资料9编号,备用辅助资料9名称,数量1,数量2,用户名,图片]
    public static final String m_VCANSAPP_BAKMODULE6_UPLOADBIAO2 = "VPBKMD6UPBIAOX2";      //C     上传记录格式[内部ID,备用类型,备用数据1,备用数据2,备用辅助资料1编号,备用辅助资料1名称,备用辅助资料2编号,备用辅助资料2名称,备用辅助资料3编号,备用辅助资料3名称,备用辅助资料4编号,备用辅助资料4名称,[物料编号,物料描述 ,存货描述,存货标志,在库匹数,在库数量,备用1,备用2,备用3,备用4,备用5],备用扣数量1,备用扣数量2,备用数据3,备用数据4,备用数据5,备用辅助资料5编号,备用辅助资料5名称,备用辅助资料6编号,备用辅助资料6名称,备用辅助资料7编号,备用辅助资料7名称,备用数据6,备用数据7,备用辅助资料8编号,备用辅助资料8名称,备用辅助资料9编号,备用辅助资料9名称,数量1,数量2,用户名,图片]
    public static final String m_VCANSAPP_BAKMODULE6_UPLOADBIAO3 = "VPBKMD6UPBIAOX3";      //C     请求错误信息继续
    public static final String m_VCANSAPP_BAKMODULE6_UPLOADBIAORe0 = "VPBKMD6UPBIARE0";      //S     成功
    public static final String m_VCANSAPP_BAKMODULE6_UPLOADBIAORe1 = "VPBKMD6UPBIARE1";      //S     失败
    public static final String m_VCANSAPP_BAKMODULE6_UPLOADBIAORe3 = "VPBKMD6UPBIARE3";      //S     错误信息 + 错误记录格式[采集器内部ID]
    public static final String m_VCANSAPP_BAKMODULE6_UPLOADBIAORe5 = "VPBKMD6UPBIARE5";      //S     错误记录格式[采集器内部ID]

    /************************综合查询一*************************************************************************/
    //==跟单==综合查询一=辅助1下载
    public static final String m_VCANSAPP_GDQUERY1_XIAZAI_1FZ1 = "VPGDQR1FZ1XZXX1";      //C     [查询类型][用户名]
    public static final String m_VCANSAPP_GDQUERY1_XIAZAI_1FZ2 = "VPGDQR1FZ1XZXX2";      //C     [查询类型][用户名]
    public static final String m_VCANSAPP_GDQUERY1_XIAZAI_1FZRe0 = "VPGDQR1FZ1XZRE0";      //S     成功    下载记录格式["综合查询一辅助条件1",编码,名称]
    public static final String m_VCANSAPP_GDQUERY1_XIAZAI_1FZRe1 = "VPGDQR1FZ1XZRE1";      //S     失败    [失败信息]
    public static final String m_VCANSAPP_GDQUERY1_XIAZAI_1FZRe2 = "VPGDQR1FZ1XZRE2";      //S     成功    下载记录格式["综合查询一辅助条件1",编码,名称]

    //==跟单==综合查询一=辅助2下载
    public static final String m_VCANSAPP_GDQUERY1_XIAZAI_2FZ1 = "VPGDQR1FZ2XZXX1";      //C     [查询类型][综合查询辅助条件1编号][综合查询辅助条件1名称][用户名]
    public static final String m_VCANSAPP_GDQUERY1_XIAZAI_2FZ2 = "VPGDQR1FZ2XZXX2";      //C     [查询类型][综合查询辅助条件1编号][综合查询辅助条件1名称][用户名]
    public static final String m_VCANSAPP_GDQUERY1_XIAZAI_2FZRe0 = "VPGDQR1FZ2XZRE0";      //S     成功    下载记录格式["综合查询一辅助条件2",编码,名称]
    public static final String m_VCANSAPP_GDQUERY1_XIAZAI_2FZRe1 = "VPGDQR1FZ2XZRE1";      //S     失败    [失败信息]
    public static final String m_VCANSAPP_GDQUERY1_XIAZAI_2FZRe2 = "VPGDQR1FZ2XZRE2";      //S     成功    下载记录格式["综合查询一辅助条件2",编码,名称]

    //==跟单==综合查询一=辅助3下载
    public static final String m_VCANSAPP_GDQUERY1_XIAZAI_3FZ1 = "VPGDQR1FZ3XZXX1";      //C     [查询类型][综合查询辅助条件1编号][综合查询辅助条件1名称][综合查询辅助条件2编号][综合查询辅助条件2名称][用户名]
    public static final String m_VCANSAPP_GDQUERY1_XIAZAI_3FZ2 = "VPGDQR1FZ3XZXX2";      //C     [查询类型][综合查询辅助条件1编号][综合查询辅助条件1名称][综合查询辅助条件2编号][综合查询辅助条件2名称][用户名]
    public static final String m_VCANSAPP_GDQUERY1_XIAZAI_3FZRe0 = "VPGDQR1FZ3XZRE0";      //S     成功    下载记录格式["综合查询辅助条件3",编码,名称]
    public static final String m_VCANSAPP_GDQUERY1_XIAZAI_3FZRe1 = "VPGDQR1FZ3XZRE1";      //S     失败    [失败信息]
    public static final String m_VCANSAPP_GDQUERY1_XIAZAI_3FZRe2 = "VPGDQR1FZ3XZRE2";      //S     成功    下载记录格式["综合查询辅助条件3",编码,名称]

    //==跟单==综合查询一=物料信息下载
    public static final String m_VCANSAPP_GDQUERY1_XIAZAI_WULIAO1 = "VPGDQR1WLXZXXX1";      //C     [查询类型][综合查询辅助条件1编号][综合查询辅助条件1名称][综合查询辅助条件2编号][综合查询辅助条件2名称][综合查询辅助条件3编号][综合查询辅助条件3名称][用户名]
    public static final String m_VCANSAPP_GDQUERY1_XIAZAI_WULIAO2 = "VPGDQR1WLXZXXX2";      //C     [查询类型][综合查询辅助条件1编号][综合查询辅助条件1名称][综合查询辅助条件2编号][综合查询辅助条件2名称][综合查询辅助条件3编号][综合查询辅助条件3名称][用户名]
    public static final String m_VCANSAPP_GDQUERY1_XIAZAI_WULIAORe0 = "VPGDQR1WLXZXRE0";      //S     成功    下载记录格式[物料编号,物料描述 ,存货描述,存货标志,在库匹数,在库数量,备用1,备用2,备用3,备用4,备用5]
    public static final String m_VCANSAPP_GDQUERY1_XIAZAI_WULIAORe1 = "VPGDQR1WLXZXRE1";      //S     失败    [失败信息]
    public static final String m_VCANSAPP_GDQUERY1_XIAZAI_WULIAORe2 = "VPGDQR1WLXZXRE2";      //S     成功   下载记录格式[物料编号,物料描述 ,存货描述,存货标志,在库匹数,在库数量,备用1,备用2,备用3,备用4,备用5]

    /************************综合查询二*************************************************************************/
    //==跟单==综合查询二=辅助1下载
    public static final String m_VCANSAPP_GDQUERY2_XIAZAI_1FZ1 = "VPGDQR2FZ1XZXX1";      //C     [查询类型][用户名]
    public static final String m_VCANSAPP_GDQUERY2_XIAZAI_1FZ2 = "VPGDQR2FZ1XZXX2";      //C     [查询类型][用户名]
    public static final String m_VCANSAPP_GDQUERY2_XIAZAI_1FZRe0 = "VPGDQR2FZ1XZRE0";      //S     成功    下载记录格式["综合查询一辅助条件1",编码,名称]
    public static final String m_VCANSAPP_GDQUERY2_XIAZAI_1FZRe1 = "VPGDQR2FZ1XZRE1";      //S     失败    [失败信息]
    public static final String m_VCANSAPP_GDQUERY2_XIAZAI_1FZRe2 = "VPGDQR2FZ1XZRE2";      //S     成功    下载记录格式["综合查询一辅助条件1",编码,名称]

    //==跟单==综合查询二=辅助2下载
    public static final String m_VCANSAPP_GDQUERY2_XIAZAI_2FZ1 = "VPGDQR2FZ2XZXX1";      //C     [查询类型][综合查询辅助条件1编号][综合查询辅助条件1名称][用户名]
    public static final String m_VCANSAPP_GDQUERY2_XIAZAI_2FZ2 = "VPGDQR2FZ2XZXX2";      //C     [查询类型][综合查询辅助条件1编号][综合查询辅助条件1名称][用户名]
    public static final String m_VCANSAPP_GDQUERY2_XIAZAI_2FZRe0 = "VPGDQR2FZ2XZRE0";      //S     成功    下载记录格式["综合查询一辅助条件2",编码,名称]
    public static final String m_VCANSAPP_GDQUERY2_XIAZAI_2FZRe1 = "VPGDQR2FZ2XZRE1";      //S     失败    [失败信息]
    public static final String m_VCANSAPP_GDQUERY2_XIAZAI_2FZRe2 = "VPGDQR2FZ2XZRE2";      //S     成功    下载记录格式["综合查询一辅助条件2",编码,名称]

    //==跟单==综合查询二=辅助3下载
    public static final String m_VCANSAPP_GDQUERY2_XIAZAI_3FZ1 = "VPGDQR2FZ3XZXX1";      //C     [查询类型][综合查询辅助条件1编号][综合查询辅助条件1名称][综合查询辅助条件2编号][综合查询辅助条件2名称][用户名]
    public static final String m_VCANSAPP_GDQUERY2_XIAZAI_3FZ2 = "VPGDQR2FZ3XZXX2";      //C     [查询类型][综合查询辅助条件1编号][综合查询辅助条件1名称][综合查询辅助条件2编号][综合查询辅助条件2名称][用户名]
    public static final String m_VCANSAPP_GDQUERY2_XIAZAI_3FZRe0 = "VPGDQR2FZ3XZRE0";      //S     成功    下载记录格式["综合查询辅助条件3",编码,名称]
    public static final String m_VCANSAPP_GDQUERY2_XIAZAI_3FZRe1 = "VPGDQR2FZ3XZRE1";      //S     失败    [失败信息]
    public static final String m_VCANSAPP_GDQUERY2_XIAZAI_3FZRe2 = "VPGDQR2FZ3XZRE2";      //S     成功    下载记录格式["综合查询辅助条件3",编码,名称]

    //==跟单==综合查询二=物料信息下载
    public static final String m_VCANSAPP_GDQUERY2_XIAZAI_WULIAO1 = "VPGDQR2WLXZXXX1";      //C     [查询类型][综合查询辅助条件1编号][综合查询辅助条件1名称][综合查询辅助条件2编号][综合查询辅助条件2名称][综合查询辅助条件3编号][综合查询辅助条件3名称][用户名]
    public static final String m_VCANSAPP_GDQUERY2_XIAZAI_WULIAO2 = "VPGDQR2WLXZXXX2";      //C     [查询类型][综合查询辅助条件1编号][综合查询辅助条件1名称][综合查询辅助条件2编号][综合查询辅助条件2名称][综合查询辅助条件3编号][综合查询辅助条件3名称][用户名]
    public static final String m_VCANSAPP_GDQUERY2_XIAZAI_WULIAORe0 = "VPGDQR2WLXZXRE0";      //S     成功    下载记录格式[物料编号,物料描述 ,存货描述,存货标志,在库匹数,在库数量,备用1,备用2,备用3,备用4,备用5]
    public static final String m_VCANSAPP_GDQUERY2_XIAZAI_WULIAORe1 = "VPGDQR2WLXZXRE1";      //S     失败    [失败信息]
    public static final String m_VCANSAPP_GDQUERY2_XIAZAI_WULIAORe2 = "VPGDQR2WLXZXRE2";      //S     成功   下载记录格式[物料编号,物料描述 ,存货描述,存货标志,在库匹数,在库数量,备用1,备用2,备用3,备用4,备用5]

    /************************综合查询三 *************************************************************************/
    //==跟单==综合查询三=辅助1下载
    public static final String m_VCANSAPP_GDQUERY3_XIAZAI_1FZ1 = "VPGDQR3FZ1XZXX1";      //C     [查询类型][用户名]
    public static final String m_VCANSAPP_GDQUERY3_XIAZAI_1FZ2 = "VPGDQR3FZ1XZXX2";      //C     [查询类型][用户名]
    public static final String m_VCANSAPP_GDQUERY3_XIAZAI_1FZRe0 = "VPGDQR3FZ1XZRE0";      //S     成功    下载记录格式["综合查询一辅助条件1",编码,名称]
    public static final String m_VCANSAPP_GDQUERY3_XIAZAI_1FZRe1 = "VPGDQR3FZ1XZRE1";      //S     失败    [失败信息]
    public static final String m_VCANSAPP_GDQUERY3_XIAZAI_1FZRe2 = "VPGDQR3FZ1XZRE2";      //S     成功    下载记录格式["综合查询一辅助条件1",编码,名称]

    //==跟单==综合查询三=辅助2下载
    public static final String m_VCANSAPP_GDQUERY3_XIAZAI_2FZ1 = "VPGDQR3FZ2XZXX1";      //C     [查询类型][综合查询辅助条件1编号][综合查询辅助条件1名称][用户名]
    public static final String m_VCANSAPP_GDQUERY3_XIAZAI_2FZ2 = "VPGDQR3FZ2XZXX2";      //C     [查询类型][综合查询辅助条件1编号][综合查询辅助条件1名称][用户名]
    public static final String m_VCANSAPP_GDQUERY3_XIAZAI_2FZRe0 = "VPGDQR3FZ2XZRE0";      //S     成功    下载记录格式["综合查询一辅助条件2",编码,名称]
    public static final String m_VCANSAPP_GDQUERY3_XIAZAI_2FZRe1 = "VPGDQR3FZ2XZRE1";      //S     失败    [失败信息]
    public static final String m_VCANSAPP_GDQUERY3_XIAZAI_2FZRe2 = "VPGDQR3FZ2XZRE2";      //S     成功    下载记录格式["综合查询一辅助条件2",编码,名称]

    //==跟单==综合查询三=辅助3下载
    public static final String m_VCANSAPP_GDQUERY3_XIAZAI_3FZ1 = "VPGDQR3FZ3XZXX1";      //C     [查询类型][综合查询辅助条件1编号][综合查询辅助条件1名称][综合查询辅助条件2编号][综合查询辅助条件2名称][用户名]
    public static final String m_VCANSAPP_GDQUERY3_XIAZAI_3FZ2 = "VPGDQR3FZ3XZXX2";      //C     [查询类型][综合查询辅助条件1编号][综合查询辅助条件1名称][综合查询辅助条件2编号][综合查询辅助条件2名称][用户名]
    public static final String m_VCANSAPP_GDQUERY3_XIAZAI_3FZRe0 = "VPGDQR3FZ3XZRE0";      //S     成功    下载记录格式["综合查询辅助条件3",编码,名称]
    public static final String m_VCANSAPP_GDQUERY3_XIAZAI_3FZRe1 = "VPGDQR3FZ3XZRE1";      //S     失败    [失败信息]
    public static final String m_VCANSAPP_GDQUERY3_XIAZAI_3FZRe2 = "VPGDQR3FZ3XZRE2";      //S     成功    下载记录格式["综合查询辅助条件3",编码,名称]

    //==跟单==综合查询三=物料信息下载
    public static final String m_VCANSAPP_GDQUERY3_XIAZAI_WULIAO1 = "VPGDQR3WLXZXXX1";      //C     [查询类型][综合查询辅助条件1编号][综合查询辅助条件1名称][综合查询辅助条件2编号][综合查询辅助条件2名称][综合查询辅助条件3编号][综合查询辅助条件3名称][用户名]
    public static final String m_VCANSAPP_GDQUERY3_XIAZAI_WULIAO2 = "VPGDQR3WLXZXXX2";      //C     [查询类型][综合查询辅助条件1编号][综合查询辅助条件1名称][综合查询辅助条件2编号][综合查询辅助条件2名称][综合查询辅助条件3编号][综合查询辅助条件3名称][用户名]
    public static final String m_VCANSAPP_GDQUERY3_XIAZAI_WULIAORe0 = "VPGDQR3WLXZXRE0";      //S     成功    下载记录格式[物料编号,物料描述 ,存货描述,存货标志,在库匹数,在库数量,备用1,备用2,备用3,备用4,备用5]
    public static final String m_VCANSAPP_GDQUERY3_XIAZAI_WULIAORe1 = "VPGDQR3WLXZXRE1";      //S     失败    [失败信息]
    public static final String m_VCANSAPP_GDQUERY3_XIAZAI_WULIAORe2 = "VPGDQR3WLXZXRE2";      //S     成功   下载记录格式[物料编号,物料描述 ,存货描述,存货标志,在库匹数,在库数量,备用1,备用2,备用3,备用4,备用5]

    /************************综合查询四 *************************************************************************/
    //==跟单==综合查询四=辅助1下载
    public static final String m_VCANSAPP_GDQUERY4_XIAZAI_1FZ1 = "VPGDQR4FZ1XZXX1";      //C     [查询类型][用户名]
    public static final String m_VCANSAPP_GDQUERY4_XIAZAI_1FZ2 = "VPGDQR4FZ1XZXX2";      //C     [查询类型][用户名]
    public static final String m_VCANSAPP_GDQUERY4_XIAZAI_1FZRe0 = "VPGDQR4FZ1XZRE0";      //S     成功    下载记录格式["综合查询一辅助条件1",编码,名称]
    public static final String m_VCANSAPP_GDQUERY4_XIAZAI_1FZRe1 = "VPGDQR4FZ1XZRE1";      //S     失败    [失败信息]
    public static final String m_VCANSAPP_GDQUERY4_XIAZAI_1FZRe2 = "VPGDQR4FZ1XZRE2";      //S     成功    下载记录格式["综合查询一辅助条件1",编码,名称]

    //==跟单==综合查询四=辅助2下载
    public static final String m_VCANSAPP_GDQUERY4_XIAZAI_2FZ1 = "VPGDQR4FZ2XZXX1";      //C     [查询类型][综合查询辅助条件1编号][综合查询辅助条件1名称][用户名]
    public static final String m_VCANSAPP_GDQUERY4_XIAZAI_2FZ2 = "VPGDQR4FZ2XZXX2";      //C     [查询类型][综合查询辅助条件1编号][综合查询辅助条件1名称][用户名]
    public static final String m_VCANSAPP_GDQUERY4_XIAZAI_2FZRe0 = "VPGDQR4FZ2XZRE0";      //S     成功    下载记录格式["综合查询一辅助条件2",编码,名称]
    public static final String m_VCANSAPP_GDQUERY4_XIAZAI_2FZRe1 = "VPGDQR4FZ2XZRE1";      //S     失败    [失败信息]
    public static final String m_VCANSAPP_GDQUERY4_XIAZAI_2FZRe2 = "VPGDQR4FZ2XZRE2";      //S     成功    下载记录格式["综合查询一辅助条件2",编码,名称]

    //==跟单==综合查询四=辅助3下载
    public static final String m_VCANSAPP_GDQUERY4_XIAZAI_3FZ1 = "VPGDQR4FZ3XZXX1";      //C     [查询类型][综合查询辅助条件1编号][综合查询辅助条件1名称][综合查询辅助条件2编号][综合查询辅助条件2名称][用户名]
    public static final String m_VCANSAPP_GDQUERY4_XIAZAI_3FZ2 = "VPGDQR4FZ3XZXX2";      //C     [查询类型][综合查询辅助条件1编号][综合查询辅助条件1名称][综合查询辅助条件2编号][综合查询辅助条件2名称][用户名]
    public static final String m_VCANSAPP_GDQUERY4_XIAZAI_3FZRe0 = "VPGDQR4FZ3XZRE0";      //S     成功    下载记录格式["综合查询辅助条件3",编码,名称]
    public static final String m_VCANSAPP_GDQUERY4_XIAZAI_3FZRe1 = "VPGDQR4FZ3XZRE1";      //S     失败    [失败信息]
    public static final String m_VCANSAPP_GDQUERY4_XIAZAI_3FZRe2 = "VPGDQR4FZ3XZRE2";      //S     成功    下载记录格式["综合查询辅助条件3",编码,名称]

    //==跟单==综合查询四=物料信息下载
    public static final String m_VCANSAPP_GDQUERY4_XIAZAI_WULIAO1 = "VPGDQR4WLXZXXX1";      //C     [查询类型][综合查询辅助条件1编号][综合查询辅助条件1名称][综合查询辅助条件2编号][综合查询辅助条件2名称][综合查询辅助条件3编号][综合查询辅助条件3名称][用户名]
    public static final String m_VCANSAPP_GDQUERY4_XIAZAI_WULIAO2 = "VPGDQR4WLXZXXX2";      //C     [查询类型][综合查询辅助条件1编号][综合查询辅助条件1名称][综合查询辅助条件2编号][综合查询辅助条件2名称][综合查询辅助条件3编号][综合查询辅助条件3名称][用户名]
    public static final String m_VCANSAPP_GDQUERY4_XIAZAI_WULIAORe0 = "VPGDQR4WLXZXRE0";      //S     成功    下载记录格式[物料编号,物料描述 ,存货描述,存货标志,在库匹数,在库数量,备用1,备用2,备用3,备用4,备用5]
    public static final String m_VCANSAPP_GDQUERY4_XIAZAI_WULIAORe1 = "VPGDQR4WLXZXRE1";      //S     失败    [失败信息]
    public static final String m_VCANSAPP_GDQUERY4_XIAZAI_WULIAORe2 = "VPGDQR4WLXZXRE2";      //S     成功   下载记录格式[物料编号,物料描述 ,存货描述,存货标志,在库匹数,在库数量,备用1,备用2,备用3,备用4,备用5]

    /************************综合查询模板*************************************************************************/
    //==跟单==综合查询模板=辅助1下载
    public static final String m_VCANSAPP_GDQUERYN_XIAZAI_1FZ1 = "VPGDQR%sFZ1XZXX1";      //C     [查询类型][用户名]
    public static final String m_VCANSAPP_GDQUERYN_XIAZAI_1FZ2 = "VPGDQR%sFZ1XZXX2";      //C     [查询类型][用户名]
    public static final String m_VCANSAPP_GDQUERYN_XIAZAI_1FZRe0 = "VPGDQR%sFZ1XZRE0";      //S     成功    下载记录格式["综合查询一辅助条件1",编码,名称]
    public static final String m_VCANSAPP_GDQUERYN_XIAZAI_1FZRe1 = "VPGDQR%sFZ1XZRE1";      //S     失败    [失败信息]
    public static final String m_VCANSAPP_GDQUERYN_XIAZAI_1FZRe2 = "VPGDQR%sFZ1XZRE2";      //S     成功    下载记录格式["综合查询一辅助条件1",编码,名称]

    //==跟单==综合查询模板=辅助2下载
    public static final String m_VCANSAPP_GDQUERYN_XIAZAI_2FZ1 = "VPGDQR%sFZ2XZXX1";      //C     [查询类型][综合查询辅助条件1编号][综合查询辅助条件1名称][用户名]
    public static final String m_VCANSAPP_GDQUERYN_XIAZAI_2FZ2 = "VPGDQR%sFZ2XZXX2";      //C     [查询类型][综合查询辅助条件1编号][综合查询辅助条件1名称][用户名]
    public static final String m_VCANSAPP_GDQUERYN_XIAZAI_2FZRe0 = "VPGDQR%sFZ2XZRE0";      //S     成功    下载记录格式["综合查询一辅助条件2",编码,名称]
    public static final String m_VCANSAPP_GDQUERYN_XIAZAI_2FZRe1 = "VPGDQR%sFZ2XZRE1";      //S     失败    [失败信息]
    public static final String m_VCANSAPP_GDQUERYN_XIAZAI_2FZRe2 = "VPGDQR%sFZ2XZRE2";      //S     成功    下载记录格式["综合查询一辅助条件2",编码,名称]

    //==跟单==综合查询模板=辅助3下载
    public static final String m_VCANSAPP_GDQUERYN_XIAZAI_3FZ1 = "VPGDQR%sFZ3XZXX1";      //C     [查询类型][综合查询辅助条件1编号][综合查询辅助条件1名称][综合查询辅助条件2编号][综合查询辅助条件2名称][用户名]
    public static final String m_VCANSAPP_GDQUERYN_XIAZAI_3FZ2 = "VPGDQR%sFZ3XZXX2";      //C     [查询类型][综合查询辅助条件1编号][综合查询辅助条件1名称][综合查询辅助条件2编号][综合查询辅助条件2名称][用户名]
    public static final String m_VCANSAPP_GDQUERYN_XIAZAI_3FZRe0 = "VPGDQR%sFZ3XZRE0";      //S     成功    下载记录格式["综合查询辅助条件3",编码,名称]
    public static final String m_VCANSAPP_GDQUERYN_XIAZAI_3FZRe1 = "VPGDQR%sFZ3XZRE1";      //S     失败    [失败信息]
    public static final String m_VCANSAPP_GDQUERYN_XIAZAI_3FZRe2 = "VPGDQR%sFZ3XZRE2";      //S     成功    下载记录格式["综合查询辅助条件3",编码,名称]

    //==跟单==综合查询模板=物料信息下载
    public static final String m_VCANSAPP_GDQUERYN_XIAZAI_WULIAO1 = "VPGDQR%sWLXZXXX1";      //C     [查询类型][综合查询辅助条件1编号][综合查询辅助条件1名称][综合查询辅助条件2编号][综合查询辅助条件2名称][综合查询辅助条件3编号][综合查询辅助条件3名称][用户名]
    public static final String m_VCANSAPP_GDQUERYN_XIAZAI_WULIAO2 = "VPGDQR%sWLXZXXX2";      //C     [查询类型][综合查询辅助条件1编号][综合查询辅助条件1名称][综合查询辅助条件2编号][综合查询辅助条件2名称][综合查询辅助条件3编号][综合查询辅助条件3名称][用户名]
    public static final String m_VCANSAPP_GDQUERYN_XIAZAI_WULIAORe0 = "VPGDQR%sWLXZXRE0";      //S     成功    下载记录格式[物料编号,物料描述 ,存货描述,存货标志,在库匹数,在库数量,备用1,备用2,备用3,备用4,备用5]
    public static final String m_VCANSAPP_GDQUERYN_XIAZAI_WULIAORe1 = "VPGDQR%sWLXZXRE1";      //S     失败    [失败信息]
    public static final String m_VCANSAPP_GDQUERYN_XIAZAI_WULIAORe2 = "VPGDQR%sWLXZXRE2";      //S     成功   下载记录格式[物料编号,物料描述 ,存货描述,存货标志,在库匹数,在库数量,备用1,备用2,备用3,备用4,备用5]

    /************************备用模板模块*************************************************************************/
    //==跟单==备用模板=辅助1下载
    public static final String m_VCANSAPP_BAKMODULEN_XIAZAI_1FZ1 = "VPBKMD%sFZ1XZXX1";      //C     [备用类型][备用数据1][备用数据2][用户名]
    public static final String m_VCANSAPP_BAKMODULEN_XIAZAI_1FZ2 = "VPBKMD%sFZ1XZXX2";      //C     [备用类型][备用数据1][备用数据2][用户名]
    public static final String m_VCANSAPP_BAKMODULEN_XIAZAI_1FZRe0 = "VPBKMD%sFZ1XZRE0";      //S     成功    下载记录格式["备用四辅助资料1",编码,名称]
    public static final String m_VCANSAPP_BAKMODULEN_XIAZAI_1FZRe1 = "VPBKMD%sFZ1XZRE1";      //S     失败    [失败信息]
    public static final String m_VCANSAPP_BAKMODULEN_XIAZAI_1FZRe2 = "VPBKMD%sFZ1XZRE2";      //S     成功    下载记录格式["备用四辅助资料1",编码,名称]

    //==跟单==备用模板=辅助2下载
    public static final String m_VCANSAPP_BAKMODULEN_XIAZAI_2FZ1 = "VPBKMD%sFZ2XZXX1";      //C     [备用类型][备用数据1][备用数据2][备用辅助资料1编号][备用辅助资料1名称][用户名]
    public static final String m_VCANSAPP_BAKMODULEN_XIAZAI_2FZ2 = "VPBKMD%sFZ2XZXX2";      //C     [备用类型][备用数据1][备用数据2][备用辅助资料1编号][备用辅助资料1名称][用户名]
    public static final String m_VCANSAPP_BAKMODULEN_XIAZAI_2FZRe0 = "VPBKMD%sFZ2XZRE0";      //S     成功    下载记录格式["备用四辅助资料2",编码,名称]
    public static final String m_VCANSAPP_BAKMODULEN_XIAZAI_2FZRe1 = "VPBKMD%sFZ2XZRE1";      //S     失败    [失败信息]
    public static final String m_VCANSAPP_BAKMODULEN_XIAZAI_2FZRe2 = "VPBKMD%sFZ2XZRE2";      //S     成功    下载记录格式["备用四辅助资料2",编码,名称]


    //==跟单==备用模板=辅助3下载
    public static final String m_VCANSAPP_BAKMODULEN_XIAZAI_3FZ1 = "VPBKMD%sFZ3XZXX1";      //C     [备用类型][备用数据1][备用数据2][备用辅助资料1编号][备用辅助资料1名称][备用辅助资料2编号][备用辅助资料2名称][用户名]
    public static final String m_VCANSAPP_BAKMODULEN_XIAZAI_3FZ2 = "VPBKMD%sFZ3XZXX2";      //C     [备用类型][备用数据1][备用数据2][备用辅助资料1编号][备用辅助资料1名称][备用辅助资料2编号][备用辅助资料2名称][用户名]
    public static final String m_VCANSAPP_BAKMODULEN_XIAZAI_3FZRe0 = "VPBKMD%sFZ3XZRE0";      //S     成功    下载记录格式["备用四辅助资料3",编码,名称]
    public static final String m_VCANSAPP_BAKMODULEN_XIAZAI_3FZRe1 = "VPBKMD%sFZ3XZRE1";      //S     失败    [失败信息]
    public static final String m_VCANSAPP_BAKMODULEN_XIAZAI_3FZRe2 = "VPBKMD%sFZ3XZRE2";      //S     成功    下载记录格式["备用四辅助资料3",编码,名称]

    //==跟单==备用模板=辅助4下载
    public static final String m_VCANSAPP_BAKMODULEN_XIAZAI_4FZ1 = "VPBKMD%sFZ4XZXX1";      //C     [备用类型][备用数据1][备用数据2][备用辅助资料1编号][备用辅助资料1名称][备用辅助资料2编号][备用辅助资料2名称][备用辅助资料3编号][备用辅助资料3名称][用户名]
    public static final String m_VCANSAPP_BAKMODULEN_XIAZAI_4FZ2 = "VPBKMD%sFZ4XZXX2";      //C     [备用类型][备用数据1][备用数据2][备用辅助资料1编号][备用辅助资料1名称][备用辅助资料2编号][备用辅助资料2名称][备用辅助资料3编号][备用辅助资料3名称][用户名]
    public static final String m_VCANSAPP_BAKMODULEN_XIAZAI_4FZRe0 = "VPBKMD%sFZ4XZRE0";      //S     成功    下载记录格式["备用四辅助资料4",编码,名称]
    public static final String m_VCANSAPP_BAKMODULEN_XIAZAI_4FZRe1 = "VPBKMD%sFZ4XZRE1";      //S     失败    [失败信息]
    public static final String m_VCANSAPP_BAKMODULEN_XIAZAI_4FZRe2 = "VPBKMD%sFZ4XZRE2";      //S     成功    下载记录格式["备用四辅助资料4",编码,名称]

    //==跟单==备用模板=辅助5下载
    public static final String m_VCANSAPP_BAKMODULEN_XIAZAI_5FZ1 = "VPBKMD%sFZ5XZXX1";      //C     [备用类型][备用数据1][备用数据2][备用辅助资料1编号][备用辅助资料1名称][备用辅助资料2编号][备用辅助资料2名称][备用辅助资料3编号][备用辅助资料3名称][备用辅助资料4编号][备用辅助资料4名称][物料编号,物料描述,存货描述,存货标志,匹数,数量, 信息一, 信息二, 信息三, 信息四, 信息五][备用扣除数量1][备用扣除数量2][备用数据3][备用数据4][备用数据5][用户名]
    public static final String m_VCANSAPP_BAKMODULEN_XIAZAI_5FZ2 = "VPBKMD%sFZ5XZXX2";      //C     [备用类型][备用数据1][备用数据2][备用辅助资料1编号][备用辅助资料1名称][备用辅助资料2编号][备用辅助资料2名称][备用辅助资料3编号][备用辅助资料3名称][备用辅助资料4编号][备用辅助资料4名称][物料编号,物料描述,存货描述,存货标志,匹数,数量, 信息一, 信息二, 信息三, 信息四, 信息五][备用扣除数量1][备用扣除数量2][备用数据3][备用数据4][备用数据5][用户名]
    public static final String m_VCANSAPP_BAKMODULEN_XIAZAI_5FZRe0 = "VPBKMD%sFZ5XZRE0";      //S     成功    下载记录格式["备用四辅助资料5",编码,名称]
    public static final String m_VCANSAPP_BAKMODULEN_XIAZAI_5FZRe1 = "VPBKMD%sFZ5XZRE1";      //S     失败    [失败信息]
    public static final String m_VCANSAPP_BAKMODULEN_XIAZAI_5FZRe2 = "VPBKMD%sFZ5XZRE2";      //S     成功    下载记录格式["备用四辅助资料5",编码,名称]

    //==跟单==备用模板=辅助6下载
    public static final String m_VCANSAPP_BAKMODULEN_XIAZAI_6FZ1 = "VPBKMD%sFZ6XZXX1";      //C     [备用类型][备用数据1][备用数据2][备用辅助资料1编号][备用辅助资料1名称][备用辅助资料2编号][备用辅助资料2名称][备用辅助资料3编号][备用辅助资料3名称][备用辅助资料4编号][备用辅助资料4名称][物料编号,物料描述,存货描述,存货标志,匹数,数量, 信息一, 信息二, 信息三, 信息四, 信息五][备用扣除数量1][备用扣除数量2][备用数据3][备用数据4][备用数据5][备用辅助资料5编号][备用辅助资料5名称][用户名]
    public static final String m_VCANSAPP_BAKMODULEN_XIAZAI_6FZ2 = "VPBKMD%sFZ6XZXX2";      //C     [备用类型][备用数据1][备用数据2][备用辅助资料1编号][备用辅助资料1名称][备用辅助资料2编号][备用辅助资料2名称][备用辅助资料3编号][备用辅助资料3名称][备用辅助资料4编号][备用辅助资料4名称][物料编号,物料描述,存货描述,存货标志,匹数,数量, 信息一, 信息二, 信息三, 信息四, 信息五][备用扣除数量1][备用扣除数量2][备用数据3][备用数据4][备用数据5][备用辅助资料5编号][备用辅助资料5名称][用户名]
    public static final String m_VCANSAPP_BAKMODULEN_XIAZAI_6FZRe0 = "VPBKMD%sFZ6XZRE0";      //S     成功    下载记录格式["备用四辅助资料6",编码,名称]
    public static final String m_VCANSAPP_BAKMODULEN_XIAZAI_6FZRe1 = "VPBKMD%sFZ6XZRE1";      //S     失败    [失败信息]
    public static final String m_VCANSAPP_BAKMODULEN_XIAZAI_6FZRe2 = "VPBKMD%sFZ6XZRE2";      //S     成功    下载记录格式["备用四辅助资料6",编码,名称]

    //==跟单==备用模板=辅助7下载
    public static final String m_VCANSAPP_BAKMODULEN_XIAZAI_7FZ1 = "VPBKMD%sFZ7XZXX1";      //C     [备用类型][备用数据1][备用数据2][备用辅助资料1编号][备用辅助资料1名称][备用辅助资料2编号][备用辅助资料2名称][备用辅助资料3编号][备用辅助资料3名称][备用辅助资料4编号][备用辅助资料4名称][物料编号,物料描述,存货描述,存货标志,匹数,数量, 信息一, 信息二, 信息三, 信息四, 信息五][备用扣除数量1][备用扣除数量2][备用数据3][备用数据4][备用数据5][备用辅助资料5编号][备用辅助资料5名称][备用辅助资料6编号][备用辅助资料6名称][用户名]
    public static final String m_VCANSAPP_BAKMODULEN_XIAZAI_7FZ2 = "VPBKMD%sFZ7XZXX2";      //C     [备用类型][备用数据1][备用数据2][备用辅助资料1编号][备用辅助资料1名称][备用辅助资料2编号][备用辅助资料2名称][备用辅助资料3编号][备用辅助资料3名称][备用辅助资料4编号][备用辅助资料4名称][物料编号,物料描述,存货描述,存货标志,匹数,数量, 信息一, 信息二, 信息三, 信息四, 信息五][备用扣除数量1][备用扣除数量2][备用数据3][备用数据4][备用数据5][备用辅助资料5编号][备用辅助资料5名称][备用辅助资料6编号][备用辅助资料6名称][用户名]
    public static final String m_VCANSAPP_BAKMODULEN_XIAZAI_7FZRe0 = "VPBKMD%sFZ7XZRE0";      //S     成功    下载记录格式["备用四辅助资料6",编码,名称]
    public static final String m_VCANSAPP_BAKMODULEN_XIAZAI_7FZRe1 = "VPBKMD%sFZ7XZRE1";      //S     失败    [失败信息]
    public static final String m_VCANSAPP_BAKMODULEN_XIAZAI_7FZRe2 = "VPBKMD%sFZ7XZRE2";      //S     成功    下载记录格式["备用四辅助资料6",编码,名称]

    //==跟单==备用模板=物料信息下载
    public static final String m_VCANSAPP_BAKMODULEN_XIAZAI_WULIAO1 = "VPBKMD%sWLXZXXX1";      //C     [备用类型][备用数据1][备用数据2][备用辅助资料1编号][备用辅助资料1名称][备用辅助资料2编号][备用辅助资料2名称][备用辅助资料3编号][备用辅助资料3名称][备用辅助资料4编号][备用辅助资料4名称][用户名]
    public static final String m_VCANSAPP_BAKMODULEN_XIAZAI_WULIAO2 = "VPBKMD%sWLXZXXX2";      //C     [备用类型][备用数据1][备用数据2][备用辅助资料1编号][备用辅助资料1名称][备用辅助资料2编号][备用辅助资料2名称][备用辅助资料3编号][备用辅助资料3名称][备用辅助资料4编号][备用辅助资料4名称][用户名]
    public static final String m_VCANSAPP_BAKMODULEN_XIAZAI_WULIAORe0 = "VPBKMD%sWLXZXRE0";      //S     成功    下载记录格式[物料编号,物料描述 ,存货描述,存货标志,在库匹数,在库数量,备用1,备用2,备用3,备用4,备用5]
    public static final String m_VCANSAPP_BAKMODULEN_XIAZAI_WULIAORe1 = "VPBKMD%sWLXZXRE1";      //S     失败    [失败信息]
    public static final String m_VCANSAPP_BAKMODULEN_XIAZAI_WULIAORe2 = "VPBKMD%sWLXZXRE2";      //S     成功   下载记录格式[物料编号,物料描述 ,存货描述,存货标志,在库匹数,在库数量,备用1,备用2,备用3,备用4,备用5]

    //==跟单==备用模板==表上传
    public static final String m_VCANSAPP_BAKMODULEN_UPLOADBIAO0 = "VPBKMD%sUPBIAOX0";      //C     开始命令
    public static final String m_VCANSAPP_BAKMODULEN_UPLOADBIAO1 = "VPBKMD%sUPBIAOX1";      //C     上传记录格式[内部ID,备用类型,备用数据1,备用数据2,备用辅助资料1编号,备用辅助资料1名称,备用辅助资料2编号,备用辅助资料2名称,备用辅助资料3编号,备用辅助资料3名称,备用辅助资料4编号,备用辅助资料4名称,[物料编号,物料描述 ,存货描述,存货标志,在库匹数,在库数量,备用1,备用2,备用3,备用4,备用5],备用扣数量1,备用扣数量2,备用数据3,备用数据4,备用数据5,备用辅助资料5编号,备用辅助资料5名称,备用辅助资料6编号,备用辅助资料6名称,备用辅助资料7编号,备用辅助资料7名称,备用数据6,备用数据7,备用辅助资料8编号,备用辅助资料8名称,备用辅助资料9编号,备用辅助资料9名称,数量1,数量2,用户名,图片]
    public static final String m_VCANSAPP_BAKMODULEN_UPLOADBIAO2 = "VPBKMD%sUPBIAOX2";      //C     上传记录格式[内部ID,备用类型,备用数据1,备用数据2,备用辅助资料1编号,备用辅助资料1名称,备用辅助资料2编号,备用辅助资料2名称,备用辅助资料3编号,备用辅助资料3名称,备用辅助资料4编号,备用辅助资料4名称,[物料编号,物料描述 ,存货描述,存货标志,在库匹数,在库数量,备用1,备用2,备用3,备用4,备用5],备用扣数量1,备用扣数量2,备用数据3,备用数据4,备用数据5,备用辅助资料5编号,备用辅助资料5名称,备用辅助资料6编号,备用辅助资料6名称,备用辅助资料7编号,备用辅助资料7名称,备用数据6,备用数据7,备用辅助资料8编号,备用辅助资料8名称,备用辅助资料9编号,备用辅助资料9名称,数量1,数量2,用户名,图片]
    public static final String m_VCANSAPP_BAKMODULEN_UPLOADBIAO3 = "VPBKMD%sUPBIAOX3";      //C     请求错误信息继续
    public static final String m_VCANSAPP_BAKMODULEN_UPLOADBIAORe0 = "VPBKMD%sUPBIARE0";      //S     成功
    public static final String m_VCANSAPP_BAKMODULEN_UPLOADBIAORe1 = "VPBKMD%sUPBIARE1";      //S     失败
    public static final String m_VCANSAPP_BAKMODULEN_UPLOADBIAORe3 = "VPBKMD%sUPBIARE3";      //S     错误信息 + 错误记录格式[采集器内部ID]
    public static final String m_VCANSAPP_BAKMODULEN_UPLOADBIAORe5 = "VPBKMD%sUPBIARE5";      //S     错误记录格式[采集器内部ID]

    /*
     * ***********************名片识别*************************************************************************/
    //==样品==名片识别-表上传
    public static final String m_vfxVAG43VcanMingpianshibie0 = "V43VCANMPSBXXX0";     //C     开始命令
    public static final String m_vfxVAG43VcanMingpianshibie1 = "V43VCANMPSBXXX1";     //C    上传记录格式[id,公司简称,客户姓名,职位,phone1,phone2,传真,地址,公司网站,email,备注]
    public static final String m_vfxVAG43VcanMingpianshibie2 = "V43VCANMPSBXXX2";     //C      上传记录格式[客户姓名,公司简称,客户电话,公司职位,传真,备注]
    public static final String m_vfxVAG43VcanMingpianshibie3 = "V43VCANMPSBXXX3";     //C     请求错误信息继续
    public static final String m_vfxVAG43VcanMingpianshibieRe0 = "V43VCANMPSBXRE0";     //S     成功
    public static final String m_vfxVAG43VcanMingpianshibieRe1 = "V43VCANMPSBXRE1";     //S     失败
    public static final String m_vfxVAG43VcanMingpianshibieRe3 = "V43VCANMPSBXRE3";     //S     错误信息 + 错误记录格式[客户条码]
    public static final String m_vfxVAG43VcanMingpianshibieRe5 = "V43VCANMPSBXRE5";     //S     错误记录格式[客户条码]


    /*
     ***********************备用模块01*************************************************************************/
    //==VCANS_成品_坯布_标准==备用01==字段01==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan011 = "V16VSBY01F01XX1";      //C     [字段01,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan012 = "V16VSBY01F01XX2";      //C     [字段01,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan01Re0 = "V16VSBY01F01RE0";      //S     成功    下载记录格式[备用01_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan01Re1 = "V16VSBY01F01RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan01Re2 = "V16VSBY01F01RE2";      //S     成功    下载记录格式[备用01_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用01==字段02==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan021 = "V16VSBY01F02XX1";      //C     [字段02,字段01,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan022 = "V16VSBY01F02XX2";      //C     [字段02,字段01,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan02Re0 = "V16VSBY01F02RE0";      //S     成功    下载记录格式[备用01_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan02Re1 = "V16VSBY01F02RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan02Re2 = "V16VSBY01F02RE2";      //S     成功    下载记录格式[备用01_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用01==字段03==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan031 = "V16VSBY01F03XX1";      //C     [字段03,字段01,字段02,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan032 = "V16VSBY01F03XX2";      //C     [字段03,字段01,字段02,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan03Re0 = "V16VSBY01F03RE0";      //S     成功    下载记录格式[备用01_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan03Re1 = "V16VSBY01F03RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan03Re2 = "V16VSBY01F03RE2";      //S     成功    下载记录格式[备用01_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用01==字段04==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan041 = "V16VSBY01F04XX1";      //C     [字段04,字段01,字段02,字段03,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan042 = "V16VSBY01F04XX2";      //C     [字段04,字段01,字段02,字段03,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan04Re0 = "V16VSBY01F04RE0";      //S     成功    下载记录格式[备用01_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan04Re1 = "V16VSBY01F04RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan04Re2 = "V16VSBY01F04RE2";      //S     成功    下载记录格式[备用01_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用01==字段05==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan051 = "V16VSBY01F05XX1";      //C     [字段05,字段01,字段02,字段03,字段04,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan052 = "V16VSBY01F05XX2";      //C     [字段05,字段01,字段02,字段03,字段04,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan05Re0 = "V16VSBY01F05RE0";      //S     成功    下载记录格式[备用01_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan05Re1 = "V16VSBY01F05RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan05Re2 = "V16VSBY01F05RE2";      //S     成功    下载记录格式[备用01_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用01==字段06==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan061 = "V16VSBY01F06XX1";      //C     [字段06,字段01,字段02,字段03,字段04,字段05,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan062 = "V16VSBY01F06XX2";      //C     [字段06,字段01,字段02,字段03,字段04,字段05,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan06Re0 = "V16VSBY01F06RE0";      //S     成功    下载记录格式[备用01_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan06Re1 = "V16VSBY01F06RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan06Re2 = "V16VSBY01F06RE2";      //S     成功    下载记录格式[备用01_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用01==字段07==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan071 = "V16VSBY01F07XX1";      //C     [字段07,字段01,字段02,字段03,字段04,字段05,字段06,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan072 = "V16VSBY01F07XX2";      //C     [字段07,字段01,字段02,字段03,字段04,字段05,字段06,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan07Re0 = "V16VSBY01F07RE0";      //S     成功    下载记录格式[备用01_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan07Re1 = "V16VSBY01F07RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan07Re2 = "V16VSBY01F07RE2";      //S     成功    下载记录格式[备用01_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用01==字段08==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan081 = "V16VSBY01F08XX1";      //C     [字段08,字段01,字段02,字段03,字段04,字段05,字段06,字段07,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan082 = "V16VSBY01F08XX2";      //C     [字段08,字段01,字段02,字段03,字段04,字段05,字段06,字段07,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan08Re0 = "V16VSBY01F08RE0";      //S     成功    下载记录格式[备用01_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan08Re1 = "V16VSBY01F08RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan08Re2 = "V16VSBY01F08RE2";      //S     成功    下载记录格式[备用01_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用01==字段09==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan091 = "V16VSBY01F09XX1";      //C     [字段09,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan092 = "V16VSBY01F09XX2";      //C     [字段09,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan09Re0 = "V16VSBY01F09RE0";      //S     成功    下载记录格式[备用01_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan09Re1 = "V16VSBY01F09RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan09Re2 = "V16VSBY01F09RE2";      //S     成功    下载记录格式[备用01_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用01==字段10==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan101 = "V16VSBY01F10XX1";      //C     [字段10,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan102 = "V16VSBY01F10XX2";      //C     [字段10,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan10Re0 = "V16VSBY01F10RE0";      //S     成功    下载记录格式[备用01_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan10Re1 = "V16VSBY01F10RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan10Re2 = "V16VSBY01F10RE2";      //S     成功    下载记录格式[备用01_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用01==字段11==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan111 = "V16VSBY01F11XX1";      //C     [字段11,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan112 = "V16VSBY01F11XX2";      //C     [字段11,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan11Re0 = "V16VSBY01F11RE0";      //S     成功    下载记录格式[备用01_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan11Re1 = "V16VSBY01F11RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan11Re2 = "V16VSBY01F11RE2";      //S     成功    下载记录格式[备用01_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用01==字段12==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan121 = "V16VSBY01F12XX1";      //C     [字段12,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan122 = "V16VSBY01F12XX2";      //C     [字段12,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan12Re0 = "V16VSBY01F12RE0";      //S     成功    下载记录格式[备用01_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan12Re1 = "V16VSBY01F12RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan12Re2 = "V16VSBY01F12RE2";      //S     成功    下载记录格式[备用01_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用01==字段13==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan131 = "V16VSBY01F13XX1";      //C     [字段13,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan132 = "V166VSBY01F13XX2";      //C     [字段13,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan13Re0 = "V16VSBY01F13RE0";      //S     成功    下载记录格式[备用01_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan13Re1 = "V16VSBY01F13RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan13Re2 = "V16VSBY01F13RE2";      //S     成功    下载记录格式[备用01_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用01==字段14==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan141 = "V16VSBY01F14XX1";      //C     [字段14,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan142 = "V16VSBY01F14XX2";      //C     [字段14,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan14Re0 = "V16VSBY01F14RE0";      //S     成功    下载记录格式[备用01_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan14Re1 = "V16VSBY01F14RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan14Re2 = "V16VSBY01F14RE2";      //S     成功    下载记录格式[备用01_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用01==字段15==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan151 = "V16VSBY01F15XX1";      //C     [字段15,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan152 = "V16VSBY01F15XX2";      //C     [字段15,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan15Re0 = "V16VSBY01F15RE0";      //S     成功    下载记录格式[备用01_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan15Re1 = "V16VSBY01F15RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan15Re2 = "V16VSBY01F15RE2";      //S     成功    下载记录格式[备用01_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用01==字段16==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan161 = "V16VSBY01F16XX1";      //C     [字段16,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan162 = "V16VSBY01F16XX2";      //C     [字段16,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan16Re0 = "V16VSBY01F16RE0";      //S     成功    下载记录格式[备用01_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan16Re1 = "V16VSBY01F16RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan16Re2 = "V16VSBY01F16RE2";      //S     成功    下载记录格式[备用01_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用01==字段17==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan171 = "V16VSBY01F17XX1";      //C     [字段17,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan172 = "V16VSBY01F17XX2";      //C     [字段17,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan17Re0 = "V16VSBY01F17RE0";      //S     成功    下载记录格式[备用01_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan17Re1 = "V16VSBY01F17RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan17Re2 = "V16VSBY01F17RE2";      //S     成功    下载记录格式[备用01_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用01==字段18==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan181 = "V16VSBY01F18XX1";      //C     [字段18,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,字段17,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan182 = "V16VSBY01F18XX2";      //C     [字段18,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,字段17,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan18Re0 = "V16VSBY01F18RE0";      //S     成功    下载记录格式[备用01_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan18Re1 = "V16VSBY01F18RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan18Re2 = "V16VSBY01F18RE2";      //S     成功    下载记录格式[备用01_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用01==字段19==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan191 = "V16VSBY01F19XX1";      //C     [字段19,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,字段17,字段18,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan192 = "V16VSBY01F19XX2";      //C     [字段19,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,字段17,字段18,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan19Re0 = "V16VSBY01F19RE0";      //S     成功    下载记录格式[备用01_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan19Re1 = "V16VSBY01F19RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan19Re2 = "V16VSBY01F19RE2";      //S     成功    下载记录格式[备用01_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用01==字段20==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan201 = "V16VSBY01F20XX1";      //C     [字段20,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,字段17,字段18,字段19,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan202 = "V16VSBY01F20XX2";      //C     [字段20,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,字段17,字段18,字段19,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan20Re0 = "V16VSBY01F20RE0";      //S     成功    下载记录格式[备用01_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan20Re1 = "V16VSBY01F20RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan20Re2 = "V16VSBY01F20RE2";      //S     成功    下载记录格式[备用01_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用01==字段21==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan211 = "V16VSBY01F21XX1";      //C     [字段21,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,字段17,字段18,字段19,字段20,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan212 = "V16VSBY01F21XX2";      //C     [字段21,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,字段17,字段18,字段19,字段20,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan21Re0 = "V16VSBY01F21RE0";      //S     成功    下载记录格式[备用01_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan21Re1 = "V16VSBY01F21RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan21Re2 = "V16VSBY01F21RE2";      //S     成功    下载记录格式[备用01_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用01==字段22==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan221 = "V16VSBY01F22XX1";      //C     [字段22,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,字段17,字段18,字段19,字段20,字段21,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan222 = "V16VSBY01F22XX2";      //C     [字段22,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,字段17,字段18,字段19,字段20,字段21,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan22Re0 = "V16VSBY01F22RE0";      //S     成功    下载记录格式[备用01_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan22Re1 = "V16VSBY01F22RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan22Re2 = "V16VSBY01F22RE2";      //S     成功    下载记录格式[备用01_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用01==字段23==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan231 = "V16VSBY01F23XX1";      //C     [字段23,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,字段17,字段18,字段19,字段20,字段21,字段22,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan232 = "V16VSBY01F23XX2";      //C     [字段23,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,字段17,字段18,字段19,字段20,字段21,字段22,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan23Re0 = "V16VSBY01F23RE0";      //S     成功    下载记录格式[备用01_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan23Re1 = "V16VSBY01F23RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan23Re2 = "V16VSBY01F23RE2";      //S     成功    下载记录格式[备用01_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用01==字段24==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan241 = "V16VSBY01F24XX1";      //C     [字段24,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,字段17,字段18,字段19,字段20,字段21,字段22,字段23,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan242 = "V16VSBY01F24XX2";      //C     [字段24,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,字段17,字段18,字段19,字段20,字段21,字段22,字段23,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan24Re0 = "V16VSBY01F24RE0";      //S     成功    下载记录格式[备用01_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan24Re1 = "V16VSBY01F24RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan24Re2 = "V16VSBY01F24RE2";      //S     成功    下载记录格式[备用01_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用01==字段25==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan251 = "V16VSBY01F25XX1";      //C     [字段25,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,字段17,字段18,字段19,字段20,字段21,字段22,字段23,字段24,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan252 = "V16VSBY01F25XX2";      //C     [字段25,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,字段17,字段18,字段19,字段20,字段21,字段22,字段23,字段24,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan25Re0 = "V16VSBY01F25RE0";      //S     成功    下载记录格式[备用01_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan25Re1 = "V16VSBY01F25RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan25Re2 = "V16VSBY01F25RE2";      //S     成功    下载记录格式[备用01_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用01==字段26==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan261 = "V16VSBY01F26XX1";      //C     [字段26,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,字段17,字段18,字段19,字段20,字段21,字段22,字段23,字段24,字段25,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan262 = "V16VSBY01F26XX2";      //C     [字段26,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,字段17,字段18,字段19,字段20,字段21,字段22,字段23,字段24,字段25,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan26Re0 = "V16VSBY01F26RE0";      //S     成功    下载记录格式[备用01_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan26Re1 = "V16VSBY01F26RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan26Re2 = "V16VSBY01F26RE2";      //S     成功    下载记录格式[备用01_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用01==字段27==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan271 = "V16VSBY01F27XX1";      //C     [字段27,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,字段17,字段18,字段19,字段20,字段21,字段22,字段23,字段24,字段25,字段26,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan272 = "V16VSBY01F27XX2";      //C     [字段27,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,字段17,字段18,字段19,字段20,字段21,字段22,字段23,字段24,字段25,字段26,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan27Re0 = "V16VSBY01F27RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan27Re1 = "V16VSBY01F27RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01_ZiDuan27Re2 = "V16VSBY01F27RE2";      //S     成功

    //==VCANS_成品_坯布_标准==备用01==表上传
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01Biao0 = "V16VSBY01BXXXX0";     //C     开始命令
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01Biao1 = "V16VSBY01BXXXX1";     //C     上传记录格式[采集器内部ID,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,字段17,字段18,字段19,字段20,字段21,字段22,字段23,字段24,字段25,字段26,字段27,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01Biao2 = "V16VSBY01BXXXX2";     //C     上传记录格式[采集器内部ID,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,字段17,字段18,字段19,字段20,字段21,字段22,字段23,字段24,字段25,字段26,字段27,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01Biao3 = "V16VSBY01BXXXX3";     //C     请求错误信息继续
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01BiaoRe0 = "V16VSBY01BXXRE0";     //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01BiaoRe1 = "V16VSBY01BXXRE1";     //S     失败     [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01BiaoRe3 = "V16VSBY01BXXRE3";     //S     错误信息 + 错误记录格式[采集器内部ID]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong01BiaoRe5 = "V16VSBY01BXXRE5";     //S     错误记录格式[采集器内部ID]


    /************************备用模块02*************************************************************************/

    //==VCANS_成品_坯布_标准==备用02==字段01==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan011 = "V16VSBY02F01XX1";      //C     [字段01,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan012 = "V16VSBY02F01XX2";      //C     [字段01,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan01Re0 = "V16VSBY02F01RE0";      //S     成功    下载记录格式[备用02_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan01Re1 = "V16VSBY02F01RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan01Re2 = "V16VSBY02F01RE2";      //S     成功    下载记录格式[备用02_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用02==字段02==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan021 = "V16VSBY02F02XX1";      //C     [字段02,字段01,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan022 = "V16VSBY02F02XX2";      //C     [字段02,字段01,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan02Re0 = "V16VSBY02F02RE0";      //S     成功    下载记录格式[备用02_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan02Re1 = "V16VSBY02F02RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan02Re2 = "V16VSBY02F02RE2";      //S     成功    下载记录格式[备用02_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用02==字段03==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan031 = "V16VSBY02F03XX1";      //C     [字段03,字段01,字段02,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan032 = "V16VSBY02F03XX2";      //C     [字段03,字段01,字段02,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan03Re0 = "V16VSBY02F03RE0";      //S     成功    下载记录格式[备用02_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan03Re1 = "V16VSBY02F03RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan03Re2 = "V16VSBY02F03RE2";      //S     成功    下载记录格式[备用02_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用02==字段04==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan041 = "V16VSBY02F04XX1";      //C     [字段04,字段01,字段02,字段03,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan042 = "V16VSBY02F04XX2";      //C     [字段04,字段01,字段02,字段03,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan04Re0 = "V16VSBY02F04RE0";      //S     成功    下载记录格式[备用02_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan04Re1 = "V16VSBY02F04RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan04Re2 = "V16VSBY02F04RE2";      //S     成功    下载记录格式[备用02_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用02==字段05==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan051 = "V16VSBY02F05XX1";      //C     [字段05,字段01,字段02,字段03,字段04,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan052 = "V16VSBY02F05XX2";      //C     [字段05,字段01,字段02,字段03,字段04,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan05Re0 = "V16VSBY02F05RE0";      //S     成功    下载记录格式[备用02_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan05Re1 = "V16VSBY02F05RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan05Re2 = "V16VSBY02F05RE2";      //S     成功    下载记录格式[备用02_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用02==字段06==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan061 = "V16VSBY02F06XX1";      //C     [字段06,字段01,字段02,字段03,字段04,字段05,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan062 = "V16VSBY02F06XX2";      //C     [字段06,字段01,字段02,字段03,字段04,字段05,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan06Re0 = "V16VSBY02F06RE0";      //S     成功    下载记录格式[备用02_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan06Re1 = "V16VSBY02F06RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan06Re2 = "V16VSBY02F06RE2";      //S     成功    下载记录格式[备用02_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用02==字段07==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan071 = "V16VSBY02F07XX1";      //C     [字段07,字段01,字段02,字段03,字段04,字段05,字段06,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan072 = "V16VSBY02F07XX2";      //C     [字段07,字段01,字段02,字段03,字段04,字段05,字段06,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan07Re0 = "V16VSBY02F07RE0";      //S     成功    下载记录格式[备用02_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan07Re1 = "V16VSBY02F07RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan07Re2 = "V16VSBY02F07RE2";      //S     成功    下载记录格式[备用02_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用02==字段08==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan081 = "V16VSBY02F08XX1";      //C     [字段08,字段01,字段02,字段03,字段04,字段05,字段06,字段07,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan082 = "V16VSBY02F08XX2";      //C     [字段08,字段01,字段02,字段03,字段04,字段05,字段06,字段07,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan08Re0 = "V16VSBY02F08RE0";      //S     成功    下载记录格式[备用02_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan08Re1 = "V16VSBY02F08RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan08Re2 = "V16VSBY02F08RE2";      //S     成功    下载记录格式[备用02_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用02==字段09==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan091 = "V16VSBY02F09XX1";      //C     [字段09,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan092 = "V16VSBY02F09XX2";      //C     [字段09,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan09Re0 = "V16VSBY02F09RE0";      //S     成功    下载记录格式[备用02_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan09Re1 = "V16VSBY02F09RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan09Re2 = "V16VSBY02F09RE2";      //S     成功    下载记录格式[备用02_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用02==字段10==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan101 = "V16VSBY02F10XX1";      //C     [字段10,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan102 = "V16VSBY02F10XX2";      //C     [字段10,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan10Re0 = "V16VSBY02F10RE0";      //S     成功    下载记录格式[备用02_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan10Re1 = "V16VSBY02F10RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan10Re2 = "V16VSBY02F10RE2";      //S     成功    下载记录格式[备用02_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用02==字段11==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan111 = "V16VSBY02F11XX1";      //C     [字段11,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan112 = "V16VSBY02F11XX2";      //C     [字段11,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan11Re0 = "V16VSBY02F11RE0";      //S     成功    下载记录格式[备用02_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan11Re1 = "V16VSBY02F11RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan11Re2 = "V16VSBY02F11RE2";      //S     成功    下载记录格式[备用02_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用02==字段12==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan121 = "V16VSBY02F12XX1";      //C     [字段12,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan122 = "V16VSBY02F12XX2";      //C     [字段12,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan12Re0 = "V16VSBY02F12RE0";      //S     成功    下载记录格式[备用02_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan12Re1 = "V16VSBY02F12RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan12Re2 = "V16VSBY02F12RE2";      //S     成功    下载记录格式[备用02_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用02==字段13==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan131 = "V16VSBY02F13XX1";      //C     [字段13,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan132 = "V16VSBY02F13XX2";      //C     [字段13,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan13Re0 = "V16VSBY02F13RE0";      //S     成功    下载记录格式[备用02_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan13Re1 = "V16VSBY02F13RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan13Re2 = "V16VSBY02F13RE2";      //S     成功    下载记录格式[备用02_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用02==字段14==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan141 = "V16VSBY02F14XX1";      //C     [字段14,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan142 = "V16VSBY02F14XX2";      //C     [字段14,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan14Re0 = "V16VSBY02F14RE0";      //S     成功    下载记录格式[备用02_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan14Re1 = "V16VSBY02F14RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan14Re2 = "V16VSBY02F14RE2";      //S     成功    下载记录格式[备用02_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用02==字段15==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan151 = "V16VSBY02F15XX1";      //C     [字段15,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan152 = "V16VSBY02F15XX2";      //C     [字段15,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan15Re0 = "V16VSBY02F15RE0";      //S     成功    下载记录格式[备用02_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan15Re1 = "V16VSBY02F15RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan15Re2 = "V16VSBY02F15RE2";      //S     成功    下载记录格式[备用02_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用02==字段16==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan161 = "V16VSBY02F16XX1";      //C     [字段16,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan162 = "V16VSBY02F16XX2";      //C     [字段16,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan16Re0 = "V16VSBY02F16RE0";      //S     成功    下载记录格式[备用02_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan16Re1 = "V16VSBY02F16RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan16Re2 = "V16VSBY02F16RE2";      //S     成功    下载记录格式[备用02_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用02==字段17==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan171 = "V16VSBY02F17XX1";      //C     [字段17,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan172 = "V16VSBY02F17XX2";      //C     [字段17,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan17Re0 = "V16VSBY02F17RE0";      //S     成功    下载记录格式[备用02_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan17Re1 = "V16VSBY02F17RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan17Re2 = "V16VSBY02F17RE2";      //S     成功    下载记录格式[备用02_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用02==字段18==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan181 = "V16VSBY02F18XX1";      //C     [字段18,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,字段17,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan182 = "V16VSBY02F18XX2";      //C     [字段18,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,字段17,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan18Re0 = "V16VSBY02F18RE0";      //S     成功    下载记录格式[备用02_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan18Re1 = "V16VSBY02F18RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan18Re2 = "V16VSBY02F18RE2";      //S     成功    下载记录格式[备用02_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用02==字段19==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan191 = "V16VSBY02F19XX1";      //C     [字段19,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,字段17,字段18,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan192 = "V16VSBY02F19XX2";      //C     [字段19,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,字段17,字段18,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan19Re0 = "V16VSBY02F19RE0";      //S     成功    下载记录格式[备用02_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan19Re1 = "V16VSBY02F19RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan19Re2 = "V16VSBY02F19RE2";      //S     成功    下载记录格式[备用02_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用02==字段20==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan201 = "V16VSBY02F20XX1";      //C     [字段20,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,字段17,字段18,字段19,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan202 = "V16VSBY02F20XX2";      //C     [字段20,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,字段17,字段18,字段19,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan20Re0 = "V16VSBY02F20RE0";      //S     成功    下载记录格式[备用02_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan20Re1 = "V16VSBY02F20RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan20Re2 = "V16VSBY02F20RE2";      //S     成功    下载记录格式[备用02_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用02==字段21==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan211 = "V16VSBY02F21XX1";      //C     [字段21,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,字段17,字段18,字段19,字段20,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan212 = "V16VSBY02F21XX2";      //C     [字段21,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,字段17,字段18,字段19,字段20,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan21Re0 = "V16VSBY02F21RE0";      //S     成功    下载记录格式[备用02_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan21Re1 = "V16VSBY02F21RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan21Re2 = "V16VSBY02F21RE2";      //S     成功    下载记录格式[备用02_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用02==字段22==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan221 = "V16VSBY02F22XX1";      //C     [字段22,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,字段17,字段18,字段19,字段20,字段21,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan222 = "V16VSBY02F22XX2";      //C     [字段22,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,字段17,字段18,字段19,字段20,字段21,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan22Re0 = "V16VSBY02F22RE0";      //S     成功    下载记录格式[备用02_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan22Re1 = "V16VSBY02F22RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan22Re2 = "V16VSBY02F22RE2";      //S     成功    下载记录格式[备用02_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用02==字段23==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan231 = "V16VSBY02F23XX1";      //C     [字段23,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,字段17,字段18,字段19,字段20,字段21,字段22,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan232 = "V16VSBY02F23XX2";      //C     [字段23,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,字段17,字段18,字段19,字段20,字段21,字段22,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan23Re0 = "V16VSBY02F23RE0";      //S     成功    下载记录格式[备用02_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan23Re1 = "V16VSBY02F23RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan23Re2 = "V16VSBY02F23RE2";      //S     成功    下载记录格式[备用02_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用02==字段24==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan241 = "V16VSBY02F24XX1";      //C     [字段24,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,字段17,字段18,字段19,字段20,字段21,字段22,字段23,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan242 = "V16VSBY02F24XX2";      //C     [字段24,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,字段17,字段18,字段19,字段20,字段21,字段22,字段23,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan24Re0 = "V16VSBY02F24RE0";      //S     成功    下载记录格式[备用02_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan24Re1 = "V16VSBY02F24RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan24Re2 = "V16VSBY02F24RE2";      //S     成功    下载记录格式[备用02_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用02==字段25==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan251 = "V16VSBY02F25XX1";      //C     [字段25,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,字段17,字段18,字段19,字段20,字段21,字段22,字段23,字段24,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan252 = "V16VSBY02F25XX2";      //C     [字段25,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,字段17,字段18,字段19,字段20,字段21,字段22,字段23,字段24,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan25Re0 = "V16VSBY02F25RE0";      //S     成功    下载记录格式[备用02_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan25Re1 = "V16VSBY02F25RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan25Re2 = "V16VSBY02F25RE2";      //S     成功    下载记录格式[备用02_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用02==字段26==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan261 = "V16VSBY02F26XX1";      //C     [字段26,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,字段17,字段18,字段19,字段20,字段21,字段22,字段23,字段24,字段25,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan262 = "V16VSBY02F26XX2";      //C     [字段26,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,字段17,字段18,字段19,字段20,字段21,字段22,字段23,字段24,字段25,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan26Re0 = "V16VSBY02F26RE0";      //S     成功    下载记录格式[备用02_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan26Re1 = "V16VSBY02F26RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan26Re2 = "V16VSBY02F26RE2";      //S     成功    下载记录格式[备用02_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用02==字段27==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan271 = "V16VSBY02F27XX1";      //C     [字段27,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,字段17,字段18,字段19,字段20,字段21,字段22,字段23,字段24,字段25,字段26,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan272 = "V16VSBY02F27XX2";      //C     [字段27,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,字段17,字段18,字段19,字段20,字段21,字段22,字段23,字段24,字段25,字段26,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan27Re0 = "V16VSBY02F27RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan27Re1 = "V16VSBY02F27RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02_ZiDuan27Re2 = "V16VSBY02F27RE2";      //S     成功

    //==VCANS_成品_坯布_标准==备用02==表上传
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02Biao0 = "V16VSBY02BXXXX0";     //C     开始命令
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02Biao1 = "V16VSBY02BXXXX1";     //C     上传记录格式[采集器内部ID,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,字段17,字段18,字段19,字段20,字段21,字段22,字段23,字段24,字段25,字段26,字段27,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02Biao2 = "V16VSBY02BXXXX2";     //C     上传记录格式[采集器内部ID,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,字段17,字段18,字段19,字段20,字段21,字段22,字段23,字段24,字段25,字段26,字段27,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02Biao3 = "V16VSBY02BXXXX3";     //C     请求错误信息继续
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02BiaoRe0 = "V16VSBY02BXXRE0";     //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02BiaoRe1 = "V16VSBY02BXXRE1";     //S     失败     [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02BiaoRe3 = "V16VSBY02BXXRE3";     //S     错误信息 + 错误记录格式[采集器内部ID]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong02BiaoRe5 = "V16VSBY02BXXRE5";     //S     错误记录格式[采集器内部ID]

    /*
	 * ***********************备用模块03*************************************************************************/

    //==VCANS_成品_坯布_标准==备用03==字段01==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan011 = "V16VSBY03F01XX1";      //C     [字段01,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan012 = "V16VSBY03F01XX2";      //C     [字段01,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan01Re0 = "V16VSBY03F01RE0";      //S     成功    下载记录格式[备用03_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan01Re1 = "V16VSBY03F01RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan01Re2 = "V16VSBY03F01RE2";      //S     成功    下载记录格式[备用03_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用03==字段02==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan021 = "V16VSBY03F02XX1";      //C     [字段02,字段01,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan022 = "V16VSBY03F02XX2";      //C     [字段02,字段01,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan02Re0 = "V16VSBY03F02RE0";      //S     成功    下载记录格式[备用03_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan02Re1 = "V16VSBY03F02RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan02Re2 = "V16VSBY03F02RE2";      //S     成功    下载记录格式[备用03_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用03==字段03==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan031 = "V16VSBY03F03XX1";      //C     [字段03,字段01,字段02,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan032 = "V16VSBY03F03XX2";      //C     [字段03,字段01,字段02,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan03Re0 = "V16VSBY03F03RE0";      //S     成功    下载记录格式[备用03_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan03Re1 = "V16VSBY03F03RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan03Re2 = "V16VSBY03F03RE2";      //S     成功    下载记录格式[备用03_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用03==字段04==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan041 = "V16VSBY03F04XX1";      //C     [字段04,字段01,字段02,字段03,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan042 = "V16VSBY03F04XX2";      //C     [字段04,字段01,字段02,字段03,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan04Re0 = "V16VSBY03F04RE0";      //S     成功    下载记录格式[备用03_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan04Re1 = "V16VSBY03F04RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan04Re2 = "V16VSBY03F04RE2";      //S     成功    下载记录格式[备用03_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用03==字段05==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan051 = "V16VSBY03F05XX1";      //C     [字段05,字段01,字段02,字段03,字段04,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan052 = "V16VSBY03F05XX2";      //C     [字段05,字段01,字段02,字段03,字段04,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan05Re0 = "V16VSBY03F05RE0";      //S     成功    下载记录格式[备用03_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan05Re1 = "V16VSBY03F05RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan05Re2 = "V16VSBY03F05RE2";      //S     成功    下载记录格式[备用03_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用03==字段06==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan061 = "V16VSBY03F06XX1";      //C     [字段06,字段01,字段02,字段03,字段04,字段05,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan062 = "V16VSBY03F06XX2";      //C     [字段06,字段01,字段02,字段03,字段04,字段05,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan06Re0 = "V16VSBY03F06RE0";      //S     成功    下载记录格式[备用03_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan06Re1 = "V16VSBY03F06RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan06Re2 = "V16VSBY03F06RE2";      //S     成功    下载记录格式[备用03_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用03==字段07==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan071 = "V16VSBY03F07XX1";      //C     [字段07,字段01,字段02,字段03,字段04,字段05,字段06,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan072 = "V16VSBY03F07XX2";      //C     [字段07,字段01,字段02,字段03,字段04,字段05,字段06,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan07Re0 = "V16VSBY03F07RE0";      //S     成功    下载记录格式[备用03_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan07Re1 = "V16VSBY03F07RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan07Re2 = "V16VSBY03F07RE2";      //S     成功    下载记录格式[备用03_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用03==字段08==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan081 = "V16VSBY03F08XX1";      //C     [字段08,字段01,字段02,字段03,字段04,字段05,字段06,字段07,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan082 = "V16VSBY03F08XX2";      //C     [字段08,字段01,字段02,字段03,字段04,字段05,字段06,字段07,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan08Re0 = "V16VSBY03F08RE0";      //S     成功    下载记录格式[备用03_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan08Re1 = "V16VSBY03F08RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan08Re2 = "V16VSBY03F08RE2";      //S     成功    下载记录格式[备用03_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用03==字段09==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan091 = "V16VSBY03F09XX1";      //C     [字段09,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan092 = "V16VSBY03F09XX2";      //C     [字段09,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan09Re0 = "V16VSBY03F09RE0";      //S     成功    下载记录格式[备用03_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan09Re1 = "V16VSBY03F09RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan09Re2 = "V16VSBY03F09RE2";      //S     成功    下载记录格式[备用03_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用03==字段10==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan101 = "V16VSBY03F10XX1";      //C     [字段10,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan102 = "V16VSBY03F10XX2";      //C     [字段10,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan10Re0 = "V16VSBY03F10RE0";      //S     成功    下载记录格式[备用03_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan10Re1 = "V16VSBY03F10RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan10Re2 = "V16VSBY03F10RE2";      //S     成功    下载记录格式[备用03_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用03==字段11==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan111 = "V16VSBY03F11XX1";      //C     [字段11,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan112 = "V16VSBY03F11XX2";      //C     [字段11,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan11Re0 = "V16VSBY03F11RE0";      //S     成功    下载记录格式[备用03_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan11Re1 = "V16VSBY03F11RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan11Re2 = "V16VSBY03F11RE2";      //S     成功    下载记录格式[备用03_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用03==字段12==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan121 = "V16VSBY03F12XX1";      //C     [字段12,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan122 = "V16VSBY03F12XX2";      //C     [字段12,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan12Re0 = "V16VSBY03F12RE0";      //S     成功    下载记录格式[备用03_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan12Re1 = "V16VSBY03F12RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan12Re2 = "V16VSBY03F12RE2";      //S     成功    下载记录格式[备用03_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用03==字段13==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan131 = "V16VSBY03F13XX1";      //C     [字段13,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan132 = "V16VSBY03F13XX2";      //C     [字段13,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan13Re0 = "V16VSBY03F13RE0";      //S     成功    下载记录格式[备用03_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan13Re1 = "V16VSBY03F13RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan13Re2 = "V16VSBY03F13RE2";      //S     成功    下载记录格式[备用03_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用03==字段14==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan141 = "V16VSBY03F14XX1";      //C     [字段14,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan142 = "V16VSBY03F14XX2";      //C     [字段14,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan14Re0 = "V16VSBY03F14RE0";      //S     成功    下载记录格式[备用03_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan14Re1 = "V16VSBY03F14RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan14Re2 = "V16VSBY03F14RE2";      //S     成功    下载记录格式[备用03_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用03==字段15==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan151 = "V16VSBY03F15XX1";      //C     [字段15,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan152 = "V16VSBY03F15XX2";      //C     [字段15,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan15Re0 = "V16VSBY03F15RE0";      //S     成功    下载记录格式[备用03_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan15Re1 = "V16VSBY03F15RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan15Re2 = "V16VSBY03F15RE2";      //S     成功    下载记录格式[备用03_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用03==字段16==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan161 = "V16VSBY03F16XX1";      //C     [字段16,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan162 = "V16VSBY03F16XX2";      //C     [字段16,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan16Re0 = "V16VSBY03F16RE0";      //S     成功    下载记录格式[备用03_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan16Re1 = "V16VSBY03F16RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan16Re2 = "V16VSBY03F16RE2";      //S     成功    下载记录格式[备用03_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用03==字段17==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan171 = "V16VSBY03F17XX1";      //C     [字段17,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan172 = "V16VSBY03F17XX2";      //C     [字段17,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan17Re0 = "V16VSBY03F17RE0";      //S     成功    下载记录格式[备用03_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan17Re1 = "V16VSBY03F17RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan17Re2 = "V16VSBY03F17RE2";      //S     成功    下载记录格式[备用03_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用03==字段18==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan181 = "V16VSBY03F18XX1";      //C     [字段18,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,字段17,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan182 = "V16VSBY03F18XX2";      //C     [字段18,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,字段17,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan18Re0 = "V16VSBY03F18RE0";      //S     成功    下载记录格式[备用03_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan18Re1 = "V16VSBY03F18RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan18Re2 = "V16VSBY03F18RE2";      //S     成功    下载记录格式[备用03_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用03==字段19==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan191 = "V16VSBY03F19XX1";      //C     [字段19,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,字段17,字段18,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan192 = "V16VSBY03F19XX2";      //C     [字段19,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,字段17,字段18,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan19Re0 = "V16VSBY03F19RE0";      //S     成功    下载记录格式[备用03_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan19Re1 = "V16VSBY03F19RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan19Re2 = "V16VSBY03F19RE2";      //S     成功    下载记录格式[备用03_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用03==字段20==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan201 = "V16VSBY03F20XX1";      //C     [字段20,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,字段17,字段18,字段19,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan202 = "V16VSBY03F20XX2";      //C     [字段20,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,字段17,字段18,字段19,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan20Re0 = "V16VSBY03F20RE0";      //S     成功    下载记录格式[备用03_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan20Re1 = "V16VSBY03F20RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan20Re2 = "V16VSBY03F20RE2";      //S     成功    下载记录格式[备用03_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用03==字段21==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan211 = "V16VSBY03F21XX1";      //C     [字段21,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,字段17,字段18,字段19,字段20,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan212 = "V16VSBY03F21XX2";      //C     [字段21,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,字段17,字段18,字段19,字段20,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan21Re0 = "V16VSBY03F21RE0";      //S     成功    下载记录格式[备用03_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan21Re1 = "V16VSBY03F21RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan21Re2 = "V16VSBY03F21RE2";      //S     成功    下载记录格式[备用03_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用03==字段22==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan221 = "V16VSBY03F22XX1";      //C     [字段22,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,字段17,字段18,字段19,字段20,字段21,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan222 = "V16VSBY03F22XX2";      //C     [字段22,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,字段17,字段18,字段19,字段20,字段21,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan22Re0 = "V16VSBY03F22RE0";      //S     成功    下载记录格式[备用03_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan22Re1 = "V16VSBY03F22RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan22Re2 = "V16VSBY03F22RE2";      //S     成功    下载记录格式[备用03_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用03==字段23==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan231 = "V16VSBY03F23XX1";      //C     [字段23,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,字段17,字段18,字段19,字段20,字段21,字段22,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan232 = "V16VSBY03F23XX2";      //C     [字段23,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,字段17,字段18,字段19,字段20,字段21,字段22,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan23Re0 = "V16VSBY03F23RE0";      //S     成功    下载记录格式[备用03_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan23Re1 = "V16VSBY03F23RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan23Re2 = "V16VSBY03F23RE2";      //S     成功    下载记录格式[备用03_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用03==字段24==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan241 = "V16VSBY03F24XX1";      //C     [字段24,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,字段17,字段18,字段19,字段20,字段21,字段22,字段23,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan242 = "V16VSBY03F24XX2";      //C     [字段24,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,字段17,字段18,字段19,字段20,字段21,字段22,字段23,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan24Re0 = "V16VSBY03F24RE0";      //S     成功    下载记录格式[备用03_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan24Re1 = "V16VSBY03F24RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan24Re2 = "V16VSBY03F24RE2";      //S     成功    下载记录格式[备用03_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用03==字段25==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan251 = "V16VSBY03F25XX1";      //C     [字段25,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,字段17,字段18,字段19,字段20,字段21,字段22,字段23,字段24,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan252 = "V16VSBY03F25XX2";      //C     [字段25,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,字段17,字段18,字段19,字段20,字段21,字段22,字段23,字段24,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan25Re0 = "V16VSBY03F25RE0";      //S     成功    下载记录格式[备用03_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan25Re1 = "V16VSBY03F25RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan25Re2 = "V16VSBY03F25RE2";      //S     成功    下载记录格式[备用03_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用03==字段26==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan261 = "V16VSBY03F26XX1";      //C     [字段26,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,字段17,字段18,字段19,字段20,字段21,字段22,字段23,字段24,字段25,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan262 = "V16VSBY03F26XX2";      //C     [字段26,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,字段17,字段18,字段19,字段20,字段21,字段22,字段23,字段24,字段25,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan26Re0 = "V16VSBY03F26RE0";      //S     成功    下载记录格式[备用03_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan26Re1 = "V16VSBY03F26RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan26Re2 = "V16VSBY03F26RE2";      //S     成功    下载记录格式[备用03_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用03==字段27==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan271 = "V16VSBY03F27XX1";      //C     [字段27,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,字段17,字段18,字段19,字段20,字段21,字段22,字段23,字段24,字段25,字段26,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan272 = "V16VSBY03F27XX2";      //C     [字段27,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,字段17,字段18,字段19,字段20,字段21,字段22,字段23,字段24,字段25,字段26,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan27Re0 = "V16VSBY03F27RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan27Re1 = "V16VSBY03F27RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03_ZiDuan27Re2 = "V16VSBY03F27RE2";      //S     成功


    //==VCANS_成品_坯布_标准==备用03==表上传
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03Biao0 = "V16VSBY03BXXXX0";     //C     开始命令
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03Biao1 = "V16VSBY03BXXXX1";     //C     上传记录格式[采集器内部ID,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,字段17,字段18,字段19,字段20,字段21,字段22,字段23,字段24,字段25,字段26,字段27,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03Biao2 = "V16VSBY03BXXXX2";     //C     上传记录格式[采集器内部ID,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,字段17,字段18,字段19,字段20,字段21,字段22,字段23,字段24,字段25,字段26,字段27,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03Biao3 = "V16VSBY03BXXXX3";     //C     请求错误信息继续
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03BiaoRe0 = "V16VSBY03BXXRE0";     //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03BiaoRe1 = "V16VSBY03BXXRE1";     //S     失败     [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03BiaoRe3 = "V16VSBY03BXXRE3";     //S     错误信息 + 错误记录格式[采集器内部ID]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong03BiaoRe5 = "V16VSBY03BXXRE5";     //S     错误记录格式[采集器内部ID]



      /*
  	 * ***********************备用模块04*************************************************************************/

    //==VCANS_成品_坯布_标准==备用04==字段01==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan011 = "V16VSBY04F01XX1";      //C     [字段01,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan012 = "V16VSBY04F01XX2";      //C     [字段01,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan01Re0 = "V16VSBY04F01RE0";      //S     成功    下载记录格式[备用04_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan01Re1 = "V16VSBY04F01RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan01Re2 = "V16VSBY04F01RE2";      //S     成功    下载记录格式[备用04_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用04==字段02==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan021 = "V16VSBY04F02XX1";      //C     [字段02,字段01,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan022 = "V16VSBY04F02XX2";      //C     [字段02,字段01,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan02Re0 = "V16VSBY04F02RE0";      //S     成功    下载记录格式[备用04_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan02Re1 = "V16VSBY04F02RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan02Re2 = "V16VSBY04F02RE2";      //S     成功    下载记录格式[备用04_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用04==字段03==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan031 = "V16VSBY04F03XX1";      //C     [字段03,字段01,字段02,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan032 = "V16VSBY04F03XX2";      //C     [字段03,字段01,字段02,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan03Re0 = "V16VSBY04F03RE0";      //S     成功    下载记录格式[备用04_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan03Re1 = "V16VSBY04F03RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan03Re2 = "V16VSBY04F03RE2";      //S     成功    下载记录格式[备用04_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用04==字段04==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan041 = "V16VSBY04F04XX1";      //C     [字段04,字段01,字段02,字段03,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan042 = "V16VSBY04F04XX2";      //C     [字段04,字段01,字段02,字段03,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan04Re0 = "V16VSBY04F04RE0";      //S     成功    下载记录格式[备用04_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan04Re1 = "V16VSBY04F04RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan04Re2 = "V16VSBY04F04RE2";      //S     成功    下载记录格式[备用04_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用04==字段05==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan051 = "V16VSBY04F05XX1";      //C     [字段05,字段01,字段02,字段03,字段04,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan052 = "V16VSBY04F05XX2";      //C     [字段05,字段01,字段02,字段03,字段04,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan05Re0 = "V16VSBY04F05RE0";      //S     成功    下载记录格式[备用04_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan05Re1 = "V16VSBY04F05RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan05Re2 = "V16VSBY04F05RE2";      //S     成功    下载记录格式[备用04_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用04==字段06==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan061 = "V16VSBY04F06XX1";      //C     [字段06,字段01,字段02,字段03,字段04,字段05,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan062 = "V16VSBY04F06XX2";      //C     [字段06,字段01,字段02,字段03,字段04,字段05,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan06Re0 = "V16VSBY04F06RE0";      //S     成功    下载记录格式[备用04_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan06Re1 = "V16VSBY04F06RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan06Re2 = "V16VSBY04F06RE2";      //S     成功    下载记录格式[备用04_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用04==字段07==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan071 = "V16VSBY04F07XX1";      //C     [字段07,字段01,字段02,字段03,字段04,字段05,字段06,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan072 = "V16VSBY04F07XX2";      //C     [字段07,字段01,字段02,字段03,字段04,字段05,字段06,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan07Re0 = "V16VSBY04F07RE0";      //S     成功    下载记录格式[备用04_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan07Re1 = "V16VSBY04F07RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan07Re2 = "V16VSBY04F07RE2";      //S     成功    下载记录格式[备用04_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用04==字段08==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan081 = "V16VSBY04F08XX1";      //C     [字段08,字段01,字段02,字段03,字段04,字段05,字段06,字段07,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan082 = "V16VSBY04F08XX2";      //C     [字段08,字段01,字段02,字段03,字段04,字段05,字段06,字段07,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan08Re0 = "V16VSBY04F08RE0";      //S     成功    下载记录格式[备用04_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan08Re1 = "V16VSBY04F08RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan08Re2 = "V16VSBY04F08RE2";      //S     成功    下载记录格式[备用04_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用04==字段09==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan091 = "V16VSBY04F09XX1";      //C     [字段09,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan092 = "V16VSBY04F09XX2";      //C     [字段09,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan09Re0 = "V16VSBY04F09RE0";      //S     成功    下载记录格式[备用04_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan09Re1 = "V16VSBY04F09RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan09Re2 = "V16VSBY04F09RE2";      //S     成功    下载记录格式[备用04_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用04==字段10==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan101 = "V16VSBY04F10XX1";      //C     [字段10,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan102 = "V16VSBY04F10XX2";      //C     [字段10,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan10Re0 = "V16VSBY04F10RE0";      //S     成功    下载记录格式[备用04_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan10Re1 = "V16VSBY04F10RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan10Re2 = "V16VSBY04F10RE2";      //S     成功    下载记录格式[备用04_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用04==字段11==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan111 = "V16VSBY04F11XX1";      //C     [字段11,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan112 = "V16VSBY04F11XX2";      //C     [字段11,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan11Re0 = "V16VSBY04F11RE0";      //S     成功    下载记录格式[备用04_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan11Re1 = "V16VSBY04F11RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan11Re2 = "V16VSBY04F11RE2";      //S     成功    下载记录格式[备用04_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用04==字段12==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan121 = "V16VSBY04F12XX1";      //C     [字段12,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan122 = "V16VSBY04F12XX2";      //C     [字段12,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan12Re0 = "V16VSBY04F12RE0";      //S     成功    下载记录格式[备用04_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan12Re1 = "V16VSBY04F12RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan12Re2 = "V16VSBY04F12RE2";      //S     成功    下载记录格式[备用04_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用04==字段13==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan131 = "V16VSBY04F13XX1";      //C     [字段13,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan132 = "V16VSBY04F13XX2";      //C     [字段13,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan13Re0 = "V16VSBY04F13RE0";      //S     成功    下载记录格式[备用04_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan13Re1 = "V16VSBY04F13RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan13Re2 = "V16VSBY04F13RE2";      //S     成功    下载记录格式[备用04_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用04==字段14==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan141 = "V16VSBY04F14XX1";      //C     [字段14,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan142 = "V16VSBY04F14XX2";      //C     [字段14,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan14Re0 = "V16VSBY04F14RE0";      //S     成功    下载记录格式[备用04_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan14Re1 = "V16VSBY04F14RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan14Re2 = "V16VSBY04F14RE2";      //S     成功    下载记录格式[备用04_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用04==字段15==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan151 = "V16VSBY04F15XX1";      //C     [字段15,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan152 = "V16VSBY04F15XX2";      //C     [字段15,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan15Re0 = "V16VSBY04F15RE0";      //S     成功    下载记录格式[备用04_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan15Re1 = "V16VSBY04F15RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan15Re2 = "V16VSBY04F15RE2";      //S     成功    下载记录格式[备用04_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用04==字段16==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan161 = "V16VSBY04F16XX1";      //C     [字段16,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan162 = "V16VSBY04F16XX2";      //C     [字段16,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan16Re0 = "V16VSBY04F16RE0";      //S     成功    下载记录格式[备用04_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan16Re1 = "V16VSBY04F16RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan16Re2 = "V16VSBY04F16RE2";      //S     成功    下载记录格式[备用04_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用04==字段17==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan171 = "V16VSBY04F17XX1";      //C     [字段17,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan172 = "V16VSBY04F17XX2";      //C     [字段17,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan17Re0 = "V16VSBY04F17RE0";      //S     成功    下载记录格式[备用04_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan17Re1 = "V16VSBY04F17RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan17Re2 = "V16VSBY04F17RE2";      //S     成功    下载记录格式[备用04_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用04==字段18==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan181 = "V16VSBY04F18XX1";      //C     [字段18,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,字段17,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan182 = "V16VSBY04F18XX2";      //C     [字段18,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,字段17,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan18Re0 = "V16VSBY04F18RE0";      //S     成功    下载记录格式[备用04_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan18Re1 = "V16VSBY04F18RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan18Re2 = "V16VSBY04F18RE2";      //S     成功    下载记录格式[备用04_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用04==字段19==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan191 = "V16VSBY04F19XX1";      //C     [字段19,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,字段17,字段18,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan192 = "V16VSBY04F19XX2";      //C     [字段19,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,字段17,字段18,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan19Re0 = "V16VSBY04F19RE0";      //S     成功    下载记录格式[备用04_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan19Re1 = "V16VSBY04F19RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan19Re2 = "V16VSBY04F19RE2";      //S     成功    下载记录格式[备用04_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用04==字段20==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan201 = "V16VSBY04F20XX1";      //C     [字段20,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,字段17,字段18,字段19,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan202 = "V16VSBY04F20XX2";      //C     [字段20,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,字段17,字段18,字段19,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan20Re0 = "V16VSBY04F20RE0";      //S     成功    下载记录格式[备用04_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan20Re1 = "V16VSBY04F20RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan20Re2 = "V166VSBY04F20RE2";      //S     成功    下载记录格式[备用04_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用04==字段21==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan211 = "V16VSBY04F21XX1";      //C     [字段21,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,字段17,字段18,字段19,字段20,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan212 = "V16VSBY04F21XX2";      //C     [字段21,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,字段17,字段18,字段19,字段20,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan21Re0 = "V16VSBY04F21RE0";      //S     成功    下载记录格式[备用04_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan21Re1 = "V16VSBY04F21RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan21Re2 = "V16VSBY04F21RE2";      //S     成功    下载记录格式[备用04_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用04==字段22==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan221 = "V16VSBY04F22XX1";      //C     [字段22,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,字段17,字段18,字段19,字段20,字段21,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan222 = "V16VSBY04F22XX2";      //C     [字段22,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,字段17,字段18,字段19,字段20,字段21,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan22Re0 = "V16VSBY04F22RE0";      //S     成功    下载记录格式[备用04_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan22Re1 = "V16VSBY04F22RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan22Re2 = "V16VSBY04F22RE2";      //S     成功    下载记录格式[备用04_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用04==字段23==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan231 = "V16VSBY04F23XX1";      //C     [字段23,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,字段17,字段18,字段19,字段20,字段21,字段22,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan232 = "V16VSBY04F23XX2";      //C     [字段23,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,字段17,字段18,字段19,字段20,字段21,字段22,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan23Re0 = "V16VSBY04F23RE0";      //S     成功    下载记录格式[备用04_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan23Re1 = "V16VSBY04F23RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan23Re2 = "V16VSBY04F23RE2";      //S     成功    下载记录格式[备用04_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用04==字段24==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan241 = "V16VSBY04F24XX1";      //C     [字段24,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,字段17,字段18,字段19,字段20,字段21,字段22,字段23,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan242 = "V16VSBY04F24XX2";      //C     [字段24,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,字段17,字段18,字段19,字段20,字段21,字段22,字段23,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan24Re0 = "V16VSBY04F24RE0";      //S     成功    下载记录格式[备用04_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan24Re1 = "V16VSBY04F24RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan24Re2 = "V16VSBY04F24RE2";      //S     成功    下载记录格式[备用04_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用04==字段25==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan251 = "V16VSBY04F25XX1";      //C     [字段25,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,字段17,字段18,字段19,字段20,字段21,字段22,字段23,字段24,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan252 = "V16VSBY04F25XX2";      //C     [字段25,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,字段17,字段18,字段19,字段20,字段21,字段22,字段23,字段24,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan25Re0 = "V16VSBY04F25RE0";      //S     成功    下载记录格式[备用04_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan25Re1 = "V16VSBY04F25RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan25Re2 = "V16VSBY04F25RE2";      //S     成功    下载记录格式[备用04_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用04==字段26==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan261 = "V16VSBY04F26XX1";      //C     [字段26,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,字段17,字段18,字段19,字段20,字段21,字段22,字段23,字段24,字段25,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan262 = "V16VSBY04F26XX2";      //C     [字段26,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,字段17,字段18,字段19,字段20,字段21,字段22,字段23,字段24,字段25,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan26Re0 = "V16VSBY04F26RE0";      //S     成功    下载记录格式[备用04_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan26Re1 = "V16VSBY04F26RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan26Re2 = "V16VSBY04F26RE2";      //S     成功    下载记录格式[备用04_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用04==字段27==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan271 = "V16VSBY04F27XX1";      //C     [字段27,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,字段17,字段18,字段19,字段20,字段21,字段22,字段23,字段24,字段25,字段26,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan272 = "V16VSBY04F27XX2";      //C     [字段27,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,字段17,字段18,字段19,字段20,字段21,字段22,字段23,字段24,字段25,字段26,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan27Re0 = "V16VSBY04F27RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan27Re1 = "V16VSBY04F27RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04_ZiDuan27Re2 = "V16VSBY04F27RE2";      //S     成功

    //==VCANS_成品_坯布_标准==备用04==表上传
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04Biao0 = "V16VSBY04BXXXX0";     //C     开始命令
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04Biao1 = "V16VSBY04BXXXX1";     //C     上传记录格式[采集器内部ID,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,字段17,字段18,字段19,字段20,字段21,字段22,字段23,字段24,字段25,字段26,字段27,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04Biao2 = "V16VSBY04BXXXX2";     //C     上传记录格式[采集器内部ID,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,字段17,字段18,字段19,字段20,字段21,字段22,字段23,字段24,字段25,字段26,字段27,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04Biao3 = "V16VSBY04BXXXX3";     //C     请求错误信息继续
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04BiaoRe0 = "V16VSBY04BXXRE0";     //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04BiaoRe1 = "V16VSBY04BXXRE1";     //S     失败     [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04BiaoRe3 = "V16VSBY04BXXRE3";     //S     错误信息 + 错误记录格式[采集器内部ID]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong04BiaoRe5 = "V16VSBY04BXXRE5";     //S     错误记录格式[采集器内部ID]

      /*
  	 * ***********************备用模块05*************************************************************************/


    //==VCANS_成品_坯布_标准==备用05==字段01==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan011 = "V16VSBY05F01XX1";      //C     [字段01,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan012 = "V16VSBY05F01XX2";      //C     [字段01,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan01Re0 = "V16VSBY05F01RE0";      //S     成功    下载记录格式[备用05_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan01Re1 = "V16VSBY05F01RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan01Re2 = "V16VSBY05F01RE2";      //S     成功    下载记录格式[备用05_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用05==字段02==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan021 = "V16VSBY05F02XX1";      //C     [字段02,字段01,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan022 = "V16VSBY05F02XX2";      //C     [字段02,字段01,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan02Re0 = "V16VSBY05F02RE0";      //S     成功    下载记录格式[备用05_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan02Re1 = "V16VSBY05F02RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan02Re2 = "V16VSBY05F02RE2";      //S     成功    下载记录格式[备用05_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用05==字段03==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan031 = "V16VSBY05F03XX1";      //C     [字段03,字段01,字段02,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan032 = "V16VSBY05F03XX2";      //C     [字段03,字段01,字段02,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan03Re0 = "V16VSBY05F03RE0";      //S     成功    下载记录格式[备用05_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan03Re1 = "V16VSBY05F03RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan03Re2 = "V16VSBY05F03RE2";      //S     成功    下载记录格式[备用05_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用05==字段04==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan041 = "V16VSBY05F04XX1";      //C     [字段04,字段01,字段02,字段03,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan042 = "V16VSBY05F04XX2";      //C     [字段04,字段01,字段02,字段03,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan04Re0 = "V16VSBY05F04RE0";      //S     成功    下载记录格式[备用05_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan04Re1 = "V16VSBY05F04RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan04Re2 = "V16VSBY05F04RE2";      //S     成功    下载记录格式[备用05_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用05==字段05==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan051 = "V16VSBY05F05XX1";      //C     [字段05,字段01,字段02,字段03,字段04,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan052 = "V16VSBY05F05XX2";      //C     [字段05,字段01,字段02,字段03,字段04,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan05Re0 = "V16VSBY05F05RE0";      //S     成功    下载记录格式[备用05_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan05Re1 = "V16VSBY05F05RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan05Re2 = "V16VSBY05F05RE2";      //S     成功    下载记录格式[备用05_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用05==字段06==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan061 = "V16VSBY05F06XX1";      //C     [字段06,字段01,字段02,字段03,字段04,字段05,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan062 = "V16VSBY05F06XX2";      //C     [字段06,字段01,字段02,字段03,字段04,字段05,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan06Re0 = "V16VSBY05F06RE0";      //S     成功    下载记录格式[备用05_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan06Re1 = "V16VSBY05F06RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan06Re2 = "V16VSBY05F06RE2";      //S     成功    下载记录格式[备用05_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用05==字段07==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan071 = "V16VSBY05F07XX1";      //C     [字段07,字段01,字段02,字段03,字段04,字段05,字段06,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan072 = "V16VSBY05F07XX2";      //C     [字段07,字段01,字段02,字段03,字段04,字段05,字段06,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan07Re0 = "V16VSBY05F07RE0";      //S     成功    下载记录格式[备用05_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan07Re1 = "V16VSBY05F07RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan07Re2 = "V16VSBY05F07RE2";      //S     成功    下载记录格式[备用05_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用05==字段08==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan081 = "V16VSBY05F08XX1";      //C     [字段08,字段01,字段02,字段03,字段04,字段05,字段06,字段07,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan082 = "V16VSBY05F08XX2";      //C     [字段08,字段01,字段02,字段03,字段04,字段05,字段06,字段07,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan08Re0 = "V16VSBY05F08RE0";      //S     成功    下载记录格式[备用05_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan08Re1 = "V16VSBY05F08RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan08Re2 = "V16VSBY05F08RE2";      //S     成功    下载记录格式[备用05_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用05==字段09==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan091 = "V16VSBY05F09XX1";      //C     [字段09,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan092 = "V16VSBY05F09XX2";      //C     [字段09,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan09Re0 = "V16VSBY05F09RE0";      //S     成功    下载记录格式[备用05_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan09Re1 = "V16VSBY05F09RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan09Re2 = "V16VSBY05F09RE2";      //S     成功    下载记录格式[备用05_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用05==字段10==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan101 = "V16VSBY05F10XX1";      //C     [字段10,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan102 = "V16VSBY05F10XX2";      //C     [字段10,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan10Re0 = "V16VSBY05F10RE0";      //S     成功    下载记录格式[备用05_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan10Re1 = "V16VSBY05F10RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan10Re2 = "V16VSBY05F10RE2";      //S     成功    下载记录格式[备用05_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用05==字段11==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan111 = "V16VSBY05F11XX1";      //C     [字段11,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan112 = "V16VSBY05F11XX2";      //C     [字段11,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan11Re0 = "V16VSBY05F11RE0";      //S     成功    下载记录格式[备用05_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan11Re1 = "V16VSBY05F11RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan11Re2 = "V16VSBY05F11RE2";      //S     成功    下载记录格式[备用05_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用05==字段12==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan121 = "V16VSBY05F12XX1";      //C     [字段12,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan122 = "V16VSBY05F12XX2";      //C     [字段12,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan12Re0 = "V16VSBY05F12RE0";      //S     成功    下载记录格式[备用05_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan12Re1 = "V16VSBY05F12RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan12Re2 = "V16VSBY05F12RE2";      //S     成功    下载记录格式[备用05_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用05==字段13==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan131 = "V16VSBY05F13XX1";      //C     [字段13,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan132 = "V16VSBY05F13XX2";      //C     [字段13,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan13Re0 = "V16VSBY05F13RE0";      //S     成功    下载记录格式[备用05_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan13Re1 = "V16VSBY05F13RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan13Re2 = "V16VSBY05F13RE2";      //S     成功    下载记录格式[备用05_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用05==字段14==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan141 = "V16VSBY05F14XX1";      //C     [字段14,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan142 = "V16VSBY05F14XX2";      //C     [字段14,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan14Re0 = "V16VSBY05F14RE0";      //S     成功    下载记录格式[备用05_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan14Re1 = "V16VSBY05F14RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan14Re2 = "V16VSBY05F14RE2";      //S     成功    下载记录格式[备用05_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用05==字段15==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan151 = "V16VSBY05F15XX1";      //C     [字段15,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan152 = "V16VSBY05F15XX2";      //C     [字段15,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan15Re0 = "V16VSBY05F15RE0";      //S     成功    下载记录格式[备用05_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan15Re1 = "V16VSBY05F15RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan15Re2 = "V16VSBY05F15RE2";      //S     成功    下载记录格式[备用05_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用05==字段16==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan161 = "V16VSBY05F16XX1";      //C     [字段16,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan162 = "V16VSBY05F16XX2";      //C     [字段16,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan16Re0 = "V16VSBY05F16RE0";      //S     成功    下载记录格式[备用05_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan16Re1 = "V16VSBY05F16RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan16Re2 = "V16VSBY05F16RE2";      //S     成功    下载记录格式[备用05_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用05==字段17==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan171 = "V16VSBY05F17XX1";      //C     [字段17,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan172 = "V16VSBY05F17XX2";      //C     [字段17,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan17Re0 = "V16VSBY05F17RE0";      //S     成功    下载记录格式[备用05_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan17Re1 = "V16VSBY05F17RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan17Re2 = "V16VSBY05F17RE2";      //S     成功    下载记录格式[备用05_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用05==字段18==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan181 = "V16VSBY05F18XX1";      //C     [字段18,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,字段17,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan182 = "V16VSBY05F18XX2";      //C     [字段18,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,字段17,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan18Re0 = "V16VSBY05F18RE0";      //S     成功    下载记录格式[备用05_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan18Re1 = "V16VSBY05F18RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan18Re2 = "V16VSBY05F18RE2";      //S     成功    下载记录格式[备用05_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用05==字段19==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan191 = "V16VSBY05F19XX1";      //C     [字段19,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,字段17,字段18,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan192 = "V16VSBY05F19XX2";      //C     [字段19,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,字段17,字段18,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan19Re0 = "V16VSBY05F19RE0";      //S     成功    下载记录格式[备用05_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan19Re1 = "V16VSBY05F19RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan19Re2 = "V16VSBY05F19RE2";      //S     成功    下载记录格式[备用05_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用05==字段20==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan201 = "V16VSBY05F20XX1";      //C     [字段20,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,字段17,字段18,字段19,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan202 = "V16VSBY05F20XX2";      //C     [字段20,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,字段17,字段18,字段19,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan20Re0 = "V16VSBY05F20RE0";      //S     成功    下载记录格式[备用05_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan20Re1 = "V16VSBY05F20RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan20Re2 = "V16VSBY05F20RE2";      //S     成功    下载记录格式[备用05_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用05==字段21==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan211 = "V16VSBY05F21XX1";      //C     [字段21,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,字段17,字段18,字段19,字段20,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan212 = "V16VSBY05F21XX2";      //C     [字段21,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,字段17,字段18,字段19,字段20,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan21Re0 = "V16VSBY05F21RE0";      //S     成功    下载记录格式[备用05_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan21Re1 = "V16VSBY05F21RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan21Re2 = "V16VSBY05F21RE2";      //S     成功    下载记录格式[备用05_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用05==字段22==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan221 = "V16VSBY05F22XX1";      //C     [字段22,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,字段17,字段18,字段19,字段20,字段21,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan222 = "V16VSBY05F22XX2";      //C     [字段22,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,字段17,字段18,字段19,字段20,字段21,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan22Re0 = "V16VSBY05F22RE0";      //S     成功    下载记录格式[备用05_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan22Re1 = "V16VSBY05F22RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan22Re2 = "V16VSBY05F22RE2";      //S     成功    下载记录格式[备用05_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用05==字段23==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan231 = "V16VSBY05F23XX1";      //C     [字段23,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,字段17,字段18,字段19,字段20,字段21,字段22,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan232 = "V16VSBY05F23XX2";      //C     [字段23,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,字段17,字段18,字段19,字段20,字段21,字段22,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan23Re0 = "V16VSBY05F23RE0";      //S     成功    下载记录格式[备用05_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan23Re1 = "V16VSBY05F23RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan23Re2 = "V16VSBY05F23RE2";      //S     成功    下载记录格式[备用05_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用05==字段24==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan241 = "V16VSBY05F24XX1";      //C     [字段24,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,字段17,字段18,字段19,字段20,字段21,字段22,字段23,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan242 = "V16VSBY05F24XX2";      //C     [字段24,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,字段17,字段18,字段19,字段20,字段21,字段22,字段23,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan24Re0 = "V16VSBY05F24RE0";      //S     成功    下载记录格式[备用05_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan24Re1 = "V16VSBY05F24RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan24Re2 = "V16VSBY05F24RE2";      //S     成功    下载记录格式[备用05_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用05==字段25==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan251 = "V16VSBY05F25XX1";      //C     [字段25,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,字段17,字段18,字段19,字段20,字段21,字段22,字段23,字段24,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan252 = "V16VSBY05F25XX2";      //C     [字段25,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,字段17,字段18,字段19,字段20,字段21,字段22,字段23,字段24,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan25Re0 = "V16VSBY05F25RE0";      //S     成功    下载记录格式[备用05_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan25Re1 = "V16VSBY05F25RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan25Re2 = "V16VSBY05F25RE2";      //S     成功    下载记录格式[备用05_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用05==字段26==下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan261 = "V16VSBY05F26XX1";      //C     [字段26,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,字段17,字段18,字段19,字段20,字段21,字段22,字段23,字段24,字段25,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan262 = "V16VSBY05F26XX2";      //C     [字段26,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,字段17,字段18,字段19,字段20,字段21,字段22,字段23,字段24,字段25,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan26Re0 = "V16VSBY05F26RE0";      //S     成功    下载记录格式[备用05_字段n_标题,字段n值]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan26Re1 = "V16VSBY05F26RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan26Re2 = "V16VSBY05F26RE2";      //S     成功    下载记录格式[备用05_字段n_标题,字段n值]

    //==VCANS_成品_坯布_标准==备用05==字段27==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan271 = "V16VSBY05F27XX1";      //C     [字段27,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,字段17,字段18,字段19,字段20,字段21,字段22,字段23,字段24,字段25,字段26,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan272 = "V16VSBY05F27XX2";      //C     [字段27,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,字段17,字段18,字段19,字段20,字段21,字段22,字段23,字段24,字段25,字段26,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan27Re0 = "V16VSBY05F27RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan27Re1 = "V16VSBY05F27RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05_ZiDuan27Re2 = "V16VSBY05F27RE2";      //S     成功

    //==VCANS_成品_坯布_标准==备用05==表上传
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05Biao0 = "V16VSBY05BXXXX0";     //C     开始命令
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05Biao1 = "V16VSBY05BXXXX1";     //C     上传记录格式[采集器内部ID,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,字段17,字段18,字段19,字段20,字段21,字段22,字段23,字段24,字段25,字段26,字段27,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05Biao2 = "V16VSBY05BXXXX2";     //C     上传记录格式[采集器内部ID,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,字段17,字段18,字段19,字段20,字段21,字段22,字段23,字段24,字段25,字段26,字段27,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05Biao3 = "V16VSBY05BXXXX3";     //C     请求错误信息继续
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05BiaoRe0 = "V16VSBY05BXXRE0";     //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05BiaoRe1 = "V16VSBY05BXXRE1";     //S     失败     [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05BiaoRe3 = "V16VSBY05BXXRE3";     //S     错误信息 + 错误记录格式[采集器内部ID]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong05BiaoRe5 = "V16VSBY05BXXRE5";     //S     错误记录格式[采集器内部ID]

    /************************备用模块06*************************************************************************/
    //==VCANS__标准==备用06==字段01==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan011 = "V16VSBY06F01XX1";      //C     [字段01,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan012 = "V16VSBY06F01XX2";      //C     [字段01,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan01Re0 = "V16VSBY06F01RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan01Re1 = "V16VSBY06F01RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan01Re2 = "V16VSBY06F01RE2";      //S     成功

    //==VCANS__标准==备用06==字段02==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan021 = "V16VSBY06F02XX1";      //C     [字段2,字段01,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan022 = "V16VSBY06F02XX2";      //C     [字段2,字段01,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan02Re0 = "V16VSBY06F02RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan02Re1 = "V16VSBY06F02RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan02Re2 = "V16VSBY06F02RE2";      //S     成功

    //==VCANS__标准==备用06==字段03==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan031 = "V16VSBY06F03XX1";      //C     [字段3,字段01,字段02,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan032 = "V16VSBY06F03XX2";      //C     [字段3,字段01,字段02,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan03Re0 = "V16VSBY06F03RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan03Re1 = "V16VSBY06F03RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan03Re2 = "V16VSBY06F03RE2";      //S     成功

    //==VCANS__标准==备用06==字段04==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan041 = "V16VSBY06F04XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan042 = "V16VSBY06F04XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan04Re0 = "V16VSBY06F04RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan04Re1 = "V16VSBY06F04RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan04Re2 = "V16VSBY06F04RE2";      //S     成功

    //==VCANS__标准==备用06==字段05==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan051 = "V16VSBY06F05XX1";      //C     [字段5,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan052 = "V16VSBY06F05XX2";      //C     [字段5,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan05Re0 = "V16VSBY06F05RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan05Re1 = "V16VSBY06F05RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan05Re2 = "V16VSBY06F05RE2";      //S     成功

    //==VCANS__标准==备用06==字段06==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan061 = "V16VSBY06F06XX1";      //C     [字段6,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan062 = "V16VSBY06F06XX2";      //C     [字段6,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan06Re0 = "V16VSBY06F06RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan06Re1 = "V16VSBY06F06RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan06Re2 = "V16VSBY06F06RE2";      //S     成功

    //==VCANS__标准==备用06==字段07==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan071 = "V16VSBY06F07XX1";      //C     [字段7,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan072 = "V16VSBY06F07XX2";      //C     [字段7,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan07Re0 = "V16VSBY06F07RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan07Re1 = "V16VSBY06F07RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan07Re2 = "V16VSBY06F07RE2";      //S     成功

    //==VCANS__标准==备用06==字段08==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan081 = "V16VSBY06F08XX1";      //C     [字段8,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan082 = "V16VSBY06F08XX2";      //C     [字段8,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan08Re0 = "V16VSBY06F08RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan08Re1 = "V16VSBY06F08RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan08Re2 = "V16VSBY06F08RE2";      //S     成功

    //==VCANS__标准==备用06==字段09==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan091 = "V16VSBY06F09XX1";      //C     [字段9,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan092 = "V16VSBY06F09XX2";      //C     [字段9,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan09Re0 = "V16VSBY06F09RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan09Re1 = "V16VSBY06F09RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan09Re2 = "V16VSBY06F09RE2";      //S     成功

    //==VCANS__标准==备用06==字段10==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan101 = "V16VSBY06F10XX1";      //C     [字段10,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan102 = "V16VSBY06F10XX2";      //C     [字段10,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan10Re0 = "V16VSBY06F10RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan10Re1 = "V16VSBY06F10RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan10Re2 = "V16VSBY06F10RE2";      //S     成功
    //==VCANS__标准==备用06==字段11==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan111 = "V16VSBY06F11XX1";      //C     [字段11,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan112 = "V16VSBY06F11XX2";      //C     [字段11,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan11Re0 = "V16VSBY06F11RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan11Re1 = "V16VSBY06F11RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan11Re2 = "V16VSBY06F11RE2";      //S     成功
    //==VCANS__标准==备用06==字段12==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan121 = "V16VSBY06F12XX1";      //C     [字段12,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan122 = "V16VSBY06F12XX2";      //C     [字段12,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan12Re0 = "V16VSBY06F12RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan12Re1 = "V16VSBY06F12RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan12Re2 = "V16VSBY06F12RE2";      //S     成功

    //==VCANS__标准==备用06==字段13==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan131 = "V16VSBY06F13XX1";      //C     [字段13,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan132 = "V16VSBY06F13XX2";      //C     [字段13,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan13Re0 = "V16VSBY06F13RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan13Re1 = "V16VSBY06F13RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan13Re2 = "V16VSBY06F13RE2";      //S     成功

    //==VCANS__标准==备用06==字段14==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan141 = "V16VSBY06F14XX1";      //C     [字段14,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan142 = "V16VSBY06F14XX2";      //C     [字段14,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan14Re0 = "V16VSBY06F14RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan14Re1 = "V16VSBY06F14RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan14Re2 = "V16VSBY06F14RE2";      //S     成功

    //==VCANS__标准==备用06==字段15==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan151 = "V16VSBY06F15XX1";      //C     [字段15,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan152 = "V16VSBY06F15XX2";      //C     [字段15,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan15Re0 = "V16VSBY06F15RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan15Re1 = "V16VSBY06F15RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan15Re2 = "V16VSBY06F15RE2";      //S     成功

    //==VCANS__标准==备用06==字段16==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan161 = "V16VSBY06F16XX1";      //C     [字段16,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan162 = "V16VSBY06F16XX2";      //C     [字段16,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan16Re0 = "V16VSBY06F16RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan16Re1 = "V16VSBY06F16RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan16Re2 = "V16VSBY06F16RE2";      //S     成功

    //==VCANS__标准==备用06==字段17==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan171 = "V16VSBY06F17XX1";      //C     [字段17,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan172 = "V16VSBY06F17XX2";      //C     [字段17,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan17Re0 = "V16VSBY06F17RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan17Re1 = "V16VSBY06F17RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan17Re2 = "V16VSBY06F17RE2";      //S     成功

    //==VCANS__标准==备用06==字段18==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan181 = "V16VSBY06F18XX1";      //C     [字段18,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan182 = "V16VSBY06F18XX2";      //C     [字段18,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan18Re0 = "V16VSBY06F18RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan18Re1 = "V16VSBY06F18RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan18Re2 = "V16VSBY06F18RE2";      //S     成功

    //==VCANS__标准==备用06==字段19==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan191 = "V16VSBY06F19XX1";      //C     [字段19,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan192 = "V16VSBY06F19XX2";      //C     [字段19,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan19Re0 = "V16VSBY06F19RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan19Re1 = "V16VSBY06F19RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan19Re2 = "V16VSBY06F19RE2";      //S     成功

    //==VCANS__标准==备用06==字段20==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan201 = "V16VSBY06F20XX1";      //C     [字段20,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan202 = "V16VSBY06F20XX2";      //C     [字段20,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan20Re0 = "V16VSBY06F20RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan20Re1 = "V16VSBY06F20RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan20Re2 = "V16VSBY06F20RE2";      //S     成功

    //==VCANS__标准==备用06==字段21==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan211 = "V16VSBY06F21XX1";      //C     [字段21,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan212 = "V16VSBY06F21XX2";      //C     [字段21,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan21Re0 = "V16VSBY06F21RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan21Re1 = "V16VSBY06F21RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan21Re2 = "V16VSBY06F21RE2";      //S     成功

    //==VCANS__标准==备用06==字段22==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan221 = "V16VSBY06F22XX1";      //C     [字段22,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan222 = "V16VSBY06F22XX2";      //C     [字段22,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan22Re0 = "V16VSBY06F22RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan22Re1 = "V16VSBY06F22RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan22Re2 = "V16VSBY06F22RE2";      //S     成功

    //==VCANS__标准==备用06==字段23==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan231 = "V16VSBY06F23XX1";      //C     [字段23,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan232 = "V16VSBY06F23XX2";      //C     [字段23,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan23Re0 = "V16VSBY06F23RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan23Re1 = "V16VSBY06F23RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan23Re2 = "V16VSBY06F23RE2";      //S     成功

    //==VCANS__标准==备用06==字段24==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan241 = "V16VSBY06F24XX1";      //C     [字段24,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan242 = "V16VSBY06F24XX2";      //C     [字段24,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan24Re0 = "V16VSBY06F24RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan24Re1 = "V16VSBY06F24RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan24Re2 = "V16VSBY06F24RE2";      //S     成功

    //==VCANS__标准==备用06==字段25==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan251 = "V16VSBY06F25XX1";      //C     [字段25,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan252 = "V16VSBY06F25XX2";      //C     [字段25,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan25Re0 = "V16VSBY06F25RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan25Re1 = "V16VSBY06F25RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan25Re2 = "V16VSBY06F25RE2";      //S     成功

    //==VCANS__标准==备用06==字段26==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan261 = "V16VSBY06F26XX1";      //C     [字段26,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan262 = "V16VSBY06F26XX2";      //C     [字段26,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan26Re0 = "V16VSBY06F26RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan26Re1 = "V16VSBY06F26RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan26Re2 = "V16VSBY06F26RE2";      //S     成功

    //==VCANS_成品_坯布_标准==备用06==表上传
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06Biao0 = "V16VSBY06BXXXX0";     //C     开始命令
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06Biao1 = "V16VSBY06BXXXX1";     //C     上传记录格式[采集器内部ID,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,字段17,字段18,字段19,字段20,字段21,字段22,字段23,字段24,字段25,字段26,字段27,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06Biao2 = "V16VSBY06BXXXX2";     //C     上传记录格式[采集器内部ID,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,字段17,字段18,字段19,字段20,字段21,字段22,字段23,字段24,字段25,字段26,字段27,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06Biao3 = "V16VSBY06BXXXX3";     //C     请求错误信息继续
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06BiaoRe0 = "V16VSBY06BXXRE0";     //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06BiaoRe1 = "V16VSBY06BXXRE1";     //S     失败     [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06BiaoRe3 = "V16VSBY06BXXRE3";     //S     错误信息 + 错误记录格式[采集器内部ID]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06BiaoRe5 = "V16VSBY06BXXRE5";     //S     错误记录格式[采集器内部ID]


    /************************备用模块08*************************************************************************/

    //==VCANS__标准==备用08==字段01==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan011 = "V16VSBY08F01XX1";      //C     [字段01,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan012 = "V16VSBY08F01XX2";      //C     [字段01,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan01Re0 = "V16VSBY08F01RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan01Re1 = "V16VSBY08F01RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan01Re2 = "V16VSBY08F01RE2";      //S     成功

    //==VCANS__标准==备用08==字段02==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan021 = "V16VSBY08F02XX1";      //C     [字段2,字段01,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan022 = "V16VSBY08F02XX2";      //C     [字段2,字段01,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan02Re0 = "V16VSBY08F02RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan02Re1 = "V16VSBY08F02RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan02Re2 = "V16VSBY08F02RE2";      //S     成功

    //==VCANS__标准==备用08==字段03==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan031 = "V16VSBY08F03XX1";      //C     [字段3,字段01,字段02,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan032 = "V16VSBY08F03XX2";      //C     [字段3,字段01,字段02,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan03Re0 = "V16VSBY08F03RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan03Re1 = "V16VSBY08F03RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan03Re2 = "V16VSBY08F03RE2";      //S     成功

    //==VCANS__标准==备用08==字段04==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan041 = "V16VSBY08F04XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan042 = "V16VSBY08F04XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan04Re0 = "V16VSBY08F04RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan04Re1 = "V16VSBY08F04RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan04Re2 = "V16VSBY08F04RE2";      //S     成功

    //==VCANS__标准==备用08==字段05==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan051 = "V16VSBY08F05XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan052 = "V16VSBY08F05XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan05Re0 = "V16VSBY08F05RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan05Re1 = "V16VSBY08F05RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan05Re2 = "V16VSBY08F05RE2";      //S     成功

    //==VCANS__标准==备用08==字段06==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan061 = "V16VSBY08F06XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan062 = "V16VSBY08F06XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan06Re0 = "V16VSBY08F06RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan06Re1 = "V16VSBY08F06RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan06Re2 = "V16VSBY08F06RE2";      //S     成功

    //==VCANS__标准==备用08==字段07==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan071 = "V16VSBY08F07XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan072 = "V16VSBY08F07XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan07Re0 = "V16VSBY08F07RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan07Re1 = "V16VSBY08F07RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan07Re2 = "V16VSBY08F07RE2";      //S     成功

    //==VCANS__标准==备用08==字段08==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan081 = "V16VSBY08F08XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan082 = "V16VSBY08F08XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan08Re0 = "V16VSBY08F08RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan08Re1 = "V16VSBY08F08RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan08Re2 = "V16VSBY08F08RE2";      //S     成功

    //==VCANS__标准==备用08==字段09==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan091 = "V16VSBY08F09XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan092 = "V16VSBY08F09XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan09Re0 = "V16VSBY08F09RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan09Re1 = "V16VSBY08F09RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan09Re2 = "V16VSBY08F09RE2";      //S     成功

    //==VCANS__标准==备用08==字段10==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan101 = "V16VSBY08F10XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan102 = "V16VSBY08F10XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan10Re0 = "V16VSBY08F10RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan10Re1 = "V16VSBY87F10RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan10Re2 = "V16VSBY08F10RE2";      //S     成功
    //==VCANS__标准==备用08==字段11==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan111 = "V16VSBY08F11XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan112 = "V16VSBY08F11XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan11Re0 = "V16VSBY08F11RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan11Re1 = "V16VSBY08F11RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan11Re2 = "V16VSBY08F11RE2";      //S     成功
    //==VCANS__标准==备用08==字段12==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan121 = "V16VSBY08F12XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan122 = "V16VSBY08F12XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan12Re0 = "V16VSBY08F12RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan12Re1 = "V16VSBY08F12RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan12Re2 = "V16VSBY08F12RE2";      //S     成功

    //==VCANS__标准==备用08==字段13==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan131 = "V16VSBY08F13XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan132 = "V16VSBY08F13XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan13Re0 = "V16VSBY08F13RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan13Re1 = "V16VSBY08F13RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan13Re2 = "V16VSBY08F13RE2";      //S     成功

    //==VCANS__标准==备用08==字段14==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan141 = "V16VSBY08F14XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan142 = "V16VSBY08F14XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan14Re0 = "V16VSBY08F14RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan14Re1 = "V16VSBY08F14RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan14Re2 = "V16VSBY08F14RE2";      //S     成功

    //==VCANS__标准==备用08==字段15==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan151 = "V16VSBY08F15XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan152 = "V16VSBY08F15XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan15Re0 = "V16VSBY08F15RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan15Re1 = "V16VSBY08F15RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan15Re2 = "V16VSBY08F15RE2";      //S     成功

    //==VCANS__标准==备用08==字段16==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan161 = "V16VSBY08F16XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan162 = "V16VSBY08F16XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan16Re0 = "V16VSBY08F16RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan16Re1 = "V16VSBY08F16RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan16Re2 = "V16VSBY08F16RE2";      //S     成功

    //==VCANS__标准==备用08==字段17==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan171 = "V16VSBY08F17XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan172 = "V16VSBY08F17XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan17Re0 = "V16VSBY08F17RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan17Re1 = "V16VSBY08F17RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan17Re2 = "V16VSBY08F17RE2";      //S     成功

    //==VCANS__标准==备用08==字段18==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan181 = "V16VSBY08F18XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan182 = "V16VSBY08F18XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan18Re0 = "V16VSBY08F18RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan18Re1 = "V16VSBY08F18RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan18Re2 = "V16VSBY08F18RE2";      //S     成功

    //==VCANS__标准==备用08==字段19==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan191 = "V16VSBY08F19XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan192 = "V16VSBY08F19XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan19Re0 = "V16VSBY08F19RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan19Re1 = "V16VSBY08F19RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan19Re2 = "V16VSBY08F19RE2";      //S     成功

    //==VCANS__标准==备用08==字段20==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan201 = "V16VSBY08F20XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan202 = "V16VSBY08F20XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan20Re0 = "V16VSBY08F20RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan20Re1 = "V16VSBY08F20RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan20Re2 = "V16VSBY08F20RE2";      //S     成功

    //==VCANS__标准==备用08==字段21==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan211 = "V16VSBY08F21XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan212 = "V16VSBY08F21XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan21Re0 = "V16VSBY08F21RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan21Re1 = "V16VSBY08F21RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan21Re2 = "V16VSBY08F21RE2";      //S     成功

    //==VCANS__标准==备用08==字段22==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan221 = "V16VSBY08F22XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan222 = "V16VSBY08F22XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan22Re0 = "V16VSBY08F22RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan22Re1 = "V16VSBY08F22RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan22Re2 = "V16VSBY08F22RE2";      //S     成功

    //==VCANS__标准==备用08==字段23==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan231 = "V16VSBY08F23XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan232 = "V16VSBY08F23XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan23Re0 = "V16VSBY08F23RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan23Re1 = "V16VSBY08F23RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan23Re2 = "V16VSBY08F23RE2";      //S     成功

    //==VCANS__标准==备用08==字段24==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan241 = "V16VSBY08F24XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan242 = "V16VSBY08F24XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan24Re0 = "V16VSBY08F24RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan24Re1 = "V16VSBY08F24RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan24Re2 = "V16VSBY08F24RE2";      //S     成功

    //==VCANS__标准==备用08==字段25==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan251 = "V16VSBY08F25XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan252 = "V16VSBY08F25XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan25Re0 = "V16VSBY08F25RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan25Re1 = "V16VSBY08F25RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan25Re2 = "V16VSBY08F25RE2";      //S     成功

    //==VCANS__标准==备用08==字段26==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan261 = "V16VSBY08F26XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan262 = "V16VSBY08F26XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan26Re0 = "V16VSBY08F26RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan26Re1 = "V16VSBY08F26RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan26Re2 = "V16VSBY08F26RE2";      //S     成功

    //==VCANS_成品_坯布_标准==备用08==表上传
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08Biao0 = "V16VSBY08BXXXX0";     //C     开始命令
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08Biao1 = "V16VSBY08BXXXX1";     //C     上传记录格式[采集器内部ID,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,字段17,字段18,字段19,字段20,字段21,字段22,字段23,字段24,字段25,字段26,字段27,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08Biao2 = "V16VSBY08BXXXX2";     //C     上传记录格式[采集器内部ID,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,字段17,字段18,字段19,字段20,字段21,字段22,字段23,字段24,字段25,字段26,字段27,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08Biao3 = "V16VSBY08BXXXX3";     //C     请求错误信息继续
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08BiaoRe0 = "V16VSBY08BXXRE0";     //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08BiaoRe1 = "V16VSBY08BXXRE1";     //S     失败     [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08BiaoRe3 = "V16VSBY08BXXRE3";     //S     错误信息 + 错误记录格式[采集器内部ID]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08BiaoRe5 = "V16VSBY08BXXRE5";     //S     错误记录格式[采集器内部ID]


    /************************备用模块09*************************************************************************/

    //==VCANS__标准==备用09==字段01==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan011 = "V16VSBY09F01XX1";      //C     [字段01,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan012 = "V16VSBY09F01XX2";      //C     [字段01,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan01Re0 = "V16VSBY09F01RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan01Re1 = "V16VSBY09F01RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan01Re2 = "V16VSBY09F01RE2";      //S     成功

    //==VCANS__标准==备用09==字段02==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan021 = "V16VSBY09F02XX1";      //C     [字段2,字段01,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan022 = "V16VSBY09F02XX2";      //C     [字段2,字段01,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan02Re0 = "V16VSBY09F02RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan02Re1 = "V16VSBY09F02RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan02Re2 = "V16VSBY09F02RE2";      //S     成功

    //==VCANS__标准==备用09==字段03==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan031 = "V16VSBY09F03XX1";      //C     [字段3,字段01,字段02,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan032 = "V16VSBY09F03XX2";      //C     [字段3,字段01,字段02,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan03Re0 = "V16VSBY09F03RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan03Re1 = "V16VSBY09F03RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan03Re2 = "V16VSBY09F03RE2";      //S     成功

    //==VCANS__标准==备用09==字段04==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan041 = "V16VSBY09F04XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan042 = "V16VSBY09F04XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan04Re0 = "V16VSBY09F04RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan04Re1 = "V16VSBY09F04RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan04Re2 = "V16VSBY09F04RE2";      //S     成功

    //==VCANS__标准==备用09==字段05==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan051 = "V16VSBY09F05XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan052 = "V16VSBY09F05XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan05Re0 = "V16VSBY09F05RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan05Re1 = "V16VSBY09F05RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan05Re2 = "V16VSBY09F05RE2";      //S     成功

    //==VCANS__标准==备用09==字段06==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan061 = "V16VSBY09F06XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan062 = "V16VSBY09F06XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan06Re0 = "V16VSBY09F06RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan06Re1 = "V16VSBY09F06RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan06Re2 = "V16VSBY09F06RE2";      //S     成功

    //==VCANS__标准==备用09==字段07==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan071 = "V16VSBY09F07XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan072 = "V16VSBY09F07XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan07Re0 = "V16VSBY09F07RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan07Re1 = "V16VSBY09F07RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan07Re2 = "V16VSBY09F07RE2";      //S     成功

    //==VCANS__标准==备用09==字段08==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan081 = "V16VSBY09F08XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan082 = "V16VSBY09F08XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan08Re0 = "V16VSBY09F08RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan08Re1 = "V16VSBY09F08RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan08Re2 = "V16VSBY09F08RE2";      //S     成功

    //==VCANS__标准==备用09==字段09==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan091 = "V16VSBY09F09XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan092 = "V16VSBY09F09XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan09Re0 = "V16VSBY09F09RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan09Re1 = "V16VSBY09F09RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan09Re2 = "V16VSBY09F09RE2";      //S     成功

    //==VCANS__标准==备用09==字段10==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan101 = "V16VSBY09F10XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan102 = "V16VSBY09F10XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan10Re0 = "V16VSBY09F10RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan10Re1 = "V16VSBY09F10RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan10Re2 = "V16VSBY09F10RE2";      //S     成功
    //==VCANS__标准==备用09==字段11==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan111 = "V16VSBY09F11XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan112 = "V16VSBY09F11XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan11Re0 = "V16VSBY09F11RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan11Re1 = "V16VSBY09F11RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan11Re2 = "V16VSBY09F11RE2";      //S     成功
    //==VCANS__标准==备用09==字段12=
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan121 = "V16VSBY09F12XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan122 = "V16VSBY09F12XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan12Re0 = "V16VSBY09F12RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan12Re1 = "V16VSBY096F12RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan12Re2 = "V16VSBY09F12RE2";      //S     成功

    //==VCANS__标准==备用09==字段13==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan131 = "V16VSBY09F13XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan132 = "V16VSBY09F13XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan13Re0 = "V16VSBY09F13RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan13Re1 = "V16VSBY09F13RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan13Re2 = "V16VSBY09F13RE2";      //S     成功

    //==VCANS__标准==备用09==字段14==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan141 = "V16VSBY09F14XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan142 = "V16VSBY09F14XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan14Re0 = "V16VSBY09F14RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan14Re1 = "V16VSBY09F14RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan14Re2 = "V16VSBY09F14RE2";      //S     成功

    //==VCANS__标准==备用09==字段15==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan151 = "V16VSBY09F15XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan152 = "V16VSBY09F15XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan15Re0 = "V16VSBY09F15RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan15Re1 = "V16VSBY09F15RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan15Re2 = "V16VSBY09F15RE2";      //S     成功

    //==VCANS__标准==备用09==字段16==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan161 = "V16VSBY09F16XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan162 = "V16VSBY09F16XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan16Re0 = "V16VSBY09F16RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan16Re1 = "V16VSBY09F16RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan16Re2 = "V16VSBY09F16RE2";      //S     成功

    //==VCANS__标准==备用09==字段17==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan171 = "V16VSBY09F17XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan172 = "V16VSBY09F17XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan17Re0 = "V16VSBY09F17RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan17Re1 = "V16VSBY09F17RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan17Re2 = "V16VSBY09F17RE2";      //S     成功

    //==VCANS__标准==备用09==字段18==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan181 = "V16VSBY09F18XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan182 = "V16VSBY09F18XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan18Re0 = "V16VSBY09F18RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan18Re1 = "V16VSBY09F18RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan18Re2 = "V16VSBY09F18RE2";      //S     成功

    //==VCANS__标准==备用09==字段19==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan191 = "V16VSBY09F19XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan192 = "V16VSBY09F19XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan19Re0 = "V16VSBY09F19RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan19Re1 = "V16VSBY09F19RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan19Re2 = "V16VSBY09F19RE2";      //S     成功

    //==VCANS__标准==备用09==字段20==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan201 = "V16VSBY09F20XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan202 = "V16VSBY09F20XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan20Re0 = "V16VSBY09F20RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan20Re1 = "V16VSBY09F20RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan20Re2 = "V16VSBY09F20RE2";      //S     成功

    //==VCANS__标准==备用09==字段21==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan211 = "V16VSBY09F21XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan212 = "V16VSBY09F21XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan21Re0 = "V16VSBY09F21RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan21Re1 = "V16VSBY09F21RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan21Re2 = "V16VSBY09F21RE2";      //S     成功

    //==VCANS__标准==备用09==字段22==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan221 = "V16VSBY09F22XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan222 = "V16VSBY09F22XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan22Re0 = "V16VSBY09F22RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan22Re1 = "V16VSBY09F22RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan22Re2 = "V16VSBY09F22RE2";      //S     成功

    //==VCANS__标准==备用09==字段23==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan231 = "V16VSBY09F23XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan232 = "V16VSBY09F23XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan23Re0 = "V16VSBY09F23RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan23Re1 = "V16VSBY09F23RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan23Re2 = "V16VSBY09F23RE2";      //S     成功

    //==VCANS__标准==备用09==字段24==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan241 = "V16VSBY09F24XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan242 = "V16VSBY097F24XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan24Re0 = "V16VSBY09F24RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan24Re1 = "V16VSBY09F24RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan24Re2 = "V16VSBY09F24RE2";      //S     成功

    //==VCANS__标准==备用09==字段25==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan251 = "V16VSBY09F25XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan252 = "V16VSBY09F25XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan25Re0 = "V16VSBY09F25RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan25Re1 = "V16VSBY09F25RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan25Re2 = "V16VSBY09F25RE2";      //S     成功

    //==VCANS__标准==备用09==字段26==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan261 = "V16VSBY09F26XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan262 = "V16VSBY09F26XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan26Re0 = "V16VSBY09F26RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan26Re1 = "V16VSBY09F26RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan26Re2 = "V16VSBY09F26RE2";      //S     成功

    //==VCANS_成品_坯布_标准==备用09==表上传
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09Biao0 = "V16VSBY09BXXXX0";     //C     开始命令
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09Biao1 = "V16VSBY09BXXXX1";     //C     上传记录格式[采集器内部ID,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,字段17,字段18,字段19,字段20,字段21,字段22,字段23,字段24,字段25,字段26,字段27,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09Biao2 = "V16VSBY09BXXXX2";     //C     上传记录格式[采集器内部ID,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,字段17,字段18,字段19,字段20,字段21,字段22,字段23,字段24,字段25,字段26,字段27,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09Biao3 = "V16VSBY09BXXXX3";     //C     请求错误信息继续
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09BiaoRe0 = "V16VSBY09BXXRE0";     //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09BiaoRe1 = "V16VSBY09BXXRE1";     //S     失败     [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09BiaoRe3 = "V16VSBY09BXXRE3";     //S     错误信息 + 错误记录格式[采集器内部ID]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09BiaoRe5 = "V16VSBY09BXXRE5";     //S     错误记录格式[采集器内部ID]


    /************************备用模块10*************************************************************************/

    //==VCANS__标准==备用10==字段01==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan011 = "V16VSBY10F01XX1";      //C     [字段01,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan012 = "V16VSBY10F01XX2";      //C     [字段01,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan01Re0 = "V16VSBY10F01RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan01Re1 = "V16VSBY10F01RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan01Re2 = "V16VSBY10F01RE2";      //S     成功

    //==VCANS__标准==备用10==字段02==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan021 = "V16VSBY10F02XX1";      //C     [字段2,字段01,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan022 = "V16VSBY10F02XX2";      //C     [字段2,字段01,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan02Re0 = "V16VSBY10F02RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan02Re1 = "V16VSBY10F02RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan02Re2 = "V16VSBY10F02RE2";      //S     成功

    //==VCANS__标准==备用10==字段03==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan031 = "V16VSBY10F03XX1";      //C     [字段3,字段01,字段02,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan032 = "V16VSBY10F03XX2";      //C     [字段3,字段01,字段02,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan03Re0 = "V16VSBY10F03RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan03Re1 = "V16VSBY10F03RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan03Re2 = "V16VSBY10F03RE2";      //S     成功

    //==VCANS__标准==备用10==字段04==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan041 = "V16VSBY10F04XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan042 = "V16VSBY10F04XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan04Re0 = "V16VSBY10F04RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan04Re1 = "V16VSBY10F04RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan04Re2 = "V16VSBY10F04RE2";      //S     成功

    //==VCANS__标准==备用10==字段05==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan051 = "V16VSBY10F05XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan052 = "V16VSBY10F05XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan05Re0 = "V16VSBY10F05RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan05Re1 = "V16VSBY10F05RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan05Re2 = "V16VSBY10F05RE2";      //S     成功

    //==VCANS__标准==备用07==字段06==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan061 = "V16VSBY10F06XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan062 = "V16VSBY10F06XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan06Re0 = "V16VSBY01006RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan06Re1 = "V16VSBY10F06RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan06Re2 = "V16VSBY10F06RE2";      //S     成功

    //==VCANS__标准==备用10==字段07==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan071 = "V16VSBY10F07XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan072 = "V16VSBY10F07XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan07Re0 = "V16VSBY10F07RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan07Re1 = "V16VSBY10F07RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan07Re2 = "V16VSBY10F07RE2";      //S     成功

    //==VCANS__标准==备用10==字段08==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan081 = "V16VSBY10F08XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan082 = "V16VSBY10F08XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan08Re0 = "V16VSBY10F08RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan08Re1 = "V16VSBY10F08RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan08Re2 = "V16VSBY10F08RE2";      //S     成功

    //==VCANS__标准==备用10==字段09==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan091 = "V16VSBY10F09XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan092 = "V16VSBY10F09XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan09Re0 = "V16VSBY10F09RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan09Re1 = "V16VSBY10F09RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan09Re2 = "V16VSBY10F09RE2";      //S     成功

    //==VCANS__标准==备用10==字段10==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan101 = "V16VSBY10F10XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan102 = "V16VSBY10F10XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan10Re0 = "V16VSBY10F10RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan10Re1 = "V16VSBY10F10RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan10Re2 = "V16VSBY10F10RE2";      //S     成功
    //==VCANS__标准==备用10==字段11==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan111 = "V16VSBY10F11XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan112 = "V16VSBY10F11XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan11Re0 = "V16VSBY10F11RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan11Re1 = "V16VSBY10F11RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan11Re2 = "V16VSBY10F11RE2";      //S     成功
    //==VCANS__标准==备用10==字段12==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan121 = "V16VSBY10F12XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan122 = "V16VSBY10F12XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan12Re0 = "V16VSBY10F12RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan12Re1 = "V16VSBY106F12RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan12Re2 = "V16VSBY10F12RE2";      //S     成功

    //==VCANS__标准==备用10==字段13==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan131 = "V16VSBY10F13XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan132 = "V16VSBY10F13XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan13Re0 = "V16VSBY10F13RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan13Re1 = "V16VSBY10F13RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan13Re2 = "V16VSBY10F13RE2";      //S     成功

    //==VCANS__标准==备用10==字段14==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan141 = "V16VSBY10F14XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan142 = "V16VSBY10F14XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan14Re0 = "V16VSBY10F14RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan14Re1 = "V16VSBY10F14RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan14Re2 = "V16VSBY10F14RE2";      //S     成功

    //==VCANS__标准==备用10==字段15==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan151 = "V16VSBY10F15XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan152 = "V16VSBY10F15XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan15Re0 = "V16VSBY10F15RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan15Re1 = "V16VSBY10F15RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan15Re2 = "V16VSBY10F15RE2";      //S     成功

    //==VCANS__标准==备用10==字段16==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan161 = "V16VSBY10F16XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan162 = "V16VSBY10F16XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan16Re0 = "V16VSBY10F16RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan16Re1 = "V16VSBY10F16RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan16Re2 = "V16VSBY10F16RE2";      //S     成功

    //==VCANS__标准==备用10==字段17==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan171 = "V16VSBY10F17XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan172 = "V16VSBY10F17XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan17Re0 = "V16VSBY10F17RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan17Re1 = "V16VSBY10F17RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan17Re2 = "V16VSBY10F17RE2";      //S     成功

    //==VCANS__标准==备用10==字段18==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan181 = "V16VSBY10F18XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan182 = "V16VSBY10F18XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan18Re0 = "V16VSBY10F18RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan18Re1 = "V16VSBY10F18RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan18Re2 = "V16VSBY10F18RE2";      //S     成功

    //==VCANS__标准==备用10==字段19==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan191 = "V16VSBY10F19XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan192 = "V16VSBY10F19XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan19Re0 = "V16VSBY10F19RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan19Re1 = "V16VSBY10F19RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan19Re2 = "V16VSBY10F19RE2";      //S     成功

    //==VCANS__标准==备用10==字段20==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan201 = "V16VSBY10F20XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan202 = "V16VSBY10F20XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan20Re0 = "V16VSBY10F20RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan20Re1 = "V16VSBY10F20RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan20Re2 = "V16VSBY10F20RE2";      //S     成功

    //==VCANS__标准==备用10==字段21==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan211 = "V16VSBY10F21XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan212 = "V16VSBY10F21XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan21Re0 = "V16VSBY10F21RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan21Re1 = "V16VSBY10F21RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan21Re2 = "V16VSBY10F21RE2";      //S     成功

    //==VCANS__标准==备用10==字段22==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan221 = "V16VSBY10F22XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan222 = "V16VSBY10F22XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan22Re0 = "V16VSBY10F22RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan22Re1 = "V16VSBY10F22RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan22Re2 = "V16VSBY10F22RE2";      //S     成功

    //==VCANS__标准==备10==字段23==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan231 = "V16VSBY10F23XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan232 = "V16VSBY10F23XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan23Re0 = "V16VSBY10F23RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan23Re1 = "V16VSBY10F23RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan23Re2 = "V16VSBY10F23RE2";      //S     成功

    //==VCANS__标准==备用10==字段24==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan241 = "V16VSBY10F24XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan242 = "V16VSBY10F24XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan24Re0 = "V16VSBY10F24RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan24Re1 = "V16VSBY10F24RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan24Re2 = "V16VSBY10F24RE2";      //S     成功

    //==VCANS__标准==备用10==字段25==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan251 = "V16VSBY10F25XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan252 = "V16VSBY10F25XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan25Re0 = "V16VSBY10F25RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan25Re1 = "V16VSBY10F25RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan25Re2 = "V16VSBY10F25RE2";      //S     成功

    //==VCANS__标准==备用10==字段26==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan261 = "V16VSBY10F26XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan262 = "V16VSBY10F26XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan26Re0 = "V16VSBY10F26RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan26Re1 = "V16VSBY10F26RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan26Re2 = "V16VSBY10F26RE2";      //S     成功

    //==VCANS_成品_坯布_标准==备用10==表上传
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10Biao0 = "V16VSBY10BXXXX0";     //C     开始命令
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10Biao1 = "V16VSBY10BXXXX1";     //C     上传记录格式[采集器内部ID,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,字段17,字段18,字段19,字段20,字段21,字段22,字段23,字段24,字段25,字段26,字段27,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10Biao2 = "V16VSBY10BXXXX2";     //C     上传记录格式[采集器内部ID,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,字段17,字段18,字段19,字段20,字段21,字段22,字段23,字段24,字段25,字段26,字段27,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10Biao3 = "V16VSBY10BXXXX3";     //C     请求错误信息继续
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10BiaoRe0 = "V16VSBY10BXXRE0";     //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10BiaoRe1 = "V16VSBY10BXXRE1";     //S     失败     [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10BiaoRe3 = "V16VSBY10BXXRE3";     //S     错误信息 + 错误记录格式[采集器内部ID]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10BiaoRe5 = "V16VSBY10BXXRE5";     //S     错误记录格式[采集器内部ID]


    /************************备用模块07*************************************************************************/

    //==VCANS__标准==备用07==字段01==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan011 = "V16VSBY07F01XX1";      //C     [字段01,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan012 = "V16VSBY07F01XX2";      //C     [字段01,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan01Re0 = "V16VSBY07F01RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan01Re1 = "V16VSBY07F01RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan01Re2 = "V16VSBY07F01RE2";      //S     成功

    //==VCANS__标准==备用07==字段02==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan021 = "V16VSBY07F02XX1";      //C     [字段2,字段01,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan022 = "V16VSBY07F02XX2";      //C     [字段2,字段01,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan02Re0 = "V16VSBY07F02RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan02Re1 = "V16VSBY07F02RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan02Re2 = "V16VSBY07F02RE2";      //S     成功

    //==VCANS__标准==备用07==字段03==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan031 = "V16VSBY07F03XX1";      //C     [字段3,字段01,字段02,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan032 = "V16VSBY07F03XX2";      //C     [字段3,字段01,字段02,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan03Re0 = "V16VSBY07F03RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan03Re1 = "V16VSBY07F03RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan03Re2 = "V16VSBY07F03RE2";      //S     成功

    //==VCANS__标准==备用07==字段04==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan041 = "V16VSBY07F04XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan042 = "V16VSBY07F04XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan04Re0 = "V16VSBY07F04RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan04Re1 = "V16VSBY07F04RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan04Re2 = "V16VSBY07F04RE2";      //S     成功

    //==VCANS__标准==备用07==字段05==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan051 = "V16VSBY07F05XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan052 = "V16VSBY07F05XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan05Re0 = "V16VSBY07F05RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan05Re1 = "V16VSBY07F05RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan05Re2 = "V16VSBY07F05RE2";      //S     成功

    //==VCANS__标准==备用07==字段06==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan061 = "V16VSBY07F06XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan062 = "V16VSBY07F06XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan06Re0 = "V16VSBY07F06RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan06Re1 = "V16VSBY07F06RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan06Re2 = "V16VSBY07F06RE2";      //S     成功

    //==VCANS__标准==备用07==字段07==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan071 = "V16VSBY07F07XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan072 = "V16VSBY07F07XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan07Re0 = "V16VSBY07F07RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan07Re1 = "V16VSBY07F07RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan07Re2 = "V16VSBY07F07RE2";      //S     成功

    //==VCANS__标准==备用07==字段08==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan081 = "V16VSBY07F08XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan082 = "V16VSBY07F08XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan08Re0 = "V16VSBY07F08RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan08Re1 = "V16VSBY07F08RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan08Re2 = "V16VSBY07F08RE2";      //S     成功

    //==VCANS__标准==备用07==字段09==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan091 = "V16VSBY07F09XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan092 = "V16VSBY07F09XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan09Re0 = "V16VSBY07F09RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan09Re1 = "V16VSBY07F09RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan09Re2 = "V16VSBY07F09RE2";      //S     成功

    //==VCANS__标准==备用07==字段10==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan101 = "V16VSBY07F10XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan102 = "V16VSBY07F10XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan10Re0 = "V16VSBY07F10RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan10Re1 = "V16VSBY07F10RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan10Re2 = "V16VSBY07F10RE2";      //S     成功
    //==VCANS__标准==备用07==字段11==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan111 = "V16VSBY07F11XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan112 = "V16VSBY07F11XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan11Re0 = "V16VSBY07F11RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan11Re1 = "V16VSBY07F11RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan11Re2 = "V16VSBY07F11RE2";      //S     成功
    //==VCANS__标准==备用07==字段12==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan121 = "V16VSBY07F12XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan122 = "V16VSBY07F12XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan12Re0 = "V16VSBY07F12RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan12Re1 = "V16VSBY076F12RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan12Re2 = "V16VSBY07F12RE2";      //S     成功

    //==VCANS__标准==备用07==字段13==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan131 = "V16VSBY07F13XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan132 = "V16VSBY07F13XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan13Re0 = "V16VSBY07F13RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan13Re1 = "V16VSBY07F13RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan13Re2 = "V16VSBY07F13RE2";      //S     成功

    //==VCANS__标准==备用07==字段14==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan141 = "V16VSBY07F14XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan142 = "V16VSBY07F14XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan14Re0 = "V16VSBY07F14RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan14Re1 = "V16VSBY07F14RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan14Re2 = "V16VSBY07F14RE2";      //S     成功

    //==VCANS__标准==备用06==字段15==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan151 = "V16VSBY07F15XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan152 = "V16VSBY07F15XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan15Re0 = "V16VSBY07F15RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan15Re1 = "V16VSBY07F15RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan15Re2 = "V16VSBY07F15RE2";      //S     成功

    //==VCANS__标准==备用06==字段16==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan161 = "V16VSBY07F16XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan162 = "V16VSBY07F16XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan16Re0 = "V16VSBY07F16RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan16Re1 = "V16VSBY07F16RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan16Re2 = "V16VSBY07F16RE2";      //S     成功

    //==VCANS__标准==备用07==字段17==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan171 = "V16VSBY07F17XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan172 = "V16VSBY07F17XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan17Re0 = "V16VSBY07F17RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan17Re1 = "V16VSBY07F17RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan17Re2 = "V16VSBY07F17RE2";      //S     成功

    //==VCANS__标准==备用06==字段18==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan181 = "V16VSBY07F18XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan182 = "V16VSBY07F18XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan18Re0 = "V16VSBY07F18RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan18Re1 = "V16VSBY07F18RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan18Re2 = "V16VSBY07F18RE2";      //S     成功

    //==VCANS__标准==备用07==字段19==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan191 = "V16VSBY07F19XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan192 = "V16VSBY07F19XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan19Re0 = "V16VSBY07F19RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan19Re1 = "V16VSBY07F19RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan19Re2 = "V16VSBY07F19RE2";      //S     成功

    //==VCANS__标准==备用07==字段20==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan201 = "V16VSBY07F20XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan202 = "V16VSBY07F20XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan20Re0 = "V16VSBY07F20RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan20Re1 = "V16VSBY07F20RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan20Re2 = "V16VSBY07F20RE2";      //S     成功

    //==VCANS__标准==备用07==字段21==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan211 = "V16VSBY07F21XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan212 = "V16VSBY07F21XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan21Re0 = "V16VSBY07F21RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan21Re1 = "V16VSBY07F21RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan21Re2 = "V16VSBY07F21RE2";      //S     成功

    //==VCANS__标准==备用07==字段22==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan221 = "V16VSBY07F22XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan222 = "V16VSBY07F22XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan22Re0 = "V16VSBY07F22RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan22Re1 = "V16VSBY07F22RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan22Re2 = "V16VSBY08F22RE2";      //S     成功

    //==VCANS__标准==备用07==字段23==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan231 = "V16VSBY07F23XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan232 = "V16VSBY07F23XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan23Re0 = "V16VSBY07F23RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan23Re1 = "V16VSBY07F23RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan23Re2 = "V16VSBY07F23RE2";      //S     成功

    //==VCANS__标准==备用07==字段24==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan241 = "V16VSBY07F24XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan242 = "V16VSBY07F24XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan24Re0 = "V16VSBY07F24RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan24Re1 = "V16VSBY07F24RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan24Re2 = "V16VSBY07F24RE2";      //S     成功

    //==VCANS__标准==备用07==字段25==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan251 = "V16VSBY07F25XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan252 = "V16VSBY07F25XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan25Re0 = "V16VSBY07F25RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan25Re1 = "V16VSBY07F25RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan25Re2 = "V16VSBY07F25RE2";      //S     成功

    //==VCANS__标准==备用07==字段26==
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan261 = "V16VSBY07F26XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan262 = "V16VSBY07F26XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan26Re0 = "V16VSBY07F26RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan26Re1 = "V16VSBY07F26RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan26Re2 = "V16VSBY07F26RE2";      //S     成功

    //==VCANS_成品_坯布_标准==备用07==表上传
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07Biao0 = "V16VSBY07BXXXX0";     //C     开始命令
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07Biao1 = "V16VSBY07BXXXX1";     //C     上传记录格式[采集器内部ID,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,字段17,字段18,字段19,字段20,字段21,字段22,字段23,字段24,字段25,字段26,字段27,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07Biao2 = "V16VSBY07BXXXX2";     //C     上传记录格式[采集器内部ID,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,字段12,字段13,字段14,字段15,字段16,字段17,字段18,字段19,字段20,字段21,字段22,字段23,字段24,字段25,字段26,字段27,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07Biao3 = "V16VSBY07BXXXX3";     //C     请求错误信息继续
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07BiaoRe0 = "V16VSBY07BXXRE0";     //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07BiaoRe1 = "V16VSBY07BXXRE1";     //S     失败     [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07BiaoRe3 = "V16VSBY07BXXRE3";     //S     错误信息 + 错误记录格式[采集器内部ID]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07BiaoRe5 = "V16VSBY07BXXRE5";     //S     错误记录格式[采集器内部ID]


    /************************备用模块06-10物料信息加载*************************************************************************/

    //==跟单==备用模块06=物料信息下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan1 = "V16VSWl06FXXXX1";      //C     [备用类型][备用数据1][备用数据2][备用辅助资料1编号][备用辅助资料1名称][备用辅助资料2编号][备用辅助资料2名称][备用辅助资料3编号][备用辅助资料3名称][备用辅助资料4编号][备用辅助资料4名称][用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuan2 = "V16VSWl06FXXXX2";      //C     [备用类型][备用数据1][备用数据2][备用辅助资料1编号][备用辅助资料1名称][备用辅助资料2编号][备用辅助资料2名称][备用辅助资料3编号][备用辅助资料3名称][备用辅助资料4编号][备用辅助资料4名称][用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuanRe0 = "V16VSWl06FXXRE0";      //S     成功    下载记录格式[物料编号,物料描述 ,存货描述,存货标志,在库匹数,在库数量,备用1,备用2,备用3,备用4,备用5]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuanRe1 = "V16VSWl06FXXRE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong06_ZiDuanRe2 = "V16VSWl06FXXRE2";      //S     成功   下载记录格式[物料编号,物料描述 ,存货描述,存货标志,在库匹数,在库数量,备用1,备用2,备用3,备用4,备用5]

    //==跟单==备用模块06=物料信息下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan1 = "V16VSWl07FXXXX1";      //C     [备用类型][备用数据1][备用数据2][备用辅助资料1编号][备用辅助资料1名称][备用辅助资料2编号][备用辅助资料2名称][备用辅助资料3编号][备用辅助资料3名称][备用辅助资料4编号][备用辅助资料4名称][用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuan2 = "V16VSWl07FXXXX2";      //C     [备用类型][备用数据1][备用数据2][备用辅助资料1编号][备用辅助资料1名称][备用辅助资料2编号][备用辅助资料2名称][备用辅助资料3编号][备用辅助资料3名称][备用辅助资料4编号][备用辅助资料4名称][用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuanRe0 = "V16VSWl07FXXRE0";      //S     成功    下载记录格式[物料编号,物料描述 ,存货描述,存货标志,在库匹数,在库数量,备用1,备用2,备用3,备用4,备用5]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuanRe1 = "V16VSWl07FXXRE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong07_ZiDuanRe2 = "V16VSWl07FXXRE2";      //S     成功   下载记录格式[物料编号,物料描述 ,存货描述,存货标志,在库匹数,在库数量,备用1,备用2,备用3,备用4,备用5]

    //==跟单==备用模块06=物料信息下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan1 = "V16VSWl08FXXXX1";      //C     [备用类型][备用数据1][备用数据2][备用辅助资料1编号][备用辅助资料1名称][备用辅助资料2编号][备用辅助资料2名称][备用辅助资料3编号][备用辅助资料3名称][备用辅助资料4编号][备用辅助资料4名称][用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuan2 = "V16VSWl08FXXXX2";      //C     [备用类型][备用数据1][备用数据2][备用辅助资料1编号][备用辅助资料1名称][备用辅助资料2编号][备用辅助资料2名称][备用辅助资料3编号][备用辅助资料3名称][备用辅助资料4编号][备用辅助资料4名称][用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuanRe0 = "V16VSWl08FXXRE0";      //S     成功    下载记录格式[物料编号,物料描述 ,存货描述,存货标志,在库匹数,在库数量,备用1,备用2,备用3,备用4,备用5]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuanRe1 = "V16VSWl08FXXRE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong08_ZiDuanRe2 = "V16VSWl08FXXRE2";      //S     成功   下载记录格式[物料编号,物料描述 ,存货描述,存货标志,在库匹数,在库数量,备用1,备用2,备用3,备用4,备用5]

    //==跟单==备用模块06=物料信息下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan1 = "V16VSWl09FXXXX1";      //C     [备用类型][备用数据1][备用数据2][备用辅助资料1编号][备用辅助资料1名称][备用辅助资料2编号][备用辅助资料2名称][备用辅助资料3编号][备用辅助资料3名称][备用辅助资料4编号][备用辅助资料4名称][用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuan2 = "V16VSWl09FXXXX2";      //C     [备用类型][备用数据1][备用数据2][备用辅助资料1编号][备用辅助资料1名称][备用辅助资料2编号][备用辅助资料2名称][备用辅助资料3编号][备用辅助资料3名称][备用辅助资料4编号][备用辅助资料4名称][用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuanRe0 = "V16VSWl09FXXRE0";      //S     成功    下载记录格式[物料编号,物料描述 ,存货描述,存货标志,在库匹数,在库数量,备用1,备用2,备用3,备用4,备用5]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuanRe1 = "V16VSWl09FXXRE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong09_ZiDuanRe2 = "V16VSWl09FXXRE2";      //S     成功   下载记录格式[物料编号,物料描述 ,存货描述,存货标志,在库匹数,在库数量,备用1,备用2,备用3,备用4,备用5]

    //==跟单==备用模块06=物料信息下载
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan1 = "V16VSWl10FXXXX1";      //C     [备用类型][备用数据1][备用数据2][备用辅助资料1编号][备用辅助资料1名称][备用辅助资料2编号][备用辅助资料2名称][备用辅助资料3编号][备用辅助资料3名称][备用辅助资料4编号][备用辅助资料4名称][用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuan2 = "V16VSWl10FXXXX2";      //C     [备用类型][备用数据1][备用数据2][备用辅助资料1编号][备用辅助资料1名称][备用辅助资料2编号][备用辅助资料2名称][备用辅助资料3编号][备用辅助资料3名称][备用辅助资料4编号][备用辅助资料4名称][用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuanRe0 = "V16VSWl10FXXRE0";      //S     成功    下载记录格式[物料编号,物料描述 ,存货描述,存货标志,在库匹数,在库数量,备用1,备用2,备用3,备用4,备用5]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuanRe1 = "V16VSWl10FXXRE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_BeiYong10_ZiDuanRe2 = "V16VSWl10FXXRE2";      //S     成功   下载记录格式[物料编号,物料描述 ,存货描述,存货标志,在库匹数,在库数量,备用1,备用2,备用3,备用4,备用5]


    /************************综合查询1*************************************************************************/

    //VCANS_APP==综合查询01==字段01==
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe01_ZiDuan011 = "V16VSZH01F01XX1";      //C     [字段01,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe01_ZiDuan012 = "V16VSZH01F01XX2";      //C     [字段01,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe01_ZiDuan01Re0 = "V16VSZH01F01RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe01_ZiDuan01Re1 = "V16VSZH01F01RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe01_ZiDuan01Re2 = "V16VSZH01F01RE2";      //S     成功

    //VCANS_APP==综合查询01==字段02==
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe01_ZiDuan021 = "V16VSZH01F02XX1";      //C     [字段2,字段01,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe01_ZiDuan022 = "V16VSZH01F02XX2";      //C     [字段2,字段01,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe01_ZiDuan02Re0 = "V16VSZH01F02RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe01_ZiDuan02Re1 = "V16VSZH01F02RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe01_ZiDuan02Re2 = "V16VSZH01F02RE2";      //S     成功

    //VCANS_APP==综合查询01==字段03==
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe01_ZiDuan031 = "V16VSZH01F03XX1";      //C     [字段3,字段01,字段02,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe01_ZiDuan032 = "V16VSZH01F03XX2";      //C     [字段3,字段01,字段02,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe01_ZiDuan03Re0 = "V16VSZH01F03RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe01_ZiDuan03Re1 = "V16VSZH01F03RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe01_ZiDuan03Re2 = "V16VSZH01F03RE2";      //S     成功

    //VCANS_APP==综合查询01==字段04==
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe01_ZiDuan041 = "V16VSZH01F04XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe01_ZiDuan042 = "V16VSZH01F04XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe01_ZiDuan04Re0 = "V16VSZH01F04RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe01_ZiDuan04Re1 = "V16VSZH01F04RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe01_ZiDuan04Re2 = "V16VSZH01F04RE2";      //S     成功

    //VCANS_APP==综合查询10==字段05==
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe01_ZiDuan051 = "V16VSZH01F05XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe01_ZiDuan052 = "V16VSZH01F05XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe01_ZiDuan05Re0 = "V16VSZH01F05RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe01_ZiDuan05Re1 = "V16VSZH01F05RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe01_ZiDuan05Re2 = "V16VSZH01F05RE2";      //S     成功

    //==VCANS__标准==综合01==字段06==
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe01_ZiDuan061 = "V16VSZH01F06XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe01_ZiDuan062 = "V16VSZH01F06XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe01_ZiDuan06Re0 = "V16VSZH01006RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe01_ZiDuan06Re1 = "V16VSZH01F06RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe01_ZiDuan06Re2 = "V16VSZH01F06RE2";      //S     成功

    //VCANS_APP==综合查询01==字段07==
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe01_ZiDuan071 = "V16VSZH01F07XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe01_ZiDuan072 = "V16VSZH01F07XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe01_ZiDuan07Re0 = "V16VSZH01F07RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe01_ZiDuan07Re1 = "V16VSZH01F07RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe01_ZiDuan07Re2 = "V16VSZH01F07RE2";      //S     成功

    //VCANS_APP==综合查询01==字段08==
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe01_ZiDuan081 = "V16VSZH01F08XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe01_ZiDuan082 = "V16VSZH01F08XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe01_ZiDuan08Re0 = "V16VSZH01F08RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe01_ZiDuan08Re1 = "V16VSZH01F08RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe01_ZiDuan08Re2 = "V16VSZH01F08RE2";      //S     成功

    //VCANS_APP==综合查询01==字段09==
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe01_ZiDuan091 = "V16VSZH01F09XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe01_ZiDuan092 = "V16VSZH01F09XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe01_ZiDuan09Re0 = "V16VSZH01F09RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe01_ZiDuan09Re1 = "V16VSZH01F09RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe01_ZiDuan09Re2 = "V16VSZH01F09RE2";      //S     成功

    //VCANS_APP==综合查询01==字段10==
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe01_ZiDuan101 = "V16VSZH01F10XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe01_ZiDuan102 = "V16VSZH01F10XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe01_ZiDuan10Re0 = "V16VSZH01F10RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe01_ZiDuan10Re1 = "V16VSZH01F10RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe01_ZiDuan10Re2 = "V16VSZH01F10RE2";      //S     成功
    //VCANS_APP==综合查询01==字段11==
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe01_ZiDuan111 = "V16VSZH01F11XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe01_ZiDuan112 = "V16VSZH01F11XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe01_ZiDuan11Re0 = "V16VSZH01F11RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe01_ZiDuan11Re1 = "V16VSZH01F11RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe01_ZiDuan11Re2 = "V16VSZH01F11RE2";      //S     成功
    //VCANS_APP==综合查询01==字段12==
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe01_ZiDuan121 = "V16VSZH01F12XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe01_ZiDuan122 = "V16VSZH01F12XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe01_ZiDuan12Re0 = "V16VSZH01F12RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe01_ZiDuan12Re1 = "V16VSZH01F12RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe01_ZiDuan12Re2 = "V16VSZH01F12RE2";      //S     成功

    //VCANS_APP==综合查询01==查询结果下载
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe01_CX121 = "V16VSZH01C12XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe01_CX122 = "V16VSZH01C12XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe01_CX12Re0 = "V16VSZH01C12RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe01_CX12Re1 = "V16VSZH01C12RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe01_CX12Re2 = "V16VSZH01C12RE2";      //S     成功

    //VCANS_APP==综合查询01==查询结果图片下载
    public static final String m_vfxVAG62VCANSBiaoZhun_PZonHe01_CX121 = "V16VSZH01P12XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_PZonHe01_CX122 = "V16VSZH01P12XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_PZonHe01_CX12Re0 = "V16VSZH01P12RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_PZonHe01_CX12Re1 = "V16VSZH01P12RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_PZonHe01_CX12Re2 = "V16VSZH01P12RE2";      //S     成功


    /************************综合查询2*************************************************************************/

    //VCANS_APP==综合查询02==字段01==
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe02_ZiDuan011 = "V16VSZH02F01XX1";      //C     [字段01,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe02_ZiDuan012 = "V16VSZH02F01XX2";      //C     [字段01,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe02_ZiDuan01Re0 = "V16VSZH02F01RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe02_ZiDuan01Re1 = "V16VSZH02F01RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe02_ZiDuan01Re2 = "V16VSZH02F01RE2";      //S     成功

    //VCANS_APP==综合查询02==字段02==
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe02_ZiDuan021 = "V16VSZH02F02XX1";      //C     [字段2,字段01,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe02_ZiDuan022 = "V16VSZH02F02XX2";      //C     [字段2,字段01,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe02_ZiDuan02Re0 = "V16VSZH02F02RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe02_ZiDuan02Re1 = "V16VSZH02F02RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe02_ZiDuan02Re2 = "V16VSZH02F02RE2";      //S     成功

    //VCANS_APP==综合查询02==字段03==
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe02_ZiDuan031 = "V16VSZH02F03XX1";      //C     [字段3,字段01,字段02,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe02_ZiDuan032 = "V16VSZH02F03XX2";      //C     [字段3,字段01,字段02,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe02_ZiDuan03Re0 = "V16VSZH02F03RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe02_ZiDuan03Re1 = "V16VSZH02F03RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe02_ZiDuan03Re2 = "V16VSZH02F03RE2";      //S     成功

    //VCANS_APP==综合查询02==字段04==
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe02_ZiDuan041 = "V16VSZH02F04XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe02_ZiDuan042 = "V16VSZH02F04XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe02_ZiDuan04Re0 = "V16VSZH02F04RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe02_ZiDuan04Re1 = "V16VSZH02F04RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe02_ZiDuan04Re2 = "V16VSZH02F04RE2";      //S     成功

    //VCANS_APP==综合查询02==字段05==
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe02_ZiDuan051 = "V16VSZH02F05XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe02_ZiDuan052 = "V16VSZH02F05XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe02_ZiDuan05Re0 = "V16VSZH02F05RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe02_ZiDuan05Re1 = "V16VSZH02F05RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe02_ZiDuan05Re2 = "V16VSZH02F05RE2";      //S     成功

    //VCANS_APP==综合查询02==字段06==
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe02_ZiDuan061 = "V16VSZH02F06XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe02_ZiDuan062 = "V16VSZH02F06XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe02_ZiDuan06Re0 = "V16VSZH02006RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe02_ZiDuan06Re1 = "V16VSZH02F06RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe02_ZiDuan06Re2 = "V16VSZH02F06RE2";      //S     成功2
    //VCANS_APP==综合查询02==字段07
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe02_ZiDuan071 = "V16VSZH02F07XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe02_ZiDuan072 = "V16VSZH02F07XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe02_ZiDuan07Re0 = "V16VSZH02F07RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe02_ZiDuan07Re1 = "V16VSZH02F07RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe02_ZiDuan07Re2 = "V16VSZH02F07RE2";      //S     成功

    //VCANS_APP==综合查询02==字段08==
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe02_ZiDuan081 = "V16VSZH02F08XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe02_ZiDuan082 = "V16VSZH02F08XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe02_ZiDuan08Re0 = "V16VSZH02F08RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe02_ZiDuan08Re1 = "V16VSZH02F08RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe02_ZiDuan08Re2 = "V16VSZH02F08RE2";      //S     成功

    //VCANS_APP==综合查询02==字段09==
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe02_ZiDuan091 = "V16VSZH02F09XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe02_ZiDuan092 = "V16VSZH02F09XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe02_ZiDuan09Re0 = "V16VSZH02F09RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe02_ZiDuan09Re1 = "V16VSZH02F09RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe02_ZiDuan09Re2 = "V16VSZH02F09RE2";      //S     成功

    ///VCANS_APP==综合查询02==字段10==
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe02_ZiDuan101 = "V16VSZH02F10XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe02_ZiDuan102 = "V16VSZH02F10XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe02_ZiDuan10Re0 = "V16VSZH02F10RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe02_ZiDuan10Re1 = "V16VSZH02F10RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe02_ZiDuan10Re2 = "V16VSZH02F10RE2";      //S     成功
    //VCANS_APP==综合查询02==字段11=
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe02_ZiDuan111 = "V16VSZH02F11XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe02_ZiDuan112 = "V16VSZH02F11XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe02_ZiDuan11Re0 = "V16VSZH02F11RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe02_ZiDuan11Re1 = "V16VSZH02F11RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe02_ZiDuan11Re2 = "V16VSZH02F11RE2";      //S     成功
    //VCANS_APP==综合查询02==字段12==
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe02_ZiDuan121 = "V16VSZH02F12XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe02_ZiDuan122 = "V16VSZH02F12XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe02_ZiDuan12Re0 = "V16VSZH02F12RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe02_ZiDuan12Re1 = "V16VSZH02F12RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe02_ZiDuan12Re2 = "V16VSZH02F12RE2";      //S     成功

    //VCANS_APP==综合查询02==查询结果下载
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe02_CX121 = "V16VSZH02C12XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe02_CX122 = "V16VSZH02C12XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe02_CX12Re0 = "V16VSZH02C12RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe02_CX12Re1 = "V16VSZH02C12RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe02_CX12Re2 = "V16VSZH02C12RE2";      //S     成功

    //VCANS_APP==综合查询02==查询结果图片下载
    public static final String m_vfxVAG62VCANSBiaoZhun_PZonHe02_CX121 = "V16VSZH02P12XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_PZonHe02_CX122 = "V16VSZH02P12XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_PZonHe02_CX12Re0 = "V16VSZH02P12RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_PZonHe02_CX12Re1 = "V16VSZH02P12RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_PZonHe02_CX12Re2 = "V16VSZH02P12RE2";      //S     成功

    /************************综合查询3*************************************************************************/

    //VCANS_APP==综合查询03==字段01==
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe03_ZiDuan011 = "V16VSZH03F01XX1";      //C     [字段01,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe03_ZiDuan012 = "V16VSZH03F01XX2";      //C     [字段01,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe03_ZiDuan01Re0 = "V16VSZH03F01RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe03_ZiDuan01Re1 = "V16VSZH03F01RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe03_ZiDuan01Re2 = "V16VSZH03F01RE2";      //S     成功3
    //VCANS_APP==综合查询03==字段02=3
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe03_ZiDuan021 = "V16VSZH03F02XX1";      //C     [字段2,字段01,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe03_ZiDuan022 = "V16VSZH03F02XX2";      //C     [字段2,字段01,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe03_ZiDuan02Re0 = "V16VSZH03F02RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe03_ZiDuan02Re1 = "V16VSZH03F02RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe03_ZiDuan02Re2 = "V16VSZH03F02RE2";      //S     成功

    //VCANS_APP==综合查询03==字段03==
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe03_ZiDuan031 = "V16VSZH03F03XX1";      //C     [字段3,字段01,字段02,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe03_ZiDuan032 = "V16VSZH03F03XX2";      //C     [字段3,字段01,字段02,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe03_ZiDuan03Re0 = "V16VSZH03F03RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe03_ZiDuan03Re1 = "V16VSZH03F03RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe03_ZiDuan03Re2 = "V16VSZH03F03RE2";      //S     成功

    //==VCANS__标准==综合03==字段04==
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe03_ZiDuan041 = "V16VSZH03F04XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe03_ZiDuan042 = "V16VSZH03F04XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe03_ZiDuan04Re0 = "V16VSZH03F04RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe03_ZiDuan04Re1 = "V16VSZH03F04RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe03_ZiDuan04Re2 = "V16VSZH03F04RE2";      //S     成功

    //VCANS_APP==综合查询03==字段05==
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe03_ZiDuan051 = "V16VSZH03F05XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe03_ZiDuan052 = "V16VSZH03F05XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe03_ZiDuan05Re0 = "V16VSZH03F05RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe03_ZiDuan05Re1 = "V16VSZH03F05RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe03_ZiDuan05Re2 = "V16VSZH03F05RE2";      //S     成功

    //VCANS_APP==综合查询03==字段06==
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe03_ZiDuan061 = "V16VSZH03F06XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe03_ZiDuan062 = "V16VSZH03F06XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe03_ZiDuan06Re0 = "V16VSZH03F06RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe03_ZiDuan06Re1 = "V16VSZH03F06RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe03_ZiDuan06Re2 = "V16VSZH03F06RE2";      //S     成功2
    //VCANS_APP==综合查询03==字段07
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe03_ZiDuan071 = "V16VSZH03F07XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe03_ZiDuan072 = "V16VSZH03F07XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe03_ZiDuan07Re0 = "V16VSZH03F07RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe03_ZiDuan07Re1 = "V16VSZH03F07RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe03_ZiDuan07Re2 = "V16VSZH03F07RE2";      //S     成功

    //VCANS_APP==综合查询03==字段08==
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe03_ZiDuan081 = "V16VSZH03F08XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe03_ZiDuan082 = "V16VSZH03F08XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe03_ZiDuan08Re0 = "V16VSZH03F08RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe03_ZiDuan08Re1 = "V16VSZH03F08RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe03_ZiDuan08Re2 = "V16VSZH03F08RE2";      //S     成功

    //VCANS_APP==综合查询03==字段09==
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe03_ZiDuan091 = "V16VSZH03F09XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe03_ZiDuan092 = "V16VSZH03F09XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe03_ZiDuan09Re0 = "V16VSZH03F09RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe03_ZiDuan09Re1 = "V16VSZH03F09RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe03_ZiDuan09Re2 = "V16VSZH03F09RE2";      //S     成功3
    //VCANS_APP==综合查询03==字段10==
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe03_ZiDuan101 = "V16VSZH03F10XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe03_ZiDuan102 = "V16VSZH03F10XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe03_ZiDuan10Re0 = "V16VSZH03F10RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe03_ZiDuan10Re1 = "V16VSZH03F10RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe03_ZiDuan10Re2 = "V16VSZH03F10RE2";      //S     成功
    //VCANS_APP==综合查询03==字段11
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe03_ZiDuan111 = "V16VSZH03F11XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe03_ZiDuan112 = "V16VSZH03F11XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe03_ZiDuan11Re0 = "V16VSZH03F11RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe03_ZiDuan11Re1 = "V16VSZH03F11RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe03_ZiDuan11Re2 = "V16VSZH03F11RE2";      //S     成功
    //VCANS_APP==综合查询03==字段12==
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe03_ZiDuan121 = "V16VSZH03F12XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe03_ZiDuan122 = "V16VSZH03F12XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe03_ZiDuan12Re0 = "V16VSZH03F12RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe03_ZiDuan12Re1 = "V16VSZH03F12RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe03_ZiDuan12Re2 = "V16VSZH03F12RE2";      //S     成功

    //VCANS_APP==综合查询03==查询结果下载
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe03_CX121 = "V16VSZH03C12XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe03_CX122 = "V16VSZH03C12XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe03_CX12Re0 = "V16VSZH03C12RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe03_CX12Re1 = "V16VSZH03C12RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe03_CX12Re2 = "V16VSZH03C12RE2";      //S     成功

    //VCANS_APP==综合查询03==查询结果图片下载
    public static final String m_vfxVAG62VCANSBiaoZhun_PZonHe03_CX121 = "V16VSZH03P12XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_PZonHe03_CX122 = "V16VSZH03P12XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_PZonHe03_CX12Re0 = "V16VSZH03P12RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_PZonHe03_CX12Re1 = "V16VSZH03P12RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_PZonHe03_CX12Re2 = "V16VSZH03P12RE2";      //S     成功

    /************************综合查询4*************************************************************************/

    //VCANS_APP==综合查询04==字段01==
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe04_ZiDuan011 = "V16VSZH04F01XX1";      //C     [字段01,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe04_ZiDuan012 = "V16VSZH04F01XX2";      //C     [字段01,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe04_ZiDuan01Re0 = "V16VSZH04F01RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe04_ZiDuan01Re1 = "V16VSZH04F01RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe04_ZiDuan01Re2 = "V16VSZH04F01RE2";      //S     成功3
    ///VCANS_APP==综合查询04==字段02=3
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe04_ZiDuan021 = "V16VSZH04F02XX1";      //C     [字段2,字段01,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe04_ZiDuan022 = "V16VSZH04F02XX2";      //C     [字段2,字段01,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe04_ZiDuan02Re0 = "V16VSZH04F02RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe04_ZiDuan02Re1 = "V16VSZH04F02RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe04_ZiDuan02Re2 = "V16VSZH04F02RE2";      //S     成功

    //VCANS_APP==综合查询04==字段03==
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe04_ZiDuan031 = "V16VSZH04F03XX1";      //C     [字段3,字段01,字段02,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe04_ZiDuan032 = "V16VSZH04F03XX2";      //C     [字段3,字段01,字段02,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe04_ZiDuan03Re0 = "V16VSZH04F03RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe04_ZiDuan03Re1 = "V16VSZH04F03RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe04_ZiDuan03Re2 = "V16VSZH04F03RE2";      //S     成功
    //VCANS_APP==综合查询04==字段04==
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe04_ZiDuan041 = "V16VSZH04F04XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe04_ZiDuan042 = "V16VSZH04F04XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe04_ZiDuan04Re0 = "V16VSZH04F04RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe04_ZiDuan04Re1 = "V16VSZH04F04RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe04_ZiDuan04Re2 = "V16VSZH04F04RE2";      //S     成功

    //VCANS_APP==综合查询04==字段05==
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe04_ZiDuan051 = "V16VSZH04F05XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe04_ZiDuan052 = "V16VSZH04F05XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe04_ZiDuan05Re0 = "V16VSZH04F05RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe04_ZiDuan05Re1 = "V16VSZH04F05RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe04_ZiDuan05Re2 = "V16VSZH04F05RE2";      //S     成功

    //VCANS_APP==综合查询04==字段06==
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe04_ZiDuan061 = "V16VSZH04F06XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe04_ZiDuan062 = "V16VSZH04F06XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe04_ZiDuan06Re0 = "V16VSZH04F06RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe04_ZiDuan06Re1 = "V16VSZH04F06RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe04_ZiDuan06Re2 = "V16VSZH04F06RE2";      //S     成功2
    //VCANS_APP==综合查询04==字段07
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe04_ZiDuan071 = "V16VSZH04F07XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe04_ZiDuan072 = "V16VSZH04F07XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe04_ZiDuan07Re0 = "V16VSZH04F07RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe04_ZiDuan07Re1 = "V16VSZH04F07RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe04_ZiDuan07Re2 = "V16VSZH04F07RE2";      //S     成功

    //VCANS_APP==综合查询04==字段08==
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe04_ZiDuan081 = "V16VSZH04F08XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe04_ZiDuan082 = "V16VSZH04F08XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe04_ZiDuan08Re0 = "V16VSZH04F08RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe04_ZiDuan08Re1 = "V16VSZH04F08RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe04_ZiDuan08Re2 = "V16VSZH04F08RE2";      //S     成功

    //VCANS_APP==综合查询合04==字段09==
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe04_ZiDuan091 = "V16VSZH04F09XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe04_ZiDuan092 = "V16VSZH04F09XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe04_ZiDuan09Re0 = "V16VSZH04F09RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe04_ZiDuan09Re1 = "V16VSZH04F09RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe04_ZiDuan09Re2 = "V16VSZH04F09RE2";      //S     成功3
    //VCANS_APP==综合查询04==字段10==
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe04_ZiDuan101 = "V16VSZH04F10XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe04_ZiDuan102 = "V16VSZH04F10XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe04_ZiDuan10Re0 = "V16VSZH04F10RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe04_ZiDuan10Re1 = "V16VSZH04F10RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe04_ZiDuan10Re2 = "V16VSZH04F10RE2";      //S     成功
    //VCANS_APP==综合查询04==字段11
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe04_ZiDuan111 = "V16VSZH04F11XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe04_ZiDuan112 = "V16VSZH04F11XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe04_ZiDuan11Re0 = "V16VSZH04F11RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe04_ZiDuan11Re1 = "V16VSZH04F11RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe04_ZiDuan11Re2 = "V16VSZH04F11RE2";      //S     成功
    //VCANS_APP==综合查询04==字段12==
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe04_ZiDuan121 = "V16VSZH04F12XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe04_ZiDuan122 = "V16VSZH04F12XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe04_ZiDuan12Re0 = "V16VSZH04F12RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe04_ZiDuan12Re1 = "V16VSZH04F12RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe04_ZiDuan12Re2 = "V16VSZH04F12RE2";      //S     成功

    //VCANS_APP==综合查询04==查询结果下载
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe04_CX121 = "V16VSZH04C12XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe04_CX122 = "V16VSZH04C12XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe04_CX12Re0 = "V16VSZH04C12RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe04_CX12Re1 = "V16VSZH04C12RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe04_CX12Re2 = "V16VSZH04C12RE2";      //S     成功

    //VCANS_APP==综合查询04==查询结果图片下载
    public static final String m_vfxVAG62VCANSBiaoZhun_PZonHe04_CX121 = "V16VSZH04P12XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_PZonHe04_CX122 = "V16VSZH04P12XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_PZonHe04_CX12Re0 = "V16VSZH04P12RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_PZonHe04_CX12Re1 = "V16VSZH04P12RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_PZonHe04_CX12Re2 = "V16VSZH04P12RE2";      //S     成功

    /************************综合查询5*************************************************************************/

    //VCANS_APP==综合查询05==字段01==
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe05_ZiDuan011 = "V16VSZH05F01XX1";      //C     [字段01,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe05_ZiDuan012 = "V16VSZH05F01XX2";      //C     [字段01,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe05_ZiDuan01Re0 = "V16VSZH05F01RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe05_ZiDuan01Re1 = "V16VSZH05F01RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe05_ZiDuan01Re2 = "V16VSZH05F01RE2";      //S     成功3
    //VCANS_APP==综合查询05==字段02=
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe05_ZiDuan021 = "V16VSZH05F02XX1";      //C     [字段2,字段01,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe05_ZiDuan022 = "V16VSZH05F02XX2";      //C     [字段2,字段01,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe05_ZiDuan02Re0 = "V16VSZH05F02RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe05_ZiDuan02Re1 = "V16VSZH05F02RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe05_ZiDuan02Re2 = "V16VSZH05F02RE2";      //S     成功

    //VCANS_APP==综合查询05==字段03==
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe05_ZiDuan031 = "V16VSZH05F03XX1";      //C     [字段3,字段01,字段02,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe05_ZiDuan032 = "V16VSZH05F03XX2";      //C     [字段3,字段01,字段02,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe05_ZiDuan03Re0 = "V16VSZH05F03RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe05_ZiDuan03Re1 = "V16VSZH05F03RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe05_ZiDuan03Re2 = "V16VSZH05F03RE2";      //S     成功
    //VCANS_APP==综合查询05==字段04=
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe05_ZiDuan041 = "V16VSZH05F04XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe05_ZiDuan042 = "V16VSZH05F04XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe05_ZiDuan04Re0 = "V16VSZH05F04RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe05_ZiDuan04Re1 = "V16VSZH05F04RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe05_ZiDuan04Re2 = "V16VSZH05F04RE2";      //S     成功

    //VCANS_APP==综合查询05==字段05==
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe05_ZiDuan051 = "V16VSZH05F05XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe05_ZiDuan052 = "V16VSZH05F05XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe05_ZiDuan05Re0 = "V16VSZH05F05RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe05_ZiDuan05Re1 = "V16VSZH05F05RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe05_ZiDuan05Re2 = "V16VSZH05F05RE2";      //S     成功
    //VCANS_APP==综合查询05==字段06==
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe05_ZiDuan061 = "V16VSZH05F06XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe05_ZiDuan062 = "V16VSZH05F06XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe05_ZiDuan06Re0 = "V16VSZH05F06RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe05_ZiDuan06Re1 = "V16VSZH05F06RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe05_ZiDuan06Re2 = "V16VSZH05F06RE2";      //S     成功2
    //VCANS_APP==综合查询05==字段07
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe05_ZiDuan071 = "V16VSZH05F07XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe05_ZiDuan072 = "V16VSZH05F07XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe05_ZiDuan07Re0 = "V16VSZH05F07RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe05_ZiDuan07Re1 = "V16VSZH05F07RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe05_ZiDuan07Re2 = "V16VSZH05F07RE2";      //S     成功

    //VCANS_APP==综合查询05==字段08==
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe05_ZiDuan081 = "V16VSZH05F08XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe05_ZiDuan082 = "V16VSZH05F08XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe05_ZiDuan08Re0 = "V16VSZH05F08RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe05_ZiDuan08Re1 = "V16VSZH05F08RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe05_ZiDuan08Re2 = "V16VSZH05F08RE2";      //S     成功

    //VCANS_APP==综合查询05==字段09==
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe05_ZiDuan091 = "V16VSZH05F09XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe05_ZiDuan092 = "V16VSZH05F09XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe05_ZiDuan09Re0 = "V16VSZH05F09RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe05_ZiDuan09Re1 = "V16VSZH05F09RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe05_ZiDuan09Re2 = "V16VSZH05F09RE2";      //S     成功3
    //VCANS_APP==综合查询05==字段10=
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe05_ZiDuan101 = "V16VSZH05F10XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe05_ZiDuan102 = "V16VSZH05F10XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe05_ZiDuan10Re0 = "V16VSZH05F10RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe05_ZiDuan10Re1 = "V16VSZH05F10RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe05_ZiDuan10Re2 = "V16VSZH05F10RE2";      //S     成功
    //VCANS_APP==综合查询05==字段11
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe05_ZiDuan111 = "V16VSZH05F11XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe05_ZiDuan112 = "V16VSZH05F11XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe05_ZiDuan11Re0 = "V16VSZH05F11RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe05_ZiDuan11Re1 = "V16VSZH05F11RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe05_ZiDuan11Re2 = "V16VSZH05F11RE2";      //S     成功
    //VCANS_APP==综合查询05==字段12=5
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe05_ZiDuan121 = "V16VSZH05F12XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe05_ZiDuan122 = "V16VSZH05F12XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe05_ZiDuan12Re0 = "V16VSZH05F12RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe05_ZiDuan12Re1 = "V16VSZH05F12RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe05_ZiDuan12Re2 = "V16VSZH05F12RE2";      //S     成功

    //VCANS_APP==综合查询05==查询结果下载
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe05_CX121 = "V16VSZH05C12XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe05_CX122 = "V16VSZH05C12XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe05_CX12Re0 = "V16VSZH05C12RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe05_CX12Re1 = "V16VSZH05C12RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe05_CX12Re2 = "V16VSZH05C12RE2";      //S     成功

    //VCANS_APP==综合查询05==查询结果图片下载
    public static final String m_vfxVAG62VCANSBiaoZhun_PZonHe05_CX121 = "V16VSZH05P12XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_PZonHe05_CX122 = "V16VSZH05P12XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_PZonHe05_CX12Re0 = "V16VSZH05P12RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_PZonHe05_CX12Re1 = "V16VSZH05P12RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_PZonHe05_CX12Re2 = "V16VSZH05P12RE2";      //S     成功

    /************************综合查询6*************************************************************************/

    //VCANS_APP==综合查询06==字段01==
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe06_ZiDuan011 = "V16VSZH06F01XX1";      //C     [字段01,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe06_ZiDuan012 = "V16VSZH06F01XX2";      //C     [字段01,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe06_ZiDuan01Re0 = "V16VSZH06F01RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe06_ZiDuan01Re1 = "V16VSZH06F01RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe06_ZiDuan01Re2 = "V16VSZH06F01RE2";      //S     成功3
    //VCANS_APP==综合查询06==字段02=
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe06_ZiDuan021 = "V16VSZH06F02XX1";      //C     [字段2,字段01,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe06_ZiDuan022 = "V16VSZH06F02XX2";      //C     [字段2,字段01,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe06_ZiDuan02Re0 = "V16VSZH06F02RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe06_ZiDuan02Re1 = "V16VSZH06F02RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe06_ZiDuan02Re2 = "V16VSZH06F02RE2";      //S     成功

    //VCANS_APP==综合查询06==字段03==
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe06_ZiDuan031 = "V16VSZH06F03XX1";      //C     [字段3,字段01,字段02,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe06_ZiDuan032 = "V16VSZH06F03XX2";      //C     [字段3,字段01,字段02,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe06_ZiDuan03Re0 = "V16VSZH06F03RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe06_ZiDuan03Re1 = "V16VSZH06F03RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe06_ZiDuan03Re2 = "V16VSZH06F03RE2";      //S     成功
    //VCANS_APP==综合查询06==字段04=
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe06_ZiDuan041 = "V16VSZH06F04XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe06_ZiDuan042 = "V16VSZH06F04XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe06_ZiDuan04Re0 = "V16VSZH06F04RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe06_ZiDuan04Re1 = "V16VSZH06F04RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe06_ZiDuan04Re2 = "V16VSZH06F04RE2";      //S     成功

    //VCANS_APP==综合查询06==字段05==
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe06_ZiDuan051 = "V16VSZH06F05XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe06_ZiDuan052 = "V16VSZH06F05XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe06_ZiDuan05Re0 = "V16VSZH06F05RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe06_ZiDuan05Re1 = "V16VSZH06F05RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe06_ZiDuan05Re2 = "V16VSZH06F05RE2";      //S     成功
    //VCANS_APP==综合查询06==字段06==
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe06_ZiDuan061 = "V16VSZH06F06XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe06_ZiDuan062 = "V16VSZH06F06XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe06_ZiDuan06Re0 = "V16VSZH06F06RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe06_ZiDuan06Re1 = "V16VSZH06F06RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe06_ZiDuan06Re2 = "V16VSZH06F06RE2";      //S     成功2
    //VCANS_APP==综合查询06==字段07
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe06_ZiDuan071 = "V16VSZH06F07XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe06_ZiDuan072 = "V16VSZH06F07XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe06_ZiDuan07Re0 = "V16VSZH06F07RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe06_ZiDuan07Re1 = "V16VSZH06F07RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe06_ZiDuan07Re2 = "V16VSZH06F07RE2";      //S     成功

    //VCANS_APP==综合查询06==字段08==
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe06_ZiDuan081 = "V16VSZH06F08XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe06_ZiDuan082 = "V16VSZH06F08XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe06_ZiDuan08Re0 = "V16VSZH06F08RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe06_ZiDuan08Re1 = "V16VSZH06F08RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe06_ZiDuan08Re2 = "V16VSZH06F08RE2";      //S     成功

    //VCANS_APP==综合查询06==字段09==
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe06_ZiDuan091 = "V16VSZH06F09XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe06_ZiDuan092 = "V16VSZH06F09XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe06_ZiDuan09Re0 = "V16VSZH06F09RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe06_ZiDuan09Re1 = "V16VSZH06F09RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe06_ZiDuan09Re2 = "V16VSZH06F09RE2";      //S     成功3
    //VCANS_APP==综合查询06==字段10=
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe06_ZiDuan101 = "V16VSZH06F10XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe06_ZiDuan102 = "V16VSZH06F10XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe06_ZiDuan10Re0 = "V16VSZH06F10RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe06_ZiDuan10Re1 = "V16VSZH06F10RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe06_ZiDuan10Re2 = "V16VSZH06F10RE2";      //S     成功
    //VCANS_APP==综合查询06==字段11
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe06_ZiDuan111 = "V16VSZH06F11XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe06_ZiDuan112 = "V16VSZH06F11XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe06_ZiDuan11Re0 = "V16VSZH06F11RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe06_ZiDuan11Re1 = "V16VSZH06F11RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe06_ZiDuan11Re2 = "V16VSZH06F11RE2";      //S     成功
    //VCANS_APP==综合查询06==字段12=5
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe06_ZiDuan121 = "V16VSZH06F12XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe06_ZiDuan122 = "V16VSZH06F12XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe06_ZiDuan12Re0 = "V16VSZH06F12RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe06_ZiDuan12Re1 = "V16VSZH06F12RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe06_ZiDuan12Re2 = "V16VSZH06F12RE2";      //S     成功

    //VCANS_APP==综合查询06==查询结果下载
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe06_CX121 = "V16VSZH06C12XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe06_CX122 = "V16VSZH06C12XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe06_CX12Re0 = "V16VSZH06C12RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe06_CX12Re1 = "V16VSZH06C12RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe06_CX12Re2 = "V16VSZH06C12RE2";      //S     成功

    //VCANS_APP==综合查询06==查询结果图片下载
    public static final String m_vfxVAG62VCANSBiaoZhun_PZonHe06_CX121 = "V16VSZH06P12XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_PZonHe06_CX122 = "V16VSZH06P12XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_PZonHe06_CX12Re0 = "V16VSZH06P12RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_PZonHe06_CX12Re1 = "V16VSZH06P12RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_PZonHe06_CX12Re2 = "V16VSZH06P12RE2";      //S     成功

    /************************综合查询7*************************************************************************/

    //VCANS_APP==综合查询07==字段01==
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe07_ZiDuan011 = "V16VSZH07F01XX1";      //C     [字段01,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe07_ZiDuan012 = "V16VSZH07F01XX2";      //C     [字段01,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe07_ZiDuan01Re0 = "V16VSZH07F01RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe07_ZiDuan01Re1 = "V16VSZH07F01RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe07_ZiDuan01Re2 = "V16VSZH07F01RE2";      //S     成功3
    //VCANS_APP==综合查询07==字段02=
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe07_ZiDuan021 = "V16VSZH07F02XX1";      //C     [字段2,字段01,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe07_ZiDuan022 = "V16VSZH07F02XX2";      //C     [字段2,字段01,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe07_ZiDuan02Re0 = "V16VSZH07F02RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe07_ZiDuan02Re1 = "V16VSZH07F02RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe07_ZiDuan02Re2 = "V16VSZH07F02RE2";      //S     成功

    //VCANS_APP==综合查询07==字段03==
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe07_ZiDuan031 = "V16VSZH07F03XX1";      //C     [字段3,字段01,字段02,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe07_ZiDuan032 = "V16VSZH07F03XX2";      //C     [字段3,字段01,字段02,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe07_ZiDuan03Re0 = "V16VSZH07F03RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe07_ZiDuan03Re1 = "V16VSZH07F03RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe07_ZiDuan03Re2 = "V16VSZH07F03RE2";      //S     成功
    //VCANS_APP==综合查询07==字段04=
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe07_ZiDuan041 = "V16VSZH07F04XX1";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe07_ZiDuan042 = "V16VSZH07F04XX2";      //C     [字段4,字段01,字段02,字段03,,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe07_ZiDuan04Re0 = "V16VSZH07F04RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe07_ZiDuan04Re1 = "V16VSZH07F04RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe07_ZiDuan04Re2 = "V16VSZH07F04RE2";      //S     成功

    //VCANS_APP==综合查询07==字段05==
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe07_ZiDuan051 = "V16VSZH07F05XX1";      //C     [字段5,字段01,字段02,字段03,字段04,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe07_ZiDuan052 = "V16VSZH07F05XX2";      //C     [字段5,字段01,字段02,字段03,字段04,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe07_ZiDuan05Re0 = "V16VSZH07F05RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe07_ZiDuan05Re1 = "V16VSZH07F05RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe07_ZiDuan05Re2 = "V16VSZH07F05RE2";      //S     成功
    //VCANS_APP==综合查询07==字段06==
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe07_ZiDuan061 = "V16VSZH07F06XX1";      //C     [字段6,字段01,字段02,字段03,字段04,字段05,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe07_ZiDuan062 = "V16VSZH07F06XX2";      //C     [字段6,字段01,字段02,字段03,字段04,字段05,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe07_ZiDuan06Re0 = "V16VSZH07F06RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe07_ZiDuan06Re1 = "V16VSZH07F06RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe07_ZiDuan06Re2 = "V16VSZH07F06RE2";      //S     成功2
    //VCANS_APP==综合查询07==字段07
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe07_ZiDuan071 = "V16VSZH07F07XX1";      //C       [字段7,字段01,字段02,字段03,字段04,字段05,字段06,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe07_ZiDuan072 = "V16VSZH07F07XX2";      //C       [字段7,字段01,字段02,字段03,字段04,字段05,字段06,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe07_ZiDuan07Re0 = "V16VSZH07F07RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe07_ZiDuan07Re1 = "V16VSZH07F07RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe07_ZiDuan07Re2 = "V16VSZH07F07RE2";      //S     成功

    //VCANS_APP==综合查询07==字段08==
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe07_ZiDuan081 = "V16VSZH07F08XX1";      //C      [字段8,字段01,字段02,字段03,字段04,字段05,字段06,字段07,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe07_ZiDuan082 = "V16VSZH07F08XX2";      //C      [字段8,字段01,字段02,字段03,字段04,字段05,字段06,字段07,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe07_ZiDuan08Re0 = "V16VSZH07F08RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe07_ZiDuan08Re1 = "V16VSZH07F08RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe07_ZiDuan08Re2 = "V16VSZH07F08RE2";      //S     成功

    //VCANS_APP==综合查询07==字段09==
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe07_ZiDuan091 = "V16VSZH07F09XX1";      //C     [字段9,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe07_ZiDuan092 = "V16VSZH07F09XX2";      //C     [字段9,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe07_ZiDuan09Re0 = "V16VSZH07F09RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe07_ZiDuan09Re1 = "V16VSZH07F09RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe07_ZiDuan09Re2 = "V16VSZH07F09RE2";      //S     成功3
    //VCANS_APP==综合查询07==字段10=
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe07_ZiDuan101 = "V16VSZH07F10XX1";      //C     [字段10,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe07_ZiDuan102 = "V16VSZH07F10XX2";      //C     [字段10,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe07_ZiDuan10Re0 = "V16VSZH07F10RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe07_ZiDuan10Re1 = "V16VSZH07F10RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe07_ZiDuan10Re2 = "V16VSZH07F10RE2";      //S     成功
    //VCANS_APP==综合查询07==字段11
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe07_ZiDuan111 = "V16VSZH07F11XX1";      //C      [字段11,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe07_ZiDuan112 = "V16VSZH07F11XX2";      //C      [字段11,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe07_ZiDuan11Re0 = "V16VSZH07F11RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe07_ZiDuan11Re1 = "V16VSZH07F11RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe07_ZiDuan11Re2 = "V16VSZH07F11RE2";      //S     成功
    //VCANS_APP==综合查询07==字段12=5
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe07_ZiDuan121 = "V16VSZH07F12XX1";      //C      [字段12,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe07_ZiDuan122 = "V16VSZH07F12XX2";      //C      [字段12,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe07_ZiDuan12Re0 = "V16VSZH07F12RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe07_ZiDuan12Re1 = "V16VSZH07F12RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe07_ZiDuan12Re2 = "V16VSZH07F12RE2";      //S     成功

    //VCANS_APP==综合查询07==查询结果下载
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe07_CX121 = "V16VSZH07C12XX1";      //C     [字段01,字段02,字段03,字段4,字段5,字段6,字段7,字段8,字段9,字段10,字段11,字段12,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe07_CX122 = "V16VSZH07C12XX2";      //C     [字段01,字段02,字段03,字段4,字段5,字段6,字段7,字段8,字段9,字段10,字段11,字段12,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe07_CX12Re0 = "V16VSZH07C12RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe07_CX12Re1 = "V16VSZH07C12RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe07_CX12Re2 = "V16VSZH07C12RE2";      //S     成功

    //VCANS_APP==综合查询07==查询结果图片下载
    public static final String m_vfxVAG62VCANSBiaoZhun_PZonHe07_CX121 =   "V16VSZH07P12XX1";       //C     [字段01,字段02,字段03,字段4,字段5,字段6,字段7,字段8,字段9,字段10,字段11,字段12,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_PZonHe07_CX122 =   "V16VSZH07P12XX2";      //C      [字段01,字段02,字段03,字段4,字段5,字段6,字段7,字段8,字段9,字段10,字段11,字段12,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_PZonHe07_CX12Re0 = "V16VSZH07P12RE0";      //S     成功   下载记录格式[物料编号,物料描述 ,存货描述,存货标志,在库匹数,在库数量,备用1,备用2,备用3,备用4,备用5]
    public static final String m_vfxVAG62VCANSBiaoZhun_PZonHe07_CX12Re1 = "V16VSZH07P12RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_PZonHe07_CX12Re2 = "V16VSZH07P12RE2";      //S     成功   下载记录格式[物料编号,物料描述 ,存货描述,存货标志,在库匹数,在库数量,备用1,备用2,备用3,备用4,备用5]

    /************************综合查询8*************************************************************************/

    //VCANS_APP==综合查询08==字段01==
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe08_ZiDuan011 = "V16VSZH08F01XX1";      //C     [字段01,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe08_ZiDuan012 = "V16VSZH08F01XX2";      //C     [字段01,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe08_ZiDuan01Re0 = "V16VSZH08F01RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe08_ZiDuan01Re1 = "V16VSZH08F01RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe08_ZiDuan01Re2 = "V16VSZH08F01RE2";      //S     成功3
    //VCANS_APP==综合查询08==字段02=
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe08_ZiDuan021 = "V16VSZH08F02XX1";      //C     [字段2,字段01,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe08_ZiDuan022 = "V16VSZH08F02XX2";      //C     [字段2,字段01,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe08_ZiDuan02Re0 = "V16VSZH08F02RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe08_ZiDuan02Re1 = "V16VSZH08F02RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe08_ZiDuan02Re2 = "V16VSZH08F02RE2";      //S     成功

    //VCANS_APP==综合查询08==字段03==
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe08_ZiDuan031 = "V16VSZH08F03XX1";      //C     [字段3,字段01,字段02,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe08_ZiDuan032 = "V16VSZH08F03XX2";      //C     [字段3,字段01,字段02,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe08_ZiDuan03Re0 = "V16VSZH08F03RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe08_ZiDuan03Re1 = "V16VSZH08F03RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe08_ZiDuan03Re2 = "V16VSZH08F03RE2";      //S     成功
    //VCANS_APP==综合查询08==字段04=
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe08_ZiDuan041 = "V16VSZH08F04XX1";      //C      [字段4,字段01,字段02,字段03,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe08_ZiDuan042 = "V16VSZH08F04XX2";      //C      [字段4,字段01,字段02,字段03,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe08_ZiDuan04Re0 = "V16VSZH08F04RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe08_ZiDuan04Re1 = "V16VSZH08F04RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe08_ZiDuan04Re2 = "V16VSZH08F04RE2";      //S     成功

    //VCANS_APP==综合查询08==字段05==
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe08_ZiDuan051 = "V16VSZH08F05XX1";      //C     [字段5,字段01,字段02,字段03,字段04,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe08_ZiDuan052 = "V16VSZH08F05XX2";      //C     [字段5,字段01,字段02,字段03,字段04,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe08_ZiDuan05Re0 = "V16VSZH08F05RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe08_ZiDuan05Re1 = "V16VSZH08F05RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe08_ZiDuan05Re2 = "V16VSZH08F05RE2";      //S     成功
    //VCANS_APP==综合查询08==字段06==
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe08_ZiDuan061 = "V16VSZH08F06XX1";      //C     [字段6,字段01,字段02,字段03,字段04,字段05,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe08_ZiDuan062 = "V16VSZH08F06XX2";      //C     [字段6,字段01,字段02,字段03,字段04,字段05,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe08_ZiDuan06Re0 = "V16VSZH08F06RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe08_ZiDuan06Re1 = "V16VSZH08F06RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe08_ZiDuan06Re2 = "V16VSZH08F06RE2";      //S     成功2
    //==VCANS__标准==综合08==字段07
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe08_ZiDuan071 = "V16VSZH08F07XX1";      //C      [字段7,字段01,字段02,字段03,字段04,字段05,字段06,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe08_ZiDuan072 = "V16VSZH08F07XX2";      //C      [字段7,字段01,字段02,字段03,字段04,字段05,字段06,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe08_ZiDuan07Re0 = "V16VSZH08F07RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe08_ZiDuan07Re1 = "V16VSZH08F07RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe08_ZiDuan07Re2 = "V16VSZH08F07RE2";      //S     成功

    //VCANS_APP==综合查询08==字段08==
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe08_ZiDuan081 = "V16VSZH08F08XX1";      //C      [字段8,字段01,字段02,字段03,字段04,字段05,字段06,字段07,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe08_ZiDuan082 = "V16VSZH08F08XX2";      //C      [字段8,字段01,字段02,字段03,字段04,字段05,字段06,字段07,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe08_ZiDuan08Re0 = "V16VSZH08F08RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe08_ZiDuan08Re1 = "V16VSZH08F08RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe08_ZiDuan08Re2 = "V16VSZH08F08RE2";      //S     成功

    //VCANS_APP==综合查询08==字段09==
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe08_ZiDuan091 = "V16VSZH08F09XX1";      //C      [字段9,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe08_ZiDuan092 = "V16VSZH08F09XX2";      //C      [字段9,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe08_ZiDuan09Re0 = "V16VSZH08F09RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe08_ZiDuan09Re1 = "V16VSZH08F09RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe08_ZiDuan09Re2 = "V16VSZH08F09RE2";      //S     成功3
    //VCANS_APP==综合查询08==字段10=
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe08_ZiDuan101 = "V16VSZH08F10XX1";      //C     [字段10,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe08_ZiDuan102 = "V16VSZH08F10XX2";      //C     [字段10,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe08_ZiDuan10Re0 = "V16VSZH08F10RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe08_ZiDuan10Re1 = "V16VSZH08F10RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe08_ZiDuan10Re2 = "V16VSZH08F10RE2";      //S     成功
    //VCANS_APP==综合查询08==字段11
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe08_ZiDuan111 = "V16VSZH08F11XX1";      //C      [字段11,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe08_ZiDuan112 = "V16VSZH08F11XX2";      //C      [字段11,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe08_ZiDuan11Re0 = "V16VSZH08F11RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe08_ZiDuan11Re1 = "V16VSZH08F11RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe08_ZiDuan11Re2 = "V16VSZH08F11RE2";      //S     成功
    //VCANS_APP==综合查询08==字段12
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe08_ZiDuan121 = "V16VSZH08F12XX1";      //C      [字段12,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe08_ZiDuan122 = "V16VSZH08F12XX2";      //C      [字段12,字段01,字段02,字段03,字段04,字段05,字段06,字段07,字段08,字段09,字段10,字段11,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe08_ZiDuan12Re0 = "V16VSZH08F12RE0";      //S     成功
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe08_ZiDuan12Re1 = "V16VSZH08F12RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe08_ZiDuan12Re2 = "V16VSZH08F12RE2";      //S     成功

    //VCANS_APP==综合查询08==查询结果下载
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe08_CX121 = "V16VSZH08C12XX1";      //C      [字段01,字段02,字段03,字段4,字段5,字段6,字段7,字段8,字段9,字段10,字段11,字段12,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe08_CX122 = "V16VSZH08C12XX2";      //C      [字段01,字段02,字段03,字段4,字段5,字段6,字段7,字段8,字段9,字段10,字段11,字段12,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe08_CX12Re0 = "V16VSZH08C12RE0";      //S     成功     下载记录格式[物料编号,物料描述 ,存货描述,存货标志,在库匹数,在库数量,备用1,备用2,备用3,备用4,备用5]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe08_CX12Re1 = "V16VSZH08C12RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_ZonHe08_CX12Re2 = "V16VSZH08C12RE2";      //S     成功     下载记录格式[物料编号,物料描述 ,存货描述,存货标志,在库匹数,在库数量,备用1,备用2,备用3,备用4,备用5]

    //VCANS_APP==综合查询08==查询结果图片下载
    public static final String m_vfxVAG62VCANSBiaoZhun_PZonHe08_CX121 = "V16VSZH08P12XX1";      //C     [字段01,字段02,字段03,字段4,字段5,字段6,字段7,字段8,字段9,字段10,字段11,字段12,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_PZonHe08_CX122 = "V16VSZH08P12XX2";      //C     [字段01,字段02,字段03,字段4,字段5,字段6,字段7,字段8,字段9,字段10,字段11,字段12,用户名]
    public static final String m_vfxVAG62VCANSBiaoZhun_PZonHe08_CX12Re0 = "V16VSZH08P12RE0";      //S     成功    [图片]
    public static final String m_vfxVAG62VCANSBiaoZhun_PZonHe08_CX12Re1 = "V16VSZH08P12RE1";      //S     失败    [失败信息]
    public static final String m_vfxVAG62VCANSBiaoZhun_PZonHe08_CX12Re2 = "V16VSZH08P12RE2";      //S     成功
}

