/**   
  * @Title: RodAndProgressSearcher.java 
  * @Package com.oci.domain.searcher 
  * @Description: TODO(用一句话描述该文件做什么) 
  * @author RicardoShaw
  * @Email  Ricardo_Shaw@outlook.com   
  * @date 2017年6月7日 上午10:03:34 
  * @version V1.0   
*/
package com.oci.domain.searcher;

import java.io.Serializable;

/** 
 * @ClassName: RodAndProgressSearcher 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author RicardoShaw
 * @Email Ricardo_Shaw@outlook.com
 * @date 2017年6月7日 上午10:03:34 
 *  
 */
public class RodAndProgressSearcher implements Serializable{

	/** 
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
	*/ 
	private static final long serialVersionUID = 3234325772512906792L;
	private String RodName;
	private String progressName;
	public String getRodName() {
		return RodName;
	}
	public void setRodName(String rodName) {
		RodName = rodName;
	}
	public String getProgressName() {
		return progressName;
	}
	public void setProgressName(String progressName) {
		this.progressName = progressName;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "RodAndProgressSearcher [RodName=" + RodName + ", progressName="
				+ progressName + "]";
	}
	
	
	
}
