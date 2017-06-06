/**   
  * @Title: MaterialSearcher.java 
  * @Package com.oci.domain.searcher 
  * @Description: TODO(用一句话描述该文件做什么) 
  * @author RicardoShaw
  * @Email  Ricardo_Shaw@outlook.com   
  * @date 2017年6月6日 下午11:46:23 
  * @version V1.0   
*/
package com.oci.domain.searcher;

import java.io.Serializable;

/** 
 * @ClassName: MaterialSearcher 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author RicardoShaw
 * @Email Ricardo_Shaw@outlook.com
 * @date 2017年6月6日 下午11:46:23 
 *  
 */
public class MaterialSearcher implements Serializable{

	/** 
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
	*/ 
	private static final long serialVersionUID = 6684441744670476373L;
	
	private String materialName;
	private String materialMake;
	private String materialUnit;
	private String materialTypeName;
	private String materialModel;
	private String reserve1;
	private String reserve2;
	private String reserve3;
	public String getMaterialName() {
		return materialName;
	}
	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}
	public String getMaterialMake() {
		return materialMake;
	}
	public void setMaterialMake(String materialMake) {
		this.materialMake = materialMake;
	}
	public String getMaterialUnit() {
		return materialUnit;
	}
	public void setMaterialUnit(String materialUnit) {
		this.materialUnit = materialUnit;
	}
	public String getMaterialTypeName() {
		return materialTypeName;
	}
	public void setMaterialTypeName(String materialTypeName) {
		this.materialTypeName = materialTypeName;
	}
	public String getMaterialModel() {
		return materialModel;
	}
	public void setMaterialModel(String materialModel) {
		this.materialModel = materialModel;
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
		return "MaterialSearcher [materialName=" + materialName
				+ ", materialMake=" + materialMake + ", materialUnit="
				+ materialUnit + ", materialTypeName=" + materialTypeName
				+ ", materialModel=" + materialModel + ", reserve1=" + reserve1
				+ ", reserve2=" + reserve2 + ", reserve3=" + reserve3 + "]";
	}
	
	

}
