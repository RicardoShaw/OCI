/**   
  * @Title: IntervalSearcher.java 
  * @Package com.oci.domain.searcher 
  * @Description: TODO(用一句话描述该文件做什么) 
  * @author RicardoShaw
  * @Email  Ricardo_Shaw@outlook.com   
  * @date 2017年6月2日 下午8:46:07 
  * @version V1.0   
*/
package com.oci.domain.searcher;

import java.io.Serializable;

/** 
 * @ClassName: IntervalSearcher 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author RicardoShaw
 * @Email Ricardo_Shaw@outlook.com
 * @date 2017年6月2日 下午8:46:07 
 *  
 */
public class IntervalSearcher implements Serializable {

	/** 
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
	*/ 
	private static final long serialVersionUID = -6037886080875135340L;
	private String intervalName;
	private String projectName;
	private String reserve1;
	private String reserve2;
	private String reserve3;
	public String getIntervalName() {
		return intervalName;
	}
	public void setIntervalName(String intervalName) {
		this.intervalName = intervalName;
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
		return "IntervalSearcher [intervalName=" + intervalName
				+ ", projectName=" + projectName + ", reserve1=" + reserve1
				+ ", reserve2=" + reserve2 + ", reserve3=" + reserve3 + "]";
	}
	
	
}
