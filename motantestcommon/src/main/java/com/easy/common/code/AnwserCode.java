package com.easy.common.code;

import java.io.Serializable;

/**
 * 1 ~ -1
 * @author Administrator
 *
 */
public class AnwserCode implements Serializable{
    /** 
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
	*/ 
	private static final long serialVersionUID = 1L;
	
	private  int code;
    private  String message;
    
    public AnwserCode(){
    }

    public AnwserCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}
	
	@Override
    public int hashCode(){
		return code;
	}

	public String toString(){
    	return "rtv=" + this.code + "   message=" + this.message;
    }
	

	@Override
	public boolean equals(Object obj) {
		AnwserCode temp = (AnwserCode) obj;
		if( this.getCode() == temp.getCode() ){
			return true;
		}
		
		return false;
	}

	
	



	public static final AnwserCode SUCCESS = new AnwserCode(1, "响应成功");
	
	public static final AnwserCode ERROR = new AnwserCode(-1, "系统繁忙，稍后重试");
	
	public static final AnwserCode APPLICATION_EXCEPTIONS = new AnwserCode(-2, "程序异常");
	
	public static final AnwserCode URL_ERROR = new AnwserCode(-3, "请求url错误");
	
	public static final AnwserCode OP_ERROR = new AnwserCode(-4, "请求op错误");
	
	public static final AnwserCode REQUEST_ILLEGAL = new AnwserCode(-5, "请求非法");
	
	public static final AnwserCode SAVE_FAIL = new AnwserCode(-6, "保存失败");
	
	public static final AnwserCode CASH_INSUFFICIENT = new AnwserCode(-33, "余额不足");
	
	public static final AnwserCode COUNT_ERROR = new  AnwserCode(-7,"总数据量不能超过5万条");
	
	public static final AnwserCode PARAMETER_ERROR = new  AnwserCode(-8,"参数错误");
	
	public static final AnwserCode VERIFICATION_CODE_ERROR = new  AnwserCode(-9,"验证码错误");
	
	public static final AnwserCode BANK_CARD_CHECK_NOT_PASS = new  AnwserCode(-10,"银行卡验证失败");
	
	public static final AnwserCode BIND_CARD_ERROR = new  AnwserCode(-11,"绑卡失败或因重复绑卡");

	public static final AnwserCode EXAMINE_NOT_PASS = new  AnwserCode(-12,"信息未审核或审核中通过不能提现");
	
	public static final AnwserCode NO_HAVE_BIND_CARD= new  AnwserCode(-13,"未绑卡");
	
	public static final AnwserCode DRIVAER_NOT_PASS_AUDIT = new  AnwserCode(-14,"当前账号未通过审核");
	
	public static final AnwserCode PARAMETER_MISS = new  AnwserCode(-15,"必填参数缺失");
	
	public static final AnwserCode LOCATION_ERROR = new AnwserCode(-16, "修改所在地城市区县失败");

	public static final AnwserCode SAVE_ERROR = new AnwserCode(-17, "添加数据失败");
	public static final AnwserCode UPDATE_ERROR = new AnwserCode(-18, "修改数据失败");
	public static final AnwserCode DELETE_ERROR = new AnwserCode(-19, "删除数据失败");
	public static final AnwserCode BUSINESS_NOT_OPEN = new AnwserCode(-20, "该业务暂未开通,不支持呼叫用车.");
	public static final AnwserCode SELECT_NULL = new AnwserCode(-21, "查询为null");
	public static final AnwserCode UPDATE_STATUS_ERROR = new AnwserCode(-22,"修改状态失败");
	public static final AnwserCode DATA_EXIST = new  AnwserCode(-23,"数据已存在");
	public static final AnwserCode ALREADY_UPPERSHELF_EXIST_PRIORITY = new  AnwserCode(-24,"优先级已被未下架的广告占用");
	public static final AnwserCode STAY_UPPERSHELF_EXIST_PRIORITY = new  AnwserCode(-26,"优先级已被待上架的广告占用");
	public static final AnwserCode UNKNOWN_ERROR = new  AnwserCode(-27,"未知错误");
	public static final AnwserCode RPC_DEFINE_ERROR = new  AnwserCode(-28,"RPC接口定义错误");
	public static final AnwserCode ARGS_ERRORS = new AnwserCode(- 29, "参数错误");

	
	public static final AnwserCode BLACKLIST_SECURITY_SYSTEM_NOT_PASS = new  AnwserCode(-110,"公安黑名单系统验证不通过");
	
	public static final AnwserCode UNDEFINED_CAR = new  AnwserCode(-119,"找不到车辆");
	
	public static final AnwserCode UNDEFINED_DRIVER = new  AnwserCode(-120,"找不到司机");
	
	public static final AnwserCode DRIVER_NOT_WALLET= new  AnwserCode(-121,"无司机账户或司机不存在");
	
	public static final AnwserCode DRIVER_COMPANY_QUERY_FAIL= new  AnwserCode(-122,"查询不到机构相关信息");
	
	public static final AnwserCode ACCOUNT_DRIVER_ERROR = new  AnwserCode(-123,"账号为空!");
	
	public static final AnwserCode ACCOUNT_SERI_NOTEXIT_ERROR = new  AnwserCode(-124,"流水不存在!");
	
	public static final AnwserCode ACCOUNT_NOT_SUFFICIENT_FUNDS = new  AnwserCode(-125,"扣款失败,余额不足!");
	
	public static final AnwserCode REFEREESTATUS_ERROR = new  AnwserCode(-126,"推荐系统合伙人级别修改失败!");

	public static final AnwserCode NOT_DATA = new AnwserCode(-127,"数据不存在");
	
	public static final AnwserCode FILE_RECORD_IS_EMPTY = new AnwserCode(-128,"导出文件为空，请重新选择");
	
	public static final AnwserCode INVOICE_HAS_BEEN_PROVIDED = new AnwserCode(-129,"该订单已开发票");

	public static final AnwserCode FASE_VERIFY_EXPIRE = new AnwserCode(-130, "人脸校验过期");

	public static final AnwserCode FORMAT_ERROR = new AnwserCode(-131,"格式错误");
	
	public static final AnwserCode NAME_DUPLICATE = new AnwserCode(-132,"名称重复");

	public static final AnwserCode HTTP_REQUEST_ERROR = new AnwserCode(-133, "http请求错误");

	//分公司
	public static final AnwserCode BRANCH_QRCODE_UPDATE_ERROR = new AnwserCode(-134, "分公司推荐人二维码更新失败");

	public static final AnwserCode DRIVER_VIP_SELECTTIME_LESS = new AnwserCode(-135, "查询时间不合法");

	

	public static final AnwserCode INVOICE_APPLY_ERROR = new AnwserCode(-136,"当前App版本过低，开票失败，建议您升级后重新开票");

	public static final AnwserCode INVOICE_UPDATE_ERROR = new AnwserCode(-137, "发票开具中，无法修改发票信息");

	public static final AnwserCode INVOICE_REVOKE_ERROR = new AnwserCode(-138, "发票开具中，无法撤销开票");

	public static final AnwserCode INVOICE_APPLY_FREQUENT = new AnwserCode(-139,"操作过于频繁，请您稍后再试");

	public static final AnwserCode DRIVERVIP_COUNT_ERROR = new  AnwserCode(-140,"导出数据量超过10w条");
}