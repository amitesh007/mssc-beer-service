package guru.springframework.msscbeerservice.web.controller;

import java.util.UUID;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import guru.springframework.msscbeerservice.web.model.BeerDto;
import guru.springframework.msscbeerservice.web.model.BeerStyleEnum;


@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {
	
	@GetMapping("/{id}")
	public ResponseEntity<BeerDto> getBeerById(@PathVariable("id") UUID id){
		return new ResponseEntity<>(BeerDto.builder().id(UUID.randomUUID()).beerName("Test").beerStyle(BeerStyleEnum.ALE).build(),HttpStatus.OK);
	}
	
	@PostMapping("/create")
	public ResponseEntity saveNewBeer(@RequestBody BeerDto beerDto) {
		BeerDto beer= BeerDto.builder().id(UUID.randomUUID()).beerName("Test").beerStyle(BeerStyleEnum.ALE).build();
		HttpHeaders h =new HttpHeaders();
		h.add("location", "/api/v1/beer/"+beer.getId());
		
		return new ResponseEntity<>(h,HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{id}")
	public void updateBeerById(@PathVariable("id") UUID id,@RequestBody BeerDto beer) {
		System.out.println("Updated the Beer "+id.toString());
	}

}
