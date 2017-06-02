/**   
  * @Title: RodVo.java 
  * @Package com.oci.domain.vo 
  * @Description: TODO(用一句话描述该文件做什么) 
  * @author RicardoShaw
  * @Email  Ricardo_Shaw@outlook.com   
  * @date 2017年5月28日 下午6:37:37 
  * @version V1.0   
*/
package com.oci.domain.vo;

import java.io.Serializable;

/** 
 * @ClassName: RodVo 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author RicardoShaw
 * @Email Ricardo_Shaw@outlook.com
 * @date 2017年5月28日 下午6:37:37 
 *  
 */
public class RodVo implements Serializable {

	/** 
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
	*/ 
	private static final long serialVersionUID = 6567185145441585158L;
	private Integer rodId;
	private String rodNo;
	private Integer intervalId;
	private String intervalName;
	private Integer projectId;
	private String projectName;
	private String reserve1;
	private String reserve2;
	private String reserve3;
	public Integer getRodId() {
		return rodId;
	}
	public void setRodId(Integer rodId) {
		this.rodId = rodId;
	}
	public String getRodNo() {
		return rodNo;
	}
	public void setRodNo(String rodNo) {
		this.rodNo = rodNo;
	}
	public Integer getIntervalId() {
		return intervalId;
	}
	public void setIntervalId(Integer intervalId) {
		this.intervalId = intervalId;
	}
	public String getIntervalName() {
		return intervalName;
	}
	public void setIntervalName(String intervalName) {
		this.intervalName = intervalName;
	}
	public Integer getProjectId() {
		return projectId;
	}
	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getReserve1() {
		return reserve1;
	}
	public void setReserve1(String reserve1) {
		this.reserve1 = reserve1;
	}
	public String getReserve2() {
		return reserve2;
	}
	public void setReserve2(String reserve2) {
		this.reserve2 = reserve2;
	}
	public String getReserve3() {
		return reserve3;
	}
	public void setReserve3(String reserve3) {
		this.reserve3 = reserve3;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "RodVo [rodId=" + rodId + ", rodNo=" + rodNo + ", intervalId="
				+ intervalId + ", intervalName=" + intervalName
				+ ", projectId=" + projectId + ", projectName=" + projectName
				+ ", reserve1=" + reserve1 + ", reserve2=" + reserve2
				+ ", reserve3=" + reserve3 + "]";
	}
	
}
