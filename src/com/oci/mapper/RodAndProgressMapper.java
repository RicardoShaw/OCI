/**   
  * @Title: RodAndProgressMapper.java 
  * @Package com.oci.mapper 
  * @Description: TODO(用一句话描述该文件做什么) 
  * @author RicardoShaw
  * @Email  Ricardo_Shaw@outlook.com   
  * @date 2017年5月29日 上午10:27:24 
  * @version V1.0   
*/
package com.oci.mapper;

import java.util.List;

import com.oci.domain.RodAndProgress;
import com.oci.domain.searcher.RodAndProgressSearcher;
import com.oci.domain.vo.RodAndProgressVo;

/** 
 * @ClassName: RodAndProgressMapper 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author RicardoShaw
 * @Email Ricardo_Shaw@outlook.com
 * @date 2017年5月29日 上午10:27:24 
 *  
 */
public interface RodAndProgressMapper {
	public List<RodAndProgressVo> findAllRodAndProgressVo();
	public List<RodAndProgressVo> findRodAndProgressVos(RodAndProgressSearcher rodAndProgress);
	public RodAndProgress findRodAndProgress(Integer rodAndProgressId);
	public RodAndProgressVo findRodAndProgressVo(Integer rodAndProgressId);
	
	public void updateRodAndProgress(RodAndProgress rodAndProgress);
	public void insertRodAndProgress(RodAndProgress rodAndProgress);
	public void deleteRodAndProgresss(List<Integer> rodAndProgressIds);
	public void deleteRodAndProgress(Integer rodAndProgressId);
	public void deleteRodAndProgresssByRodId(List<Integer> rodIds);
	public void deleteRodAndProgressByRodId(Integer rodId);
	public void deleteRodAndProgresssByProgressId(List<Integer> progressIds);
	public void deleteRodAndProgressByProgressId(Integer progressId);
	
}
