/**   
  * @Title: RodAndMaterialMapper.java 
  * @Package com.oci.mapper 
  * @Description: TODO(用一句话描述该文件做什么) 
  * @author RicardoShaw
  * @Email  Ricardo_Shaw@outlook.com   
  * @date 2017年5月28日 下午11:31:39 
  * @version V1.0   
*/
package com.oci.mapper;

import java.util.List;

import com.oci.domain.RodAndMaterial;
import com.oci.domain.searcher.RodAndMaterialSearcher;
import com.oci.domain.vo.RodAndMaterialVo;

/** 
 * @ClassName: RodAndMaterialMapper 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author RicardoShaw
 * @Email Ricardo_Shaw@outlook.com
 * @date 2017年5月28日 下午11:31:39 
 *  
 */
public interface RodAndMaterialMapper {
	public List<RodAndMaterialVo> findAllRodAndMaterialVo();
	public List<RodAndMaterialVo> findRodAndMaterialVos(RodAndMaterialSearcher rodAndMaterial);
	
	public RodAndMaterial findRodAndMaterial(Integer rodMaterialId);
	public RodAndMaterialVo findRodAndMaterialVo(Integer rodMaterialId);
	
	public void updateRodAndMaterial(RodAndMaterial rodAndMaterial);
	public void insertRodAndMaterial(RodAndMaterial rodAndMaterial);
	public void deleteRodAndMaterials(List<Integer> rodMaterialIds);
	public void deleteRodAndMaterial(Integer rodMaterialId);
	
	public void deleteRodAndMaterialsByRodId(List<Integer> rodIds);
	public void deleteRodAndMaterialByRodId(Integer rodId);
	
	public void deleteRodAndMaterialsByMaterial(List<Integer> materialIds);
	public void deleteRodAndMaterialByMaterial(Integer materialId);
	
	
}
