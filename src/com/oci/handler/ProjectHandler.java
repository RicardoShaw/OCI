/**   
  * @Title: ProjectHandler.java 
  * @Package com.oci.handler 
  * @Description: TODO(用一句话描述该文件做什么) 
  * @author RicardoShaw
  * @Email  Ricardo_Shaw@outlook.com   
  * @date 2017年6月1日 下午8:56:48 
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

import com.oci.domain.Project;
import com.oci.domain.searcher.ProjectSearcher;
import com.oci.domain.vo.ProjectVo;
import com.oci.service.ProjectService;

/** 
 * @ClassName: ProjectHandler 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author RicardoShaw
 * @Email Ricardo_Shaw@outlook.com
 * @date 2017年6月1日 下午8:56:48 
 *  
 */
@Controller
@RequestMapping("project")
public class ProjectHandler {
	
	
	@Autowired
	private ProjectService projectService;
	
	
	@PreAuthorize("hasRole('project_add')")
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public ModelAndView add(){
		return new ModelAndView("/project/addProject","project",new Project());
	}
	
	@PreAuthorize("hasRole('project_add')")
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String addProject(@ModelAttribute("project")@Valid Project project,BindingResult result){
		if(result.hasErrors()){
			return "/project/addProject";
		}
		projectService.insertProject(project);
		System.out.println(project);
		return "redirect:/project/find";
	}
	
	@PreAuthorize("hasRole('project_delete')")
	@RequestMapping(value="/delete/{id}",method=RequestMethod.GET)
	public String deleteProject(@PathVariable("id") Integer id){
		
		projectService.deleteProject(id);
		
		return "redirect:/project/find";
	}
	
	@PreAuthorize("hasRole('project_update')")
	@RequestMapping(value="/update/{id}",method=RequestMethod.GET)
	public String updateProject(@PathVariable("id") Integer id,Model model){
		
		Project project = projectService.findProject(id);
		model.addAttribute("project", project);	
		return "/project/updateProject";
	}
	
	@PreAuthorize("hasRole('project_update')")
	@RequestMapping(value="/update/modify",method=RequestMethod.POST)
	public String updateProject(@ModelAttribute("project")@Valid Project project,BindingResult result,Model model){
		if(result.hasErrors()){
			return "/project/addProject";
		}
		projectService.updateProject(project);
		System.out.println(project);
		return "redirect:/project/find";
	}
	
	@PreAuthorize("hasRole('project_find')")
	@RequestMapping(value="/find",method=RequestMethod.GET)
	public ModelAndView find(){
		return new ModelAndView("/project/findProject","projectSearcher",new ProjectSearcher());
	}
	
	@PreAuthorize("hasRole('project_find')")
	@RequestMapping(value="/find",method=RequestMethod.POST)
	public ModelAndView find(@ModelAttribute("projectSearcher") ProjectSearcher project){
		List<ProjectVo> projects=projectService.findProjectVos(project);
		return new ModelAndView("/project/findProject","projects",projects);
	}

	

}
