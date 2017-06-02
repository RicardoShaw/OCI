/**   
  * @Title: IntervalServiceImpl.java 
  * @Package com.oci.service 
  * @Description: TODO(用一句话描述该文件做什么) 
  * @author RicardoShaw
  * @Email  Ricardo_Shaw@outlook.com   
  * @date 2017年5月26日 下午4:42:56 
  * @version V1.0   
*/
package com.oci.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oci.dao.IntervalDAO;
import com.oci.domain.Interval;
import com.oci.domain.searcher.IntervalSearcher;
import com.oci.domain.vo.IntervalForOtherVo;
import com.oci.domain.vo.IntervalVo;

/** 
 * @ClassName: IntervalServiceImpl 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author RicardoShaw
 * @Email Ricardo_Shaw@outlook.com
 * @date 2017年5月26日 下午4:42:56 
 *  
 */
@Service
@Transactional
public class IntervalServiceImpl implements IntervalService {
	
	@Autowired
	private IntervalDAO intervalDAO;
	
	
	public void setIntervalDAO(IntervalDAO intervalDAO) {
		this.intervalDAO = intervalDAO;
	}


	/* (非 Javadoc) 
	 * <p>Title: findAllIntervalVo</p> 
	 * <p>Description: </p> 
	 * @return 
	 * @see com.oci.service.IntervalService#findAllIntervalVo() 
	 */
	@Override
	public List<IntervalVo> findAllIntervalVo() {
		// TODO Auto-generated method stub
		return intervalDAO.findAllIntervalVo();
	}

	/* (非 Javadoc) 
	 * <p>Title: findIntervalVo</p> 
	 * <p>Description: </p> 
	 * @param intervalId
	 * @return 
	 * @see com.oci.service.IntervalService#findIntervalVo(java.lang.Integer) 
	 */
	@Override
	public IntervalVo findIntervalVo(Integer intervalId) {
		// TODO Auto-generated method stub
		return intervalDAO.findIntervalVo(intervalId);
	}

	/* (非 Javadoc) 
	 * <p>Title: findInterval</p> 
	 * <p>Description: </p> 
	 * @param intervalId
	 * @return 
	 * @see com.oci.service.IntervalService#findInterval(java.lang.Integer) 
	 */
	@Override
	public Interval findInterval(Integer intervalId) {
		// TODO Auto-generated method stub
		return intervalDAO.findInterval(intervalId);
	}

	/* (非 Javadoc) 
	 * <p>Title: updateInterval</p> 
	 * <p>Description: </p> 
	 * @param interval 
	 * @see com.oci.service.IntervalService#updateInterval(com.oci.domain.Interval) 
	 */
	@Override
	public void updateInterval(Interval interval) {
		// TODO Auto-generated method stub
		intervalDAO.updateInterval(interval);
	}

	/* (非 Javadoc) 
	 * <p>Title: insertInterval</p> 
	 * <p>Description: </p> 
	 * @param interval 
	 * @see com.oci.service.IntervalService#insertInterval(com.oci.domain.Interval) 
	 */
	@Override
	public void insertInterval(Interval interval) {
		// TODO Auto-generated method stub
		intervalDAO.insertInterval(interval);
	}

	/* (非 Javadoc) 
	 * <p>Title: deleteIntervals</p> 
	 * <p>Description: </p> 
	 * @param intervalIds 
	 * @see com.oci.service.IntervalService#deleteIntervals(java.util.List) 
	 */
	@Override
	public void deleteIntervals(List<Integer> intervalIds) {
		// TODO Auto-generated method stub
		intervalDAO.deleteIntervals(intervalIds);
	}

	/* (非 Javadoc) 
	 * <p>Title: deleteInterval</p> 
	 * <p>Description: </p> 
	 * @param intervalId 
	 * @see com.oci.service.IntervalService#deleteInterval(java.lang.Integer) 
	 */
	@Override
	public void deleteInterval(Integer intervalId) {
		// TODO Auto-generated method stub
		intervalDAO.deleteInterval(intervalId);
	}


	/* (非 Javadoc) 
	 * <p>Title: findAllIntervalForOtherVo</p> 
	 * <p>Description: </p> 
	 * @return 
	 * @see com.oci.service.IntervalService#findAllIntervalForOtherVo() 
	*/
	@Override
	public List<IntervalForOtherVo> findAllIntervalForOtherVo() {
		// TODO Auto-generated method stub
		return intervalDAO.findAllIntervalForOtherVo();
	}


	/* (非 Javadoc) 
	 * <p>Title: findIntervalVos</p> 
	 * <p>Description: </p> 
	 * @param interval
	 * @return 
	 * @see com.oci.service.IntervalService#findIntervalVos(com.oci.domain.searcher.IntervalSearcher) 
	*/
	@Override
	public List<IntervalVo> findIntervalVos(IntervalSearcher interval) {
		// TODO Auto-generated method stub
		return intervalDAO.findIntervalVos(interval);
	}


	/* (非 Javadoc) 
	 * <p>Title: findIntervalForOtherVoByProjectId</p> 
	 * <p>Description: </p> 
	 * @param projectId
	 * @return 
	 * @see com.oci.service.IntervalService#findIntervalForOtherVoByProjectId(java.lang.Integer) 
	*/
	@Override
	public List<IntervalForOtherVo> findIntervalForOtherVoByProjectId(
			Integer projectId) {
		// TODO Auto-generated method stub
		return intervalDAO.findIntervalForOtherVoByProjectId(projectId);
	}


	/* (非 Javadoc) 
	 * <p>Title: findIntervalForOtherVo</p> 
	 * <p>Description: </p> 
	 * @param intervalId
	 * @return 
	 * @see com.oci.service.IntervalService#findIntervalForOtherVo(java.lang.Integer) 
	*/
	@Override
	public IntervalForOtherVo findIntervalForOtherVo(Integer intervalId) {
		// TODO Auto-generated method stub
		return intervalDAO.findIntervalForOtherVo(intervalId);
	}


	/* (非 Javadoc) 
	 * <p>Title: deleteIntervalByProjectId</p> 
	 * <p>Description: </p> 
	 * @param projectId 
	 * @see com.oci.service.IntervalService#deleteIntervalByProjectId(java.lang.Integer) 
	*/
	@Override
	public void deleteIntervalByProjectId(Integer projectId) {
		// TODO Auto-generated method stub
		intervalDAO.deleteIntervalByProjectId(projectId);
	}

}
