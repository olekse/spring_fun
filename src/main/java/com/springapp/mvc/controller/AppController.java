package com.springapp.mvc.controller;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Path;
import javax.validation.Valid;

import com.springapp.mvc.model.UserProfile;
import com.springapp.mvc.model.UserProfileType;
import com.springapp.mvc.model.bp.Order;
import com.springapp.mvc.model.bp.TestDrive;
import com.springapp.mvc.model.business.Business;
import com.springapp.mvc.model.business.BusinessType;
import com.springapp.mvc.model.car.Car;
import com.springapp.mvc.model.client.Client;
import com.springapp.mvc.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springapp.mvc.model.User;


@Controller
@RequestMapping("/")
@SessionAttributes("roles")
public class AppController {


	@Autowired
	ClientService clientService;

	/*
	@Autowired
	UserService userService;
	*/

	@Autowired
	PersonService personService;

	@Autowired
	BusinessService businessService;

	@Autowired
	TestDriveService testDriveService;

	@Autowired
	OrderService orderService;

	@Autowired
	ModelService modelService;

	@Autowired
	CarService carService;

	@Autowired
	UserProfileService userProfileService;
	
	@Autowired
	MessageSource messageSource;

	@Autowired
	PersistentTokenBasedRememberMeServices persistentTokenBasedRememberMeServices;
	
	@Autowired
	AuthenticationTrustResolver authenticationTrustResolver;


	@RequestMapping(value = { "/order-{id}" }, method = RequestMethod.GET)
	public String orderCar(@PathVariable Integer id) {
		// TODO
		return "order";
	}

	@RequestMapping(value = { "/test-drive-{id}" }, method = RequestMethod.GET)
	public String orderTestDrive(@PathVariable Integer id, ModelMap model) {

		Client client = clientService.findBySSO(getPrincipal());
		Car car = carService.findById(id);
		TestDrive testDrive = new TestDrive();

		model.addAttribute("testDrive", testDrive);

		model.addAttribute("car", car);
		model.addAttribute("client", client);

		return "testDrive";
	}

	@RequestMapping(value = "/test-drive-{id}", method = RequestMethod.POST )
	public String saveNewTestDrive(@PathVariable Integer id, @Valid TestDrive testDrive, BindingResult result,
								ModelMap model){




		if(result.hasErrors()){
			List<ObjectError> oe = result.getAllErrors();
			if(oe.size() == 1){

			} else {
				return "/test-drive-{id}";
			}
		}

		Client client = clientService.findBySSO(getPrincipal());
		Car car = carService.findById(id);

		testDrive.setClient(client);
		testDrive.setCar(car);

		testDriveService.saveTestDrive(testDrive);

		return "redirect:/testDrives";
	}

	/*


		// FOR BUSINESS
		Business business = new Business();
		model.addAttribute("business", business);
		///
		return "business_client_register";
	 */

	@RequestMapping(value = "/registerBusiness", method = RequestMethod.GET )
	public String registerBusinessClient(ModelMap model) {

		model.addAttribute("businessForm", new BusinessForm());

		//model.addAttribute("loggedinuser", getPrincipal());

		return "business_client_register";
	}

	@RequestMapping(value = "/registerBusiness", method = RequestMethod.POST )
	public String registerBusinessClient(@Valid BusinessForm businessForm, BindingResult result,
										 ModelMap model) {

		Client client = businessForm.getClient();
		client.setABusiness(true);
		client.setBusinessInfo(businessForm.getBusiness());

		businessService.save(businessForm.getBusiness());
		clientService.saveClient(client);

		// save business

		//model.addAttribute("loggedinuser", getPrincipal());

		return "/login";
	}

	@RequestMapping(value = "/registerPrivate", method = RequestMethod.GET )
	public String registerPrivateClient(ModelMap model) {

		model.addAttribute("privateForm", new PrivateForm());

		//model.addAttribute("loggedinuser", getPrincipal());

		return "private_client_register";
	}

	@RequestMapping(value = "/registerPrivate", method = RequestMethod.POST )
	public String registerPrivateClient(@Valid PrivateForm privateForm, BindingResult result,
										 ModelMap model) {


		Client client = privateForm.getClient();
		client.setPersonInfo(privateForm.getPerson());

		personService.save(privateForm.getPerson());
		clientService.saveClient(client);

		// save business

		//model.addAttribute("loggedinuser", getPrincipal());

		return "/login";
	}

