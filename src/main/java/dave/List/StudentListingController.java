package dave.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller //Class is now controller.
public class StudentListingController {
@Autowired	
ListingRepository repository;
	
@GetMapping("/listing")
public String studentListing(Model listModel ){
	listModel.addAttribute("listObject", new StudentListings());
	return "listingpage";
}

@PostMapping("/listing")
public String addingToListing(@Valid StudentListings list, BindingResult resultThatBinds, Model superfluousModel ){
	
	if(resultThatBinds.hasErrors()){
		return "listingpage";
	}
	
	repository.save(list);
	superfluousModel.addAttribute("listObject", list);
	return "resultspage";
	
	}

@GetMapping("/all")
public String fetchAll(Model allListModel){
	allListModel.addAttribute("listObject", repository.findAll());
	return "everylisting";
}


}
