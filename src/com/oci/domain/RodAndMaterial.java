/**   
  * @Title: RodMaterial.java 
  * @Package com.oci.domain 
  * @Description: TODO(用一句话描述该文件做什么) 
  * @author RicardoShaw
  * @Email  Ricardo_Shaw@outlook.com   
  * @date 2017年5月25日 上午11:26:18 
  * @version V1.0   
*/
package com.oci.domain;

import java.io.Serializable;

/** 
 * @ClassName: RodMaterial 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author RicardoShaw
 * @Email Ricardo_Shaw@outlook.com
 * @date 2017年5月25日 上午11:26:18 
 *  
 */
public class RodAndMaterial implements Serializable {

	/** 
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
	*/ 
	private static final long serialVersionUID = -2397728018154844865L;

	private Integer rodAndMaterialId;
	private Integer rodId;
	private Integer materialId;
	private Integer materialNum;
	private String reserve1;
	private String reserve2;
	private String reserve3;
	public Integer getRodAndMaterialId() {
		return rodAndMaterialId;
	}
	public void setRodAndMaterialId(Integer rodAndMaterialId) {
		this.rodAndMaterialId = rodAndMaterialId;
	}
	public Integer getRodId() {
		return rodId;
	}
	public void setRodId(Integer rodId) {
		this.rodId = rodId;
	}
	public Integer getMaterialId() {
		return materialId;
	}
	public void setMaterialId(Integer materialId) {
		this.materialId = materialId;
	}
	public Integer getMaterialNum() {
		return materialNum;
	}
	public void setMaterialNum(Integer materialNum) {
		this.materialNum = materialNum;
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
		return "RodAndMaterial [rodAndMaterialId=" + rodAndMaterialId
				+ ", rodId=" + rodId + ", materialId=" + materialId
				+ ", materialNum=" + materialNum + ", reserve1=" + reserve1
				+ ", reserve2=" + reserve2 + ", reserve3=" + reserve3 + "]";
	}



}
