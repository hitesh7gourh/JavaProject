package com.HealthInsurance.healthInsurance.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.HealthInsurance.healthInsurance.Model.Claim;
import com.HealthInsurance.healthInsurance.Model.User;
import com.HealthInsurance.healthInsurance.Service.UserService;
import com.HealthInsurance.healthInsurance.repositories.ClaimRepository;
import com.HealthInsurance.healthInsurance.repositories.UserRepository;

@Controller
@SessionAttributes("userid")
public class AppController {
	@Autowired
	UserService userService;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ClaimRepository claimRepository;
	
	

	// home
	@RequestMapping(value = "/")
	public String home(Model model, HttpSession session)
	{
		
		return "welcome";
	}

	// Login page
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	// Registration page
	@RequestMapping(value = "/reg", method = RequestMethod.GET)
	public String registerUser(@ModelAttribute("user") User user) {
		return "registration";
	}

	@PostMapping(value = "/reg")
	public String newUserRegister(@ModelAttribute("user") User user, BindingResult result, HttpSession session) {
//		
		if (result.hasErrors()) {
			return "registration";
		}
		userService.registerUser(user);
		session.setAttribute("userid", user.getId());
		return "/login";
	}
	
	






	@PostMapping(value = "/login")
	public String login(@RequestParam("email") String email, @RequestParam("password") String password,
			HttpSession session, RedirectAttributes r,ModelMap map) {
		boolean success = userService.authenticateUser(email, password);
         map.addAttribute("userid",email);
		if (email.length() < 1) {
			r.addFlashAttribute("error", "Email field cannot be blank.");
			return "redirect:/login";
		} else if (password.length() < 1) {
			r.addFlashAttribute("error", "Please enter your password.");
			return "redirect:/login";
		} else if (!success) {
			r.addFlashAttribute("error", "Email and password do not match.");
			return "redirect:/login";
		} else {
			User user = userService.findByEmail(email);
			Long id = user.getId();
			session.setAttribute("userid", id);
			return "userpage";
		}
	}
	@RequestMapping(value = "/userpage", method = RequestMethod.GET)
	public String userpage() {
		return "userpage";
	}

	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout() {
		return "welcome";
	}

	// Payment
	@RequestMapping(value = "/payment", method = RequestMethod.GET)
	public String payment() {
		return "payment";
	}
	

	
	

	// Thanks
	@RequestMapping(value = "/thankyou", method = RequestMethod.GET)
	public String thankyou() {
		return "thankyou";
	}



	// UserDetails
	@GetMapping(value = "/userrecord")
	public String services(ModelMap model, HttpSession session) {

		List<User> user = userRepository.findAll();
		model.put("user", user);

		return "userrecord";
	}

	@RequestMapping(value="/delete-user", method =RequestMethod.GET)
	public String deleteEmployee(@RequestParam long id) {
		
		// call delete user method 
		userService.deleteEmployeeById(id);
		return "redirect:/userrecord";
	}
	
	
	//AdminLogin
	
	@RequestMapping(value="/login2",  method = RequestMethod.GET)
	public String Adminlogin() {
		return "login2";
	}

	
	@PostMapping(value = "/login2")
    public String login (@RequestParam("email") String email, @RequestParam("password") String password) {
    

    		if(email.equals("hitesh") && password.equals("123"))
    		{
    			return "Admin";
    		}
    		else {
    			return "login2";
 
    	
    	}
    }


	@RequestMapping(value="/Admin",  method = RequestMethod.GET)
	public String Adminlogin1() {
		return "Admin";
	}
	
	// Registration page
	@RequestMapping(value = "/claim", method = RequestMethod.GET)
	public String claim(@ModelAttribute("claim") Claim claim) {
		return "claim";
	}

	@PostMapping(value = "/claim")
	public String newClaim(@ModelAttribute("claim") Claim claim, BindingResult result, ModelMap map,HttpSession session) {
//		
		if (result.hasErrors()) {
			return "claim";
		}
		claim.setUserId((String) map.getAttribute("userid"));
		claim.setStatus("Pending");
		claimRepository.save(claim);
		session.setAttribute("claimid", claim.getId());
		return "userpage";
	}
	
	// AdminApproveStatus
	@GetMapping(value = "/report")
	public String claim(ModelMap model, HttpSession session) {

		List<Claim> claimlist = claimRepository.findByStatus("Pending");
		model.put("claim", claimlist);
		return "report";
	}
	@RequestMapping("setStatus")
	public String setStatus(@RequestParam("status") String status,@RequestParam("policy") String policy,ModelMap model) {
	 Claim claim=claimRepository.findByPolicy(policy);
	 claim.setStatus(status);
	 claimRepository.save(claim);
	 List<Claim> claimlist = claimRepository.findByStatus("Pending");
		model.put("claim", claimlist);
	 return "report";
	}
	
	@RequestMapping(value="/generate")
	public ModelAndView generate(ModelMap map)
	{ 
		ModelAndView gen=new ModelAndView();
		String userId=(String)map.getAttribute("userid");
	List<Claim> claimlist=claimRepository.findByUserId(userId);
	gen.addObject("claim",claimlist);
	gen.setViewName("policyreport");
	return gen;
	}
	
}
