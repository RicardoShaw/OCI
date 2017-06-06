/**   
  * @Title: ProjectAndTypeHandler.java 
  * @Package com.oci.handler 
  * @Description: TODO(用一句话描述该文件做什么) 
  * @author RicardoShaw
  * @Email  Ricardo_Shaw@outlook.com   
  * @date 2017年6月2日 下午6:24:07 
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

import com.oci.domain.ProjectAndType;
import com.oci.domain.searcher.ProjectAndTypeSearcher;
import com.oci.domain.vo.PTForOtherVo;
import com.oci.domain.vo.ProjectAndTypeVo;
import com.oci.domain.vo.ProjectForOtherVo;
import com.oci.service.ProjectAndTypeService;
import com.oci.service.ProjectService;
import com.oci.service.ProjectTypeService;

/** 
 * @ClassName: ProjectAndTypeHandler 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author RicardoShaw
 * @Email Ricardo_Shaw@outlook.com
 * @date 2017年6月2日 下午6:24:07 
 *  
 */
@Controller
@RequestMapping("projectAndType")
public class ProjectAndTypeHandler {
	
	@Autowired
	private ProjectAndTypeService projectAndTypeService;
	
	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private ProjectTypeService projectTypeService;
	
	
	@PreAuthorize("hasRole('project_type_add')")
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public ModelAndView add(){
		return new ModelAndView("/projectAndType/addProjectAndType","projectAndType",new ProjectAndType());
	}

	
	@PreAuthorize("hasRole('project_type_add')")
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String addProjectAndType(@ModelAttribute("projectAndType")@Valid ProjectAndType projectAndType,BindingResult result,Model model){
		if(result.hasErrors()){
			return "/projectAndType/addProjectAndType";
		}
		projectAndTypeService.insertProjectAndType(projectAndType);
		System.out.println(projectAndType);
		return "redirect:/projectAndType/find";
		
	}


	@PreAuthorize("hasRole('project_type_find')")
	@RequestMapping(value="/find",method=RequestMethod.GET)
	public ModelAndView findProjectAndTypes(){
		
		return new ModelAndView("/projectAndType/findProjectAndType","projectAndTypeSearcher",new ProjectAndTypeSearcher());	
	}
	
	@PreAuthorize("hasRole('project_type_find')")
	@RequestMapping(value="/find",method=RequestMethod.POST)
	public ModelAndView findProjectAndTypes(@ModelAttribute("projectAndTypeSearcher")ProjectAndTypeSearcher projectAndType){
		System.out.println(projectAndType);
		List<ProjectAndTypeVo> projectAndTypes=projectAndTypeService.findProjectAndTypeVos(projectAndType);
		System.out.println(projectAndTypes.size());
		ModelAndView m = new ModelAndView("/projectAndType/findProjectAndType","projectAndTypes", projectAndTypes);
		return m;	
	}
	
	
	
	
	@PreAuthorize("hasRole('project_type_delete')")
	@RequestMapping(value="/delete/{id}",method=RequestMethod.GET)
	public String deleteProjectAndType(@PathVariable("id") Integer id){
		
		projectAndTypeService.deleteProjectAndType(id);
		
		return "redirect:/projectAndType/find";
	}
	
	@PreAuthorize("hasRole('project_type_update')")
	@RequestMapping(value="/update/{id}",method=RequestMethod.GET)
	public ModelAndView updateProjectAndType(@PathVariable("id") Integer id){
		ProjectAndType projectAndType = projectAndTypeService.findProjectAndType(id);
		return new ModelAndView("/projectAndType/updateProjectAndType","projectAndType",projectAndType);
	}
	
	@PreAuthorize("hasRole('project_type_update')")
	@RequestMapping(value="/update/modify",method=RequestMethod.POST)
	public String updateProjectAndType(@ModelAttribute("projectAndType")@Valid ProjectAndType projectAndType,BindingResult result,Model model){
		if(result.hasErrors()){
			return "/projectAndType/updateProjectAndType";
		}
		projectAndTypeService.updateProjectAndType(projectAndType);
		return "redirect:/projectAndType/find";
	}
	
	   @ModelAttribute("projectList")
	   public Map<Object, Object> getProjectList()
	   {
	      Map<Object, Object> projectList = new HashMap<Object, Object>();
	      List<ProjectForOtherVo> projectVos = projectService.findAllProjectForOtherVo();
	      for(ProjectForOtherVo projectVo:projectVos){
	    	  projectList.put(projectVo.getProjectId(),projectVo.getProjectName());
	      }
	      return projectList;
	   }
	   
	   
	   @ModelAttribute("projectTypeList")
	   public Map<Object, Object> getProjectTypeList()
	   {
	      Map<Object, Object> projectTypeList = new HashMap<Object, Object>();
	      List<PTForOtherVo> ptVos = projectTypeService.findAllPTForOtherVo();
	      for(PTForOtherVo ptVo:ptVos){
	    	  projectTypeList.put(ptVo.getProjectTypeId(),ptVo.getProjectTypeName());
	      }
	      return projectTypeList;
	   }
	

}