	@RequestMapping(value = "/registerType", method = RequestMethod.GET )
	public String chooseAccountType(ModelMap model) {
		return "account_type_selection";
	}


	@RequestMapping(value = "/register", method = RequestMethod.GET )
	public String registerNewClient(ModelMap model) {
		Client client = new Client();

		model.addAttribute("client", client);
		model.addAttribute("edit", false);

		//model.addAttribute("loggedinuser", getPrincipal());

		return "clientRegistration";
	}


	@RequestMapping(value = "/register", method = RequestMethod.POST )
	public String saveNewClient(@Valid Client client, BindingResult result,
								ModelMap model){
		if(result.hasErrors()){
			List<ObjectError> oe = result.getAllErrors();
			if(oe.size() == 1){

			} else {
				return "clientRegistration";
			}
		}

		clientService.saveClient(client);

		//model.addAttribute("success", "Client " + client.getFirstName() + " "+ client.getLastName() + " registered successfully");

		return "/login";
	}



	/**
	 * This method will list all existing users.
	 */
	@RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
	public String listCars(ModelMap model, @ModelAttribute("searchForm") SearchForm sForm) {

		List<Car> cars = carService.findAllCars();




		Set<String> colors = new HashSet<>();
		Set<String> types = new HashSet<>();
		Set<String> milage = new HashSet<>();

		for(Car car : cars){
			car.setCarModel(modelService.findById(car.getId()));
			colors.add(car.getColor());
			types.add(car.getCarModel().getType());
			milage.add(String.valueOf(car.getMilage()));
		}

		Iterator<Car> carIterator = cars.iterator();


		while (carIterator.hasNext()){
			Car nextCar = carIterator.next();

			if(sForm.getColor() != null && !sForm.getColor().equals("ANY")){
				if (!nextCar.getColor().equals(sForm.getColor())){
					carIterator.remove();
					continue;
				}
			}

			if(sForm.getType() != null && !sForm.getType().equals("ANY")){
				if (!nextCar.getCarModel().getType().equals(sForm.getType())){
					carIterator.remove();
					continue;
				}
			}

			if(sForm.getMileage_min() != null) {
				Integer val = null;
				try {
					val = Integer.valueOf(sForm.getMileage_min());
				} catch (Exception ex) {

				}
				if (val != null) {
					if (nextCar.getMilage() < val) {
						carIterator.remove();
						continue;
					}
				}
			}


			if(sForm.getMileage_max() != null) {
				Integer val = null;
				try {
					val = Integer.valueOf(sForm.getMileage_max());
				} catch (Exception ex) {
				}


				if (val != null) {
					if (nextCar.getMilage() > val) {
						carIterator.remove();
						continue;
					}
				}
			}


		} // while



		model.addAttribute("searchForm", new SearchForm());

		model.addAttribute("types", types);
		model.addAttribute("colors", colors);
		model.addAttribute("cars", cars);
		model.addAttribute("loggedinuser", getPrincipal());
		return "car_list";
	}



	@RequestMapping(value = { "/testDrives" }, method = RequestMethod.GET)
	public String listRentedCars(ModelMap model) {

		Client client = clientService.findBySSO(getPrincipal());



		List<TestDrive> testDrives = testDriveService.findTestDrivesOfAClient(client);


		model.addAttribute("testDrives", testDrives);
		model.addAttribute("loggedinuser", getPrincipal());
		return "test_drive_list";
	}



	/**
	 * This method will provide the medium to add a new user.
	 */
	@RequestMapping(value = { "/newuser" }, method = RequestMethod.GET)
	public String newUser(ModelMap model) {
		Client client = new Client();
		model.addAttribute("user", client);
		model.addAttribute("edit", false);
		model.addAttribute("loggedinuser", getPrincipal());
		return "registration";
	}

