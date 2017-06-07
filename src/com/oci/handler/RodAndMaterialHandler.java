/**   
  * @Title: RodAndMaterialHandler.java 
  * @Package com.oci.handler 
  * @Description: TODO(用一句话描述该文件做什么) 
  * @author RicardoShaw
  * @Email  Ricardo_Shaw@outlook.com   
  * @date 2017年6月7日 下午1:46:37 
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

import com.oci.domain.RodAndMaterial;
import com.oci.domain.searcher.RodAndMaterialSearcher;
import com.oci.domain.vo.RodAndMaterialVo;
import com.oci.domain.vo.RodForOtherVo;
import com.oci.service.MaterialService;
import com.oci.service.RodAndMaterialService;
import com.oci.service.RodService;

/** 
 * @ClassName: RodAndMaterialHandler 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author RicardoShaw
 * @Email Ricardo_Shaw@outlook.com
 * @date 2017年6月7日 下午1:46:37 
 *  
 */
@Controller
@RequestMapping("rodAndMaterial")
public class RodAndMaterialHandler {
	
	@Autowired
	private RodAndMaterialService rodAndMaterialService;
	
	@Autowired
	private RodService rodService;
	
	@Autowired
	private MaterialService materialService;
	
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public ModelAndView add(){
		return new ModelAndView("/rod/addRod","rodAndMaterial",new RodAndMaterial());
	}
	
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String addRodAndMaterial(@ModelAttribute("rodAndMaterial")@Valid RodAndMaterial rodAndMaterial,BindingResult result){
		if(result.hasErrors()){
			return "/rodAndMaterial/addRodAndMaterial";
		}
		rodAndMaterialService.insertRodAndMaterial(rodAndMaterial);
		System.out.println(rodAndMaterial);
		return "redirect:/rodAndMaterial/find";
	}
	
	@PreAuthorize("hasRole('rodAndMaterial_delete')")
	@RequestMapping(value="/delete/{id}",method=RequestMethod.GET)
	public String deleteRodAndMaterial(@PathVariable("id") Integer id){
		
		rodAndMaterialService.deleteRodAndMaterial(id);
		
		return "redirect:/rodAndMaterial/find";
	}
	
	@PreAuthorize("hasRole('rodAndMaterial_update')")
	@RequestMapping(value="/update/{id}",method=RequestMethod.GET)
	public String updateRodAndMaterial(@PathVariable("id") Integer id,Model model){
		RodAndMaterial rodAndMaterial = rodAndMaterialService.findRodAndMaterial(id);
		model.addAttribute("rodAndMaterial", rodAndMaterial);	
		return "/rodAndMaterial/updateRodAndMaterial";
	}
	
	@PreAuthorize("hasRole('rodAndMaterial_update')")
	@RequestMapping(value="/update/modify",method=RequestMethod.POST)
	public String updateRodAndMaterial(@ModelAttribute("rodAndMaterial")@Valid RodAndMaterial rodAndMaterial,BindingResult result,Model model){
		if(result.hasErrors()){
			return "/rodAndMaterial/addRodAndMaterial";
		}
		rodAndMaterialService.updateRodAndMaterial(rodAndMaterial);
		System.out.println(rodAndMaterial);
		return "redirect:/rodAndMaterial/find";
	}
	
	@PreAuthorize("hasRole('rodAndMaterial_find')")
	@RequestMapping(value="/find",method=RequestMethod.GET)
	public ModelAndView find(){
		return new ModelAndView("/rodAndMaterial/findRodAndMaterial","rodAndMaterialSearcher",new RodAndMaterialSearcher());
	}
	
	@PreAuthorize("hasRole('rodAndMaterial_find')")
	@RequestMapping(value="/find",method=RequestMethod.POST)
	public ModelAndView find(@ModelAttribute("rodAndMaterialSearcher") RodAndMaterialSearcher rodAndMaterial){
		List<RodAndMaterialVo> rodAndMaterials=rodAndMaterialService.findRodAndMaterialVos(rodAndMaterial);
		return new ModelAndView("/rodAndMaterial/findRodAndMaterial","rodAndMaterials",rodAndMaterials);
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
	
//	@ModelAttribute("progressList")
//	public Map<Object,Object> getProgressList(){
//		Map<Object,Object> progressList = new HashMap<Object,Object>();
//		List<ProgressForOtherVo> progressVos = progressService.findAllProgressForOtherVo();
//		for(ProgressForOtherVo progressVo : progressVos){
//			progressList.put(progressVo.getProgressId(), progressVo.getProgressName());
//		}
//		return progressList;
//	}
	
	
}
