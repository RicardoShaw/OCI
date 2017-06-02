/**   
  * @Title: RodHandler.java 
  * @Package com.oci.handler 
  * @Description: TODO(用一句话描述该文件做什么) 
  * @author RicardoShaw
  * @Email  Ricardo_Shaw@outlook.com   
  * @date 2017年5月31日 下午9:58:38 
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

import com.oci.domain.Rod;
import com.oci.domain.searcher.RodSearcher;
import com.oci.domain.vo.IntervalForOtherVo;
import com.oci.domain.vo.RodVo;
import com.oci.service.IntervalService;
import com.oci.service.RodService;

/** 
 * @ClassName: RodHandler 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author RicardoShaw
 * @Email Ricardo_Shaw@outlook.com
 * @date 2017年5月31日 下午9:58:38 
 *  
 */
@Controller
@RequestMapping("rod")
public class RodHandler {
	
	@Autowired
	private RodService rodService;
	@Autowired
	private IntervalService  intervalService;
	
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public ModelAndView add(){
		return new ModelAndView("/rod/addRod","rod",new Rod());
	}
	
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String addRod(@ModelAttribute("rod")@Valid Rod rod,BindingResult result){
		if(result.hasErrors()){
			return "/rod/addRod";
		}
		rodService.InsertRod(rod);
		System.out.println(rod);
		return "redirect:/rod/find";
	}
	
	@PreAuthorize("hasRole('rod_delete')")
	@RequestMapping(value="/delete/{id}",method=RequestMethod.GET)
	public String deleteRod(@PathVariable("id") Integer id){
		
		rodService.deleteRod(id);
		
		return "redirect:/rod/find";
	}
	
	@PreAuthorize("hasRole('rod_update')")
	@RequestMapping(value="/update/{id}",method=RequestMethod.GET)
	public String updateRod(@PathVariable("id") Integer id,Model model){
		Rod rod = rodService.findRod(id);
		model.addAttribute("rod", rod);	
		return "/rod/updateRod";
	}
	
	@PreAuthorize("hasRole('rod_update')")
	@RequestMapping(value="/update/modify",method=RequestMethod.POST)
	public String updateRod(@ModelAttribute("rod")@Valid Rod rod,BindingResult result,Model model){
		if(result.hasErrors()){
			return "/rod/addRod";
		}
		rodService.updateRod(rod);
		System.out.println(rod);
		return "redirect:/rod/find";
	}
	
	@PreAuthorize("hasRole('rod_find')")
	@RequestMapping(value="/find",method=RequestMethod.GET)
	public ModelAndView find(){
		return new ModelAndView("/rod/findRod","rodSearcher",new RodSearcher());
	}
	
	@PreAuthorize("hasRole('rod_find')")
	@RequestMapping(value="/find",method=RequestMethod.POST)
	public ModelAndView find(@ModelAttribute("rodSearcher") RodSearcher rod){
		List<RodVo> rods=rodService.findRodVos(rod);
		return new ModelAndView("/rod/findRod","rods",rods);
	}
	
	
	@ModelAttribute("intervalList")
	public Map<Object,Object> getIntervalList(){
		Map<Object,Object> intervalList = new HashMap<Object,Object>();
		List<IntervalForOtherVo> intervalVos = intervalService.findAllIntervalForOtherVo();
		for(IntervalForOtherVo intervalVo:intervalVos){
			intervalList.put(intervalVo.getIntervalId(), intervalVo.getIntervalName());
		}
		return intervalList;
	}

}