	/**
	 * This method will be called on form submission, handling POST request for
	 * saving user in database. It also validates the user input
	 */
	@RequestMapping(value = { "/newuser" }, method = RequestMethod.POST)
	public String saveUser(@Valid Client client, BindingResult result,
			ModelMap model) {

		if (result.hasErrors()) {
			return "registration";
		}

		/*
		 * Preferred way to achieve uniqueness of field [sso] should be implementing custom @Unique annotation 
		 * and applying it on field [sso] of Model class [User].
		 * 
		 * Below mentioned peace of code [if block] is to demonstrate that you can fill custom errors outside the validation
		 * framework as well while still using internationalized messages.
		 * 
		 */
		if(!clientService.isUserSSOUnique(client.getId(), client.getSsoId())){
			FieldError ssoError =new FieldError("user","ssoId",messageSource.getMessage("non.unique.ssoId", new String[]{client.getSsoId()}, Locale.getDefault()));
		    result.addError(ssoError);
			return "registration";
		}
		
		clientService.saveClient(client);

		model.addAttribute("success", "User " + client.getSsoId() + " registered successfully");
		model.addAttribute("loggedinuser", getPrincipal());
		//return "success";
		return "registrationsuccess";
	}


	/**
	 * This method will provide the medium to update an existing user.
	 */
	@RequestMapping(value = { "/edit-user-{ssoId}" }, method = RequestMethod.GET)
	public String editUser(@PathVariable String ssoId, ModelMap model) {
		Client client = clientService.findBySSO(ssoId);
		model.addAttribute("user", client);
		model.addAttribute("edit", true);
		model.addAttribute("loggedinuser", getPrincipal());
		return "registration";
	}
	
	/**
	 * This method will be called on form submission, handling POST request for
	 * updating user in database. It also validates the user input
	 */
	@RequestMapping(value = { "/edit-user-{ssoId}" }, method = RequestMethod.POST)
	public String updateUser(@Valid Client client, BindingResult result,
			ModelMap model, @PathVariable String ssoId) {

		if (result.hasErrors()) {
			return "registration";
		}

		/*//Uncomment below 'if block' if you WANT TO ALLOW UPDATING SSO_ID in UI which is a unique key to a User.
		if(!userService.isUserSSOUnique(user.getId(), user.getSsoId())){
			FieldError ssoError =new FieldError("user","ssoId",messageSource.getMessage("non.unique.ssoId", new String[]{user.getSsoId()}, Locale.getDefault()));
		    result.addError(ssoError);
			return "registration";
		}*/


		clientService.updateClient(client);

		model.addAttribute("success", "User " + client.getSsoId() + " updated successfully");
		model.addAttribute("loggedinuser", getPrincipal());
		return "registrationsuccess";
	}

	
	/**
	 * This method will delete an user by it's SSOID value.
	 */

	///testDrives/delete-${tdrive.id}

	@RequestMapping(value = { "/testDrives/delete-{tdrive_id}" }, method = RequestMethod.GET)
	public String deleteTestDrive(@PathVariable String tdrive_id) {
		testDriveService.deleteById(Integer.parseInt(tdrive_id));
		return "redirect:/testDrives";
	}

	@RequestMapping(value = { "/delete-user-{ssoId}" }, method = RequestMethod.GET)
	public String deleteClient(@PathVariable String ssoId) {
		clientService.deleteClientBySSO(ssoId);
		return "redirect:/list";
	}
	

	/**
	 * This method will provide UserProfile list to views
	 */
	@ModelAttribute("roles")
	public List<UserProfile> initializeProfiles() {
		return userProfileService.findAll();
	}
	
	/**
	 * This method handles Access-Denied redirect.
	 */
	@RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
	public String accessDeniedPage(ModelMap model) {
		model.addAttribute("loggedinuser", getPrincipal());
		return "accessDenied";
	}

	/**
	 * This method handles login GET requests.
	 * If users is already logged-in and tries to goto login page again, will be redirected to list page.
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage() {
		if (isCurrentAuthenticationAnonymous()) {



			//return "account_type_selection";
			return "login";
	    } else {
	    	return "redirect:/list";  
	    }
	}



	/**
	 * This method handles logout requests.
	 * Toggle the handlers if you are RememberMe functionality is useless in your app.
	 */
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null){    
			//new SecurityContextLogoutHandler().logout(request, response, auth);
			persistentTokenBasedRememberMeServices.logout(request, response, auth);
			SecurityContextHolder.getContext().setAuthentication(null);
		}
		return "redirect:/login?logout";
	}

	/**
	 * This method returns the principal[user-name] of logged-in user.
	 */
	private String getPrincipal(){
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			userName = ((UserDetails)principal).getUsername();
		} else {
			userName = principal.toString();
		}
		return userName;
	}
	
	/**
	 * This method returns true if users is already authenticated [logged-in], else false.
	 */




	private boolean isCurrentAuthenticationAnonymous() {
	    final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    return authenticationTrustResolver.isAnonymous(authentication);
	}


}