/**   
  * @Title: RodAndProgressHandler.java 
  * @Package com.oci.handler 
  * @Description: TODO(用一句话描述该文件做什么) 
  * @author RicardoShaw
  * @Email  Ricardo_Shaw@outlook.com   
  * @date 2017年6月7日 上午12:48:52 
  * @version V1.0   
*/
package com.oci.handler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.oci.domain.RodAndProgress;
import com.oci.domain.searcher.RodAndProgressSearcher;
import com.oci.domain.vo.ProgressForOtherVo;
import com.oci.domain.vo.RodAndProgressVo;
import com.oci.domain.vo.RodForOtherVo;
import com.oci.service.ProgressService;
import com.oci.service.RodAndProgressService;
import com.oci.service.RodService;

/** 
 * @ClassName: RodAndProgressHandler 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author RicardoShaw
 * @Email Ricardo_Shaw@outlook.com
 * @date 2017年6月7日 上午12:48:52 
 *  
 */
@Controller
@RequestMapping("rodAndProgress")
public class RodAndProgressHandler {
		
	@Autowired
	private RodAndProgressService rodAndProgressService;
	@Autowired
	private RodService rodService;
	@Autowired
	private ProgressService progressService;
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public ModelAndView add(){
		return new ModelAndView("/rod/addRod","rodAndProgress",new RodAndProgress());
	}
	
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String addRodAndProgress(@ModelAttribute("rodAndProgress")@Valid RodAndProgress rodAndProgress,BindingResult result){
		if(result.hasErrors()){
			return "/rodAndProgress/addRodAndProgress";
		}
		rodAndProgressService.insertRodAndProgress(rodAndProgress);
		System.out.println(rodAndProgress);
		return "redirect:/rodAndProgress/find";
	}
	
	@PreAuthorize("hasRole('rodAndProgress_delete')")
	@RequestMapping(value="/delete/{id}",method=RequestMethod.GET)
	public String deleteRodAndProgress(@PathVariable("id") Integer id){
		
		rodAndProgressService.deleteRodAndProgress(id);
		
		return "redirect:/rodAndProgress/find";
	}
	
	@PreAuthorize("hasRole('rodAndProgress_update')")
	@RequestMapping(value="/update/{id}",method=RequestMethod.GET)
	public String updateRodAndProgress(@PathVariable("id") Integer id,Model model){
		RodAndProgress rodAndProgress = rodAndProgressService.findRodAndProgress(id);
		model.addAttribute("rodAndProgress", rodAndProgress);	
		return "/rodAndProgress/updateRodAndProgress";
	}
	
	@PreAuthorize("hasRole('rodAndProgress_update')")
	@RequestMapping(value="/update/modify",method=RequestMethod.POST)
	public String updateRodAndProgress(@ModelAttribute("rodAndProgress")@Valid RodAndProgress rodAndProgress,BindingResult result,Model model){
		if(result.hasErrors()){
			return "/rodAndProgress/addRodAndProgress";
		}
		rodAndProgressService.updateRodAndProgress(rodAndProgress);
		System.out.println(rodAndProgress);
		return "redirect:/rodAndProgress/find";
	}
	
	@PreAuthorize("hasRole('rodAndProgress_find')")
	@RequestMapping(value="/find",method=RequestMethod.GET)
	public ModelAndView find(){
		return new ModelAndView("/rodAndProgress/findRodAndProgress","rodAndProgressSearcher",new RodAndProgressSearcher());
	}
	
	@PreAuthorize("hasRole('rodAndProgress_find')")
	@RequestMapping(value="/find",method=RequestMethod.POST)
	public ModelAndView find(@ModelAttribute("rodAndProgressSearcher") RodAndProgressSearcher rodAndProgress){
		List<RodAndProgressVo> rodAndProgresss=rodAndProgressService.findRodAndProgressVos(rodAndProgress);
		return new ModelAndView("/rodAndProgress/findRodAndProgress","rodAndProgresss",rodAndProgresss);
	}
	
	
	@ModelAttribute("rodList")
	public Map<Object,Object> getRodList(){
		Map<Object,Object> rodList = new HashMap<Object,Object>();
		List<RodForOtherVo> rodVos = rodService.findAllRodForOtherVo();
		for(RodForOtherVo rodVo: rodVos){
			rodList.put(rodVo.getRodId(), rodVo.getRodNo());
		}
		return rodList;
	}
	
	@ModelAttribute("progressList")
	public Map<Object,Object> getProgressList(){
		Map<Object,Object> progressList = new HashMap<Object,Object>();
		List<ProgressForOtherVo> progressVos = progressService.findAllProgressForOtherVo();
		for(ProgressForOtherVo progressVo : progressVos){
			progressList.put(progressVo.getProgressId(), progressVo.getProgressName());
		}
		return progressList;
	}
	

}
