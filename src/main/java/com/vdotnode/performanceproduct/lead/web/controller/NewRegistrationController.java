package com.vdotnode.performanceproduct.lead.web.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vdotnode.performanceproduct.lead.domain.NewRegistration;
import com.vdotnode.performanceproduct.lead.services.NewRegistrationService;

@RestController
@RequestMapping(value = "/newRegistration")
public class NewRegistrationController {
	
	private static final Logger logger = Logger.getLogger(NewRegistrationController.class);
	
	@Autowired
    NewRegistrationService  newRegistrationService;
	
	
	/**
	 * Retrival all new Resitartion
	 * @return
	 */
	 
    
   @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<NewRegistration>> listAll() {
        List<NewRegistration> newRegistration = newRegistrationService.findAllNewRegistration();
        if(newRegistration.isEmpty()){
            return new ResponseEntity<List<NewRegistration>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<NewRegistration>>(newRegistration, HttpStatus.OK);
        
    }
    
	
  //-------------------Retrieve Single User--------------------------------------------------------
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<NewRegistration> getNewRegistration(@PathVariable("id") long id) {
        //System.out.println("Fetching User with id " + id);
    	NewRegistration newRegistration = newRegistrationService.findNewRegistrationById(id);
        if (newRegistration == null) {
            //System.out.println("User with id " + id + " not found");
            return new ResponseEntity<NewRegistration>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<NewRegistration>(newRegistration, HttpStatus.OK);
    }
    
 // -------------------Create a User --------------------//

 	@RequestMapping(method = RequestMethod.POST)
 	public ResponseEntity<NewRegistration> createNewRegistration(@RequestBody NewRegistration newRegistration) {
 		logger.debug("Request recieved for campaginChannel");
 		NewRegistration  registration= this.newRegistrationService.createNewRegistration(newRegistration);
 	
 		if(null != registration){
 		logger.debug("Creating  a campaginChannel");
 			return new ResponseEntity<NewRegistration>(registration,HttpStatus.CREATED);
 		}
 		return new ResponseEntity<NewRegistration>(HttpStatus.CONFLICT);
 	}
 	
 	
 // ------------------- Delete a User --------------------//

 	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<NewRegistration> deleteNewRegistration(@PathVariable("id") Long id) {
		logger.debug("Request recieved for campaginChannels");
		// System.out.println("Fetching & Deleting User with id " + id);

		NewRegistration campaignChannel = this.newRegistrationService.findNewRegistrationById(id);
		if (campaignChannel == null) {
			logger.error("No campaginChannel found");
			return new ResponseEntity<NewRegistration>(HttpStatus.NOT_FOUND);
		}

		this.newRegistrationService.deleteRegistrationbyId(id);
		logger.debug("Deleting for single campaginChannel");
		return new ResponseEntity<NewRegistration>(HttpStatus.OK);
	}
 // ------------------- Update a User --------------------//

 	@RequestMapping(method = RequestMethod.PUT)
 	public ResponseEntity<NewRegistration> update(@RequestBody NewRegistration newRegistration) {
 		
 		logger.debug("Request recieved for campaginChannel");
 		NewRegistration currentNewRegistration = this.newRegistrationService.findNewRegistrationById(newRegistration.getId());

 		if (currentNewRegistration == null) {
 			logger.error("No campaginChannel found");
 			return new ResponseEntity<NewRegistration>(HttpStatus.NOT_FOUND);
 		}

 		currentNewRegistration = this.newRegistrationService.updateNewRegistration(newRegistration);
 		logger.debug("Updating for single campaginChannel");
 		return new ResponseEntity<NewRegistration>(currentNewRegistration, HttpStatus.OK);
 	}

}
