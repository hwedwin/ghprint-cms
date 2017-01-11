package com.ghprint.cms.utils;

import java.io.Serializable;

/**
 * 执行结果VO.包含结果标识和描述
 *
 */
public class ResultView implements Serializable {
    private int resultCode = 0;//标识 默认为0,表示失败.1为成功
    private String resultDesc;//描述
    /**
     * 操作正确
     */
    public static final int RESULT_SUCCESS = 1;

    /**
     * 操作错误
     */
    public static final int RESULT_FAILURE = 2;
    /**
     *  信息已经被使用
     */
    public static final int ROLE_HAS_USED = 20000;

    public ResultView() {

    }

    public ResultView(int resultCode) {
        this.resultCode = resultCode;
    }

    public ResultView(int resultCode, String resultDesc) {
        this.resultCode = resultCode;
        this.resultDesc = resultDesc;
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultDesc() {
        return resultDesc;
    }

    public void setResultDesc(String resultDesc) {
        this.resultDesc = resultDesc;
    }

    /**
     * Constructs a <code>String</code> with all attributes
     * in name = value format.
     *
     * @return a <code>String</code> representation 
     * of this object.
     */
    @Override
	public String toString() {
        final String TAB = "    ";

        String retValue = "";

        retValue = "ResultView ( " + super.toString() + TAB + "resultCode = "
                + this.resultCode + TAB + "resultDesc = " + this.resultDesc
                + TAB + " )";

        return retValue;
    }

}
