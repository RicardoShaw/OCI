/**   
  * @Title: IntervalMapper.java 
  * @Package com.oci.mapper 
  * @Description: TODO(用一句话描述该文件做什么) 
  * @author RicardoShaw
  * @Email  Ricardo_Shaw@outlook.com   
  * @date 2017年5月26日 下午3:25:53 
  * @version V1.0   
*/
package com.oci.mapper;

import java.util.List;

import com.oci.domain.Interval;
import com.oci.domain.searcher.IntervalSearcher;
import com.oci.domain.vo.IntervalForOtherVo;
import com.oci.domain.vo.IntervalVo;

/** 
 * @ClassName: IntervalMapper 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author RicardoShaw
 * @Email Ricardo_Shaw@outlook.com
 * @date 2017年5月26日 下午3:25:53 
 *  
 */
public interface IntervalMapper {
	public List<IntervalVo> findAllIntervalVo();
	public List<IntervalVo> findIntervalVos(IntervalSearcher interval);
	public List<IntervalForOtherVo> findAllIntervalForOtherVo();
	
	public List<IntervalForOtherVo> findIntervalForOtherVoByProjectId(Integer projectId);
	public IntervalVo findIntervalVo(Integer intervalId);
	public Interval findInterval(Integer intervalId);
	public IntervalForOtherVo findIntervalForOtherVo(Integer intervalId);
	
	public void updateInterval(Interval interval);
	public void insertInterval(Interval interval);
	public void deleteIntervals(List<Integer> intervalIds);
	public void deleteInterval(Integer intervalId);
	
	public void deleteIntervalByProjectId(Integer projectId);

}
