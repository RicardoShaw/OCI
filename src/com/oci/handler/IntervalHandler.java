/**   
  * @Title: IntervalHandler.java 
  * @Package com.oci.handler 
  * @Description: TODO(用一句话描述该文件做什么) 
  * @author RicardoShaw
  * @Email  Ricardo_Shaw@outlook.com   
  * @date 2017年6月6日 下午11:00:20 
  * @version V1.0   
*/
package com.oci.handler;

import java.util.List;

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

import com.oci.domain.Interval;
import com.oci.domain.searcher.IntervalSearcher;
import com.oci.domain.vo.IntervalVo;
import com.oci.service.IntervalService;

/** 
 * @ClassName: IntervalHandler 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author RicardoShaw
 * @Email Ricardo_Shaw@outlook.com
 * @date 2017年6月6日 下午11:00:20 
 *  
 */
@Controller
@RequestMapping("interval")
public class IntervalHandler {
	
	@Autowired
	private IntervalService intervalService;
	
	@PreAuthorize("hasRole('interval_add')")
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public ModelAndView add(){
		return new ModelAndView("/interval/addInterval","interval",new Interval());
	}
	
	@PreAuthorize("hasRole('interval_add')")
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String addInterval(@ModelAttribute("interval")@Valid Interval interval,BindingResult result){
		if(result.hasErrors()){
			return "/interval/addInterval";
		}
		intervalService.insertInterval(interval);
		System.out.println(interval);
		return "redirect:/interval/find";
	}
	
	@PreAuthorize("hasRole('interval_delete')")
	@RequestMapping(value="/delete/{id}",method=RequestMethod.GET)
	public String deleteInterval(@PathVariable("id") Integer id){
		
		intervalService.deleteInterval(id);
		
		return "redirect:/interval/find";
	}
	
	@PreAuthorize("hasRole('interval_update')")
	@RequestMapping(value="/update/{id}",method=RequestMethod.GET)
	public String updateInterval(@PathVariable("id") Integer id,Model model){
		
		Interval interval = intervalService.findInterval(id);
		model.addAttribute("interval", interval);	
		return "/interval/updateInterval";
	}
	
	@PreAuthorize("hasRole('interval_update')")
	@RequestMapping(value="/update/modify",method=RequestMethod.POST)
	public String updateInterval(@ModelAttribute("interval")@Valid Interval interval,BindingResult result,Model model){
		if(result.hasErrors()){
			return "/interval/addInterval";
		}
		intervalService.updateInterval(interval);
		System.out.println(interval);
		return "redirect:/interval/find";
	}
	
	@PreAuthorize("hasRole('interval_find')")
	@RequestMapping(value="/find",method=RequestMethod.GET)
	public ModelAndView find(){
		return new ModelAndView("/interval/findInterval","intervalSearcher",new IntervalSearcher());
	}
	
	@PreAuthorize("hasRole('interval_find')")
	@RequestMapping(value="/find",method=RequestMethod.POST)
	public ModelAndView find(@ModelAttribute("intervalSearcher") IntervalSearcher interval){
		List<IntervalVo> intervals=intervalService.findIntervalVos(interval);
		return new ModelAndView("/interval/findInterval","intervals",intervals);
	}

	
	
		
	

}
